package com.cenibee.book.springbootweb.web;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void unauthorizedProfile() throws Exception {
        mvc.perform(get("/profile"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.oneOf("default", "oauth")));
    }

}
