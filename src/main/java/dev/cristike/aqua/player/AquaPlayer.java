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

package dev.cristike.aqua.player;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * A class that contains abstractions for various tasks targeting players.
 * */
public class AquaPlayer {

    /**
     * Gets the online player with the given name.
     *
     * @param name the player's name
     * @return an optional that may contain the player
     * */
    public static Optional<Player> getPlayer(@NotNull String name) {
        return Optional.ofNullable(Bukkit.getPlayer(name));
    }

    /**
     * Gets the online player with the given uuid.
     *
     * @param uuid the player's unique id
     * @return an optional that may contain the player
     */
    public static Optional<Player> getPlayer(@NotNull UUID uuid) {
        return Optional.ofNullable(Bukkit.getPlayer(uuid));
    }

    /**
     * Gets the offline player with the given name.
     *
     * @param name the offline player's name
     * @return an optional that may contain the offline player
     * */
    public static Optional<OfflinePlayer> getOfflinePlayer(@NotNull String name) {
        OfflinePlayer offlinePlayer = Arrays.stream(Bukkit.getOfflinePlayers())
                .filter(target -> Objects.equals(target.getName(), name)).findFirst().orElse(null);

        return Optional.ofNullable(offlinePlayer);
    }

    /**
     * Gets the offline player with the given uuid.
     *
     * @param uuid the offline player's unique id
     * @return an optional that may contain the offline player
     * */
    public static Optional<OfflinePlayer> getOfflinePlayer(@NotNull UUID uuid) {
        OfflinePlayer offlinePlayer = Arrays.stream(Bukkit.getOfflinePlayers())
                .filter(target -> target.getUniqueId().equals(uuid)).findFirst().orElse(null);

        return Optional.ofNullable(offlinePlayer);
    }

    /**
     * Gets the online players that meet the given condition.
     *
     * @param predicate the condition
     * @return the list of players that met the condition
     * */
    public static List<Player> getPlayers(@NotNull Predicate<Player> predicate) {
        return Bukkit.getOnlinePlayers().stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * Gets the unique id of the player with the given name.
     *
     * @param name the player name
     * @return an optional that may contain the unique id
     * */
    public static Optional<UUID> getPlayerUUID(@NotNull String name) {
        if (isOnline(name))
            return Optional.of(getPlayer(name).get().getUniqueId());
        else if (getOfflinePlayer(name).isPresent())
            return Optional.of(getOfflinePlayer(name).get().getUniqueId());
        else
            return Optional.empty();
    }

    /**
     * Checks if the player with the given unique id is online.
     *
     * @param uuid the unique id
     * @return whether the player is online or not.
     * */
    public static boolean isOnline(@NotNull UUID uuid) {
        return Bukkit.getServer().getOnlinePlayers().stream().anyMatch(target -> target.getUniqueId().equals(uuid));
    }

    /**
     * Checks if the player with the given name is online.
     *
     * @param name the player name
     * @return whether the player is online or not.
     * */
    public static boolean isOnline(@NotNull String name) {
        return Bukkit.getServer().getOnlinePlayers().stream().anyMatch(target -> target.getName().equals(name));
    }

    /**
     * Sends the message to all online players.
     *
     * @param message the message
     * */
    public static void broadcastMessage(@NotNull String message) {
        Bukkit.getOnlinePlayers().forEach(target -> target.sendMessage(message));
    }

    /**
     * Sends the messages to all online players.
     *
     * @param messages the list of messages
     * */
    public static void broadcastMessages(@NotNull List<String> messages) {
        messages.forEach(AquaPlayer::broadcastMessage);
    }

    /**
     * Sends the messages from the list to the player.
     *
     * @param player the target player
     * @param messages the list of messages
     * */
    public static void sendMessages(@NotNull Player player, @NotNull List<String> messages) {
        messages.forEach(player::sendMessage);
    }

    /**
     * Teleports all the players in the given list to the target location.
     *
     * @param players the player list
     * @param location the location
     * */
    public static void teleport(@NotNull Collection<Player> players, @NotNull Location location) {
        players.forEach(target -> target.teleport(location));
    }

    /***
     * Executes the given action for all the online players
     *
     * @param consumer the action
     */
    public static void forEach(@NotNull Consumer<Player> consumer) {
        Bukkit.getOnlinePlayers().forEach(consumer);
    }

    /***
     * Executes the given action for all the players in the given list.
     *
     * @param players the players
     * @param consumer the action
     */
    public static void forEach(@NotNull Collection<Player> players,
                               @NotNull Consumer<Player> consumer) {
        players.forEach(consumer);
    }

    /**
     * Executes the given action for all the online players
     * that meet the given condition.
     *
     * @param predicate the condition
     * @param consumer the action
     * */
    public static void forEachIf(@NotNull Predicate<Player> predicate,
                                 @NotNull Consumer<Player> consumer) {
        Bukkit.getOnlinePlayers().stream().filter(predicate).forEach(consumer);
    }


    /**
     * Executes the given action for all the players in the given
     * list that meet the given condition.
     *
     * @param players the player list
     * @param predicate the condition
     * @param consumer the action
     * */
    public static void forEachIf(@NotNull Collection<Player> players,
                                 @NotNull Predicate<Player> predicate,
                                 @NotNull Consumer<Player> consumer) {
        players.stream().filter(predicate).forEach(consumer);
    }
}
