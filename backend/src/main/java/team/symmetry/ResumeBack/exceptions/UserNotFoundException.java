package team.symmetry.ResumeBack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(int id){
        super("Could not found the user with id "+id);
    }
    public UserNotFoundException(String string) {
        super(string);
    }
}
