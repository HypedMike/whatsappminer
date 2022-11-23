public class MessageClock {
    int[] hours;
    public MessageClock(Chat chat){
        hours = new int[24];
        for(int i = 0; i < 24; i++){
            hours[i] = 0;
        }
        for(int i = 0; i < chat.messages.size(); i++){
            Add(chat.messages.get(i).hour, chat.messages.get(i).pmam);
        }
    }
    public void Add(int hour, String timing){
        if(timing.equals("AM")){
            hours[hour]++;
        }else{
            hours[hour + 12]++;
        }
    }
    public void print(){
        for(int i = 0; i < 24; i++){
            System.out.println((i + 1) + " - " + hours[i]);
        }
    }
}
