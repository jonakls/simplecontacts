package me.jonakls.simplecontacts.api;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactUser {

    private final UUID uuid;
    private String nickname;
    private String name;
    private String secondName;
    private String email;
    private String phone;
    private String password;
    private final Map<Integer, Contact> contactMap;

    public ContactUser(String nickname) {
        this.nickname = nickname;
        this.uuid = UUID.randomUUID();
        this.contactMap = new HashMap<>();
    }

    public ContactUser(UUID uuid) {
        this.uuid = uuid;
        this.contactMap = new HashMap<>();
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "{" +
                "id=" + uuid.toString() + ";" + // UUID
                "nick=" + nickname + ";" + // NICK
                "name=" + name + ";" + // NOMBRE
                "secondName=" + secondName + ";" + // APELLIDO
                "email=" + email + ";" + // EMAIL
                "phone=" + phone + ";" + // TELEFONO
                "password=" + // CONTRASENA (BASE64)
                Base64.getEncoder().encodeToString(password.getBytes()) +
                "}" + "\n";
    }
}
