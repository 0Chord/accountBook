package miniProject.accountBook.service;

import miniProject.accountBook.domain.Member;
import miniProject.accountBook.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean join(Member member) {
        if (!memberRepository.findById(member.getId()).equals(Optional.empty())) {
            return false;
        }
        if (!memberRepository.findByNickname(member.getNickname()).equals(Optional.empty())) {
            return false;
        }
        memberRepository.save(member);
        return true;
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOneByNickname(String nickname) {
        return memberRepository.findByNickname(nickname).orElse(null);
    }

    public Member findOne(String memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    public Member login(String loginId, String password) {
        return memberRepository.findById(loginId).filter(m -> m.getPassword().equals(password)).orElse(null);
    }

    public boolean put(Member member){
        memberRepository.update(member);
        return true;
    }

    public Member findOneByName(String name){
        return memberRepository.findByName(name).orElse(null);
    }

    public void updatePassword(String id, String password){
        Member member = memberRepository.findById(id).get();
        member.updatePassword(password);
    }
}
