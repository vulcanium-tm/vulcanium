package dev.vulcanium.brigadier;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.suggestion.SuggestionProvider;

import java.util.function.Predicate;

public interface BrigadierCommand<S extends BrigadierCommandSource> extends Command<S>, Predicate<S>, SuggestionProvider<S> {
}
