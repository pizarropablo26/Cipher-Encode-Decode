import java.io.*;
import java.util.Scanner;

/**
 * This class represents a cipher that can encode and 
 * decode information with the algorithm provided
 * @author jy
 *
 */
public class WesternCipher {
	
	private CircularArrayQueue<Character> encodingQueue;
	private CircularArrayQueue<Character> decodingQueue;

	public WesternCipher() {
		encodingQueue = new CircularArrayQueue<Character>(10);
		decodingQueue = new CircularArrayQueue<Character>(10);



	}
	
	public WesternCipher(int number) {
		encodingQueue = new CircularArrayQueue<Character>(number);
		decodingQueue = new CircularArrayQueue<Character>(number);

	}
	
	/**
	 * This method takes a string as input, splits the string into individual characters,
	 * applies the Western Cipher algorithm described above, rejoins the individual characters
	 * into a string and returns it. While possible to implement without a queue, this method
	 * must enqueue every character into the queue and then encode while dequeueing.
	 * @param input string imput
	 * @return encoded string
	 */
	public String encode(String input) {
//		Takes a string as input,
		char[] cArray = input.toCharArray();
	    for (int i = 0; i < cArray.length; i++) {
	    	encodingQueue.enqueue(cArray[i]);
	    }
//		splits the string into individual characters,
		
//		applies the Western Cipher algorithm described above, 
		String message = "";
    	int previouscodedcharacter = 0;
	    for (int i = 0; i < cArray.length; i++) {
	    	char codedCharacter = encodingQueue.dequeue();
	    	if(codedCharacter == 'A') {
	    		if (previouscodedcharacter == 0 ) {
		    		codedCharacter = '1';
		    		previouscodedcharacter = 1;
		    		message = message + codedCharacter; // message is oldmessage + 1
	    		}
	    		else {
	    			codedCharacter = '3';
		    		previouscodedcharacter = 3;
		    		message = message + codedCharacter;
	    		}
	    	}
	    	else if(codedCharacter == 'E') {
	    		if (previouscodedcharacter == 0) {
		    		codedCharacter = '2';
		    		previouscodedcharacter = 2;
		    		message = message + codedCharacter;
	    		}
	    		else {
	    			codedCharacter = '4';
		    		previouscodedcharacter = 4;
		    		message = message + codedCharacter;
	    		}
	    	}
	    	else if(codedCharacter == 'I') {
	    		if (previouscodedcharacter == 0 ) {
		    		codedCharacter = '3';
		    		previouscodedcharacter = 3;
		    		message = message + codedCharacter;
	    		}
	    		else {
	    			codedCharacter = '5';
		    		previouscodedcharacter = 5;
		    		message = message + codedCharacter;
	    		}
	    	}
	    	else if(codedCharacter == 'O') {
	    		if (previouscodedcharacter == 0 ) {
		    		codedCharacter = '4';
		    		previouscodedcharacter = 4;
		    		message = message + codedCharacter;
	    		}
	    		else {
	    			codedCharacter = '6';
		    		previouscodedcharacter = 6;
		    		message = message + codedCharacter;
	    		}
	    	}
	    	else if(codedCharacter == 'U') {
	    		if (previouscodedcharacter == 0 ) {
		    		codedCharacter = '5';
		    		previouscodedcharacter = 5;
		    		message = message + codedCharacter;
	    		}
	    		else {
	    			codedCharacter = '1';
		    		previouscodedcharacter = 1;
		    		message = message + codedCharacter;
	    		}
	    	}
	    	else if(codedCharacter == 'Y') {
	    		if (previouscodedcharacter == 0 ) {
		    		codedCharacter = '6';
		    		previouscodedcharacter = 6;
		    		message = message + codedCharacter;
	    		}
	    		else {
	    			codedCharacter = '2';
		    		previouscodedcharacter = 2;
		    		message = message + codedCharacter;
	    		}
	    	}
	    	else {
	    		if (codedCharacter != ' ') {
		    		codedCharacter = (char) (codedCharacter + 5);
		    		codedCharacter = (char) (((codedCharacter + 2 * i)-65)%26 +65);
		    		if (previouscodedcharacter != 0) {
		    			if(codedCharacter - 2*previouscodedcharacter > 'A') {
		    				codedCharacter = (char) (codedCharacter - 2*previouscodedcharacter);
		    			}
		    			else {
		    				codedCharacter = (char) (codedCharacter - 2*previouscodedcharacter +26);
		    			}
		    			previouscodedcharacter = 0; 
		    		}
	    		}
	    		message = message + codedCharacter;
	    	}
	    	
	    }

		return message;
	}
	
	/**
	 * Takes a string as input, 
	 * splits the string into individual characters and undoes the Western Cipher algorithm 
	 * described above; then, rejoins the individual decoded characters
	 * into a string. 
	 * @param input the message that will be decoded
	 * @return a String representing the decoded message 
	 */
	public String decode(String input) {

		char[] cArray = input.toCharArray();
	    for (int i = 0; i < cArray.length; i++) {
	    	decodingQueue.enqueue(cArray[i]);
	    }

		String message = "";

		int previousdecodedcharacter = 0; 

		for (int i = 0; i < cArray.length; i++) {
			char decodedCharacter = decodingQueue.dequeue();
	    	if(decodedCharacter == '1') {
	    		if (previousdecodedcharacter == 0) {
		    		decodedCharacter = 'A';
		    		previousdecodedcharacter = 1;
		    		message = message + decodedCharacter ; // message is oldmessage + 1
	    		}
	    		else {
	    			decodedCharacter = 'U';
		    		previousdecodedcharacter = 1;
		    		message = message + decodedCharacter ;
	    		}
	    	}
	    	else if(decodedCharacter == '2') {
	    		if (previousdecodedcharacter == 0) {
		    		decodedCharacter = 'E';
		    		previousdecodedcharacter = 2;
		    		message = message + decodedCharacter;
	    		}
	    		else {
	    			decodedCharacter = 'Y';
		    		previousdecodedcharacter = 2;
		    		message = message + decodedCharacter;
	    		}
	    	}
	    	else if(decodedCharacter == '3') {
	    		if (previousdecodedcharacter == 0 ) {
		    		decodedCharacter = 'I';
		    		previousdecodedcharacter = 3;
		    		message = message + decodedCharacter;
	    		}
	    		else {
	    			decodedCharacter = 'A';
		    		previousdecodedcharacter = 3;
		    		message = message + decodedCharacter;
	    		}
	    	}
	    	else if(decodedCharacter == '4') {
	    		if (previousdecodedcharacter == 0 ) {
		    		decodedCharacter = 'O';
		    		previousdecodedcharacter = 4;
		    		message = message + decodedCharacter;
	    		}
	    		else {
	    			decodedCharacter = 'E';
		    		previousdecodedcharacter = 4;
		    		message = message + decodedCharacter;
	    		}
	    	}
	    	else if(decodedCharacter == '5') {
	    		if (previousdecodedcharacter == 0 ) {
		    		decodedCharacter = 'U';
		    		previousdecodedcharacter = 5;
		    		message = message + decodedCharacter;
	    		}
	    		else {
	    			decodedCharacter = 'I';
		    		previousdecodedcharacter = 5;
		    		message = message + decodedCharacter;
	    		}
	    	}
	    	else if(decodedCharacter == '6') {
	    		if (previousdecodedcharacter == 0 ) {
		    		decodedCharacter = 'Y';
		    		previousdecodedcharacter = 6;
		    		message = message + decodedCharacter;
	    		}
	    		else {
	    			decodedCharacter = 'O';
		    		previousdecodedcharacter = 6;
		    		message = message + decodedCharacter;
	    		}
	    	}
	    	else {
	    		if (decodedCharacter != ' ') {
	    			if (previousdecodedcharacter != 0) {
		    			decodedCharacter = (char) (decodedCharacter + 2*previousdecodedcharacter);
		    		}

		    		decodedCharacter = (char) (decodedCharacter - 5);
		    		if (((decodedCharacter - 2 * i)-65) < 0) {
		    			decodedCharacter = (char) (((decodedCharacter - 2 * i)-65)%26 + 91);
		    		}
		    		else {
		    			decodedCharacter = (char) (decodedCharacter - 2 * i);
		    		}
		    		
	    		}
	    		message = message + decodedCharacter;
    			previousdecodedcharacter = 0;
	    	}
		}
    
		return message;
	}
	
	/**
	 * This is the main method of the program that asks the user if they want to decode 
	 * or encode a message and call the specified function.
	 * Quit if user prompt to quit
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WesternCipher NewCipher = new WesternCipher();
		Scanner in = new Scanner(System.in);
		String input, code;
		do{
			System.out.println("Encode a message or Decode a message (Please type 'Encode' or 'Decode' below): ");
			input = in.nextLine();
			if (input.equals("Encode")) {
				System.out.println("Enter a message ");
				input = in.nextLine();
				code = NewCipher.encode(input);
				System.out.println(code);
			}
			else if (input.equals("Decode")){
				System.out.println("Enter a message ");
				input = in.nextLine();
				code = NewCipher.decode(input); 
				System.out.println(code);
			}
			else {
				System.out.println("Please Enter A valid Option");
			}
			System.out.println("Continue? Yes or No");
			input = in.nextLine();
		} 
		while (input.equals("Yes"));{
		}
		
		
		

	}

}
