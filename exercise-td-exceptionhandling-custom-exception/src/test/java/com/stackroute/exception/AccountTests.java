package com.stackroute.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTests {
    private static final String MESSAGE_ONE = "Account object should be created with zero initial balance";
    private static final String MESSAGE_TWO = "Account object should be created with the given balance using parameterized constructor";
    private static final String MESSAGE_THREE = "Withdraw with valid amount should return the new balance";
    private static final String MESSAGE_FOUR = "Withdrawing amount less than zero should throw NegativeIntegerException";
    private static final String MESSAGE_FIVE = "Withdrawing amount greater than balance should throw InsufficientFundsException";
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(10000);
    }

    @AfterEach
    public void tearDown() {
        account = null;
    }

    @Test
    public void givenDefaultConstructorThenBalancePropertySetWithDefaultValue() {
        account = new Account();
        assertEquals(0, account.getAccountBalance(), MESSAGE_ONE);
    }

    @Test
    public void givenParameterizedConstructorThenBalancePropertySetWithGivenValue() {
        assertEquals(10000, account.getAccountBalance(), MESSAGE_TWO);
    }

    @Test
    public void givenValidWithdrawAmountThenReturnNewBalance() throws InsufficientFundException, NegativeIntegerException {
        double newBalance = account.withdraw(5000);
        assertEquals(5000, newBalance, MESSAGE_THREE);
    }

    @Test
    public void givenZeroWithdrawAmountThenReturnSameBalance() throws InsufficientFundException, NegativeIntegerException {
        double newBalance = account.withdraw(0);
        assertEquals(10000, newBalance, MESSAGE_THREE);
    }

    @Test
    public void givenNegativeWithdrawAmountThenThrowsNegativeIntegerException() throws InsufficientFundException, NegativeIntegerException {
        assertThrows(NegativeIntegerException.class, () -> account.withdraw(-100), MESSAGE_FOUR);
    }

    @Test
    public void givenWithdrawAmountGreaterThanBalanceThenThrowsInsufficientFundException()  throws InsufficientFundException, NegativeIntegerException {
        assertThrows(InsufficientFundException.class, () -> account.withdraw(150000), MESSAGE_FIVE);
    }
}
