package com.ll.scode.domain.memberModule.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
public class ApiV1MembersController {
    @GetMapping("/me")
    public String me() {
        return "me";
    }
}
