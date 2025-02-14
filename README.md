# Distributed Nursery Store Application

## Overview

The **Distributed Nursery Store Application** is a modern, scalable, and cloud-native e-commerce platform designed for a nursery store. It leverages a **microservice architecture** to provide a robust, maintainable, and scalable solution. The application is built using **Spring Boot** for backend services, **Next.js** for the frontend, and integrates various modern technologies such as **Feign**, **Redux**, **MySQL**, **OAuth2**, **Stripe**, **Spring Cloud Gateway**, **Eureka**, **Spring Security with JWT**, and more. The application also has plans to incorporate **Zipkin** for distributed tracing, **Prometheus/Grafana** for monitoring, and deployment on **Kubernetes**.

---

## Key Features

1. **Microservice Architecture**: The application is divided into multiple independent services, each responsible for a specific domain:
    - **Account Service**: Manages user accounts, authentication, and authorization.
    - **Address Service**: Handles user addresses and location-related data.
    - **Catalogue Service**: Manages product listings, categories, and inventory.
    - **Order Service**: Handles order creation, tracking, and management.
    - **Payment Service**: Integrates with **Stripe** for payment processing.
    - **Service Registry**: Uses **Eureka** for service discovery and registration.

2. **Frontend**: Built with **Next.js** and **Redux** for state management, providing a responsive and dynamic user interface.

3. **Backend**: Built with **Spring Boot**, using **Feign** for inter-service communication and **Spring Cloud Gateway** for API routing.

4. **Security**: Implements **OAuth2** resource server with **JWT-based authentication** using **Spring Security**.

5. **Database**: Uses **MySQL** for persistent data storage across services.

6. **Payment Integration**: Integrates with **Stripe** for secure and seamless payment processing.

7. **Monitoring and Tracing**:
    - **Zipkin**: Planned for distributed tracing to monitor requests across microservices.
    - **Prometheus/Grafana**: Planned for monitoring and visualizing application metrics.

8. **Deployment**: Designed to be deployed on **Kubernetes** for scalability and resilience.

---

## Technologies Used

### Backend
- **Spring Boot**: Framework for building microservices.
- **Spring Cloud Gateway**: API gateway for routing and filtering requests.
- **Eureka**: Service registry and discovery.
- **Feign**: Declarative REST client for inter-service communication.
- **Spring Security**: Implements OAuth2 and JWT-based authentication.
- **Stripe API**: Payment processing integration.
- **MySQL**: Relational database for persistent storage.
- **Zipkin** (Planned): Distributed tracing.
- **Prometheus/Grafana** (Planned): Monitoring and visualization.

### Frontend
- **Next.js**: React framework for server-side rendering and static site generation.
- **Redux**: State management library for React.

### Deployment
- **Kubernetes**: Container orchestration for deploying and scaling microservices.
- **Docker**: Containerization of services.

---

## Getting Started

### Prerequisites
- Java 17 or higher
- Node.js 16 or higher
- MySQL 8.x
- Docker
- Kubernetes cluster (optional for local development)
- Stripe API key

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/nursery-store-app.git
   cd nursery-store-app
   ```

2. **Set Up MySQL**:
    - Create a MySQL database and update the `application.yml` files in each microservice with the correct database credentials.

3. **Set Up Eureka Server**:
    - Navigate to the `eureka-server` directory and run:
      ```bash
      ./mvnw spring-boot:run
      ```

4. **Run Microservices**:
    - Start each microservice (`account-service`, `address-service`, `catalogue-service`, `order-service`, `payment-service`) by navigating to their respective directories and running:
      ```bash
      ./mvnw spring-boot:run
      ```

5. **Run Spring Cloud Gateway**:
    - Navigate to the `gateway` directory and run:
      ```bash
      ./mvnw spring-boot:run
      ```

6. **Set Up Frontend**:
    - Navigate to the `frontend` directory and install dependencies:
      ```bash
      npm install
      ```
    - Start the Next.js application:
      ```bash
      npm run dev
      ```

7. **Access the Application**:
    - Open your browser and navigate to `http://localhost:3000`.

---

## Configuration

### Environment Variables
- **Stripe API Key**: Set the `STRIPE_API_KEY` environment variable in the `payment-service`.
- **JWT Secret**: Set the `JWT_SECRET` environment variable in the `account-service`.
- **MySQL Credentials**: Update the `application.yml` files in each microservice with the correct database credentials.

### Kubernetes Deployment (Optional)
- Use the provided Kubernetes manifests (`k8s/`) to deploy the application on a Kubernetes cluster.
- Ensure you have a running Kubernetes cluster and `kubectl` configured.

---

## API Documentation

API documentation is available via **Swagger UI**:
- Access Swagger UI for each microservice at `http://localhost:<port>/swagger-ui.html`.

---

## Monitoring and Tracing (Planned)

1. **Zipkin**:
    - Deploy Zipkin for distributed tracing to monitor requests across microservices.

2. **Prometheus/Grafana**:
    - Set up Prometheus for metrics collection and Grafana for visualization.

---

## Contributing

Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

For any questions or feedback, please reach out to:
- **Sagar Subedi** - sagarsubedi01@gmail.com
- **Project Repository** - [GitHub Repo](https://github.com/sagar-subedi/distributed-nursery-store)

---

Thank you for using the Distributed Nursery Store Application! 🌱