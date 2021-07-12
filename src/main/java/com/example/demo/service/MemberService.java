package com.example.demo.service;

import com.example.demo.domain.member.Member;
import com.example.demo.dto.MemberReqDTO;
import com.example.demo.dto.MemberResultDTO;
import com.example.demo.dto.MemberUpdateDTO;

import java.util.List;

public interface MemberService {
    List<MemberResultDTO> getAllMembers();
    MemberResultDTO getMember(Long id);
    Member insertMember(MemberReqDTO memberReqDTO);
    Member updateMember(Long id, MemberUpdateDTO memberUpdateDTO);
    int deleteMember(Long id);
}
