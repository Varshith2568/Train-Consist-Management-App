import java.util.*;
import java.util.stream.Collectors;

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

        // ===== UC9 =====
        groupBogiesByType();
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

        System.out.println("Single Room:");
        single.displayRoomDetails();

        System.out.println("\nDouble Room:");
        doubleroom.displayRoomDetails();

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails();

        System.out.println("\nUC2 completed...\n");
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
        bogies.add("B101"); // duplicate

        System.out.println(bogies);

        System.out.println("\nUC3 completed...\n");
    }

    // ===== UC4 =====
    public static void maintainOrderedConsist() {

        System.out.println("=================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("=================================\n");

        LinkedList<String> train = new LinkedList<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        train.add(2, "Pantry");

        System.out.println(train);

        System.out.println("\nUC4 completed...\n");
    }

    // ===== UC5 =====
    public static void preserveInsertionOrder() {

        System.out.println("=================================");
        System.out.println("UC5 - Preserve Order");
        System.out.println("=================================\n");

        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println(formation);

        System.out.println("\nUC5 completed...\n");
    }

    // ===== UC6 =====
    public static void mapBogieCapacity() {

        System.out.println("=================================");
        System.out.println("UC6 - Map Capacity");
        System.out.println("=================================\n");

        Map<String, Integer> map = new HashMap<>();

        map.put("Sleeper", 72);
        map.put("AC Chair", 56);
        map.put("First Class", 24);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        System.out.println("\nUC6 completed...\n");
    }

    // ===== UC7 =====
    public static void sortBogiesByCapacity() {

        System.out.println("=================================");
        System.out.println("UC7 - Sort Bogies");
        System.out.println("=================================\n");

        class Bogie {
            String name;
            int capacity;

            Bogie(String name, int capacity) {
                this.name = name;
                this.capacity = capacity;
            }
        }

        List<Bogie> list = new ArrayList<>();

        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));

        list.sort(Comparator.comparingInt(b -> b.capacity));

        for (Bogie b : list) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC7 completed...\n");
    }

    // ===== UC8 =====
    public static void filterBogiesUsingStreams() {

        System.out.println("=================================");
        System.out.println("UC8 - Filter Bogies");
        System.out.println("=================================\n");

        class Bogie {
            String name;
            int capacity;

            Bogie(String name, int capacity) {
                this.name = name;
                this.capacity = capacity;
            }
        }

        List<Bogie> list = new ArrayList<>();

        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("General", 90));

        List<Bogie> filtered = list.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        for (Bogie b : filtered) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC8 completed...\n");
    }

    // ===== UC9 =====
    public static void groupBogiesByType() {

        System.out.println("=================================");
        System.out.println("UC9 - Group Bogies");
        System.out.println("=================================\n");

        class Bogie {
            String name;
            int capacity;

            Bogie(String name, int capacity) {
                this.name = name;
                this.capacity = capacity;
            }
        }

        List<Bogie> list = new ArrayList<>();

        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("First Class", 24));

        Map<String, List<Bogie>> grouped =
                list.stream().collect(Collectors.groupingBy(b -> b.name));

        for (String key : grouped.keySet()) {
            System.out.println(key + ":");
            for (Bogie b : grouped.get(key)) {
                System.out.println("  " + b.capacity);
            }
        }

        System.out.println("\nUC9 completed...\n");
    }
}

// ===== ROOM CLASSES =====
abstract class Room {
    protected int beds;
    protected int size;
    protected double price;

    public Room(int b, int s, double p) {
        beds = b;
        size = s;
        price = p;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size);
        System.out.println("Price: " + price);
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