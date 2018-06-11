package MarkovTextGenerator;

public interface MarkovTextGenerator {
	void train(String sourceText);
	void retrain(String sourceText);
	String generateText(int numWords);
}
