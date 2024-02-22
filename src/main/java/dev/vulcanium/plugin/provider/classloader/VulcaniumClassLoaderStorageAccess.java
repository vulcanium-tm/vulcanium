package dev.vulcanium.plugin.provider.classloader;

import net.kyori.adventure.util.Services;

class VulcaniumClassLoaderStorageAccess {
    static final VulcaniumClassLoaderStorage INSTANCE = (VulcaniumClassLoaderStorage)Services.service(VulcaniumClassLoaderStorage.class).orElseThrow();

    VulcaniumClassLoaderStorageAccess() {
    }
}
