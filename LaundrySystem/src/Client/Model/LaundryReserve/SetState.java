package Client.Model.LaundryReserve;

import Shared.Model.Reservation;
import Shared.Model.State;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Calendar;

public class SetState implements Runnable
{
  private String string;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public SetState(String string){
    this.string = string;
  }

  public void addListener(java.lang.String name, PropertyChangeListener listener) {
    support.addPropertyChangeListener(name, listener);
  }


  @Override public void run()
  {
    java.lang.String result = setState(string);

    support.firePropertyChange(propertyName(), "", result);
  }


  private java.lang.String propertyName(){
    java.lang.String propertyName = "StateOfWashingMachine";
    propertyName+= string.getId();

    return propertyName;
  }


  private java.lang.String setState(String string)
  {
    if(string.getState().getState().equals("broken")){
      try
      {
        Thread.sleep(600000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      return "broken";
    }else if(string.getState().getState().equals("offline")){
      try
      {
        Thread.sleep(600000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      return "offline";
    }else {
      ArrayList<Reservation> reservations = string.getSchedule().getReservations();

      for (int i = 0; i < reservations.size(); i++)
      {

        Calendar c = Calendar.getInstance();

        int compStart = c.compareTo(reservations.get(i).getStartTime());
        int compEnd = c.compareTo(reservations.get(i).getEndTime());

        if ((compStart > 0 && compEnd < 0))
        {
          string.setState(State.runing);
          return "running";
        }
      }
      return "available";
    }

  }


}
