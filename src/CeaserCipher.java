import java.util.ArrayList;

public class CeaserCipher implements Cipher
{
    ArrayList<Character> ignore;
    public CeaserCipher()
    {
        ignore=new ArrayList<>();
    }

    public CeaserCipher(char[] c)
    {
        ignore=new ArrayList<>();
        addIgnore(c);
    }

    @Override
    public String decode(String value, Alphabet alphabet, int offset)
    {
        StringBuilder b = new StringBuilder();
        for(char c: value.toCharArray())
        {
            if(!ignore.contains(c))
            {
                try
                {
                    b.append(alphabet.getCharWithOffset(c,-offset));
                }
                catch (IllegalArgumentException e)
                {
                    addIgnore(c);
                    b.append(c);
                }
            }
            else
            {
                b.append(c);
            }
        }
        return b.toString();
    }

    @Override
    public void addIgnore(char c)
    {
        if(!ignore.contains(c))
        {
            ignore.add(c);
        }
    }

    @Override
    public void addIgnore(char[] chars)
    {
        for(char c:chars)
        {
            if(!ignore.contains(c))
            {
                ignore.add(c);
            }
        }
    }
}
