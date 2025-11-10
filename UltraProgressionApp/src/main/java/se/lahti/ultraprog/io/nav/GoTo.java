package se.lahti.ultraprog.io.nav;

import se.lahti.ultraprog.io.menu.Menu;

import java.util.Objects;

public final class GoTo implements Nav {
    private final Menu next;
    public GoTo(Menu next){
        this.next = Objects.requireNonNull(next);
    }
    public Menu next(){
        return next;
    }
}
