<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp" %>
<div class="container">

    <form class="form-signin" method="post" action="signup">
        <h2 class="form-signin-heading">Please Sign Up</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required
               autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <label for="inputVerifyPassword" class="sr-only">Repeat password</label>
        <input type="password" id="inputVerifyPassword" name="verifyPassword" class="form-control"
               placeholder="Repeat password" required>
        <label for="inputFirstName" class="sr-only">First name</label>
        <input id="inputFirstName" name="firstName" class="form-control" placeholder="First name" required>
        <label for="inputLastName" class="sr-only">Last name</label>
        <input id="inputLastName" name="lastName" class="form-control" placeholder="Last name" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    </form>

</div>

<%@include file="templates/end-page.jsp" %>
