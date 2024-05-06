package org.consdiaz.digitalwallet.currencybalance.currencyexchange;

import org.consdiaz.digitalwallet.currencybalance.Currency;

/**
 * Clase que convierte desde euro a peso chileo o dolar estadounidense. Las tasas de cambio son fijas
 */
public class EURConverter extends CurrencyConverter{
    /**
     * Método que convierte desde EUR a otra moneda
     * @param amountConvert cantidad de dinero a convertir desde el objeto Currency inicial
     * @param fromCurrency objeto Currency desde donde se convierte el dinero
     * @param toCurrency objeto Currency hacia donde se convierte el dinero
     * @return cantidad de dinero que fue hacia la moneda del objeto toCurrency
     */
    @Override
    public double convert(double amountConvert, Currency fromCurrency, Currency toCurrency) {
        return amountConvert * getExchangeRate(toCurrency);
    }
    /**
     * Obtiene la tasa de cambio para la moneda EUR. Las tasas de cambio vienen del enum ExchangeRate
     * @param currency moneda a la cual queremos convertir
     * @return devuelve la tasa de cambio de EUR hacia la que corresponde a toCurrency. Si el codigo de toCurrency
     * no es correcto entonces devuelve -1
     */
    private double getExchangeRate(Currency currency){
        switch (currency.getCurrencyCode()){
            case "CLP":
                return ExchangeRate.EUR_TO_CLP.getRate();
            case "USD":
                return ExchangeRate.EUR_TO_USD.getRate();
            default:
                return -1; //error que me invente para especificar que el código de la cuenta toCurrency no existe
        }
    }
}