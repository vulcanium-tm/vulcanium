/*
 Copyright © 2023

 Owner: Vulcanium

 Contributor: Shadowflare
 ────────────────────────────────────────────────────────────────────
 Permission is hereby granted to use and modify the Vulcanium plugin freely:

 1. Include copyright and permission notice in all copies of the Software.
 2. Users can depend on Vulcanium, create, and distribute plugins that rely on it.
 3. Republishing Vulcanium elsewhere is prohibited.
 4. Source code distribution is not allowed.
 5. Publishing a derivative version of the plugin is prohibited.
 ────────────────────────────────────────────────────────────────────
 SOFTWARE PROVIDED "AS IT IS," NO WARRANTY. AUTHORS NOT LIABLE FOR DAMAGES.
 */
package org.vulcanium;

import com.google.common.base.Preconditions;
import org.vulcanium.command.CommandSender;
import org.vulcanium.generator.BiomeProvider;
import org.vulcanium.generator.ChunkGenerator;
import org.vulcanium.plugin.Plugin;

import java.util.concurrent.ThreadLocalRandom;

public class WorldCreator {

    private final String name;
    private long seed;
    private World.Environment environment = World.Environment.NORMAL;
    private ChunkGenerator generator = null;
    private BiomeProvider biomeProvider = null;
    private WorldType type = WorldType.NORMAL;
    private boolean generateStructures = true;
    private String generatorSettings = "";
    private boolean hardcore = false;
    private boolean keepSpawnInMemory = true;

    public WorldCreator(String name) {
        Preconditions.checkArgument(name != null, "World name cannot be null");
        this.name = name;
        this.seed = ThreadLocalRandom.current().nextLong();
    }

    public WorldCreator copy(World world) {
        seed = world.getSeed();
        environment = world.getEnvironment();
        generator = world.getGenerator();
        biomeProvider = world.getBiomeProvider();
        type = world.getWorldType();
        generateStructures = world.canGenerateStructures();
        hardcore = world.isHardcore();
        keepSpawnInMemory = world.getKeepSpawnInMemory();
        return this;
    }

    public WorldCreator copy(WorldCreator creator) {
        Preconditions.checkArgument(creator != null, "Creator cannot be null");
        seed = creator.seed();
        environment = creator.environment();
        generator = creator.generator();
        biomeProvider = creator.biomeProvider();
        type = creator.type();
        generateStructures = creator.generateStructures();
        generatorSettings = creator.generatorSettings();
        hardcore = creator.hardcore();
        keepSpawnInMemory = creator.keepSpawnInMemory();
        return this;
    }

    public String name() {
        return name;
    }

    public long seed() {
        return seed;
    }

    public WorldCreator seed(long seed) {
        this.seed = seed;
        return this;
    }

    public World.Environment environment() {
        return environment;
    }

    public WorldCreator environment(World.Environment env) {
        this.environment = env;
        return this;
    }

    public WorldType type() {
        return type;
    }

    public WorldCreator type(WorldType type) {
        this.type = type;
        return this;
    }

    public ChunkGenerator generator() {
        return generator;
    }

    public WorldCreator generator(ChunkGenerator generator) {
        this.generator = generator;
        return this;
    }

    public WorldCreator generator(String generator) {
        this.generator = getGeneratorForName(name, generator, null);
        return this;
    }

    public WorldCreator generator(String generator, CommandSender output) {
        this.generator = getGeneratorForName(name, generator, output);
        return this;
    }

    public BiomeProvider biomeProvider() {
        return biomeProvider;
    }

    public WorldCreator biomeProvider(BiomeProvider biomeProvider) {
        this.biomeProvider = biomeProvider;
        return this;
    }

    public WorldCreator biomeProvider(String biomeProvider) {
        this.biomeProvider = getBiomeProviderForName(name, biomeProvider, null);
        return this;
    }

    public WorldCreator biomeProvider(String biomeProvider, CommandSender output) {
        this.biomeProvider = getBiomeProviderForName(name, biomeProvider, output);
        return this;
    }

    public WorldCreator generatorSettings(String generatorSettings) {
        this.generatorSettings = generatorSettings;
        return this;
    }

    public String generatorSettings() {
        return generatorSettings;
    }

    public WorldCreator generateStructures(boolean generate) {
        this.generateStructures = generate;
        return this;
    }

    public boolean generateStructures() {
        return generateStructures;
    }

    public WorldCreator hardcore(boolean hardcore) {
        this.hardcore = hardcore;
        return this;
    }

    public boolean hardcore() {
        return hardcore;
    }

    public WorldCreator keepSpawnInMemory(boolean keepSpawnInMemory) {
        this.keepSpawnInMemory = keepSpawnInMemory;
        return this;
    }

    public boolean keepSpawnInMemory() {
        return keepSpawnInMemory;
    }

    public World createWorld() {
        return Vulcanium.createWorld(this);
    }

    public static WorldCreator name(String name) {
        return new WorldCreator(name);
    }

    public static ChunkGenerator getGeneratorForName(String world, String name, CommandSender output) {
        Preconditions.checkArgument(world != null, "World name must be specified");
        ChunkGenerator result = null;

        if (output == null) {
            output = Vulcanium.getConsoleSender();
        }

        if (name != null) {
            String[] split = name.split(":", 2);
            String id = (split.length > 1) ? split[1] : null;
            Plugin plugin = Vulcanium.getPluginManager().getPlugin(split[0]);

            if (plugin == null) {
                output.sendMessage("Plugin '" + split[0] + "' does not exist");
            } else if (!plugin.isEnabled()) {
                output.sendMessage("Plugin '" + plugin.getDescription().getFullName() + "' is not enabled");
            } else {
                result = plugin.getDefaultWorldGenerator(world, id);
            }
        }

        return result;
    }

    public static BiomeProvider getBiomeProviderForName(String world, String name, CommandSender output) {
        Preconditions.checkArgument(world != null, "World name must be specified");
        BiomeProvider result = null;

        if (output == null) {
            output = Vulcanium.getConsoleSender();
        }

        if (name != null) {
            String[] split = name.split(":", 2);
            String id = (split.length > 1) ? split[1] : null;
            Plugin plugin = Vulcanium.getPluginManager().getPlugin(split[0]);

            if (plugin == null) {
                output.sendMessage("Plugin '" + split[0] + "' does not exist");
            } else if (!plugin.isEnabled()) {
                output.sendMessage("Plugin '" + plugin.getDescription().getFullName() + "' is not enabled");
            } else {
                result = plugin.getDefaultBiomeProvider(world, id);
            }
        }

        return result;
    }
}
