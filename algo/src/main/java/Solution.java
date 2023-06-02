import java.util.*;

/**
 * @author Lin
 */
public class Solution {
    public static void main(String[] args) {
        String s = new String("1_2_3");
        for (String s1 : s.split("_")) {
            System.out.println(s1);
        }
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        int[] copy = Arrays.copyOf(candies, candies.length);
        Arrays.sort(copy);
        int max = copy[candies.length - 1];
        List<Boolean> result = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
