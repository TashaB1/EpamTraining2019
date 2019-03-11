package com.epam.cleancode.comments;

public class MortgageInstallmentCalculator {

    public static double calculateMonthlyPayment(int principalAmount, int termMortgageInYears, double rateOfInterest) {

        final int YEARINMONTHS = 12;

        double termMortgageInMonths;
        double monthlyRateOfInterest;
        double monthlyPayment;

        if (principalAmount < 0 || termMortgageInYears <= 0 || rateOfInterest < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }

        rateOfInterest /= 100.0;
        termMortgageInMonths = termMortgageInYears * YEARINMONTHS;

        if (rateOfInterest == 0) {
            return principalAmount / termMortgageInMonths;
        }

        monthlyRateOfInterest = rateOfInterest / YEARINMONTHS;
        monthlyPayment = (principalAmount * monthlyRateOfInterest) / (1 - Math.pow(1 + monthlyRateOfInterest, -termMortgageInMonths));

        return monthlyPayment;
    }
}
