import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Chat {
    public class WordC{
        public String word;
        public int istances;
    }
    List<Message> messages;
    List<WordC> words;
    List<User> users;
    MessageClock message_clock;

    public Chat(List<Message> m){
        messages = m;
        users = new ArrayList<User>();
        message_clock = new MessageClock();
    }

    public int NumberOfMessages(){
        return messages.size();
    }
    private List<User> NumberOfMessagesPerUser(){
        for(Iterator<Message> iter = messages.iterator(); iter.hasNext();){
            Message m = iter.next();
            message_clock.Add(m.hour, m.pmam);
            boolean unique = true;
            for (Iterator<User> it = users.iterator(); it.hasNext();) {
                User u = it.next();
                if(u.name.equals(m.sender)) {
                    u.counterMessages++;
                    unique = false;
                    break;
                }
            }
            if(unique){
                users.add(new User(m.sender));
            }
        }
        for(User u: users){
            System.out.println(u.name + " has sent: " + u.counterMessages + " messages");
        }

        return users;
    }
    private List<WordC> WordsCounter(){
        words = new ArrayList<>();
        for (Iterator<Message> it = messages.iterator(); it.hasNext();) {
            Message m = it.next();
            for (String s: m.text.split(" ")) {
                int unique = 1;
                for (Iterator<WordC> et = words.iterator(); et.hasNext(); ) {
                    WordC w = et.next();
                    if(w.word.equals(s)){
                        w.istances = w.istances + 1;
                        unique = 0;
                        break;
                    }
                }
                if(unique == 1){
                    WordC temp = new WordC();
                    temp.word = s;
                    temp.istances = 1;
                    words.add(temp);
                }
            }
        }
        words = selectionSort(words);
        return words;
    }
    private List<WordC> selectionSort(List<WordC> input) {
        List<WordC> array = input;
        for(int i = 0; i < array.size()-1; i++) {
            int minimo = i; //Partiamo dall' i-esimo elemento
            for(int j = i+1; j < array.size(); j++) {
                //Qui avviene la selezione, ogni volta
                //che nell' iterazione troviamo un elemento piú piccolo di minimo
                //facciamo puntare minimo all' elemento trovato
                if(array.get(minimo).istances >array.get(j).istances) {
                    minimo = j;
                }
            }
            //Se minimo e diverso dall' elemento di partenza
            //allora avviene lo scambio
            if(minimo != i) {
                WordC k = array.get(minimo);
                array.get(minimo).word = array.get(i).word;
                array.get(minimo).istances = array.get(i).istances;
                array.get(i).word = k.word;
                array.get(i).istances = k.istances;
            }
        }
        return array;
    }
    public void print(boolean total_messages, boolean words_counter, boolean number_per_user, boolean messages_per_hour){
        if(total_messages){
            for(Iterator<Message> iter = messages.iterator(); iter.hasNext();){
                Message m = iter.next();
                m.print();
            }
        }
        if(words_counter){
            words = WordsCounter();
            int pos = 0;
            for (Iterator<WordC> it = words.iterator(); it.hasNext() && pos < 100; ) {
                WordC word = it.next();
                pos++;
                System.out.println(word.word + " - " + word.istances);
            }
        }
        if(number_per_user){
            NumberOfMessagesPerUser();
        }
        if(messages_per_hour){
            message_clock.print();
        }
    }

}
