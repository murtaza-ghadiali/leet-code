class Solution {

    // Map each Roman symbol, and each valid subtractive pair, to its numeric value.
    static Map<String, Integer> value = new HashMap();
    static {
        value.put("I", 1);
        value.put("V", 5);
        value.put("X", 10);
        value.put("L", 50);
        value.put("C", 100);
        value.put("D", 500);
        value.put("M", 1000);
        value.put("IV", 4);
        value.put("IX", 9);
        value.put("XL", 40);
        value.put("XC", 90);
        value.put("CD", 400);
        value.put("CM", 900);
    }

    // Walk through the string from left to right.
    // If the current two-character pair is a valid subtractive Roman numeral,
    // add its value and skip both characters; otherwise add the single symbol value.
    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;

        while (i < s.length()) {
            if (i < s.length() - 1) {
                String twoSymbols = s.substring(i, i + 2);
                if (value.containsKey(twoSymbols)) {
                    sum += value.get(twoSymbols);
                    i += 2;
                    continue;
                }
            }

            String oneSymbol = s.substring(i, i + 1);
            sum += value.get(oneSymbol);
            i += 1;
        }

        return sum;
    }
}