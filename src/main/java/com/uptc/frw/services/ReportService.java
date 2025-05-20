package com.uptc.frw.services;

import com.uptc.frw.models.Report;
import com.uptc.frw.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public Report updateReport(Long id, Report reportDetails) {
        Report report = getReportById(id);
        report.setTitle(reportDetails.getTitle());
        report.setText(reportDetails.getText());
        report.setReportDate(reportDetails.getReportDate());
        report.setRelatedReport(reportDetails.getRelatedReport());
        return reportRepository.save(report);
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
