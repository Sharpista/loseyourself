<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/seguros/afterlogin.jsp">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="${pageContext.request.contextPath}/seguros/clientServlet?acao=listarsegurados">Listar Segurados</a>
      <a class="nav-item nav-link" href="${pageContext.request.contextPath}/seguros/listaDeSeguros">Listar Seguros</a>
      <a class="nav-item nav-link" href="${pageContext.request.contextPath}/seguros/clientServlet?acao=abrircadastro">Cadastrar Segurado</a>
      <a class="nav-item nav-link" href="${pageContext.request.contextPath}/seguros/seguroServlet?acao=cadastrarseguro">Cadastrar Seguro</a>
    </div>
  </div>
   <form class="form-inline my-2 my-lg-0">
     
      <button class="btn btn-outline-success my-2 my-sm-0" href="${pageContext.request.contextPath}/seguros/logoutServlet"type="submit">Logout</button>
      
    </form>
</nav>
   


</body>
</html>