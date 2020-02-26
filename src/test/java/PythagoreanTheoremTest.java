import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PythagoreanTheoremTest {
    private static PythagoreanTheorem pythagoreanTheorem;

    @BeforeAll
    public static void setUp() {
        pythagoreanTheorem = new PythagoreanTheorem();
    }

    @Test
    public void testZeros() {
        assertAlmostEquals(0, pythagoreanTheorem.pythagoreanTheorem(0, 0));
    }

    @Test
    public void TestIntegers() {
        assertAlmostEquals(5, pythagoreanTheorem.pythagoreanTheorem(3, 4));
    }

    @Test
    public void TestMoreIntegers() {
        assertAlmostEquals(10, pythagoreanTheorem.pythagoreanTheorem(6, 8));
    }

    @Test
    public void testDecimal() {
        assertAlmostEquals(14.1421356237, pythagoreanTheorem.pythagoreanTheorem(10.0, 10.0));
    }

    @Test
    public void testAnotherDecimal() {
        assertAlmostEquals(869.504223106, pythagoreanTheorem.pythagoreanTheorem(365.14, 789.12));
    }

    @Test
    public void testNegatives() {
        assertAlmostEquals(5, pythagoreanTheorem.pythagoreanTheorem(-3, -4));
    }

    public static void assertAlmostEquals(double expected, double actual) {
        //convert to BigDecimal to obtain better rounding functions
        double difference = new BigDecimal(expected - actual)
                .setScale(7, RoundingMode.HALF_UP)
                .doubleValue();
        assertEquals(difference, 0);
    }
}
