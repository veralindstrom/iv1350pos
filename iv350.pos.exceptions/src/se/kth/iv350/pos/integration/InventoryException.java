package se.kth.iv350.pos.integration;

/**
 * Thrown when something goes wrong while performing an operation in the Inventory class.
 */
public class InventoryException extends RuntimeException{

    /**
     * Creates a new instance representing the condition described in the specified message.
     * @param message Describing the error.
     * @param cause What kind of exception was thrown.
     */
    public InventoryException(String message, Exception cause) {
        super(message, cause);
    }
    
    
}
