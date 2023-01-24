package hello.servlet2.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("저장 테스트")
    void saveTest() {
        //given
        Member member = new Member("hello", 20);

        //when
        memberRepository.save(member);
        Member findMember = memberRepository.findById(member.getId());

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    @DisplayName("여러명 조회")
    void findAllTest() {
        //given
        Member member1 = new Member("hello1", 20);
        Member member2 = new Member("hello2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> all = memberRepository.findAll();


        //then
        Assertions.assertThat(all).contains(member1, member2);
        Assertions.assertThat(all.size()).isEqualTo(2);
    }
}
