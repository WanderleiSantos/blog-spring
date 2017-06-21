<%--
  Created by IntelliJ IDEA.
  User: Wanderlei Santos
  Date: 21/06/2017
  Time: 12:25plate use File | Settings | File Templates
  To change this tem.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="comentarios">
    <c:url var="save" value="/comentario/save"/>
    <form:form modelAttribute="comentario" action="${save}" method="post">
        <input type="hidden" value="${postagem.permalink}" name="permalink">
        <div>
            <form:label path="texto">Digite seu Comentário</form:label><br>
            <form:textarea path="texto" rows="5" cols="70" required="true"/>
        </div>
        <br>
        <div>
            <input type="submit" value="Salvar">
            <input type="reset" value="Limpar">
        </div>
    </form:form>

    <br>

    <c:forEach var="c" items="${postagem.comentarios}">
        <div class="comentarios">
            <img class="comentarios-avatar" src="<c:url value="/avatar/load/${c.usuario.avatar.id}"/>">
            <em>
                ${c.usuario.nome} - <fmt:formatDate value="${c.dataComentario}" type="both"/>
            </em>
            <p>${c.texto}</p>
        </div>
    </c:forEach>

</div>
