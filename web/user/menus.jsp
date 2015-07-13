<%--
  Created by IntelliJ IDEA.
  User: wupic
  Date: 15-7-13
  Time: 下午3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/public/bootstraptree/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/public/bootstraptree/css/bootstraptreestyle.css" />
    <script type="text/javascript" src="/public/bootstraptree/js/bootstraptree.js"></script>
</head>
<body>
=${SESSION_LOGIN_MENU}=
<div class="tree">

    <ul>
        <li>
            <span><i class="icon-folder-open"></i> <a href=""> 菜单管理根</a></span>
            <ul>
                <c:forEach items="${SESSION_LOGIN_MENU}" var="menu">
                    <li>
                    <span>
                        <i class="icon-minus-sign"></i> <a href="">${menu.menu1.node_name}</a>
                    </span>
                     <ul>
                            <c:forEach items="${menu.menu2s}" var="menu2">
                                <li>
                                    <span><i class="icon-leaf"></i> <a href=""> ${menu2.node_name}</a> </span>
                                </li>
                            </c:forEach>

                      </ul>
                    </li>
                </c:forEach>
            </ul>
        </li>


    </ul>
</div>
</body>
</html>