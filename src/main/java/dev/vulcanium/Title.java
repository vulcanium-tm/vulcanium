package dev.vulcanium;

import com.google.common.base.Preconditions;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.entity.Player;

import java.util.Collection;
import java.util.Iterator;

/** @deprecated */
@Deprecated
public final class Title {
    public static final int DEFAULT_FADE_IN = 20;
    public static final int DEFAULT_STAY = 200;
    public static final int DEFAULT_FADE_OUT = 20;
    private final BaseComponent[] title;
    private final BaseComponent[] subtitle;
    private final int fadeIn;
    private final int stay;
    private final int fadeOut;

    public Title(@NotNull BaseComponent title) {
        this((BaseComponent)title, (BaseComponent)null);
    }

    public Title(@NotNull BaseComponent[] title) {
        this((BaseComponent[])title, (BaseComponent[])null);
    }

    public Title(@NotNull String title) {
        this((String)title, (String)null);
    }

    public Title(@NotNull BaseComponent title, @Nullable BaseComponent subtitle) {
        this((BaseComponent)title, (BaseComponent)subtitle, 20, 200, 20);
    }

    public Title(@NotNull BaseComponent[] title, @Nullable BaseComponent[] subtitle) {
        this((BaseComponent[])title, (BaseComponent[])subtitle, 20, 200, 20);
    }

    public Title(@NotNull String title, @Nullable String subtitle) {
        this((String)title, (String)subtitle, 20, 200, 20);
    }

    public Title(@NotNull BaseComponent title, @Nullable BaseComponent subtitle, int fadeIn, int stay, int fadeOut) {
        this(new BaseComponent[]{(BaseComponent)Preconditions.checkNotNull(title, "title")}, subtitle == null ? null : new BaseComponent[]{subtitle}, fadeIn, stay, fadeOut);
    }

    public Title(@Nullable BaseComponent[] title, @NotNull BaseComponent[] subtitle, int fadeIn, int stay, int fadeOut) {
        Preconditions.checkArgument(fadeIn >= 0, "Negative fadeIn: %s", fadeIn);
        Preconditions.checkArgument(stay >= 0, "Negative stay: %s", stay);
        Preconditions.checkArgument(fadeOut >= 0, "Negative fadeOut: %s", fadeOut);
        this.title = (BaseComponent[])Preconditions.checkNotNull(title, "title");
        this.subtitle = subtitle;
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    public Title(@NotNull String title, @Nullable String subtitle, int fadeIn, int stay, int fadeOut) {
        this(TextComponent.fromLegacyText((String)Preconditions.checkNotNull(title, "title")), subtitle == null ? null : TextComponent.fromLegacyText(subtitle), fadeIn, stay, fadeOut);
    }

    public @NotNull BaseComponent[] getTitle() {
        return this.title;
    }

    public @Nullable BaseComponent[] getSubtitle() {
        return this.subtitle;
    }

    public int getFadeIn() {
        return this.fadeIn;
    }

    public int getStay() {
        return this.stay;
    }

    public int getFadeOut() {
        return this.fadeOut;
    }

    public void send(@NotNull Player player) {
        player.sendTitle(this);
    }

    public void send(@NotNull Collection<? extends Player> players) {
        Iterator var2 = players.iterator();

        while(var2.hasNext()) {
            Player player = (Player)var2.next();
            player.sendTitle(this);
        }

    }

    public void send(@NotNull Player[] players) {
        Player[] var2 = players;
        int var3 = players.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Player player = var2[var4];
            player.sendTitle(this);
        }

    }

    public void broadcast() {
        this.send(Vulcanium.getOnlinePlayers());
    }

    public static @NotNull Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private BaseComponent[] title;
        private BaseComponent[] subtitle;
        private int fadeIn = 20;
        private int stay = 200;
        private int fadeOut = 20;

        public Builder() {
        }

        public @NotNull Builder title(@NotNull BaseComponent title) {
            return this.title(new BaseComponent[]{(BaseComponent)Preconditions.checkNotNull(title, "title")});
        }


        public @NotNull Builder title(@NotNull BaseComponent[] title) {
            this.title = (BaseComponent[])Preconditions.checkNotNull(title, "title");
            return this;
        }
        public @NotNull Builder title(@NotNull String title) {
            return this.title(TextComponent.fromLegacyText((String)Preconditions.checkNotNull(title, "title")));
        }

        public @NotNull Builder subtitle(@Nullable BaseComponent subtitle) {
            return this.subtitle(subtitle == null ? null : new BaseComponent[]{subtitle});
        }

        public @NotNull Builder subtitle(@Nullable BaseComponent[] subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public @NotNull Builder subtitle(@Nullable String subtitle) {
            return this.subtitle(subtitle == null ? null : TextComponent.fromLegacyText(subtitle));
        }

        public @NotNull Builder fadeIn(int fadeIn) {
            Preconditions.checkArgument(fadeIn >= 0, "Negative fadeIn: %s", fadeIn);
            this.fadeIn = fadeIn;
            return this;
        }

        public @NotNull Builder stay(int stay) {
            Preconditions.checkArgument(stay >= 0, "Negative stay: %s", stay);
            this.stay = stay;
            return this;
        }

        public @NotNull Builder fadeOut(int fadeOut) {
            Preconditions.checkArgument(fadeOut >= 0, "Negative fadeOut: %s", fadeOut);
            this.fadeOut = fadeOut;
            return this;
        }

        public @NotNull Title build() {
            Preconditions.checkState(this.title != null, "Title not specified");
            return new Title(this.title, this.subtitle, this.fadeIn, this.stay, this.fadeOut);
        }
    }
}
