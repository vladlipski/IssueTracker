<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp" %>
<h1>Users:</h1>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="mytable" class="table table-bordred table-striped">
                    <thead>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Role id</th>
                    <th>Password</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${requestScope.users}">
                        <tr>
                            <form method="post" action="upd-user">

                                <td><input name="id" value=${user.id} hidden required>${user.id}</td>
                                <td><input name="firstName" value=${user.firstName} required></td>
                                <td><input name="lastName" value=${user.lastName} required></td>
                                <td><input type="email" name="email" value=${user.email} required></td>
                                <td><input type="number" name="roleId" value=${user.roleId} required></td>
                                <td><input type="password" name="password" value=${user.password} required></td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <button class="btn btn-primary btn-xs" type="submit">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </td>
                            </form>
                            <form method="post" action="del-user">
                                <input type="hidden" name="id" value=${user.id}>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">
                                        <button class="btn btn-danger btn-xs" type="submit">
                                            <span class="glyphicon glyphicon-trash"></span>
                                        </button>
                                    </p>
                                </td>
                            </form>

                        </tr>
                    </c:forEach>
                    <form method="post" action="add-user">
                        <tr>
                            <td></td>
                            <td><input name="firstName" required></td>
                            <td><input name="lastName" required></td>
                            <td><input type="email" name="email" required></td>
                            <td><input type="number" name="roleId" required></td>
                            <td><input type="password" name="password" required></td>
                            <td>
                                <p data-placement="top" data-toggle="tooltip" title="Edit">
                                    <button class="btn btn-success btn-xs" type="submit">
                                        <span class="glyphicon glyphicon-plus"></span>
                                    </button>
                                </p>
                            </td>
                            <td></td>
                        </tr>
                    </form>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="templates/end-page.jsp" %>