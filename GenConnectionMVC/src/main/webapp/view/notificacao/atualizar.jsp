<<<<<<< HEAD:GenConnection-MVC/src/main/webapp/view/notificacoes/atualizar.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Atualizar Notificação</title>

		<!-- CDN CSS Bootstrap v-5.1 -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	</head>

	<body>
		<main>
			<header class="header">
				<div class="row my-4">
					<div class="col">
						<h1>Atualizar Notificações</h1>
					</div>
				</div>
			</header>

			<div class="container py-3">
				<form action="./atualizar-notificacao">
					<div class="form-group mb-3">
						<label for="id" class="form-label"> Id </label> <input type="text" id="nome" name="id"
							class="form-control" value="<%=request.getAttribute(" id") %>" />
					</div>

					<div class="form-group mb-3">
						<label for="nome" class="form-label"> Nome do Assunto </label> <input type="text" id="nome"
							name="nome" class="form-control" value="<%=request.getAttribute(" nome") %>" />
					</div>

					<div class="form-group mb-3">
						<label for="mensagem" class="form-label"> Mensagem </label> <input type="text" id="mensagem"
							name="mensagem" class="form-control" value="<%=request.getAttribute(" mensagem") %>" />
					</div>
					<button type="submit" class="btn btn-primary">Enviar</button>
					<a href="../../usuario" class="btn btn-danger" style="margin-left: 10px"> Cancelar </a>
				</form>
			</div>

		</main>

		<!-- CDN JS Bootstrap v-5.1 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"></script>
	</body>

	</html>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Notificacoes</title>

<!-- CDN CSS Bootstrap v-5.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
</head>
<body>
	<main>
		<header class="header">
			<div class="row my-4">
				<div class="col">
					<h1>Atualizar Notificacoes</h1>
				</div>
			</div>

		</header>

		<div class="container py-3">
			<form action="./atualizar-notificacao">

				<div class="form-group mb-3">
					<label for="id" class="form-label"> </label> <input
						type="hidden" id="id" name="id" class="form-control"
						value="<%=request.getAttribute("id")%>" />
				</div>

				<div class="form-group mb-3">
					<label for="nome" class="form-label"> Novo nome da Notificacao</label> <input
						type="text" id="nome" name="nome" class="form-control"
						value="<%=request.getAttribute("nome")%>" />
				</div>

				<div class="form-group mb-3">
					<label for="pontos" class="form-label"> Nova Mensagem </label> <input
						type="text" id="pontos" name="pontos" class="form-control"
						value="<%=request.getAttribute("mensagem")%>" />
				</div>


				<button type="submit" class="btn btn-primary">Enviar</button>

				<a href="./notificacao" class="btn btn-danger"
					style="margin-left: 10px"> Cancelar </a>
			</form>
		</div>

	</main>

	<!-- CDN JS Bootstrap v-5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
>>>>>>> main:GenConnectionMVC/src/main/webapp/view/notificacao/atualizar.jsp
