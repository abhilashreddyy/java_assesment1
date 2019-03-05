package LmsSystem;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class AdminManager {
    PrivateLeaveManagement privateLeaveManagement;
    //PublicLeaveManagement
    //UserManagement

    List<EmpDetails> empDetails ;

    public AdminManager(List<EmpDetails> empDetails){
        this.empDetails = empDetails;
        HashMap<Integer,Integer> empEmptyLeaveMapping = new HashMap<Integer, Integer>();
        for(EmpDetails emp : empDetails){
            empEmptyLeaveMapping.put(emp.getEmpId(),0);
        }
        privateLeaveManagement = new PrivateLeaveManagement(empEmptyLeaveMapping);
    }

    EmpDetails getEmpDetailsFromId(int empId){

        for(EmpDetails emp : empDetails){
            if(emp.getEmpId() == empId){
                return emp;
            }
        }
        return null;
    }

}
