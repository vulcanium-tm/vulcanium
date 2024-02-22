package dev.vulcanium.entity.ai;

import com.google.common.base.Objects;
import java.util.StringJoiner;
import dev.vulcanium.namespaced.NamespacedKey;
import dev.vulcanium.entity.Mob;
import org.jetbrains.annotations.NotNull;

public class GoalKey<T extends Mob> {
    private final Class<T> entityClass;
    private final NamespacedKey namespacedKey;

    private GoalKey(@NotNull Class<T> entityClass, @NotNull NamespacedKey namespacedKey) {
        this.entityClass = entityClass;
        this.namespacedKey = namespacedKey;
    }

    public @NotNull Class<T> getEntityClass() {
        return this.entityClass;
    }

    public @NotNull NamespacedKey getNamespacedKey() {
        return this.namespacedKey;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            GoalKey<?> goalKey = (GoalKey)o;
            return Objects.equal(this.entityClass, goalKey.entityClass) && Objects.equal(this.namespacedKey, goalKey.namespacedKey);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.entityClass, this.namespacedKey});
    }

    public String toString() {
        return (new StringJoiner(", ", GoalKey.class.getSimpleName() + "[", "]")).add("entityClass=" + this.entityClass).add("namespacedKey=" + this.namespacedKey).toString();
    }

    public static <A extends Mob> @NotNull GoalKey<A> of(@NotNull Class<A> entityClass, @NotNull NamespacedKey namespacedKey) {
        return new GoalKey(entityClass, namespacedKey);
    }
}
