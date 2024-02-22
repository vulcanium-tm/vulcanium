package dev.vulcanium.util.io;

import com.google.common.collect.ImmutableMap;
import dev.vulcanium.configuration.serialization.ConfigurationSerializable;
import dev.vulcanium.configuration.serialization.ConfigurationSerialization;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Map;

final class Wrapper<T extends Map<String, ?> & Serializable> implements Serializable {
    private static final long serialVersionUID = -986209235411767547L;

    final T map;

    static Wrapper<ImmutableMap<String, ?>> newWrapper(@NotNull ConfigurationSerializable obj) {
        return new Wrapper<>(ImmutableMap.<String, Object>builder()
                .put(ConfigurationSerialization.SERIALIZED_TYPE_KEY, ConfigurationSerialization.getAlias(obj.getClass()))
                .putAll(obj.serialize())
                .build());
    }

    private Wrapper(@NotNull T map) {
        this.map = map;
    }
}