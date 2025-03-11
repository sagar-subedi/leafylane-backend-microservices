package main

import (
	"fmt"
	"log"
	"os"

	"github.com/twilio/twilio-go"
	openapi "github.com/twilio/twilio-go/rest/api/v2010"
)

// SendSMS sends a text message using Twilio
func sendSMS(to, message string) error {
	accountSID := os.Getenv("TWILIO_ACCOUNT_SID")
	authToken := os.Getenv("TWILIO_AUTH_TOKEN")
	from := os.Getenv("TWILIO_PHONE_NUMBER")

	if accountSID == "" || authToken == "" || from == "" {
		log.Fatal("Twilio credentials are missing")
	}

	client := twilio.NewRestClientWithParams(twilio.ClientParams{
		Username: accountSID,
		Password: authToken,
	})

	params := &openapi.CreateMessageParams{}
	params.SetTo(to)
	params.SetFrom(from)
	params.SetBody(message)

	resp, err := client.Api.CreateMessage(params) // ✅ FIXED: Use client.Api.CreateMessage
	if err != nil {
		log.Printf("Failed to send SMS: %v", err)
		return err
	}

	fmt.Printf("SMS sent! SID: %s\n", *resp.Sid)
	return nil
}

