<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Search-Result</h3>
	<hr>
		<pre>
		PCode		${product.pcode}
		PName		${product.pname}
		Price		${product.price}
		Picture		<img src="loadimage?code=${product.pcode}"/>
		</pre>
	<hr>
	<a href="searchform">Search-More</a><br>
	<a href="index.jsp">Home</a>
</body>
</html>