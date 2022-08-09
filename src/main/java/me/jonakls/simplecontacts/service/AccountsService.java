package me.jonakls.simplecontacts.service;

import me.jonakls.simplecontacts.api.ContactUser;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static me.jonakls.simplecontacts.utils.FileUtils.createFile;

public class AccountsService {

    private final File accountsFile;
    private final Map<UUID, ContactUser> contactUserMap;

    public AccountsService() {
        this.accountsFile = createFile("accounts.txt");
        this.contactUserMap = new HashMap<>();
        loadAccounts();
    }

    // FORMATO DE CUENTAS
    // {id=UUID;nick=NICK;name=NOMBRE;secondName=APELLIDO;email=EMAIL;phone=TELEFONO;password=BASE64}
    public void loadAccounts() {
        StringJoiner allAccounts = new StringJoiner("\n");
        try {
            FileReader fileReader = new FileReader(accountsFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                allAccounts.add(bufferedReader.readLine());
            }
            if (allAccounts.toString().isEmpty()) {
                JOptionPane.showConfirmDialog(null, "No hay cuentas registradas");
            } else {
                for (String account : allAccounts.toString().split("\n")) {
                    loadUsers(account);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al cargar las cuentas",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void loadUsers(String account) {
        // id=UUID;nick=NICK;name=NOMBRE;secondName=APELLIDO;email=EMAIL;phone=TELEFONO;password=BASE64
        String[] accountData = account.replace("{", "").replace("}", "").split(";");
        UUID uuid = null;
        for (String data : accountData) {
            String[] dataSplit = data.split("=");
            switch (dataSplit[0].toLowerCase(Locale.ROOT)) {
                case "id":
                    uuid = UUID.fromString(dataSplit[1]);
                    contactUserMap.put(uuid, new ContactUser(dataSplit[1]));
                    break;
                case "name":
                    contactUserMap.get(uuid).setName(dataSplit[1]);
                    break;
                case "secondname":
                    contactUserMap.get(uuid).setSecondName(dataSplit[1]);
                    break;
                case "email":
                    contactUserMap.get(uuid).setEmail(dataSplit[1]);
                    break;
                case "phone":
                    contactUserMap.get(uuid).setPhone(dataSplit[1]);
                    break;
                case "password":
                    contactUserMap.get(uuid).setPassword(Arrays.toString(Base64.getDecoder().decode(dataSplit[1])));
                    break;
            }
        }
    }

    public void saveAccount(ContactUser contactUser) {
        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("id=").append(contactUser.getUuid().toString()).append(";") // UUID
                .append("nick=").append(contactUser.getNickname()).append(";") // NICK
                .append("name=").append(contactUser.getName()).append(";") // NOMBRE
                .append("secondName=").append(contactUser.getSecondName()).append(";") // APELLIDO
                .append("email=").append(contactUser.getEmail()).append(";") // EMAIL
                .append("phone=").append(contactUser.getPhone()).append(";") // TELEFONO
                .append("password=") // CONTRASENA (BASE64)
                .append(Base64.getEncoder().encodeToString(contactUser.getPassword().getBytes()))
                .append("}");
        contactUserMap.put(contactUser.getUuid(), contactUser);
        try {
            FileWriter fileWriter = new FileWriter(accountsFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(builder.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al guardar la cuenta",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public ContactUser getAccount(String nickname) {

        for (ContactUser contactUser : contactUserMap.values()) {
            if (contactUser.getNickname().equalsIgnoreCase(nickname)) {
                return contactUser;
            }
        }
        return null;
    }



}
