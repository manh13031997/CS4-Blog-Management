 function login(){
    axios.post("http://localhost:8082/users/login", {
        username: document.getElementById("usn").value,
        password: document.getElementById("pas").value
    }).then(response => {
        if (response.data === "Login successful"){
            alert("Login successful")
            localStorage.setItem("username", document.getElementById("usn").value)
        } else if (response.data === "Username or password is incorrect"){
            alert("Username or password is incorrect")

        }
    })
}

