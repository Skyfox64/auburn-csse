import java.io.*;

public final class Message implements Serializable {
    public int number1;
    public int number2;
    public int sum;
    public Message(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public Message(int sum) {
        this.sum = sum;
    }
}