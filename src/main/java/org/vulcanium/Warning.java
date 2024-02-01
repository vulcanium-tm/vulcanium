package org.vulcanium;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Warning {

    public enum WarningState {
        ON,
        OFF,
        DEFAULT;

        private static final Map<String, WarningState> values = initValues();

        private static Map<String, WarningState> initValues() {
            Map<String, WarningState> map = new HashMap<>();
            for (WarningState state : WarningState.values()) {
                map.put(state.name().toLowerCase(), state);
            }
            return map;
        }

        public boolean printFor(@Nullable Warning warning) {
            return this == ON || (this == DEFAULT && (warning == null || warning.value()));
        }

        @NotNull
        public static WarningState value(@Nullable final String value) {
            return values.getOrDefault(value.toLowerCase(), DEFAULT);
        }
    }

    boolean value() default false;

    String reason() default "";
}
