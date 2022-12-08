package useCase.Report;

import entities.Report;

import java.io.IOException;

public interface ReportInputBoundary {
    /**
     * Creates a Type A report.
     *
     * @param userID
     * @throws IOException
     */
    public void TypeAReport(String userID) throws IOException;

    /**
     * Creates a Type B report.
     *
     * @param petID
     * @throws IOException
     */
    public void TypeBReport(String petID) throws IOException;

    /**
     * Creates a Type C report.
     *
     * @param petID
     * @param chatId
     * @throws IOException
     */
    public void TypeCReport(String petID, String chatId) throws IOException;
}
