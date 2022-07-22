package Kim.OwnHub.git;

import org.apache.logging.log4j.util.Strings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Controller {

    public String getSession(HttpServletRequest res, String sessionName){

        HttpSession session = res.getSession();
        String result = session.getAttribute(sessionName).toString();

        return result;
    }

    public void setSession(HttpServletRequest res, int sessionTime, String sessionName, String attribute){

        HttpSession session = res.getSession();
        session.setAttribute(sessionName, attribute);
        session.setMaxInactiveInterval(sessionTime);

    }


}
