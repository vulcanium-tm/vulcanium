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
package org.vulcanium.attribute;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.vulcanium.configuration.serialization.ConfigurationSerializable;
import org.vulcanium.inventory.EquipmentSlot;
import org.vulcanium.util.NumberConversions;

/**
 * Concrete implementation of an attribute modifier.
 */
public class AttributeModifier implements ConfigurationSerializable {

    private final UUID uuid;
    private final String name;
    private final double amount;
    private final Operation operation;
    private final EquipmentSlot slot;

    public AttributeModifier(@NotNull String name, double amount, @NotNull Operation operation) {
        this(UUID.randomUUID(), name, amount, operation);
    }

    public AttributeModifier(@NotNull UUID uuid, @NotNull String name, double amount, @NotNull Operation operation) {
        this(uuid, name, amount, operation, null);
    }

    public AttributeModifier(@NotNull UUID uuid, @NotNull String name, double amount, @NotNull Operation operation, @Nullable EquipmentSlot slot) {
        Objects.requireNonNull(uuid, "UUID cannot be null");
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(operation, "Operation cannot be null");
        this.uuid = uuid;
        this.name = name;
        this.amount = amount;
        this.operation = operation;
        this.slot = slot;
    }

    /**
     * Get the unique ID for this modifier.
     *
     * @return unique id
     */
    @NotNull
    public UUID getUniqueId() {
        return uuid;
    }

    /**
     * Get the name of this modifier.
     *
     * @return name
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Get the amount by which this modifier will apply its {@link Operation}.
     *
     * @return modification amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Get the operation this modifier will apply.
     *
     * @return operation
     */
    @NotNull
    public Operation getOperation() {
        return operation;
    }

    /**
     * Get the {@link EquipmentSlot} this AttributeModifier is active on,
     * or null if this modifier is applicable for any slot.
     *
     * @return the slot
     */
    @Nullable
    public EquipmentSlot getSlot() {
        return slot;
    }

    @NotNull
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<>();
        data.put("uuid", uuid.toString());
        data.put("name", name);
        data.put("operation", operation.ordinal());
        data.put("amount", amount);
        if (slot != null) {
            data.put("slot", slot.name());
        }
        return data;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof AttributeModifier)) {
            return false;
        }
        AttributeModifier mod = (AttributeModifier) other;
        boolean slots = (this.slot != null ? (this.slot == mod.slot) : mod.slot == null);
        return this.uuid.equals(mod.uuid) && this.name.equals(mod.name) && this.amount == mod.amount && this.operation == mod.operation && slots;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + uuid.hashCode();
        hash = 17 * hash + name.hashCode();
        hash = 17 * hash + Double.hashCode(amount);
        hash = 17 * hash + operation.hashCode();
        hash = 17 * hash + Objects.hashCode(slot);
        return hash;
    }

    @Override
    public String toString() {
        return "AttributeModifier{" +
                "uuid=" + uuid.toString() +
                ", name=" + name +
                ", operation=" + operation.name() +
                ", amount=" + amount +
                ", slot=" + (slot != null ? slot.name() : "") +
                "}";
    }

    @NotNull
    public static AttributeModifier deserialize(@NotNull Map<String, Object> args) {
        UUID uuid = UUID.fromString((String) args.get("uuid"));
        String name = (String) args.get("name");
        double amount = NumberConversions.toDouble(args.get("amount"));
        Operation operation = Operation.values()[NumberConversions.toInt(args.get("operation"))];
        EquipmentSlot slot = args.containsKey("slot") ? EquipmentSlot.valueOf(((String) args.get("slot")).toUpperCase()) : null;
        return new AttributeModifier(uuid, name, amount, operation, slot);
    }

    /**
     * Enumerable operation to be applied.
     */
    public enum Operation {
        /**
         * Adds (or subtracts) the specified amount to the base value.
         */
        ADD_NUMBER,
        /**
         * Adds this scalar of amount to the base value.
         */
        ADD_SCALAR,
        /**
         * Multiply amount by this value, after adding 1 to it.
         */
        MULTIPLY_SCALAR_1;
    }
}
