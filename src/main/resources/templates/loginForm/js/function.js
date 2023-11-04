 function login(){
    axios.post("http://localhost:8080/users/login", {
        username: document.getElementById("usn").value,
        password: document.getElementById("pas").value
    }).then(response => {
        if (response.data === "Login successful"){
            alert("Login successful")
            localStorage.setItem("username", document.getElementById("usn").value)
        } else if (response.data === "Username or password is incorrect"){
            alert("Username or password is incorrect")
            reloadPage()
        }
    })
}

 function register(){
     axios.post("http://localhost:8080/users/register", {
         username: document.getElementById("usn").value,
         age: document.getElementById("age").value,
         address: document.getElementById("address").value,
         email: document.getElementById("email").value,
         password: document.getElementById("password").value
     }).then(() => {
         alert("Register successful!!!")
         redirectToLoginForm("http://localhost:63342/CS4-Blog-Management/src/main/resources/templates/loginForm/loginForm.html?_ijt=shuescjtqi2g4iagmfd3pq5h4r&_ij_reload=RELOAD_ON_SAVE")

     })
 }

 function reloadPage(){
     location.reload();
 }

 function redirectToLoginForm(url) {
     window.location.href = url;
 }