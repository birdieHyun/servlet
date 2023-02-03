package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class SpringMemberSaveControllerV1 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();


    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest request) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
//        mv.getModel().put("member", member);  이 방식처럼 모델을 찾아서 넣어 주는 것이 아니라 밑의 코드처럼 하는 것이 더 깔끔하다.
        mv.addObject("member", member);
        return mv;
    }
}
