package main

import (
	"log"
	"net/http"
	"os"
	"github.com/gin-gonic/gin"
	"github.com/streadway/amqp"
)

func main() {
	// Initialize Gin Router
	r := gin.Default()

	// Health Check Route
	r.GET("/health", func(c *gin.Context) {
		c.String(http.StatusOK, "Notification Service is Running!")
	})

	// Start Consuming Messages
	go consumeRabbitMQ()

	// Start Gin Server
	log.Fatal(r.Run(":8083"))
}

func consumeRabbitMQ() {
	// Connect to RabbitMQ
	conn, err := amqp.Dial(os.Getenv("RABBITMQ_URL"))
	if err != nil {
		log.Fatalf("Failed to connect to RabbitMQ: %v", err)
	}
	defer conn.Close()

	// Open a channel
	ch, err := conn.Channel()
	if err != nil {
		log.Fatalf("Failed to open a channel: %v", err)
	}
	defer ch.Close()

	// Declare Queue
	q, err := ch.QueueDeclare("notification_queue", false, false, false, false, nil)
	if err != nil {
		log.Fatalf("Failed to declare a queue: %v", err)
	}

	// Consume Messages
	msgs, err := ch.Consume(q.Name, "", true, false, false, false, nil)
	if err != nil {
		log.Fatalf("Failed to consume messages: %v", err)
	}

	// Process Messages
	for msg := range msgs {
		log.Printf("Received Message: %s", msg.Body)
		sendEmailNotification(string(msg.Body)) // Call Email Sender
//         err := sendSMS("+9779806604253", "Hello from Notification Service!")
//         if err != nil {
//             log.Fatalf("Error sending SMS: %v", err)
//         } else {
//             log.Println("SMS sent successfully!")
//         }
	}
}
