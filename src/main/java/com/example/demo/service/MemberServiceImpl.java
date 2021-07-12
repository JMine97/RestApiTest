package com.example.demo.service;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MemberRepostiory;
import com.example.demo.dto.MemberReqDTO;
import com.example.demo.dto.MemberResultDTO;
import com.example.demo.dto.MemberUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepostiory memberRepostiory;

    @Override
    public List<MemberResultDTO> getAllMembers() {
        List<Member> members = memberRepostiory.findAll();

        return members.stream().map(member -> new MemberResultDTO(member)).collect(Collectors.toList());
    }

    @Override
    public MemberResultDTO getMember(Long id) {
        return new MemberResultDTO(memberRepostiory.getById(id));
    }

    @Override
    @Transactional
    public Member insertMember(MemberReqDTO memberReqDTO) {
        return memberRepostiory.save(memberReqDTO.toEntity());
    }

    @Override
    @Transactional
    public Member updateMember(Long id, MemberUpdateDTO memberUpdateDTO) {
        Member member = memberRepostiory.findById(id).orElseThrow(() ->
                new IllegalArgumentException("찾을 수 없는 id 입니다"));

        member.changeName(memberUpdateDTO.getName());
        member.changeDept(memberUpdateDTO.getDept());
        member.changeAge(memberUpdateDTO.getAge());
        return member;
    }

    @Override
    @Transactional
    public int deleteMember(Long id) {
        Optional<Member> member = memberRepostiory.findById(id);
        if (member.isEmpty()){
            return 0;
        }
        memberRepostiory.deleteById(id);
        return 1;
    }
}
