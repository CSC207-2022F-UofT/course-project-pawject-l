package controller;

import useCase.Report.ReportInputBoundary;
import useCase.Report.ReportManager;

import java.io.IOException;

public class ReportController {
    static ReportInputBoundary reportInput;
    public void performReportA(String userID) throws IOException {
        reportInput.TypeAReport(userID);
    };
    public void performReportB(String petID) throws IOException {
        reportInput.TypeBReport(petID);
    };
    public void performReportC(String petID, String chatID) throws IOException {
        reportInput.TypeCReport(petID, chatID);
    };

}
