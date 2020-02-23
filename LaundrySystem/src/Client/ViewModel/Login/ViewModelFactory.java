package Client.ViewModel.Login;

import Client.Model.Login.LoginModelFactory;

public class ViewModelFactory {
    private final LoginModelFactory modelFactory;
    private LoginVM loginVM;
    private CreateUserVM createUserVM;
    private ChangePasswordVM changePasswordVM;

    public ViewModelFactory(LoginModelFactory mf) {
        this.modelFactory = mf;
    }

    public LoginVM getLoginVM() {
        // using lazy instantiation, to ensure only one LoginVM is created, and it can subsequently be reused
        // I could also have instantiated them in modelimpls constructor
        if(loginVM == null) {
            loginVM = new LoginVM(modelFactory.getLoginModel());
        }
        return loginVM;
    }

    public CreateUserVM getCreateUserVM() {
        if(createUserVM == null) {
            createUserVM = new CreateUserVM(modelFactory.getLoginModel());
        }
        return createUserVM;
    }

    public ChangePasswordVM getChangePasswordVM() {
        if(changePasswordVM == null) {
            changePasswordVM = new ChangePasswordVM(modelFactory.getLoginModel());
        }
        return changePasswordVM;
    }
}
