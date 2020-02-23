package Client.Networking;

import Client.Model.Customer;
import Client.Model.User;
import Server.Server;
import Shared.Model.Message;
import Shared.Model.Reservation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ClientImpl implements Client {
  private Server server;
  private String id;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);


  public ClientImpl() throws RemoteException, NotBoundException
  {
    UnicastRemoteObject.exportObject(this, 0);
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    Server server = (Server)registry.lookup("ChatServer");
  }

  public void addListener(String name, PropertyChangeListener listener) {
    support.addPropertyChangeListener(name, listener);
  }


  public void registerClient(String id){
    server.registerClient(this,id);
    this.id = id;
  }


  @Override
  public void sendMessage(String msg, String name) {

  }

  @Override
  public void receiveMessage(String msg, String name) throws RemoteException {
    while(true){
      ArrayList<Message> messages = server.getMessages(id);
      int numberOfMessages = messages.size();
    }

  }







  @Override public String getWashingMachine(String stringID)
  {
    return null;
  }

  @Override public Customer getCustomer(String CustomerId)
  {
    return null;
  }

  @Override public void cancelReservation(Reservation reservation)
  {

  }

  @Override public void createNewUser(User user)
  {

  }

  @Override public void changePassword(String Id, String newPw)
  {

  }





}
