package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import spittr.daoimpl.SpitterRepositoryImpl;
import spittr.daoimpl.SpittleRepositoryImpl;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;
import spittr.web.SpittleController;

@Configuration
@EnableWebMvc
//@EnableJpaRepositories("spittr.data")
@ComponentScan(basePackages = {"spittr"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
         /* configure static content handling */
        configurer.enable();
    }

//     spittle

//    @Bean
//    public SpittleRepository spittleRepository() {
//        return new SpittleRepositoryImpl();
//    }

//    @Bean
//    public SpittleController spittleController(SpittleRepository spittleRepository) {
//        return new SpittleController(spittleRepository);
//    }
//
//    //spitter
//    @Bean
//    public SpitterRepository spitterRepository() {
//        return new SpitterRepositoryImpl();
//    }

}














