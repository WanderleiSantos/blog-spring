<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Postagens</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <script type="text/javascript" src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/postagem.js"/>"></script>
</head>
<body>
<c:import url="../menu.jsp"/>
<br>
<fieldset>

    <legend>Postagens</legend>
    <div>
        <input id="search" type="search" placeholder="Buscar" value="">
    </div>

    <table id="table-ajax" class="table">
        <jsp:include page="table-rows.jsp"/>
    </table>

    <div id="info"> </div>

</fieldset>

</body>

</html>
