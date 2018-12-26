package edu.utcluj.track.position;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import javax.servlet.http.HttpServletResponse;


@Controller
public class AppControler {
String jwtToken = null;
    @RequestMapping(method = RequestMethod.GET, value ="/loginpage")
    public String login() {
        return "login.html";
    }

    @RequestMapping(method = RequestMethod.POST, value ="/loginpage")
    public String loginlogic() {
        jwtToken = "abcd";
        return "redirect:adminpage";
    }

    @RequestMapping(method = RequestMethod.GET, value="/adminpage")
    public String admin(HttpServletResponse httpServletResponse) {
            return "admin.html";
    }
}
