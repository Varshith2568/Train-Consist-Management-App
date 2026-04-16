import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        initializeTrain();
        roomInitialization();
        trackUniqueBogies();
        maintainOrderedConsist();
        preserveInsertionOrder();
        mapBogieCapacity();
        sortBogiesByCapacity();
        filterBogiesUsingStreams();
    }

    public static void initializeTrain() {
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial Bogie Count: " + trainConsist.size());
    }

    public static void roomInitialization() {
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        single.displayRoomDetails();
        doubleRoom.displayRoomDetails();
        suite.displayRoomDetails();
    }

    public static void trackUniqueBogies() {
        Set<String> bogies = new HashSet<>();
        bogies.add("B101");
        bogies.add("B102");
        bogies.add("B101");

        System.out.println("Bogie IDs:");
        System.out.println(bogies);
 feature/UC8
        System.out.println("Duplicates ignored");


        System.out.println("\nDuplicates are ignored by HashSet");
        System.out.println("\nUC3 completed...\n");
 main
    }

    public static void maintainOrderedConsist() {
        LinkedList<String> train = new LinkedList<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial Train:");
        System.out.println(train);

        train.add(2, "Pantry");

        System.out.println("\nAfter adding Pantry:");
        System.out.println(train);

        train.removeFirst();
        train.removeLast();

        System.out.println("\nAfter removing first & last:");
        System.out.println(train);
    }

    public static void preserveInsertionOrder() {
 feature/UC8


        System.out.println("=================================");
        System.out.println("UC5 - Preserve Insertion Order");
        System.out.println("=================================\n");

main
        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate

        System.out.println("Final Formation:");
        System.out.println(formation);
    }

    public static void mapBogieCapacity() {
feature/UC8
        Map<String, Integer> map = new HashMap<>();


        System.out.println("=================================");
        System.out.println("UC6 - Map Bogie Capacity");
        System.out.println("=================================\n");

        Map<String, Integer> capacityMap = new HashMap<>();
 main

        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);

        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void sortBogiesByCapacity() {

feature/UC8

        System.out.println("======================================");
        System.out.println("UC7 - Sort Bogies by Capacity");
        System.out.println("======================================\n");

main
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
    }

    public static void filterBogiesUsingStreams() {

 feature/UC8

        System.out.println("======================================");
        System.out.println("UC8 - Filter Bogies Using Streams");
        System.out.println("======================================\n");

main
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
feature/UC8


        System.out.println("\nUC8 completed...\n");
    }

    // ===== UC9 =====
    public static void groupBogiesByType() {

        System.out.println("=================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("=================================\n");

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
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 24));

        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));

        System.out.println("Grouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println("\n" + entry.getKey() + ":");
            for (Bogie b : entry.getValue()) {
                System.out.println("  Capacity -> " + b.capacity);
            }
        }

        System.out.println("\nUC9 completed...\n");
    }

    // ===== UC10 =====
    public static void countTotalSeats() {

        System.out.println("======================================");
        System.out.println("UC10 - Count Total Seats (Reduce)");
        System.out.println("======================================\n");

        class Bogie {
            String name;
            int capacity;

            Bogie(String name, int capacity) {
                this.name = name;
                this.capacity = capacity;
            }
        }

        // Create list
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // DISPLAY
        System.out.println("Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // MAP + REDUCE
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity: " + totalSeats);

        System.out.println("\nUC10 completed...\n");
 main
    }
}

// ROOM CLASSES
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