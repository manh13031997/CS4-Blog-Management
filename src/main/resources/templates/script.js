//lay id dang nhap
let idLogin = localStorage.getItem("idLogin")
console.log(idLogin)
function logOut() {
    deleteLocalStorage()
    redirectToForm("http://localhost:63342/CS4-Blog-Management/src/main/resources/templates/loginForm/loginForm.html?_ijt=shuescjtqi2g4iagmfd3pq5h4r&_ij_reload=RELOAD_ON_SAVE")
}

function redirectToForm(url) {
    window.location.href = url;
}

function deleteLocalStorage() {
    localStorage.removeItem("username")
    localStorage.removeItem("idLogin")
}
function loadUser() {
    axios.get("http://localhost:8080/" + "user" +"/"+ idLogin).then((res) =>{
        +
        console.log(idLogin)
        let curUser = res.data
        console.log(curUser)
        document.getElementById("a ").innerHTML = `<span id="user" class="logo m-0 float-start">${curUser.username}</span>`;
        document.getElementById("b").innerHTML = `<img id="img" style="margin-left: 20px; width: 41px"
                            src=${curUser.image}
                            class="rounded-circle"
                            height="41"
                            alt="Black and White Portrait of a Man"
                            loading="lazy"
                />`;
    })
}
// loadUser();

