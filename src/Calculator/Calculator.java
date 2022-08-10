package Calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {

    public static void main(String[] args) {
        try{
            System.out.println("Enter an expression:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String string = br.readLine();

            CalcTest calc = new CalcTest();
            String result = calc.result(string);
            System.out.println("Result: " + result);
        }
        catch(Exception e){
        }
    }
}