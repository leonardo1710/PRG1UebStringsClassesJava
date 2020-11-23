package at.ac.fhcampuswien;

import at.ac.fhcampuswien.musiclibrary.Album;
import at.ac.fhcampuswien.musiclibrary.Single;
import at.ac.fhcampuswien.musiclibrary.Song;

public class App {
    Album[] albums = new Album[3];

    public static void main(String[] args){
        App app = new App();

        System.out.println("Create example album objects.");
        app.createExampleAlbums();

        System.out.println("Print objects:");
        app.printAlbums(app.albums);


        System.out.println("Print song author initials:");
        String initials = app.albums[0].getSongs()[0].getAuthorInitials();
        System.out.println(initials); //JF

        System.out.println(app.albums[0].getSongs()[1].getAuthorInitials()); //W

        System.out.println(app.albums[1].getSongs()[1].getAuthorInitials()); //BI


        System.out.println("Compare Song names:");
        Song s1 = app.albums[0].getSongs()[0];
        Song s2 = app.albums[0].getSongs()[1];
        boolean isNameSame = s1.hasSameName(s2);
        System.out.println("Same name? " + isNameSame);


        System.out.println("See if album has song with name: Nothing Else Matters");
        boolean hasSong = app.albums[1].findSong("Nothing Else Matters");
        System.out.println(hasSong);

        Song[] filtered = app.albums[0].filterSongsByKeyword("dad");
        Song[] filtered2 = app.albums[1].filterSongsByKeyword("e");
        System.out.println("Filter with keyword \"dad\":");
        app.printSongs(filtered);
        System.out.println("Filter with keyword \"e\":");
        app.printSongs(filtered2);

        System.out.println("Get album shortname: ");
        System.out.println(app.albums[0].getAlbumShortname());
        System.out.println(app.albums[2].getAlbumShortname());

        System.out.println("Replace Numbers in Strings: ");
        app.albums[2].replaceNumbersInName();
        System.out.println(app.albums[2].getName());


        //create an object of class Single
        Single single = new Single("Billie Jean",
                new Song[]{
                        new Song("Billie Jean", "Michael Jackson", 4.24),
                        new Song("Billie Jean extended", "Michael Jackson", 7.23)
                });
    }

    private void printSongs(Song[] songs){
        for(Song s: songs){
            System.out.println(s.toString());
        }
    }
    private void printAlbums(Album[] albums){
        for(Album a: albums){
            System.out.println(a.toString());
        }
    }

    public void createExampleAlbums(){
        Song[] songs = new Song[2];

        Song s1 = new Song("Feliz Navidad", "Jose Feliciano", 3.12);

        System.out.println("###################################");
        System.out.println(s1.toString());

        Song s2 = new Song("Last Christmas", "Wham!", 4.39);

        songs[0] = s1;
        songs[1] = s2;

        Album album = new Album("Christmas Special", songs);

        Album album2 = new Album("Best Of Rock No. 10");

        album2.setSongs(new Song[]{
                    new Song("Nothing Else Matters", "Metallica", 7.49),
                    new Song("Cradle of Love", "Billy Idol", 5.23)
                });

        Album album3 = new Album("U2", songs);

        albums[0] = album;
        albums[1] = album2;
        albums[2] = album3;
    }
}
