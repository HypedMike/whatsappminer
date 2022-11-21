import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(args);
        String path = "C:\\Users\\miche\\IdeaProjects\\whatsappminer\\input.txt";
        File test = new File(path);
        if(!test.exists()){
            System.out.println("Not such file");
            return;
        }
        List<Message> messages = ReadChat(path);
        Chat chat = new Chat(messages);
        chat.NumberOfMessagesPerUser();
    }
    private static List<Message> ReadChat(String path) throws FileNotFoundException {
        File input = new File(path);
        Scanner scanner = new Scanner(input);
        List<Message> messages = new ArrayList<Message>();
        while(scanner.hasNextLine()){
            Message temp = new Message(scanner.nextLine());
            if(!temp.isNull())
                messages.add(temp);
        }
        return messages;
    }
}