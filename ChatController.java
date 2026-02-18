package com.SpringBoot_AI;
import com.SpringBoot_AI.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ChatController {

    private final GeminiService geminiService;

    public ChatController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String message) throws Exception {
        return geminiService.getResponse(message);
    }
}

