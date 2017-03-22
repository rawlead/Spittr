package spittr.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;


public class SpittrWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    //    configure multipart details
//    for files upload

    // limit files to no more than 2 MB,
    // limit the entire request to no more than 4 MB,
    // write all files to disk.
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/uploads",
                        2097152, 4194304, 0));
    }
}
