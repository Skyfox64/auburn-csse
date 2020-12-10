import java.util.Random;
import java.util.Scanner;

/**
*@author Tyler Rabren
*@version 9/18/11 
**/
public class OnlineUserID {

/**
*@ param args User-defined command line arguments (not used).
**/
	
	Random generator = new Random();
	Scanner userInput = new Scanner(System.in);
	
	private String firstName;
	private String lastName;
	private int pass1;
	private int pass2;
	private int pass3;
	private int passWord;
	
	public int getPassword () {
	passWord = pass1 + pass2 + pass3;
	return passWord;
	}
	
	public boolean setPassword(String passWord) {
	boolean isSet = true;
	if ( < 6)
	{
	boolean isSet = false;
	}
	}
	
	
}


