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
