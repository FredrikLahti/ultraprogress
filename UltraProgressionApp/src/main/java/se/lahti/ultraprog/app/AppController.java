package se.lahti.ultraprog.app;

import se.lahti.ultraprog.io.ConsoleIO;
import se.lahti.ultraprog.io.menu.Menu;
import se.lahti.ultraprog.io.nav.*;
import se.lahti.ultraprog.service.Services;

import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Deque;

public class AppController {
    private final ConsoleIO io;
    private final Services services;
    private final Deque<Menu> stack = new ArrayDeque<>();


    public AppController(ConsoleIO io, Services services, Menu start){
        this.io = io;
        this.services = services;
        stack.push(start);
    }

    public void run(){
        while(!stack.isEmpty()){
            Menu current = stack.peek();
            io.println("\n== " + current.title() + " ==");
            Nav nav = current.handle(io,services);


            if(nav instanceof Stay) continue;
            if (nav instanceof GoTo g) {stack.push(g.next()); continue;}
            if (nav instanceof Back) {stack.pop(); continue;}
            if (nav instanceof Exit) break;
        }
        io.println("Goodbye!");
    }
}
