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
                    <th>Start date</th>
                    <th>End date</th>
                    <th>Project id</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>
                    <tbody>
                    <c:forEach var="sprint" items="${requestScope.sprints}">
                        <tr>
                            <form method="post" action="upd-sprint">

                                <td><input name="id" value=${sprint.id} hidden required>${sprint.id}</td>
                                <td><input name="name" value=${sprint.name} required></td>
                                <td><input type="date" name="startDate" value=${sprint.startDate} required></td>
                                <td><input type="date" name="endDate" value=${sprint.endDate} required></td>
                                <td><input type="number" name="projectId" value=${sprint.projectId} required></td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <button class="btn btn-primary btn-xs" name="action" value="UPDATE_SPRINT"
                                                formmethod="POST">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </td>
                            </form>
                            <form method="post" action="del-sprint">
                                <input type="hidden" name="id" value=${sprint.id}>

                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">
                                        <button class="btn btn-danger btn-xs" type="submit">
                                            <span class="glyphicon glyphicon-trash"></span>
                                        </button>
                                    </p>
                                </td>
                            </form>

                            <form method="post" action="generate-sprint-tasks-report-pdf">
                                <input type="hidden" name="id" value=${sprint.id}>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Download sprint tasks report PDF">
                                        <button class="btn btn-warning btn-xs" type="submit">PDF</button>
                                    </p>
                                </td>
                            </form>
                            <form method="post" action="generate-sprint-tasks-report-csv">
                                <input type="hidden" name="id" value=${sprint.id}>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Download sprint tasks report CSV">
                                        <button class="btn btn-warning btn-xs" type="submit">CSV</button>
                                    </p>
                                </td>
                            </form>
                            <form method="post" action="generate-sprint-tasks-report-xls">
                                <input type="hidden" name="id" value=${sprint.id}>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Download sprint tasks report XLS">
                                        <button class="btn btn-warning btn-xs" type="submit">XLS</button>
                                    </p>
                                </td>
                            </form>
                        </tr>

                    </c:forEach>
                    <form method="post" action="add-sprint">
                        <tr>
                            <td></td>
                            <td><input name="name" required></td>
                            <td><input type="date" name="startDate" required></td>
                            <td><input type="date" name="endDate" required></td>
                            <td><input type="number" name="projectId" required></td>
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