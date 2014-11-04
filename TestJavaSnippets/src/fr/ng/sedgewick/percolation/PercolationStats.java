package fr.ng.sedgewick.percolation;

import fr.ng.sedgewick.utilities.StdOut;
import fr.ng.sedgewick.utilities.StdRandom;
import fr.ng.sedgewick.utilities.StdStats;

public class PercolationStats {
    private final double[] attemps;

    // Perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        attemps = new double[T];
        for (int i = 0; i < T; i++) {
            System.out.println(i);
            Percolation percolation = new Percolation(N);
            int steps = 0;
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(N) + 1;
                int column = StdRandom.uniform(N) + 1;
                if (!percolation.isOpen(row, column)) {
                    percolation.open(row, column);
                    steps++;
                }
            }
            attemps[i] = (double) steps / (N * N);
        }
    }

    /**
     * Sample mean of percolation threshold
     */
    public double mean() {
        return StdStats.mean(attemps);
    }

    /**
     * Sample standard deviation of percolation thershold
     */
    public double stddev() {
        return StdStats.stddev(attemps);
    }

    /**
     * Returns lower bound of the 95% confidence interval
     */
    public double confidenceLow() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(attemps.length));
    }

    /**
     * Returns upper bound of the 95% confidence interval
     */
    public double confidenceHigh() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(attemps.length));
    }

    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(50, 1000);
        StdOut.print("mean = " + percolationStats.mean() + "\n");
        StdOut.print("Std dev = " + percolationStats.stddev() + "\n");
        StdOut.print("95% confidence interval = " + percolationStats.confidenceLow() + ", "
                + percolationStats.confidenceHigh());
    }
}
