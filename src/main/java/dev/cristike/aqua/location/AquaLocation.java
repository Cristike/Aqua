/*
 *   Copyright (c) 2023 Cristike
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *   SOFTWARE.
 */

package dev.cristike.aqua.location;

import dev.cristike.aqua.number.AquaMath;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class AquaLocation {

    /**
     * Gets the world with the given name.
     *
     * @param name the world's name
     * @return an optional that may contain the world
     * */
    public static Optional<World> getWorld(@NotNull String name) {
        return Optional.ofNullable(Bukkit.getWorld(name));
    }

    /**
     * Gets the location from the given coordinates.
     *
     * @param world the location's world name
     * @param x the location's x coordinate
     * @param y the location's y coordinate
     * @param z the location's z coordinate
     *
     * @return an optional that may contain the location
     * */
    public static Optional<Location> getLocation(@NotNull String world, double x, double y, double z) {
        return getWorld(world).map(value -> new Location(value, x, y, z));
    }

    /**
     * Gets the location from the given coordinates.
     *
     * @param world the location's world name
     * @param x the location's x coordinate
     * @param y the location's y coordinate
     * @param z the location's z coordinate
     * @param yaw the location's yaw
     * @param pitch the location's pitch
     *
     * @return an optional that may contain the location
     * */
    public static Optional<Location> getLocation(@NotNull String world, double x, double y, double z, float yaw, float pitch) {
        return getWorld(world).map(value -> new Location(value, x, y, z, yaw, pitch));
    }

    /**
     * Gets the location from the given string coordinates.
     *
     * @param world the location's world name
     * @param x the location's x coordinate
     * @param y the location's y coordinate
     * @param z the location's z coordinate
     *
     * @return an optional that may contain the location
     * */
    public static Optional<Location> getLocation(@NotNull String world, @NotNull String x, @NotNull String y, @NotNull String z) {
        Optional<Double> oX = AquaMath.parseDouble(x);
        Optional<Double> oY = AquaMath.parseDouble(y);
        Optional<Double> oZ = AquaMath.parseDouble(z);

        if (oX.isEmpty() || oY.isEmpty() || oZ.isEmpty()) return Optional.empty();

        return getWorld(world).map(value -> new Location(value, oX.get(), oY.get(), oZ.get()));
    }
}
