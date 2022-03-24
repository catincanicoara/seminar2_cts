package ro.ase.cts.exceptions;

public class InvalidPriceException extends Exception{
    @Override
    public String getMessage() {
        return "Pret invalid!";
    }
}
