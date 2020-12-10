import java.io.*;import java.io.Serializable;import java.lang.String;

public final class MessageHW2 implements Serializable {

//    public String word1;
//    public String word2;
    public String message;
    public String x;


//    public MessageHW2(String word1, String word2) {
//        this.word1 = word1;
//        this.word2 = word2;
//    }

    public MessageHW2(String message, String xIn) {
        this.message = message;
        this.x = xIn;
    }
}