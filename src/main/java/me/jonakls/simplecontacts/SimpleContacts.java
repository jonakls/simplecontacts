package me.jonakls.simplecontacts;

import me.jonakls.simplecontacts.api.ContactUser;
import me.jonakls.simplecontacts.managers.ContactService;
import me.jonakls.simplecontacts.ui.LoginForm;

import java.util.Scanner;

public class SimpleContacts {

    private static ContactUser contactUser;
    private static ContactService contactService;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // SE INICIA EL SERVICIO DE CONTACTOS
        contactService = new ContactService();

        // SE INICIA LA ABSTRACCION DE USUARO
        contactUser = new ContactUser("Jonathan Narvaez");

        // EJERCICIO BASICO DE PRUEBA PARA GESTIONAR
        // INICIA LOS UI DEL SISTEMA
        new LoginForm(null);
    }

}
