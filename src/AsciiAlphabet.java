import java.util.ArrayList;

public class AsciiAlphabet implements Alphabet
{
    ArrayList<Character> letters;
    public AsciiAlphabet()
    {
        letters=new ArrayList<>();
        String str= "0123456789";
        str = str.concat("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase());
        str = str.concat("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        for(char c: str.toCharArray())
        {
            letters.add(c);
        }
    }
    @Override
    public int getIndex(char input)
    {
        if(letters.contains(input))
        {
            return letters.indexOf(input);
        }
        else
        {
            throw new IllegalArgumentException();
        }
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
        try
        {
            int ch = getIndex(character);
            return getChar(ch+offset);
        }
        catch (IllegalArgumentException e)
        {
            throw e;
        }
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

    @Override
    public int[] getIndexList(char[] list)
    {
        int[] indexList = new int[list.length];
        for(int i=0;i<list.length;i++)
        {
            if(letters.contains(list[i]))
            {
                indexList[i]=getIndex(list[i]);
            }
        }
        return indexList;
    }
}
