package LinkedList.exception;

public class InvalidPosition extends Exception{
    public InvalidPosition(){
        super("Invalid position");
    }

    public InvalidPosition(String message){
        super(message);
    }
}
