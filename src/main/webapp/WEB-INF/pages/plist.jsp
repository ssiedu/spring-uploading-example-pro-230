<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="jstl"%>

<html>
<body>
	<h3>Product-List</h3>
	<hr>
	<table border="1">
		<tr>
			<th>Code</th><th>Name</th><th>Price</th><th>Image</th>
		<tr>
		<jstl:forEach items="${products}" var="product">
		<tr>
			<td>${product.pcode}</td>
			<td>${product.pname}</td>
			<td>${product.price}</td>
			<td><img width="30" height="30" src="loadimage?code=${product.pcode}"/></td>
		<tr>
		</jstl:forEach>
	</table>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>