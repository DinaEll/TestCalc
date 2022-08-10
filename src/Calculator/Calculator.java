package Calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {

    public static void main(String[] args) {
        try{
            System.out.println("Введите выражение:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String string = br.readLine();

            Calc calc = new Calc();
            String result = calc.result(string);
            System.out.println("Результат: " + result);
        }
        catch(Exception e){
        }
    }
}