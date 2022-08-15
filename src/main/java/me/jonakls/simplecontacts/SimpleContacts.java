package me.jonakls.simplecontacts;

import me.jonakls.simplecontacts.service.AccountsService;
import me.jonakls.simplecontacts.ui.LoginForm;

public class SimpleContacts {

    private static AccountsService accountsService;

    public static void main(String[] args) {
        accountsService = new AccountsService();

        new LoginForm(null);
    }

    public static AccountsService getAccountsService() {
        return accountsService;
    }

}
