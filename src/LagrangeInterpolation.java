public class LagrangeInterpolation {
    public static double interpolate(double[] x, double[] y, double xi) {
        int n = x.length;
        double result = 0.0;

        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term *= (xi - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }
        return result;
    }

    public static void main(String[] args) {
        double[] x = {5, 10, 15, 20, 25, 30, 35, 40};
        double[] y = {40, 30, 25, 40, 18, 20, 22, 15};

        System.out.println("Lagrange Interpolation:");
        for (double xi = 5; xi <= 40; xi += 5) {
            System.out.printf("f(%.2f) = %.2f%n", xi, interpolate(x, y, xi));
        }
    }
}