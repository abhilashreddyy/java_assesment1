package LeaveManagementSystemTest;

import LmsSystem.DynamicEmpDetails;
import LmsSystem.EmpDetails;
import LmsSystem.EmpRole;
import LmsSystem.EmpType;
import org.junit.Test;

public class UserBasedTests {

    public void createUser() throws Exception {
        DynamicEmpDetails dynamicEmpDetails = new DynamicEmpDetails(EmpType.PERMANENT, EmpRole.NONADMIN, "abhilashreddyy1@gmail.com");
        EmpDetails empDetail = new EmpDetails("abhi", 1, "11/7/2014", dynamicEmpDetails);

    }

    @Test
    public void EmailAssertion(){
        try{
            createUser();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
