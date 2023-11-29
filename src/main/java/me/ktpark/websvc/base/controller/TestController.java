package me.ktpark.websvc.base.controller;

import me.ktpark.websvc.base.controller.extension.BaseControllerTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class TestController extends BaseControllerTemplate {

    @PostMapping("/transaction/test/userTest")
    public ResponseEntity<Map<String, Object>> userTest(@RequestBody Map<String, Object> param, HttpServletRequest req) {

        printRequestInfo(req);

        System.out.println(param);

        System.out.println(param.get("id"));
        System.out.println(param.get("name"));
        System.out.println(param.get("phone"));
        System.out.println(param.get("listMap"));

        List<Map<String, Object>> listMap = (List<Map<String, Object>>) param.get("listMap");
        Optional<Map<String, Object>> findMap = listMap.stream().filter((map) -> map.containsKey("map3")).findAny();
        System.out.println(findMap);

        ResponseEntity<Map<String, Object>> mapResponseEntity = new ResponseEntity<>(param, HttpStatus.OK);
        return mapResponseEntity;

    }

}
