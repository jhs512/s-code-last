package com.ll.scode.domain.memberModule.member.controller;

import com.ll.scode.domain.memberModule.member.dto.MemberDto;
import com.ll.scode.global.rsData.RsData.RsData;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/members")
public class ApiV1MembersController {
    @Getter
    public static class MeResponse {
        public MemberDto item;

        public MeResponse(MemberDto item) {
            this.item = item;
        }
    }

    @GetMapping("/me")
    public RsData<MeResponse> me() {
        return RsData.of(
                "200",
                new MeResponse(
                        new MemberDto(1L, LocalDateTime.now(), LocalDateTime.now(), "user1")
                )
        );
    }
}
