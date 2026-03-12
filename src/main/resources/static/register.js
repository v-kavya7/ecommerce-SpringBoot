function register(){

let name = document.getElementById("name").value;
let email = document.getElementById("email").value;
let password = document.getElementById("password").value;

fetch("http://localhost:8080/users/register",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({
name:name,
email:email,
password:password
})

})
.then(response=>response.json())
.then(data=>{

alert("Registration Successful");

window.location.href="login.html";

});

}