package Client.ViewModel.Laundry;

import Client.Model.LaundryReserve.ReserveModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReserveVM {

    private final ReserveModel reserveModel;
    private StringProperty Id = new SimpleStringProperty();
    private StringProperty mode = new SimpleStringProperty();
    private StringProperty washingMachineId = new SimpleStringProperty();
    private StringProperty year = new SimpleStringProperty();
    private StringProperty month = new SimpleStringProperty();
    private StringProperty day = new SimpleStringProperty();
    private StringProperty hour = new SimpleStringProperty();
    private StringProperty minute = new SimpleStringProperty();

    public ReserveVM(ReserveModel reserveModel) {
        this.reserveModel = reserveModel;
    }


    public String validateReservation(){
        String result = reserveModel.validateReservation(Id.getValue(),mode.getValue(), washingMachineId.getValue(),getStartTime());

        return result;
    }

    // method to clear the data in the properties
    public void clearFields() {
        Id.setValue("");
        mode.setValue("");
        washingMachineId.setValue("");
        year.setValue("");
        month.setValue("");
        day.setValue("");
        hour.setValue("");
        minute.setValue("");
    }


    public StringProperty idProperty()
    {
        return Id;
    }

    public StringProperty modeProperty()
    {
        return mode;
    }

    public StringProperty washingMachineIdProperty() { return washingMachineId; }

    public StringProperty yearProperty() { return year; }

    public StringProperty monthProperty() { return month; }

    public StringProperty dayProperty() { return day; }

    public StringProperty hourProperty() { return hour; }

    public StringProperty minuteProperty() { return minute; }


    private String getStartTime(){
        String startTime = "";
        startTime+= year.getValue();
        startTime+= month.getValue();
        startTime+= day.getValue();
        startTime+= hour.getValue();
        startTime+= minute.getValue();
        return startTime;
    }






}
