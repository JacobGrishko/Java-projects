package dictionary;

import java.util.TreeMap;

public class DictModel {
	
	public boolean mainDict;
	
	TreeMap<String,String> dictionary;
	TreeMap<String,String> fileDictionary;
	
	public DictModel() {
		dictionary = new TreeMap<String,String>();
		examples();
		mainDict = true;
	}
	
	public void examples() {
		dictionary.put("apple", "A fruit, growing on trees.");
		dictionary.put("ass", "An animal, other known as Donkey. Like from the movie Shrek (Shrek is love, shrek is life)");
		dictionary.put("231241", "A number, comes before 231242.");
		dictionary.put("weeaboo", "A non japanese person who denounces thier own culture and call themselves japanese."
						+ "	They try to learn japanese through anime they watch and usually end up pronouncing it wrong and looking like a complete idiot.");
		dictionary.put("bush", "Like a tree, but small. almost no wood. Or USA's 2 presidents.");
	}
	
}
