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
                    <c:forEach var="task" items="${tasks}">
                        <form>
                            <tr>
                                <td><input name="task_id" value=${task.id} hidden required>${task.id}</td>
                                <td><input name="name" value=${task.name} required></td>
                                <td><textarea name="description" required>${task.description}</textarea></td>
                                <td><input style="width: 100px;" name="due_date" value=${task.due_date} required></td>
                                <td><input style="width: 20px;" name="done" value=${task.done} required></td>
                                <td><input style="width: 50px;" name="sprint_id" value=${task.sprint_id} required></td>
                                <td><input style="width: 50px;" name="performer_id" value=${task.performer_id} required></td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <button class="btn btn-primary btn-xs" type="submit" name="action" value="UPDATE_TASK" formmethod="POST">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">
                                        <button class="btn btn-danger btn-xs"  name="action" value="DELETE_TASK" formmethod="POST">
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
                            <td><textarea name="description" required></textarea></td>
                            <td><input style="width: 100px;" name="due_date" required></td>
                            <td><input style="width: 20px;" name="done" required></td>
                            <td><input style="width: 50px;" name="sprint_id" required></td>
                            <td><input style="width: 50px;" name="performer_id" required></td>
                            <td>
                                <p data-placement="top" data-toggle="tooltip" title="Edit">
                                    <button class="btn btn-success btn-xs" type="submit" name="action" value="CREATE_TASK" formmethod="POST">
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