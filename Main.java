import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        double m = Double.parseDouble(args[2]);
        double nu = Double.parseDouble(args[3]);
        double lambda = Double.parseDouble(args[4]);

        Boolean flag = false;
        if (flag) {
            int index = 0;
            for (; nu < 10000; nu *= 10) {
                ArrayList<Double> sums = new ArrayList<>(10);
                Path path = Path.of(new java.io.File(".").getCanonicalPath() + "/out_data/out_one" + index + ".txt");
                FileWriter fw = new FileWriter(String.valueOf(path));
                for (int i = 0; i < 11; i++) {
                    n = 65526 + i;
                    sums.add(0.0);
                    for (int j = n + 1; j <= N + 1; j++) {
                        double mul = 1;
                        for (int l = n; l <= j - 1; l++) {
                            double nul;
                            if ((N - m) <= l && l <= N)
                                nul = (N - l) * nu;
                            else
                                nul = m * nu;

                            mul *= nul / (l * lambda);
                        }
                        sums.set(i, sums.get(i) + mul * (double) 1 / (lambda * j));
                        sums.set(i, sums.get(i) + 1 / (n * lambda));
                    }
                    fw.write(n + " " + sums.get(i) + "\n");
                }
                index++;
                fw.close();
            }
        } else {
            int index = 0;
            for (Double m_: new Double[] { 1D, 2D, 3D, 4D})
            {
                ArrayList<Double> sums = new ArrayList<>(10);
                ArrayList<Double> muls = new ArrayList<>(10);
                Path path = Path.of(new java.io.File(".").getCanonicalPath() + "/out_data/out_six" + index + ".txt");
                FileWriter fw = new FileWriter(String.valueOf(path));
                for (int i = 0; i < 11; i++) {
                    n = 8092 + i * 10;
                    sums.add(0D);
                    muls.add(1D);
                    double mul = 1;
                    for (int l = 1; l < n; l++) {
                        mul *= (l * lambda) / (nu * l);
                    }
                    muls.set(i, mul / (nu * m_));
                    for (int j = 1; j <= n-1; j++) {
                        double mul_ = 1;
                        for (int l = j; l <= n - 1; l++) {
                            double nul;
                            if ((N - m_) <= l && l <= N)
                                nul = (N - l) * nu;
                            else
                                nul = m_ * nu;

                            mul_ *= (l * lambda) / nul;
                        }
                        sums.set(i, sums.get(i) + (mul_ / (lambda * j)));
                    }

                    fw.write(n + " " + (sums.get(i) + muls.get(i)) + '\n');
                }
                fw.close();
                index++;
            }
        }
    }
}
