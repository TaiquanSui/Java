package Client.Model.LaundryReserve;

import Client.Model.Customer;
import Server.Server;
import Shared.Model.Mode;
import Shared.Model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ReserveModelImpl implements ReserveModel
{

    protected ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    private Customer customer;
    private Server server;

    public ReserveModelImpl(){}

    public void setServer(Server server){
        this.server = server;
    }

    @Override
    public String validateReservation(String Id, String mode, String washingMachineID, String startTime) {
        this.customer = server.getCustomer(Id);
        Reservation reservation = new Reservation(customer, getMode(mode), washingMachineID, getStartTime(startTime), false);

        String result = ifReservationApproved(reservation);

        return result;
    }


    @Override public void cancelReservation(Reservation reservation)
    {
        server.cancelReservation(reservation);
    }








    private String ifReservationApproved(Reservation reservation){

        if(customer.getEndTimeOfBan().compareTo(getCurrentTime())>0){
            return "You are banned";
        }

        if(reservation.getStartTime().compareTo(getCurrentTime())<0){
            return "The time is before current time!";
        }


        for(int i = 0; i<reservations.size(); i++){
            int startCompStart = reservation.getStartTime().compareTo(reservations.get(i).getStartTime());
            int startCompEnd = reservation.getStartTime().compareTo(reservations.get(i).getEndTime());

            int endCompStart = reservation.getStartTime().compareTo(reservations.get(i).getStartTime());
            int endCompEnd = reservation.getStartTime().compareTo(reservations.get(i).getEndTime());

            if((startCompStart>0 && startCompEnd<0) || (endCompStart>0 && endCompEnd<0)){
                return "The period or part of the period is taken";
            }
        }

        Calendar currentTimeAddOneMonth = getCurrentTime();
        currentTimeAddOneMonth.add(Calendar.MONTH,1);

        if(reservation.getStartTime().compareTo(currentTimeAddOneMonth)>0){
            return "You cant reserve date after one month from now";
        }

        return "You can reserve this time period";
    }


    private Calendar getCurrentTime(){
        Calendar c = Calendar.getInstance();
        return c;
    }

    private Mode getMode(String mode){
        if(mode.equals("mode1")){
            return Mode.mode1;
        }
        if(mode.equals("mode2")){
            return Mode.mode2;
        }
        if(mode.equals("mode3")){
            return Mode.mode3;
        }
        if(mode.equals("mode4")){
            return Mode.mode4;
        }
        return null;
    }

    private Calendar getStartTime(String startTime){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        try
        {
            cal.setTime(sdf.parse(startTime));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return cal;
    }





}

