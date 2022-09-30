package miniProject.accountBook.repository;

import miniProject.accountBook.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(String id);

    List<Member> findAll();

    Optional<Member> findByNickname(String nickname);
}
