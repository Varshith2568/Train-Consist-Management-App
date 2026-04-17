import java.util.*;
import java.util.stream.Collectors;

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

        // ✅ UC20 handled safely
        try {
            searchWithValidation();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
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

    // ===== UC20 =====
    public static void searchWithValidation() {

        System.out.println("=====================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("=====================================\n");

        String[] bogieIds = {}; // empty

        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }
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