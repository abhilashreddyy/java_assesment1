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



    public AdminManager(List<EmpDetails> empDetails){
        HashMap<Integer,Integer> empEmptyLeaveMapping = new HashMap<Integer, Integer>();
        for(EmpDetails emp : empDetails){
            empEmptyLeaveMapping.put(emp.getEmpId(),0);
        }
        privateLeaveManagement = new PrivateLeaveManagement(empEmptyLeaveMapping,empDetails);
    }



}
