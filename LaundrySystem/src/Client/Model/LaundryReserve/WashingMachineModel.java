package Client.Model.LaundryReserve;

import Shared.Model.Schedule;

import java.beans.PropertyChangeListener;

public interface WashingMachineModel
{
  void addListener(String name, PropertyChangeListener listener);

  String setState(String washingMachineId, String state);

  Schedule getSchedule(String washingMachineId);
}
