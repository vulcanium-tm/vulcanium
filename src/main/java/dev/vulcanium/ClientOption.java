package dev.vulcanium;

import net.kyori.adventure.translation.Translatable;
import net.kyori.adventure.util.Index;
import dev.vulcanium.inventory.MainHand;
import org.jetbrains.annotations.NotNull;

public final class ClientOption<T> {
    public static final ClientOption<SkinParts> SKIN_PARTS = new ClientOption(SkinParts.class);
    public static final ClientOption<Boolean> CHAT_COLORS_ENABLED = new ClientOption(Boolean.class);
    public static final ClientOption<ChatVisibility> CHAT_VISIBILITY = new ClientOption(ChatVisibility.class);
    public static final ClientOption<String> LOCALE = new ClientOption(String.class);
    public static final ClientOption<MainHand> MAIN_HAND = new ClientOption(MainHand.class);
    public static final ClientOption<Integer> VIEW_DISTANCE = new ClientOption(Integer.class);
    public static final ClientOption<Boolean> ALLOW_SERVER_LISTINGS = new ClientOption(Boolean.class);
    public static final ClientOption<Boolean> TEXT_FILTERING_ENABLED = new ClientOption(Boolean.class);
    private final Class<T> type;

    private ClientOption(@NotNull Class<T> type) {
        this.type = type;
    }

    public @NotNull Class<T> getType() {
        return this.type;
    }

    public static enum ChatVisibility implements Translatable {
        FULL("full"),
        SYSTEM("system"),
        HIDDEN("hidden"),
        UNKNOWN("unknown");

        public static Index<String, ChatVisibility> NAMES = Index.create(ChatVisibility.class, (chatVisibility) -> {
            return chatVisibility.name;
        });
        private final String name;

        private ChatVisibility(String name) {
            this.name = name;
        }

        public @NotNull String translationKey() {
            if (this == UNKNOWN) {
                throw new UnsupportedOperationException(this.name + " doesn't have a translation key");
            } else {
                return "options.chat.visibility." + this.name;
            }
        }
    }
}
