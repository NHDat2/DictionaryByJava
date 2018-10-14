package DictionaryProgram;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * DictionaryManagement use to manage inputting, adding, editing, deleting Dictionary
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 * @version 1.0
 */

public class DictionaryManagement
{
	/**
	 * insestFromCommandline to get input from commandline
	 *@param inputCmd_Dictionary is the dictionary to add input to
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

    /**
     * insertFromFile use to input Dictionary from file
     * @param inputTxt_Dictionary
     */
	public void insertFromFile(Dictionary inputTxt_Dictionary, String filename)
	{
		try
		{
			File path = new File(".\\src\\data\\" + filename);
			FileReader readFile = new FileReader(path);
			BufferedReader bufferReader = new BufferedReader(readFile);
			String line;
			while ((line = bufferReader.readLine()) != null)
			{
				if(line.charAt(0) == '*') continue;
				Word input_Word = new Word();
				int index = line.indexOf('\t');
				if (index == -1) continue;
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

    /**
     * addWord use to add word into available dictionary
     * @param add_Dictionary
     * @param added_Word
     * @return true/false
     */
	public boolean addWords(Dictionary add_Dictionary, Word added_Word)
	{
		if (add_Dictionary.addElement(added_Word))
		{
			return true;
		}
		return false;
	}

    /**
     * editWord use to edit word from available dictionary
     * @param edit_Dictionary
     */
	public boolean editWord(Dictionary edit_Dictionary, String edit_WordTarget, Word replace_Word)
	{
		for (Word value : edit_Dictionary.list_word)
		{
			if (edit_WordTarget.equals(value.getWordTarget()))
			{
				value.setWordTarget(replace_Word.getWordTarget());
				value.setWordExplain(replace_Word.getWordExplain());
				return true;
			}
		}
		try{
			TimeUnit.SECONDS.sleep(2);
		}
		catch (Exception er){};
		return false;
	}

    /**
     * deleteWord method use to delete word from dictionary
     * @param delete_Dictionary
     * @param word_Delete
     * @return true/false
     */
	public boolean deleteWord(Dictionary delete_Dictionary, String word_Delete)
	{
		for (int i = 0; i < delete_Dictionary.list_word.size(); i++)
		{
			String delete_Target = delete_Dictionary.list_word.get(i).getWordTarget();
			if (delete_Target.equals(word_Delete))
			{
				delete_Dictionary.list_word.remove(i);
				return true;
			}
		}
		//System.out.println("Deleted");
		try{
			TimeUnit.SECONDS.sleep(2);
		}
		catch (Exception er){};
		return false;
	}

    /**
     * dictionaryExportToFile method is used to override out file data
     * @param output_Dictionary
     */
	public void dictionaryExportToFile(Dictionary output_Dictionary){
		try{
			FileWriter writer = new FileWriter(".\\src\\data\\avdict.txt");
			BufferedWriter buffer = new BufferedWriter(writer);
			for (int i = 0; i < output_Dictionary.list_word.size(); i++)
			{
				String out_Target = output_Dictionary.list_word.get(i).getWordTarget();
				String out_Explain = output_Dictionary.list_word.get(i).getWordExplain();
				buffer.write(out_Target);
				buffer.write("\t");
				buffer.write(out_Explain);
				buffer.write("\n");
			}
			buffer.close();
			System.out.println("Changes saved...");
			try{
				TimeUnit.SECONDS.sleep(3);
			}
			catch (Exception er){};
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * dictionaryLookup method use to search word from dictionary
     * @param find_Dictionary
     * @param word_target
     * @return
     */
	public String dictionaryLookup(Dictionary find_Dictionary, String word_target)
	{
		for (Word value : find_Dictionary.list_word)
		{
			String s = value.getWordTarget();
			if (s.equals(word_target))
			{
				return value.getWordExplain();
			}
		}
		return "";
	}
}