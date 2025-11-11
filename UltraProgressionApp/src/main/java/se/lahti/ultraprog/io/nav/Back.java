package se.lahti.ultraprog.io.nav;

/**
 * Navigation class to go back in the program
 *
 */

public final class Back implements Nav {
    private static final Back INSTANCE = new Back();
    private Back(){}
    public static Back get(){
        return INSTANCE;
    }
}
