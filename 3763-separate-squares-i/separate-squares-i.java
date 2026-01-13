class Solution {
    public boolean check(int[][] squares, double midY, double total) {
        
        double botArea = 0.0;
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];

            double boty = y;
            double topy = y + l;

            if (midY >= topy) {
                // full square below
                botArea += l * l;
            } else if (midY > boty) {
                // partial square below
                botArea += (midY - boty) * l;
            }
        }
        return botArea >= total / 2.0;
    }

    public double separateSquares(int[][] squares) {

        double low = Double.MAX_VALUE;
        double high = -Double.MAX_VALUE;
        double total = 0.0;

        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];

            total += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double resultY = 0.0;

        while (high - low > 1e-5) {
            double midY = low + (high - low) / 2.0;
            resultY = midY;

            if (check(squares, midY, total)) {
                // bottom area is greater
                high = midY;
            } else {
                low = midY;
            }
        }
        return resultY;
    }
}
