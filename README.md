# GeminiBridge

🚀 Spring Boot + Gemini AI Service

A lightweight Spring Boot service that integrates Google Gemini AI using pure Java (no external AI SDKs).
Supports:

Normal conversational AI responses

AI-generated MySQL SELECT queries

This project is ideal for learning AI integration in Java backend without heavy frameworks.

🧠 Features
1. Normal AI Chat

Send any prompt → Get AI-generated response.

Example

Input: Explain REST API
Output: Gemini explanation

2. SQL Generator Mode

Converts natural language → MySQL SELECT query.

Example

Input: Get all users registered today
Output: SELECT * FROM users WHERE DATE(created_at) = CURDATE();


⚠️ Restricted to SELECT queries for safety.

🛠️ Technologies Used
Layer	Technology
Backend	Java 17+
Framework	Spring Boot
AI Provider	Google Gemini API
HTTP Client	Java HttpClient (no third-party libs)
Build Tool	Maven / Gradle
Config	application.properties
📁 Project Structure
com.SpringBoot_AI
 └── GeminiService.java

Core Responsibilities
Class	Purpose
GeminiService	Handles AI communication
callGemini()	Makes API request
generateSQL()	SQL-only prompt engineering
extractText()	Parses Gemini response
⚙️ Prerequisites

Java 17+

Maven or Gradle

Google Gemini API Key

🔑 Getting Gemini API Key

Go to: https://makersuite.google.com/app/apikey

Generate API key

Copy it

⚙️ Configuration

Add this in:

application.properties
gemini.api.key=YOUR_API_KEY_HERE

▶️ How to Run
1️⃣ Clone Repo
git clone https://github.com/your-username/springboot-gemini-ai.git
cd springboot-gemini-ai

2️⃣ Build Project
Maven
mvn clean install

Gradle
gradle build

3️⃣ Run Application
mvn spring-boot:run


OR

java -jar target/app.jar

🔌 How It Works Internally
Step-by-step flow

User sends prompt

Service builds Gemini JSON payload

HTTP POST → Google Gemini API

AI response received

Text extracted manually

Returned to controller
