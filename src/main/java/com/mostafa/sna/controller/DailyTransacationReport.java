package com.mostafa.sna.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mostafa.sna.model.TransactionHistory;
import com.mostafa.sna.util.ReportAPI;
import com.mostafa.sna.util.DateFormater;

@Controller
public class DailyTransacationReport {
	
	DateFormater dateFormater = new DateFormater();
	
	@GetMapping("transactionHistoryForm")
	public String showReportPage(Model model) {
		TransactionHistory transaction = new TransactionHistory();
		transaction.setWalletid("ALL");
		transaction.setTransactionType("RCV");
		transaction.setFromDate(dateFormater.dateToStringConverter(new Date(), "yyyy-MM-dd"));
		transaction.setToDate(dateFormater.dateToStringConverter(new Date(), "yyyy-MM-dd"));
		model.addAttribute("transaction", transaction);
		return "transaction-history-report-page";
	}
	
	@PostMapping("transactionHistoryReport")
	public String processReport(@ModelAttribute("transaction") TransactionHistory transaction, Model model, RedirectAttributes redirectAttributes) {
		
		ReportAPI api = new ReportAPI();
		
		TransactionHistory transaction2 = new TransactionHistory();
		
		List<TransactionHistory> transactionList = new ArrayList<TransactionHistory>();
		
		String url = "http://www.url.com/getDailyTransactionHistoryReportDetails";
		
		String message="";
		
		String apiPass = "trandailyhistorydetails";
		String walletid = transaction.getWalletid();
		String transactionType = transaction.getTransactionType();
		String fromDate = transaction.getFromDate();
		String toDate = transaction.getToDate();
		
		transaction2.setApi_pass(apiPass);
		transaction2.setWalletid(walletid);
		transaction2.setTransactionType(transactionType);
		transaction2.setFromDate(fromDate);
		transaction2.setToDate(toDate);
		
		String response = api.getDailyTransactionHistory(transaction2, url);

        System.out.println("Response: "+response);
		
		JSONArray jsonArray = new JSONArray(response);
        for(int i =0; i< jsonArray.length(); i++){
            if(jsonArray.get(i) instanceof JSONObject){
            	
                JSONObject jsnObj = (JSONObject)jsonArray.get(i);
                
                if(((String)jsnObj.getString("errorcode")).equals("1")) {
                	message = (String) jsnObj.getString("errormessage");
                	System.out.println(message);
                }else {
                	String data = (String) jsnObj.getString("data");
                	
                	JSONArray jsonArray2 = new JSONArray(data);
                	
                	for(int j =0; j< jsonArray2.length(); j++){
                		if(jsonArray2.get(j) instanceof JSONObject){
                			JSONObject jsnObj2 = (JSONObject)jsonArray2.get(j);
                			
                			TransactionHistory transaction3 = new TransactionHistory();
                            
                            transaction3.setWalletid((String)jsnObj2.get("walletid"));
                            transaction3.setDocnum((String)jsnObj2.get("docnum"));
                            transaction3.setTrndat((String)jsnObj2.get("trndat"));
                            transaction3.setDoctype((String)jsnObj2.get("doctyp"));
                            transaction3.setTrnamt((double)jsnObj2.get("trnamt"));
                            transaction3.setNarration((String)jsnObj2.get("narration"));
                            
                            transaction3.setTransactionType(transactionType);
                            transaction3.setFromDate(fromDate);
                            transaction3.setToDate(toDate);
                            
                            System.out.println("Transaction: "+transaction3);
                            
                            transactionList.add(transaction3);
                			
                		}
                	}
                }
            }
        }
        
        if(message=="") {
        	model.addAttribute("transactionList", transactionList);
    		return "transactionHistoryForstView";
        }else {
        	redirectAttributes.addFlashAttribute("message", message);
        	return "redirect:/transactionHistoryForm";
        }
		
	}
	
}
