<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp" %>
<h1>Tasks:</h1>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="mytable" class="table table-bordred table-striped">
                    <thead>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Due dae</th>
                    <th>Done</th>
                    <th>Sprint id</th>
                    <th>Performer id</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>
                    <tbody>
                    <c:forEach var="task" items="${requestScope.tasks}">
                        <tr>
                            <form method="post" action="upd-task">

                                <td><input name="id" value=${task.id} hidden required>${task.id}</td>
                                <td><input name="name" value=${task.name} required></td>
                                <td><textarea name="description" required>${task.description}</textarea></td>
                                <td><input type="datetime-local" name="dueDate" value=${task.dueDate} required></td>
                                <td><input name="done" value=${task.done} required></td>
                                <td><input type="number" name="sprintId" value=${task.sprintId} required></td>
                                <td><input type="number" name="performerId" value=${task.performerId} required>
                                </td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <button class="btn btn-primary btn-xs" type="submit">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </td>
                            </form>
                            <form method="post" action="del-task">
                                <input type="hidden" name="id" value=${task.id}>


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
                    <form method="post" action="add-task">
                        <tr>
                            <td></td>
                            <td><input name="name" required></td>
                            <td><textarea name="description" required></textarea></td>
                            <td><input type="datetime-local" name="dueDate" required></td>
                            <td><input name="done" required></td>
                            <td><input type="number" name="sprintId" required></td>
                            <td><input type="number" name="performerId" required></td>
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