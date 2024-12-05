# RabbitMQ Java-Python Example

## Overview

This project demonstrates how to use RabbitMQ to establish communication between two different programming environments: a **Java producer** and a **Python consumer**.

- **Producer**: A Java application sends JSON messages to a RabbitMQ queue.
- **Consumer**: A Python application listens to the RabbitMQ queue and processes the JSON messages.

This setup is ideal for scenarios where different systems or programming environments need to communicate reliably through a message broker.

---

## Features

- **Java Producer**:
  - Connects to RabbitMQ using `amqp-client`.
  - Publishes a JSON message to the `json_queue` queue.
  
- **Python Consumer**:
  - Connects to RabbitMQ using `pika`.
  - Consumes messages from the `json_queue` queue.
  - Parses the JSON message and prints it.

- **RabbitMQ Monitoring**:
  - Track messages and queues using RabbitMQ's management interface.

---

## Technologies Used

- **Java 11**: Producer implementation.
- **Python 3.9+**: Consumer implementation.
- **RabbitMQ**: Message broker to handle communication.
- **Libraries**:
  - **Java**: `amqp-client`
  - **Python**: `pika`

---

## Architecture

The communication flow is as follows:

1. The Java producer sends a JSON message to the `json_queue` queue on RabbitMQ.
2. RabbitMQ acts as a broker, storing and managing the message.
3. The Python consumer listens to the `json_queue` queue and processes the message.

---

## **Setup Instructions**

### 1. Prerequisites

- Install RabbitMQ and ensure it is running.
- Install Java 11+ and Python 3.9+.
- Download the `amqp-client` JAR for Java.

### 2. RabbitMQ Installation

- Access the RabbitMQ management UI at [http://localhost:15672](http://localhost:15672).
  - **Default credentials**:
    - Username: `guest`
    - Password: `guest`

### 3. Project Setup

Set Up Java Producer:

1. Compile the Java producer:

   ```bash

   javac -cp amqp-client-<version>.jar JsonSender.java
   ```

2. Run the Java producer:

    ```bash

    java -cp .:amqp-client-<version>.jar JsonSender
    ```


### 5. Set Up Python Consumer

1. Install the `pika` library:

   ```bash
   pip install pika
   ```

2. Run the consumer:

   ```bash
   python3 json_receiver.py
   ```

---

## **Expected Observations**

### 1. Java Producer

When you run the Java producer, it should print:

```plaintext
Message envoyé : {
    "name": "Alice",
    "age": 30,
    "city": "Paris"
}
```

### 2. Python Consumer

When you run the Python consumer, it should print:

```plaintext
Message reçu : {'name': 'Alice', 'age': 30, 'city': 'Paris'}
```

### 3. RabbitMQ Dashboard

In the RabbitMQ management UI:

- **Queues**: The `json_queue` queue will appear.
- **Messages**: You’ll see the message count increase when the Java producer publishes a message.
- **Consumers**: The `json_receiver.py` script will appear as a consumer connected to `json_queue`.
- **Message Flow**:
  - Messages will move from **Ready** to **Acknowledged** when consumed.

---

## Project Description

This project showcases an example of cross-platform communication using RabbitMQ. The Java application sends structured JSON data, while the Python application consumes and processes it. This pattern is useful for:

- Microservices communication.
- Decoupled systems where different technologies interact.
- Reliable message passing for distributed systems.

---

## Author

Developed by Hajar Kattaa.
