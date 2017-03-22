package spittr;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import spittr.Spitter;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;
import spittr.web.SpitterController;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {


    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "rawlead@gmail.com","Jack", "Bauer");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "rawlead@gmail.com", "Jack", "Bauer");
       // when(mockRepository.save(unsaved)).thenReturn(saved);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/spitter/register")
                .param("username", "jbauer")
                .param("password", "24hours")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
        )
                .andExpect(redirectedUrl("/spitter/jbauer"));
        verify(mockRepository, atLeastOnce()).save(unsaved);
    }


//    @Test
//    public void shouldShowRegistration() throws Exception {
//        SpitterController controller = new SpitterController(SpitterRepository);
//        MockMvc mockMvc = standaloneSetup(controller).build();
//        mockMvc.perform(get("/spitter/register"))
//                .andExpect(view().name("registerForm"));
//    }
}
