package org.consdiaz.digitalwallet;
import org.consdiaz.digitalwallet.menu.Menu;
import org.consdiaz.digitalwallet.menu.login.User;
import org.consdiaz.digitalwallet.menu.login.UserLogin;
import org.consdiaz.digitalwallet.menu.login.UserSingUp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Punto de entrada de la billetera. Se encarga de iniciar sesión y registrar usuarios nuevos
 */
public class Runner {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        UserSingUp userSingUp = new UserSingUp();
        ArrayList<User> users = userSingUp.getUsers();
        UserLogin userLogin = new UserLogin(users);
        Menu menu = new Menu();

        int optionMenu;
        boolean menuBool = true;
        System.out.println("Bienvenido a DigitalWallet\n");

        do {
            System.out.println("Menú Inicio: " +
                    "\n1. Iniciar Sesión" +
                    "\n2. Registrar usuario nuevo");

            System.out.print("Seleccione una opción (1 - 2): ");
            optionMenu = s.nextInt();
            s.nextLine();

            switch (optionMenu){
                //Inicio de sesión
                case 1:

                    System.out.println("Ingrese usuario: ");
                    String userName = s.nextLine();

                    System.out.println("Ingrese contraseña: ");
                    String userPassword = s.nextLine();

                    boolean loginSuccess = userLogin.login(userName, userPassword);

                    if (loginSuccess) {
                        System.out.println("Ingresando a su DigitalWallet... \n");
                        System.out.println("------------------------------------------------------------\n");
                        menu.displayMenu(userName);
                        menuBool = false;
                    } else {
                        System.out.println("Usuario y/o contraseña incorrectos." +
                                "\nInténtelo nuevamente");
                    }
                    break;

                //Registro de usuario nuevo
                case 2:
                    System.out.println("Registro de nuevo usuario");
                    System.out.println("Ingrese nombre de usuario: ");
                    String newUserName = s.nextLine();

                    if (userSingUp.alreadyExist(newUserName)){
                        System.out.println("El nombre de usuario ya existe. " +
                                "Si ya tiene una cuenta intente iniciar sesión o " +
                                "elija un nuevo nombre de usuario");
                    }

                    System.out.println("Ingrese contraseña: ");
                    String newUserPassword = s.nextLine();

                    userSingUp.addUser(newUserName, newUserPassword);
                    System.out.println("Usuario registrado correctamente");
                    break;

                default:
                    System.out.println("Por favor ingrese una opción válida (1 o 2)");
            }
        } while (menuBool);
    }
}