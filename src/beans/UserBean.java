package beans;

import dao.UserDAO;
import model.User;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by eugeny on 13.11.2016.
 */
@Named
@SessionScoped
public class UserBean implements Serializable {
    @EJB
    UserDAO userDAO;

    private String login;
    private String password;
    private boolean authorized;
    private String userLogin;

    public String getUserLogin() {
        return userLogin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public String check(){
        if (authorized) return "success";
        User user = userDAO.find(login);
        if (user != null && user.getPassword().equals(password)) {
            authorized = true;
            userLogin = login;
            return "success";
        } else {
            return "fail";
        }
    }

    public List<User> getUsers() {
        return userDAO.findAll();
    }
}
