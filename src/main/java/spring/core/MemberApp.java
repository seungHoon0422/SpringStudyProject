package spring.core;

import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {


//        @Configuration, @Bean을 사용하지 않고 DI 하는 방식
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();


        // spring container는 기본적으로 application context 부터 시작
        ApplicationContext ac = new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }



}
