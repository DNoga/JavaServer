$(document).ready(function(){
	
	$("#registerForm").submit(function(e) {
		  var error = 0;	
		  var password = $("#password").val();
		  var confirmPassword = $("#password_confirmation").val();
		  
		  //Checks if password and confirm password hold same value
		  if(password != confirmPassword){
			  error = error + 1;
		  }
		  
		  if(error == 0){
			  
		  }else{
			  e.preventDefault();
		  }
		  
		});
	
	
});