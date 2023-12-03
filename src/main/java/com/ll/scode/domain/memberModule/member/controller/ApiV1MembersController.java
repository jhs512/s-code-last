package com.ll.scode.domain.memberModule.member.controller;

import com.ll.scode.domain.memberModule.member.dto.MemberDto;
import com.ll.scode.global.rsData.RsData.RsData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;

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

    @Setter
    @Getter
    @ToString
    public static class JoinRequest {
        private String username;
        private String password;
        private String email;
        private String nickname;
    }

    @Getter
    public static class JoinResponse {
        public MemberDto item;

        public JoinResponse(MemberDto item) {
            this.item = item;
        }
    }

    @PostMapping("")
    public RsData<MeResponse> join(
            @RequestBody JoinRequest joinRequest
    ) {
        return RsData.of(
                "201",
                new MeResponse(
                        new MemberDto(1L, LocalDateTime.now(), LocalDateTime.now(), joinRequest.nickname)
                )
        );
    }
}
