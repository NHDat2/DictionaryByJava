package DictionaryProgram;

/**
 * class Word
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 * @version 1.0
 */

public class Word
{
	private String word_target = "";
	private String word_explain = "";

	public void setWordTarget(String newWordTarget)
	{
		this.word_target = newWordTarget;
	}
	public void setWordExplain(String explainNewWord)
	{
		this.word_explain = explainNewWord;
	}
	public String getWordTarget()
	{
		return this.word_target;
	}
	public String getWordExplain()
	{
		return this.word_explain;
	}
}