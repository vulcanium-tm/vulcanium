package dev.vulcanium.brigadier;

import org.jetbrains.annotations.Nullable;
import dev.vulcanium.Location;
import dev.vulcanium.world.World;
import dev.vulcanium.command.CommandSender;
import dev.vulcanium.entity.Entity;

public interface BrigadierCommandSource {
    @Nullable Entity getVulcaniumEntity();

    @Nullable World getVulcaniumWorld();

    @Nullable Location getVulcaniumLocation();

    CommandSender getVulcaniumSender();
}
