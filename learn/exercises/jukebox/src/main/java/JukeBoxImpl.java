import java.util.*;

public class JukeBoxImpl implements Jukebox {
    private List<String> songs;
    private Map<String,Integer> requestList;
    private int currentSong;
    private final int minimumRequestsToBuySong=2;

    JukeBoxImpl(){
        songs = new ArrayList();
        songs.add("Sunny Day");
        songs.add("It's hot");
        songs.add("where did you go");
        songs.add("when will I see you again.");
        songs.add("ancient of days");
        songs.add("victor's crown");
        requestList = new HashMap();
    }

    private boolean canPlay(){
        return songs.size()>0;
    }

    private void notifyErrorState(){
        System.out.println("playlist is empty.");
            }


    @Override
    public int play() {
        int played = -1;
        if(canPlay()){
            notifyPlaying();
            played = 0;
        }

        else {
            notifyErrorState();
        }
        return played;
    }

    private void notifyPlaying() {
        System.out.println("Playing "+songs.get(currentSong));
    }

    @Override
    public int nextSong() {
        if(currentSong>= songs.size()-1) resetCurrentSong();
            currentSong++;
        return play();

    }

    @Override
    public int previousSong() {
        return play();
    }

    @Override
    public int shuffle() {
        Collections.shuffle(songs);
        resetCurrentSong();
        return currentSong;
    }

    private void resetCurrentSong() {
        currentSong = 0;
    }

    @Override
    public int playSong(String title) {
        int played =  -1;
        int index = songs.indexOf(title);
        if (index != -1) {
            currentSong = index;
            return play();
        }
        else {

            played = 0;
            request(title);

            if(canBuySong(title)){
                boolean bought = buy(title);

                if(bought){
                    currentSong = songs.indexOf(title);
                    playSong(title);
                }
            }
            else{
                System.out.println("Song not available.");
            }
        }
        return played;

    }

    private int playSong(int index){
        currentSong = index;
        return play();
    }

    private boolean buy(String title) {
        return songs.add(title);
    }

    private boolean canBuySong(String title) {
        return requestList.get(title)>minimumRequestsToBuySong;
    }

    private void request(String title) {
        int count = requestList.getOrDefault(title,0);
        requestList.put(title,++count);
    }
}
