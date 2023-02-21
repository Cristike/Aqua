


package dev.cristike.aqua.number;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class AquaMath {

    /**
     * Transforms the given input into an integer.
     *
     * @param input the input
     * @return an optional that may contain the value
     * */
    public static Optional<Integer> parseInt(@NotNull String input) {
        try {
            int number = Integer.parseInt(input);
            return Optional.of(number);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * Transforms the given input into a float.
     *
     * @param input the input
     * @return an optional that may contain the value
     * */
    public static Optional<Float> parseFloat(@NotNull String input) {
        try {
            float number = Float.parseFloat(input);
            return Optional.of(number);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * Transforms the given input into a double.
     *
     * @param input the input
     * @return an optional that may contain the value
     * */
    public static Optional<Double> parseDouble(@NotNull String input) {
        try {
            double number = Double.parseDouble(input);
            return Optional.of(number);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
