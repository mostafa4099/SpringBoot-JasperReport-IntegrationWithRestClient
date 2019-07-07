package com.mostafa.sna.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.mostafa.sna.model.ReportStaticContent;
import com.mostafa.sna.model.TransactionHistory;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component("transactionHistoryForstView")
public class TransactionHistoryReportPDFView extends AbstractView {

	private JasperReport dailyTransactioReport;

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=TransactionHistoryReport.pdf");
		
		List<TransactionHistory> transaction = (List<TransactionHistory>) model.get("transactionList");
		
		ReportStaticContent staticContent = new ReportStaticContent();
		Map<String, Object> map = new HashMap<>();
		map.put("heading", staticContent.getHeading());
		map.put("subHeading", staticContent.getSubHeading());
		map.put("logoPath", staticContent.getLogoPath());
		
		JRDataSource dataSource = getDataSource(transaction);
		JasperReport report = getReport();
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		
		final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}

	private JRDataSource getDataSource(List<TransactionHistory> transactions) {
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(transactions);
		return dataSource;
	}

	public JasperReport getReport() throws JRException {
		if (dailyTransactioReport == null) {
			InputStream stream = this.getClass().getResourceAsStream("/static/report/TransactionReport.jrxml");
			dailyTransactioReport = JasperCompileManager.compileReport(stream);
		}
		return dailyTransactioReport;
	}
	
}
