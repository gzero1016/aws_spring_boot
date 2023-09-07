package com.aws.spring_study.controller;

import com.aws.spring_study.dto.JsonTestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController //데이터응답
public class RespStudyController {

    @GetMapping("/resp/str")
    public String strTest() {
        return "문자열";
    }

    @GetMapping("/resp/obj")
    public Object objectTest() {
        Map<String, Object> responseMap = new HashMap<>();
        return responseMap; // RestController이기 때문에 json으로 응답이날아감
    }

    @GetMapping("/resp/obj2")
    public Object objectTest2() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("김준일");
        jsonTestDto.setAge(30);
        return jsonTestDto; // 자동으로 json으로 응답이날아감
    }

    @GetMapping("/resp/status") //이렇게 상태코드를 주지않음 나쁜예시!
    public Object statusTest(HttpServletResponse response) {
        response.setStatus(400);
        return null;
    }

    // 400번대 상태코드는 클라이언트에서 오류 잡아야하고
    // 500번대 상태코드는 서버에서 오류를 잡아야함
    @GetMapping("/resp/resp-entity")
    public ResponseEntity<?> responseEntityText () {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("김준일");
        jsonTestDto.setAge(30);
        return new ResponseEntity<JsonTestDto>(jsonTestDto, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/resp/map-resp-entity")
    public ResponseEntity<Map<String, Object>> mapResponseEntity() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", "데이터입니다.");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/resp")
    public ResponseEntity<JsonTestDto> jsonTestDtoResponse() {   // 이렇게 상태코드를 쓰는게 가장 좋은예시!
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("김준일");
        jsonTestDto.setAge(30);
        // 아래와 같이 status 코드를 작성할 수 있는 방법은 여러가지이다.
//        return ResponseEntity.ok().body(jsonTestDto);
//        return ResponseEntity.badRequest().body(jsonTestDto);
//        return ResponseEntity.status(405).body(jsonTestDto);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonTestDto);
    }
}
