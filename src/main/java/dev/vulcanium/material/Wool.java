package dev.vulcanium.material;

import dev.vulcanium.DyeColor;
import dev.vulcanium.Material;
import dev.vulcanium.block.data.BlockData;

/**
 * Represents a Wool/Cloth block
 * @deprecated all usage of MaterialData is deprecated and subject to removal.
 * Use {@link BlockData}.
 */
@Deprecated
public class Wool extends MaterialData implements Colorable {
    public Wool() {
        super(Material.LEGACY_WOOL);
    }

    public Wool(DyeColor color) {
        this();
        setColor(color);
    }

    public Wool(final Material type) {
        super(type);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated Magic value
     */
    @Deprecated
    public Wool(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current color of this dye
     *
     * @return DyeColor of this dye
     */
    @Override
    public DyeColor getColor() {
        return DyeColor.getByWoolData(getData());
    }

    /**
     * Sets the color of this dye
     *
     * @param color New color of this dye
     */
    @Override
    public void setColor(DyeColor color) {
        setData(color.getWoolData());
    }

    @Override
    public String toString() {
        return getColor() + " " + super.toString();
    }

    @Override
    public Wool clone() {
        return (Wool) super.clone();
    }
}
