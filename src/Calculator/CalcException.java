package Calculator;

public class CalcException extends Exception {
    public CalcException() {
        System.out.println("Ошибка. Сейчас еноты расскажут вам, в чем проблема:");
    }

    public CalcException(String message) {
        this();
        System.out.println(message);
    }
}
