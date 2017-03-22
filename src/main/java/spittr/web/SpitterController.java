package spittr.web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
//       to be able to post new spittler from registerForm
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            /*@RequestPart("profilePicture") byte[] profilePicture,*/
            @Valid SpitterForm spitterForm, Errors errors, RedirectAttributes model) throws IllegalStateException,IOException {

        System.out.println("before founding errors");

        if (errors.hasErrors())
            return "registerForm";

        System.out.println("found no erroes");

        Spitter spitter = spitterForm.toSpitter();
        spitterRepository.save(spitter);

        MultipartFile profilePicture = spitterForm.getProfilePicture();
        profilePicture.transferTo(new File("/uploads/" + spitter.getUsername() + ".jpg"));

        model.addAttribute("username", spitter.getUsername());
        // attribute survive redirect and after session finished disappear with flash attribute
        model.addFlashAttribute("spitter", spitter);
        return "redirect:/spitter/{username}"; // alternative: + spitter.getUsername();
    }



    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable("username") String username, Model model) {
        // after session ends add attribute to a model again
        if (!model.containsAttribute("spitter")) {
            model.addAttribute(spitterRepository.findByUsername(username));
        }
        return "profile";
    }
}












