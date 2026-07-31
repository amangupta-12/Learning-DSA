class Solution {
    public int maximumXorProduct(long a, long b, int n) {

        long axorx = 0;
        long bxorx = 0;

        int M = 1000000000 + 7;

        for (int i = 49; i >= n; i--) {

            long a_i_bit = (a >> i) & 1L;
            long b_i_bit = (b >> i) & 1L;

            if (a_i_bit == 1) {
                axorx = axorx ^ (1L << i);
            }

            if (b_i_bit == 1) {
                bxorx = bxorx ^ (1L << i);
            }

        }

        for (int i = n - 1; i >= 0; i--) {
            long a_i_bit = (a >> i) & 1L;
            long b_i_bit = (b >> i) & 1L;

            if (a_i_bit == b_i_bit) {
                axorx = axorx ^ (1L << i);
                bxorx = bxorx ^ (1L << i);
                continue;
            } else {
                if (axorx > bxorx) {
                    bxorx = bxorx ^ (1L << i);
                } else {
                    axorx = axorx ^ (1L << i);
                }
            }
        }

        axorx = axorx % M;
        bxorx = bxorx % M;

        return (int) ((axorx * bxorx) % M);
    }
}