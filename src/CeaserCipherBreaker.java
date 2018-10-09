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

  public String breakText()
  {
    String broken="";
    return broken;
  }

  private boolean compareToDictionary(String word)
  {
      return false;
  }
}
