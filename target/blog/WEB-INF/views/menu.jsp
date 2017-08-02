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
        <a href="<c:url value="/postagem/ajax/add"/>">Add Postagem AJAX</a>
    </nav>

    <nav>
        <a href="<c:url value="/categoria/add"/>">categorias</a>
    </nav>
</fieldset>
