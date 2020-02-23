package Server.persistence;

import Client.Model.Customer;
import Shared.Model.Message;
import Shared.Model.Mode;
import Shared.Model.Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DBGetter implements IDBGetter
{
  private String url = "jdbc:postgresql://localhost:5432/postgres";
  private String user = "postgres";
  private String password = "stq20000409";





  @Override
  public Customer getCustomer(String CustomerId){
    Connection c = null;
    Statement stmt = null;

    Customer customer =null;

    try {
      Class.forName("org.postgresql.Driver");

      //don't forget to change localhost and password
      c = DriverManager.getConnection(url, user, password);
      c.setAutoCommit(false);
      System.out.println("Opened Car database successfully");

      stmt = c.createStatement();
      ResultSet rs;

      String sql = "SELECT * FROM \"laundrySystemschema\".Customer " + "WHERE CustomerId  = '" + CustomerId  + "'";
      rs = stmt.executeQuery(sql);
      System.out.println("------------CUSTOMER-------------");



      while (rs.next()) {
        String Name = rs.getString("Name");
        String Password  = rs.getString("Password ");
        boolean ban = rs.getBoolean("Ban");
        Calendar endTimeOfBan = getTime(rs.getString("EndTimeOfBan"));
        int Balance = rs.getInt("Balance");

        customer = new Customer(Name, CustomerId, Password, ban, endTimeOfBan, Balance);
        System.out.println("get Customer database successfully: " + customer);
      }
      c.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    return customer;
  }




  @Override
  public ArrayList<Reservation> getReservations(String washingMachineId) {
    Connection c = null;
    Statement stmt = null;

    try {
      Class.forName("org.postgresql.Driver");

      //don't forget to change localhost and password
      c = DriverManager.getConnection(url, user, password);
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs;

      String sql = "SELECT * FROM \"laundrySystemschema\".Reservation" + "WHERE WashingmachineId = '" + washingMachineId + "'";
      rs = stmt.executeQuery(sql);
      System.out.println("------------Reservation-------------");

      ArrayList<Reservation> reservations = new ArrayList<>();
      while (rs.next()) {
        Customer customer = getCustomer(rs.getString("CustomerID"));
        Calendar startTimeDate  = getTime(rs.getString("StartTimeDate"));
        Calendar endTimeDate  = getTime(rs.getString("EndTimeDate"));
        Mode mode = null;
        switch (rs.getString("Mode")){
          case "1" :
            mode =Mode.mode1;
            break;
          case "2" :
            mode =Mode.mode2;
          case "3" :
            mode =Mode.mode3;
            break;
          case "4" :
            mode =Mode.mode4;
            break;
        }
        boolean acceptance = rs.getBoolean("Acceptance");

        Reservation reservation = new Reservation(customer, mode, washingMachineId, startTimeDate, acceptance);
        System.out.println("get Reservation database successfully: " + reservation);

        reservations.add(reservation);

      }
      c.close();
      return reservations;
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    return null;
  }



  public ArrayList<Message> getMessages(String receiverID) {
    Connection c = null;
    Statement stmt = null;

    try {
      Class.forName("org.postgresql.Driver");

      //don't forget to change localhost and password
      c = DriverManager.getConnection(url, user, password);
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs;

      String sql = "SELECT * FROM \"laundrySystemschema\".Message" + "WHERE receiverID = '" + receiverID + "' AND read = 0" ;
      rs = stmt.executeQuery(sql);
      System.out.println("------------Messages-------------");

      ArrayList<Message> messages = new ArrayList<>();
      while (rs.next()) {
        String senderID= rs.getString("senderID");
        String text = rs.getString("text");
        String date = rs.getString("date");
        boolean isread = rs.getBoolean("read");

        Message message = new Message(text, date, senderID, receiverID, isread);
        System.out.println("get Reservation database successfully: " + message);

        messages.add(message);
      }
      c.close();
      return messages;
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    return null;
  }









  private Calendar getTime(String startTime){
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



