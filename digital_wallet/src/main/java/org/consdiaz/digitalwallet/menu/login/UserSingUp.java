package org.consdiaz.digitalwallet.menu.login;

import java.util.ArrayList;

/**
 * Clase que se encarga del registro de usuarios nuevos
 */
public class UserSingUp {
    private ArrayList<User> users; //el atributo users es un arraylist que contiene objetos User

    /**
     * El constructor inicializa el el users con un administrador. Con el se puede hacer inicio de sesion aunque
     * no se haya registrado ningun usuario nuevo aun
     */
    public UserSingUp() {
        this.users = new ArrayList<>();
        User adminUser = new User("admin", "pass123");
        users.add(adminUser);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Método para agregar objeto User al ArrayList
     * @param name nombre usuario
     * @param password contraseña del usuario
     */
    public void addUser(String name, String password){
        User newUser = new User(name, password);
        users.add(newUser);
    }

    /**
     * Método para verificar si ya existía el nombre de usuario
     * @param name nombre de usuario
     * @return true si el usuario ya existía, false si no es el caso
     */
    public boolean alreadyExist(String name){
        for (User user : users){
            return user.getName().equalsIgnoreCase(name);
        }
        return false;
    }
}