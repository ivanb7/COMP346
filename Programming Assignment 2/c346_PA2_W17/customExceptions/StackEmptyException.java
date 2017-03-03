package customExceptions;

/**
 * Exception thrown when the stack is empty
 */
public class StackEmptyException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5234351668841749603L;

	public StackEmptyException(String message){
		super(message);
	}
	
}
