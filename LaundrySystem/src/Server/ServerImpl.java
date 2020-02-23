package Server;

import Client.Model.Customer;
import Client.Model.User;
import Client.Networking.Client;
import Server.persistence.DBAdder;
import Server.persistence.DBGetter;
import Shared.Model.Message;
import Shared.Model.Reservation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ServerImpl implements Server
{
  private ArrayList<ClientContainer> clients;
  private DBAdder dbAdder;
  private DBGetter dbGetter;


  public ServerImpl(DBAdder dbAdder, DBGetter dbGetter) throws RemoteException {
    UnicastRemoteObject.exportObject(this, 0);
    clients = new ArrayList<>();

    this.dbAdder = dbAdder;
    this.dbGetter = dbGetter;
  }

  @Override
  public boolean registerClient(Client cc, java.lang.String name) {

    // checking to see if username is taken

    for (ClientContainer client : clients) {
      if(client.name.equals(name)) return false;
    }

    clients.add(new ClientContainer(name, cc));

    return true;
  }

  @Override public ArrayList<Message> getMessages(String clientID)
  {
    return dbGetter.getMessages(clientID);
  }

  @Override public String getWashingMachine(java.lang.String stringID)
  {
    return null;
  }

  @Override public Customer getCustomer(java.lang.String CustomerId)
  {
    return null;
  }

  @Override public void cancelReservation(Reservation reservation)
  {

  }

  @Override public void createNewUser(User user)
  {

  }

  @Override public void changePassword(java.lang.String Id,
      java.lang.String newPw)
  {

  }

  @Override
  public void sendMessage(java.lang.String msg, java.lang.String name) {

    //looping through all connected clients

    for (ClientContainer client : clients) {
      if(client.name.equals(name)) continue;

      try {
        client.client.receiveMessage(msg, name);
      } catch (RemoteException e) {
        e.printStackTrace();
      }
    }
  }





  @Override
  public void logout(java.lang.String name) {
    Client toRemove = null;
    for (ClientContainer client : clients) {
      if(client.name.equals(name)) toRemove = client.client;
    }
    clients.remove(toRemove);
  }

  private class ClientContainer {
    java.lang.String name;
    Client client;

    ClientContainer(java.lang.String name, Client client) {
      this.name = name;
      this.client = client;
    }
  }
}
