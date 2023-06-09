package FlightControl;

import java.util.Scanner;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;
import FlightControl.logic.FlightControl;
import FlightControl.ui.UserInterface;

public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.

        Scanner scanner = new Scanner(System.in);
        FlightControl flightControl = new FlightControl();

        UserInterface ui = new UserInterface(flightControl, scanner);


    }
}
