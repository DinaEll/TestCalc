package Calculator;

public class CalcException extends Exception {
    public CalcException() {
        System.out.println("������. ������ ����� ��������� ���, � ��� ��������:");
    }

    public CalcException(String message) {
        this();
        System.out.println(message);
    }
}
