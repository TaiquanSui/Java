package Client.Model.LaundryReserve;

import Shared.Model.Reservation;

public interface ReserveModel {

    String validateReservation(String Id, String mode, String washingMachine, String startTime);

    void cancelReservation(Reservation reservation);

}
