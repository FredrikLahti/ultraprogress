package se.lahti.ultraprog.io.nav;

public final class Exit implements Nav{
    private static final Exit INSTANCE = new Exit();
    private Exit(){}
    public static Exit get(){return INSTANCE;}
}
