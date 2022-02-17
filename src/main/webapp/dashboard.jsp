<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Pick & Go - Dashboard</title>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <!-- <script src="vendor/datatables/jquery.dataTables.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.js"></script> -->

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin.min.js"></script>
  <script src="js/jquery-3.3.1.js"></script>
  <script src="js/jquery.dataTables.min.js"></script>

  <!-- Demo scripts for this page-->
  <script src="js/demo/datatables-demo.js"></script>

  <!-- Custom fonts for this template-->
  <link href="<c:url value="../vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
 <%--  <link href="<c:url value="../vendor/datatables/dataTables.bootstrap4.css"/>" rel="stylesheet"> --%>
 <link href="<c:url value="../css/jquery.dataTables.min.css"/>" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<c:url value="../css/sb-admin.css"/>" rel="stylesheet">
  
  <!-- Custom fonts for this template-->
  <link href="<c:url value="vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <%-- <link href="<c:url value="vendor/datatables/dataTables.bootstrap4.css"/>" rel="stylesheet"> --%>
	<link href="<c:url value="css/jquery.dataTables.min.css"/>" rel="stylesheet">
	
  <!-- Custom styles for this template-->
  <link href="<c:url value="css/sb-admin.css"/>" rel="stylesheet">
  <script src="js/axios.min.js"></script>
	<script src="js/r.js"></script>
	
	<script type="text/javascript">
	function getUserInfo() {
		axios.get('/pickngo-mgt/user/username/'+sessionStorage.getItem(`userName`)+'.do')
   		  .then(function (response) {
   		  		//var responseData = response['data']['collectionCenterData'];
   		  		sessionStorage.setItem('display_name', response.data['userName']);
   		    	sessionStorage.setItem('designation', response.data['designation']);
                sessionStorage.setItem('userId', response.data['userId']);
   		  })
   		  .catch(function (error) {
   		    //alert(error);
   		  })
   		  .then(function () {
   		    	treeNode();
   		    	document.getElementById("welcomeNote").innerHTML = "Hi "+  sessionStorage.getItem('display_name');
   		  });
	}

	function treeNode(){
		if (sessionStorage.getItem(`designation`)=="Administrator") {
			document.getElementById("dashboard").style.display = "";
			
			document.getElementById("masterData").style.display = "";
			document.getElementById("collectionCenter").style.display = "";
			document.getElementById("buyingSellingPrice").style.display = "";
			document.getElementById("cashInHand").style.display = "";
			document.getElementById("vehicle").style.display = "";
			document.getElementById("stores").style.display = "";
			document.getElementById("item").style.display = "";
			
			document.getElementById("entities").style.display = "";
			document.getElementById("farmer").style.display = "";
			document.getElementById("customer").style.display = "";
			
			document.getElementById("transaction").style.display = "";
			document.getElementById("itemPurchase").style.display = "";
			document.getElementById("paymentToFarmer").style.display = "";
			document.getElementById("itemSelling").style.display = "";
			document.getElementById("collection").style.display = "";
			document.getElementById("itemLocationTransfer").style.display = "";
			document.getElementById("itemIssue").style.display = "";
			document.getElementById("transaction").style.display = "";
			document.getElementById("cashTransfer").style.display = "";
			document.getElementById("paddyForecasting").style.display = "";
			
			document.getElementById("inquiry").style.display = "";
			document.getElementById("seasonForecasting").style.display = "";
			
			document.getElementById("reports").style.display = "";
			document.getElementById("administration").style.display = "";
		} else if (sessionStorage.getItem(`designation`)=="Manager") {
			document.getElementById("dashboard").style.display = "";
			
			document.getElementById("masterData").style.display = "none";
			document.getElementById("collectionCenter").style.display = "none";
			document.getElementById("buyingSellingPrice").style.display = "none";
			document.getElementById("cashInHand").style.display = "none";
			document.getElementById("vehicle").style.display = "none";
			document.getElementById("stores").style.display = "none";
			document.getElementById("item").style.display = "none";
			
			document.getElementById("entities").style.display = "none";
			document.getElementById("farmer").style.display = "none";
			document.getElementById("customer").style.display = "none";
			
			document.getElementById("transaction").style.display = "";
			document.getElementById("itemPurchase").style.display = "none";
			document.getElementById("paymentToFarmer").style.display = "none";
			document.getElementById("itemSelling").style.display = "none";
			document.getElementById("collection").style.display = "none";
			document.getElementById("itemLocationTransfer").style.display = "none";
			document.getElementById("itemIssue").style.display = "none";
			document.getElementById("transaction").style.display = "none";
			document.getElementById("cashTransfer").style.display = "none";
			document.getElementById("paddyForecasting").style.display = "";
			
			document.getElementById("inquiry").style.display = "";
			document.getElementById("seasonForecasting").style.display = "";
			
			document.getElementById("reports").style.display = "";
			document.getElementById("administration").style.display = "";
		} else if (sessionStorage.getItem(`designation`)=="Finance Office") {
			document.getElementById("dashboard").style.display = "";
			
			document.getElementById("masterData").style.display = "none";
			document.getElementById("collectionCenter").style.display = "none";
			document.getElementById("buyingSellingPrice").style.display = "none";
			document.getElementById("cashInHand").style.display = "none";
			document.getElementById("vehicle").style.display = "none";
			document.getElementById("stores").style.display = "none";
			document.getElementById("item").style.display = "none";
			
			document.getElementById("entities").style.display = "none";
			document.getElementById("farmer").style.display = "none";
			document.getElementById("customer").style.display = "none";
			
			document.getElementById("transaction").style.display = "";
			document.getElementById("itemPurchase").style.display = "none";
			document.getElementById("paymentToFarmer").style.display = "";
			document.getElementById("itemSelling").style.display = "none";
			document.getElementById("collection").style.display = "";
			document.getElementById("itemLocationTransfer").style.display = "none";
			document.getElementById("itemIssue").style.display = "none";
			document.getElementById("transaction").style.display = "";
			document.getElementById("cashTransfer").style.display = "";
			document.getElementById("paddyForecasting").style.display = "none";
			
			document.getElementById("inquiry").style.display = "none";
			document.getElementById("seasonForecasting").style.display = "none";
			
			document.getElementById("reports").style.display = "none";
			document.getElementById("administration").style.display = "none";
		} else if (sessionStorage.getItem(`designation`)=="Collection Officer") {
			document.getElementById("dashboard").style.display = "";
			
			document.getElementById("masterData").style.display = "none";
			document.getElementById("collectionCenter").style.display = "none";
			document.getElementById("buyingSellingPrice").style.display = "none";
			document.getElementById("cashInHand").style.display = "none";
			document.getElementById("vehicle").style.display = "none";
			document.getElementById("stores").style.display = "none";
			document.getElementById("item").style.display = "none";
			
			document.getElementById("entities").style.display = "none";
			document.getElementById("farmer").style.display = "none";
			document.getElementById("customer").style.display = "none";
			
			document.getElementById("transaction").style.display = "";
			document.getElementById("itemPurchase").style.display = "";
			document.getElementById("paymentToFarmer").style.display = "none";
			document.getElementById("itemSelling").style.display = "none";
			document.getElementById("collection").style.display = "none";
			document.getElementById("itemLocationTransfer").style.display = "none";
			document.getElementById("itemIssue").style.display = "none";
			document.getElementById("transaction").style.display = "none";
			document.getElementById("cashTransfer").style.display = "none";
			document.getElementById("paddyForecasting").style.display = "none";
			
			document.getElementById("inquiry").style.display = "none";
			document.getElementById("seasonForecasting").style.display = "none";
			
			document.getElementById("reports").style.display = "none";
			document.getElementById("administration").style.display = "none";
		} else if (sessionStorage.getItem(`designation`)=="Clerk") {
			document.getElementById("dashboard").style.display = "";
			
			document.getElementById("masterData").style.display = "";
			document.getElementById("collectionCenter").style.display = "";
			document.getElementById("buyingSellingPrice").style.display = "";
			document.getElementById("cashInHand").style.display = "";
			document.getElementById("vehicle").style.display = "";
			document.getElementById("stores").style.display = "";
			document.getElementById("item").style.display = "";
			
			document.getElementById("entities").style.display = "";
			document.getElementById("farmer").style.display = "";
			document.getElementById("customer").style.display = "";
			
			document.getElementById("transaction").style.display = "";
			document.getElementById("itemPurchase").style.display = "";
			document.getElementById("paymentToFarmer").style.display = "none";
			document.getElementById("itemSelling").style.display = "none";
			document.getElementById("collection").style.display = "none";
			document.getElementById("itemLocationTransfer").style.display = "none";
			document.getElementById("itemIssue").style.display = "none";
			document.getElementById("transaction").style.display = "none";
			document.getElementById("cashTransfer").style.display = "none";
			document.getElementById("paddyForecasting").style.display = "none";
			
			document.getElementById("inquiry").style.display = "none";
			document.getElementById("seasonForecasting").style.display = "none";
			
			document.getElementById("reports").style.display = "none";
			document.getElementById("administration").style.display = "none";
		} else if (sessionStorage.getItem(`designation`)=="Store keeper") {
			document.getElementById("dashboard").style.display = "";
			
			document.getElementById("masterData").style.display = "none";
			document.getElementById("collectionCenter").style.display = "none";
			document.getElementById("buyingSellingPrice").style.display = "none";
			document.getElementById("cashInHand").style.display = "none";
			document.getElementById("vehicle").style.display = "none";
			document.getElementById("stores").style.display = "none";
			document.getElementById("item").style.display = "none";
			
			document.getElementById("entities").style.display = "none";
			document.getElementById("farmer").style.display = "none";
			document.getElementById("customer").style.display = "none";
			
			document.getElementById("transaction").style.display = "";
			document.getElementById("itemPurchase").style.display = "none";
			document.getElementById("paymentToFarmer").style.display = "none";
			document.getElementById("itemSelling").style.display = "none";
			document.getElementById("collection").style.display = "none";
			document.getElementById("itemLocationTransfer").style.display = "";
			document.getElementById("itemIssue").style.display = "";
			document.getElementById("transaction").style.display = "none";
			document.getElementById("cashTransfer").style.display = "none";
			document.getElementById("paddyForecasting").style.display = "none";
			
			document.getElementById("inquiry").style.display = "none";
			document.getElementById("seasonForecasting").style.display = "none";
			
			document.getElementById("reports").style.display = "none";
			document.getElementById("administration").style.display = "none";
		} else {
			window.location.href="http://localhost:8081/pickngo-mgt/errorLogin.jsp";
		}
	}
	
	</script>
</head>

<body id="page-top" onload="getUserInfo();">

  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="index.html">Pick & Go Delivery Management System</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
      <i class="fas fa-bars"></i>
    </button>


    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">
      <li class="nav-item dropdown no-arrow">
        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-user-circle fa-fw"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          <a class="dropdown-item" href="#">Profile</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
        </div>
      </li>
    </ul>

  </nav>

  <div id="wrapper">

    <!-- Sidebar -->
    
    <ul class="sidebar navbar-nav">
      <li class="nav-item" id="dashboard">
        <a class="nav-link" href="dashboard.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span>
        </a>
      </li>
      <li class="nav-item dropdown" id="masterData">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Master Data</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Master Data</h6>
          <a class="dropdown-item" href="collectionCenter.jsp" id=collectionCenter>Collection Center</a>
          <a class="dropdown-item" href="buyingSellingPrice.jsp" id="buyingSellingPrice">Buying/Selling Price</a>
          <a class="dropdown-item" href="cashInHand.jsp" id="cashInHand">Cash In Hand</a>
          <a class="dropdown-item" href="vehicle.jsp" id="vehicle">Vehicle</a>
          <a class="dropdown-item" href="stores.jsp" id="stores">Stores</a>
          <a class="dropdown-item" href="item.jsp" id="item">Item</a>
        </div>
      </li>
      <li class="nav-item dropdown" id="entities">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Entities</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Entities</h6>
          <a class="dropdown-item" href="farmer.jsp" id="farmer">Farmer Registration</a>
          <a class="dropdown-item" href="customer.jsp" id="customer">Customer Registration</a>
        </div>
      </li>
      <li class="nav-item dropdown" id="transaction">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Transaction</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Transaction</h6>
          <a class="dropdown-item" href="itemPurchase.jsp" id="itemPurchase">Item Purchase</a>
          <a class="dropdown-item" href="paymentToFarmer.jsp" id="paymentToFarmer">Payment To Farmer</a>
          <a class="dropdown-item" href="itemSelling.jsp" id="itemSelling">Item Selling</a>
          <a class="dropdown-item" href="collection.jsp" id="collection">Collection</a>
          <a class="dropdown-item" href="itemLocationTransfer.jsp" id="itemLocationTransfer">Item Location Transfer</a>
          <a class="dropdown-item" href="itemIssue.jsp" id="itemIssue">Item issue</a>
          <a class="dropdown-item" href="transaction.jsp" id="transaction">Transaction</a>
          <a class="dropdown-item" href="cashTransfer.jsp" id="cashTransfer">Cash Transfer</a>
          <a class="dropdown-item" href="paddyForecasting.jsp" id="paddyForecasting">Paddy Forecasting</a>
        </div>
      </li>
      <li class="nav-item dropdown" id="inquiry">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Inquiry</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Inquiry</h6>
          <a class="dropdown-item" href="seasonForecasting.jsp" id="seasonForecasting">Season Forecasting</a>
        </div>
      </li>
      <li class="nav-item" id="reports">
        <a class="nav-link" href="reports.jsp">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Reports</span></a>
      </li>
      <li class="nav-item dropdown" id="administration">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Administration</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Administration</h6>
          <a class="dropdown-item" href="user.jsp" id="userMgt">User Management</a>
          <a class="dropdown-item" href="userRoles.jsp" id="userRoleMgt">User Role Management</a>
        </div>
      </li>
    </ul>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="dashboard.jsp">Dashboard</a>
          </li>
          <!-- <li class="breadcrumb-item active">Home</li> -->
        </ol>

        <!-- Page Content -->
        <h1 id="welcomeNote"></h1>
        <hr><br>
        <div class="row">
              <div class="col-xl-3 col-md-6">
                  <div class="card bg-primary text-white mb-4">
                      <div class="card-body">Purchase Details</div>
                      <div class="card-footer d-flex align-items-center justify-content-between">
                          <a class="small text-white stretched-link" href="#">View Details</a>
                          <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                      </div>
                  </div>
              </div>
              <div class="col-xl-3 col-md-6">
                  <div class="card bg-warning text-white mb-4">
                      <div class="card-body">Issue Details</div>
                      <div class="card-footer d-flex align-items-center justify-content-between">
                          <a class="small text-white stretched-link" href="#">View Details</a>
                          <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                      </div>
                  </div>
              </div>
              <div class="col-xl-3 col-md-6">
                  <div class="card bg-success text-white mb-4">
                      <div class="card-body">Stock Details</div>
                      <div class="card-footer d-flex align-items-center justify-content-between">
                          <a class="small text-white stretched-link" href="#">View Details</a>
                          <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                      </div>
                  </div>
              </div>
              <div class="col-xl-3 col-md-6">
                  <div class="card bg-danger text-white mb-4">
                      <div class="card-body">Sales Details</div>
                      <div class="card-footer d-flex align-items-center justify-content-between">
                          <a class="small text-white stretched-link" href="#">View Details</a>
                          <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                      </div>
                  </div>
              </div>

      </div>
	     <div class="row">          	
             <div class="col-md-12">
             	 
             </div>
	             
	     </div>
        </div>
      <!-- /.container-fluid -->

      <!-- Sticky Footer -->
      <footer class="sticky-footer">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright © Paddy Storage Cooperation (PSC)  2021</span>
          </div>
        </div>
      </footer>

    </div>
    <!-- /.content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.jsp">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../js/sb-admin.min.js"></script>


	<!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin.min.js"></script>
</body>

</html>
