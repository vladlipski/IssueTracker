<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp" %>
<div class="container">

    <form class="form-signin" method="post" action="login">
        <h2 class="form-signin-heading">Please log in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required
               autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <a href="signup">Sign Up</a>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
    </form>

</div>

<%@include file="templates/end-page.jsp" %>
