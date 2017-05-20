<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp" %>
<h1>Comments:</h1>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="mytable" class="table table-bordred table-striped">
                    <thead>
                    <th>Id</th>
                    <th>Content</th>
                    <th>Task id</th>
                    <th>Author id</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>
                    <tbody>
                    <c:forEach var="comment" items="${comments}">
                        <form>
                            <tr>
                                <td><input name="comment_id" value=${comment.id} hidden required>${comment.id}</td>
                                <td><input name="content" value=${comment.content} required></td>
                                <td><input name="task_id" value=${comment.task_id} required></td>
                                <td><input name="author_id" value=${comment.author_id} required></td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <button class="btn btn-primary btn-xs" type="submit" name="action" value="UPDATE_COMMENT" formmethod="POST">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">
                                        <button class="btn btn-danger btn-xs"  name="action" value="DELETE_COMMENT" formmethod="POST">
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
                            <td><input name="content" required></td>
                            <td><input name="task_id" required></td>
                            <td><input name="author_id" required></td>
                            <td>
                                <p data-placement="top" data-toggle="tooltip" title="Edit">
                                    <button class="btn btn-success btn-xs" type="submit" name="action" value="CREATE_COMMENT" formmethod="POST">
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