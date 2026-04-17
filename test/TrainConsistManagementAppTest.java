import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

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
        List<Integer> result = input.stream().filter(x -> x > 60).toList();
        assertTrue(result.isEmpty());
    }

    @Test
    void testUC8_AllMatch() {
        List<Integer> input = Arrays.asList(70, 80, 90);
        List<Integer> result = input.stream().filter(x -> x > 60).toList();
        assertEquals(input, result);
    }

    // ================= UC10 =================
    @Test
    void testUC10_TotalSeats() {
        List<Integer> input = Arrays.asList(72, 56, 24, 90);
        int total = input.stream().reduce(0, Integer::sum);
        assertEquals(242, total);
    }

    @Test
    void testUC10_EmptyList() {
        List<Integer> input = new ArrayList<>();
        int total = input.stream().reduce(0, Integer::sum);
        assertEquals(0, total);
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
    static class GoodsBogieUC12 {
        String type, cargo;
        GoodsBogieUC12(String t, String c) { type = t; cargo = c; }
    }

    @Test
    void testUC12_AllValid() {
        List<GoodsBogieUC12> list = Arrays.asList(
                new GoodsBogieUC12("Cylindrical", "Petroleum"),
                new GoodsBogieUC12("Rectangular", "Coal")
        );
        boolean result = list.stream().allMatch(b ->
                !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));
        assertTrue(result);
    }

    @Test
    void testUC12_InvalidCase() {
        List<GoodsBogieUC12> list = List.of(
                new GoodsBogieUC12("Cylindrical", "Coal"));
        boolean result = list.stream().allMatch(b ->
                !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));
        assertFalse(result);
    }

<<<<<<< HEAD
=======
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
>>>>>>> cfe9f40d2bb360f7c0f580360fe5cdf4237da333
    // ================= UC13 =================
    static class BogieUC13 {
        int capacity;
        BogieUC13(int c) { capacity = c; }
    }

    @Test
    void testUC13_FilterLogic() {
        List<BogieUC13> list = Arrays.asList(
                new BogieUC13(50), new BogieUC13(70), new BogieUC13(90));
        long count = list.stream().filter(b -> b.capacity > 60).count();
        assertEquals(2, count);
    }

    // ================= UC14 =================
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

    @Test
    void testUC14_Exception() {
        assertThrows(InvalidCapacityException.class, () -> new PassengerBogie(0));
    }

    // ================= UC15 =================
    static class CargoBogie {
        String shape, cargo;
        CargoBogie(String s) { shape = s; }

        void assign(String c) {
            if (shape.equals("Rectangular") && c.equals("Petroleum")) return;
            cargo = c;
        }
    }

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

    @Test
    void testUC16_AlreadySorted() {
        assertArrayEquals(new int[]{24,56,60,70,72},
                bubbleSort(new int[]{24,56,60,70,72}));
    }

    // ================= UC17 =================
    @Test
    void testUC17_Sorting() {
        String[] arr = {"Sleeper","AC Chair","General"};
        Arrays.sort(arr);
        assertArrayEquals(new String[]{"AC Chair","General","Sleeper"}, arr);
    }

    // ================= UC18 =================
    boolean search(String[] arr, String key) {
        for (String s : arr) if (s.equals(key)) return true;
        return false;
    }

<<<<<<< HEAD
    @Test
    void testUC18_Found() {
        assertTrue(search(new String[]{"BG101","BG309"}, "BG309"));
    }
=======
main

>>>>>>> cfe9f40d2bb360f7c0f580360fe5cdf4237da333

    @Test
    void testUC18_NotFound() {
        assertFalse(search(new String[]{"BG101","BG309"}, "BG999"));
    }
}