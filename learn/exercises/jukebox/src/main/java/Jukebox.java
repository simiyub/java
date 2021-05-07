public interface Jukebox {
    int play();
    int nextSong();
    int previousSong();
    int shuffle();
    int playSong(String title);
}
