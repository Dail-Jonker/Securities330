public class CeaserCipherBreaker
{
  public CeaserCipher cc = null;
  public String text = "";
  public Alphabet alphabet;
  public CeaserCipherBreaker(CeaserCipher _cc, String _text, Alphabet _alphabet)
  {
    cc = _cc;
    text = _text;
    alphabet = _alphabet;
  }
  public int[] Frequency(String a, String encoded)
  {
    int[] freq = new int[a.length()];

    for(int i = 0; i < a.length(); i++)
    {
      for(int j = 0; j < encoded.length(); j++)
      {
        if(a.charAt(i) == encoded.charAt(j))
          freq[i]++;
      }
    }
    return freq;
  }

  public boolean IsEnglish(String word)
  {
    String[] one = {"a", "i"};
    String[] two = {"of", "to", "in", "it", "is", "be", "as", "at", "so", "we",
    "he", "by", "or", "on", "do", "if", "me", "my", "up", "an", "go", "no", "us", "am"};
    String[] three = {"the", "and", "for", "are", "but", "not", "you", "all", "any", "can",
    "had", "her", "was", "one", "our", "out", "day", "get", "has", "him", "his", "how",
    "man", "new", "now", "old", "see", "two", "way", "who", "boy", "did", "its", "let", "put",
    "say", "she", "too", "use"};
    String[] four = {"that", "with", "have", "this", "will", "your", "from", "they",
    "know", "want", "been", "good", "much", "some", "time"};

    if(word.length() == 1)
    {
      for(int i = 0; i < one.length; i++)
      {
        if(word == one[i])
          return true;
      }
      return false;
    }
    else if(word.length() == 2)
    {
      for(int i = 0; i < two.length; i++)
      {
        if(word == two[i])
          return true;
      }
      return false;
    }
    else if(word.length() == 3)
    {
      for(int i = 0; i < three.length; i++)
      {
        if(word == three[i])
          return true;
      }
      return false;
    }
    else if(word.length() == 4)
    {
      for(int i = 0; i < four.length; i++)
      {
        if(word == four[i])
          return true;
      }
      return false;
    }
    else
    {
      System.out.println("Choose a word of length 1 to 4");
      return false;
    }
  }
}
