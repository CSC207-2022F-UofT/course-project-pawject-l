package userCase;
import entities.User;
import entities.Report;
import entities.Pet;
import repo.ChatDataRequestModel;
import repo.PetDataRequestModel;
import repo.UserDataRequestModel;
public class ReportInteractor {
    private PetDataRequestModel pm;
    private ChatDataRequestModel cm;
    private UserDataRequestModel um;
    public ReportInteractor(PetDataRequestModel pm, ChatDataRequestModel cm, UserDataRequestModel um){
        this.pm = pm;
        this.cm = cm;
        this.um = um;
    }
    public void TypeAReport(String userID){
        Report r = new Report(userID, "TypeA", um);
        r.report();
    }
    public void TypeBReport(String petID){
        Report r = new Report(petID, "TypeB", pm, um);
        r.report();
    }
    public void TypeCReport(String petID, String chatId) {
        Report r = new Report(petID, chatId,"TypeA", pm,cm);
        r.report();
    }
}
