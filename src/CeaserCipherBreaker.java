import java.util.ArrayList;
import java.util.Scanner;

public class CeaserCipherBreaker
{
  private CeaserCipher cc = null;
  private String text = "";
  private Alphabet alphabet;
  private ArrayList<Character> ignoredCharacters;
  private int[] freq;
  public CeaserCipherBreaker(CeaserCipher _cc, String _text, Alphabet _alphabet)
  {
        cc = _cc;
        text = _text;
        alphabet = _alphabet;
        ignoredCharacters = new ArrayList<>();
        this.freq=Frequency(_alphabet,_text);
  }
  public int[] Frequency(Alphabet a, String encoded)
  {
    int[] freq = new int[a.getLength()];
    for(int j = 0; j < encoded.length(); j++)
    {
        char c = encoded.charAt(j);
        try
        {
            freq[this.alphabet.getIndex(c)]++;
        }
        catch (IllegalArgumentException e)
        {
            ignoredCharacters.add(c);
        }
    }
    return freq;
  }

  public boolean IsEnglish(String word) {
      String[] one = {"a", "i"};
      String[] two = {"of", "to", "in", "it", "is", "be", "as", "at", "so", "we",
              "he", "by", "or", "on", "do", "if", "me", "my", "up", "an", "go", "no", "us", "am"};
      String[] three = {"the", "and", "for", "are", "but", "not", "you", "all", "any", "can",
              "had", "her", "was", "one", "our", "out", "day", "get", "has", "him", "his", "how",
              "man", "new", "now", "old", "see", "two", "way", "who", "boy", "did", "its", "let", "put",
              "say", "she", "too", "use"};
      String[] four = {"that", "with", "have", "this", "will", "your", "from", "they",
              "know", "want", "been", "good", "much", "some", "time"};

      if (word.length() == 1) {
          for (int i = 0; i < one.length; i++) {
              if (word == one[i])
                  return true;
          }
          return false;
      } else if (word.length() == 2) {
          for (int i = 0; i < two.length; i++) {
              if (word.equalsIgnoreCase(two[i]))
                  return true;
          }
          return false;
      } else if (word.length() == 3) {
          for (int i = 0; i < three.length; i++) {
              if (word.equalsIgnoreCase(three[i]))
                  return true;
          }
          return false;
      } else if (word.length() == 4) {
          for (int i = 0; i < four.length; i++) {
              if (word.equalsIgnoreCase(four[i]))
                  return true;
          }
          return false;
      } else {
          //System.out.println("Choose a word of length 1 to 4");
          return false;
      }
  }
  private int getMostFrequentIndexBelow(int prevIndex)//if last prevIndex is =-1 it will return the max index
  {
        if(prevIndex<this.freq.length)
        {
            int index=0;
            int freq=0;
            int maxFreq=0;
            if(prevIndex==-1)
            {
                maxFreq = Integer.MAX_VALUE;
            }
            else
            {
                maxFreq=this.freq[prevIndex];
            }
            for(int i=0;i<this.freq.length;i++)
            {
                if(this.freq[i]<=maxFreq&&i!=prevIndex)
                {
                    if(this.freq[i]>freq)
                    {
                        index=i;
                        freq=this.freq[i];
                    }
                }
            }
            return index;
        }
        else
        {
            throw new IllegalArgumentException();
        }
  }

  public String breakText()
  {
    String broken="";
    boolean run =true;
    char[] englishFreq= {'e','t','a','o','i', 'n', 's', 'r' ,'h' ,'l','d','c','u','m','f','p','g','w','y','b','v','k','x','j','q','z'};
    int mostCommonFromCypher = getMostFrequentIndexBelow(-1);
    char mostCommon = alphabet.getChar(mostCommonFromCypher);
    for (int i =0;i<englishFreq.length;i++)
    {
        int difference = alphabet.getDifference(mostCommon,englishFreq[i]);
        String decipherd =cc.decode(text,alphabet,difference);
        Scanner scanner = new Scanner(decipherd);
        int englishCount=0;
        while (scanner.hasNext()&&englishCount<3)
        {
            String str = scanner.next();
            if(IsEnglish(str))
            {
                englishCount++;
            }
        }
        if (englishCount==3)
        {
            broken=decipherd;
            break;
        }
    }
    return broken;
  }

  private boolean compareToDictionary(String word)
  {
      return false;
  }
}
