package org.vulcanium.plugin;

import static org.vulcanium.support.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.vulcanium.Bukkit;
import org.vulcanium.event.Event;
import org.vulcanium.event.TestEvent;
import org.vulcanium.permissions.Permission;
import org.vulcanium.support.AbstractTestingBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class PluginManagerTest extends AbstractTestingBase {
    private class MutableObject {
        volatile Object value = null;
    }

    private static final PluginManager pm = Bukkit.getServer().getPluginManager();

    private final MutableObject store = new MutableObject();

    @Test
    public void testAsyncSameThread() {
        final Event event = new TestEvent(true);
        try {
            pm.callEvent(event);
        } catch (IllegalStateException ex) {
            assertThat(event.getEventName() + " cannot be triggered asynchronously from primary server thread.", is(ex.getMessage()));
            return;
        }
        throw new IllegalStateException("No exception thrown");
    }

    @Test
    public void testSyncSameThread() {
        final Event event = new TestEvent(false);
        pm.callEvent(event);
    }

    @Test
    public void testAsyncLocked() throws InterruptedException {
        final Event event = new TestEvent(true);
        Thread secondThread = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (pm) {
                            pm.callEvent(event);
                        }
                    } catch (Throwable ex) {
                        store.value = ex;
                    }
                }
            }
        );
        secondThread.start();
        secondThread.join();
        assertThat(store.value, is(instanceOf(IllegalStateException.class)));
        assertThat(event.getEventName() + " cannot be triggered asynchronously from inside synchronized code.", is(((Throwable) store.value).getMessage()));
    }

    @Test
    public void testAsyncUnlocked() throws InterruptedException {
        final Event event = new TestEvent(true);
        Thread secondThread = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    try {
                        pm.callEvent(event);
                    } catch (Throwable ex) {
                        store.value = ex;
                    }
                }
            }
        );
        secondThread.start();
        secondThread.join();
        if (store.value != null) {
            throw new RuntimeException((Throwable) store.value);
        }
    }

    @Test
    public void testSyncUnlocked() throws InterruptedException {
        final Event event = new TestEvent(false);
        Thread secondThread = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    try {
                        pm.callEvent(event);
                    } catch (Throwable ex) {
                        store.value = ex;
                        assertThat(event.getEventName() + " cannot be triggered asynchronously from another thread.", is(ex.getMessage()));
                        return;
                    }
                }
            }
        );
        secondThread.start();
        secondThread.join();
        if (store.value == null) {
            throw new IllegalStateException("No exception thrown");
        }
    }

    @Test
    public void testSyncLocked() throws InterruptedException {
        final Event event = new TestEvent(false);
        Thread secondThread = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (pm) {
                            pm.callEvent(event);
                        }
                    } catch (Throwable ex) {
                        store.value = ex;
                        assertThat(event.getEventName() + " cannot be triggered asynchronously from another thread.", is(ex.getMessage()));
                        return;
                    }
                }
            }
        );
        secondThread.start();
        secondThread.join();
        if (store.value == null) {
            throw new IllegalStateException("No exception thrown");
        }
    }

    @Test
    public void testRemovePermissionByNameLower() {
        this.testRemovePermissionByName("lower");
    }

    @Test
    public void testRemovePermissionByNameUpper() {
        this.testRemovePermissionByName("UPPER");
    }

    @Test
    public void testRemovePermissionByNameCamel() {
        this.testRemovePermissionByName("CaMeL");
    }

    public void testRemovePermissionByPermissionLower() {
        this.testRemovePermissionByPermission("lower");
    }

    @Test
    public void testRemovePermissionByPermissionUpper() {
        this.testRemovePermissionByPermission("UPPER");
    }

    @Test
    public void testRemovePermissionByPermissionCamel() {
        this.testRemovePermissionByPermission("CaMeL");
    }

    private void testRemovePermissionByName(final String name) {
        final Permission perm = new Permission(name);
        pm.addPermission(perm);
        assertThat(pm.getPermission(name), is(perm), "Permission \"" + name + "\" was not added");
        pm.removePermission(name);
        assertThat(pm.getPermission(name), is(nullValue()), "Permission \"" + name + "\" was not removed");
    }

    private void testRemovePermissionByPermission(final String name) {
        final Permission perm = new Permission(name);
        pm.addPermission(perm);
        assertThat(pm.getPermission(name), is(perm), "Permission \"" + name + "\" was not added");
        pm.removePermission(perm);
        assertThat(pm.getPermission(name), is(nullValue()), "Permission \"" + name + "\" was not removed");
    }

    @AfterEach
    public void tearDown() {
        pm.clearPlugins();
        assertThat(pm.getPermissions(), is(empty()));
    }
}
