package DictionaryProgram;

import java.util.*;
/** 
* dictionay includes words
*/
class Dictionary
{
	public List<Word> list_word = new ArrayList<Word>();
	/** 
	* addElement to add new words to the dictionary
	*@param newWord the new word to be added
	*@return no returning any values
	*/
	public void addElement(Word newWord)
	{
		list_word.add(newWord);
	}
}