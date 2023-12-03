package com.ll.scode.domain.memberModule.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MemberDto {
    private long id;
    LocalDateTime createDate;
    LocalDateTime modifyDate;
    private String name;
}
