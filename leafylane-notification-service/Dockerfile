FROM golang:1.23.3 as builder
WORKDIR /notification-service
COPY . .
RUN go build -o leafylane-notification-service-bin-0

FROM alpine:latest
WORKDIR /root/

# Install libc6-compat for glibc compatibility
RUN apk add --no-cache libc6-compat

COPY --from=builder /notification-service/leafylane-notification-service-bin-0 .

COPY dockerize /usr/local/bin/dockerize

CMD ["dockerize", "-wait", "tcp://leafylane-rabbitmq:5672", "-timeout", "15m", "./leafylane-notification-service-bin-0"]