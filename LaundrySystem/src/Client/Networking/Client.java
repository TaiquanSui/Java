package Client.Networking;

import Client.Model.Customer;
import Client.Model.User;
import Shared.Model.Reservation;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote
{
  void registerClient(java.lang.String id);
  void receiveMessage(java.lang.String msg, java.lang.String name) throws RemoteException;
  void sendMessage(java.lang.String msg, java.lang.String name);
  String getWashingMachine(java.lang.String stringID);
  Customer getCustomer(java.lang.String CustomerId);
  void cancelReservation(Reservation reservation);
  void changePassword(java.lang.String Id, java.lang.String newPw);
  void createNewUser(User user);
}
