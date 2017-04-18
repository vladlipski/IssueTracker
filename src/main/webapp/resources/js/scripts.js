function signIn() {

    var uri = window.location.pathname;

    $.ajax({
        url: uri,
        method: 'POST',
        data: {
            command: 'SIGN_IN',
            email: $("#inputEmail").val(),
            password: $("#inputPassword").val()
        },
        success: function(data) {

        },
        error: function () {

        }
    });
}