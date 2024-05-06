package org.consdiaz.digitalwallet.menu.login;

import java.util.ArrayList;

/**
 * Clase que se encarga del inicio de sesión
 */
public class UserLogin {
    private ArrayList<User> users; //atributo que contiene los usuarios ya registrados almacenados en un arraylist

    public UserLogin(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * Método para iniciar sesión. Compara el usuario y contraseña ingresado por consola con
     * los objetos User almacenados en el ArrayList
     * @param userName usuario ingresado por consola para iniciar sesión
     * @param userPassword contraseña ingresada por consola para iniciar sesión
     * @return verdadero en caso de que coincidan
     */
    public boolean login (String userName, String userPassword){
        for (User user : users){
            if (userName.equalsIgnoreCase(user.getName()) && userPassword.equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
}