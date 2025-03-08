FROM golang:1.23.3 as builder
WORKDIR /notification-service
COPY . .
RUN go build -o nurserystore-notification-service-bin-0

FROM alpine:latest
WORKDIR /root/

# Install libc6-compat for glibc compatibility
RUN apk add --no-cache libc6-compat

COPY --from=builder /notification-service/nurserystore-notification-service-bin-0 .

# Run the service
CMD ["./nurserystore-notification-service-bin-0"]