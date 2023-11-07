// let idLogin = localStorage.getItem("idLogin");
let userName = localStorage.getItem("username");
function login(){
    axios.post("http://localhost:8080/users/login", {
        username: document.getElementById("usn").value,
        password: document.getElementById("pas").value
    }).then((response) => {
        let id = response.data.id;
        let naa = response.data.username;
        if (response.status === 200){
            // alert("Login successful")
            localStorage.setItem("username", naa);//luu id dang nhap vao localstrorage
            localStorage.setItem("idLogin", id);
            redirectToForm("http://localhost:63342/CS4-Blog-Management/src/main/resources/templates/index.html?_ijt=c2q4jpdbiql6g4d86cabfl9dgk&_ij_reload=RELOAD_ON_SAVE")
        } else {
            alert("Username or password is incorrect")
            reloadPage()
        }
    })

}

 function register(){
     let age = document.getElementById("age").value
     let email = document.getElementById("email").value;
     let phone = document.getElementById("phone").value;
     let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
     let phoneRegex = /^(03|05|07|08|09)\d{8}$/;

     axios.post("http://localhost:8080/users/register", {
         username: document.getElementById("usn").value,
         age: document.getElementById("age").value,
         address: document.getElementById("address").value,
         phoneNumber: document.getElementById("phone").value,
         email: document.getElementById("email").value,
         password: document.getElementById("password").value
     }).then(() => {
         if (emailRegex.test(email) && phoneRegex.test(phone) && parseInt(age) >= 1) {
             alert("Register successful!!!")
             redirectToForm("http://localhost:63342/CS4-Blog-Management/src/main/resources/templates/loginForm/loginForm.html?_ijt=shuescjtqi2g4iagmfd3pq5h4r&_ij_reload=RELOAD_ON_SAVE")
         }else {
             alert("Age, phone number or email information may not be in the correct format!");
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
     let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

     if (!emailRegex.test(emailInput)) {
         emailError.style.display = 'block';
     } else {
         emailError.style.display = 'none';
     }
 }

 function checkPhoneNumberFormat() {
     let phoneInput = document.getElementById("phone").value;
     let phoneError = document.getElementById("phoneError");
     let phoneRegex = /^(03|05|07|08|09)\d{8}$/;

     if (!phoneRegex.test(phoneInput)) {
         phoneError.style.display = 'block';
     } else {
         phoneError.style.display = 'none';
     }
 }