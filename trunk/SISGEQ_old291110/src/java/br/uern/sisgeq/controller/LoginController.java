package br.uern.sisgeq.controller;

import br.uern.sisgeq.model.Login;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author rafael
 */
@ManagedBean(name="loginManagedBean")
@RequestScoped
public class LoginController {
    private Login login;

    public LoginController(){
        login = new Login();
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
