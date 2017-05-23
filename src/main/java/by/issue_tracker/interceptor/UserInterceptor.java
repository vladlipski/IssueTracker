package by.issue_tracker.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    @Qualifier("deniedForUnauthorizedActions")
    private Set<String> deniedForUnauthorizedActions;
    @Autowired
    @Qualifier("deniedForAuthorizedActions")
    private Set<String> deniedForAuthorizedActions;

    private static final String INDEX_PAGE = "index.jsp";
    private static final String USER = "user";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession(false);
        if (accessDenied(session, handler)) {
            response.sendRedirect(INDEX_PAGE);
            return false;
        }
        return true;
    }

    private boolean accessDenied(HttpSession session, Object handler) {
        boolean loggedIn = isLoggedIn(session);
        RequestMapping requestMapping = ((HandlerMethod) handler).getMethodAnnotation(RequestMapping.class);
        String action = requestMapping.value()[0];
        if (loggedIn && isDeniedActionForAuthorizedUser(action)) {
            return true;
        } else if (!loggedIn && isDeniedActionForUnauthorizedUser(action)) {
            return true;
        }
        return false;
    }

    private boolean isDeniedActionForUnauthorizedUser(String action) {
        return deniedForUnauthorizedActions.contains(action);
    }

    private boolean isDeniedActionForAuthorizedUser(String action) {
        return deniedForAuthorizedActions.contains(action);
    }

    private boolean isLoggedIn(HttpSession session) {
        if (session == null) {
            return false;
        } else {
            return session.getAttribute(USER) != null;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
