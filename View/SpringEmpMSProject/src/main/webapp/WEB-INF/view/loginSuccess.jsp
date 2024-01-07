<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>사내 인트라넷 시스템</title>
</head>
<script>
	top.location.href = 'top.khs';
	parent.center.location.href = 'main.khs';
</script>
<body bgcolor='white'>
<center><br/><br/>


<%=session.getAttribute("login") %>님 좋은 하루 되세요~~<br/>
<br/><br/><br/>
Copyright 2011 All rights reserved. <br/>
</center>
</body>
</html>
