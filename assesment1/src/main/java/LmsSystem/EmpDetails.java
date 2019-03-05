package LmsSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmpDetails {
    String Name;
    int empId;
    int dateOfJoin;
    DynamicEmpDetails dynamicEmpDetails;
    //LeaveDates leavedates;
}
