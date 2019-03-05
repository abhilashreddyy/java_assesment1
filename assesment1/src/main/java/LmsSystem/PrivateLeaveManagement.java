package LmsSystem;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.HashMap;

@AllArgsConstructor
public class PrivateLeaveManagement {

    HashMap<Integer,Integer> empLeaveMapping;
    public boolean addPrivateLeave(int empId, int LeaveType){
        try {
            int ExistingLeaves = empLeaveMapping.get(empId);
            empLeaveMapping.put(empId,ExistingLeaves+LeaveType);
            return true;
        }
        catch (Exception e){
            //print e
            return false;
        }

    }

    public int getNumLeaves(int empId){
        return empLeaveMapping.get(empId);
    }
    //boolean removeLeave();
    //boolean addPublicLeaves();


}
