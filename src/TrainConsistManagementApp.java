import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // ===== UC1 =====
        initializeTrain();

        // ===== UC2 =====
        roomInitialization();

        // ===== UC3 =====
        trackUniqueBogies();

        // ===== UC4 =====
        maintainOrderedConsist();

        // ===== UC5 =====
        preserveInsertionOrder();

        // ===== UC6 =====
        mapBogieCapacity();

        // ===== UC7 =====
        sortBogiesByCapacity();

        // ===== UC8 =====
        filterBogiesUsingStreams();
    }

    // ===== UC1 =====
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

    // ===== UC2 =====
    public static void roomInitialization() {

        System.out.println("=================================");
        System.out.println("Hotel Room Initialization");
        System.out.println("=================================\n");

        Room single = new SingleRoom();
        Room doubleroom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

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

    // ===== UC3 =====
    public static void trackUniqueBogies() {

        System.out.println("=================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("=================================\n");

        Set<String> bogies = new HashSet<>();

        bogies.add("B101");
        bogies.add("B102");
        bogies.add("B103");
        bogies.add("B104");

        bogies.add("B101");
        bogies.add("B102");

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies);

        System.out.println("\nDuplicates are ignored by HashSet");
        System.out.println("\nUC3 completed...\n");
    }

    // ===== UC4 =====
    public static void maintainOrderedConsist() {

        System.out.println("=================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("=================================\n");

        LinkedList<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist + "\n");

        trainConsist.add(2, "Pantry Car");

        System.out.println("After inserting Pantry Car:");
        System.out.println(trainConsist + "\n");

        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("After removing first & last:");
        System.out.println(trainConsist + "\n");

        System.out.println("UC4 completed...\n");
    }

    // ===== UC5 =====
    public static void preserveInsertionOrder() {

        System.out.println("=================================");
        System.out.println("UC5 - Preserve Insertion Order");
        System.out.println("=================================\n");

        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate

        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nUC5 completed...\n");
    }

    // ===== UC6 =====
    public static void mapBogieCapacity() {

        System.out.println("=================================");
        System.out.println("UC6 - Map Bogie Capacity");
        System.out.println("=================================\n");

        Map<String, Integer> capacityMap = new HashMap<>();

        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);

        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 completed...\n");
    }

    // ===== UC7 =====
    public static void sortBogiesByCapacity() {

        System.out.println("======================================");
        System.out.println("UC7 - Sort Bogies by Capacity");
        System.out.println("======================================\n");

        class Bogie {
            String name;
            int capacity;

            Bogie(String name, int capacity) {
                this.name = name;
                this.capacity = capacity;
            }
        }

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC7 completed...\n");
    }

    // ===== UC8 =====
    public static void filterBogiesUsingStreams() {

        System.out.println("======================================");
        System.out.println("UC8 - Filter Bogies Using Streams");
        System.out.println("======================================\n");

        class Bogie {
            String name;
            int capacity;

            Bogie(String name, int capacity) {
                this.name = name;
                this.capacity = capacity;
            }
        }

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC8 completed...\n");
    }
}

// ===== ROOM CLASSES =====
abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int beds, int size, double price) {
        numberOfBeds = beds;
        squareFeet = size;
        pricePerNight = price;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price: " + pricePerNight);
    }
}

class SingleRoom extends Room {
    public SingleRoom() { super(1, 250, 1500); }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super(2, 400, 2500); }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super(3, 750, 5000); }
}