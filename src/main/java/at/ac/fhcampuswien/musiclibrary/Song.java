package at.ac.fhcampuswien.musiclibrary;

public class Song {
    private String name, author;
    private double length;

    public Song(String name, String author, double length){
        this.name = name;
        this.author = author;
        this.length = length;
    }

    public double getLength(){
        return this.length;
    }

    public String getName(){
        return this.name;
    }

    public String getAuthorInitials(){
        String[] authorNames = this.author.split(" ");   // split if > 1 word

        StringBuilder initials = new StringBuilder();

        //get first char from each word of author and append it to initials
        for(int i = 0; i < authorNames.length; i++){
            initials.append(authorNames[i].charAt(0));
        }

        return initials.toString();
    }

    public boolean hasSameName(Song songToCompare){
        return songToCompare.name.toUpperCase().equals(this.name.toUpperCase());
    }

    @Override
    public String toString(){
        return "Song name: " + this.name;
    }
}
