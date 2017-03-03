package customExceptions;

/**
 * Exception thrown when the stack is full
 */
public class StackFullException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8003422992006097437L;

	public StackFullException(String message){
		super(message);
	}
	
}
