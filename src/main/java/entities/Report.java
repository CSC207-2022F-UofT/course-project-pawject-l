package entities;

import java.lang.reflect.Type;
import java.util.Objects;

public class Report {

    private String type;
    private User user;
    public Report(User a, String b){
        this.type = b;
        this.user = a;
    }

    private void punish(){return;}

    private void check_counts() {
        if (user.getReport_count(type) == 3){
            punish();
        };
        return;
        }
    public void report (){
            if (Objects.equals(type, "Type_A")) {
                user.setReport_count(type);
                check_counts();
            }
            return;
    }
};