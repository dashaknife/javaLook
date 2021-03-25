package Volos.clothes.exception;

public class WrongInputException extends RuntimeException{
    public WrongInputException(String message){
        super(message);
    }

    @Override
    public String toString() {
        return "Wrong input: " + super.getMessage();
    }
}
