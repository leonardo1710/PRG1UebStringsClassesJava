package at.ac.fhcampuswien.musiclibrary;

import java.util.Arrays;

public class Album {
    private String name;
    private Song[] songs;

    private double length;

    public Album(String name){
        this.name = name;
        this.length = 0;
    }

    public Album(String name, Song[] songs){
        this.name = name;
        this.songs = songs;

        double overallLength = 0;
        for(Song song: songs){
            overallLength += song.getLength();
        }
        this.length = overallLength;
    }

    public void setSongs(Song[] songs){
        this.songs = songs;
    }

    public Song[] getSongs(){
        return this.songs;
    }

    public String getName(){
        return this.name;
    }

    public boolean findSong(String name){
        for(Song song: songs){
            if(song.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    // gets the first 3 letters of an album (if 3 letters exist)
    public String getAlbumShortname(){
        if(this.name.length() > 2){ //check if even has 3 letters
            return this.name.substring(0, 3);
        }

        return this.name;
    }

    public Song[] filterSongsByKeyword(String keyword){
        int origLength = this.songs.length;
        Song[] filteredSongs = new Song[origLength];

        for(int i = 0; i < this.songs.length; i++){
            if(this.songs[i].getName().contains(keyword)){
                filteredSongs[i] = this.songs[i];
            }
        }

        filteredSongs = removeNullsFromArray(filteredSongs);

        return filteredSongs;

    }

    private Song[] removeNullsFromArray(Song[] songs){
        songs = Arrays.stream(songs)
                .filter(s -> (s != null))
                .toArray(Song[]::new);

        return songs;
    }

    @Override
    public String toString(){
        return "Album name: " + this.name + System.lineSeparator() +
                "Album length: " + this.length + System.lineSeparator() +
                "Number songs: " + this.songs.length;
    }

    //replace all numbers with & signs in name
    public void replaceNumbersInName(){
        this.name = this.name.replaceAll("[0-9]+", "&"); //use regular expressions
        // or
        //this.name = this.name.replaceAll("\\d+", "&");  //+ means one or more times
    }
}
