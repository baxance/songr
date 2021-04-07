package com.baxance.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Controller
public class SongrController {
    static ArrayList<Album> library = new ArrayList<>();
    static {
        library.add(
                new Album("The Bees Made Honey in the Lions Skull",
                        "Earth",
                        7,
                        3206,
                        "https://southernlord" +
                                ".com/media/2018/03/Sunn90_Earth_Bees-666x666.jpg")
        );
        library.add(
                new Album("Axis Mundi",
                        "Brown Bird",
                        16,
                        3523,
                        "http://brownbird" +
                                ".net/wp-content/uploads/2015/02/Axis-Mundi-Cover1.jpg")
        );
        library.add(
                new Album("Splendor & Misery",
                        "clipping.",
                        15,
                        2227,
                        "https://upload.wikimedia" +
                                ".org/wikipedia/en/c/cf/Clipping._-_Splendor_%26_Misery.jpg")
        );
    }


    @Autowired
    public AlbumRepository albumRepository;

    @GetMapping("/")
    public String splash(Model model){
        return "index.html";
    }

    @GetMapping("/albums")
    public String albums(Model m){ // Model m = param that collects attributes/data that we want in the html
        List<Album> library = albumRepository.findAll();
        m.addAttribute("albumArray", library);
//        System.out.println("id: " + library.get(0).id);
        return "albums.html";
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello-world.html";
    }

    @GetMapping("/capitalize/{word}")
    public String renderCapitalize(
            @PathVariable String word
        ){
        return "capitalize.html";
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

//    @PutMapping("/albums/{id}")
//    public RedirectView updateAlbum(@PathVariable long id,
//        String imageURL,
//        String title,
//        String artist,
//        int songCount,
//        int length
//    ){
//        Album entry = new Album(artist, title, songCount, length, imageURL);
//        albumRepository.(entry);
//        return new RedirectView("/albums");
//    }

//    @RequestMapping(value = "/albums/{id}", method = RequestMethod.POST)
//    public RedirectView updateAlbum(@ModelAttribute("id"), @PathVariable long id){
//
//    }
}
