package by.issue_tracker.config;

import by.issue_tracker.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"by.issue_tracker.*"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private UserInterceptor userInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/views/**").addResourceLocations("/views/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.setInterceptors(userInterceptor);
        return requestMappingHandlerMapping;
    }

    @Bean
    @Qualifier("deniedForUnauthorizedActions")
    public Set<String> deniedForUnauthorizedActions() {
        Set<String> actions = new HashSet<>();
        actions.add("logOut");
        actions.add("projects");
        actions.add("upd-project");
        actions.add("del-project");
        actions.add("add-project");
        actions.add("comments");
        actions.add("upd-comment");
        actions.add("del-comment");
        actions.add("add-comment");
        actions.add("sprints");
        actions.add("upd-sprint");
        actions.add("del-sprint");
        actions.add("add-sprint");
        actions.add("tasks");
        actions.add("upd-task");
        actions.add("del-task");
        actions.add("add-task");
        actions.add("users");
        actions.add("upd-user");
        actions.add("del-user");
        actions.add("add-user");
        return actions;
    }

    @Bean
    @Qualifier("deniedForAuthorizedActions")
    public Set<String> deniedForAuthorizedActions() {
        Set<String> actions = new HashSet<>();
        actions.add("login");
        actions.add("signup");
        return actions;
    }
}
