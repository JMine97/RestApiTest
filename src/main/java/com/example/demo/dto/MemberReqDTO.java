package com.example.demo.dto;

import com.example.demo.domain.member.Member;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class MemberReqDTO {
    private String name;
    private Integer age;
    private String dept;

    public Member toEntity(){
        return Member.builder()
                .age(age)
                .dept(dept)
                .name(name)
                .build();
    }
}
