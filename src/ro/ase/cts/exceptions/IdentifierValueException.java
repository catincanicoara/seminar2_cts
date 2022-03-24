package ro.ase.cts.exceptions;

public class IdentifierValueException extends Exception{
    @Override
    public String getMessage() {
        return "Id introdus gresit!";
    }
}
