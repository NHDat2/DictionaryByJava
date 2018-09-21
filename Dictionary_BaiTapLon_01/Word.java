package DictionaryProgram;

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