
//Simple program to write random strings to a file
//to replicate the monkey-typewriter theory

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

class MoTy
{
	public static void main(String[] args)
	throws IOException
	{

		Random rand = new Random();
		
		int     probSpace;
		int 	randomCharNum = rand.nextInt(93) + 33;;	
		int     count=0;
		String  outputString = "";
		char 	letterToWrite = ' ';

		//Run a large number of iterations as the program is unlikely to produce intelligable results
		final int ITERATIONS = 1000000;

		//Relative path to file name
 		FileWriter fWriter = new FileWriter("./moty.txt");


		for (int i=0;i<ITERATIONS;i++)
		{
			count = 0;
			outputString = "";

			//A "sentence" is 50 characters long
			while (count < 50)
			{
				//get a random character
				randomCharNum = rand.nextInt(93) + 33;

				//Space bar is large to a monkey is more likely to hit it
				probSpace = rand.nextInt(8);

				//If not a space, convert the random number to a character
				if (probSpace != 0)
				{
					letterToWrite = (char)randomCharNum;
				}
				//If a space, make char space
				else
				{
					letterToWrite = ' ';
				}
				//Append char to string and go to next pos
				outputString = outputString + letterToWrite;
				count++;

				//Optional code that checks for strings starting with "The",
				//anything else is dismissed and resets loop
				if (!outputString.startsWith("The"))
				{
					if (outputString.length() > 4)
					{
						break;
					}
				}
			}
		try
		{	//Write strings starting with "The"
			if(outputString.startsWith("The ") && outputString.length() > 3)
			{
				//Write string to file
				int y =i+1;
				fWriter.write("String #" + y + ": ");
				fWriter.write(outputString);
				fWriter.write("\n\n");
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		}

		fWriter.close();
	}
}