/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uern.sisgeq.controller;

import br.uern.sisgeq.model.Login;

/**
 *
 * @author rafael
 */
public class LoginManagedBean {
    private Login login;

    public LoginManagedBean(){
        login = new Login();
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
