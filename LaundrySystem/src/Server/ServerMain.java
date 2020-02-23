package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain
{
    public static void main(String[] args) {
      try {
        ServerImpl server = new ServerImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", server);
        System.out.println("Server started");
      } catch (RemoteException | AlreadyBoundException e) {
        e.printStackTrace();
      }
    }
}
