<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <script src="https://www.google.com/recaptcha/api.js" async defer></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<style type="text/css">

.html, .body {
	margin: 0
}
</style>
</head>
<body>
	<div class="container">
		<div class="card mt-5 border-white" >
			<h5 class="card-header text-center bg-dark text-white">
				<a href="index.jsp" class="text-decoration-none text-white"><i
					class="fas fa-arrow-left float-left"></i></a> LOGIN
			</h5>
				<div class="card-body">
					<form  id = "loginForm" action="${pageContext.request.contextPath}/loginServlet" method = "post">
						<div class="form-group row" >
							<label for="nome"
								class="col-sm-1 col-form-label col-form-label-sm">User:</label>
							<div>
								<input class="form-control form-control-sm ml-5" id="usuario"
									name="usuario" placeholder="User" class = "required" value="${param.usuario}">
							</div>
						</div>
						<div class="form-group row">
							<label for="cpf"
								class=" col-sm-1 col-form-label col-form-label-sm">Password:</label>
							<div>
								<input class="form-control form-control-sm ml-5" id="senha"
									name="senha" placeholder="Password" type="password" class = "required" value="${param.senha}">
							</div>
						<div class="g-recaptcha" data-sitekey="6LcvYrkUAAAAADMj1ysNU5IA9qkLDE9oBbvCCksB"></div>
						</div>
						<div class="text-center mt-4">
						<button type="submit" class="btn btn-dark">Sign In</button>
					</div>
					${mensagem}
					</form>
					<script type="text/javascript">
						$('#loginForm').validate();
					</script>
				</div>
			
		</div>
	</div>

</body>
</html>