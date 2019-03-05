package LmsSystem;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public class PrivateLeaveManagement {

    HashMap<Integer,Integer> empLeaveMapping;
    List<EmpDetails> empDetails ;
    public boolean addPrivateLeave(int empId, String leaveType){
        EmpDetails empDetails = getEmpDetailsFromId(empId);

        StandardLeaveCard myCard = new StandardLeaveCard();


        int leaveNumber = myCard.card.get(leaveType);

        if(empDetails.leaveCredits == 0 || leaveNumber > empDetails.getLeaveCredits()){
            return false;
        }

        try {
            int ExistingLeaves = empLeaveMapping.get(empId);
            empLeaveMapping.put(empId,ExistingLeaves+leaveNumber);
            empDetails.leaveCredits -= leaveNumber;
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    public EmpDetails getEmpDetailsFromId(int empId){

        for(EmpDetails emp : empDetails){
            if(emp.getEmpId() == empId){
                return emp;
            }
        }
        return null;
    }

    public int getNumLeaves(int empId){
        return empLeaveMapping.get(empId);
    }
    //boolean removeLeave();
    //boolean addPublicLeaves();


}
