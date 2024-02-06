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
        String romans[] = {"I", "IV", "V", "IX", "X", "L", "C"};
        int arabics[] = {1, 4, 5, 9, 10, 50, 100};
        String res = "";
        int n = a;
        while (n > 0) {
            for (int i = arabics.length - 1; i >= 0; i--) {
                if (n >= arabics[i]) {
                    n -= arabics[i];
                    res += romans[i];
                    break;
                }
            }
        }
        return res;
    }
}