package entities;

import java.lang.reflect.Type;

public class Report {
    public void check_counts(User a, Report b) {
        if (b instanceof Type_A_Report){

        }
        return;
    }
};

class Type_A_Report {
    private int report_count;

    private void punish(User a){return;}

    public void check_counts(User a, Report b) {
        if (report_count == 3) {
            punish(a);
        }
        return;
    }

    public void type_A() {return;}

}
