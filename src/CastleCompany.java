import java.util.Scanner;

/**
 * Created by hoa_nguyen on 2017-09-08.
 */
public class CastleCompany {
    private enum Direction {
        UPHILL, DOWNHILL, DEFAULT
    }

    public static void main(String[] agrs) {
        // Get input from keyboard
        String ins = getInput();
        int[] land = converStringToInts(ins);

        int numCastle = 1; // can always build the castle at the first element
        Direction lastDir = Direction.DEFAULT;

        for(int i = 1; i < land.length; i++) {

            if(land[i-1] < land[i]) {
                // Going up hill. If already went down hill before, it's a valley
                if(lastDir == Direction.DOWNHILL) numCastle++;
                lastDir = Direction.UPHILL;
            }
            else if(land[i-1] > land[i]) {
                // Going downhill. If already went up hill before, it's a peak
                if(lastDir == Direction.UPHILL) numCastle++;
                lastDir = Direction.DOWNHILL;
            }
        }

        System.out.print("Number of Castles: " + numCastle);
    }

    private static int[] converStringToInts(String args) {
        args = args.replace(" ", ""); // replace all spaces

        String[] ins = args.split(",");

        int[] outs = new int[ins.length];
        for(int i = 0; i < outs.length; i++) {
            outs[i] = Integer.valueOf(ins[i]);
        }

        return outs;
    }

    private static String getInput() {
        System.out.print("Input: ");
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        return input;
    }
}
