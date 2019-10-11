<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.10.2/css/all.css"
	integrity="sha384-rtJEYb85SiYWgfpCr0jn174XgJTn4rptSOQsMroFBPQSGLdOC5IbubP6lJ35qoM9"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<style>
.btn-default.amarelo {
	background: yellow;
}

.btn-default.amarelo:hover {
	background: rgb(240, 240, 0);
}

.btn-default.amarelo.active {
	background: rgb(230, 230, 0);
}

.btn-default.laranja {
	background: orange;
}

.btn-default.laranja:hover {
	background: rgb(255, 140, 0);
}

.btn-default.laranja.active {
	background: rgb(255, 125, 0);
}

.btn-default.vermelho {
	background: red;
}

.btn-default.vermelho:hover {
	background: rgb(240, 0, 0);
}

.btn-default.vermelho.active {
	background: rgb(230, 0, 0);
}

.html, .body {
	margin: 0
}
</style>

</head>
<body>
	<div class="container">
		<div class="card mt-5 border-dark">

			<h5 class="card-header text-center bg-dark text-white">
				<a href="${pageContext.request.contextPath}/seguros/afterlogin.jsp" class="text-decoration-none text-white"><i
					class="fas fa-arrow-left float-left"></i></a> CADASTRO DE SEGUROS
			</h5>
			<div class="card-body">
				<form class="p-3"
					action="${pageContext.request.contextPath}/seguros/seguroServlet?acao=listarseguros"
					method="post">
					<div class="form-group row ">
						<label for="nome"
							class="col-sm-1 col-form-label col-form-label-sm">ID:</label>
						<div>
							<input class="form-control form-control-sm ml-5"
								id="id" name="id"
								placeholder="id" readonly value="${seguro.id_seguro}">
						</div>
					</div>
					<div class="form-group row ">
						<label for="nome"
							class="col-sm-1 col-form-label col-form-label-sm">TIPO:</label>
						<div>
							<input class="form-control form-control-sm ml-5"
								id="identificacao" name="identificacao"
								placeholder="identificacao" value="${seguro.identificacao}">
						</div>
					</div>
					<div class="form-group row">
						<label for="cpf"
							class=" col-sm-1 col-form-label col-form-label-sm">Valor:</label>
						<div>
							<input type="number" class="form-control form-control-sm ml-5"
								id="valor" name="valor" placeholder="valor"
								value="${seguro.valor}">
						</div>
					</div>
					<div class="text-center mt-4">
						<button type="submit" class="btn btn-primary">ATUALIZAR</button>
					</div>
					${mensagem}
				</form>
			</div>
		</div>
	</div>

</body>
</html>