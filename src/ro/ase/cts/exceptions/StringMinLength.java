package ro.ase.cts.exceptions;

public class StringMinLength extends Exception{
    @Override
    public String getMessage() {
        return "Lungimea setata incorect!";
    }
}
