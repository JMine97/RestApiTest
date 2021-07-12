package com.example.demo.dto;

import com.example.demo.domain.member.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberResultDTO {
    private Long id;
    private String name;
    private Integer age;
    private String dept;

    public MemberResultDTO(Member member){
        this.id=member.getId();
        this.name=member.getName();
        this.age=member.getAge();
        this.dept=member.getDept();
    }
}
