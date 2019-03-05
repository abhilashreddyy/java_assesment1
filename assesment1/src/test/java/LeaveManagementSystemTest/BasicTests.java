package LeaveManagementSystemTest;

import LmsSystem.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BasicTests {
    List<EmpDetails> empDetails = new ArrayList();
    @Before
    public void CreateEmployees() throws Exception{
        DynamicEmpDetails dynamicEmpDetails = new DynamicEmpDetails(EmpType.PERMANENT, EmpRole.NONADMIN,"abhilashreddyy1@gmail.com");
        EmpDetails empDetail = new EmpDetails("abhi",1, "11/7/2014",dynamicEmpDetails);
        empDetails.add(empDetail);

        dynamicEmpDetails = new DynamicEmpDetails(EmpType.PROBATION, EmpRole.ADMIN,"prateek@gmail.com");
        empDetail = new EmpDetails("prateek",2, "13/2/2016",dynamicEmpDetails);

        empDetails.add(empDetail);

        dynamicEmpDetails = new DynamicEmpDetails(EmpType.PROBATION, EmpRole.NONADMIN,"Shubhampal@gmail.com");
        empDetail = new EmpDetails("shubham",3, "15/1/2019",dynamicEmpDetails);

        empDetails.add(empDetail);


    }

    @Test
    public void verifySettingHolidayTest(){
        AdminManager adminManager = new AdminManager(empDetails);
        PrivateLeaveManagement privateLeaveManagement = adminManager.getPrivateLeaveManagement();
        privateLeaveManagement.addPrivateLeave(1,"CASUAL_LEAVE");

        Assert.assertEquals(10,privateLeaveManagement.getNumLeaves(1));
    }

    @Test
    public void verifyIfSufficientCreditsAvailable(){

        AdminManager adminManager = new AdminManager(empDetails);
        PrivateLeaveManagement privateLeaveManagement = adminManager.getPrivateLeaveManagement();
        Assert.assertEquals(false,privateLeaveManagement.addPrivateLeave(2,"SICK_LEAVE"));

    }

    @Test
    public void verifyIfAuthorisedUserCanTakeLEaves(){

        AdminManager adminManager = new AdminManager(empDetails);
        PrivateLeaveManagement privateLeaveManagement = adminManager.getPrivateLeaveManagement();
        Assert.assertEquals(true,privateLeaveManagement.addPrivateLeave(1,"PRIVILAGED_LEAVE"));

    }

    @Test
    public void assertIfTheUserHadExhaustedCredits1(){
        AdminManager adminManager = new AdminManager(empDetails);
        PrivateLeaveManagement privateLeaveManagement = adminManager.getPrivateLeaveManagement();
        privateLeaveManagement.addPrivateLeave(1,"PRIVILAGED_LEAVE");
        Assert.assertEquals(false,privateLeaveManagement.addPrivateLeave(1,"PRIVILAGED_LEAVE"));
    }

    @Test
    public void assertIfTheUserHadExhaustedCredits2(){
        AdminManager adminManager = new AdminManager(empDetails);
        PrivateLeaveManagement privateLeaveManagement = adminManager.getPrivateLeaveManagement();
        privateLeaveManagement.addPrivateLeave(1,"SICK_LEAVE");
        privateLeaveManagement.addPrivateLeave(1,"SICK_LEAVE");
        privateLeaveManagement.addPrivateLeave(1,"SICK_LEAVE");
        privateLeaveManagement.addPrivateLeave(1,"SICK_LEAVE");
        privateLeaveManagement.addPrivateLeave(1,"SICK_LEAVE");
        Assert.assertEquals(false,privateLeaveManagement.addPrivateLeave(1,"PRIVILAGED_LEAVE"));
    }

    @Test
    public void assertIfTheUserHadExhaustedCredits3(){
        AdminManager adminManager = new AdminManager(empDetails);
        PrivateLeaveManagement privateLeaveManagement = adminManager.getPrivateLeaveManagement();
        privateLeaveManagement.addPrivateLeave(1,"SICK_LEAVE");
        privateLeaveManagement.addPrivateLeave(1,"SICK_LEAVE");
        privateLeaveManagement.addPrivateLeave(1,"SICK_LEAVE");
        privateLeaveManagement.addPrivateLeave(1,"SICK_LEAVE");
        privateLeaveManagement.addPrivateLeave(1,"SICK_LEAVE");
        Assert.assertEquals(false,privateLeaveManagement.addPrivateLeave(1,"SICK_LEAVE"));
    }

    @Test
    public void checkWeatherUserInflormationIsCorrectlyFilled(){
        AdminManager adminManager = new AdminManager(empDetails);
        PrivateLeaveManagement privateLeaveManagement = adminManager.getPrivateLeaveManagement();
        Assert.assertEquals(empDetails.get(0),privateLeaveManagement.getEmpDetailsFromId(1));
    }




}
