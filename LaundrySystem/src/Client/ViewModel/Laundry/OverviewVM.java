package Client.ViewModel.Laundry;

import Client.Model.LaundryReserve.WashingMachineModel;
import Shared.Model.Schedule;
import javafx.beans.property.StringProperty;

public class OverviewVM
{

  private final WashingMachineModel washingMachineModel;
  private StringProperty washingMachineId;

  public OverviewVM(WashingMachineModel washingMachineModel) {
    this.washingMachineModel = washingMachineModel;
  }


  public Schedule getWM1Schedule(){
    return washingMachineModel.getSchedule("washingMachine1");
  }

  public Schedule getWM2Schedule(){
    return washingMachineModel.getSchedule("washingMachine2");
  }

  public Schedule getWM3Schedule(){
    return washingMachineModel.getSchedule("washingMachine3");
  }

  public Schedule getWM4Schedule(){
    return washingMachineModel.getSchedule("washingMachine4");
  }

  public Schedule getWM5Schedule(){
    return washingMachineModel.getSchedule("washingMachine5");
  }

  public Schedule getWM6Schedule(){
    return washingMachineModel.getSchedule("washingMachine6");
  }

}
