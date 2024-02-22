package dev.vulcanium.potion;

import com.google.common.base.Preconditions;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * @deprecated Upgraded / extended potions are now their own {@link PotionType} use them instead.
 */
@Deprecated
public final class PotionData {

    private final PotionType type;
    /**
     * -- GETTER --
     *  Checks if the potion is in an extended state. This refers to the extended duration potions.
     *
     */
    @Getter
    private final boolean extended;
    /**
     * -- GETTER --
     *  Checks if the potion is in an upgraded state. This refers to whether or not the potion is Tier 2.
     *
     */
    @Getter
    private final boolean upgraded;

    /**
     * Instantiates a final PotionData object to contain information about a Potion.
     *
     * @param type     the type of the Potion
     * @param extended whether the potion is extended (PotionType#isExtendable() must be true)
     * @param upgraded whether the potion is upgraded (PotionType#isUpgradable() must be true)
     */
    public PotionData(@NotNull PotionType type, boolean extended, boolean upgraded) {
        validatePotionData(type, extended, upgraded);
        this.type = type;
        this.extended = extended;
        this.upgraded = upgraded;
    }

    /**
     * Convenience constructor for a non-extended and non-upgraded potion.
     *
     * @param type the type of the Potion
     */
    public PotionData(@NotNull PotionType type) {
        this(type, false, false);
    }

    /**
     * Validate potion data based on the provided parameters.
     *
     * @param type     the type of the Potion
     * @param extended whether the potion is extended
     * @param upgraded whether the potion is upgraded
     */
    private void validatePotionData(@NotNull PotionType type, boolean extended, boolean upgraded) {
        Preconditions.checkArgument(type != null, "Potion Type must not be null");
        Preconditions.checkArgument(!upgraded || type.isUpgradeable(), "Potion Type is not upgradable");
        Preconditions.checkArgument(!extended || type.isExtendable(), "Potion Type is not extendable");
        Preconditions.checkArgument(!upgraded || !extended, "Potion cannot be both extended and upgraded");
        Preconditions.checkArgument(!type.getKey().getKey().startsWith("strong_"),
                "Strong potion type cannot be used directly, got %s", type.getKey());
        Preconditions.checkArgument(!type.getKey().getKey().startsWith("long_"),
                "Extended potion type cannot be used directly, got %s", type.getKey());
    }

    /**
     * Gets the type of the potion, Type matches up with each kind of craftable potion.
     *
     * @return the potion type
     */
    @NotNull
    public PotionType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (type != null ? type.hashCode() : 0);
        hash = 23 * hash + (extended ? 1 : 0);
        hash = 23 * hash + (upgraded ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PotionData other = (PotionData) obj;
        return upgraded == other.upgraded && extended == other.extended && type == other.type;
    }
}