import java.util.ArrayList;

public class AsciiAlphabet implements Alphabet
{
    ArrayList<Character> letters;
    public AsciiAlphabet()
    {
        letters=new ArrayList<>();
        String str= "0123456789";
        str = str.concat("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        str = str.concat("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase());
        System.out.println(str);
    }
    @Override
    public int getIndex(char input) {
        return 0;
    }

    @Override
    public char getChar(int index) {
        return 0;
    }
}
