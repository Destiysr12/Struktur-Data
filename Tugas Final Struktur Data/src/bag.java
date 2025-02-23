import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class bag {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();

        StdOut.println("Masukkan angka (tekan Ctrl+D untuk selesai di terminal, atau Ctrl+Z lalu Enter di Windows):");

        // Membaca input sampai EOF
        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }

        int N = numbers.size();
        if (N == 0) {
            StdOut.println("Tidak ada data yang dimasukkan.");
            return;
        }

        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / N;

        if (N == 1) {
            StdOut.printf("Mean: %.2f\n", mean);
            StdOut.println("Standar deviasi tidak dapat dihitung untuk satu nilai.");
            return;
        }

        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (N - 1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
