🤖 Local AI ChatBot (Spring Boot + Ollama)

A simple full-stack AI chatbot built using Spring Boot and Ollama (local AI models).
This project runs AI completely on your machine without using paid cloud APIs.

It supports:

AI chat using local LLMs

Browser commands (open Google, Instagram, etc.)

Fully offline AI capability

🚀 Features

Local AI using Ollama (no API cost)

Spring Boot backend

Simple web UI chatbot

Works offline after model download

Supports quick commands like:

open google

open instagram

open youtube

open github

🛠 Tech Stack
Backend

Java 17+

Spring Boot

REST API

AI Engine

Ollama (local LLM runtime)

Models supported:

phi3 (recommended fast)

llama3 (better quality but slower)

Frontend

HTML + CSS + JavaScript

Bootstrap UI

📦 Requirements

Before running this project, install:

Java 17 or above

Maven

Ollama

⚙️ Ollama Installation
Step 1 — Download Ollama

Download from: https://ollama.com/download

Install normally like any software.

Step 2 — Install a Model

Recommended fast model:

ollama pull phi3

Optional higher quality model:

ollama pull llama3
▶️ How to Run the Project
Step 1 — Start Ollama (IMPORTANT)

Open terminal and run:

ollama run phi3

⚠️ This terminal must stay running in the background. If you close it → AI stops working.

Step 2 — Start Spring Boot Backend

Go to project folder and run:

mvn spring-boot:run

Wait until you see:

Tomcat started on port 8080
Step 3 — Open the App

Open browser:

http://localhost:8080

Now you can chat with your local AI.

💬 Example Commands
Normal AI

explain sql

what is java

tell me about spring boot

Browser Commands

These open websites instantly:

open google

open instagram

open youtube

open facebook

open github

open amazon

⏱ Why Responses Can Be Slow

This project uses local AI, not cloud AI. So responses may take time.

Reasons for delay:

AI runs on your CPU

No cloud GPU acceleration

Large models need more processing time

First request is always slower (model warm-up)

Typical speeds:

Cloud AI → 1–2 seconds

Local AI → 5–30 seconds (depends on laptop)

⚡ How to Reduce Delay

Use smaller model like phi3

Keep Ollama running (avoid cold start)

Send shorter prompts

Use system with more RAM for faster results

⚠️ Important Notes

Ollama must run in background terminal

Spring Boot must also be running

If either stops → chatbot will not respond

Both must run together:

Ollama terminal

Spring Boot terminal

🧪 Troubleshooting
Backend not reachable

Make sure Spring Boot is running

Check http://localhost:8080

AI not responding

Ensure Ollama is running

Check http://localhost:11434

Model not found error

Install model again:

ollama pull phi3
🎯 Project Goal

This project demonstrates:

Local AI integration with Java

Full offline chatbot architecture

Spring Boot + LLM integration

Great for:

AI portfolio projects

Learning local LLMs

Building privacy-first AI apps

📌 Future Improvements

Streaming responses (ChatGPT style)

Chat history memory

Hybrid AI (local + cloud)

Docker deployment

Authentication

👨‍💻 Author

Built as a learning project to understand:

AI + Java integration

Local LLM architecture

Full-stack AI development
