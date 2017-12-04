<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="MyApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script>
<script type="text/javascript" src="script/controller.js"></script>
<script type="text/javascript" src="script/datevalidation.js"></script>
<script type="text/javascript" src="script/checkdate.js"></script>
<script type="text/javascript" src="script/checkpan.js"></script>
<script type="text/javascript" src="script/checkname.js"></script>
<script type="text/javascript" src="script/checkmn.js"></script>
<script type="text/javascript" src="script/checkln.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var form = $("#myform");
		var name=$('#name').val();
		var richard=$('#richard');
		form.submit(function(event) {
			$.ajax({
				type : form.attr('method'),
				url : 'http://localhost:8080/Registration/rstr/'+name,
				data: name,
				success :function(data) {
			        console.log('Success');
			        document.getElementById("richard").innerHTML=data
			    },
			    error: function(data) {
			        console.log("Error");
			        console.log("You have an Error"+data);
			    }
			});
			event.preventDefault();
		});
	});
</script>
</head>
<body ng-controller="MyController">
<!-- Page Header -->
<div class="container" style="box-shadow:0 0 2px black">
	<div class="page-header">
 
   		<div class = "col-sm-6 col-md-3">
      		<a href = "#" class = "thumbnail">
         	<img src = "images/fotolia_2577979_XS.jpg" style="height:10em" alt = "Generic placeholder thumbnail">
      		</a>
   		</div>
   
		<div name="pageheader" class=" panel-default bg-primary vcenter" style="height:10em" >
			<h1><strong>Registration Form</strong></h1>
		</div>
	</div>
</div>
<!-- End of Page Header -->
<br>
<!-- Panel Body -->
<!-- Panel1 -->
<div class="container" style="box-shadow:0 0 2px black">
	<div class="row">
	<!-- Start of Row1 -->
		<!-- Panel1-LHS -->
		<br>
			<div class="col-md-6">
				<div class="form-group">
  					<label>Registration Number :</label>
	  					<div class="input-group">
							<input type="text" class="form-control" disabled>
							<span class="input-group-btn">
							<button class="btn btn-default" type="button" ng-click="genID()">
							Generate
							</button>
							</span>
					</div>
  					<label>First Name :</label>
	  				<input type="text" class="form-control" name="fname" id="fn" maxlength="10" onblur="checkfn()" required>
  					<label>Middle Name :</label>
	  				<input type="text" class="form-control" name="mname" id="mn" maxlength="10" onblur="checkmn()" required>
	  				<label>Unique ID :</label>
	  				<input type="text" class="form-control" name="uniqueid" id="unique"  maxlength="10">
  					<label>Gender :</label>
	  				<div class="container">
  						<div class="btn-group">
  							<label class="radio-inline">
	          				<input name="radioGroup" name="male" value="m" type="radio"> Male
        					</label>
        					<label class="radio-inline">
	          				<input name="radioGroup" name="female" value="f" checked="checked" type="radio"> Female
        					</label>
            			</div>
         			</div>
         		</div>
         	</div>
         <!-- End of Panel1-LHS -->
  		 <!-- Panel1-RHS -->
  		 	<div class="col-md-6">
  		 		<div class="form-group">
					 <label >Last Name :</label>
	  					<input type="text" class="form-control" name="lname" id="ln" maxlength="10" onblur="checkln()" required>
  					<label >Date of Birth :</label>
	  					<input id="dob" type="text" class="form-control" name="dob" onkeyup="checkDate()"><div id="datewarn"></div> 
  					<label >Pan Number :</label>
	  					<input type="text" class="form-control" name="pan" id="pan" onkeyup="checkpan()"><div id="panwarn" required></div>
  		 			<label >Marital Status :</label>
	  					 <div class="form-group">
  								<select class="form-control" id="sel1">
    								<option>Single</option>
    								<option>Married</option>
    								<option>Seperated</option>
    								<option>Widowed</option>
  								</select>
						</div>
  		 			
  		 		</div>
  		 	</div>
  		 <!-- End of Panel1-RHS -->
	</div>			
	<!-- End of Panel1 -->
	<!-- End of Row1 -->
		<!-- Start of Row2 -->
			<!-- Start of Panel2 -->
				<!-- start of row1 -->
					<div class="row">
						<div class="col-md-2">
							<label>Communication Address</label>
						</div>	
						<div class="col-md-10">
					 	<textarea class="form-control"  maxlength="50" ng-model="currentaddress"></textarea>
						</div>
					</div>
					<br>
					<br>
				<!-- End of row1 -->
				<!-- start of row2 -->
				<div class="row">
					<div class="col-md-2"></div>
					<input type="checkbox" class="checkbox col-md-1" ng-model="account.sameAsAbove">
					<label class="col-md-9">Same As Permanent Address</label>
				</div>
				<!-- end of row2 	 -->
				<br>
				<br>
				<!-- start of row3 -->
					<div class="row">
						<div class="col-md-2">
							<label>Permanent Address</label>
						</div>	
						<div class="col-md-10">
					 		<textarea class="form-control"  maxlength="50" ng-disabled="account.sameAsAbove"=></textarea>
						</div>
					</div><br>
				<!-- end of row3 -->
			<!-- End of Panel2 -->
		<!-- End of Row2 -->
</div>
<!-- End of Panel1 -->
<!-- End of Row -->
<!-- End of Panel Body -->
<br>
<br>
<div class="container" style="box-shadow:0 0 2px black">
<br>
<div align="right">

	<div id="head" class="well col-lg-12">
			<fieldset>
				<span class="pull-left"><legend>Educational Details</legend></span>
					<div class="col-sm-12">
						<div class="col-sm-1 form-group pull-left">
							<label>Course</label>
						</div>
						<div class="col-sm-3 form-group">
							<label>University/College</label>
						</div>
						<div class="col-sm-4 form-group">
							<label>Year of pass</label>
						</div>
						<div class="col-sm-2 form-group">
							<label>Percentage</label>
						</div>
						<button type="button" ng-click="add()" class="btn btn-info col-sm-1">
							<span class="glyphicon glyphicon-plus"></span> Add
						</button>
					</div>
					<div class="col-sm-12" ng-repeat="item in items">
						<div class="col-sm-2 form-group">
							<input type="text" class="form-control">
						</div>
						<div class="col-sm-4 form-group">
							<input type="text" class="form-control">
						</div>
						<div class="col-sm-3 form-group">
							<input type="text" class="form-control">
						</div>
						<div class="col-sm-1 form-group">
							<input type="text" class="form-control">
						</div>
						<div class="col-sm-1 form-group">
						</div>
				<div class="col-sm-1 form-group">
					<button type="button"ng-click="remove($index)" class="btn btn-info">
				<span class="glyphicon glyphicon-trash"></span>
			</button>
		</div>
	</div>				
</fieldset>
</div>
</div>
<br>
<input type="submit" value="Submit" name="submit" class="btn btn-lg btn-primary center-block"/>

<br>
</body>
</html>