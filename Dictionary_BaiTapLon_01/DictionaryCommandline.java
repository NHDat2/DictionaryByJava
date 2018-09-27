package DictionaryProgram;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
* DictionaryCommanline manages actions through commanline
*/
public class DictionaryCommandline
{
	/**
	* showAllWord prints all current words from the dictionary
	*@param showInfo_Dictionary is the dictionary which is needed to print
	*@return this function doesn't return any values
	*/
	public void showAllWord(Dictionary showInfo_Dictionary)
	{
		System.out.println("No\t" + "English\t" + "Vietnamese");
		for (int i = 0; i < showInfo_Dictionary.list_word.size(); i++)
		{
			String wordTarget = showInfo_Dictionary.list_word.get(i).getWordTarget().toString();
			String wordExplain = showInfo_Dictionary.list_word.get(i).getWordExplain().toString();
			System.out.println(i + 1 + "\t" + wordTarget + "\t" + wordExplain);
		}
		System.out.println("-------------------------------------------------------------------------");
	}
	/**
	* dictionaryBasic includes basic actions to do with a dictionary
	*@param insert_Dictionary to call insert function
	*@param input_Dictionary is the dictionary which is needed to use
	*@return this function doesn't return any values
	*/
	public void dictionaryBasic(DictionaryManagement insert_Dictionary, Dictionary input_Dictionary)
	{
		insert_Dictionary.insertFromCommandLine(input_Dictionary);
		//insert_Dictionary.insertFromFile(input_Dictionary);
		showAllWord(input_Dictionary);
	}

	public void dictionaryAdvanced(DictionaryManagement inputTxt_Dictionary, Dictionary input_Dictionary)
	{
		inputTxt_Dictionary.insertFromFile(input_Dictionary);
		showAllWord(input_Dictionary);
		inputTxt_Dictionary.dictionaryLookup(input_Dictionary);
	}

	public void showMenu(DictionaryManagement manage_Dictionary, Dictionary main_Dictionary){
		Scanner scan = new Scanner(System.in);
		int chooseNumber = 0;
		while (chooseNumber < 8)
		{			
			System.out.println("Choose your option: ");
			System.out.println("1. get input from commandline");
			System.out.println("2. get input from text file");
			System.out.println("3. add word");
			System.out.println("4. edit word");
			System.out.println("5. delete word");
			System.out.println("6. lookup");
			System.out.println("7. show all words");
			System.out.println("8. exit");
			chooseNumber = scan.nextInt();
			switch (chooseNumber) {
				case 1 :
					manage_Dictionary.insertFromCommandLine(main_Dictionary);
					break;
				case 2 :
					manage_Dictionary.insertFromFile(main_Dictionary);
					break;
				case 3 :
					manage_Dictionary.addWords(main_Dictionary);
					manage_Dictionary.updateFile(main_Dictionary);
					break;
				case 4 :
					manage_Dictionary.editWord(main_Dictionary);
					manage_Dictionary.updateFile(main_Dictionary);
					break;
				case 5 :
					manage_Dictionary.deleteWord(main_Dictionary);
					manage_Dictionary.updateFile(main_Dictionary);
					break;
				case 6 :
					manage_Dictionary.dictionaryLookup(main_Dictionary);
					break;
				case 7 :
					showAllWord(main_Dictionary);
					break;
				default:
					System.out.println("End or unknown command, closing...");
					break;
			}
		}
	}
	/**
	* main function to take main ativities
	* @param args
	* @return don't return anything
	*/
	public static void main(String[] args)
	{
		Dictionary global_Dictionary = new Dictionary();
		DictionaryManagement global_Dic_Management = new DictionaryManagement();
		DictionaryCommandline global_Dic_Commandline = new DictionaryCommandline();
		//global_Dic_Commandline.dictionaryBasic(global_Dic_Management, global_Dictionary);
		//global_Dic_Commandline.dictionaryAdvanced(global_Dic_Management, global_Dictionary);
		global_Dic_Commandline.showMenu(global_Dic_Management, global_Dictionary);
	}
}
