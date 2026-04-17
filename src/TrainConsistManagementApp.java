import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

 feature/UC19
        initializeTrain();
        roomInitialization();
        trackUniqueBogies();
        maintainOrderedConsist();
        preserveInsertionOrder();
        mapBogieCapacity();
        sortBogiesByCapacity();
        filterBogiesUsingStreams();
        groupBogiesByType();
        countTotalSeats();
        validateTrainAndCargo();
        checkSafetyCompliance();
        performanceComparison();
        handleInvalidCapacity();
        safeCargoAssignment();
        bubbleSortCapacities();
        sortBogieNames();
        linearSearchBogie();
        binarySearchBogie();
 feature/UC20

       
        try {
            searchWithValidation();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

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
 main
 main
    }

    // ===== UC1 =====
    public static void initializeTrain() {
        System.out.println("=== Train Consist Management App ===");
        List<String> train = new ArrayList<>();
        System.out.println("Initial Bogie Count: " + train.size() + "\n");
    }

    // ===== UC2 =====
    public static void roomInitialization() {
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        r1.displayRoomDetails();
        r2.displayRoomDetails();
        r3.displayRoomDetails();
        System.out.println();
    }

    // ===== UC3 =====
    public static void trackUniqueBogies() {
        Set<String> bogies = new HashSet<>();
        bogies.add("B101");
        bogies.add("B102");
        bogies.add("B101");

        System.out.println("Unique Bogies: " + bogies + "\n");
    }

    // ===== UC4 =====
    public static void maintainOrderedConsist() {
        LinkedList<String> train = new LinkedList<>();
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add(1, "Pantry");

        System.out.println(train + "\n");
    }

    // ===== UC5 =====
    public static void preserveInsertionOrder() {
        Set<String> set = new LinkedHashSet<>();
        set.add("Engine");
        set.add("Sleeper");
        set.add("Engine");

        System.out.println(set + "\n");
    }

    // ===== UC6 =====
    public static void mapBogieCapacity() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Sleeper", 72);
        map.put("AC", 56);

        System.out.println(map + "\n");
    }

    // ===== UC7 =====
    public static void sortBogiesByCapacity() {
        List<Integer> list = Arrays.asList(72, 56, 24, 90);
        list.sort(Integer::compareTo);
        System.out.println(list + "\n");
    }

    // ===== UC8 =====
    public static void filterBogiesUsingStreams() {
        List<Integer> list = Arrays.asList(72, 56, 24, 90);
        list.stream().filter(x -> x > 60).forEach(System.out::println);
        System.out.println();
    }

    // ===== UC9 =====
    public static void groupBogiesByType() {
        List<String> list = Arrays.asList("Sleeper", "AC", "Sleeper");
        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        System.out.println(map + "\n");
    }

    // ===== UC10 =====
    public static void countTotalSeats() {
        List<Integer> list = Arrays.asList(72, 56, 24);
        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println("Total: " + sum + "\n");
    }

    // ===== UC11 =====
    public static void validateTrainAndCargo() {
        System.out.println("Valid: " + "TRN-1234".matches("TRN-\\d{4}") + "\n");
    }

    // ===== UC12 =====
    public static void checkSafetyCompliance() {
        class Bogie {
            String type, cargo;
            Bogie(String t, String c) { type = t; cargo = c; }
        }

        List<Bogie> list = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Rectangular", "Coal")
        );

        boolean safe = list.stream().allMatch(b ->
                !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("Safe: " + safe + "\n");
    }

    // ===== UC13 =====
    public static void performanceComparison() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) list.add(i);

        long start = System.nanoTime();
        list.stream().filter(x -> x > 60).toList();
        long end = System.nanoTime();

        System.out.println("Time: " + (end - start) + "\n");
    }

    // ===== UC14 =====
    public static void handleInvalidCapacity() {
        try {
            throw new Exception("Invalid");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ===== UC15 =====
    public static void safeCargoAssignment() {
        try {
            throw new RuntimeException("Unsafe cargo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Done\n");
        }
    }

    // ===== UC16 =====
    public static void bubbleSortCapacities() {
        int[] arr = {72, 56, 24};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr) + "\n");
    }

    // ===== UC17 =====
    public static void sortBogieNames() {
        String[] arr = {"Sleeper", "AC"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr) + "\n");
    }

    // ===== UC18 =====
    public static void linearSearchBogie() {
        String[] arr = {"BG101", "BG205"};
        for (String s : arr)
            if (s.equals("BG205")) System.out.println("Found\n");
    }

    // ===== UC19 =====
    public static void binarySearchBogie() {
        String[] arr = {"BG101", "BG205", "BG309"};
        Arrays.sort(arr);

        int low = 0, high = arr.length - 1;
        String key = "BG309";

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) {
                System.out.println("Found using Binary Search\n");
                return;
            } else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
    }

 feature/UC20
    // ===== UC20 =====
    public static void searchWithValidation() {

        System.out.println("=====================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("=====================================\n");

        String[] bogieIds = {}; // empty

        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
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
 main
    }
}

// ===== ROOM CLASSES =====
abstract class Room {
    int beds, size;
    double price;

    Room(int b, int s, double p) {
        beds = b; size = s; price = p;
    }

    void displayRoomDetails() {
        System.out.println(beds + " beds, price: " + price);
    }
}

class SingleRoom extends Room { SingleRoom() { super(1,200,1500); } }
class DoubleRoom extends Room { DoubleRoom() { super(2,300,2500); } }
class SuiteRoom extends Room { SuiteRoom() { super(3,500,5000); } }