public class TokenDataComparator implements Comparator {
    public boolean isEqualTo (Object item1, Object item2) {
        if (((TokenData)item1).key.compareTo(((TokenData)item2).key) == 0)
            return true;
        else
            return false;
    }

    public boolean isLessThanOrEqualTo (Object item1, Object item2) {
        if (((TokenData)item1).key.compareTo(((TokenData)item2).key) <= 0)
            return true;
        else
            return false;
    }

    public boolean isGreaterThan (Object item1, Object item2) {
        if (((TokenData)item1).key.compareTo(((TokenData)item2).key) > 0)
            return true;
        else
            return false;
    }

    public boolean isGreaterThanOrEqualTo (Object item1, Object item2) {
        if (((TokenData)item1).key.compareTo(((TokenData)item2).key) >= 0)
            return true;
        else
            return false;
    }
}
