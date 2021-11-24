package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("hello", 20);


        Member savedMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(savedMember.getId());


        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        Member member = new Member("member1", 20);
        Member member1 = new Member("member2", 30);
        memberRepository.save(member);
        memberRepository.save(member1);


        List<Member> all = memberRepository.findAll();


        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(member, member1);
    }
}
