



function getAdminpage() {
     criteria1=new Criteria1();
    sendRequest("GET", "position?", null, getPositionsSucccessHandler, getPositionsErrorHandler);
}
function Criteria1() {
    var userName = $('#userName').val().trim(); // select data from input and trim it
    if (userName.length > 0) {
        this.userName = userName;
    }

    var inputPassword = $('#inputPassword').val().trim(); // select data from input and trim it
    if (inputPassword.length > 0) {
        this.inputPassword = inputPassword;
    }
}
function getPositionsSucccessHandler(respData) {
    if (respData == "abcd") {
        goToPage("http://localhost:61611/track/static/admin.html");
    } else
    {
        goToPage("http://localhost:61611/track/static/login.html")
    }
}
function getPosition() {
    return myPosition;
}
function getPositionsErrorHandler(status) {
    alert("err response: " + status); // popup on err.
}