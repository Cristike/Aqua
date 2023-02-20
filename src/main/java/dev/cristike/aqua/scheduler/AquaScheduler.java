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

package dev.cristike.aqua.scheduler;

import dev.cristike.aqua.plugin.AquaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class AquaScheduler {

    /**
     * Gets the server scheduler.
     * */
    @NotNull
    public static BukkitScheduler getScheduler() { return Bukkit.getScheduler(); }

    /**
     * Executes the given action on the main thread
     * for the hosting plugin of the tool.
     *
     * @param runnable the action
     * */
    public static void runTask(@NotNull Runnable runnable) {
        getScheduler().runTask(AquaPlugin.getPlugin(), runnable);
    }

    /**
     * Executes the given action asynchronously
     * for the hosting plugin of the tool.
     *
     * @param runnable the action
     * */
    public static void runTaskAsync(@NotNull Runnable runnable) {
        getScheduler().runTaskAsynchronously(AquaPlugin.getPlugin(), runnable);
    }

    /**
     * Executes the given action after
     * the given amount of ticks.
     *
     * @param runnable the action
     * @param period the amount of ticks
     * */
    public static void runTaskLater(@NotNull Runnable runnable, long period) {
        getScheduler().runTaskLater(AquaPlugin.getPlugin(), runnable, period);
    }

    /**
     * Executes the given action async after
     * the given amount of ticks.
     *
     * @param runnable the action
     * @param period the amount of ticks
     * */
    public static void runTaskLaterAsync(@NotNull Runnable runnable, long period) {
        getScheduler().runTaskLaterAsynchronously(AquaPlugin.getPlugin(), runnable, period);
    }

    /**
     * Executes repeatedly the given action
     * with gaps of a given period.
     *
     * @param runnable the action
     * @param period the period
     * */
    @NotNull
    public static BukkitTask runTaskTimer(@NotNull Runnable runnable, long period) {
         return getScheduler().runTaskTimer(AquaPlugin.getPlugin(), runnable, period, period);
    }

    /**
     * Executes repeatedly the given action
     * with gaps of a given period after a given delay.
     *
     * @param runnable the action
     * @param delay the delay
     * @param period the period
     * */
    @NotNull
    public static BukkitTask runTaskTimer(@NotNull Runnable runnable, long delay, long period) {
        return getScheduler().runTaskTimer(AquaPlugin.getPlugin(), runnable, delay, period);
    }

    /**
     * Executes repeatedly the given action asynchronously
     * with gaps of a given period,
     *
     * @param runnable the action
     * @param period the period
     * */
    @NotNull
    public static BukkitTask runTaskTimerAsync(@NotNull Runnable runnable, long period) {
        return getScheduler().runTaskTimerAsynchronously(AquaPlugin.getPlugin(), runnable, period, period);
    }

    /**
     * Executes repeatedly the given action asynchronously
     * with gaps of a given period after a given delay.
     *
     * @param runnable the action
     * @param delay the delay
     * @param period the period
     * */
    @NotNull
    public static BukkitTask runTaskTimerAsync(@NotNull Runnable runnable, long delay, long period) {
        return getScheduler().runTaskTimerAsynchronously(AquaPlugin.getPlugin(), runnable, delay, period);
    }
}
