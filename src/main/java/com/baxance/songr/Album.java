package com.baxance.songr;

public class Album {
    String title;
    String artist;
    int songCount;
    int length;
    String imageURL;

public Album(String title, String artist, int songCount, int length, String imageURL){
    this.title = title;
    this.artist = artist;
    this.songCount = songCount;
    this.length = length;
    this.imageURL = imageURL;
}

public String getTitle(){ // <- getter
    return title;
}

/*
public String setTitle(String title){ // <- setter
    this.title;
}
 */

public String getArtist(){
    return artist;
}

public int getSongCount(){
    return songCount;
}

public int getLength(){
    return length;
}

public String getImageURL(){
    return imageURL;
}

}

