package com.baxance.songr;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String title;
    int length;
    int track;

    @ManyToOne
    Album songOf;

    public Song(String title, int length, int track, Album songOf) {
        this.title = title;
        this.length = length;
        this.track = track;
        this.songOf = songOf;
    }

    Song(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public Album getSongOf() {
        return songOf;
    }

    public void setSongOf(Album songOf) {
        this.songOf = songOf;
    }
}
