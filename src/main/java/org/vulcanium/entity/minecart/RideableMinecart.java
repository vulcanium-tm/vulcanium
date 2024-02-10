package org.vulcanium.entity.minecart;

import org.vulcanium.entity.Entity;
import org.vulcanium.entity.IronGolem;
import org.vulcanium.entity.LivingEntity;
import org.vulcanium.entity.Minecart;

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
