package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach //각 테스트가 종료될때마다 실행
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){

        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //tehn
        Member findMember = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(findMember).isEqualTo(member);

    }

    @Test
    void findAll(){

        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1, member2);

    }

    @Test
    void isNotEqualToTest(){
        Member member1 = new Member("홍길동", 20);
        Member member2 = new Member("이순신", 30);

        Assertions.assertThat(member1).isNotEqualTo(member2);
    }

    @Test
    void isSameAsTest(){

        Member member1 = new Member("이순신", 20);
        Member clone   = member1;

        Assertions.assertThat(member1).isSameAs(clone);
    }

    @Test
    void isNotSameAsTest() {
        Member member1 = new Member("홍길동", 20);
        Member member2 = new Member("이순신", 20);

        Assertions.assertThat(member1).isNotSameAs(member2);
    }

    @Test
    void isInstanceOfTest() {
        Member member1 = new Member("홍길동",20);
        Assertions.assertThat(member1).isInstanceOf(Member.class);
    }

    @Test
    void isNullTest(){
        Member member = null;
        Assertions.assertThat(member).isNull();
    }

    @Test
    void isNotNullTest(){
        Member member = new Member("홍길동", 20);
        Assertions.assertThat(member).isNotNull();
    }

    @Test
    void throwsTest() {

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Wolrd");

        org.junit.jupiter.api.Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> list.get(2) );
    }

}
