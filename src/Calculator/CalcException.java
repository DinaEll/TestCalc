package Calculator;

public class CalcException extends Exception {
    public CalcException() {
        System.out.println("Error. Now the raccoons will tell you what the problem is:");
    }
    public CalcException(String error) {
        this();
        System.out.println(error);
    }
}
