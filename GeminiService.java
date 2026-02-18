package com.SpringBoot_AI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GeminiService {

	@Value("${gemini.api.key}")
	private String apiKey;

	private static final String API_BASE = "https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key=";

	private final HttpClient client = HttpClient.newHttpClient();

	// ---------------- NORMAL CHAT ----------------

	public String getResponse(String prompt) throws Exception {
		return callGemini(prompt);
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

		return callGemini(sqlPrompt);
	}

	// ---------------- COMMON GEMINI CALL ----------------

	private String callGemini(String prompt) throws Exception {

		if (apiKey == null || apiKey.isEmpty()) {
			return "Error: Gemini API key not configured.";
		}

		prompt = prompt.replace("\"", "\\\"");

		String json = """
				{
				  "contents": [
				    {
				      "parts": [
				        { "text": "%s" }
				      ]
				    }
				  ]
				}
				""".formatted(prompt);

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_BASE + apiKey))
				.header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		if (response.statusCode() != 200) {
			return "API Error: " + response.body();
		}

		return extractText(response.body());
	}

	// ---------------- TEXT EXTRACTION ----------------

	private String extractText(String body) {

		int start = body.indexOf("\"text\": \"") + 9;
		int end = body.indexOf("\"", start);

		if (start > 8 && end > start) {
			return body.substring(start, end).replace("\\n", "\n");
		}

		return "Error: Could not extract text.";
	}
}
