import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        initializeTrain();              // UC1
        roomInitialization();           // UC2
        trackUniqueBogies();            // UC3
        maintainOrderedConsist();       // UC4
        preserveInsertionOrder();       // UC5
        mapBogieCapacity();             // UC6
        sortBogiesByCapacity();         // UC7
        filterBogiesUsingStreams();     // UC8
        groupBogiesByType();            // UC9
        countTotalSeats();              // UC10
        validateTrainAndCargo();        // UC11
    }

    // ===== UC1 =====
    public static void initializeTrain() {
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial Bogie Count: " + trainConsist.size());
        System.out.println();
    }

    // ===== UC2 =====
    public static void roomInitialization() {
        System.out.println("UC2 - Room Initialization");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        single.displayRoomDetails();
        doubleRoom.displayRoomDetails();
        suite.displayRoomDetails();

        System.out.println();
    }

    // ===== UC3 =====
    public static void trackUniqueBogies() {
        System.out.println("UC3 - Unique Bogies");

        Set<String> bogies = new HashSet<>();
        bogies.add("B101");
        bogies.add("B102");
        bogies.add("B101"); // duplicate

        System.out.println("Bogies: " + bogies);
        System.out.println("Duplicates ignored\n");
    }

    // ===== UC4 =====
    public static void maintainOrderedConsist() {
        System.out.println("UC4 - Ordered Consist");

        LinkedList<String> train = new LinkedList<>();
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");

        System.out.println("Train: " + train);

        train.add(2, "Pantry");

        System.out.println("After adding Pantry: " + train);

        train.removeFirst();
        train.removeLast();

        System.out.println("After removal: " + train + "\n");
    }

    // ===== UC5 =====
    public static void preserveInsertionOrder() {
        System.out.println("UC5 - Preserve Order");

        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("Formation: " + formation + "\n");
    }

    // ===== UC6 =====
    public static void mapBogieCapacity() {
        System.out.println("UC6 - Map Capacity");

        Map<String, Integer> map = new HashMap<>();
        map.put("Sleeper", 72);
        map.put("AC Chair", 56);
        map.put("First Class", 24);
        map.put("General", 90);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println();
    }

    // ===== UC7 =====
    public static void sortBogiesByCapacity() {
        System.out.println("UC7 - Sort Bogies");

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

        list.sort(Comparator.comparingInt(b -> b.capacity));

        for (Bogie b : list) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println();
    }

    // ===== UC8 =====
    public static void filterBogiesUsingStreams() {
        System.out.println("UC8 - Filter Bogies");

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

        System.out.println();
    }

    // ===== UC9 =====
    public static void groupBogiesByType() {
        System.out.println("UC9 - Group Bogies");

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
        list.add(new Bogie("General", 90));

        Map<String, List<Bogie>> grouped =
                list.stream().collect(Collectors.groupingBy(b -> b.name));

        for (String key : grouped.keySet()) {
            System.out.println(key + " -> " + grouped.get(key).size());
        }

        System.out.println();
    }

    // ===== UC10 =====
    public static void countTotalSeats() {
        System.out.println("UC10 - Total Seats");

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

        int total = list.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seats: " + total + "\n");
    }

    // ===== UC11 =====
    public static void validateTrainAndCargo() {
        System.out.println("UC11 - Validation");

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        boolean trainValid = trainId.matches("TRN-\\d{4}");
        boolean cargoValid = cargoCode.matches("PET-[A-Z]{2}");

        System.out.println("Train ID: " + trainId + " -> " + (trainValid ? "Valid" : "Invalid"));
        System.out.println("Cargo Code: " + cargoCode + " -> " + (cargoValid ? "Valid" : "Invalid"));

        System.out.println();
    }

    // ===== UC12 =====
    public static void checkSafetyCompliance() {
        System.out.println("UC12 - Safety Check");

        class GoodsBogie {
            String type;
            String cargo;

            GoodsBogie(String type, String cargo) {
                this.type = type;
                this.cargo = cargo;
            }
        }

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        System.out.println("Train Safety: " + (isSafe ? "SAFE" : "UNSAFE"));
        System.out.println();
    }
}

// ===== ROOM CLASSES =====

abstract class Room {
    protected int beds, size;
    protected double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + beds + ", Size: " + size + ", Price: " + price);
    }
}

class SingleRoom extends Room {
    public SingleRoom() { super(1, 200, 1500); }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super(2, 350, 2500); }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super(3, 500, 5000); }
}