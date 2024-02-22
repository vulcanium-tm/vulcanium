package dev.vulcanium.inventory.meta;

public interface ArmorStandMeta extends ItemMeta {
    boolean isInvisible();

    boolean hasNoBasePlate();

    boolean shouldShowArms();

    boolean isSmall();

    boolean isMarker();

    void setInvisible(boolean var1);

    void setNoBasePlate(boolean var1);

    void setShowArms(boolean var1);

    void setSmall(boolean var1);

    void setMarker(boolean var1);
}
