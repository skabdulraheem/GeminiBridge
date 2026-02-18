package com.SpringBoot_AI;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class OllamaService {

	private static final String OLLAMA_URL = "http://localhost:11434/api/generate";
	private static final String MODEL = "phi3";  // change if needed

    private final HttpClient client = HttpClient.newHttpClient();

    // ---------------- NORMAL CHAT ----------------

    public String getResponse(String prompt) throws Exception {
        return callOllama(prompt);
    }

    // ---------------- SQL MODE ----------------

    public String generateSQL(String userRequest) throws Exception {

        String sqlPrompt = """
                You are an expert MySQL query generator.
                Convert the following request into a valid MySQL SELECT query.
                Rules:
                - Return ONLY the SQL query.
                - No explanation.
                - No markdown.
                - Only SELECT statements allowed.

                Request: %s
                """.formatted(userRequest);

        return callOllama(sqlPrompt);
    }

    // ---------------- COMMON OLLAMA CALL ----------------

    private String callOllama(String prompt) throws Exception {

        prompt = prompt.replace("\"", "\\\"");

        String json = """
                {
                  "model": "%s",
                  "prompt": "%s",
                  "stream": false
                }
                """.formatted(MODEL, prompt);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(OLLAMA_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            return "Ollama Error: " + response.body();
        }

        return extractText(response.body());
    }

    // ---------------- TEXT EXTRACTION ----------------

    private String extractText(String body) {

        // Ollama response contains: "response":"text here"
        int start = body.indexOf("\"response\":\"") + 12;
        int end = body.indexOf("\"", start);

        if (start > 11 && end > start) {
            return body.substring(start, end).replace("\\n", "\n");
        }

        return "Error: Could not extract text.";
    }
}
