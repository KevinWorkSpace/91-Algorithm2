package Advanced.BitOperation;

public class IsUnique {

    public boolean isUnique(String astr) {
        int mark = 0;
        for (int i=0; i<astr.length(); i++) {
            int bit = astr.charAt(i) - 'a';
            if ((mark & (1 << bit)) != 0) {
                return false;
            }
            else {
                mark |= 1 << bit;
            }
        }
        return true;
    }
}
