package dev.vulcanium.potion;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.Color;
import dev.vulcanium.namespaced.NamespacedKey;
import dev.vulcanium.configuration.serialization.ConfigurationSerializable;
import dev.vulcanium.annotation.SerializableAs;
import dev.vulcanium.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Represents a potion effect, that can be added to a {@link LivingEntity}.
 * A potion effect has a duration that it will last for, an amplifier that
 * will enhance its effects, and a {@link PotionEffectType}, that represents
 * its effect on an entity.
 */
@SerializableAs("PotionEffect")
public class PotionEffect implements ConfigurationSerializable {
    /**
     * A constant denoting infinite potion duration.
     */
    public static final int INFINITE_DURATION = -1;

    private static final String AMPLIFIER = "amplifier";
    private static final String DURATION = "duration";
    private static final String TYPE = "effect";
    private static final String AMBIENT = "ambient";
    private static final String PARTICLES = "has-particles";
    private static final String ICON = "has-icon";

    private final int amplifier;
    private final int duration;
    private final PotionEffectType type;
    private final boolean ambient;
    private final boolean particles;
    private final boolean icon;

    public PotionEffect(@NotNull PotionEffectType type, int duration, int amplifier, boolean ambient, boolean particles, boolean icon) {
        Preconditions.checkArgument(type != null, "effect type cannot be null");
        this.type = type;
        this.duration = duration;
        this.amplifier = amplifier;
        this.ambient = ambient;
        this.particles = particles;
        this.icon = icon;
    }

    public PotionEffect(@NotNull PotionEffectType type, int duration, int amplifier, boolean ambient, boolean particles) {
        this(type, duration, amplifier, ambient, particles, particles);
    }

    public PotionEffect(@NotNull PotionEffectType type, int duration, int amplifier, boolean ambient) {
        this(type, duration, amplifier, ambient, true);
    }

    public PotionEffect(@NotNull PotionEffectType type, int duration, int amplifier) {
        this(type, duration, amplifier, true);
    }

    public PotionEffect(@NotNull Map<String, Object> map) {
        this(getEffectType(map), getInt(map, DURATION), getInt(map, AMPLIFIER),
                getBool(map, AMBIENT, false), getBool(map, PARTICLES, true),
                getBool(map, ICON, getBool(map, PARTICLES, true)));
    }

    @NotNull
    private static PotionEffectType getEffectType(@NotNull Map<?, ?> map) {
        Object type = map.get(TYPE);
        if (type instanceof String) {
            return PotionEffectType.getByKey(NamespacedKey.fromString((String) type));
        } else if (type instanceof Integer) {
            return PotionEffectType.getById((Integer) type);
        } else {
            throw new NoSuchElementException(map + " does not contain " + TYPE);
        }
    }

    private static int getInt(@NotNull Map<?, ?> map, @NotNull Object key) {
        Object num = map.get(key);
        if (num instanceof Integer) {
            return (Integer) num;
        } else {
            throw new NoSuchElementException(map + " does not contain " + key);
        }
    }

    private static boolean getBool(@NotNull Map<?, ?> map, @NotNull Object key, boolean def) {
        Object bool = map.get(key);
        return bool instanceof Boolean ? (Boolean) bool : def;
    }

    @Override
    @NotNull
    public Map<String, Object> serialize() {
        Map<String, Object> serializedMap = Map.of(
                TYPE, type.getKey().toString(),
                DURATION, duration,
                AMPLIFIER, amplifier,
                AMBIENT, ambient,
                PARTICLES, particles,
                ICON, icon
        );
        return serializedMap;
    }

    public boolean apply(@NotNull LivingEntity entity) {
        return entity.addPotionEffect(this);
    }

    public int getAmplifier() {
        return amplifier;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isInfinite() {
        return duration == INFINITE_DURATION;
    }

    public boolean isShorterThan(@NotNull PotionEffect other) {
        return !isInfinite() && (duration < other.duration || other.isInfinite());
    }

    @NotNull
    public PotionEffectType getType() {
        return type;
    }

    public boolean isAmbient() {
        return ambient;
    }

    public boolean hasParticles() {
        return particles;
    }

    @Deprecated
    @Nullable
    public Color getColor() {
        return null;
    }

    public boolean hasIcon() {
        return icon;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + type.hashCode();
        hash = hash * 31 + amplifier;
        hash = hash * 31 + duration;
        hash ^= 0x22222222 >> (ambient ? 1 : -1);
        hash ^= 0x22222222 >> (particles ? 1 : -1);
        hash ^= 0x22222222 >> (icon ? 1 : -1);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PotionEffect)) {
            return false;
        }
        PotionEffect that = (PotionEffect) obj;
        return this.type.equals(that.type) && this.ambient == that.ambient &&
                this.amplifier == that.amplifier && this.duration == that.duration &&
                this.particles == that.particles && this.icon == that.icon;
    }

    @Override
    public String toString() {
        return type.getName() + (ambient ? ":(" : ":") + duration + "t-x" + amplifier + (ambient ? ")" : "");
    }
}