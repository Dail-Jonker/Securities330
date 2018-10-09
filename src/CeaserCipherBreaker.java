public class CeaserCipherBreaker
{
  public CeaserCipherBreaker()
  {
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
}
