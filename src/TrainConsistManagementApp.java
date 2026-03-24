import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // ===== UC1 =====
        initializeTrain();

        // ===== UC2 =====
        roomInitialization();

        // ===== UC3 =====
        trackUniqueBogies();
    }

    // ===== UC1: Initialize Train and Display Consist Summary =====
    public static void initializeTrain() {

        System.out.println("=================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("=================================\n");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + trainConsist.size());
        System.out.println("Current Train Consist : " + trainConsist);

        System.out.println("\nSystem ready for operations...\n");
    }

    // ===== UC2: Room Initialization (OOP Concept) =====
    public static void roomInitialization() {

        System.out.println("=================================");
        System.out.println("Hotel Room Initialization");
        System.out.println("=================================\n");

        // Create room objects
        Room single = new SingleRoom();
        Room doubleroom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display details
        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable + "\n");

        System.out.println("Double Room:");
        doubleroom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable + "\n");

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable + "\n");
    }

    // ===== UC3: Track Unique Bogie IDs =====
    public static void trackUniqueBogies() {

        System.out.println("=================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("=================================\n");

        // HashSet stores only unique values
        Set<String> bogies = new HashSet<>();

        // Add bogie IDs (with duplicates)
        bogies.add("B101");
        bogies.add("B102");
        bogies.add("B103");
        bogies.add("B104");

        bogies.add("B101"); // duplicate
        bogies.add("B102"); // duplicate

        // Display result
        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies);

        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet");

        System.out.println("\nUC3 uniqueness validation completed...\n");
    }
}

// ===== ABSTRACT CLASS =====
abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}

// ===== SINGLE ROOM =====
class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

// ===== DOUBLE ROOM =====
class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

// ===== SUITE ROOM =====
class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}