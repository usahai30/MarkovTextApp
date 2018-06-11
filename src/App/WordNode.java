package App;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WordNode {

	private String word;
	private List<String> nextWords;

	public WordNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public
		String getWord()
		{
			return this.word;
		}
	
		void addNextWord(String word)
		{
			this.nextWords.add(word);
		}
		
		String getRandomNextWord(Random gen)
		{
			int size=nextWords.size();
			int index = gen.nextInt(size);
			return nextWords.get(index);
		}
		
		public String toString()
		{
			String toReturn = word + ": ";
			for (String s : nextWords) {
				toReturn += s + "->";
			}
			toReturn += "\n";
			return toReturn;
		}
}
