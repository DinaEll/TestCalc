package Calculator;

import java.util.Arrays;
import java.util.List;

public class CalcTest {
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
            throw new CalcException("The expression should be: \"a operator b\"");
        }

        if (converter.checkOperator(expItems.get(1))) {
            operator = expItems.get(1);
        } else {
            throw new CalcException("Operator '" + expItems.get(1) + "' is invalid, should be: + - * / ");
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
            throw new CalcException("Numbers must be whole, Arabic or Roman");
        }

        if (!(a >= 1 && a <= 10)) {
            throw new CalcException("The first number must be less than or equal to 10 (X)");
        }

        if (!(b >= 1 && b <= 10)) {
            throw new CalcException("The second number must be less than or equal to 10 (X)");
        }
        int res = calcExp(a, operator, b);

        if (!isRomanExp) {
            return String.valueOf(res);
        } else if (res < 0){
            throw new CalcException("In the Roman calculator, the result cannot be less than 0");
        } else {
            String sign = res < 0 ? "-" : "";
            return sign + converter.arabToRomeConvert(Math.abs(res));
        }
    }
}