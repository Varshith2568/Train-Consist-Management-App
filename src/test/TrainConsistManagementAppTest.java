
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // ✅ Create GoodsBogie class inside test
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // ✅ Safety method (same logic as UC12)
    boolean isSafe(List<GoodsBogie> list) {
        return list.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical") ||
                                b.cargo.equalsIgnoreCase("Petroleum")
                );
    }

    // ✅ Test 1: Valid case
    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        assertTrue(isSafe(list));
    }

    // ❌ Test 2: Invalid cylindrical cargo
    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Coal"));

        assertFalse(isSafe(list));
    }

    // ✅ Test 3
    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        assertTrue(isSafe(list));
    }

    // ❌ Test 4
    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(isSafe(list));
    }

    // ✅ Test 5
    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> list = new ArrayList<>();

        assertTrue(isSafe(list));
    }
}