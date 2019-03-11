package com.epam.cleancode.singleresponsibility;

public class Calculator {

    private static final String SEPARATOR = ",";

    public String add(String numbers) {
        validate(numbers);

        return "summa: " + getSum(numbers);
    }

    public String multiply(String numbers) {
        validate(numbers);

        return "product: " + getProduct(numbers);
    }

    private int getSum(String numbers) {
        int summa = 0;

        for (String number : numbers.split(SEPARATOR)) {
            if (isNotEmpty(number)) {
                summa += Integer.valueOf(number);
            }
        }

        return summa;
    }

    private int getProduct(String numbers) {
        int product = 1;

        for (String number : numbers.split(SEPARATOR)) {
            if (isNotEmpty(number)) {
                product *= Integer.valueOf(number);
            }
        }

        return product;
    }

    private boolean isNotEmpty(String numbers) {
        return !numbers.isEmpty();
    }

    private void validate(String numbers) {
        if (numbers == null || isNotDigits(numbers)) {
            throw new WrongFormatException();
        }

    }

    private boolean isNotDigits(String numbers) {
        return !isDigits(numbers);
    }

    private boolean isDigits(String numbers) {
        return numbers.matches("[\\d" + SEPARATOR + "]*");
    }

}
