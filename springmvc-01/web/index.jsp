<%--
  Created by IntelliJ IDEA.
  User: 三木
  Date: 2021/5/16
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="hello" method="get">
    <input type="text" name="id"/>
    <input type="submit" value="get"/>
  </form>
  <form action="hello" method="post">
    <input type="text" name="id"/>
    <input type="text" name="username"/>
    <input type="text" name="password"/>
    <input type="text" name="email"/>
    <input type="submit" value="post"/>
  </form>
  <form action="hello" method="post">
    <input type="hidden" name="_method" value="delete"/>
    <input type="text" name="id"/>
    <input type="submit" value="delete"/>
  </form>
  <form action="hello" method="post">
    <input type="hidden" name="_method" value="put"/>
    <input type="text" name="id"/>
    <input type="text" name="username"/>
    <input type="text" name="password"/>
    <input type="text" name="email"/>
    <input type="submit" value="put"/>
  </form>
<%--<a href="/hello">hello</a>--%>
  </body>
</html>
