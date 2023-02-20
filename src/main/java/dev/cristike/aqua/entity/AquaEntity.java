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

package dev.cristike.aqua.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AquaEntity {

    /**
     * Gets the entities that are around the given entity
     * in the given radius.
     *
     * @param entity the entity
     * @param radius the radius
     * */
    @NotNull
    public static List<Entity> getNearbyEntities(@NotNull Entity entity, double radius) {
        List<Entity> entities = entity.getNearbyEntities(radius, radius, radius);
        entities.add(entity);

        return entities;
    }

    /**
     * Gets the players that are around the given entity
     * in the given radius.
     *
     * @param entity the entity
     * @param radius the radius
     * */
    @NotNull
    public static List<Player> getNearbyPlayers(@NotNull Entity entity, double radius) {
        List<Entity> entities = getNearbyEntities(entity, radius);
        List<Player> players = new ArrayList<>();

        entities.forEach(target -> {
            if (!(target instanceof Player player)) return;
            players.add(player);
        });

        return players;
    }

    /**
     * Executes the given action for all the entities
     * that are around the given entity in the given radius.
     *
     * @param entity the entity
     * @param radius the radius
     * @param consumer the action
     * */
    public static void forEachNearbyEntity(@NotNull Entity entity, double radius, @NotNull Consumer<Entity> consumer) {
        getNearbyEntities(entity, radius).forEach(consumer);
    }

    /**
     * Executes the given action for all the players
     * that are around the given entity in the given radius.
     *
     * @param entity the entity
     * @param radius the radius
     * @param consumer the action
     * */
    public static void forEachNearbyPlayer(@NotNull Entity entity, double radius, @NotNull Consumer<Player> consumer) {
        getNearbyPlayers(entity, radius).forEach(consumer);
    }
}
