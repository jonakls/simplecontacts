package me.jonakls.simplecontacts.managers;

import me.jonakls.simplecontacts.api.Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactService {

    private final Map<UUID, Contact> contactUserMap;

    public ContactService() {
        this.contactUserMap = new HashMap<>();
    }

    public void loadContacts() {
        //TODO: Pendiente crear

    }

    public void addContact(String uuid, Contact contact) {
        this.contactUserMap.put(UUID.fromString(uuid), contact);
    }

    public void removeContact(String string) {

    }

    public Contact updateContact(String uuid) {
        return this.contactUserMap.get(UUID.fromString(uuid));
    }


}
