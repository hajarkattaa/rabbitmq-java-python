import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class JsonSender {
    private final static String QUEUE_NAME = "json_queue";

    public static void main(String[] argv) {
        // Configuration de la connexion à RabbitMQ
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); // ou IP du serveur RabbitMQ
        factory.setUsername("guest"); // par défaut
        factory.setPassword("guest"); // par défaut

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            // Déclaration de la file d'attente
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            // Message JSON à envoyer
            String jsonMessage = "{\n" +
                    "    \"name\": \"Alice\",\n" +
                    "    \"age\": 30,\n" +
                    "    \"city\": \"test\"\n" +
                    "}";

            // Publication du message
            channel.basicPublish("", QUEUE_NAME, null, jsonMessage.getBytes());
            System.out.println("Message envoyé : " + jsonMessage);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
