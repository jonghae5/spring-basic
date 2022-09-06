package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Optional;
// assertThat deprecated (junit 경우)
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
//        Assertions.assertEquals(member, result);
//        System.out.println("result =" + (result == member));
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        Member resultMember = repository.findByName("spring1").get();
//        Optional<Member> resultMember = repository.findByName("spring");
        System.out.println(resultMember);
        assertThat(resultMember).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member3 = new Member();
        member3.setName("spring1");
        repository.save(member3);

        Member member4 = new Member();
        member4.setName("spring2");
        repository.save(member4);
        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}
