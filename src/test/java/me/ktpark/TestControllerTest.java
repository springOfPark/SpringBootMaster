package me.ktpark;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testJSON() throws Exception {

        Map<String, Object> param = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        param.put("name", "박경택");
        param.put("age", 30);
        param.put("job", "Devloper");

        String toJSON = objectMapper.writeValueAsString(param);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/json")
                        .contentType(MediaType.APPLICATION_JSON) // 요청 메시지 타입
                        .accept(MediaType.APPLICATION_JSON) // 응답 받을 타입
                        .content(toJSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void test() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/test/test")
                        .content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));

    }

}
