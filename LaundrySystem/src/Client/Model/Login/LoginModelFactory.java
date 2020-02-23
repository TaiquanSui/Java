package Client.Model.Login;

import Client.Networking.Client;
import Client.Networking.ClientImpl;

public class LoginModelFactory {

    private LoginModelImpl loginModel;

    public LoginModel getLoginModel() {
        // using lazy instantiation, meaning I only create the LoginModel, when it is asked for.
        // it is stored in a field variable, so the same instance can be reused again, and by multiple view models
        // This ensure all view models use the same instance of the model
        if(loginModel == null) {
            loginModel = new LoginModelImpl();
        }
        return loginModel;
    }
}
