import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
      String str = "";
      String message = "";
      try
      {
        BufferedReader br = new BufferedReader(new FileReader("CeasarText.txt"));
        while((str = br.readLine()) != null)
          message += str;
      }
      catch (IOException e) {
        e.printStackTrace();
      }

      CeaserCipherBreaker ceaserCipherBreaker = new CeaserCipherBreaker(new CeaserCipher(),str,new AsciiAlphabet());
      if(ceaserCipherBreaker.IsEnglish("I"));
      {
        System.out.println("Yes");
      }
      CeaserCipherBreaker ceaserCipherBreaker = new CeaserCipherBreaker(new CeaserCipher(),message,new AsciiAlphabet());
        System.out.println(ceaserCipherBreaker.breakText());
    }
}
