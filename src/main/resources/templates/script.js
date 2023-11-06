let userName = localStorage.getItem("username")

function logOut() {
    redirectToForm("http://localhost:63342/CS4-Blog-Management/src/main/resources/templates/loginForm/loginForm.html?_ijt=shuescjtqi2g4iagmfd3pq5h4r&_ij_reload=RELOAD_ON_SAVE")
}

function redirectToForm(url) {
    window.location.href = url;
}