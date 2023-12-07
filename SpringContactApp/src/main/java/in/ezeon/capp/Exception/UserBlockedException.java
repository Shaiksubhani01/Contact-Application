package in.ezeon.capp.Exception;

@SuppressWarnings("serial")
public class UserBlockedException extends Exception{
	
	//creates Users obj without  error description
	//if you are  using these constructor there won't be any error mess. 
	public UserBlockedException() {
		
	}
	//creates Users obj with  error description
	// if you want to take some error details you can use these constructor.
   public UserBlockedException(String errDesc) {
		super(errDesc);
	}
}
