package com.SpringBoot_AI;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ai")
public class OllamaController {

    private final OllamaService service;

    public OllamaController(OllamaService service) {
        this.service = service;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) throws Exception {
        return service.getResponse(prompt);
    }

    @GetMapping("/sql")
    public String sql(@RequestParam String prompt) throws Exception {
        return service.generateSQL(prompt);
    }
}
