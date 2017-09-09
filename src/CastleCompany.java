/**
 * Created by hoa_nguyen on 2017-09-08.
 */
public class CastleCompany {
    private enum Direction {
        UPHILL, DOWNHILL, DEFAULT
    }

    public static void main(String[] agrs) {
        int[] land = {2,1,1,10};
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
}
