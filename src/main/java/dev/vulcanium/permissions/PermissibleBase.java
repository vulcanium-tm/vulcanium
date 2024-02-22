package dev.vulcanium.permissions;

import dev.vulcanium.Vulcanium;
import dev.vulcanium.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Base Permissible for use in any Permissible object via proxy or extension
 */
public class PermissibleBase implements Permissible {
    private final ServerOperator opable;
    private final Permissible parent;
    private final List<PermissionAttachment> attachments = new ArrayList<>();
    private final Map<String, PermissionAttachmentInfo> permissions = new HashMap<>();

    public PermissibleBase(@Nullable ServerOperator opable) {
        this.opable = opable;
        this.parent = (opable instanceof Permissible) ? (Permissible) opable : this;

        recalculatePermissions();
    }

    @Override
    public boolean isOp() {
        return opable != null && opable.isOp();
    }

    @Override
    public void setOp(boolean value) {
        if (opable == null) {
            throw new UnsupportedOperationException("Cannot change op value as no ServerOperator is set");
        }
        opable.setOp(value);
    }

    @Override
    public boolean isPermissionSet(@NotNull String name) {
        return permissions.containsKey(name.toLowerCase(Locale.ENGLISH));
    }

    @Override
    public boolean isPermissionSet(@NotNull Permission perm) {
        return isPermissionSet(perm.getName());
    }

    @Override
    public boolean hasPermission(@NotNull String inName) {
        String name = inName.toLowerCase(Locale.ENGLISH);
        if (isPermissionSet(name)) {
            return permissions.get(name).getValue();
        } else {
            Permission perm = Vulcanium.getServer().getPluginManager().getPermission(name);
            return (perm != null) ? perm.getDefault().getValue(isOp()) : Permission.DEFAULT_PERMISSION.getValue(isOp());
        }
    }

    @Override
    public boolean hasPermission(@NotNull Permission perm) {
        return hasPermission(perm.getName());
    }
    @NotNull
    public PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value) {
        PermissionAttachment attachment = addAttachment(plugin);
        attachment.setPermission(name, value);
        return attachment;
    }

    @NotNull
    public PermissionAttachment addAttachment(@NotNull Plugin plugin) {
        PermissionAttachment attachment = new PermissionAttachment(plugin, parent);
        attachments.add(attachment);
        recalculatePermissions();
        return attachment;
    }

    @Override
    public void removeAttachment(@NotNull PermissionAttachment attachment) {
        if (attachments.remove(attachment)) {
            attachment.remove();
            recalculatePermissions();
        } else {
            throw new IllegalArgumentException("Given attachment is not part of Permissible object " + parent);
        }
    }

    @Override
    public void recalculatePermissions() {
        clearPermissions();
        Set<Permission> defaults = Vulcanium.getServer().getPluginManager().getDefaultPermissions(isOp());
        Vulcanium.getServer().getPluginManager().subscribeToDefaultPerms(isOp(), parent);
        for (Permission perm : defaults) {
            String name = perm.getName().toLowerCase(Locale.ENGLISH);
            permissions.put(name, new PermissionAttachmentInfo(parent, name, null, true));
            Vulcanium.getServer().getPluginManager().subscribeToPermission(name, parent);
            calculateChildPermissions(perm.getChildren(), false, null);
        }
        attachments.forEach(attachment -> calculateChildPermissions(attachment.getPermissions(), false, attachment));
    }

    public synchronized void clearPermissions() {
        permissions.keySet().forEach(name -> Vulcanium.getServer().getPluginManager().unsubscribeFromPermission(name, parent));
        Vulcanium.getServer().getPluginManager().unsubscribeFromDefaultPerms(false, parent);
        Vulcanium.getServer().getPluginManager().unsubscribeFromDefaultPerms(true, parent);
        permissions.clear();
    }

    private void calculateChildPermissions(@NotNull Map<String, Boolean> children, boolean invert, @Nullable PermissionAttachment attachment) {
        children.forEach((name, value) -> {
            String lname = name.toLowerCase(Locale.ENGLISH);
            boolean permissionValue = value ^ invert;
            permissions.put(lname, new PermissionAttachmentInfo(parent, lname, attachment, permissionValue));
            Vulcanium.getServer().getPluginManager().subscribeToPermission(name, parent);
            Permission perm = Vulcanium.getServer().getPluginManager().getPermission(name);
            if (perm != null) {
                calculateChildPermissions(perm.getChildren(), !permissionValue, attachment);
            }
        });
    }

    @Nullable
    public PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value, int ticks) {
        PermissionAttachment attachment = addAttachment(plugin, ticks);
        if (attachment != null) {
            attachment.setPermission(name, value);
        }
        return attachment;
    }

    @Nullable
    public PermissionAttachment addAttachment(@NotNull Plugin plugin, int ticks) {
        PermissionAttachment attachment = addAttachment(plugin);
        if (attachment != null) {
            Vulcanium.getServer().getScheduler().scheduleSyncDelayedTask(plugin, attachment::remove, ticks);
        }
        return attachment;
    }

    @Override
    @NotNull
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return new HashSet<>(permissions.values());
    }
}
