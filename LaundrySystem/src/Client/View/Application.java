package Client.View;

import Client.Model.Login.LoginModelFactory;
import Client.View.Login.ViewHandlerLogin;
import Client.ViewModel.Login.ViewModelFactory;
import javafx.stage.Stage;

public class Application extends javafx.application.Application
{

    @Override
    public void start(Stage stage) throws Exception {
      // creating the core classes, that are needed.
      // If I had a client, I would create it here too, and hand over to the ModelFactory

      LoginModelFactory mf = new LoginModelFactory();
      ViewModelFactory vmf = new ViewModelFactory(mf);
      ViewHandlerLogin vh = new ViewHandlerLogin(vmf);
      vh.start();
    }

    @Override
    public void stop() throws Exception {
      // This method is called, when the application is shut down
      System.out.println("Shutting down.");
    }

}
