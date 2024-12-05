import pika
import json

connection = pika.BlockingConnection(pika.ConnectionParameters("localhost"))
channel = connection.channel()

queue_name = "json_queue"
channel.queue_declare(queue=queue_name)

def callback(ch, method, properties, body):
    message = json.loads(body)
    print(f"Message reçu : {message}")

channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)

print("En attente de messages... Appuyez sur Ctrl+C pour quitter.")
channel.start_consuming()
