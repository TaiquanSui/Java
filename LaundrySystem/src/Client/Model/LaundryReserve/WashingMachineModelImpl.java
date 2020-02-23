package Client.Model.LaundryReserve;

import Server.Server;
import Shared.Model.Reservation;
import Shared.Model.Schedule;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class WashingMachineModelImpl implements WashingMachineModel
{

  private ArrayList<Reservation> reservations;
  private SetState setState;
  private Server server;
  protected PropertyChangeSupport support = new PropertyChangeSupport(this);

  public WashingMachineModelImpl(){

  }

  public void addListener(String name, PropertyChangeListener listener) {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public String setState(String washingMachineId, String state)
  {
    return "";
  }

  @Override public Schedule getSchedule(String washingMachineId)
  {
    return null;
  }
}
