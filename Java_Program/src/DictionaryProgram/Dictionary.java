package DictionaryProgram;

import java.util.*;
/**
 * class Dictionary is use to creat List_Word
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 * @version 1.0
 */
public class Dictionary
{
	public List<Word> list_word = new ArrayList<Word>();
	/**
	 * addElement to add new words to the dictionary
	 *@param newWord the new word to be added
	 *@return no returning any values
	 */
	public boolean addElement(Word newWord)
	{
		return list_word.add(newWord);
	}
}