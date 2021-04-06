package com.baxance.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;

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
        System.out.println(library.get(0).title);
        System.out.println(library.get(1).artist);
        System.out.println(library.get(2).length);

    }

    @GetMapping("/")
    public String root(){
        return "index.html";
    }

    @GetMapping("/albums")
    public String albums(Model m){ // Model m = param that collects attributes/data that we want in the html

        m.addAttribute("albumArray", library);
//        Album earth = new Album(
//                "The Bees Made Honey in the Lions Skull",
//                "Earth",
//                7,
//                3206,
//                "https://southernlord.com/media/2018/03/Sunn90_Earth_Bees-666x666.jpg"
//        ); album.addAttribute("earth", earth);
//        Album axis = new Album(
//                "Axis Mundi",
//                "Brown Bird",
//                16,
//                3523,
//                "http://brownbird.net/wp-content/uploads/2015/02/Axis-Mundi-Cover1.jpg"
//        ); album.addAttribute("axis", axis);
//        Album clipping = new Album(
//                "Splendor & Misery",
//                "clipping.",
//                15,
//                2227,
//                "https://upload.wikimedia.org/wikipedia/en/c/cf/Clipping._-_Splendor_%26_Misery.jpg"
//        ); album.addAttribute("clipping", clipping);

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


}
