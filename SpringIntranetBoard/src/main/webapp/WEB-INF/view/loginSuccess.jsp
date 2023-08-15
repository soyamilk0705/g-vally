<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"  errorPage="index.khs" %>
<html>
<head>
<title>사내 인트라넷 시스템</title>
</head>

<script>
    top.menu.location.href = 'menu.khs';
</script>
<body bgcolor='white'>
<center><br/><br/>


<%=session.getAttribute("login") %>님 좋은 하루 되세요~~<br/>
<a href="list.khs">게시물보기</a>
<br/><br/><br/>
Copyright 2011 All rights reserved. <br/>
</center>
</body>
</html>
