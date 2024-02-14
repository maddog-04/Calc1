class ArabicToRoman {
    static int romanToInt(String s) {
        int sum = 0;
        char chs[] = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'I') {
                sum += 1;
            }
            if (chs[i] == 'V') {
                if (i != 0 && chs[i - 1] == 'I') {
                    sum += 4 - 1;
                } else {
                    sum += 5;
                }
            }
            if (chs[i] == 'X') {
                if (i != 0 && chs[i - 1] == 'I') {
                    sum += 9 - 1;
                } else {
                    sum += 10;
                }
            }
        }
        return sum;
    }

    static String intToRoman(int a) {
        String romans[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
        int arabics[] = {1, 4, 5, 9, 10, 40, 50, 90, 100};
        StringBuilder res = new StringBuilder();
        int n = a;
        int i = arabics.length - 1;
        while (n > 0) {
            if (n >= arabics[i]) {
                res.append(romans[i]);
                n -= arabics[i];
            } else {
                i--;
            }
        }
        return res.toString();
    }
}