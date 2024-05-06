package org.consdiaz.digitalwallet.menu;

import org.consdiaz.digitalwallet.currencybalance.Currency;
import org.consdiaz.digitalwallet.currencybalance.currencyexchange.CLPConverter;
import org.consdiaz.digitalwallet.currencybalance.currencyexchange.EURConverter;
import org.consdiaz.digitalwallet.currencybalance.currencyexchange.USDConverter;
import org.consdiaz.digitalwallet.currencybalance.management.CurrencyAccount;

import java.util.Scanner;

public class Menu {
    /**
     * Este método se encarga de mostrar el menu una vez ya se haya iniciado sesión. Incluye opción ver saldo,
     * depositar y retirar fondos, convertir de una moneda a otra y cerrar sesión
     */
    public void displayMenu(String userName){

        Scanner s = new Scanner(System.in);
        int opcionMenuLogged;
        boolean menuLoggedBool = true;

        //Cuentas con sus monedas
        Currency peso = new Currency("Peso chileno", "CLP", "$");
        Currency euro = new Currency("Euro", "EUR", "€");
        Currency dolar = new Currency("Dolar estadounidense", "USD", "$");

        CurrencyAccount cuentaPeso = new CurrencyAccount(peso, 1000000);
        CurrencyAccount cuentaEuro = new CurrencyAccount(euro, 1000);
        CurrencyAccount cuentaDolar = new CurrencyAccount(dolar, 1100);

        System.out.println("¡Bienvenido/a " + userName + " a su DigitalWallet!");
        do {
            System.out.println("Opciones disponibles: "+
                    "\n1. Ver Saldo" +
                    "\n2. Depositar fondos" +
                    "\n3. Retirar fondos" +
                    "\n4. Convertir fondos a otra moneda" +
                    "\n5. Cerrar sesión");
            System.out.print("Ingrese el número de la opción que desea ejecutar (1 - 4): ");
            opcionMenuLogged = s.nextInt();

            switch (opcionMenuLogged){
                //Muestra los saldos
                case 1:
                    System.out.println("\n------------------------------------------------------------");
                    System.out.println("Balance saldos");
                    System.out.println(cuentaPeso);
                    System.out.println(cuentaEuro);
                    System.out.println(cuentaDolar);
                    System.out.println("------------------------------------------------------------\n");
                    break;

                //Depositar
                case 2:
                    System.out.println("\n------------------------------------------------------------");
                    System.out.println("Depositar");
                    System.out.println("Cuentas disponibles para depositar dinero: "+
                            "\n1. Cuenta peso chileno (CLP)" +
                            "\n2. Cuenta euro (EUR)" +
                            "\n3. Cuenta dolar estadounidense (USD)");
                    System.out.print("Ingrese el número correspondiente de la cuenta (1 - 3): ");
                    int depositNumber = s.nextInt();

                    System.out.print("Ingrese la cantidad que quiere depositar: ");
                    double amountDeposit = s.nextDouble();

                    //Elige a cual cuenta depositar
                    switch (depositNumber) {
                        case 1:
                            cuentaPeso.deposit(amountDeposit);
                            System.out.println(cuentaPeso);
                            break;
                        case 2:
                            cuentaEuro.deposit(amountDeposit);
                            System.out.println(cuentaEuro);
                            break;
                        case 3:
                            cuentaDolar.deposit(amountDeposit);
                            System.out.println(cuentaDolar);
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor ingrese un número del uno al tres (1 - 3)");
                            break;
                    }
                    System.out.println("------------------------------------------------------------\n");
                    break;

                //Retirar
                case 3:
                    System.out.println("\n------------------------------------------------------------");
                    System.out.println("Retirar");
                    System.out.println("Cuentas disponibles para retirar dinero: "+
                            "\n1. Cuenta Peso chileno (CLP)" +
                            "\n2. Cuenta Euro (EUR)" +
                            "\n3. Cuenta Dolar estadounidense (USD)");
                    System.out.print("Ingrese el número correspondiente de la cuenta (1 - 3): ");
                    int withdrawNumber = s.nextInt();

                    System.out.print("Ingrese la cantidad que quiere retirar: ");
                    double amountWithdraw = s.nextDouble();

                    //Elige desde que cuenta retirar fondos
                    switch (withdrawNumber) {
                        case 1:
                            cuentaPeso.withdraw(amountWithdraw);
                            System.out.println(cuentaPeso);
                            break;
                        case 2:
                            cuentaEuro.withdraw(amountWithdraw);
                            System.out.println(cuentaEuro);
                            break;
                        case 3:
                            cuentaDolar.withdraw(amountWithdraw);
                            System.out.println(cuentaDolar);
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor ingrese un número del uno al tres (1 - 3)");
                            break;
                    }
                    System.out.println("------------------------------------------------------------\n");
                    break;

                //Convertir moneda
                case 4:
                    System.out.println("\n------------------------------------------------------------");
                    System.out.println("Convertir moneda");
                    System.out.println("Ingrese el código de la moneda desde donde quiere convertir (CLP - EUR - USD): ");
                    String fromCurrency = s.next().toUpperCase();

                    System.out.println("Ingrese el código de la moneda a la que quiere convertir (CLP - EUR - USD): ");
                    String toCurrency = s.next().toUpperCase();

                    Currency desdeCurrency = new Currency(fromCurrency);
                    Currency haciaCurrency = new Currency(toCurrency);

                    //Se encarga de ver desde que moneda se convertira el dinero y dentro de cada case se busca hacia donde hay que convertir
                    switch (desdeCurrency.getCurrencyCode()) {
                        case "CLP":
                            System.out.println(cuentaPeso);
                            System.out.println("Ingrese cuanto dinero en " + desdeCurrency.getCurrencyCode() + " quiere convertir a " + haciaCurrency.getCurrencyCode() + ": ");
                            double amountConvertCLP = s.nextDouble();

                            if (amountConvertCLP > cuentaPeso.getBalance()){
                                System.out.println("Saldo insuficiente. Máximo puede convertir " + peso.getSymbol() + cuentaPeso.getBalance());
                            } else {
                                double finalAmountFromCLP = new CLPConverter().convert(amountConvertCLP, desdeCurrency, haciaCurrency);
                                System.out.println("Usted ha convertido " + desdeCurrency.getCurrencyCode() + " " + amountConvertCLP + " a " + haciaCurrency.getCurrencyCode() + finalAmountFromCLP);
                                cuentaPeso.withdraw(amountConvertCLP);
                                System.out.println(cuentaPeso);

                                switch (haciaCurrency.getCurrencyCode()) {
                                    case "EUR":
                                        cuentaEuro.deposit(finalAmountFromCLP);
                                        System.out.println(cuentaEuro);
                                        break;
                                    case "USD":
                                        cuentaDolar.deposit(finalAmountFromCLP);
                                        System.out.println(cuentaDolar);
                                        break;
                                }
                            }
                            break;

                        case "EUR":
                            System.out.println(cuentaEuro);
                            System.out.println("Ingrese cuanto dinero en " + desdeCurrency.getCurrencyCode() + " quiere convertir a " + haciaCurrency.getCurrencyCode() + ": ");
                            double amountConvertEUR = s.nextDouble();

                            double finalAmountFromEUR = new EURConverter().convert(amountConvertEUR, desdeCurrency, haciaCurrency);
                            System.out.println("Usted ha convertido " + desdeCurrency.getCurrencyCode() + " " + amountConvertEUR + " a " + haciaCurrency.getCurrencyCode() + finalAmountFromEUR);
                            cuentaEuro.withdraw(amountConvertEUR);
                            System.out.println(cuentaEuro);

                            switch (haciaCurrency.getCurrencyCode()){
                                case "CLP":
                                    cuentaPeso.deposit(finalAmountFromEUR);
                                    System.out.println(cuentaPeso);
                                    break;
                                case "USD":
                                    cuentaDolar.deposit(finalAmountFromEUR);
                                    System.out.println(cuentaDolar);
                                    break;
                            }
                            break;

                        case "USD":
                            System.out.println(cuentaDolar);
                            System.out.println("Ingrese cuanto dinero en " + desdeCurrency.getCurrencyCode() + " quiere convertir a " + haciaCurrency.getCurrencyCode() + ": ");
                            double amountConvertUSD = s.nextDouble();

                            double finalAmountFromUSD = new USDConverter().convert(amountConvertUSD, desdeCurrency, haciaCurrency);
                            System.out.println("Usted ha convertido " + desdeCurrency.getCurrencyCode() + " " + amountConvertUSD + " a " + haciaCurrency.getCurrencyCode() + finalAmountFromUSD);
                            cuentaDolar.withdraw(amountConvertUSD);
                            System.out.println(cuentaDolar);

                            switch (haciaCurrency.getCurrencyCode()){
                                case "CLP":
                                    cuentaPeso.deposit(finalAmountFromUSD);
                                    System.out.println(cuentaPeso);
                                    break;
                                case "EUR":
                                    cuentaEuro.deposit(finalAmountFromUSD);
                                    System.out.println(cuentaEuro);
                                    break;
                            }
                            break;
                        default:
                            System.out.println("El código de la moneda " + fromCurrency + " es inválido.");
                    }
                    System.out.println("------------------------------------------------------------\n");
                    break;

                //Cerrar sesión
                case 5:
                    menuLoggedBool = false;
                    System.out.println("\n------------------------------------------------------------");
                    System.out.println("Cerrando sesión...");
                    System.out.println("¡" + userName + " vuelva pronto!");
                    System.out.println("------------------------------------------------------------\n");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor ingrese un número del uno al cuatro (1 - 4)");
            }
        } while (menuLoggedBool);
    }
}
