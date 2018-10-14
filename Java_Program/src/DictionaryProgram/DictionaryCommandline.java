package DictionaryProgram;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

/**
 * DictionaryCommanline manages actions through commanline
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 * @version 1.0
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
		System.out.println("No" + "\t" + "English" + "           |            " + "Vietnamese");
		System.out.println("-------------------------------------------------------------------------");
		for (int i = 0; i < showInfo_Dictionary.list_word.size(); i++)
		{
			String wordTarget = showInfo_Dictionary.list_word.get(i).getWordTarget().toString();
			String wordExplain = showInfo_Dictionary.list_word.get(i).getWordExplain().toString();
			int numOfSpace = 30;
			numOfSpace = 30 - wordTarget.length();
			String tabs = "";
			for (int j = 0; j < numOfSpace; j++) tabs = tabs + " ";
			System.out.println(i + 1 + "\t" + wordTarget + tabs + wordExplain);
		}
		System.out.println("-------------------------------------------------------------------------");
		try{
			TimeUnit.SECONDS.sleep(3);
		}
		catch (Exception er){};
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

	/**
	 * method dictionaryAdvanced use methods inserFromFile and ShowAllWord
	 * @param inputTxt_Dictionary
	 * @param input_Dictionary
	 */
	public void dictionaryAdvanced(DictionaryManagement inputTxt_Dictionary, Dictionary input_Dictionary)
	{
		inputTxt_Dictionary.insertFromFile(input_Dictionary, "avdict.txt");
		showAllWord(input_Dictionary);
		//inputTxt_Dictionary.dictionaryLookup(input_Dictionary);
	}

	/**
	 * dictionarySearcher use to search list words have subString is string input
	 * @param search_Dictionary
	 */
	public void dictionarySearcher(Dictionary search_Dictionary)
	{
		String input_Word;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your word: ");
		input_Word = scan.nextLine();
		boolean existWord = false;
		for (int i = 0; i < search_Dictionary.list_word.size(); i++)
		{
			String compare_Target = search_Dictionary.list_word.get(i).getWordTarget().toString();
			String compare_Explain = search_Dictionary.list_word.get(i).getWordExplain().toString();
			int isFound = compare_Target.indexOf(input_Word);
			if (isFound != -1 && isFound == 0)
			{
				existWord = true;
				System.out.print(compare_Target);
				System.out.print("\t");
				System.out.print(compare_Explain);
				System.out.print("\n");
			}
		}
		if (existWord == false)
		{
			System.out.println("Your asked word does not exist!");
		}
		try{
			TimeUnit.SECONDS.sleep(2);
		}
		catch (Exception er){};
	}

	/**
	 * showMenu use to showMenu
	 * @param manage_Dictionary
	 * @param main_Dictionary
	 * @param main_translator
	 */
	public void showMenu(DictionaryManagement manage_Dictionary, Dictionary main_Dictionary, Translator main_translator)
	{
		Scanner scan = new Scanner(System.in);
		int chooseNumber = 0;
		while (chooseNumber < 11)
		{
			System.out.println("Choose your option: ");
			System.out.println("1. get input from commandline");
			System.out.println("2. get input from text file");
			System.out.println("3. add word");
			System.out.println("4. edit word");
			System.out.println("5. delete word");
			System.out.println("6. lookup");
			System.out.println("7. show all words");
			System.out.println("8. search for words");
			System.out.println("9. save all changes");
			System.out.println("10. search for words online");
			System.out.println("11. exit");
			chooseNumber = scan.nextInt();
			switch (chooseNumber) {
				case 1 :
					manage_Dictionary.insertFromCommandLine(main_Dictionary);
					break;
				case 2 :
					manage_Dictionary.insertFromFile(main_Dictionary, "avdict.txt");
					break;
				case 3 :
					System.out.print("\nEnter word_Target : ");
					String word_target = scan.nextLine();
					System.out.print("\nEnter word_Explain : ");
					String word_explain = scan.nextLine();
					Word word = new Word();
					word.setWordTarget(word_target);
					word.setWordExplain(word_explain);
					manage_Dictionary.addWords(main_Dictionary, word);
					manage_Dictionary.dictionaryExportToFile(main_Dictionary);
					break;
				case 4 :
					System.out.print("\nEnter word is needed edit : ");
					String edit_word = scan.nextLine();
					System.out.print("\nEnter word_Target replace : ");
					String replace_wordTarget = scan.nextLine();
					System.out.print("\nEnter word_Explain replace : ");
					String replace_wordExplain = scan.nextLine();
					Word word_repalce = new Word();
					word_repalce.setWordExplain(replace_wordExplain);
					word_repalce.setWordTarget(replace_wordTarget);
					manage_Dictionary.editWord(main_Dictionary, edit_word, word_repalce);
					manage_Dictionary.dictionaryExportToFile(main_Dictionary);
					break;
				case 5 :
					System.out.print("\nEnter word is needed delete : ");
					String word_delete = scan.nextLine();
					manage_Dictionary.deleteWord(main_Dictionary, word_delete);
					manage_Dictionary.dictionaryExportToFile(main_Dictionary);
					break;
				case 6 :
					System.out.print("\nEnter word is needed find : ");
					String word_find = scan.nextLine();
					manage_Dictionary.dictionaryLookup(main_Dictionary, word_find);
					break;
				case 7 :
					showAllWord(main_Dictionary);
					break;
				case 8 :
					dictionarySearcher(main_Dictionary);
					break;
				case 9 :
					manage_Dictionary.dictionaryExportToFile(main_Dictionary);
					break;
				case 10 :
					try{
						main_translator.get_translator("house");
					}
					catch (Exception er)
					{
						System.out.println("Error read file : " + er);
					}
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
		Translator global_Translator = new Translator();
		global_Dic_Commandline.showMenu(global_Dic_Management, global_Dictionary, global_Translator);
	}
}