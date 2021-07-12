package com.example.demo.dto;

import com.example.demo.domain.member.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberUpdateDTO {
    private Long id;
    private String name;
    private Integer age;
    private String dept;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .age(age)
                .dept(dept)
                .build();
    }
}

