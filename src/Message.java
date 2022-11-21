import java.util.Date;

public class Message {

    String date, time, sender, text;

    public Message(String data){
        String line[] = data.split(" - ");

        if(line.length >= 2){
            // info

            String info[] = line[0].split(" ");
            if(info.length >= 3){
                date = info[0].substring(0, info[0].length() - 1);
                time = info[1] + info[2];
            }


            // message

            String message[] = line[1].split(": ");
            if(message.length >= 2){
                sender = message[0];
                text = message[1];
            }

        }

    }
    public boolean isNull(){
        if(date == null || time == null || sender == null || text == null){
            return true;
        }
        return false;
    }
    public void print(){
        System.out.println(date + " " + time + " " + sender + ": " + text);
    }
}
