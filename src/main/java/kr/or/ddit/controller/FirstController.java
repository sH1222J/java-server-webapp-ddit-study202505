package kr.or.ddit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

//
// 애너테이션(annotation)이란? 소스 코드에 추가해 사용하는 메타 데이터의 일종.
// 타 데이터는 프로그램에서 처리해야 할 데이터가 아니라 컴파일 및 실행 과정에서 코드를
// 어떻게 처리해야 할지 알려 주는 추가 정보. 자바에서 어노테이션은 앞에 @기호를 붙여 사용.
//
//스프링 프레임워크에게 이 클래스는 특별한 클래스임을 알려줌
//자바빈(객체)으로 등록한 후 메모리에 미리 new를해서 업로드 함

@Slf4j
@Controller
public class FirstController {

    // 메서드 작성
    @GetMapping("/hi")
    public ModelAndView niceToMeetYou() {
//            model : 데이터(String, int, List, map, VO ...)
//            View : 뷰의 경로
        ModelAndView mav = new ModelAndView();
        mav.setViewName("greetings");
        //model 객체가 "성호" 값을 "username"속성에 연결해 웹 브라우저로 보냄
        mav.addObject("username","성호");
        mav.addObject("myfriend","없슴다");

        // greetigns.mustacth 파일을 반환

        return mav;

    }

    /*

  //요청URI : /bye
    //요청파라미터 :
    //요청방식 : get
    //URL 요청 접수
    //1. 컨트롤러는 골뱅이Controller 내부에 골뱅이GetMapping 어노테이션을 통해
    // 클라이언트의 요청을 받음
    public String seeYouNext(){//2. 메서드 작성 : /bye 요청을 처리

            // 3. goodbye.mustache  변환
     */
    @GetMapping("/bye")
    public String seeYouNext(Model model){ // 2. 메서드 작성 : /bye 요청을 받아오기
        // 반환값은 요청에 따라 보여 줄 뷰 템플릿 페이지를 적음
        // model.addAttribute("속성", "값");

        model.addAttribute("nickname", "개떵이");

        // mav.setViewName("goodbye")
        // /template/goobye.mustache를 포워딩
        return "goodbye";
    }

    /*
        요청URI : /articles/new
        요청파라미터 :
        요청방식 : get
        */
    //2. URL 요청 접수
    //뷰 페이지를 보여 주기 위해 newArticleForm() 메서드를 추가함

@GetMapping("/articles/new")
    public String newArticleForm(){//3. 메서드 생성
        // 4. 반환값 작성 : 뷰 페이지의 이름을 적음.
        // articles 디렉터리를 만들고 new.mustache 뷰 페이지를 추가했으므로

    // 파일 경로까지 포함해서 입력
    // 뷰리졸버 조립 : /templates/ + articles/new + .mustache
    // (해석)new_mustache.java -> (컴파일)new_mustache.class
    // (처리완료)html => 포워딩
    //        return "articles/new";
    return "articles/new";


    }


    // GetMapping 대신 PostMapping 애너테이션을 사용함.
// 뷰 페이지에서 폼 데이터를 post 방식으로 전송했으므로 컨트롤러에서 받을 때도
//  PostMapping으로 받음. 이 때 괄호 안에는 받는 URL 주소를 넣음.
// new.mustache에서 <form> 태그에 action="/articles/create"로 설정했음을 기억하자

    @PostMapping("/articles/create")
public String createArticle(){
    log.info("createArticle에 왔다.");
    // get방식으로 /articles/create/new을 재요청
    return "redirectt:/articles/new";
}






}


