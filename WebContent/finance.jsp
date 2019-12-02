<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="web_application.data_layer.StoreInventory" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"> </script>
<script type="text/javascript"><%@include file="js/jquery.min.js"%></script>
<script type="text/javascript"><%@include file="js/bootstrap.js"%></script>
<script type="text/javascript"> 
$('#myModal').on('shown.bs.modal', function () {
  $('#myInput').trigger('focus')
})</script> 
<style><%@include file="css/bootstrap.min.css"%></style>
<title>Stock List</title>
<meta charset="UTF-8">
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #e3f2fd;">
  <a class="navbar-brand" href="/software_architecture_cw/store">DE-Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link" href="/software_architecture_cw/store/products">Pricing</a>
      <a class="nav-item nav-link" href="/software_architecture_cw/store/stock">Stock</a>
      <a class="nav-item nav-link" href="/software_architecture_cw/store/loyalty">Loyalty</a>
      <a class="nav-item nav-link" href="/software_architecture_cw/store/report">Analytics</a>
      <a class="nav-item nav-link" href="/software_architecture_cw/store/finance">Finance Approval</a>
      <a class="nav-item nav-link" href="/software_architecture_cw/logout">Log Out</a>
    </div>
  </div>
</nav>
<div class="container">
<table class="table table-striped">
		<caption>Enabling requests</caption>
		<thead>
			<th>Request Details</th>
			<th></th>
		</thead>
<tbody>
 <!-- <h2> Product Pricing </h2> -->
 <c:forEach items="${names}" var="item">
<tr>
		<td>${item}</td>
	<td><button onclick="$('#myModal').modal('show');" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong" >
	  Approve Request
	</button>
	<!-- modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Send Request to Enabling?</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Send finance request information to Enabling using an API.
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" data-dismiss="modal">Approve</button>
	      </div>
	    </div>
	  </div>
	</div>
</td>
	</tr>
	
 </c:forEach>
 
 </tbody>
 </table>
 
 </div>