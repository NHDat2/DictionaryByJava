package DictionaryProgram;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
* DictionaryManagement includes dictionary's manage methods
*/
class DictionaryManagement
{
	/** 
	* insestFromCommandline to get input from commandline
	*@param input_Dictionary is the dictionary to add input to
	*@return don't return anything
	*/
	public void insertFromCommandLine(Dictionary inputCmd_Dictionary)
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
			inputCmd_Dictionary.addElement(input_Word);
		}
		scan.close();
	}

	public void insertFromFile(Dictionary inputTxt_Dictionary)
	{
		try
		{
			File path = new File("D:/Java/TH OOP/Dictionary_BaiTapLon_01/Dictionaries.txt");
			FileReader readFile = new FileReader(path);
			BufferedReader bufferReader = new BufferedReader(readFile);
			String line;
			while ((line = bufferReader.readLine()) != null)
			{
				Word input_Word = new Word();
				int index = line.lastIndexOf('\t');
				input_Word.setWordTarget(line.substring(0, index));
				input_Word.setWordExplain(line.substring(index + 1, line.length()));
				inputTxt_Dictionary.addElement(input_Word);
			}
			readFile.close();
			bufferReader.close();
		}
		catch (Exception er)
		{
			System.out.println("Error read file : " + er);
		}
	}

	public void dictionaryLookup(Dictionary find_Dictionary)
	{
		Scanner scan = new Scanner(System.in);
		String key_word = scan.nextLine();
		scan.close();
		for (Word value : find_Dictionary.list_word)
		{
			if (key_word.equals(value.getWordTarget()))
			{
				System.out.println(value.getWordExplain());
			}
		}
	}
}