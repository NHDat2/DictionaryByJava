package DictionaryProgram;
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
		showAllWord(input_Dictionary);
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
		global_Dic_Commandline.dictionaryBasic(global_Dic_Management, global_Dictionary);
	}
}
