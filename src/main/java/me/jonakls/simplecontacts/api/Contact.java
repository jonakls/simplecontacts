package me.jonakls.simplecontacts.api;

import java.util.UUID;

public class Contact {

    private final UUID uuid;
    private final String name;
    private String alias;
    private String secondName;
    private String email;
    private long number;
    private long secondNumber;

    public Contact(UUID uuid, String name, String secondName) {
        this.uuid = uuid;
        this.name = name;
        this.secondName = secondName;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setSecondNumber(long secondNumber) {
        this.secondNumber = secondNumber;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public long getNumber() {
        return number;
    }

    public long getSecondNumber() {
        return secondNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + uuid.toString() +
                "name=" + name +
                "secondname=" + secondName +
                "alias=" + alias +
                "email=" + email +
                "phone=" + number +
                "phone2=" + secondNumber +
                '}' + '\n'
        ;
    }
}
