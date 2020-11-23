package data;

import java.util.*;

public class PlayListManager {

    PlayList playList;
    Scanner ui;
    static final String NEXT = "NEXT";
    static final String PREVIOUS = "PREVIOUS";
    Song play;
    int playIndex=0;
    List<Album> albums;
    private boolean forward;

    public void run() {

        ui = new Scanner(System.in);
        playList = new PlayList();
        albums = playList.library();
        for (Album album:albums){
            playList.add(album.getSongs());
        }

        boolean run = true;
        while(run) {

            System.out.println("Please select an option from the menu below:");
            playList.printMenu();
            int selection = ui.nextInt();
            ui.nextLine();
            switch (selection) {
                case 1:
                    playList.playSong();
                    break;
                case 2:
                    playList.replay();
                    break;
                case 3:
                    playList.back();
                    break;
                case 4:
                    playList.next();
                    break;
                case 5:
                    playList.showSongsInPlaylist();
                    break;
                case 6:
                    playList.showSongsInLibrary();
                    break;
                case 7:
                    playList.addSong();
                    break;
                case 8:
                    playList.removeSong();
                    break;
                case 9:
                    playList.quit();
                    run=false;
                    break;
                case 0: default:
                    playList.printMenu();
                    break;

            }
        }
    }

    private class PlayList {
        private LinkedList<Song> playList;
        private ListIterator<Song> iterator;
        PlayList(){
            playList = new LinkedList<>();
            iterator = playList.listIterator();
        }
        public void showSongsInPlaylist() {

            if(playList.size()==0){
                System.out.println("There are no songs in this playlist.");
            }
            else{
                System.out.println("Songs in the playlist are:");
                printSongs(playList);
            }
        }

        public void add(List<Song> songs) {
            playList.addAll(songs);
        }

        public void remove(String songName) {
            for (Song song : playList) {
                if (songName.equalsIgnoreCase(song.getName())) {
                    playList.remove(song);
                    System.out.println(songName+" removed from playlist.");
                    return;
                }
            }
            System.out.println(songName+" is not in the playlist");
        }

        public void play(String request) {
            if(!request.equalsIgnoreCase(NEXT) && !request.equalsIgnoreCase(PREVIOUS)){
                System.out.println("Playing.."+request);
            }
            else{

                if(request.equalsIgnoreCase(NEXT)) {
                    if(!forward){
                        if(iterator.hasNext()) {
                            iterator.next();
                        }
                        forward=true;
                    }

                    if (iterator.hasNext()) {
                        play = iterator.next();
                        System.out.println("Playing.." + play.getName());
                    }
                    else{
                        System.out.println("You've reached the end of the playlist.");
                        forward = false;
                    }
                }
                else if(request.equalsIgnoreCase(PREVIOUS)){
                    if(forward){
                        if(iterator.hasPrevious()){
                            iterator.previous();
                        }
                        forward=false;
                    }
                    if(iterator.hasPrevious()){
                        play=iterator.previous();
                        System.out.println("Playing.."+play.getName());
                    }
                    else{
                        System.out.println("You are at the start of the playlist.");
                        forward=true;
                    }


                }
            }
        }
    private void removeSong() {
        System.out.println("Which song do you want to remove from the playlist?");
        String songName = ui.nextLine();
        playList.remove(songName);
    }

    private void addSong() {
        System.out.println("Which song do you want to add from your library?");
        String songName=ui.nextLine();
        Song song = songFromLibrary(songName);
        if(song!=null){
            if(!songInPlayList(songName)){
                playList.add(song);
            }
            else {
                System.out.println(songName+" is in your playlist already.");
            }

        }
        else{
            System.out.println("Song not in your library.");
        }
    }

    private void showSongsInLibrary() {
        if(albums.size()==0){
            System.out.println("There is no music in your library.");
        }
        else {
            System.out.println("Songs in your library are:");
            for (Album album : albums) {
                printSongs(album.getSongs());
            }
        }
    }
    private boolean songInPlayList(String songName) {
        if(playList.size()==0){
            System.out.println("There are no songs in this playlist.");
        }
        else{
            for (Song song: playList){
                if(song.getName().equalsIgnoreCase(songName)){
                    return true;
                }
            }
        }

        return false;
    }

    private Song songFromLibrary(String songName) {
        if(albums.size()==0){
            System.out.println("There are no songs in your library.");
        }
        else{
            for(Album album:albums){
                for (Song song:album.getSongs()){
                    if(songName.equalsIgnoreCase(song.getName())){
                        return song;
                    }
                }

            }
        }
        return null;
    }

    private List<Album> library() {
        List<Album> library = new ArrayList<>();

        Song[] feelingsSongs = new Song []{
                Song.newSong("love", "Feelings", "New Sound",4.5),
                Song.newSong("hate", "Feelings", "New Sound",4),
                Song.newSong("jealousy", "Feelings", "New Sound",3.5),
                Song.newSong("sadness", "Feelings", "New Sound",5),
                Song.newSong("joy","Feelings", "New Sound",6),
                Song.newSong("disappointment", "Feelings", "New Sound",3)};
        Album feelings = Album.newAlbum("Feelings", "New Sound",feelingsSongs );

        Song[] jesusSongs = new Song []{
                Song.newSong("saviour", "Saviour King", "David", 2.5),
                Song.newSong("protector", "Saviour  King", "David", 3),
                Song.newSong("I know your name", "Saviour King", "David", 5),
                Song.newSong("Those who know your name", "Saviour King", "David", 4)
        };
        Album saviourKing = Album.newAlbum("Saviour King", "David", jesusSongs);

        library.add(saviourKing);
        library.add(feelings);

        return library;
    }

    private void quit() {
        System.out.println("exiting..");
        //exit the player
    }


    private void printSongs(List<Song> list) {
        for (Song song:list){
            System.out.println(song.toString());
        }
    }

    private void next() {
        System.out.println("Going Next..");
        play(NEXT);
    }

    private void back() {
        System.out.println("Going back..");
        play(PREVIOUS);
    }


    private void replay() {
        System.out.println("Replaying..");
        if(play!=null){
            play(play.getName());
        }
        else{
            System.out.println("No tune currently playing.");
        }

    }

    private void playSong() {
        //show song playing
        //Show next song
        //Show previous song
        System.out.println("What song do you want to play?");
        String songName=ui.nextLine();

        play=null;
        for(int i=0;i<playList.size();i++){
            Song song = playList.get(i);
            if(playList.get(i).getName().equalsIgnoreCase(songName)){
                play=song;
                playIndex=i;
                break;
            }
        }

        if(play!=null){
            play(play.getName());
        }
        else {
            System.out.println(songName+" is not in the playlist");
        }

    }

    private void printMenu() {
        System.out.println("Actions Available:\n" +
                "===================================\n" +
                "0-Print Menu\n" +
                "1-Play, 2-Replay, 3-Back, 4-Next\n" +
                "5-Show songs in the playlist\n" +
                "6-Show songs in entire library\n" +
                "7-Add Song To Playlist\n" +
                "8-Remove Song From Playlist\n" +
                "9-Quit\n" +
                "==================================");
    }


    }
}
