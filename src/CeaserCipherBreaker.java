import java.util.ArrayList;

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
    }
    return broken;
  }

  private boolean compareToDictionary(String word)
  {
      return false;
  }
}
