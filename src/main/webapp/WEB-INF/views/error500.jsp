<%--
  Created by IntelliJ IDEA.
  User: wanderlei
  Date: 03/08/17
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
    <body>
        <h1>Error 500</h1>
        <p>Um Erro Foi Encontrado</p>
        <di>
            ${pageContext.exception.message}
        </di>
    </body>
</html>
