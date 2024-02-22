package dev.vulcanium.event.player;

import dev.vulcanium.ClientOption;
import dev.vulcanium.SkinParts;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.MainHand;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class PlayerClientOptionsChangeEvent extends PlayerEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final String locale;
    private final int viewDistance;
    private final ClientOption.ChatVisibility chatVisibility;
    private final boolean chatColors;
    private final SkinParts skinparts;
    private final MainHand mainHand;
    private final boolean allowsServerListings;
    private final boolean textFilteringEnabled;

    /** @deprecated */
    @Deprecated
    public PlayerClientOptionsChangeEvent(@NotNull Player player, @NotNull String locale, int viewDistance, @NotNull ClientOption.ChatVisibility chatVisibility, boolean chatColors, @NotNull SkinParts skinParts, @NotNull MainHand mainHand) {
        super(player);
        this.locale = locale;
        this.viewDistance = viewDistance;
        this.chatVisibility = chatVisibility;
        this.chatColors = chatColors;
        this.skinparts = skinParts;
        this.mainHand = mainHand;
        this.allowsServerListings = false;
        this.textFilteringEnabled = false;
    }

    @Internal
    public PlayerClientOptionsChangeEvent(@NotNull Player player, @NotNull Map<ClientOption<?>, ?> options) {
        super(player);
        this.locale = (String)options.get(ClientOption.LOCALE);
        this.viewDistance = (Integer)options.get(ClientOption.VIEW_DISTANCE);
        this.chatVisibility = (ClientOption.ChatVisibility)options.get(ClientOption.CHAT_VISIBILITY);
        this.chatColors = (Boolean)options.get(ClientOption.CHAT_COLORS_ENABLED);
        this.skinparts = (SkinParts)options.get(ClientOption.SKIN_PARTS);
        this.mainHand = (MainHand)options.get(ClientOption.MAIN_HAND);
        this.allowsServerListings = (Boolean)options.get(ClientOption.ALLOW_SERVER_LISTINGS);
        this.textFilteringEnabled = (Boolean)options.get(ClientOption.TEXT_FILTERING_ENABLED);
    }

    public @NotNull String getLocale() {
        return this.locale;
    }

    public boolean hasLocaleChanged() {
        return !this.locale.equals(this.player.getClientOption(ClientOption.LOCALE));
    }

    public int getViewDistance() {
        return this.viewDistance;
    }

    public boolean hasViewDistanceChanged() {
        return this.viewDistance != (Integer)this.player.getClientOption(ClientOption.VIEW_DISTANCE);
    }

    @NotNull
    public ClientOption. ChatVisibility getChatVisibility() {
        return this.chatVisibility;
    }

    public boolean hasChatVisibilityChanged() {
        return this.chatVisibility != this.player.getClientOption(ClientOption.CHAT_VISIBILITY);
    }

    public boolean hasChatColorsEnabled() {
        return this.chatColors;
    }

    public boolean hasChatColorsEnabledChanged() {
        return this.chatColors != (Boolean)this.player.getClientOption(ClientOption.CHAT_COLORS_ENABLED);
    }

    public @NotNull SkinParts getSkinParts() {
        return this.skinparts;
    }

    public boolean hasSkinPartsChanged() {
        return this.skinparts.getRaw() != ((SkinParts)this.player.getClientOption(ClientOption.SKIN_PARTS)).getRaw();
    }

    public @NotNull MainHand getMainHand() {
        return this.mainHand;
    }

    public boolean hasMainHandChanged() {
        return this.mainHand != this.player.getClientOption(ClientOption.MAIN_HAND);
    }

    public boolean allowsServerListings() {
        return this.allowsServerListings;
    }

    public boolean hasAllowServerListingsChanged() {
        return this.allowsServerListings != (Boolean)this.player.getClientOption(ClientOption.ALLOW_SERVER_LISTINGS);
    }

    public boolean hasTextFilteringEnabled() {
        return this.textFilteringEnabled;
    }

    public boolean hasTextFilteringChanged() {
        return this.textFilteringEnabled != (Boolean)this.player.getClientOption(ClientOption.TEXT_FILTERING_ENABLED);
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
