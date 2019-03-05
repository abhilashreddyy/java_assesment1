package LmsSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DynamicEmpDetails {
    private EmpType empType;
    private EmpRole empRole;
    private String email;

}
