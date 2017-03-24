package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/spitters")
public class SpittersController {
    SpitterRepository spitterRepository;

    @Autowired
    public SpittersController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getSpitters(Model model) {
        List<Spitter> spitters = spitterRepository.findAllSpitters();
        model.addAttribute("spitters",spitters);
        return "spitters";
    }
}
