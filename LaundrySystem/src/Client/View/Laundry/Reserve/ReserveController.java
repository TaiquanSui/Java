package Client.View.Laundry.Reserve;

import Client.View.Laundry.ViewHandlerLD;
import Client.ViewModel.Laundry.ReserveVM;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.Calendar;

public class ReserveController
{
  @FXML
  public TextField idTextField;
  @FXML
  public ComboBox<String> mode;
  @FXML
  public ComboBox<String> washingMachineId;
  @FXML
  public ComboBox<String> year;
  @FXML
  public ComboBox<String> month;
  @FXML
  public ComboBox<String> day;
  @FXML
  public ComboBox<String> hour;
  @FXML
  public ComboBox<String> minute;

  private ReserveVM reserveVM;
  private ViewHandlerLD viewHandlerLD;

  public void init(ReserveVM reserveVM,ViewHandlerLD viewHandlerLD) {
    this.reserveVM = reserveVM;
    this.viewHandlerLD = viewHandlerLD;

    month.getSelectionModel().selectedItemProperty().addListener(this::getDay);

    // making the bindings, so data can flow to the View Model, and back again, automatically.
    idTextField.textProperty().bindBidirectional(reserveVM.idProperty());
    mode.valueProperty().bindBidirectional(reserveVM.modeProperty());
    washingMachineId.valueProperty().bindBidirectional(reserveVM.washingMachineIdProperty());
    year.valueProperty().bindBidirectional(reserveVM.yearProperty());
    month.valueProperty().bindBidirectional(reserveVM.monthProperty());
    day.valueProperty().bindBidirectional(reserveVM.dayProperty());
    hour.valueProperty().bindBidirectional(reserveVM.hourProperty());
    minute.valueProperty().bindBidirectional(reserveVM.minuteProperty());

    mode.getItems().addAll("mode1","mode2","mode3","mode4");
    washingMachineId.getItems().addAll("washingMachine1","washingMachine2","washingMachine3","washingMachine4","washingMachine5","washingMachine6");
    year.getItems().addAll(getYears());
    month.getItems().addAll(getMonth());
    hour.getItems().addAll(getHours());
    minute.getItems().addAll(getMinutes());

    year.getSelectionModel().select(0);
    month.getSelectionModel().select(0);
    day.getSelectionModel().select(0);
    hour.getSelectionModel().select(0);
    minute.getSelectionModel().select(0);
  }

  public void onReserveButton(){
    String result = reserveVM.validateReservation();

    if("Ok".equals(result)){
      reserveVM.clearFields();
//    viewHandlerLD.openOverView();
      JOptionPane
          .showMessageDialog(null, "You have successfully send the reservation","", JOptionPane.INFORMATION_MESSAGE);
    }else {
      JOptionPane.showMessageDialog(null, result,"Password change failed", JOptionPane.ERROR_MESSAGE);
    }
  }




  private String[] getYears(){
    Calendar c = Calendar.getInstance();
    int currentYear = c.get(Calendar.YEAR);
    c.add(Calendar.DATE,14);
    int yearAfterTwoWeeks = c.get(Calendar.YEAR);


    if(currentYear == yearAfterTwoWeeks){
      String[] years = new String[1];
      years[0] = Integer.toString(currentYear);
      return years;
    }else {
      String[] years = new String[2];
      years[0] = Integer.toString(currentYear);
      years[1] = Integer.toString(yearAfterTwoWeeks);
      return years;
    }
  }

  private String[] getMonth(){
    Calendar c = Calendar.getInstance();
    int currentMonth = c.get(Calendar.MONTH) + 1;
    c.add(Calendar.DATE,14);
    int monthAfterTwoWeeks = c.get(Calendar.MONTH) + 1;


    if(currentMonth == monthAfterTwoWeeks){
      String[] months = new String[1];
      months[0] = Integer.toString(currentMonth);
      return months;
    }else {
      String[] months = new String[2];
      months[0] = Integer.toString(currentMonth);
      months[1] = Integer.toString(monthAfterTwoWeeks);
      return months;
    }
  }

  private void getDay(Observable observable, String old, String newVal){
    Calendar c = Calendar.getInstance();
    int currentDay = c.get(Calendar.DATE);
    int currentMonth = c.get(Calendar.MONTH);
    c.add(Calendar.DATE,14);
    int dayAfterTwoWeeks = c.get(Calendar.DATE);

    if(dayAfterTwoWeeks > currentDay){

      int dayNumbers = dayAfterTwoWeeks - currentDay + 1;

      String[] days = new String[dayNumbers];
      for(int i = 0; i < dayNumbers; i++){
        days[i] = Integer.toString(currentDay + i);
      }

      day.getItems().addAll(days);

    }else {

      int month = Integer.valueOf(newVal);

      if( Integer.valueOf(month) == currentMonth){
        int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayNumbers = maxDay-currentDay + 1;
        String[] days = new String[dayNumbers];
        for(int i = 0; i < dayNumbers; i++){
          days[i] = Integer.toString(currentDay + i);
        }

        day.getItems().addAll(days);

      }else {
        String[] days = new String[dayAfterTwoWeeks];

        for(int i = 0; i < dayAfterTwoWeeks; i++){
          days[i] = Integer.toString(i);
        }

        day.getItems().addAll(days);
      }
    }

  }




  private String[] getHours(){
    String[] hours = new String[24];
    for(int i = 0; i<24; i++){
      hours[i] = Integer.toString(i);
    }
    return hours;
  }


  private String[] getMinutes(){
    String[] minutes = new String[60];
    for(int i = 0; i<60; i++){
      minutes[i] = Integer.toString(i);
    }
    return minutes;
  }

  private void clearComboBox(){
    mode.getItems().clear();
    washingMachineId.getItems().clear();
    year.getItems().clear();
    month.getItems().clear();
    day.getItems().clear();
    hour.getItems().clear();
    minute.getItems().clear();
  }


}
