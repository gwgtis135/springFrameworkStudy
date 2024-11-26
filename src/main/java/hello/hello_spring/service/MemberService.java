package hello.hello_spring.service;

import hello.hello_spring.domin.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 x
        Optional<Member> result = memberRepository.findByName(member.getName());

        result.ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }); //값이 있으면

        memberRepository.save(member);
        return member.getId();

    }
}
