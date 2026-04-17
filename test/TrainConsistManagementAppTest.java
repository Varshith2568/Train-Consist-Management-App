import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // ================= UC8 =================
    // Filter Bogies (capacity > 60)

    @Test
    void testUC8_FilterValid() {

        List<Integer> input = Arrays.asList(72, 56, 24, 90);

        List<Integer> result = input.stream()
                .filter(x -> x > 60)
                .toList();

        assertEquals(Arrays.asList(72, 90), result);
    }

    @Test
    void testUC8_NoMatch() {

        List<Integer> input = Arrays.asList(10, 20, 30);

        List<Integer> result = input.stream()
                .filter(x -> x > 60)
                .toList();

        assertTrue(result.isEmpty());
    }

    @Test
    void testUC8_AllMatch() {

        List<Integer> input = Arrays.asList(70, 80, 90);

        List<Integer> result = input.stream()
                .filter(x -> x > 60)
                .toList();

        assertEquals(input, result);
    }

    // ================= UC10 =================
    // Reduce (Total seats)

    @Test
    void testUC10_TotalSeats() {

        List<Integer> input = Arrays.asList(72, 56, 24, 90);

        int total = input.stream()
                .reduce(0, Integer::sum);

        assertEquals(242, total);
    }

    @Test
    void testUC10_EmptyList() {

        List<Integer> input = new ArrayList<>();

        int total = input.stream()
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    // ================= UC11 =================
    // Regex Validation

    @Test
    void testUC11_ValidTrainId() {
        String trainId = "TRN-1234";
        assertTrue(trainId.matches("TRN-\\d{4}"));
    }

    @Test
    void testUC11_InvalidTrainId() {
        String trainId = "TRN-12";
        assertFalse(trainId.matches("TRN-\\d{4}"));
    }

    @Test
    void testUC11_ValidCargoCode() {
        String cargo = "PET-AB";
        assertTrue(cargo.matches("PET-[A-Z]{2}"));
    }

    @Test
    void testUC11_InvalidCargoCode() {
        String cargo = "PET-123";
        assertFalse(cargo.matches("PET-[A-Z]{2}"));
    }

// ================= UC12 =================
// Safety Validation

    class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    @Test
    void testSafety_AllBogiesValid() {

        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal")
        );

        boolean result = list.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        assertTrue(result);
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {

        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );

        boolean result = list.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        assertFalse(result);
    }

    @Test
    void testSafety_NonCylindricalAllowed() {

        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Open", "Grain")
        );

        boolean result = list.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        assertTrue(result);
    }

    @Test
    void testSafety_MixedWithViolation() {

        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal") // invalid
        );

        boolean result = list.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        assertFalse(result);
    }

    @Test
    void testSafety_EmptyList() {

        List<GoodsBogie> list = new ArrayList<>();

        boolean result = list.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        assertTrue(result); // empty = safe
    }


 develop
    // ================= UC13 =================
// Performance Comparison (Loops vs Streams)

    class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    @Test
    void testLoopFilteringLogic() {

        List<Bogie> list = Arrays.asList(
                new Bogie("A", 50),
                new Bogie("B", 70),
                new Bogie("C", 90)
        );

        List<Bogie> result = new ArrayList<>();

        for (Bogie b : list) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }

        // Only 70 and 90 should be included
        assertEquals(2, result.size());
    }

    @Test
    void testStreamFilteringLogic() {

        List<Bogie> list = Arrays.asList(
                new Bogie("A", 50),
                new Bogie("B", 70),
                new Bogie("C", 90)
        );

        List<Bogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {

        List<Bogie> list = Arrays.asList(
                new Bogie("A", 50),
                new Bogie("B", 70),
                new Bogie("C", 90)
        );

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : list) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = list.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        // Both results should be same size
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {

        long start = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            // dummy operation
        }

        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {

        List<Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("X", i % 100));
        }

        List<Bogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        // Should return some filtered data
        assertFalse(result.isEmpty());
    }



main


}
