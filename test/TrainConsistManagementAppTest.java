import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testFilter_ValidCapacity() {
        List<Integer> input = Arrays.asList(72, 56, 24, 90);

        List<Integer> result = input.stream()
                .filter(x -> x > 60)
                .toList();

        assertEquals(Arrays.asList(72, 90), result);
    }

    @Test
    void testFilter_NoMatch() {
        List<Integer> input = Arrays.asList(20, 30);

        List<Integer> result = input.stream()
                .filter(x -> x > 60)
                .toList();

        assertTrue(result.isEmpty());
    }
}