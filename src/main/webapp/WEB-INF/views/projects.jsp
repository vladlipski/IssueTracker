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
                    <c:forEach var="project" items="${requestScope.projects}">
                        <tr>
                            <form method="post" action="upd-project">

                                <td><input name="id" value=${project.id} hidden required>${project.id}</td>
                                <td><input name="name" value=${project.name} required></td>
                                <td><textarea name="description"
                                              value=${project.description} required>${project.description}</textarea>
                                </td>
                                <td><input type="date" name="creationDate" value=${project.creationDate} required></td>
                                <td><input type="number" name="managerId" value=${project.managerId} required></td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <button class="btn btn-primary btn-xs" name="action" value="UPDATE_PROJECT"
                                                formmethod="POST">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </td>
                            </form>
                            <form method="post" action="del-project">
                                <input type="hidden" name="id" value=${project.id}>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">
                                        <button class="btn btn-danger btn-xs" type="submit">
                                            <span class="glyphicon glyphicon-trash"></span>
                                        </button>
                                    </p>
                                </td>
                            </form>

                            <form method="post" action="generate-project-tasks-report-pdf">
                                <input type="hidden" name="id" value=${project.id}>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Download project tasks report PDF">
                                        <button class="btn btn-warning btn-xs" type="submit">PDF</button>
                                    </p>
                                </td>
                            </form>
                            <form method="post" action="generate-project-tasks-report-csv">
                                <input type="hidden" name="id" value=${project.id}>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Download project tasks report CSV">
                                        <button class="btn btn-warning btn-xs" type="submit">CSV</button>
                                    </p>
                                </td>
                            </form>
                            <form method="post" action="generate-project-tasks-report-xls">
                                <input type="hidden" name="id" value=${project.id}>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Download project tasks report XLS">
                                        <button class="btn btn-warning btn-xs" type="submit">XLS</button>
                                    </p>
                                </td>
                            </form>
                        </tr>

                    </c:forEach>
                    <form method="post" action="add-project">
                        <tr>
                            <td></td>
                            <td><input name="name" required></td>
                            <td><textarea name="description" required></textarea></td>
                            <td><input type="date" name="creationDate" required></td>
                            <td><input type="number" name="managerId" required></td>
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