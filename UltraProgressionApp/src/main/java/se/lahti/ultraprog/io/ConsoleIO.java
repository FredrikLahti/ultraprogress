package se.lahti.ultraprog.io;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;

/**
 *
 *
 *
 *
 */
public class ConsoleIO {
    private final Scanner in;
    private final PrintStream out;
    private final Locale locale;

    public ConsoleIO(InputStream input, PrintStream out, Locale locale){
        this.in = new Scanner(input);
        this.out = out;
        this.locale = locale == null ? Locale.getDefault() : locale;
    }






    //------Printing-----------
    public void println(String s){
        out.println(s);
    }
    public void print(String s){
        out.print(s);
    }
    public void line(){
        out.println();
    }


    //Clear Screen

    public void clearScreen(){
        try{
            out.printf("\033[H\033[2J");
            out.flush();
        } catch (Exception ignore){
            for (int i = 0; i<30; i++){
                out.println();
            }
        }
    }
    public void header(String title){
        out.println();
        out.println("== " + title + " ==");
    }

    public void pressEnterToContinue(){
        out.println("Press Enter to continue...");
        in.nextLine();
    }

    public String readLine(String prompt){
        while(true){
            out.print(prompt);
            String s= in.nextLine().trim();
            if(!s.isBlank()) return s;
            out.println("Input cannot be blank, try again.");
        }
    }

    //read nonblank

    //------Integers----------

    //readint

    public int readInt(String prompt){
        while(true){
            out.print(prompt);
            String intLine = in.nextLine();
            try{
                return Integer.parseInt(intLine);
            } catch (NumberFormatException e) {
                out.println("Invalid input. Try again..");
            }
        }
    }


    //readint mininclusive and maxinclusive

    public int readInt(String prompt, int minInclusive, int maxInclusive){
        while(true){
            int userInt = readInt(prompt);
            if(userInt < minInclusive || userInt > maxInclusive) {
                out.printf("Not in range. Range is [%d - %d]. Try again..",minInclusive, maxInclusive);
            }
            return userInt;
        }
    }

    //--------Booleans-----------

    public boolean readYesNo(String prompt){
        while(true){
            out.print(prompt + "[Yes/No]");
            String answer = in.nextLine().trim().toLowerCase();
            if(answer == "yes" || answer == "y") return true;
            if (answer == "no" || answer == "n") return false;
            out.println("Invalid entry. Answer [Yes/y] or [No/n]");
        }
    }


    //---------DATES-------------
    public LocalDate readDate(String prompt, DateTimeFormatter fmt){
        while(true){
            out.print(prompt + " (" + fmt.toString() + "): ");
            String s = in.nextLine().trim();

            try{
                return LocalDate.parse(s,fmt);
            } catch (DateTimeParseException e){
                out.println("Invalid date format. Try again..");
            }
        }
    }
    //Convenience ISO-8601 (yyyy-MM-dd)
    public LocalDate readIsoDate(String prompt) {
        return readDate(prompt, DateTimeFormatter.ISO_LOCAL_DATE);
    }




    //---------Generic picker--------------

    //Paginate
    public <T> void paginate(List<T> items, int pageSize, Function<T ,String> toLine){
        if(items == null || items.isEmpty()){
            out.println("(No items)");
        }
        int total = items.size();
        int page = 0;
        while (true){
            int start = page * pageSize;
            int end = Math.min(start + pageSize, total);
            out.printf("Showing %d-%d of %d%n", start +1, end, total);
            for (int i = start ; i < end; i++){
                String line = toLine == null ? String.valueOf(items.get(i)) : toLine.apply(items.get(i));
                out.println(line);
            }
            if(end >= total) {
                out.println("(End)");
                break;
            }
            String cmd = readLine("n) next page, q) quit: ").trim().toLowerCase(locale);
            if (cmd.equals("n")) { page++; }
            else break;
        }
    }
}
