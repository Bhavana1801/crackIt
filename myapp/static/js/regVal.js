function validateform(){  
	var name=document.registration.username.value;  
	var password1=document.registration.password1.value; 
	var password2 = document.registration.password2.value;
	var reg = "(^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z]+$)";
	var email = document.registration.email.value;
	var regex = new RegExp(reg);
	alert("injavas");
	if (regex.test(email)) {
		alert("valid email");
	}
	if (name==null || name==""){  
  		alert("Name can't be blank");  
  		return false;  
	}
	if(password1.length<6){  
  		alert("Password must be at least 6 characters long.");  
  		return false;  
	}
	if(password1 != password2) {
		alert("password's doesnt match");
	}

}