package Client.Networking;

import java.io.IOException;
import java.rmi.NotBoundException;

public class ClientMain
{
  public static void main(String[] args) {
    try {
      ClientImpl cci = new ClientImpl();
    } catch (IOException | NotBoundException e) {
      e.printStackTrace();
    }
  }
}
