package se.kth.iv350.pos.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Handles a error message.
 */
public class ErrorMessageHandler {
    /**
     * Displays the specified error message.
     * 
     * @param message The error message.
     */
    void showErrorMsg(String message) {
        StringBuilder errorMessageBuilder = new StringBuilder();
        errorMessageBuilder.append(currentTime());
        errorMessageBuilder.append("\nERROR: ");
        errorMessageBuilder.append(message);
        System.out.println(errorMessageBuilder);
    }
    
    private String currentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
