package LmsSystem;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.HashMap;

@AllArgsConstructor
public class LeaveManagement {

    HashMap<Integer,PrivateLeaveDates> empLeaveMapping;
    boolean addPrivateLeave(int empId, Date LeaveDate){
        empLeaveMapping.get(empId).privateDateList.add(LeaveDate);
        return true;
    }
    //boolean removeLeave();
    //boolean addPublicLeaves();


}
