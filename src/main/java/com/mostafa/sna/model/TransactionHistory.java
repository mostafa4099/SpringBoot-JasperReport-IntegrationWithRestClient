package com.mostafa.sna.model;

public class TransactionHistory {
	
	private String api_pass = "trandailyhistorydetails";
	private String transactionType;
	private String fromDate;
	private String toDate;
	private String walletid;
	private String docnum;
	private String trndat;
	private String doctype;
	private double trnamt;
	private String narration;
	
	public TransactionHistory() {
		
	}

	public TransactionHistory(String api_pass, String transactionType, String fromDate, String toDate, String walletid,
			String docnum, String trndat, String doctype, double trnamt, String narration) {
		super();
		this.api_pass = api_pass;
		this.transactionType = transactionType;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.walletid = walletid;
		this.docnum = docnum;
		this.trndat = trndat;
		this.doctype = doctype;
		this.trnamt = trnamt;
		this.narration = narration;
	}
	
	public String getApi_pass() {
		return api_pass;
	}

	public void setApi_pass(String api_pass) {
		this.api_pass = api_pass;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getWalletid() {
		return walletid;
	}

	public void setWalletid(String walletid) {
		this.walletid = walletid;
	}

	public String getDocnum() {
		return docnum;
	}

	public void setDocnum(String docnum) {
		this.docnum = docnum;
	}

	public String getTrndat() {
		return trndat;
	}

	public void setTrndat(String trndat) {
		this.trndat = trndat;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public double getTrnamt() {
		return trnamt;
	}

	public void setTrnamt(double trnamt) {
		this.trnamt = trnamt;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
}
