public class NewtonInterpolation {
    public static double[] dividedDifferences(double[] x, double[] y) {
        int n = y.length;
        double[][] coef = new double[n][n];
        for (int i = 0; i < n; i++) {
            coef[i][0] = y[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                coef[i][j] = (coef[i + 1][j - 1] - coef[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = coef[0][i];
        }
        return result;
    }

    public static double interpolate(double[] x, double[] coef, double xi) {
        double result = coef[coef.length - 1];
        for (int i = coef.length - 2; i >= 0; i--) {
            result = result * (xi - x[i]) + coef[i];
        }
        return result;
    }

    public static void main(String[] args) {
        double[] x = {5, 10, 15, 20, 25, 30, 35, 40};
        double[] y = {40, 30, 25, 40, 18, 20, 22, 15};

        double[] coef = dividedDifferences(x, y);

        System.out.println("Newton Interpolation:");
        for (double xi = 5; xi <= 40; xi += 5) {
            System.out.printf("f(%.2f) = %.2f%n", xi, interpolate(x, coef, xi));
        }
    }
}
