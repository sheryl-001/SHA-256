//Demonstration of SHA-256 hashing function
import java.util.*;
import java.security.*;
import java.math.*;
public class SHA_256_demonstration
{
	public static void main(String args[]) throws NoSuchAlgorithmException
	{
		Scanner sc=new Scanner(System.in);
		String s;
		System.out.println("Text?\n");
		s=sc.next();
		System.out.println("Input: "+s);
		try
		{
			//MessageDigest is a class provided in java.security package
			//Algorithm begins by calling the static getInstance() method
			MessageDigest msg=MessageDigest.getInstance("SHA-256");
			//digest() method called to return the input text as an array of bytes
			byte[] digestedText = msg.digest(s.getBytes());
			//convert the returned byte array into signum representation
			//with the use of BigInteger class provided in java.math package
			BigInteger no = new BigInteger(1, digestedText);
			// Convert digestedText into hexadecimal value
           		String hashvalue = no.toString(16);
			// Add preceding 0s to make it 64 bit
           		 while (hashvalue.length() < 64) 
			{
				//concatenate with preceeding 0s
                		hashvalue = "0" + hashvalue;
            	}
			System.out.println("Output: "+hashvalue);
		}
		catch(NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e);
		}
	}
}
//end of program