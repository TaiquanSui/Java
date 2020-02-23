package Client.View.Laundry.Overview;

import Client.Model.LaundryReserve.SetState;
import Client.View.Laundry.ViewHandlerLD;
import Client.ViewModel.Laundry.OverviewVM;
import Shared.Model.Reservation;
import Shared.Model.Schedule;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.beans.PropertyChangeEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OverviewController
{
  @FXML
  private ImageView washingMachine1;
  @FXML
  private ImageView washingMachine2;
  @FXML
  private ImageView washingMachine3;
  @FXML
  private ImageView washingMachine4;
  @FXML
  private ImageView washingMachine5;
  @FXML
  private ImageView washingMachine6;
  @FXML
  private ListView<String> wm1Schedule;
  @FXML
  private ListView<String> wm2Schedule;
  @FXML
  private ListView<String> wm3Schedule;
  @FXML
  private ListView<String> wm4Schedule;
  @FXML
  private ListView<String> wm5Schedule;
  @FXML
  private ListView<String> wm6Schedule;

  private SetState setState1;
  private SetState setState2;
  private SetState setState3;
  private SetState setState4;
  private SetState setState5;
  private SetState setState6;
  private ViewHandlerLD viewHandlerLD;
  private OverviewVM overviewVM;


  public void init(ViewHandlerLD viewHandlerLD, OverviewVM overviewVM, SetState setState1, SetState setState2, SetState setState3, SetState setState4, SetState setState5, SetState setState6) {
    this.setState1 = setState1;
    this.setState2 = setState2;
    this.setState3 = setState3;
    this.setState4 = setState4;
    this.setState5 = setState5;
    this.setState6 = setState6;
    this.viewHandlerLD = viewHandlerLD;
    this.overviewVM =overviewVM;

    setState1.addListener("StateOfWashingMachine1",this::setImage1);
    setState2.addListener("StateOfWashingMachine2",this::setImage2);
    setState3.addListener("StateOfWashingMachine3",this::setImage3);
    setState4.addListener("StateOfWashingMachine4",this::setImage4);
    setState5.addListener("StateOfWashingMachine5",this::setImage5);
    setState6.addListener("StateOfWashingMachine6",this::setImage6);
  }







  private void setImage1(PropertyChangeEvent propertyChangeEvent)
  {
    String result = (String)propertyChangeEvent.getNewValue();
    if(result.equals("available")){
      washingMachine1.setImage(new Image("file:washingMachineAvailable.png"));
    }else if(result.equals("running")){
      washingMachine1.setImage(new Image("file:washingMachineRunning.png"));
    }else if(result.equals("broken")){
      washingMachine1.setImage(new Image("file:washingMachineBroken.png"));
    }else if(result.equals("offline")){
      washingMachine1.setImage(new Image("file:washingMachineOffline.png"));
    }
  }

  private void setImage2(PropertyChangeEvent propertyChangeEvent)
  {
    String result = (String)propertyChangeEvent.getNewValue();
    if(result.equals("available")){
      washingMachine2.setImage(new Image("file:washingMachineAvailable.png"));
    }else if(result.equals("running")){
      washingMachine2.setImage(new Image("file:washingMachineRunning.png"));
    }else if(result.equals("broken")){
      washingMachine2.setImage(new Image("file:washingMachineBroken.png"));
    }else if(result.equals("offline")){
      washingMachine2.setImage(new Image("file:washingMachineOffline.png"));
    }
  }

  private void setImage3(PropertyChangeEvent propertyChangeEvent)
  {
    String result = (String)propertyChangeEvent.getNewValue();
    if(result.equals("available")){
      washingMachine3.setImage(new Image("file:washingMachineAvailable.png"));
    }else if(result.equals("running")){
      washingMachine3.setImage(new Image("file:washingMachineRunning.png"));
    }else if(result.equals("broken")){
      washingMachine3.setImage(new Image("file:washingMachineBroken.png"));
    }else if(result.equals("offline")){
      washingMachine3.setImage(new Image("file:washingMachineOffline.png"));
    }
  }

  private void setImage4(PropertyChangeEvent propertyChangeEvent)
  {
    String result = (String)propertyChangeEvent.getNewValue();
    if(result.equals("available")){
      washingMachine4.setImage(new Image("file:washingMachineAvailable.png"));
    }else if(result.equals("running")){
      washingMachine4.setImage(new Image("file:washingMachineRunning.png"));
    }else if(result.equals("broken")){
      washingMachine4.setImage(new Image("file:washingMachineBroken.png"));
    }else if(result.equals("offline")){
      washingMachine4.setImage(new Image("file:washingMachineOffline.png"));
    }
  }

  private void setImage5(PropertyChangeEvent propertyChangeEvent)
  {
    String result = (String)propertyChangeEvent.getNewValue();
    if(result.equals("available")){
      washingMachine5.setImage(new Image("file:washingMachineAvailable.png"));
    }else if(result.equals("running")){
      washingMachine5.setImage(new Image("file:washingMachineRunning.png"));
    }else if(result.equals("broken")){
      washingMachine5.setImage(new Image("file:washingMachineBroken.png"));
    }else if(result.equals("offline")){
      washingMachine5.setImage(new Image("file:washingMachineOffline.png"));
    }
  }

  private void setImage6(PropertyChangeEvent propertyChangeEvent)
  {
    String result = (String)propertyChangeEvent.getNewValue();
    if(result.equals("available")){
      washingMachine6.setImage(new Image("file:washingMachineAvailable.png"));
    }else if(result.equals("running")){
      washingMachine6.setImage(new Image("file:washingMachineRunning.png"));
    }else if(result.equals("broken")){
      washingMachine6.setImage(new Image("file:washingMachineBroken.png"));
    }else if(result.equals("offline")){
      washingMachine6.setImage(new Image("file:washingMachineOffline.png"));
    }
  }


  public void setWmSchedule(){
    //WashingMachine1
    Schedule schedule1 = overviewVM.getWM1Schedule();
    ObservableList<String> timeList1 = FXCollections.observableArrayList();
    for(int i = 0; i<schedule1.getReservations().size(); i++){
      Reservation reservation = schedule1.getReservations().get(i);
      String timePeriod = getTimePeriod(reservation.getStartTime(),reservation.getEndTime());
      timeList1.add(timePeriod);
    }
    wm1Schedule = new ListView<>(timeList1);
    wm1Schedule.setItems(timeList1);


    //WashingMachine2
    Schedule schedule2 = overviewVM.getWM2Schedule();
    ObservableList<String> timeList2 = FXCollections.observableArrayList();
    for(int i = 0; i<schedule2.getReservations().size(); i++){
      Reservation reservation = schedule2.getReservations().get(i);
      String timePeriod = getTimePeriod(reservation.getStartTime(),reservation.getEndTime());
      timeList2.add(timePeriod);
    }
    wm2Schedule = new ListView<>(timeList2);
    wm2Schedule.setItems(timeList2);


    //WashingMachine3
    Schedule schedule3 = overviewVM.getWM3Schedule();
    ObservableList<String> timeList3 = FXCollections.observableArrayList();
    for(int i = 0; i<schedule3.getReservations().size(); i++){
      Reservation reservation = schedule3.getReservations().get(i);
      String timePeriod = getTimePeriod(reservation.getStartTime(),reservation.getEndTime());
      timeList3.add(timePeriod);
    }
    wm3Schedule = new ListView<>(timeList3);
    wm3Schedule.setItems(timeList3);


    //WashingMachine4
    Schedule schedule4 = overviewVM.getWM4Schedule();
    ObservableList<String> timeList4 = FXCollections.observableArrayList();
    for(int i = 0; i<schedule4.getReservations().size(); i++){
      Reservation reservation = schedule4.getReservations().get(i);
      String timePeriod = getTimePeriod(reservation.getStartTime(),reservation.getEndTime());
      timeList4.add(timePeriod);
    }
    wm4Schedule = new ListView<>(timeList4);
    wm4Schedule.setItems(timeList4);


    //WashingMachine5
    Schedule schedule5 = overviewVM.getWM5Schedule();
    ObservableList<String> timeList5 = FXCollections.observableArrayList();
    for(int i = 0; i<schedule5.getReservations().size(); i++){
      Reservation reservation = schedule5.getReservations().get(i);
      String timePeriod = getTimePeriod(reservation.getStartTime(),reservation.getEndTime());
      timeList5.add(timePeriod);
    }
    wm5Schedule = new ListView<>(timeList5);
    wm5Schedule.setItems(timeList5);


    //WashingMachine6
    Schedule schedule6 = overviewVM.getWM6Schedule();
    ObservableList<String> timeList6 = FXCollections.observableArrayList();
    for(int i = 0; i<schedule6.getReservations().size(); i++){
      Reservation reservation = schedule6.getReservations().get(i);
      String timePeriod = getTimePeriod(reservation.getStartTime(),reservation.getEndTime());
      timeList6.add(timePeriod);
    }
    wm6Schedule = new ListView<>(timeList6);
    wm6Schedule.setItems(timeList6);
  }


  private String getTimePeriod(Calendar startTime, Calendar endTime){
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    String timePeriod = sdf.format(startTime) + " - " + sdf.format(endTime);

    return timePeriod;
  }




}
