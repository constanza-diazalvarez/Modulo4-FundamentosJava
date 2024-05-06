package org.consdiaz.digitalwallet.currencybalance;

/**
 * Esta clase representa a cada moneda con su nombre(peso chileno, euro, dolar estadounidense),
 * código(CLP, EUR, USD) y símbolo($, €)
 */
public class Currency {
    String currencyName;
    String currencyCode;
    String symbol;

    public Currency(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Currency(String currencyName, String currencyCode, String symbol) {
        this(currencyCode);
        this.currencyName = currencyName;
        this.symbol = symbol;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * Representación en string de Currency
     * @return string en formato "nombre (codigo): simbolo"
     */
    @Override
    public String toString() {
        return currencyName + " (" + currencyCode + "): " + symbol;
    }
}