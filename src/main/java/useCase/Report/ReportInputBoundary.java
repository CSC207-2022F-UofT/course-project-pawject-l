package useCase.Report;

import entities.Report;

import java.io.IOException;

public interface ReportInputBoundary {
    public void TypeAReport(String userID) throws IOException;
    public void TypeBReport(String petID) throws IOException;
    public void TypeCReport(String petID, String chatId) throws IOException;
}
