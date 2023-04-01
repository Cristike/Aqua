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

package dev.cristike.aqua.particle;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;

public class AquaParticle {

    /**
     * Spawns a particle at the target location.
     *
     * @param particle the type of particle
     * @param location the location
     * */
    public static void spawnParticle(@NotNull Particle particle, @NotNull Location location) {
        if (location.getWorld() == null) return;
        location.getWorld().spawnParticle(particle, location, 1);
    }

    /**
     * Spawns a given amount of particles at the target location.
     *
     * @param particle the type of particle
     * @param location the location
     * @param count the amount of particles
     * */
    public static void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count) {
        if (location.getWorld() == null) return;
        location.getWorld().spawnParticle(particle, location, count);
    }

    /**
     * Spawns a given amount of particles at the target location.
     * The position of the particles will be randomized based on
     * the offsets of each axis.
     *
     * @param particle the type of particle
     * @param location the location
     * @param count the amount of particles
     * @param offsetX the offset for the X axis
     * @param offsetY the offset for the Y axis
     * @param offsetZ the offset for the Z axis
     * */
    public static void spawnParticle(@NotNull Particle particle,
                                     @NotNull Location location,
                                     int count,
                                     double offsetX,
                                     double offsetY,
                                     double offsetZ) {
        if (location.getWorld() == null) return;
        location.getWorld().spawnParticle(particle, location, count, offsetX, offsetY, offsetZ);
    }

    /**
     * Spawns a colored particle at the target location.
     *
     * @param location the location
     * @param color the color of the particle
     * */
    public static void spawnColoredParticle(@NotNull Location location, @NotNull Color color) {
        if (location.getWorld() == null) return;
        location.getWorld().spawnParticle(Particle.REDSTONE, location, 1,
                new Particle.DustOptions(color, 1));
    }

    /**
     * Spawns a colored particle of a specific size at the target location.
     *
     * @param location the location
     * @param color the color of the particle
     * @param size the particle size
     * */
    public static void spawnColoredParticle(@NotNull Location location, @NotNull Color color, float size) {
        if (location.getWorld() == null) return;
        location.getWorld().spawnParticle(Particle.REDSTONE, location, 1,
                new Particle.DustOptions(color, size));
    }

    /**
     * Spawns a given amount of colored particles at the target location.
     *
     * @param location the location
     * @param count the amount of particles
     * @param color the color of the particles
     * */
    public static void spawnColoredParticle(@NotNull Location location, int count, @NotNull Color color) {
        if (location.getWorld() == null) return;
        location.getWorld().spawnParticle(Particle.REDSTONE, location, count,
                new Particle.DustOptions(color, 1));
    }

    /**
     * Spawns a given amount of colored particles of a specific size
     * at the target location.
     *
     * @param location the location
     * @param count the amount of particles
     * @param color the color of the particles
     * @param size the particle size
     * */
    public static void spawnColoredParticle(@NotNull Location location,
                                            int count,
                                            @NotNull Color color,
                                            float size) {
        if (location.getWorld() == null) return;
        location.getWorld().spawnParticle(Particle.REDSTONE, location, count,
                new Particle.DustOptions(color, size));
    }

    /**
     * Spawns a given amount of colored particles at the target location.
     * The position of the particles will be randomized based on
     * the offsets of each axis.
     *
     * @param location the location
     * @param count the amount of particles
     * @param color the color of the particles
     * @param offsetX the offset for the X axis
     * @param offsetY the offset for the Y axis
     * @param offsetZ the offset for the Z axis
     * */
    public static void spawnColoredParticle(@NotNull Location location,
                                            int count,
                                            double offsetX,
                                            double offsetY,
                                            double offsetZ,
                                            @NotNull Color color) {
        if (location.getWorld() == null) return;
        location.getWorld().spawnParticle(Particle.REDSTONE, location, count, offsetX, offsetY, offsetZ,
                new Particle.DustOptions(color, 1));
    }

    /**
     * Spawns a given amount of colored particles of a specific size
     * at the target location.
     * The position of the particles will be randomized based on
     * the offsets of each axis.
     *
     * @param location the location
     * @param count the amount of particles
     * @param color the color of the particles
     * @param offsetX the offset for the X axis
     * @param offsetY the offset for the Y axis
     * @param offsetZ the offset for the Z axis
     * @param size the particle size
     * */
    public static void spawnColoredParticle(@NotNull Location location,
                                            int count,
                                            double offsetX,
                                            double offsetY,
                                            double offsetZ,
                                            @NotNull Color color,
                                            float size) {
        if (location.getWorld() == null) return;
        location.getWorld().spawnParticle(Particle.REDSTONE, location, count, offsetX, offsetY, offsetZ,
                new Particle.DustOptions(color, size));
    }
}
