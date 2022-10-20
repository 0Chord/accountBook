package miniProject.accountBook.repository;


import miniProject.accountBook.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Member update(Member member);

    Optional<Member> findById(String id);

    List<Member> findAll();

    Optional<Member> findByNickname(String nickname);

    Optional<Member> findByName(String name);
}
