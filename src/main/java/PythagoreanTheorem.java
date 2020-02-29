import java.math.BigDecimal;
import java.math.RoundingMode;

public class PythagoreanTheorem {
    public double findHypotenuse(double a, double b) {
        return -1;
    }

    public double findSide(double b, double c) {
        return -1;
    }

    public boolean verify(double a, double b, double c) {
        System.out.println(a * a + b * b);
        System.out.println(c * c);
        return almostEquals(a * a + b * b, c * c);
    }

    private boolean almostEquals(double d0, double d1) {
        double difference = new BigDecimal(d0 - d1)
                .setScale(7, RoundingMode.HALF_UP)
                .doubleValue();
        return difference == 0;
    }
}
