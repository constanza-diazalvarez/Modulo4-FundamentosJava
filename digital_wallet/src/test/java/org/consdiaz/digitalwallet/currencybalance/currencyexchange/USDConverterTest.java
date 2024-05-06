package org.consdiaz.digitalwallet.currencybalance.currencyexchange;

import org.consdiaz.digitalwallet.currencybalance.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class USDConverterTest {

    @Test
    void testconvertToCLP() {
        USDConverter converter = new USDConverter();
        Currency dolarTest = new Currency("Dolar estadounidense", "USD", "$");
        Currency pesoTest = new Currency("Peso chileno", "CLP", "$");

        double amountUSD = 400.0;
        double expectedCLP = amountUSD * ExchangeRate.USD_TO_CLP.getRate();

        assertEquals(expectedCLP, converter.convert(amountUSD, dolarTest, pesoTest));
    }

    @Test
    void testconvertToEUR() {
        USDConverter converter = new USDConverter();
        Currency dolarTest = new Currency("Dolar estadounidense", "USD", "$");
        Currency euroTest = new Currency("Euro", "EUR", "€");

        double amountUSD = 300.0;
        double expectedEUR = amountUSD * ExchangeRate.USD_TO_EUR.getRate();

        assertEquals(expectedEUR, converter.convert(amountUSD, dolarTest, euroTest));
    }

    @Test
    void invalidCurrency() {
        USDConverter converter = new USDConverter();
        Currency dolarTest = new Currency("Dolar estadounidense", "USD", "$");
        Currency mentiraTest = new Currency("Moneda de mentira", "MEN", "μ");

        double amountUSD = 200.0;
        double expectedAmountBERI = amountUSD * -1;
        assertEquals(expectedAmountBERI, converter.convert(amountUSD, dolarTest, mentiraTest));
    }
}