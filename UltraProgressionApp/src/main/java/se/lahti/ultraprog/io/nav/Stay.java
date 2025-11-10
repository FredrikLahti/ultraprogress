package se.lahti.ultraprog.io.nav;


public final class Stay implements Nav{
    private static final Stay INSTANCE = new Stay();
    private Stay(){}
    public static Stay get(){
        return INSTANCE;
    }
}
