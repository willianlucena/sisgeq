package br.uern.sisgeq.controller;

import br.uern.sisgeq.model.Login;

/**
 *
 * @author rafael
 */
public class LoginMB {
    private Login login;

    public LoginMB(){
        login = new Login();
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
