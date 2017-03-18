package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;
    private final static String MAX_LONG_AS_STRING = "9223372036854775807";

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null)
            throw new SpittleNotFoundException();
        model.addAttribute(spittle);
        return "spittle";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(@RequestParam(value = "max", defaultValue = "20") long max,
                                  @RequestParam(value = "count", defaultValue = "10") int count, Model model) {
       List<Spittle> spittleList = spittleRepository.findSpitles(max, count);
       model.addAttribute("spittleList", spittleList);
       return "spittlesView";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(Spittle spittle, Model model) {
        try {
            spittleRepository.save(new Spittle(spittle.getMessage(),new Date(),
                    spittle.getLongitude(),spittle.getLatitude()));
            return "redirect:/spittles";
        } catch (DuplicateSpittleException e) {
            return "error/duplicate";
        }
    }

}




















