package FlightControl.ui;

import java.util.Scanner;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.logic.FlightControl;

public class UserInterface {
    
    FlightControl flightControl;
    Scanner scanner;

    public UserInterface(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
        start();
    }

    public void start() {
        startAssetControl();
        System.out.println();
        startFlightControl();
        
    }

    public void startAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");

            String userInput = this.scanner.nextLine();

            switch (userInput) {
                case "1":
                    addAirplane();
                    break;
                case "2":
                    addFlight();
                    break;
                case "x":
                    return;
                default:
                    break;
            }
        }
        
    }

    private void addAirplane() {
        System.out.print("Give the airplane id: ");
        String planeId = this.scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int planeCapacity = Integer.parseInt(this.scanner.nextLine());
        this.flightControl.addAirplane(planeId, planeCapacity);
    }

    private void addFlight() {
        String planeId = askForAirplane();

        System.out.print("Give the departure airport id: ");
        String departureId = this.scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destinationId = this.scanner.nextLine();

        this.flightControl.addFlight(
            this.flightControl.getAirplane(planeId), departureId, destinationId
        );
    }

    public void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");

            String userInput = this.scanner.nextLine();

            switch (userInput) {
                case "1":
                    printAirplanes();
                    break;
                case "2":
                    printFlights();
                    break;
                case "3":
                    printAirPlaneDetails();
                    break;
                case "x":
                    return;
                default:
                    continue;
            }
        }
    }

    public void printAirplanes() {
        this.flightControl.getAirplanes().stream()
            .forEach(plane -> System.out.println(plane));
    }

    public void printFlights() {
        this.flightControl.getFlights().stream()
            .forEach(flight -> System.out.println(flight));
    }

    public void printAirPlaneDetails() {
        String planeId = askForAirplane();
        System.out.println(this.flightControl.getAirplane(planeId));
    }

    public String askForAirplane() {
        System.out.print("Give the airplane id: ");
        String planeId = this.scanner.nextLine();
        while (this.flightControl.getAirplane(planeId) == null) {
            System.out.println("No airplane with the id " + planeId + ".");
            System.out.print("Give the airplane id: ");
            planeId = this.scanner.nextLine();
        }
        return planeId;
    }

}
