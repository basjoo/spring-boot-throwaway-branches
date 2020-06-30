package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for {@link ScriptTestController}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
@AutoConfigureMockMvc
class ScriptTestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testScript() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/test/script"))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        assertThat(content)
                .contains("var message = \"\\/js\\/test.js\" + \"&param2=\" + param2;");
    }

}
