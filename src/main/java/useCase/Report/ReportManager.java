package useCase.Report;

import entities.Report;
import repo.ChatDataAccessInterface;
import repo.PetDataAccessInterface;
import repo.UserDataAccessInterface;

import java.io.IOException;

public class ReportManager implements ReportInputBoundary{
    static PetDataAccessInterface PDAI;
    static ChatDataAccessInterface CDAI;
    static UserDataAccessInterface UDAI;
    public void TypeAReport(String userID) throws IOException {
        Report r = new Report(userID, "TypeA", UDAI);
        r.report();
    }
    public void TypeBReport(String petID) throws IOException {
        Report r = new Report(petID, "TypeB", PDAI, UDAI);
        r.report();
    }
    public void TypeCReport(String petID, String chatId) throws IOException {
        Report r = new Report(petID, chatId,"TypeC", PDAI,CDAI);
        r.report();
    }
}