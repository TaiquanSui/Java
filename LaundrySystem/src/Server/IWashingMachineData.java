package Server;

import Shared.Model.Reservation;
import Shared.Model.State;

public interface IWashingMachineData
{
  void addReservation(Reservation reservation);
  void cancelReservation(Reservation reservation);
  void setState(State state);
  void changeNote();
}
