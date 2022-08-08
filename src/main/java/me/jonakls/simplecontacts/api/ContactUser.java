package me.jonakls.simplecontacts.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactUser {

    private final String name;
    private final UUID uuid;
    private final Map<Integer, Contact> contactMap;

    public ContactUser(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
        this.contactMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Map<Integer, Contact> getContactMap() {
        return contactMap;
    }
}
