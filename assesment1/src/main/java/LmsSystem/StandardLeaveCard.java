package LmsSystem;

import java.util.HashMap;
import java.util.Map;

public class StandardLeaveCard {
    public Map<String,Integer> card;

        StandardLeaveCard(){
            this.card = new HashMap<String,Integer>(){{
                put("SICK_LEAVE", 5);
                put("CASUAL_LEAVE", 5);
                put("PRIVILAGED_LEAVE", 15);
            }};
        }
}
