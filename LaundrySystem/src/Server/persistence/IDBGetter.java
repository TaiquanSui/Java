package Server.persistence;

import Client.Model.Customer;
import Shared.Model.Reservation;

import java.util.ArrayList;

public interface IDBGetter
{
  ArrayList<Reservation> getReservations(String washingMachineId);

  Customer getCustomer(String CustomerId);

}
