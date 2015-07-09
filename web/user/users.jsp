<%--
  Created by IntelliJ IDEA.
  User: wupicheng
  Date: 15-5-13
  Time: 上午11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">

    <h1 class="page-title">Users</h1>
    <ul class="breadcrumb">
        <li><a href="index.html">Home</a> </li>
        <li class="active">Users</li>
    </ul>

</div>
<div class="main-content">

    <div class="btn-toolbar list-toolbar">
        <button class="btn btn-primary"><i class="fa fa-plus"></i> New User</button>
        <button class="btn btn-default">Import</button>
        <button class="btn btn-default">Export</button>
        <div class="btn-group">
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>密码</th>
            <th>ss</th>
            <th>编辑删除</th>
            <th style="width: 3.5em;"></th>
        </tr>
        </thead>
        <tbody>
        <script type="text/javascript">
             function deletea(user_id){
               $("#delete_a").attr("href","/user/userAction!deleteUser.do?user_id="+user_id);
                 $("#myModal").modal();
             }
        </script>
         <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.user_id}</td>
            <td>${user.user_name}</td>
            <td>${user.user_password}</td>
            <td>ss</td>
            <td>
                <a href="/user/userAction!editUser.do?user_id=${user.user_id}"><i class="fa fa-pencil"></i></a>
                <a href="#myModal" role="button" data-toggle="modal" onclick="deletea(${user.user_id})"><i class="fa fa-trash-o"></i></a>
            </td>

        </tr>
         </c:forEach>
        </tbody>
    </table>

    <ul class="pagination">
        <li><a href="/user/userAction!queryAllUser.do?currentPageNum=1">&laquo;</a></li>
        <c:forEach begin="1" end="${pageObject.totalPageNum}" var="num">
            <li><a href="/user/userAction!queryAllUser.do?currentPageNum=${num}">${num}</a></li>
        </c:forEach>


        <li><a href="/user/userAction!queryAllUser.do?currentPageNum=${pageObject.totalPageNum}">&raquo;</a></li>
    </ul>

    <div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">删除确认</h3>
                </div>
                <div class="modal-body">
                    <p class="error-text"><i class="fa fa-warning modal-icon"></i>确认删除吗？<br>这个操作不可恢复.</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
                    <a id="delete_a"  class="btn btn-danger"  >删除</a>
                </div>
            </div>
        </div>
    </div>



</div>