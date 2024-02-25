/**
 * @author Siwoo Park
 * @version 1.0
 */
public class EuclideanAlgorithm {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 13;
        int steps = 0;
        int dividend = num1;
        int divisor = num2;
        int gcd = 0;
        int quotient = 0;
        int remainder = 0;

        System.out.printf("Finding the greatest common divisor of %d and %d.%n", num1, num2);
        if (divisor > dividend) {
            System.out.println("The inputs would have caused an unnecessary step.");
            int temp;
            temp = divisor;
            divisor = dividend;
            dividend = temp;
        } else {
            System.out.println("An extra step was avoided.");
        }

        do {
            steps += 1;
            quotient = dividend / divisor;
            remainder = dividend % divisor;
            System.out.printf("Step %d: %d = %d * %d + %d%n", steps, dividend, divisor, quotient, remainder);
            gcd = divisor;
            dividend = divisor;
            divisor = remainder;
        } while (remainder != 0);

        System.out.println("The GCD is " + gcd);

        switch (steps) {
            case 1:
                System.out.println("Only one step was needed!");
                break;
            case 2:
                System.out.println("Two steps were taken!");
                break;
            case 3:
                System.out.println("This process took three steps");
                break;
            case 4:
                System.out.println("Wow! Four steps");
                break;
            default:
                System.out.printf("%d steps is alot of steps!%n", steps);
                break;
        }
        // String message = (gcd == 1) ? String.format("%d and %d are relatively
        // prime.", num1, num2)
        // : String.format("%d and %d are not relatively prime.", num1, num2);
        // System.out.printf(message);
        System.out.printf("%d and %d are %s.%n", num1, num2, (gcd == 1) ? "relatively prime" : "not relatively prime");

    }
}