import data.PlayListManager;

/***
 *     // Modify the playlist challenge so that the Album class uses an inner class.
 *     // Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
 *     // The inner SongList class will use an ArrayList and will provide a method to add a song.
 *     // It will also provide findSong() methods which will be used by the containing Album class
 *     // to add songs to the playlist.
 *     // Neither the Song class or the Main class should be changed.
 * **/
public class Challenge {

    public static void main(String[] args) {


      PlayListManager playlist = new PlayListManager();
      playlist.run();
}
}
