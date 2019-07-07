<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Daily Transaction Report</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<link href="/css/sidenav.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<div class="header">
			<nav class="navbar navbar-inverse"
				style="background: #337AB7; z-index: 2;">
				<div class="container-fluid">
					<div class="navbar-header" style="background: #337AB7;">
						<p class="navbar-brand" style="color: white;">Daily
							Transaction</p>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" class="btn btn-md" style="color: white;"><span
								class="glyphicon glyphicon-log-out" style="color: white;"></span>
								Log Out</a></li>
					</ul>
				</div>
			</nav>
		</div>
		<div class="content">
			<div class="row">
				<div class="col-sm-12">
					<div class="row">
						<div class="col-sm-3">
							<div class="sidenav">
								<img src="/images/user-group-man.png" alt="Avatar"
									style="border-radius: 50%; size: 100px">
									<a href="#">Personal Info</a>
									<a href="${pageContext.request.contextPath}/transactionHistoryForm">Transaction History</a>
									<a href="${pageContext.request.contextPath}/singUpRequestReportForm">SignUp History</a>
									<a href="${pageContext.request.contextPath}/bankListReportForm">Registered Bank List</a>
									<a href="${pageContext.request.contextPath}/kycApprovedListReportForm">KYC Approved List</a>
									<a href="${pageContext.request.contextPath}/bankAccountListReportForm">Bank Account List</a>
									<a href="#">About</a>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div style="height: 30px;">
									<h4 style="text-align: center; color: red;">${message}</h4>
								</div>
								<div class="panel panel-primary">
									<div class="panel-heading">
										<div class="col text-center">
											<h4 class="">Daily Transaction Report</h4>
										</div>
									</div>
									<div class="panel-body">
										<form:form action="transactionHistoryReport" method="POST"
											modelAttribute="transaction">
											<div class="form-group">
												<label for="walletid" class="lab">Wallet Id:</label>
												<form:input type="text" class="form-control" path="walletid"
													id="walletid" />
											</div>
											<div class="form-group">
												<label for="transactionType" class="lab">Transaction
													Type:</label>
												<form:input type="text" class="form-control"
													path="transactionType" id="transactionType" />
											</div>
											<div class="form-group">
												<label for="fromDate" class="lab">From
													Date:</label>
												<form:input type="date" class="form-control"
													path="fromDate" id="fromDate" />
											</div>
											<div class="form-group">
												<label for="toDate" class="lab">To
													Date:</label>
												<form:input type="date" class="form-control"
													path="toDate" id="toDate" />
											</div>
											<div style="text-align: center;">
												<button type="submit" class="btn btn-primary"
													style="height: 40px; width: 100px;">Submit</button>
												<button type="reset" class="btn btn-primary"
													style="height: 40px; width: 100px;">Reset</button>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer">
				<div class="row">
					<div class="col-sm-12"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>