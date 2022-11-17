package userCase;
import entities.User;
import entities.Report;
import entities.Pet;
import repo.ChatDataRequestModel;
import repo.PetDataRequestModel;
public class ReportInteractor {
    private PetDataRequestModel pm;
    private ChatDataRequestModel cm;
    public ReportInteractor(PetDataRequestModel pm, ChatDataRequestModel cm){
        this.pm = pm;
        this.cm = cm;
    }
    public void TypeAReport(User a){
        Report r = new Report(a, "TypeA");
        r.report();
    }
    public void TypeBReport(Pet c){
        Report r = new Report(c, "TypeB");
        r.report();
    }
    public void TypeCReport(Pet a, String chatId) {
        Report r = new Report(a, chatId,"TypeA", cm);
        r.report();
    }
}
