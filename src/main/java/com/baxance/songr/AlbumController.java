package com.baxance.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    public AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String albums(Model m){ // Model m = param that collects attributes/data that we want in the html
        List<Album> library = albumRepository.findAll();
        m.addAttribute("albumArray", library);
        return "albums.html";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(
            String imageURL,
            String title,
            String artist,
            int songCount,
            int length
    ){
        Album entry = new Album(artist, title, songCount, length, imageURL);

        albumRepository.save(entry);
        return new RedirectView("/albums");
    }

    @DeleteMapping("/albums/{id}")
    public RedirectView deleteAlbum(@PathVariable long id){
        albumRepository.deleteById(id);
        return new RedirectView("/albums");
    }
}
