package com.baxance.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import java.util.List;

@Controller
public class SongController{

    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs/{id}")
    public String songs(Model m, @PathVariable long id){
        Album album = albumRepository.getOne(id);
//        Song songs = songRepository.findAllById();
        m.addAttribute("albumArray", album);
        return "songs.html";
    }

    @PostMapping("/songs/{id}")
    public RedirectView addSong(String title, int length, int track, @PathVariable long id){
        Album album = albumRepository.getOne(id);
        Song song = new Song(title, length, track, album);
        songRepository.save(song);
        System.out.println(song.title);
        System.out.println(song.length);
        System.out.println(song.track);
        return new RedirectView("/songs/{id}");
    }

    @DeleteMapping("/songs/{id}/{Albumid}")
    public RedirectView deleteSong(@PathVariable long id, @PathVariable ("Albumid") long Albumid){
        songRepository.deleteById(id);
        return new RedirectView("/songs/{Albumid}");
    }
}
