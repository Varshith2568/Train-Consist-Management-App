import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // ================= COMMON CLASSES =================

    // For UC12 safety tests
    static class GoodsBogie {
        String type, cargo;
        GoodsBogie(String t, String c) { type = t; cargo = c; }
    }

    // For UC13
    static class Bogie {
        int capacity;
        Bogie(int c) { capacity = c; }
    }

    // For UC14
    static class InvalidCapacityException extends Exception {
        InvalidCapacityException(String msg) { super(msg); }
    }

    static class PassengerBogie {
        int capacity;
        PassengerBogie(int c) throws InvalidCapacityException {
            if (c <= 0) throw new InvalidCapacityException("Capacity must be greater than zero");
            capacity = c;
        }
    }

    // For UC15
    static class CargoBogie {
        String shape, cargo;
        CargoBogie(String s) { shape = s; }

        void assign(String c) {
            if (shape.equals("Rectangular") && c.equals("Petroleum")) return;
            cargo = c;
        }
    }

    // ================= UC8 =================
    @Test
    void testUC8_FilterValid() {
        List<Integer> input = Arrays.asList(72, 56, 24, 90);
        List<Integer> result = input.stream().filter(x -> x > 60).toList();
        assertEquals(Arrays.asList(72, 90), result);
    }

    @Test
    void testUC8_NoMatch() {
        List<Integer> input = Arrays.asList(10, 20, 30);
        assertTrue(input.stream().filter(x -> x > 60).toList().isEmpty());
    }

    @Test
    void testUC8_AllMatch() {
        List<Integer> input = Arrays.asList(70, 80, 90);
        assertEquals(input, input.stream().filter(x -> x > 60).toList());
    }

    // ================= UC10 =================
    @Test
    void testUC10_TotalSeats() {
        assertEquals(242, Arrays.asList(72,56,24,90).stream().reduce(0, Integer::sum));
    }

    @Test
    void testUC10_EmptyList() {
        assertEquals(0, new ArrayList<Integer>().stream().reduce(0, Integer::sum));
    }

    // ================= UC11 =================
    @Test
    void testUC11_ValidTrainId() {
        assertTrue("TRN-1234".matches("TRN-\\d{4}"));
    }

    @Test
    void testUC11_InvalidTrainId() {
        assertFalse("TRN-12".matches("TRN-\\d{4}"));
    }

    @Test
    void testUC11_ValidCargoCode() {
        assertTrue("PET-AB".matches("PET-[A-Z]{2}"));
    }

    @Test
    void testUC11_InvalidCargoCode() {
        assertFalse("PET-123".matches("PET-[A-Z]{2}"));
    }

    // ================= UC12 =================
    @Test
    void testUC12_AllValid() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal")
        );

        boolean result = list.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertTrue(result);
    }

    @Test
    void testUC12_InvalidCase() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Coal")
        );

        boolean result = list.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertFalse(result);
    }

    // ================= UC13 =================
    @Test
    void testUC13_FilterLogic() {
        List<Bogie> list = Arrays.asList(
                new Bogie(50), new Bogie(70), new Bogie(90)
        );
        assertEquals(2, list.stream().filter(b -> b.capacity > 60).count());
    }

    // ================= UC14 =================
    @Test
    void testUC14_Exception() {
        assertThrows(InvalidCapacityException.class, () -> new PassengerBogie(0));
    }

    // ================= UC15 =================
    @Test
    void testUC15_Safe() {
        CargoBogie g = new CargoBogie("Cylindrical");
        g.assign("Petroleum");
        assertEquals("Petroleum", g.cargo);
    }

    @Test
    void testUC15_Unsafe() {
        CargoBogie g = new CargoBogie("Rectangular");
        g.assign("Petroleum");
        assertNull(g.cargo);
    }

    // ================= UC16 =================
    int[] bubbleSort(int[] arr) {
        int[] a = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length - i - 1; j++)
                if (a[j] > a[j+1]) {
                    int t = a[j]; a[j] = a[j+1]; a[j+1] = t;
                }
        return a;
    }

    @Test
    void testUC16_Basic() {
        assertArrayEquals(new int[]{24,56,60,70,72},
                bubbleSort(new int[]{72,56,24,70,60}));
    }

    // ================= UC17 =================
    @Test
    void testUC17_Sorting() {
        String[] arr = {"Sleeper","AC Chair","General"};
        Arrays.sort(arr);
        assertArrayEquals(new String[]{"AC Chair","General","Sleeper"}, arr);
    }

    // ================= UC18 =================
    boolean linearSearch(String[] arr, String key) {
        for (String s : arr) if (s.equals(key)) return true;
        return false;
    }

    @Test
    void testUC18_Found() {
        assertTrue(linearSearch(new String[]{"BG101","BG309"}, "BG309"));
    }

    @Test
    void testUC18_NotFound() {
        assertFalse(linearSearch(new String[]{"BG101","BG309"}, "BG999"));
    }

    // ================= UC19 =================
    boolean binarySearch(String[] arr, String key) {
        Arrays.sort(arr);
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) return true;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    @Test
    void testUC19_BogieFound() {
        assertTrue(binarySearch(
                new String[]{"BG101","BG205","BG309","BG412","BG550"},
                "BG309"));
    }

    @Test
    void testUC19_BogieNotFound() {
        assertFalse(binarySearch(
                new String[]{"BG101","BG205","BG309","BG412","BG550"},
                "BG999"));
    }


// ================= UC20 =================

    boolean searchWithValidation(String[] arr, String key) {

        if (arr.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        for (String s : arr) {
            if (s.equals(key)) return true;
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        assertThrows(IllegalStateException.class, () -> {
            searchWithValidation(new String[]{}, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        assertDoesNotThrow(() -> {
            searchWithValidation(new String[]{"BG101","BG205"}, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        assertTrue(searchWithValidation(
                new String[]{"BG101","BG205","BG309"}, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        assertFalse(searchWithValidation(
                new String[]{"BG101","BG205","BG309"}, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        assertTrue(searchWithValidation(
                new String[]{"BG101"}, "BG101"));
    }

}


