function signIn() {

    var uri = window.location.pathname;

    if ($(".form-signin").valid()) {
        $.ajax({
            url: uri,
            method: 'POST',
            data: {
                command: 'login',
                email: $("#inputEmail").val(),
                password: $("#inputPassword").val()
            },
            success: function (data) {
                window.location.replace("/home");
            },
            error: function (response) {
                alert(response.status);
            }
        });
    }
}

$("[data-toggle=tooltip]").tooltip();