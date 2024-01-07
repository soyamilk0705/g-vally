<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 쓰기</title>
<script type="text/javascript">
	function board_write(){	
		if (this.writeform.name.value == ""){
			alert("이름을 입력해주세요.");
			this.writeform.name.focus();
		} else if(this.writeform.pwd.value == ""){
			alert("비밀번호를 입력해주세요.");
			this.writeform.pwd.focus();
		} else if(this.writeform.email.value == "") {
			alert("이메일을 입력해주세요.");
			this.writeform.email.focus();
		} else if(this.writeform.subject.value == "") {
			alert("제목를 입력해주세요.");
			this.writeform.subject.focus();
		} else if(this.writeform.content.value == "") {
			alert("내용을 입력해주세요.");
			this.writeform.content.focus();
		} else {
			// document.writeform.submit();
			return true;
		}
		
		return false;
	} 
	
	 function board_write(writeform){
		alert(writeform.name.value);
		if (writeform.name.value == ""){
			alert("이름을 입력해주세요.");
			writeform.name.focus();
		} else if(writeform.pwd.value == ""){
			alert("비밀번호를 입력해주세요.");
			writeform.pwd.focus();
		} else if(writeform.email.value == "") {
			alert("이메일을 입력해주세요.");
			writeform.email.focus();
		} else if(writeform.subject.value == "") {
			alert("제목를 입력해주세요.");
			writeform.subject.focus();
		} else if(writeform.content.value == "") {
			alert("내용을 입력해주세요.");
			writeform.content.focus();
		} else {
			//writeform.submit();
			return true;
		}
		return false;

	}  
</script>
<style type="text/css">
	th {text-align: right; background: orange}

</style>

</head>
<body>
<h1>글 쓰기</h1>
<a href="list.htm">리스트</a>
<form name = "writeform" action="write.htm" method="post" onsubmit="return board_write(this)">
<table width="600">
	<tr>
		<th>이름</th>
		<td>
			<input type="text" name="name" maxlength="5" size="12"/>
		</td>
	</tr>
	
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" name="pwd" maxlength="12"  size="13"/>
		</td>
	</tr>
	
	<tr>
		<th>이메일</th>
		<td>
			<input type="text" name="email" maxlength="30"  size="30"/>
		</td>
	</tr>
	
	
	<tr>
		<th>제목</th>
		<td>
			<input type="text" name="subject" maxlength="50" size="65"/>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<textarea name="content" rows="5" cols="50"></textarea>
		</td>
	</tr>
	<tr>
		
		<td colspan="2">
			<input type="submit" value="쓰기"/>	<!-- board_write(this.writeform) -->
			<input type="reset" value="취소" />
		</td>
	</tr>
	

</table>


</form>
</body>
</html>