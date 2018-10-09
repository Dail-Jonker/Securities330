import java.util.ArrayList;

public class AsciiAlphabet implements Alphabet
{
    ArrayList<Character> letters;
    public AsciiAlphabet()
    {
        letters=new ArrayList<>();
        String str= "0123456789";
        str = str.concat("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase());
        //str = str.concat("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        for(char c: str.toCharArray())
        {
            letters.add(c);
        }
    }
    @Override
    public int getIndex(char input)
    {
        input = Character.toLowerCase(input);
        return letters.indexOf(input);
    }

    @Override
    public char getChar(int index)
    {
        if(index<0)
        {
            index=(letters.size())+index;
        }
        else if(index>letters.size()-1)
        {
            index=index%letters.size();
        }
        return letters.get(index);
    }

    @Override
    public int getLength() {
        return letters.size();
    }

    @Override
    public char getCharWithOffset(char character, int offset)
    {
        int ch = getIndex(character);
        return getChar(ch+offset);
    }

    @Override
    public int getDifference(char c1, char c2)
    {
        int ret =0;
        if(letters.contains(c1)&&letters.contains(c2))
        {
            ret=getIndex(c1)-getIndex(c2);
        }
        else
        {
            throw new IllegalArgumentException();
        }
        return ret;
    }
}
