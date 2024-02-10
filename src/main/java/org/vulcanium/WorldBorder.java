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
package org.vulcanium;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.TimeUnit;

public interface WorldBorder {

    @Nullable
    World getWorld();

    void reset();

    double getSize();

    void setSize(double newSize);

    void setSize(double newSize, long seconds);

    void setSize(double newSize, @NotNull TimeUnit unit, long time);

    @NotNull
    Location getCenter();

    void setCenter(double x, double z);

    void setCenter(@NotNull Location location);

    double getDamageBuffer();

    void setDamageBuffer(double blocks);

    double getDamageAmount();

    void setDamageAmount(double damage);

    int getWarningTime();

    void setWarningTime(int seconds);

    int getWarningDistance();

    void setWarningDistance(int distance);

    boolean isInside(@NotNull Location location);

    double getMaxSize();

    double getMaxCenterCoordinate();
}
