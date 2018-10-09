public interface Cipher
{
    String decode(String value, Alphabet alphabet, int offset);
    void addIgnore(char c);
    void addIgnore(char[] chars);
}
