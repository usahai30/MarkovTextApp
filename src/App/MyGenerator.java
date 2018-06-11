package App;

import java.util.List;
import java.util.Random;

import MarkovTextGenerator.*;
import LinkList.*;

public class MyGenerator implements MarkovTextGenerator {
	
	// List of Words with their next words
	private MyLinkedList<WordNode> wordList; 

	// The Staring word
	private String starter;
	
	// Random Number Generator
	private Random rnGenerator;
	
	public MyGenerator(Random generator) {
		wordList = new MyLinkedList<WordNode>();
		starter = "";
		this.rnGenerator = generator;
	}
	
	@Override
	public void train(String sourceText) {
		
		String words[] = sourceText.split("[\\s,.!]+");
		starter = words[0];
		String prevWord = starter;
		
		for(String each: words)
		{
			if(each==starter)
				continue;
			
			int index=0; boolean found=false;
			for(WordNode wn: wordList)
			{
				if(wn.getWord().equals(prevWord))
				{
					found=true;
					wordList.getNodeObject(index).getData().addNextWord(each);
				}
				index++;
			}
			
			if(!found)
			{
				WordNode word = new WordNode(prevWord);
				word.addNextWord(each);
				wordList.add(word);				
			}			
			prevWord = each;			
		}
		
		WordNode word = new WordNode(prevWord);
		word.addNextWord(starter);
		wordList.add(word);				
		
	}

	@Override
	public void retrain(String sourceText) {
		
		//to-do Empty the List
		
		this.train(sourceText);
		
	}

	@Override
	public String generateText(int arg) {
		
		String currWord = starter;
		String output = "";
		output+=currWord;
		int add=0;
		while(add<arg)
		{
			LLNode<WordNode> node = wordList.getNodeObject(currWord);
			String random = node.getData().getRandomNextWord(this.rnGenerator);
			output+=" "+random;
			currWord = random;
			add++;
		}
		return output;
	}
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (WordNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MyGenerator gen = new MyGenerator(new Random());
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		//String textString = "Hi There. Hi Leo.";
		System.out.println(textString);
		gen.train(textString);
		//System.out.println(gen);
		System.out.println(gen.generateText(8));
		
		System.out.println();
		
		MyGenerator gen2 = new MyGenerator(new Random(42));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen2.train(textString2);
		//System.out.println(gen2);
		System.out.println(gen2.generateText(20));
		
	}

}
