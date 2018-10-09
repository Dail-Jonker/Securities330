public interface Cipher
{
    String encode(String value, Alphabet alphabet, int offset);
    String decode(String value, Alphabet alphabet, int offset);
    void addIgnore(char c);
    void addIgnore(char[] chars);
}
