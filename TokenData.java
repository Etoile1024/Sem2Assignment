public class TokenData {
    public String key;

    public LinkedList list = new LinkedList(new IntegerComparator()); //used to store lineNum

    public TokenData(String key, int line) {
        this.key = key;
        list.addToHead(line);
    }
    public String toString() {
        return String.format("%-25s: %s",key,list.toString());
    }
}
