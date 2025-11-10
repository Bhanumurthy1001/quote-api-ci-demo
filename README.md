# quote-api-ci-demo
🚀 Quote API CI/CD Project

A lightweight Java 17 REST API that returns motivational quotes and includes a /health endpoint for container readiness checks.
This project demonstrates a complete DevOps pipeline — from source code to containerized deployment using GitHub Actions and GitHub Container Registry (GHCR).

🧠 Overview
Feature	Description
🧱 Language	Java 17
🧪 Build Tool	Maven
🧰 CI/CD	GitHub Actions
🐳 Containerization	Docker
☁️ Registry	GitHub Container Registry (GHCR)
🩺 Endpoints	/quote → random quote
/health → container health check
📁 Project Structure
quote-api-ci-demo/
├── src/
│   ├── main/java/
│   │   ├── App.java
│   │   └── QuoteController.java
│   └── test/java/
│       └── QuoteControllerTest.java
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── .github/workflows/ci.yml

⚙️ Build and Run Locally
1️⃣ Build the JAR
mvn clean package -DskipTests

2️⃣ Run directly (without Docker)
java -jar target/quote-api-1.0-SNAPSHOT.jar


Access endpoints:

http://localhost:8080/quote

http://localhost:8080/health

🐳 Run with Docker
1️⃣ Build Docker image
docker build -t ghcr.io/bhanumurthy1001/quote-api:latest .

2️⃣ Run container
docker run -d -p 8080:8080 ghcr.io/bhanumurthy1001/quote-api:latest

3️⃣ Test endpoints
curl http://localhost:8080/quote
curl http://localhost:8080/health


✅ Example output:

"Great things never come from comfort zones."
OK

📦 Push to GitHub Container Registry (GHCR)
Login and push:
docker login ghcr.io -u Bhanumurthy1001
docker push ghcr.io/bhanumurthy1001/quote-api:latest


View your package:
👉 https://github.com/Bhanumurthy1001?tab=packages

⚙️ GitHub Actions CI/CD Workflow

.github/workflows/ci.yml handles:

Checkout code

Set up Java

Run Maven tests

Build Docker image

Push to GHCR

Verify /health endpoint

💚 Health Monitoring

Your container automatically exposes:

/health → returns OK

Dockerfile includes:

HEALTHCHECK --interval=30s --timeout=5s \
  CMD curl -f http://localhost:8080/health || exit 1


This ensures your CI/CD pipeline and Kubernetes deployments know when the container is healthy.
🌐 Future Enhancements

Add /quotes/random with JSON response

Deploy to Kubernetes (GKE/AKS)

Add Prometheus + Grafana monitoring

Integrate GitOps workflow (ArgoCD)

👨‍💻 Author

Bhanu Murthy Allada (Nova 2.0)
💼 Senior DevOps & Cloud Engineer
📦 GHCR: bhanumurthy1001/quote-api

🔗 GitHub: github.com/Bhanumurthy1001
