<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fieldset style="font-family: monospace; font-size: 10px">
    <legend>Menu</legend>
    <nav>
        <a href="<c:url value="/"/> ">HOME</a>
    </nav>
    <nav>

        <security:authorize access="hasAnyAuthority('ADMIN', 'AUTOR', 'LEITOR')">
            <a href="<c:url value="/usuario/perfil/${logado.id}"/>">Perfil</a>
        </security:authorize>

        <security:authorize access="hasAuthority('ADMIN')">
            <a href="<c:url value="/usuario/list"/>">Listar Usuarios</a>
        </security:authorize>

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
        <security:authorize access="hasAnyAuthority('ADMIN', 'AUTOR')">
            <a href="<c:url value="/categoria/add"/>">categorias</a>
        </security:authorize>
    </nav>

    <nav class="login">

        <c:if test="${logado == null}">
            <a href="<c:url value="/auth/form"/>">LOGIN</a>
            <a href="<c:url value="/usuario/add"/>">Cadastrar-se</a>
        </c:if>

        <security:authorize access="hasAnyAuthority('ADMIN', 'AUTOR', 'LEITOR')">
            <form action="<c:url value="/logout"/>" method="post">
                <security:csrfInput/>
                <button type="submit">Sair</button>
             </form>
        </security:authorize>

    </nav>


</fieldset>
