package com.dami.firstservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/first-service")
public class FirstServiceController {
    
    private final Environment env;
    
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the First service.";
    }
    
    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("Server port={}", request.getServerPort());
        // random port 사용할 때는 프로퍼티명 local.server.port로 포트번호 확인 가능
        return String.format("This is CustomFilter of First service on PORT %s", env.getProperty("local.server.port"));
    }
}
