import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Test {
    static String[] options =
            {"Total messages number",
                    "Top used words",
                    "Number messagges per user",
                    "Messages per hour"};

    public static void Start(String p) throws FileNotFoundException {
        String path = "C:\\Users\\miche\\IdeaProjects\\whatsappminer\\input.txt";
        if(p != null){
            path = p;
        }
        Chat chat = new Chat(path);
        System.out.println("Decide which features to test:\n");
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            for (int i = 0; i < options.length; i++) {
                System.out.println(i + " - " + options[i]);
            }
            System.out.println("-1 - quit");
            int user_input = Integer.parseInt(scanner.nextLine());
            if (user_input == -1) {
                loop = false;
            } else {
                switch (user_input) {
                    case 0:
                        System.out.println("Number of messages: " + chat.NumberOfMessages());
                        break;
                    case 1:
                        System.out.println("Top 10 most used words: ");
                        List<Chat.WordC> words = chat.WordsCounter();
                        for (int j = 0; j < 10 && j < words.size(); j++) {
                            System.out.println((j + 1) + " - " + words.get(j).word + " -> " + words.get(j).istances);
                        }
                        break;
                    case 2:
                        List<User> users = chat.NumberOfMessagesPerUser();
                        for(int i = 0; i < users.size(); i++){
                            System.out.println(users.get(i).name + " -> " + users.get(i).counterMessages);
                        }
                        break;
                    case 3:
                        chat.message_clock.print();
                    default:
                        System.out.println("Input not recognized");
                }
            }
        }
    }
}
