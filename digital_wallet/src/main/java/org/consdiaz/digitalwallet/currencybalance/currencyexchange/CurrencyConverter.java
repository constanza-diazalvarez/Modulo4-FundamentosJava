package org.consdiaz.digitalwallet.currencybalance.currencyexchange;

import org.consdiaz.digitalwallet.currencybalance.Currency;

/**
 * Clase abstracta que convierte moneda
 */
public abstract class CurrencyConverter {
    /**
     * Método que convierte de una moneda a otra
     * @param amountConvert cantidad de dinero a convertir desde el objeto Currency inicial
     * @param fromCurrency objeto Currency desde donde se convierte el dinero
     * @param toCurrency objeto Currency hacia donde se convierte el dinero
     * @return cantidad de dinero del objeto Currency toCurrency
     */
    public abstract double convert(double amountConvert, Currency fromCurrency, Currency toCurrency);
}