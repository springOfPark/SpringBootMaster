package me.ktpark;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.ktpark.websvc.define.Course;
import me.ktpark.websvc.define.Person;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.oxm.Marshaller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Marshaller xmlMarshaller;

    @Test
    @Disabled
    @DisplayName("JSON 요청 및 응답")
    public void testJSON() throws Exception {

        Map<String, Object> param = new HashMap<>();

        param.put("name", "박경택");
        param.put("age", 30);
        param.put("job", "개발자");

        String toJSON = objectMapper.writeValueAsString(param);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/json")
                        .contentType(MediaType.APPLICATION_JSON) // 요청 메시지 타입
                        .accept(MediaType.APPLICATION_JSON) // 응답 받을 타입
                        .content(toJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("박경택")) // JSON 값 중 값이 맞는지 확인
        ;

    }

    @Test
    @DisplayName("XML 요청 및 응답 (Person)")
    public void testXML() throws Exception {

        Person person = new Person();

        person.setName("박경택");
        person.setAge(30);
        person.setRealNumber("9406011000000");

        // 객체 => XML
        StringWriter stringWriter = new StringWriter();
        Result result = new StreamResult(stringWriter);

        xmlMarshaller.marshal(person, result);

        String xmlString = stringWriter.toString();
        System.out.println(xmlString);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/test/xml")
                        .contentType(MediaType.APPLICATION_XML)
                        .accept(MediaType.APPLICATION_XML)
                        .content(xmlString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("person/name").string("박경택"));

    }

    @Test
    @DisplayName("XML 요청 및 응답 (Course)")
    public void testCourseXML() throws Exception {

        Course course = new Course();

        course.setTitle("스프링 부트 마스터 하기");
        course.setShortTitle("스프링 부트");
        course.setContent("스프링 부트 학습하기 : Spring Boot 원리, 활용");

        // 객체 => XML
        StringWriter stringWriter = new StringWriter();
        Result result = new StreamResult(stringWriter);

        xmlMarshaller.marshal(course, result);

        String xmlString = stringWriter.toString();
        System.out.println(xmlString);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/test/courseXml")
                                .contentType(MediaType.APPLICATION_XML)
                                .accept(MediaType.APPLICATION_XML)
                                .content(xmlString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("course/title").string("스프링 부트 마스터 하기"));

    }

}
