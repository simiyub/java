package data;

public class Song {
    private final String name;
    private final double duration;
    private final String album;
    private final String singer;

    private Song(String name, String album, String singer, double duration) {
        this.name=name;
        this.duration=duration;
        this.album = album;
        this.singer = singer;
    }
    public static Song newSong(String name, String album, String singer, double duration){
        return new Song(name,album,singer,duration);
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    public String getAlbum() {
        return album;
    }

    public String getSinger() {
        return singer;
    }

    @Override
    public String toString() {
        return getName()+" by "+getSinger()+" from the album "+getAlbum();
    }
}
