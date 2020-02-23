package Shared.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Schedule
{
  private ArrayList<Reservation> reservations;
  private ArrayList<String> timeTable;


  public Schedule(ArrayList<Reservation> reservations){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    Reservation temp;

    for(int i=0; i<reservations.size(); i++){
      for (int j = i + 1; j < reservations.size(); j++)
      {
        if (reservations.get(i).getStartTime().compareTo(reservations.get(j).getStartTime()) == 1)
        {
          temp = reservations.get(i);
          reservations.get(i).setReservation(reservations.get(j));
          reservations.get(j).setReservation(temp);
        }
      }
    }

    for(int i=0; i<reservations.size(); i++){
      Calendar c1 = reservations.get(i).getStartTime();
      Calendar c2 = reservations.get(i).getEndTime();
      String time = sdf.format(c1) + " to " + sdf.format(c2) + "  " +reservations.get(i).getCustomer().getName();
      timeTable.add(time);
    }
  }



  public void addReservation(Reservation reservation){
    reservations.add(reservation);

    Reservation temp;

    for(int i=0; i<reservations.size(); i++){
      for (int j = i + 1; j < reservations.size(); j++)
      {
        if (reservations.get(i).getStartTime().compareTo(reservations.get(j).getStartTime()) == 1)
        {
          temp = reservations.get(i);
          reservations.get(i).setReservation(reservations.get(j));
          reservations.get(j).setReservation(temp);
        }
      }
    }
  }


  public ArrayList<Reservation> getReservations(){
    return reservations;
  }




  public boolean checkTime(Calendar c){
    for(int i = 0; i<timeTable.size(); i++){
      int compStart = c.compareTo(reservations.get(i).getStartTime());
      int compEnd = c.compareTo(reservations.get(i).getEndTime());

      if(compStart>0 && compEnd<0){
        return true;
      }
    }
    return false;
  }




  Calendar c = Calendar.getInstance();
  int year = c.get(Calendar.YEAR);
  int month = c.get(Calendar.MONTH)+1;
  int date = c.get(Calendar.DATE);
  int hour = c.get(Calendar.HOUR_OF_DAY);
  int minute = c.get(Calendar.MINUTE);
  int second = c.get(Calendar.SECOND);





}
