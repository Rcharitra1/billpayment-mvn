package dmit2015.security;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
/**
 * @Version 2021-03-27
 * @Author R Charitra
 *
 * @Comments
 * This is controller class for logout
 *
 * */
@Named
@RequestScoped
public class Logout {

    @Inject
    private HttpServletRequest request;

    public String submit() throws ServletException {
        request.logout();
        request.getSession().invalidate();
        return "/index?faces-redirect=true";
    }
}