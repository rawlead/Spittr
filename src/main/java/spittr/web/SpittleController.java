package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    //@Autowired
//    private SpittleRepository spittleRepository;
//
//    @Autowired
//    public SpittleController(SpittleRepository spittleRepository) {
//        this.spittleRepository = spittleRepository;
//    }


    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        List<Spittle> spittles = createSpittleList(30);
        model.addAttribute("spittleList", spittles);
//        model.addAttribute("spittleList",
//                spittleRepository.findSpitles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}
