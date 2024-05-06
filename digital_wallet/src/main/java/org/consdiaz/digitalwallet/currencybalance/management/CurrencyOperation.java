package org.consdiaz.digitalwallet.currencybalance.management;

/**
 * Interfaz que define las operaciones sobre las cuentas
 */
public interface CurrencyOperation {
    double deposit(double amount);
    double withdraw(double amount);
}