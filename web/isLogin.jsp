<%@ page import="jnmc.demo.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: GodDustin
  Date: 2023/5/18
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<@page import="jnmc.demo.Servlet.UserServlet"%>
<@page import="jnmc.demo.bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
    User user = (User)session.getAttribute("user");
    if(user ==null)
    {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
    }
%>
