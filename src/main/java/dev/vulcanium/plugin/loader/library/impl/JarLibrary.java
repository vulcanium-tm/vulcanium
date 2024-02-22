package dev.vulcanium.plugin.loader.library.impl;

import dev.vulcanium.plugin.loader.library.ClassPathLibrary;
import dev.vulcanium.plugin.loader.library.LibraryLoadingException;
import dev.vulcanium.plugin.loader.library.LibraryStore;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

public class JarLibrary implements ClassPathLibrary {
    private final Path path;

    public JarLibrary(@NotNull Path path) {
        this.path = path;
    }

    public void register(@NotNull LibraryStore store) throws LibraryLoadingException {
        if (Files.notExists(this.path, new LinkOption[0])) {
            throw new LibraryLoadingException("Could not find library at " + this.path);
        } else {
            store.addLibrary(this.path);
        }
    }
}
