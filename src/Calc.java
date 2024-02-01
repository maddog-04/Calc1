class Calc {
    public static String calc(String input) throws Exception {
        String[] split = input.split(" ");
        if (split.length < 3) {
            throw new Exception("т.к. строка не является математической операцией");
        }
        if (split.length > 3) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int a;
        int b;
        boolean isArabicResult = false;
        boolean isArabicResult2 = false;
        try {
            a = Integer.parseInt(split[0]); // из нулевого индекса строки возвращает число
        } catch (Exception e) {
            a = ArabicToRoman.romanToInt(split[0]);
            isArabicResult = true;
        }
        try {
            b = Integer.parseInt(split[2]);
        } catch (Exception e) {
            b = ArabicToRoman.romanToInt(split[2]);
            isArabicResult2 = true;
        }
        if ((isArabicResult == true && isArabicResult2 == false) || (isArabicResult2 == true && isArabicResult == false)) {
            throw new Exception("т.к. используются одновременно разные системы счисления");
        }
        if (a > 10 || b > 10) {
            throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
        }
        String operation = split[1];
        Calculator calc = new Calculator(a, b);
        String result;
        switch (operation) {
            case "+":
                result = String.valueOf(calc.plus());
                break;
            case "-":
                result = String.valueOf(calc.minus());
                break;
            case "*":
                result = String.valueOf(calc.multi());
                break;
            case "/":
                result = String.valueOf(calc.div());
                break;
            default:
                throw new Exception("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами.");
        }
        if (isArabicResult == true) {
            int i = Integer.parseInt(result);
            if (i < 0) {
                throw new Exception("т.к. в римской системе нет отрицательных чисел");
            }
            return ArabicToRoman.intToRoman(i);
        }
        return result;
    }
}