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

package dev.cristike.aqua.math;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A class that contains abstractions for various tasks based on random values.
 * */
public class AquaRandom {
    private static final Random random = new Random();

    /**
     * Gets a random integer between 0 and the bound (exclusive).
     *
     * @param bound the bound
     * @return the random value
     * */
    public static int getRandomInteger(int bound) {
        return random.nextInt(bound);
    }

    /**
     * Gets a random integer between the origin (inclusive) and the bound (exclusive).
     *
     * @param origin the origin
     * @param bound the bound
     *
     * @return the random value
     * */
    public static int getRandomInteger(int origin, int bound) {
        return random.nextInt(origin, bound);
    }

    /**
     * Gets a random double between 0 and the bound (exclusive).
     *
     * @param bound the bound
     * @return the random value
     * */
    public static double getRandomDouble(double bound) {
        return random.nextDouble(bound);
    }

    /**
     * Gets a random double between the origin (inclusive) and the bound (exclusive).
     *
     * @param origin the origin
     * @param bound the bound
     *
     * @return the random value
     * */
    public static double getRandomDouble(double origin, double bound) {
        return random.nextDouble(origin, bound);
    }

    /**
     * Gets a random value from the given array.
     *
     * @return the random value
     * */
    public static <T> T getRandomElement(@NotNull T[] array) {
        return array[getRandomInteger(array.length)];
    }

    /**
     * Gets a random element
     * from the given list.
     *
     * @return the random value
     * */
    public static <T> T getRandomElement(@NotNull List<T> list) {
        return list.get(getRandomInteger(list.size()));
    }

    /**
     * Shuffles the given array.
     *
     * @param array the original array
     * @return a new shuffled array instance
     * */
    public static <T> T[] shuffleArray(@NotNull T[] array) {
        T[] shuffledArray = Arrays.copyOf(array, array.length);

        for (int i = shuffledArray.length - 1; i >= 1; i--) {
            int j = getRandomInteger(i + 1);

            T temp = shuffledArray[i];
            shuffledArray[i] = shuffledArray[j];
            shuffledArray[j] = temp;
        }

        return shuffledArray;
    }
}
