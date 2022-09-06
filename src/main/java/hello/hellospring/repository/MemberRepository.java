package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 추상 메소드
    // 타입 생략시 같은 패키지에 소속된 클래스
    // protected 경우 같은 패키지 및 자식 클래스
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
