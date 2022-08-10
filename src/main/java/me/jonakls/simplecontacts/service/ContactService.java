package me.jonakls.simplecontacts.service;

import me.jonakls.simplecontacts.api.Contact;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactService {

    private final UUID uuid;
    private final Map<Integer, Contact> contactMap;
    private File contactFile;

    public ContactService(UUID uuid) {
        this.uuid = uuid;
        this.contactMap = new HashMap<>();
        loadFolder();
    }

    final static File CONTACT_FOLDER = new File("contact");

    private void loadFolder() {
        final File[] files = CONTACT_FOLDER.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                continue;
            }
            if (!file.getName().equals(uuid.toString())) {
                continue;
            }
            contactFile = new File(CONTACT_FOLDER + uuid.toString() + "contacts.txt");
        }

        try {
            if (contactFile == null) {
                contactFile.createNewFile();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo de contacto");
        }
    }

    public void loadContacts() {


    }
}
