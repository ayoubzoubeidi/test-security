package com.maz.testsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class MvcTest extends BaseMvcMock {

    @Test
    public void testAuthenticationWithValidUser() throws Exception {
        mockMvc.perform(get("/api").with(httpBasic("ayoub", "ayoub")))
                .andExpect(status().isOk());
    }

}
