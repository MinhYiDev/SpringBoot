package customException;

public class FieldRequiredException extends RuntimeException{
	
	public FieldRequiredException(String s) {
		super(s);
	}
}
