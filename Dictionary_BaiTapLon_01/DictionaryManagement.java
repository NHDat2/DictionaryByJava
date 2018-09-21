package DictionaryProgram;

import java.util.*;
/**
* DictionaryManagement includes dictionary's manage methods
*/
class DictionaryManagement
{
	/** 
	* insestFromCommandline to get input from commandline
	*@param input_Dictionary is the dictionary to add input to
	*@return not returning any values
	*/
	public void insertFromCommandLine(Dictionary input_Dictionary)
	{
		Scanner scan = new Scanner(System.in);
		int numberOfWord = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < numberOfWord; i++)
		{
			Word input_Word = new Word();
			String input, input2;
			input_Word.setWordTarget(input = scan.nextLine());
			input_Word.setWordExplain(input2 = scan.nextLine());
			input_Dictionary.addElement(input_Word);

			
		}
	}
}