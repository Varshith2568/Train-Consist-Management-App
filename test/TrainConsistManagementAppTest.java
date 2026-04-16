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
}