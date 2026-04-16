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

        System.out.println(bogies);
        System.out.println("Duplicates ignored");
    }

    public static void maintainOrderedConsist() {
        LinkedList<String> train = new LinkedList<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        train.add(2, "Pantry");

        System.out.println(train);
    }

    public static void preserveInsertionOrder() {
        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println(formation);
    }

    public static void mapBogieCapacity() {
        Map<String, Integer> map = new HashMap<>();

        map.put("Sleeper", 72);
        map.put("AC Chair", 56);
        map.put("First Class", 24);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    public static void sortBogiesByCapacity() {

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
    }

    public static void filterBogiesUsingStreams() {

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
    }
}

// ROOM CLASSES
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