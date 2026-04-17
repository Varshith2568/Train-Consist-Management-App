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
develop
        checkSafetyCompliance();        // UC12
        performanceComparison();        // UC13
 feature/UC15
        handleInvalidCapacity();       // UC14
        safeCargoAssignment();        // UC15
 feature/UC16
        bubbleSortCapacities();   // UC16
feature/UC17
        sortBogieNames();   // UC17
 feature/UC18
        linearSearchBogie();   // UC18




 feature/UC14
        handleInvalidCapacity();   // UC14


 main
 main
main
 main
main
 main
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
 develop
        bogies.add("B101");

        bogies.add("B101"); // duplicate
main

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

 develop

        System.out.println("After adding Pantry: " + train);

 main
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
 develop

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

        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        System.out.println("Train Safety: " + (isSafe ? "SAFE" : "UNSAFE"));
        System.out.println();
    }

    // ===== UC13 =====
    public static void performanceComparison() {
        System.out.println("=====================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("=====================================\n");

        class Bogie {
            String type;
            int capacity;

            Bogie(String type, int capacity) {
                this.type = type;
                this.capacity = capacity;
            }
        }

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", i % 100));
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();

        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }
        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();
        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();
        long endStream = System.nanoTime();

        System.out.println("Loop Execution Time (ns): " + (endLoop - startLoop));
        System.out.println("Stream Execution Time (ns): " + (endStream - startStream));

        System.out.println("\nUC13 performance benchmarking completed...\n");


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
 main
    }

    // ===== UC14 =====
    public static void handleInvalidCapacity() {
        System.out.println("=====================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("=====================================\n");

        // Custom Exception
        class InvalidCapacityException extends Exception {
            public InvalidCapacityException(String message) {
                super(message);
            }
        }

        // Passenger Bogie
        class PassengerBogie {
            String type;
            int capacity;

            PassengerBogie(String type, int capacity) throws InvalidCapacityException {
                if (capacity <= 0) {
                    throw new InvalidCapacityException("Capacity must be greater than zero");
                }
                this.type = type;
                this.capacity = capacity;
            }
        }

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + b1.type + " -> " + b1.capacity);

            // Invalid case
            PassengerBogie b2 = new PassengerBogie("AC", 0);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...\n");
    }

    // ===== UC15 =====
    public static void safeCargoAssignment() {
        System.out.println("=====================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("=====================================\n");

        // Custom Runtime Exception
        class CargoSafetyException extends RuntimeException {
            public CargoSafetyException(String message) {
                super(message);
            }
        }

        // Goods Bogie
        class GoodsBogie {
            String shape;
            String cargo;

            GoodsBogie(String shape) {
                this.shape = shape;
            }

            void assignCargo(String cargo) {
                try {
                    // Rule: Rectangular cannot carry Petroleum
                    if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                        throw new CargoSafetyException("Unsafe cargo assignment!");
                    }

                    this.cargo = cargo;
                    System.out.println("Cargo assigned successfully -> " + cargo);

                } catch (CargoSafetyException e) {
                    System.out.println("Error: " + e.getMessage());

                } finally {
                    System.out.println("Cargo validation completed for " + shape + " bogie");
                }
            }
        }

        //  Safe case
        GoodsBogie g1 = new GoodsBogie("Cylindrical");
        g1.assignCargo("Petroleum");

        System.out.println();

        //  Unsafe case
        GoodsBogie g2 = new GoodsBogie("Rectangular");
        g2.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...\n");
    }

    // ===== UC16 =====
    public static void bubbleSortCapacities() {
        System.out.println("=====================================");
        System.out.println("UC16 - Manual Sorting using Bubble Sort");
        System.out.println("=====================================\n");

        int[] capacities = {72, 56, 24, 70, 60};

        // Display original
        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        // Bubble Sort
        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // Display sorted
        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nUC16 sorting completed...\n");
    }

    // ===== UC17 =====
    public static void sortBogieNames() {
        System.out.println("=====================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("=====================================\n");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        // Original
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // Sorting using built-in method
        Arrays.sort(bogieNames);

        // Sorted output
        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...\n");
    }

    // ===== UC18 =====
    public static void linearSearchBogie() {
        System.out.println("=====================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("=====================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchId = "BG309";

        // Display all IDs
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = false;

        // Linear Search
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        // Result
        if (found) {
            System.out.println("\nBogie " + searchId + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchId + " NOT found.");
        }

        System.out.println("\nUC18 search completed...\n");
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