import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Chat {
    List<Message> messages;
    List<User> users;

    public Chat(List<Message> m){
        messages = m;
        users = new ArrayList<User>();
    }

    public int NumberOfMessages(){
        return messages.size();
    }
    public List<User> NumberOfMessagesPerUser(){
        for(Iterator<Message> iter = messages.iterator(); iter.hasNext();){
            Message m = iter.next();
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

    public void print(){
        for(Iterator<Message> iter = messages.iterator(); iter.hasNext();){
            Message m = iter.next();
            m.print();
        }
    }
}
