package dev.vulcanium.entity.minecart;

import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.IronGolem;
import dev.vulcanium.entity.LivingEntity;
import dev.vulcanium.entity.Minecart;

/**
 * Represents a minecart that can have certain {@link
 * Entity entities} as passengers. Normal passengers
 * include all {@link LivingEntity living entities} with
 * the exception of {@link IronGolem iron golems}.
 * Non-player entities that meet normal passenger criteria automatically
 * mount these minecarts when close enough.
 */
public interface RideableMinecart extends Minecart {
}
