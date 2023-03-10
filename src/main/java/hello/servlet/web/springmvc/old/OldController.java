package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("/springmvc/old-controller")  // 스프링 빈의 이름이 /springmvc/old-controller 가 된다.
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");  // WEB-INF 의 new-form 으로 이동하도록 (논리 이름만 넣은것이다. -> 뷰 리졸버에서 물리적인 이름으로 바뀌도록)
    }
}
