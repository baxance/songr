package com.baxance.songr;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(columnDefinition = "TEXT")
    public String title;

    @OneToMany(mappedBy ="songOf", cascade = CascadeType.ALL)
    public List<Song> songs;

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

Album(){}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getTitle(){ // <- getter
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getArtist(){
    return artist;
}

public void setArtist(String artist) {
    this.artist = artist;
}

public int getSongCount(){
    return songCount;
}

public void setSongCount(int songCount) {
    this.songCount = songCount;
}

public int getLength(){
    return length;
}

public List<Song> getSongs() {
    return songs;
}

public void setLength(int length) {
    this.length = length;
}

public String getImageURL(){
    return imageURL;
}

public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
}

}

