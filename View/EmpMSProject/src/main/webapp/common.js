/**
 * java script 공통 모듈
 */

function checkLogin(loginForm){
	var id = loginForm.id.value;
	var pwd = loginForm.pwd.value;
	
	if(id.trim() == ""){
		alert("사번을 입력하세요.");
		loginForm.id.focus();
	} else if (pwd.trim() == "") {
		alert("비밀번호를 입력하세요.");
		loginForm.pwd.focus();
	}else {
		return true;
	}
	return false;
}

function checkPwd(oPwd, vPwd){
	if((oPwd.value.trim() == "") || (vPwd.value.trim() == "")){
		alert("비밀번호를 입력해주세요.");
		oPwd.focus();
	}
	
	if (pwd.value.trim() == vPwd.value.trim()){
		
		// var doc = opener.parent.center.document;
		// doc.form1.pwd.value = oPwd.value;
		
		opener.document.form1.pwd.value = oPwd.value;		// pwd 값을 새로 바꾼 비밀번호로 변경 
		self.close(); 
	} else {
		alert("비밀번호가 틀렸습니다. 다시 입력하세요.");
		vPwd.focus();
		
	}
}

function goDelete(id){
	location = 'deleteEmp.html?id=' + id;
}


function openWindow(url, title){
	var option = "";
	window.open(url, title, option);
}
