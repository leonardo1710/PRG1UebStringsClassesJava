package at.ac.fhcampuswien.musiclibrary;

public class Single extends Album {

    private String name;
    private Song[] songs;

    private double length;

    private String a;


    public Single(String name) {
        super(name);
        this.a = "Hallo";
    }

    public Single(String name, Song[] songs) {
        super(name, songs);
    }



    @Override
    public String toString() {
        //return super.toString();

        return "Single name: " + this.name + System.lineSeparator() +
                "Single length: " + this.length + System.lineSeparator() +
                "Number songs: " + this.songs.length;


    }


}
