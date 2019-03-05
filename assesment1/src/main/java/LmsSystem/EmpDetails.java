package LmsSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

@AllArgsConstructor
@Getter
@Setter
public class EmpDetails {
    String name;
    int empId;
    String dateOfJoin;
    DynamicEmpDetails dynamicEmpDetails;
    int leaveCredits ;

    public EmpDetails(String name, int empId, String dateofJoin, DynamicEmpDetails dynamicEmpDetails){
        this.name = name;
        this.empId = empId;
        this.dateOfJoin = dateofJoin;
        this.dynamicEmpDetails = dynamicEmpDetails;

        if(dynamicEmpDetails.getEmpType() == EmpType.PROBATION){
            leaveCredits = 0;
        }
        else{
            leaveCredits = 25;
        }
    }


}
