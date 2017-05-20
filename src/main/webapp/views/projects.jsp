<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp" %>
<h1>Projects:</h1>
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
                    <c:forEach var="project" items="${projects}">
                        <form>
                            <tr>
                                <td><input name="project_id" value=${project.id} hidden>${project.id}</td>
                                <td><input name="name" value=${project.name} ></td>
                                <td><textarea name="description" value=${project.description} >${project.description}</textarea></td>
                                <td><input name="creation_date" value=${project.creation_date} ></td>
                                <td><input name="manager_id" value=${project.manager_id} ></td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <button class="btn btn-primary btn-xs" name="action" value="UPDATE_PROJECT" formmethod="POST">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">
                                        <button class="btn btn-danger btn-xs"  name="action" value="DELETE_PROJECT" formmethod="POST">
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
                            <td><input name="name"></td>
                            <td><textarea name="description"></textarea></td>
                            <td><input name="creation_date"></td>
                            <td><input name="manager_id"></td>
                            <td>
                                <p data-placement="top" data-toggle="tooltip" title="Edit">
                                    <button class="btn btn-success btn-xs" name="action" value="CREATE_PROJECT" formmethod="POST">
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