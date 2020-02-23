package Client.Model.Login;

import java.beans.PropertyChangeListener;

public interface LoginModel
{

    String validateLogin(String username, String password);

    String createUser(String name, String Id, String pw, String pwAgain, boolean isCustomer, boolean isAdministrator);

    String changePassword(String username, String pw, String newPw, String newPwAgain);

    void registerClient(String Id);

}
