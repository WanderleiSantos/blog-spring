<%--
  Created by IntelliJ IDEA.
  User: wanderlei
  Date: 13/05/17
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fieldset style="font-family: monospace; font-size: 10px">
    <legend>Menu</legend>
    <nav>
        <a href="<c:url value="/"/> ">HOME</a>
    </nav>
    <nav>
        <a href="<c:url value="/usuario/add"/>">Add Usuario</a>
        <a href="<c:url value="/usuario/list"/>">Listar Usuarios</a>
    </nav>

    <nav>
        <a href="<c:url value="/autor/add"/>">Add Autor</a>
        <a href="<c:url value="/autor/list"/>">Listar Autores</a>
    </nav>

    <nav>
        <a href="<c:url value="/postagem/add"/>">Add Postagem</a>
        <a href="<c:url value="/postagem/list"/>">Listar Postagens</a>
    </nav>

    <nav>
        <a href="<c:url value="/categoria/add"/>">categorias</a>
    </nav>
</fieldset>
