package dev.vulcanium.damage;

import com.google.common.base.Preconditions;
import dev.vulcanium.namespaced.*;
import dev.vulcanium.registry.Registry;
import dev.vulcanium.Translatable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;

@Experimental
public interface DamageType extends Keyed, Translatable {
    DamageType IN_FIRE = getDamageType("in_fire");
    DamageType LIGHTNING_BOLT = getDamageType("lightning_bolt");
    DamageType ON_FIRE = getDamageType("on_fire");
    DamageType LAVA = getDamageType("lava");
    DamageType HOT_FLOOR = getDamageType("hot_floor");
    DamageType IN_WALL = getDamageType("in_wall");
    DamageType CRAMMING = getDamageType("cramming");
    DamageType DROWN = getDamageType("drown");
    DamageType STARVE = getDamageType("starve");
    DamageType CACTUS = getDamageType("cactus");
    DamageType FALL = getDamageType("fall");
    DamageType FLY_INTO_WALL = getDamageType("fly_into_wall");
    DamageType OUT_OF_WORLD = getDamageType("out_of_world");
    DamageType GENERIC = getDamageType("generic");
    DamageType MAGIC = getDamageType("magic");
    DamageType WITHER = getDamageType("wither");
    DamageType DRAGON_BREATH = getDamageType("dragon_breath");
    DamageType DRY_OUT = getDamageType("dry_out");
    DamageType SWEET_BERRY_BUSH = getDamageType("sweet_berry_bush");
    DamageType FREEZE = getDamageType("freeze");
    DamageType STALAGMITE = getDamageType("stalagmite");
    DamageType FALLING_BLOCK = getDamageType("falling_block");
    DamageType FALLING_ANVIL = getDamageType("falling_anvil");
    DamageType FALLING_STALACTITE = getDamageType("falling_stalactite");
    DamageType STING = getDamageType("sting");
    DamageType MOB_ATTACK = getDamageType("mob_attack");
    DamageType MOB_ATTACK_NO_AGGRO = getDamageType("mob_attack_no_aggro");
    DamageType PLAYER_ATTACK = getDamageType("player_attack");
    DamageType ARROW = getDamageType("arrow");
    DamageType TRIDENT = getDamageType("trident");
    DamageType MOB_PROJECTILE = getDamageType("mob_projectile");
    DamageType FIREWORKS = getDamageType("fireworks");
    DamageType FIREBALL = getDamageType("fireball");
    DamageType UNATTRIBUTED_FIREBALL = getDamageType("unattributed_fireball");
    DamageType WITHER_SKULL = getDamageType("wither_skull");
    DamageType THROWN = getDamageType("thrown");
    DamageType INDIRECT_MAGIC = getDamageType("indirect_magic");
    DamageType THORNS = getDamageType("thorns");
    DamageType EXPLOSION = getDamageType("explosion");
    DamageType PLAYER_EXPLOSION = getDamageType("player_explosion");
    DamageType SONIC_BOOM = getDamageType("sonic_boom");
    DamageType BAD_RESPAWN_POINT = getDamageType("bad_respawn_point");
    DamageType OUTSIDE_BORDER = getDamageType("outside_border");
    DamageType GENERIC_KILL = getDamageType("generic_kill");

    private static @NotNull DamageType getDamageType(@NotNull String key) {
        NamespacedKey namespacedKey = NamespacedKey.minecraft(key);
        return (DamageType)Preconditions.checkNotNull((DamageType)Registry.DAMAGE_TYPE.get(namespacedKey), "No DamageType found for %s. This is a bug.", namespacedKey);
    }

    @NotNull String getTranslationKey();

    @NotNull DamageScaling getDamageScaling();

    @NotNull DamageEffect getDamageEffect();

    @NotNull DeathMessageType getDeathMessageType();

    float getExhaustion();
}
