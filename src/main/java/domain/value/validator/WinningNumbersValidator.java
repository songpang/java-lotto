package domain.value.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import ui.message.ExceptionMessage;

public class WinningNumbersValidator {
    public static final int MINIMUM_WINNING_NUMBER = 1;
    public static final int MAXIMUM_WINNING_NUMBER = 45;
    private static final String CHARACTERS_CONTAINING_NUMBER_COMMA = "^[0-9,\\s]+$";
    private static final int SIZE_OF_WINNING_NUMBERS = 6;

    public void validateOtherCharacterSymbols(String input) {
        if (!Pattern.matches(CHARACTERS_CONTAINING_NUMBER_COMMA, input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_ONLY_NUMBERS_AND_COMMA.getMessage());
        }
    }

    public void validateSizeOfWinningNumbers(List<Integer> splitWinningNumbers) {
        if (splitWinningNumbers.size() != SIZE_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_INPUT_SIX_WINNING_NUMBERS.getMessage());
        }
    }

    public void validateRangeOfWinningNumbers(List<Integer> splitWinningNumbers) {
        if (splitWinningNumbers.stream()
            .anyMatch(
                winningNumber -> winningNumber < MINIMUM_WINNING_NUMBER || winningNumber > MAXIMUM_WINNING_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
        }
    }

    public void validateDuplicateWinningNumbers(List<Integer> splitWinningNumbers) {
        Set<Integer> numbers = new HashSet<>(splitWinningNumbers);
        if (numbers.size() != SIZE_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBERS.getMessage());
        }
    }
}
