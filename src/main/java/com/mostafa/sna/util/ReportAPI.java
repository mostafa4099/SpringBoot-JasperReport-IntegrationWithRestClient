package com.mostafa.sna.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.mostafa.sna.model.TransactionHistory;

public class ReportAPI {
	
	RestTemplate restTemplate = new RestTemplate();
	
    public String getDailyTransactionHistory(TransactionHistory transaction, String url){
    	
    	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        
        map.add("api_pass", transaction.getApi_pass());
        map.add("walletid", transaction.getWalletid());
        map.add("transactionType", transaction.getTransactionType());
        map.add("fromDate", transaction.getFromDate());
        map.add("toDate", transaction.getToDate());
        
        final HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map ,
                headers);
        
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String response = responseEntity.getBody();
        
        return response;
    }
	
}
