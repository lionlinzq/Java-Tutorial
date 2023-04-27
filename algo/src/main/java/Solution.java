import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        int[] copy = Arrays.copyOf(candies, candies.length);
        Arrays.sort(copy);
        int max = copy[candies.length - 1];
        List<Boolean> result = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            if (candies[i] + extraCandies >= max){
                result.add(true);
            }else {
                result.add(false);
            }
        }
        return result;
    }
}
