package org.consdiaz.digitalwallet.currencybalance.currencyexchange;

/**
 * enum con la tasa de cambio (valor fijo) según moneda de inicio a moneda final
 */
public enum ExchangeRate {
    CLP_TO_USD(0.011),
    CLP_TO_EUR(0.00099),
    EUR_TO_CLP(1015.08),
    EUR_TO_USD(1.08),
    USD_TO_CLP(942.28),
    USD_TO_EUR(0.93);

    private final double rate;

    ExchangeRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}