<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="www.zlybl.model.Apply" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lhy
  Date: 2023/1/3
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员借书申请全查</title>
</head>
<body>
<table>
    <caption>借书申请列表</caption>
    <tr>
        <th>申请id</th>
        <th>用户id</th>
        <th>图书id</th>
        <th>申请状态</th>
        <th>操作</th>
    </tr>
    <%
        List<Apply> applyList = (List<Apply>) request.getAttribute("applyList");
        for (Apply apply : applyList){
    %>
    <tr>
        <td><%=apply.getApplyId()%></td>
        <td><%=apply.getUserId()%></td>
        <td><%=apply.getBookId()%></td>
        <td><%=apply.getApplyStatus()%></td>
        <c:set var="applyStatus">
            <%=apply.getApplyStatus()%>
        </c:set>
        <c:if test="${applyStatus == 0}">
            <td>
                <a href="modApply?applyId=<%=apply.getApplyId()%>&userId=<%=apply.getUserId()%>&bookId=<%=apply.getBookId()%>&applyType=<%=apply.isApplyType()%>&applyStatus=1">同意申请</a>
            </td>
            <td>
                <a href="modApply?applyId=<%=apply.getApplyId()%>&userId=<%=apply.getUserId()%>&bookId=<%=apply.getBookId()%>&applyType=<%=apply.isApplyType()%>&applyStatus=2">拒绝申请</a>
            </td>
        </c:if>
        <c:if test="${applyStatus != 0}">
            <td>
                已处理
            </td>
        </c:if>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
