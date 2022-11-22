public class MessageClock {
    int[] hours;
    public MessageClock(){
        hours = new int[24];
        for(int i = 0; i < 24; i++){
            hours[i] = 0;
        }
    }
    public void Add(int hour, String timing){
        if(timing == "AM"){
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
