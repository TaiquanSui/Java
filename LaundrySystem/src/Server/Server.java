package Server;

import Client.Model.Customer;
import Client.Model.User;
import Client.Networking.Client;
import Shared.Model.Message;
import Shared.Model.Reservation;

import java.rmi.Remote;
import java.util.ArrayList;

public interface Server extends Remote
{
  boolean registerClient(Client cc, java.lang.String name);
  ArrayList<Message> getMessages(String clientID);
  void sendMessage(java.lang.String msg, java.lang.String name);
  void logout(java.lang.String name);
  String getWashingMachine(java.lang.String stringID);
  Customer getCustomer(java.lang.String CustomerId);
  void cancelReservation(Reservation reservation);
  void changePassword(java.lang.String Id, java.lang.String newPw);
  void createNewUser(User user);
}
