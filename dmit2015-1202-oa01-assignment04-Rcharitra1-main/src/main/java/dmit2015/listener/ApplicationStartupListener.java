package dmit2015.listener;

import dmit2015.entity.CallerUser;
import dmit2015.repository.CallerUserRepository;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;


/**
 * @Version 2021-03-27
 * @Author R Charitra
 *
 * @Comments
 * Creates default users for the application using code first approach
 *
 * */
@WebListener
public class ApplicationStartupListener implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(ApplicationStartupListener.class.getName());

    @Inject
    CallerUserRepository callerUserRepository;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (callerUserRepository.list().size() == 0) {
            logger.info("Creating default accounts for application");
            CallerUser user1 = new CallerUser();
            user1.setUsername("larry@3stooges.com");
            callerUserRepository.add(user1, "Password2015", new String[]{"ADMIN"});
            CallerUser user2 = new CallerUser();
            user2.setUsername("curly@3stooges.com");
            callerUserRepository.add(user2, "Password2015", new String[]{"REGISTER_USER"});
            CallerUser user3 = new CallerUser();
            user3.setUsername("moe@3stooges.com");
            callerUserRepository.add(user3, "Password2015", new String[]{"REGISTER_USER"});
        } else {
            logger.info("Application has user accounts");
        }
    }
}