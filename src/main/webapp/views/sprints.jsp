<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp" %>
<h1>Sprints:</h1>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="mytable" class="table table-bordred table-striped">
                    <thead>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Creation date</th>
                    <th>Manager id</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>
                    <tbody>
                    <c:forEach var="sprint" items="${sprints}">
                        <form>
                            <tr>
                                <td><input name="sprint_id" value=${sprint.id} hidden required>${sprint.id}</td>
                                <td><input name="name" value=${sprint.name} required></td>
                                <td><input name="start_date" value=${sprint.start_date} required></td>
                                <td><input name="end_date" value=${sprint.end_date} required></td>
                                <td><input name="project_id" value=${sprint.project_id} required></td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <button class="btn btn-primary btn-xs" name="action" value="UPDATE_SPRINT" formmethod="POST">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">
                                        <button class="btn btn-danger btn-xs"  name="action" value="DELETE_SPRINT" formmethod="POST">
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
                            <td><input name="name" required></td>
                            <td><input name="start_date" required></td>
                            <td><input name="end_date" required></td>
                            <td><input name="project_id" required></td>
                            <td>
                                <p data-placement="top" data-toggle="tooltip" title="Edit">
                                    <button class="btn btn-success btn-xs" type="submit" name="action" value="CREATE_SPRINT" formmethod="POST">
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