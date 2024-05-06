package org.consdiaz.digitalwallet.currencybalance.currencyexchange;

import org.consdiaz.digitalwallet.currencybalance.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EURConverterTest {

    @Test
    void testConvertToCLP(){
        EURConverter converter = new EURConverter();
        Currency euroTest = new Currency("Euro", "EUR", "€");
        Currency pesoTest = new Currency("Peso chileno", "CLP", "$");

        double amountEUR = 500.0;
        double expectedCLP = amountEUR * ExchangeRate.EUR_TO_CLP.getRate();

        assertEquals(expectedCLP, converter.convert(amountEUR, euroTest, pesoTest));
    }

    @Test
    void testConvertToUSD() {
        EURConverter converter = new EURConverter();
        Currency euroTest = new Currency("Euro", "EUR", "€");
        Currency dolarTest = new Currency("Dolar estadounidense", "USD", "$");

        double amountEUR = 600.0;
        double expectedUSD = amountEUR * ExchangeRate.EUR_TO_USD.getRate();

        assertEquals(expectedUSD, converter.convert(amountEUR, euroTest, dolarTest));
    }
    @Test
    void invalidCurrency() {
        EURConverter converter = new EURConverter();
        Currency euroTest = new Currency("Euro", "EUR", "€");
        Currency falsaTest = new Currency("Moneda falsa", "FAL", "φ");

        double amountEUR = 400.0;
        double expectedAmountBERI = amountEUR * -1;
        assertEquals(expectedAmountBERI, converter.convert(amountEUR, euroTest, falsaTest));
    }
}