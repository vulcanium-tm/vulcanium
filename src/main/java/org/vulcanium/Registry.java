package org.vulcanium;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface Registry<T extends Keyed> extends Iterable<T> {

    Registry<Advancement> ADVANCEMENT = new SimpleRegistry<>(Advancement.class, Vulcanium::getAdvancement, Vulcanium::advancementIterator);
    Registry<Art> ART = new SimpleRegistry<>(Art.class);
    Registry<Attribute> ATTRIBUTE = new SimpleRegistry<>(Attribute.class);
    Registry<PatternType> BANNER_PATTERN = new SimpleRegistry<>(PatternType.class);
    Registry<Biome> BIOME = new SimpleRegistry<>(Biome.class);
    Registry<KeyedBossBar> BOSS_BARS = new SimpleRegistry<>(KeyedBossBar.class, Vulcanium::getBossBar, Vulcanium::getBossBars);
    Registry<Cat.Type> CAT_VARIANT = new SimpleRegistry<>(Cat.Type.class);
    Registry<Enchantment> ENCHANTMENT = new SimpleRegistry<>(Enchantment.class, () -> Objects.requireNonNull(Vulcanium.getRegistry(Enchantment.class)));
    Registry<EntityType> ENTITY_TYPE = new SimpleRegistry<>(EntityType.class, (entity) -> entity != EntityType.UNKNOWN);
    Registry<MusicInstrument> INSTRUMENT = new SimpleRegistry<>(MusicInstrument.class, () -> Objects.requireNonNull(Vulcanium.getRegistry(MusicInstrument.class)));
    Registry<LootTables> LOOT_TABLES = new SimpleRegistry<>(LootTables.class);
    Registry<Material> MATERIAL = new SimpleRegistry<>(Material.class, (mat) -> !mat.isLegacy());
    Registry<PotionEffectType> EFFECT = new SimpleRegistry<>(PotionEffectType.class, () -> Objects.requireNonNull(Vulcanium.getRegistry(PotionEffectType.class)));
    Registry<Particle> PARTICLE_TYPE = new SimpleRegistry<>(Particle.class, (par) -> par.register);
    Registry<PotionType> POTION = new SimpleRegistry<>(PotionType.class);
    Registry<Statistic> STATISTIC = new SimpleRegistry<>(Statistic.class);
    Registry<Structure> STRUCTURE = new SimpleRegistry<>(Structure.class, Vulcanium::getRegistry);
    Registry<StructureType> STRUCTURE_TYPE = new SimpleRegistry<>(StructureType.class, Vulcanium::getRegistry);
    Registry<Sound> SOUNDS = new SimpleRegistry<>(Sound.class);
    Registry<TrimMaterial> TRIM_MATERIAL = new SimpleRegistry<>(TrimMaterial.class, Vulcanium::getRegistry);
    Registry<TrimPattern> TRIM_PATTERN = new SimpleRegistry<>(TrimPattern.class, Vulcanium::getRegistry);
    Registry<Villager.Profession> VILLAGER_PROFESSION = new SimpleRegistry<>(Villager.Profession.class);
    Registry<Villager.Type> VILLAGER_TYPE = new SimpleRegistry<>(Villager.Type.class);
    Registry<MemoryKey> MEMORY_MODULE_TYPE = new SimpleRegistry<>(MemoryKey.class, () -> Iterators.forArray(MemoryKey.values()));
    Registry<Fluid> FLUID = new SimpleRegistry<>(Fluid.class);
    Registry<Frog.Variant> FROG_VARIANT = new SimpleRegistry<>(Frog.Variant.class);
    Registry<GameEvent> GAME_EVENT = new SimpleRegistry<>(GameEvent.class, () -> Objects.requireNonNull(Vulcanium.getRegistry(GameEvent.class)));

    @Nullable
    T get(@NotNull NamespacedKey key);

    @NotNull
    Stream<T> stream();

    @Nullable
    default T match(@NotNull String input) {
        Preconditions.checkArgument(input != null, "input must not be null");

        String filtered = input.toLowerCase().replaceAll("\\s+", "_");
        NamespacedKey namespacedKey = NamespacedKey.fromString(filtered);
        return (namespacedKey != null) ? get(namespacedKey) : null;
    }

    interface Supplier<T> {
        T get();
    }

    interface IterableSupplier<T> extends Supplier<Iterator<T>> {
        @Override
        Iterator<T> get();
    }

    class SimpleRegistry<T extends Enum<T> & Keyed> implements Registry<T> {
        private final Map<NamespacedKey, T> map;

        SimpleRegistry(@NotNull Class<T> type, Supplier<Registry<T>> registrySupplier) {
            this(type, registrySupplier, Iterators::empty);
        }

        SimpleRegistry(@NotNull Class<T> type, Supplier<Registry<T>> registrySupplier, IterableSupplier<T> iteratorSupplier) {
            Objects.requireNonNull(registrySupplier, "Registry supplier must not be null");
            Objects.requireNonNull(iteratorSupplier, "Iterator supplier must not be null");

            this.map = registrySupplier.get().getEntries().stream()
                    .filter(entry -> entry != null && type.isInstance(entry))
                    .map(entry -> (T) entry)
                    .collect(Collectors.toMap(Keyed::getKey, Function.identity()));
        }

        @Nullable
        @Override
        public T get(@NotNull NamespacedKey key) {
            return map.get(key);
        }

        @NotNull
        @Override
        public Stream<T> stream() {
            return map.values().stream();
        }

        @NotNull
        @Override
        public Iterator<T> iterator() {
            return iteratorSupplier.get();
        }
    }
}
