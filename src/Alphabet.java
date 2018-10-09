public interface Alphabet
{
    public int getIndex(char input);
    public char getChar(int index);
    public int getLength();
    public char getCharWithOffset(char character,int offset) throws IllegalArgumentException;
    public int getDifference(char c1, char c2) throws IllegalArgumentException;
    int[] getIndexList(char[] list);
}
