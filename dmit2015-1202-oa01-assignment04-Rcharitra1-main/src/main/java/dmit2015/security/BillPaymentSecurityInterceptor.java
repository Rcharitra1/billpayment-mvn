package dmit2015.security;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.security.enterprise.SecurityContext;

/**
 * @Version 2021-03-27
 * @Author R Charitra
 *
 * @Comments
 * This interceptor class for bill payments. This enables protection on method level should the url moves to another
 * location, the methods are locked and are accessible only if the user is in either ADMIN or REGISTER_USER
 *
 * */

public class BillPaymentSecurityInterceptor {

    @Inject
    private SecurityContext _securityContext;

    @AroundInvoke
    public Object verifyAccess(InvocationContext ic) throws Exception {
        String methodName = ic.getMethod().getName();
        if (methodName.toLowerCase().startsWith("find") ||
                methodName.toLowerCase().startsWith("delete") || methodName.toLowerCase().startsWith("update")) {
            boolean havePermission = _securityContext.isCallerInRole("REGISTER_USER") || _securityContext.isCallerInRole("ADMIN");
            if (!havePermission) {
                throw new RuntimeException("Access denied. You do not have permission to execute this method.");
            }
        }

        return ic.proceed();
    }
}
