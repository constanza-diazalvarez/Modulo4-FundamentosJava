package org.consdiaz.digitalwallet.currencybalance.management;

import org.consdiaz.digitalwallet.currencybalance.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyAccountTest {

    @Test
    void testDeposit() {
        Currency pesoTest = new Currency("Peso chileno", "CLP", "$");
        CurrencyAccount accountTest = new CurrencyAccount(pesoTest, 10000.0);

        double depositAmount = 5000.0;
        double expectedBalance = 15000.0;

        assertEquals(expectedBalance, accountTest.deposit(depositAmount));

    }

    @Test
    void withdrawSuficiente() {
        Currency pesoTest = new Currency("Peso chileno", "CLP", "$");
        CurrencyAccount accountTest = new CurrencyAccount(pesoTest, 10000.0);

        double withdrawAmount = 1000.0;
        double expectedBalance = 9000.0;

        assertEquals(expectedBalance, accountTest.withdraw(withdrawAmount));
    }

    @Test
    void withdrawInuficiente() {
        Currency pesoTest = new Currency("Peso chileno", "CLP", "$");
        CurrencyAccount accountTest = new CurrencyAccount(pesoTest, 10000.0);

        double withdrawAmount = 11000.0;
        double expectedInicialBalance = 10000;

        assertEquals(expectedInicialBalance, accountTest.getBalance());
    }
}