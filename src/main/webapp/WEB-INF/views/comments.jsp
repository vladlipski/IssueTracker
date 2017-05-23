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
                    <c:forEach var="comment" items="${requestScope.comments}">
                        <tr>
                            <form method="post" action="upd-comment">

                                <td><input name="id" value=${comment.id} hidden required>${comment.id}</td>
                                <td><input name="content" value=${comment.content} required></td>
                                <td><input type="number" name="taskId" value=${comment.taskId} required></td>
                                <td><input type="number" name="authorId" value=${comment.authorId} required></td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <button class="btn btn-primary btn-xs" type="submit">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </td>
                            </form>
                            <form method="post" action="del-comment">
                                <input type="hidden" name="id" value=${comment.id}>
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
                    <form method="post" action="add-comment">
                        <tr>
                            <td></td>
                            <td><input name="content" required></td>
                            <td><input type="number" name="taskId" required></td>
                            <td><input type="number" name="authorId" required></td>
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