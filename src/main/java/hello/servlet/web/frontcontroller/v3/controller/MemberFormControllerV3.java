package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ModelAndView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        return new ModelAndView("new-form"); // 논리적인 이름은 스스로 정해야 한다. 경로이름이 아닌 논리적 이름 사용하기
    }

}
