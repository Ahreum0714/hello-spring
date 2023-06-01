package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * SpringConfig 방식의 장점: 다른 영역의 코드 변경 없이 구현 클래스만 수정하면 됨
 *
 * e.g. return new MemoryMemberRepository();
 *       ==> return new DbMemberRepository();
 * */
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

/*    @Bean //SpringConfig에서 직접 빈 등록하거나, TimeTraceAop클래스에 @Component 해주거나!
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/
    
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

}
