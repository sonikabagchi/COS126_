public class NBody {
    public static void main(String[] args) {
        // read command line arguments
        double tau = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        // read number of planets and radius from document
        int n = StdIn.readInt();
        double radius = StdIn.readDouble();

        // initialise 6 parallel arrays
        double[] px = new double[n];
        double[] py = new double[n];
        double[] vx = new double[n];
        double[] vy = new double[n];
        double[] mass = new double[n];
        String[] image = new String[n];
        double grav = 6.67 * Math.pow(10, -11);

        // print out number of planets and radius
        StdOut.printf("%d\n", n);
        StdOut.printf("%.2e\n", radius);

        // read data from Standard input and print for each row
        for (int i = 0; i < n; i++) {
            px[i] = StdIn.readDouble();
            py[i] = StdIn.readDouble();
            vx[i] = StdIn.readDouble();
            vy[i] = StdIn.readDouble();
            mass[i] = StdIn.readDouble();
            image[i] = StdIn.readString();
            // StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", px[i], py[i], vx[i], vy[i],mass[i], image[i]);
        }

        // setting background
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.enableDoubleBuffering();
        StdAudio.play("2001.wav");

        // increasing time by set intervals
        double t = 0;
        while (t < tau) {
            // StdOut.println(t);
            t = t + dt;

            // calculating forces acting on each planet
            // initialise arrays for forces and acceleration
            double[] fx = new double[n];
            double[] fy = new double[n];
            double[] ax = new double[n];
            double[] ay = new double[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        double dx = px[j] - px[i];
                        double dy = py[j] - py[i];
                        double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
                        double f = (grav * mass[i] * mass[j]) / (Math.pow(r, 2));
                        fx[i] = fx[i] + (f * (dx / r));
                        fy[i] = fy[i] + (f * (dy / r));
                    }
                    ax[i] = fx[i] / mass[i];
                    ay[i] = fy[i] / mass[i];
                }
            }

            // updating position and velocity of each planet
            for (int j = 0; j < n; j++) {
                vx[j] = vx[j] + dt * ax[j];
                vy[j] = vy[j] + dt * ay[j];

                px[j] = px[j] + dt * vx[j];
                py[j] = py[j] + dt * vy[j];
            }

            StdDraw.picture(0, 0, "starfield.jpg");

            // drawing each planet
            for (int k = 0; k < n; k++) {
                StdDraw.picture(px[k], py[k], image[k]);
            }
            StdDraw.show();
            StdDraw.pause(20);

        }
        // printing out final positions of planets
        for (int i = 0; i < n; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", px[i], py[i], vx[i],
                          vy[i], mass[i], image[i]);
        }
    }
}
