package Calculator;

import java.util.HashMap;
import java.util.Map;

public class Converter {
    private final Map<String, Integer> arabRom = new HashMap<>();
    private final int[] arab = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] rome = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public Converter() {
        arabRom.put("I", 1);
        arabRom.put("II", 2);
        arabRom.put("III", 3);
        arabRom.put("IV", 4);
        arabRom.put("V", 5);
        arabRom.put("VI", 6);
        arabRom.put("VII", 7);
        arabRom.put("VIII", 8);
        arabRom.put("IX", 9);
        arabRom.put("X", 10);
    }
    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean isRoman(String str) {
        return arabRom.containsKey(str);
    }
    public Integer romeToArabConvert(String st){
        if (arabRom.containsKey(st)){
            return arabRom.get(st);
        }
        return null;
    }
    public String arabToRomeConvert(Integer num) throws Exception {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arab.length; i++) {
            while ((num - arab[i]) >= 0) {
                num -= arab[i];
                result.append(rome[i]);
            }
        }
        return result.toString();
    }
    public boolean checkOperator(String op){
        return "*".equals(op) || "/".equals(op) || "+".equals(op) || "-".equals(op);
    }
}