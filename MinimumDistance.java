// Given a string A which contains only three characters {'x', 'o', '.'}.
// Find minimum possible distance between any pair of 'x' and 'o' in the string.
// Distance is defined as the absolute difference between the index of 'x' and 'o'.
// NOTE: If there is no such pair return -1.
//Input:
// str1 = "x...o.x...o";
// str2 = "xxx...xxx";
//Output:
//2
//-1

public class MinimumDistance {

    public static int solve(String A) {
        int size = A.length();
        char[] Ar = new char[size];
        for (int i = 0; i < size; i++) {
            Ar[i] = A.charAt(i);
        }

        int[] pref = new int[size];
        int[] sufx = new int[size];

        for (int i = 0; i < size; i++) {
            if (Ar[i] == 'x') {
                pref[i] = i;
            } else {
                if (i == 0) {
                    pref[i] = -1;
                } else {
                    pref[i] = pref[i - 1];
                }
            }
        }

        for (int i = size - 1; i >= 0; i--) {
            if (Ar[i] == 'x') {
                sufx[i] = i;
            } else {
                if (i == size - 1) {
                    sufx[i] = -1;
                } else {
                    sufx[i] = sufx[i + 1];
                }
            }
        }

        int ans = 10000000;

        for (int i = 0; i < size; i++) {
            if (Ar[i] == 'o') {
                if (pref[i] != -1)
                    ans = Math.min(ans, i - pref[i]);
                if (sufx[i] != -1)
                    ans = Math.min(ans, sufx[i] - i);
            }
        }
        if (ans == 1e7) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "x...o.x...o";
        String str2 = "xxx...xxx";
        int ans1 = solve(str1);
        int ans2 = solve(str2);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
