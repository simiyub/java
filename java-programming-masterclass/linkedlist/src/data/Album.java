package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Album {
    private final String name;
    private List<Song> songs;
    private final String singer;

    private Album(String name, String singer, List<Song> songs) {
        this.name = name;
        this.singer=singer;
        this.songs = songs;
    }

    public static Album newAlbum(String name, String singer, Song[] songs) {
        return new Album(name, singer, Arrays.asList(songs));
    }

    public Song song(String name) {

        for (Song song:songs) {
            if (song.getName().equalsIgnoreCase(name)) {
                return song;
            }
        }
        System.out.println(name+" not in album"+getName());
        return null;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getSinger() {
        return singer;
    }
}
