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
                        <c:forEach var="user" items="${users}">
                            <form>
                                <tr>
                                    <td><input name="user_id" value=${user.id} hidden>${user.id}</td>
                                    <td><input name="first_name" value=${user.first_name} ></td>
                                    <td><input name="last_name" value=${user.last_name} ></td>
                                    <td><input name="email" value=${user.email} ></td>
                                    <td><input name="role_id" value=${user.role_id} ></td>
                                    <td><input name="password" value=${user.password} ></td>
                                    <td>
                                        <p data-placement="top" data-toggle="tooltip" title="Edit">
                                            <button class="btn btn-primary btn-xs" name="action" value="UPDATE_USER" formmethod="POST">
                                                <span class="glyphicon glyphicon-pencil"></span>
                                            </button>
                                        </p>
                                    </td>
                                    <td>
                                        <p data-placement="top" data-toggle="tooltip" title="Delete">
                                            <button class="btn btn-danger btn-xs"  name="action" value="DELETE_USER" formmethod="POST">
                                                <span class="glyphicon glyphicon-trash"></span>
                                            </button>
                                        </p>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                        <form>
                            <tr>
                                <td></td>
                                <td><input name="first_name"></td>
                                <td><input name="last_name"></td>
                                <td><input name="email"></td>
                                <td><input name="role_id"></td>
                                <td><input name="password"></td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <button class="btn btn-success btn-xs" name="action" value="CREATE_USER" formmethod="POST">
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </button>
                                    </p>
                                </td>
                            </tr>
                        </form>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
<%@include file="templates/end-page.jsp" %>