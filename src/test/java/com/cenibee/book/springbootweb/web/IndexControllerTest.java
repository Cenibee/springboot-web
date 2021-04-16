package com.cenibee.book.springbootweb.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("메인페이지 로딩")
    void loadMainPage() throws Exception {
        MvcResult result = mvc.perform(
                get("/")
                    .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getContentAsString().contains("스프링 부트로 시작하는 웹 서비스"))
                .isTrue();
    }

}