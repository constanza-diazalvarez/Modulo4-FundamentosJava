package org.consdiaz.digitalwallet.menu.login;

/**
 * Clase usuario que contiene los atributos nombre y contraseña
 */
public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}