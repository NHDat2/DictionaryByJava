package DictionaryProgram;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
			File path = new File("Dictionaries.txt");
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

	public void addWords(Dictionary add_Dictionary, Word added_Word){
		add_Dictionary.addElement(added_Word);
	}

	public void editWord(Dictionary edit_Dictionary, Word edit_Word, Word replace_Word){
		for (Word value : edit_Dictionary.list_word)
		{
			if (edit_Word.equals(value.getWordTarget()))
			{
				value.setWordTarget(replace_Word.getWordTarget());
				value.setWordExplain(replace_Word.getWordExplain());
			}
		}
	}

	public void deleteWord(Dictionary delete_Dictionary, Word deleted_Word){
		delete_Dictionary.list_word.remove(deleted_Word);
	}
	/**
	* updateFile to update fixed data
	*/
	public void updateFile(Dictionary output_Dictionary){
		try{
			FileWriter writer = new FileWriter("Dictionaries.txt");
    	BufferedWriter buffer = new BufferedWriter(writer);
			for (int i = 0; i < output_Dictionary.list_word.size(); i++)
			{
				String out_Target = output_Dictionary.list_word.get(i).getWordTarget().toString();
				String out_Explain = output_Dictionary.list_word.get(i).getWordExplain().toString();
				buffer.write(out_Target);
				buffer.write("\t");
				buffer.write(out_Explain);
			}
			buffer.close();
			System.out.println("Changes saved...");
		}
		catch(IOException e) {
		  e.printStackTrace();
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
