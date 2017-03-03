package task5;
import customExceptions.*;

/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2017/02/08 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	//Made this private
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	//Made this private
	private int iTop  = 3;

	/**
	 * stack[0:5] with four defined values
	 */
	//Made this private
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '$', '$'};

	private int accessCounter = 0;
	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{


		if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
			this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick()
	{
		// Access Counter gets incremented
		this.accessCounter++;

		return this.acStack[this.iTop];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 * @throws StackOutOfBoundsException 
	 */
	public char getAt(final int piPosition) throws StackOutOfBoundsException
	{
		// Access Counter gets incremented
		this.accessCounter++;
		if(piPosition < iSize)
		{
		return this.acStack[piPosition];
		}
		else
		{
			throw new StackOutOfBoundsException("Out of Bounds error.");
		}
	}

	/**
	 * Standard push operation
	 * @throws StackFullException
	 */
	public void push(final char pcBlock) throws StackFullException
	{
		// Access Counter gets incremented
		this.accessCounter++;
		
		//Implemented handling the case when the stack is empty by adding an 'a' on top
		if(!this.isEmpty())
			this.acStack[++this.iTop] = pcBlock;
		else { 
			if(this.isFull()){
				throw new StackFullException("Stack is full, cannot push");
			} else 
				this.acStack[++this.iTop] = 'a';
		}

	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 * @throws StackEmptyException 
	 */
	public char pop() throws StackEmptyException
	{
		// Access Counter gets incremented
		this.accessCounter++;
		
		if(!this.isEmpty()){
			char cBlock = this.acStack[this.iTop];
			this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
			
			return cBlock;
		} else 
			throw new StackEmptyException("Stack is empty, cannot pop");
		
	}
	
	/**
	 * Getter method to return iTop
	 * @return iTop
	 * @throws StackOutOfBoundsException 
	 */
	public int getTop(){
		return this.iTop;
	}
	/**
	 * Getter method for the access counter
	 * @return accessCounter
	 */
	public int getAccessCounter() {
		return this.accessCounter;
	}
	/**
	 * Returns true if the stack is empty, false otherwise
	 * @return
	 */
	public boolean isEmpty() {
		return (this.iTop == -1);
	}
	/**
	 * Returns true if the stack is full, otherwise false
	 * @return
	 */
	public boolean isFull(){
		return (this.iSize == MAX_SIZE);
	}
	/**
	 * Returns the size of the stack
	 * @return
	 */
	public int getSize() {
		return this.iSize;
	}
}

// EOF
