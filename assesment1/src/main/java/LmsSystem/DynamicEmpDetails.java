package LmsSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.regex.Pattern;

@Data
public class DynamicEmpDetails {
    private EmpType empType;
    private EmpRole empRole;
    private String email;


    public DynamicEmpDetails(EmpType empType, EmpRole empRole, String email) throws Exception{

        if(isValidEmail(email)){
            throw new Exception("Invalid Email");
        }

        this.email = email;
        this.empType = empType;
        this.empRole = empRole;

    }


    public boolean isValidEmail(String email) {

        return email.matches("[A-Z0-9._%+-][A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{3}");
    }

}
