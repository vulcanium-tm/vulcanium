package dev.vulcanium.profile;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ProfileProperty {
    private final String name;
    private final String value;
    private final String signature;

    public ProfileProperty(@NotNull String name, @NotNull String value) {
        this(name, value, (String)null);
    }

    public ProfileProperty(@NotNull String name, @NotNull String value, @Nullable String signature) {
        this.name = (String)Preconditions.checkNotNull(name, "ProfileProperty name can not be null");
        this.value = (String)Preconditions.checkNotNull(value, "ProfileProperty value can not be null");
        this.signature = signature;
    }

    public @NotNull String getName() {
        return this.name;
    }

    public @NotNull String getValue() {
        return this.value;
    }

    public @Nullable String getSignature() {
        return this.signature;
    }

    public boolean isSigned() {
        return this.signature != null;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ProfileProperty that = (ProfileProperty)o;
            return Objects.equals(this.name, that.name) && Objects.equals(this.value, that.value) && Objects.equals(this.signature, that.signature);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }
}
