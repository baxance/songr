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

    @GetMapping("/")
    public String splash(Model model){
        return "index.html";
    }

}
