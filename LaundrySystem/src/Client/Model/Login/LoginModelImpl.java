package Client.Model.Login;

import Client.Model.Administrator;
import Client.Model.Customer;
import Client.Model.User;
import Client.Networking.Client;
import Server.Server;

public class LoginModelImpl implements LoginModel
{

    private Client client;

    public LoginModelImpl(Client client) {
        this.client = client;
    }

    @Override
    public String validateLogin(String Id, String password) {
        String result = checkLoginCredentials(Id, password);

        return result;
    }

    @Override
    public String changePassword(String Id, String pw, String newPw, String newPwAgain) {
        String result = checkUpdateNewPW(Id, pw, newPw, newPwAgain);

        if("OK".equals(result)) {
            // updating the password
            client.changePassword(Id,newPw);
        }

        return result;
    }

    @Override
    public String createUser(String name, String Id, String pw, String pwAgain, boolean isCustomer, boolean isAdministrator) {
        String result = attemptCreateUser(name, Id, pw, pwAgain);

        if("OK".equals(result)) {
            // adding the new user
            if(isAdministrator){
                client.createNewUser(new Administrator(name, Id, pw));
            }else if(isCustomer) {
                client.createNewUser(new Customer(name, Id, pw, false, null, 0));
            }
        }

        return result;
    }


    @Override
    public void registerClient(String Id){
        client.registerClient(Id);
    }







    private String checkLoginCredentials(String Id, String password) {
        User user = findUser(Id);
        if(user == null) {
            return "User not found";
        }
        if(!user.getPassword().equals(password)) {
            return "Incorrect password";
        }

        return "OK";
    }

    private User findUser(String Id) {
        User user = null;

//        to be implemented

        return user;
    }

    private String attemptCreateUser(String name, String Id, String pw, String pwAgain) {
        if(name == null) {
            return "Username cannot be empty";
        }
        if(findUser(Id) != null) {
            return "Username already exists";
        }

        // checking the passwords
        return validatePasswords(pw, pwAgain); // returning result of checking passwords
    }

    // method to check that two passwords are valid and matches
    private String validatePasswords(String pw, String pwAgain) {

        if(pw == null) {
            return "Password cannot be empty";
        }
        if(pw.length() < 8) {
            return "Password length must be 8 or more";
        }
        if(pw.length() > 14) {
            return "Password length must be 14 or less";
        }
        if(!pw.equals(pwAgain)) {
            return "Passwords do not match";
        }

        // verifying that the password contains at least one upper case character
        if(pw.equals(pw.toLowerCase())) {
            return "Password must contain at least one upper case letter";
        }

        // checking if there is a lower case letter in pw
        if (!pwContainsLowerCase(pw)){
            return "Password must contain at least one lower case letter";
        }

        // using regular expression to check that the password contains a number
        if(!pw.matches(".*\\d.*")) {
            return "Password must contain at least one number";
        }

        // if I reach this point, everything is okay.
        return "OK";
    }

    private boolean pwContainsLowerCase(String pw) {
        boolean foundLowerCase = false;
        for (int i = 0; i < pw.length(); i++) { // looping through all characters in the pw
            char c = pw.charAt(i);
            if(Character.isLowerCase(c)) { // checking if the character is lower case
                foundLowerCase = true;
                break;
            }
        }
        return foundLowerCase;
    }

    private String checkUpdateNewPW(String username, String pw, String newPw, String newPwAgain) {

        // check that username and pw is correct;
        if(!"OK".equals(checkLoginCredentials(username, pw))) {
            return "Incorrect login credentials";
        }

        // check that passwords are valid and matches
        return validatePasswords(newPw, newPwAgain);
    }
}
