import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = null;
        if(args.length == 1){
            path = args[0];
        }
        Test.Start(path);
    }
}