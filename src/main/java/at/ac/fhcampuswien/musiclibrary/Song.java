package at.ac.fhcampuswien.musiclibrary;

public class Song {
    private String name, author, songwriter;
    private double length;


    public Song(String name, String author, double length){
        this.name = name;
        this.author = author;
        this.songwriter = "";
        this.length = length;
    }

    public double getLength(){
        return length;
    }

    public String getName(){
        return this.name;
    }

    public String getAuthorInitials(){
        String[] author = this.author.split(" ");   // split if > 1 word

        StringBuilder initials = new StringBuilder();
        //get first char from each word of author and append it to initials
        for(int i = 0; i < author.length; i++){
            initials.append(author[i].charAt(0));
        }

        return initials.toString();
    }

    public boolean hasSameName(Song songToCompare){
        return songToCompare.name.equals(this.name);
    }

    @Override
    public String toString(){
        return "Song name: " + this.name;
    }
}
