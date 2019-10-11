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
				<a href="index.jsp" class="text-decoration-none text-white"><i
					class="fas fa-arrow-left float-left"></i></a> CADASTRO
			</h5>
			<div class="card-body">
				<form class="p-3"
					action="${pageContext.request.contextPath}/seguros/clientServlet"
					method="post">
					<div class="form-group row ">
						<label for="nome"
							class="col-sm-1 col-form-label col-form-label-sm">NOME:</label>
						<div>
							<input class="form-control form-control-sm ml-5" id="nome"
								name="nome" placeholder="nome" value="${client.nome}">
						</div>
					</div>
					<div class="form-group row">
						<label for="cpf"
							class=" col-sm-1 col-form-label col-form-label-sm">CPF:</label>
						<div>
							<input class="form-control form-control-sm ml-5" id="cpf"
								name="cpf" placeholder="cpf" value="${client.cpf}">
						</div>
					</div>
					<div class="form-group row">
						<label for="rg" class=" col-sm-1 col-form-label col-form-label-sm">RG:</label>
						<div>
							<input class="form-control form-control-sm ml-5" id="rg"
								placeholder="rg" name="rg" value="${client.rg}">
						</div>
					</div>
					<div class="form-group row">
						<label for="aniversario"
							class=" col-sm-1 col-form-label col-form-label-sm">Nascimento:</label>
						<div>
							<input type="date" class="form-control form-control-sm ml-5"
								id="aniversario" name="aniversario" value="${client.aniversario}">
						</div>
					</div>
					<hr>
					<h5 class="mt-4">G�NERO</h5>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="sexo"
							id="masculino" value="Masculino"
							${client.marcacao == 'Masculino' ? 'checked' : ''}> <label
							class="form-check-label" for="exampleRadios1"> MASCULINO
						</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="sexo"
							id="feminino" value="Feminino"
							${client.marcacao == 'Feminino' ? 'checked' : ''}> <label
							class="form-check-label" for="exampleRadios2"> FEMININO </label>
					</div>
					<h5 class="mt-2">SEGURO</h5>
					<div class="form-check">
						<c:forEach var="seguro" items="${seguro}">
							<input class="form-check-input" type="checkbox"
								value="${seguro.id_seguro}" name="seguro"
								${paramValues.seguro.stream().anyMatch(v->v == '${seguro.id_seguro}').get() ? 'checked' : ''}>
							<label class="form-check-label"> ${seguro.identificacao}
							</label>
							<br>
						</c:forEach>
					</div>
					<h5 class="mt-2">CORRENTISTA</h5>

					<select class="custom-select mt-1" name="correntista">
						<option value="Sim"
							${client.correntista == 'Sim' ? 'selected' : ''}>Sim</option>
						<option value="Nao"
							${client.correntista == 'Nao' ? 'selected' : ''}>N�o</option>
					</select>
					<h5 class="mt-2">DIA DA VISITA</h5>
					<select multiple class="custom-select mt-1" name="visitas">
						<option value="Segunda"
							${paramValue.visita.stream().anyMartch(v -> v == "Segunda").get() ? 'selected' : ''}>Segunda</option>
						<option value="Ter�a"
							${paramValue.visita.stream().anyMartch(v -> v == "Ter�a").get() ? 'selected' : ''}>Ter�a</option>
						<option value="Quarta"
							${paramValue.visita.stream().anyMartch(v -> v == "Quarta").get() ? 'selected' : ''}>Quarta</option>
						<option value="Quinta"
							${paramValue.visita.stream().anyMartch(v -> v == "Quinta").get() ? 'selected' : ''}>Quinta</option>
						<option value="Sexta"
							${paramValue.visita.stream().anyMartch(v -> v == "Sexta").get() ? 'selected' : ''}>Sexta</option>
					</select>
					<div class="text-center mt-4">
						<button type="submit" class="btn btn-primary">CADASTRAR</button>
					</div>
					${mensagem}
				</form>
			</div>
		</div>
	</div>

</body>
</html>