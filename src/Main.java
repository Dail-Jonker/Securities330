import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
      String str = "";
      String message = "";
      try
      {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        while((str = br.readLine()) != null)
          message += str;
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }

      CeaserCipherBreaker ceaserCipherBreaker = new CeaserCipherBreaker(new CeaserCipher(),str,new AsciiAlphabet());
    }
}
