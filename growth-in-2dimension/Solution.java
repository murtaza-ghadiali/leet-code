import java.util.*;

class Solution {

   public static long getMaxCellCount(String[] upRight) {
        // Track the smallest row and column among all operations.
        // The maximum value occurs at the cell (1,1) area that is covered by every rectangle,
        // and the count of such cells is the product of the minimum r and minimum c values.
        long minR = Long.MAX_VALUE;
        long minC = Long.MAX_VALUE;

        for (String s : upRight) {
            // Example input: "2 3" -> row = 2, col = 3
            String[] parts = s.trim().split("\\s+");
            long r = Long.parseLong(parts[0]);
            long c = Long.parseLong(parts[1]);

            // Keep the maximum overlap area closest to the origin.
            minR = Math.min(minR, r);
            minC = Math.min(minC, c);
        }

        return minR * minC;
    }
}