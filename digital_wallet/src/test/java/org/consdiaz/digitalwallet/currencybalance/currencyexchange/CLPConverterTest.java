package org.consdiaz.digitalwallet.currencybalance.currencyexchange;

import org.consdiaz.digitalwallet.currencybalance.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CLPConverterTest {

    @Test
    void testConvertToUSD() {
        CLPConverter converter = new CLPConverter();
        Currency pesoTest = new Currency("Peso chileno", "CLP", "$");
        Currency dolarTest = new Currency("Dolar estadounidense", "USD", "$");

        double amountCLP = 1000.0;
        double expectedAmountUSD = amountCLP * ExchangeRate.CLP_TO_USD.getRate();

        assertEquals(expectedAmountUSD, converter.convert(amountCLP, pesoTest, dolarTest));
    }

    @Test
    void testConverterToEUR() {
        CLPConverter converter = new CLPConverter();
        Currency pesoTest = new Currency("Peso chileno", "CLP", "$");
        Currency euroTest = new Currency("Euro", "EUR", "€");

        double amountCLP = 2000.0;
        double expectedAmountEUR = amountCLP * ExchangeRate.CLP_TO_EUR.getRate();

        assertEquals(expectedAmountEUR, converter.convert(amountCLP, pesoTest, euroTest));
    }

    @Test
    void invalidCurrency() {
        CLPConverter converter = new CLPConverter();
        Currency pesoTest = new Currency("Peso chileno", "CLP", "$");
        Currency berryTest = new Currency("Berry", "BERI", "β");

        double amountCLP = 4000.0;
        double expectedAmountBERI = amountCLP * -1;
        assertEquals(expectedAmountBERI, converter.convert(amountCLP, pesoTest, berryTest));
    }
}