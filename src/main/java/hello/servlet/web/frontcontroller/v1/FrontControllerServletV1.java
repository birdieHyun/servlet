package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*") // * 모양은 v1/ 하위에 어떤 url이 들어와도 일단 이 서블릿을 호출한다.
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        // 요청이 오면 Map 으로 어떤 컨트롤러를 호출해야 하는지 찾고 컨트롤러를 호출해서 html 응답이 나갈것이다.
        String requestURI = request.getRequestURI();
        ControllerV1 controller = controllerMap.get(requestURI);
        /*
         주소에 따라서 호출되는 컨트롤러가 달라질 것이다.
         만약 members/new-form 이라면 new MemberFormControllerV1 이 생성될 것이고
         members/save 라면 new MemberSaveControllerV1 이 생성될 것이다.
         이것이 다형성!!
         */
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 페이지가 없으면 404
            return;
        }
        // null 이 아니라 잘 호출되었다면 controller. process 진행
        controller.process(request, response);
    }
}
