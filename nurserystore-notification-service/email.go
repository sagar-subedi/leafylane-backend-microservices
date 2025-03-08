package main

import (
	"fmt"
	"log"
	"net/smtp"
	"os"
)

func sendEmailNotification(body string) {
	smtpHost := "smtp.gmail.com"
	smtpPort := "587"
	senderEmail := os.Getenv("EMAIL_SENDER")
	password := os.Getenv("EMAIL_PASSWORD")
	recipient := os.Getenv("EMAIL_RECIPIENT")

	auth := smtp.PlainAuth("", senderEmail, password, smtpHost)

	message := []byte(fmt.Sprintf("Subject: Order Update\n\n%s", body))

	err := smtp.SendMail(smtpHost+":"+smtpPort, auth, senderEmail, []string{recipient}, message)
	if err != nil {
		log.Printf("Failed to send email: %v", err)
	} else {
		log.Println("Email sent successfully!")
	}
}
