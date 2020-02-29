import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class PythagoreanTheoremTest {
    private static PythagoreanTheorem pythagoreanTheorem;

    @BeforeAll
    public static void setUp() {
        pythagoreanTheorem = new PythagoreanTheorem();
    }

    @Test
    public void testHypotenuseZeros() {
        assertAlmostEquals(0, pythagoreanTheorem.findHypotenuse(0, 0));
    }

    @Test
    public void testHypotenuseIntegers() {
        assertAlmostEquals(5, pythagoreanTheorem.findHypotenuse(3, 4));
    }

    @Test
    public void testHypotenuseMoreIntegers() {
        assertAlmostEquals(10, pythagoreanTheorem.findHypotenuse(6, 8));
    }

    @Test
    public void testHypotenuseDecimal() {
        assertAlmostEquals(14.1421356237, pythagoreanTheorem.findHypotenuse(10.0, 10.0));
    }

    @Test
    public void testHypotenuseAnotherDecimal() {
        assertAlmostEquals(869.504223106, pythagoreanTheorem.findHypotenuse(365.14, 789.12));
    }

    @Test
    public void testHypotenuseNegatives() {
        assertAlmostEquals(5, pythagoreanTheorem.findHypotenuse(-3, -4));
    }

    @Test
    public void testSideZeros() {
        assertAlmostEquals(0, pythagoreanTheorem.findSide(0, 0));
    }

    @Test
    public void testSideIntegers() {
        assertAlmostEquals(3, pythagoreanTheorem.findSide(4, 5));
    }

    @Test
    public void testSideMoreIntegers() {
        assertAlmostEquals(6, pythagoreanTheorem.findSide(8, 10));
    }

    @Test
    public void testSideDecimal() {
        assertAlmostEquals(10.0, pythagoreanTheorem.findSide(10.0, 14.1421356237));
    }

    @Test
    public void testSideAnotherDecimal() {
        assertAlmostEquals(365.14, pythagoreanTheorem.findSide(789.12, 869.504223106));
    }

    @Test
    public void testVerifyZeros() {
        assertTrue(pythagoreanTheorem.verify(0, 0, 0));
    }

    @Test
    public void testIntegerTriangleWorks() {
        assertTrue(pythagoreanTheorem.verify(3, 4, 5));
    }

    @Test
    public void testAnotherIntegerTriangleWorks() {
        assertTrue(pythagoreanTheorem.verify(6,8, 10));
    }

    @Test
    public void testBadTriangleFails() {
        assertFalse(pythagoreanTheorem.verify(3, 4, 7));
    }

    @Test
    public void testAnotherBadTriangle() {
        assertFalse(pythagoreanTheorem.verify(7, 8, 11));
    }

    @Test
    public void testDoubleTrianglePasses() {
        assertTrue(pythagoreanTheorem.verify(10, 10, 14.142135623730951));
    }

    @Test
    public void testDoubleTriangleFails() {
        assertFalse(pythagoreanTheorem.verify(11.1, 15.7, 23.65));
    }

    @Test
    public void testBadTriangleNegatives() {
        assertFalse(pythagoreanTheorem.verify(-1, -1, -1));
    }

    @Test
    public void testGoodTriangleNegatives() {
        assertTrue(pythagoreanTheorem.verify(-3, -4, -5));
    }

    public static void assertAlmostEquals(double expected, double actual) {
        //convert to BigDecimal to obtain better rounding functions
        double difference = new BigDecimal(expected - actual)
                .setScale(7, RoundingMode.HALF_UP)
                .doubleValue();
        assertEquals(difference, 0);
    }
}
