package Shared.Model;

import Client.Model.Customer;

import java.util.Calendar;

public class Reservation
{
  private Customer customer;
  private Mode mode;
  private String washingMachineId;
  private Calendar startTime;
  private Calendar endTime;
  private boolean isAccepted;

  public Reservation(Customer customer, Mode mode, String washingMachineId, Calendar startTime, boolean isAccepted){
    this.customer = customer;
    this.mode = mode;
    this.washingMachineId = washingMachineId;
    this.startTime = startTime;
    this.endTime = startTime;
    endTime.add(Calendar.MINUTE, mode.getMin());
    this.isAccepted = isAccepted;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public void setMode(Mode mode)
  {
    this.mode = mode;
  }

  public void setWashingMachineId(String washingMachineId)
  {
    this.washingMachineId = washingMachineId;
  }

  public void setStartTime(Calendar startTime)
  {
    this.startTime = startTime;
  }

  public void setEndTime(Calendar endTime)
  {
    this.endTime = endTime;
  }

  public void setAccepted(boolean accepted) {
    isAccepted = accepted;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Mode getMode()
  {
    return mode;
  }

  public String getWashingMachineId()
  {
    return washingMachineId;
  }

  public Calendar getStartTime()
  {
    return startTime;
  }

  public Calendar getEndTime()
  {
    return endTime;
  }

  public boolean isAccepted() {
    return isAccepted;
  }

  public void setReservation(Reservation reservation){
    this.customer = reservation.getCustomer();
    this.washingMachineId = reservation.getWashingMachineId();
    this.startTime = reservation.getStartTime();
    this.endTime = reservation.getEndTime();
  }

  public boolean equals(Reservation reservation)
  {
    return isAccepted == reservation.isAccepted && customer.equals(reservation.customer)
        && mode == reservation.mode && washingMachineId
        .equals(reservation.washingMachineId)
        && startTime.equals(reservation.startTime) && endTime.equals(reservation.endTime);
  }



}
