package Calculator;

import java.util.Arrays;
import java.util.List;

public class Calc {
    private int a, b;
    private String operator;
    private int calcExp(int n1, String op, int n2) {
        int res;
        switch (op) {
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
            case "/":
                res = n1 / n2;
                break;
            default:
                throw new AssertionError();
        }
        return res;
    }

    public String result(String exp) throws Exception {
        boolean isRomanExp;
        Converter converter = new Converter();
        List<String> expItems = Arrays.asList(exp.split(" "));

        if (expItems.size() != 3) {
            throw new CalcException("Выражение должно быть таким: \"a оператор b\"");
        }

        if (converter.checkOperator(expItems.get(1))) {
            operator = expItems.get(1);
        } else {
            throw new CalcException("Оператор '" + expItems.get(1) + "' не корректен, должен быть: + - * / ");
        }

        if (converter.isNumeric(expItems.get(0)) && converter.isNumeric(expItems.get(2))) {
            a = Integer.parseInt(expItems.get(0));
            b = Integer.parseInt(expItems.get(2));
            isRomanExp = false;
        } else if (converter.isRoman(expItems.get(0)) && converter.isRoman(expItems.get(2))) {
            a = converter.romeToArabConvert(expItems.get(0));
            b = converter.romeToArabConvert(expItems.get(2));
            isRomanExp = true;
        } else {
            throw new CalcException("Числа должны быть целые, арабские или римские");
        }

        if (!(a >= 1 && a <= 10)) {
            throw new CalcException("Первое число должно быть меньше 10 (Х)");
        }

        if (!(b >= 1 && b <= 10)) {
            throw new CalcException("Второе число должно быть меньше 10 (Х)");
        }
        int res = calcExp(a, operator, b);

        if (!isRomanExp) {
            return String.valueOf(res);
        } else if (res < 0){
            throw new CalcException("В римском калькуляторе результат не может быть меньше 0");
        } else {
            String sign = res < 0 ? "-" : "";
            return sign + converter.arabToRomeConvert(Math.abs(res));
        }
    }
}