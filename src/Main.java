import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
      if(args.length==1)
      {
          String str = "";
          String message = "";
          try
          {
              BufferedReader br = new BufferedReader(new FileReader(args[0]));
              while((str = br.readLine()) != null)
                  message += str;
          }
          catch (IOException e) {
              e.printStackTrace();
          }
          CeaserCipherBreaker ceaserCipherBreaker = new CeaserCipherBreaker(new CeaserCipher(),message,new AsciiAlphabet());
          System.out.println(ceaserCipherBreaker.breakText());
      }
      else
      {
          System.out.println("Invalid number of params");
      }
    }
}
