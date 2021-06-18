public class HtreeEx {

    // plots an "H" centered on (x, y), using 3 lines, each of length size
    public static void drawH(double x, double y, double size) {


    }

    // plot an H-tree of order n, centered at (x, y) of the given side length
    public static void draw(int n, double x, double y, double size) {


        // compute x- and y-coordinates of the 4 half-size H-trees


        // recursively draw 4 half-size H-trees of order n-1


    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double x = 0.5, y = 0.5;   // center of H-tree
        double size = 0.5;         // side length of H-tree
        draw(n, x, y, size);
    }
}
