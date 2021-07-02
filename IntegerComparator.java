public class IntegerComparator implements Comparator {
    public boolean isEqualTo (Object item1, Object item2) {
        if ((int)item1==(int)item2)
            return true;
        else
            return false;
    }

    public boolean isLessThanOrEqualTo (Object item1, Object item2) {
        if ((int)item1<=(int)item2)
            return true;
        else
            return false;
    }

    public boolean isGreaterThan (Object item1, Object item2) {
        if ((int)item1>(int)item2)
            return true;
        else
            return false;
    }

    public boolean isGreaterThanOrEqualTo (Object item1, Object item2) {
        if ((int)item1>=(int)item2)
            return true;
        else
            return false;
    }
}
