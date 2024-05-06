package org.consdiaz.digitalwallet.currencybalance.management;

import org.consdiaz.digitalwallet.currencybalance.Currency;

/**
 * Representa la cuenta de una moneda especifica. Maneja lo que es el deposito y retiro de dinero de la cuenta.
 * Tiene como atributos la nstancia Currency que representa una moneda y su balance(saldo)
 */
public class CurrencyAccount implements CurrencyOperation{
    private Currency currency;
    private double balance;

    public CurrencyAccount(Currency currency, double balance) {
        this.currency = currency;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Realiza el deposito a la cuenta y actualiza su saldo
     * @param amountDeposit cantidad de dinero a depositar
     * @return el monto actualizado del saldo
     */
    @Override
    public double deposit(double amountDeposit) {
        this.balance += amountDeposit;
        return balance;
    }

    /**
     * Si hay suficiente dinero realiza un retiro de la cuenta. Si no puede retirar el dinero avisa con un mensaje por consola
     * @param amountWithdraw cantidad de dinero para retirar
     * @return el monto actualizado del saldo
     */
    @Override
    public double withdraw(double amountWithdraw) {
        if (this.balance >= amountWithdraw){
            this.balance -= amountWithdraw;
        } else {
            System.out.println("Saldo insuficiente. No se puede hacer el retiro");
        }
        return balance;
    }

    /**
     * Representación en string de la cuenta
     * @return string que venia con el formato de currency ("nombre (codigo): simbolo") más el saldo
     */
    @Override
    public String toString() {
        return "Balance de la cuenta " + currency + balance;
    }
}