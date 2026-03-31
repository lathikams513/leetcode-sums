import java.util.*;

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] res = new char[n + m - 1];
        Arrays.fill(res, '?');

        // Step 1: Apply 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (res[i + j] == '?' || res[i + j] == str2.charAt(j)) {
                        res[i + j] = str2.charAt(j);
                    } else {
                        return "";
                    }
                }
            }
        }

        // Step 2: Fill remaining '?' with 'a'
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '?') res[i] = 'a';
        }

        // Step 3: Fix 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                boolean match = true;

                for (int j = 0; j < m; j++) {
                    if (res[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean changed = false;

                    for (int j = m - 1; j >= 0; j--) {
                        int pos = i + j;

                        char original = res[pos];

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != str2.charAt(j)) {
                                res[pos] = c;

                                // check ALL 'T' still valid
                                if (validT(res, str1, str2)) {
                                    changed = true;
                                    break;
                                }
                            }
                        }

                        if (changed) break;

                        res[pos] = original;
                    }

                    if (!changed) return "";
                }
            }
        }

        // Step 4: FINAL VALIDATION (VERY IMPORTANT 🔥)
        if (!validateAll(res, str1, str2)) return "";

        return new String(res);
    }

    private boolean validT(char[] res, String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (res[i + j] != str2.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean validateAll(char[] res, String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        for (int i = 0; i < n; i++) {
            boolean match = true;

            for (int j = 0; j < m; j++) {
                if (res[i + j] != str2.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (str1.charAt(i) == 'T' && !match) return false;
            if (str1.charAt(i) == 'F' && match) return false;
        }

        return true;
    }
}