<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Pick & Go - Login</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

<!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  <script src="js/axios.min.js"></script>
	<script src="js/r.js"></script>
	
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">

	<script type="text/javascript">
		//console.log(sessionStorage.getItem('designation'));
		function login(){
			//const axios = require('axios');
			var userName = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var status = false;
			if(userName==null || userName=='') {
				document.getElementById("msgUsername").innerHTML = "username is required";
				status = true;
			}
		
			var regularExpression = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
			if(password==null || password=='') {
				document.getElementById("msgPassword").innerHTML = "password is required";
				status = true;
			} else if (password.length<8) {
				document.getElementById("msgPassword").innerHTML = "pasword must be atleast 8 characters long";
				status = true;
			}
			
			if (status) {
				return false;
			}
			console.log(userName)
			sessionStorage.setItem('userName', userName);
			axios.get('/pickngo-mgt/login.do', {
	   		    params: {
	   		    	username: userName,
	   		    	password: password
	   		    }
	   		  })
	   		  .then(function (response) {
	   		    console.log(response);
	   		    if (response.data['userId']!='' && response.data['userId']!='null') {
	   		    	//sessionStorage.setItem('display_name', response.data['userName']);
	   		    	//sessionStorage.setItem('designation', response.data['designation']);
	                //sessionStorage.setItem('userId', response.data['userId']);
	                
	   		    	window.location.href="http://localhost:8081/pickngo-mgt/dashboard.jsp";
				} else {
					window.location.href="http://localhost:8081/pickngo-mgt/errorLogin.jsp";
				}
	   		  })
	   		  .catch(function (error) {
	   		    alert(error);
	   		  })
	   		  .then(function () {
	   		    // always executed
	   		  });
			
			/* axios.post('/pickngo-mgt/loginPath/login.do', {
				username: userName,
			    password: password
			  })
			  .then(function (response) {
			    console.log(response);
			  })
			  .catch(function (error) {
			    console.log(error);
			  }); */
		}
		
		function clearDiv() {
			document.getElementById("msgPassword").innerHTML = "";
			document.getElementById("msgUsername").innerHTML = "";
		}
	</script>
</head>

<body class="bg-dark">

  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Pick & Go Delivery Login</div>
      <div class="card-body">
        <form action="/pickngo-mgt/login.do" method="post">
          <div class="form-group">
            <div class="form-label-group">
              <input type="text" id="username" name="username" class="form-control" required="required" autofocus="autofocus" onfocus="clearDiv();">
              <label for="inputEmail">Username</label>
              <span id="msgUsername" style="color:red"></span>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <input type="password" id="password" name="password" class="form-control" required="required" onfocus="clearDiv();">
              <label for="inputPassword">Password</label>
              <span id="msgPassword" style="color:red"></span>
            </div>
          </div>
          <div class="form-group">
            <div class="checkbox">
              <label>
                <input type="checkbox" value="remember-me">
                Remember Password
              </label>
            </div>
          </div>
          <input type="button" class="btn btn-primary btn-block" onclick="login()" value="Login"/>
        </form>