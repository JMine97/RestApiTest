package com.example.demo.controller;

import com.example.demo.domain.member.Member;
import com.example.demo.dto.MemberReqDTO;
import com.example.demo.dto.MemberResultDTO;
import com.example.demo.dto.MemberUpdateDTO;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MembersController {
    private final MemberService memberService;

    @GetMapping("/members")
    public List<MemberResultDTO> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/members/{id}")
    public MemberResultDTO getMember(@PathVariable Long id){
        return memberService.getMember(id);
    }

    @PostMapping("/members")
    public Member insertMember(@RequestBody MemberReqDTO memberReqDTO){
        Member member = memberService.insertMember(memberReqDTO);
        return member;
    }

    @PutMapping("/members/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody MemberUpdateDTO memberUpdateDTO) {
        return memberService.updateMember(id, memberUpdateDTO);
    }

    @DeleteMapping("/members/{id}")
    public int deleteMember(@PathVariable Long id) {
        return memberService.deleteMember(id);
    }
}
