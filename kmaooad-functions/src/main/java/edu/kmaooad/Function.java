package edu.kmaooad;

import com.google.gson.Gson;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/TelegramWebhook". To invoke it using "curl" command in bash:
     * curl -d "HTTP Body" {your host}/api/TelegramWebhook
     */
    @FunctionName("TelegramWebhook")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.POST},
                authLevel = AuthorizationLevel.FUNCTION)
                HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        final String body = request.getBody().orElse(null);

        if (body == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Please pass a name in the request body").build();
        } else {
            Gson g = new Gson();
            Message message = g.fromJson(body, Message.class);

            return request.createResponseBuilder(HttpStatus.OK).body(message.getMessage().getMessage_id()).build();
        }
    }
}
