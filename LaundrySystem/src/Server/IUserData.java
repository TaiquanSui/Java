package Server;

import Client.Model.Administrator;
import Client.Model.Customer;

public interface IUserData
{
  void addCustomer(Customer customer);
  void addAdministrator(Administrator administrator);
  void changePassword(String Id, String np);
  void changeBalance(String balance);
  String getBan();
  void changeBan(boolean ban, int banPeriod);
}
