package se.lahti.ultraprog.io.menu;

import se.lahti.ultraprog.io.ConsoleIO;
import se.lahti.ultraprog.io.nav.Nav;
import se.lahti.ultraprog.service.Services;

import java.time.format.DateTimeFormatter;

public interface Menu {

    String title();

    /**
     * The menu prints options for the specific screen
     * It reads input with ConsoleIO methods
     * It calls services to perform actions
     * @param io I/O handler and validator
     * @param svc Umbrella to connect to all service classes.
     * @return Nav to tell controller where to go next.
     */
    Nav handle(ConsoleIO io, Services svc);
}
