package com.ll.scode.domain.memberModule.member.controller;

import com.ll.scode.standard.util.Ut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class ApiV1MembersControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("GET /api/v1/members/me")
    void t1() throws Exception {
        // WHEN
        ResultActions resultActions = mvc
                .perform(get("/api/v1/members/me"))
                .andDo(print());

        // THEN
        resultActions
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(ApiV1MembersController.class))
                .andExpect(handler().methodName("me"))
                .andExpect(jsonPath("$.data.item.id", is(1)))
                .andExpect(jsonPath("$.data.item.createDate", matchesPattern("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{7}")))
                .andExpect(jsonPath("$.data.item.modifyDate", matchesPattern("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{7}")))
                .andExpect(jsonPath("$.data.item.name", is("user1")));
    }

    @Test
    @DisplayName("POST /api/v1/members")
    void t2() throws Exception {
        Map paramsMap = Map.of(
                "username", "usernew",
                "password", "1234",
                "email", " usernew@test.com",
                "nickname", "usernewnick"
        );

        // WHEN
        ResultActions resultActions = mvc
                .perform(
                        post("/api/v1/members")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(Ut.json.stringify(paramsMap))
                )
                .andDo(print());

        // THEN
        resultActions
                .andExpect(status().isCreated())
                .andExpect(handler().handlerType(ApiV1MembersController.class))
                .andExpect(handler().methodName("join"))
                .andExpect(jsonPath("$.data.item.id", is(1)))
                .andExpect(jsonPath("$.data.item.createDate", matchesPattern("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{7}")))
                .andExpect(jsonPath("$.data.item.modifyDate", matchesPattern("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{7}")))
                .andExpect(jsonPath("$.data.item.name", is("usernewnick")));
    }
}