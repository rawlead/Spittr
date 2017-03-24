package spittr.web;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.net.URLConnection;

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
        model.addAttribute(new SpitterForm());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @Valid SpitterForm spitterForm, Errors errors) throws IOException {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        Spitter spitter = spitterForm.toSpitter();
        spitterRepository.save(spitter);

        MultipartFile profilePicture = spitterForm.getProfilePicture();
        File file = new File("/tmp/spittr/" + spitter.getUsername() + ".jpg");
        profilePicture.transferTo(file);

        return "redirect:/spitter/" + spitter.getUsername();
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        // after session ends add attribute to a model again
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

    @RequestMapping(value = "/{username}/profilePicture")
    public void getUploadedPicture(@PathVariable String username, HttpServletResponse response) throws IOException {
        PathResource pathResource = new PathResource("/tmp/spittr/"+ username +".jpg");
        response.setHeader("Content-Type",
                URLConnection.guessContentTypeFromName(pathResource.getFilename()));
        IOUtils.copy(pathResource.getInputStream(),response.getOutputStream());
    }



    @RequestMapping(method = RequestMethod.GET)
    public String searchForSpitter(@RequestParam String username) {
        if (!spitterRepository.spitterExists(username) || username == null)
            throw new SpitterNotFoundException();
        return "redirect:/spitter/" + username;
    }

    @ExceptionHandler(SpitterNotFoundException.class)
    public String handlNotFound() {
        return "notFound";
    }




}












