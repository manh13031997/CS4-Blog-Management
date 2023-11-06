 function login(){
    axios.post("http://localhost:8080/users/login", {
        username: document.getElementById("usn").value,
        password: document.getElementById("pas").value
    }).then(response => {
        if (response.data === "Login successful"){
            alert("Login successful")
            localStorage.setItem("username", document.getElementById("usn").value)
            redirectToForm("http://localhost:63342/CS4-Blog-Management/src/main/resources/templates/index.html?_ijt=c2q4jpdbiql6g4d86cabfl9dgk&_ij_reload=RELOAD_ON_SAVE")
        } else if (response.data === "Username or password is incorrect"){
            alert("Username or password is incorrect")
            reloadPage()
        }
    })
}

 function register(){
     let age = document.getElementById("age").value
     let email = document.getElementById("email").value;
     let regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

     axios.post("http://localhost:8080/users/register", {
         username: document.getElementById("usn").value,
         age: document.getElementById("age").value,
         address: document.getElementById("address").value,
         email: document.getElementById("email").value,
         password: document.getElementById("password").value
     }).then(() => {
         if (regex.test(email) && parseInt(age) >= 1) {
             alert("Register successful!!!")
             redirectToForm("http://localhost:63342/CS4-Blog-Management/src/main/resources/templates/loginForm/loginForm.html?_ijt=shuescjtqi2g4iagmfd3pq5h4r&_ij_reload=RELOAD_ON_SAVE")
         } else if (parseInt(age) < 1 && regex.test(email) === false) {
             alert("Enter age greater than or equal to 1 and invalid email address!")
             reloadPage()
         } else if (parseInt(age) < 1) {
             alert("Enter age greater than or equal to 1")
             reloadPage()
         }else {
             alert("Invalid email address!");
             reloadPage()
         }

     })
 }

 function reloadPage(){
     location.reload();
 }

 function redirectToForm(url) {
     window.location.href = url;
 }

 function checkAgeFormat(){
     let ageInput = document.getElementById("age").value;
     let ageError = document.getElementById("ageError");

     if (isNaN(ageInput)) {
         ageError.style.display = 'block';
     } else {
         ageError.style.display = 'none';
     }
 }

 function checkEmailFormat(){
     let emailInput = document.getElementById("email").value;
     let emailError = document.getElementById("emailError");
     let regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

     if (!regex.test(emailInput)) {
         emailError.style.display = 'block';
     } else {
         emailError.style.display = 'none';
     }
 }