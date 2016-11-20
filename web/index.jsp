<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DSA</title>
    <meta charset="utf-8">
    <%-- CODIGO PARA UTILIZAR LOS BOOTSTRAPS --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#btn2").click(function (){
                var name= $("#name").val();
                var password= $("#password").val();
                $.post("/Register",{name:name,password:password},function(responseText) {
                    if(responseText!="Usuario existente") {
                        window.location = "User.jsp";
                        document.cookie=name;
                    }
                    else{$("#res").text(responseText);}
                });
            });
            $("#btn1").click(function (){
                var name= $("#name").val();
                var password= $("#password").val();
                $.get("/Register",{name:name,password:password},function(responseText) {
                    if(responseText!="Error al autenticarse") {
                        document.cookie=name;
                        window.location = "User.jsp";
                    }
                    else{ $("#res").text(responseText);}
                });
            });
            $("#btn4").click(function (){
                var name= $("#name").val();
                var password= $("#password").val();
                $.post("/RegisterDAO",{name:name,password:password},function(responseText) {
                    if(responseText!="Usuario existente") {
                        window.location = "User.jsp";
                        document.cookie=name;
                    }
                    else{$("#res").text(responseText);}
                });
            });
            $("#btn3").click(function (){
                var name= $("#name").val();
                var password= $("#password").val();
                $.get("/RegisterDAO",{name:name,password:password},function(responseText) {
                    if(responseText!="Error al autenticarse") {
                        document.cookie=name;
                        window.location = "User.jsp";
                    }
                    else{ $("#res").text(responseText);}
                });
            });
        });
    </script>

</head>

<body>

<div class="container">
    <%-- DIVISION DEL BOOTSRAP LLAMADA JUMBOTRON QUE HACE LA LETRA GRANDE (ESTILO) --%>
    <div class="jumbotron">
        <h1>Examen MQ</h1>

        <h2>Bienvenida</h2>
        <%-- PONE LAS LETRAS EN EL MEDIO --%>

        <%-- CREA BOTONES CON VINCULOS INTERNOS ( FIBONACCI CLACULADORA...) --%>
        <div class="container">
            <div class="jumbotron">
                <h1>Inicio Session</h1>

                <div class="form-group">
                    <label>Name</label>
                    <input class="form-control" id="name" type="text">
                </div>

                <div class="form-group">
                    <label>Password</label>
                    <input class="form-control"id="password" type="password">
                </div>

                <button id="btn1" class="btn btn-primary center-block">Iniciar session</button>
                <button id="btn2" class="btn btn-primary center-block">Registrarse</button>
                <button id="btn3" class="btn btn-primary center-block">Iniciar session DAO</button>
                <button id="btn4" class="btn btn-primary center-block">Registrarse DAO</button>
                <p id="res"></p>

            </div>

        </div>
        <%-- AÑADE UN PIE DE PAGINA ( SE PROGRAMA EN EL JS) --%>
        <footer id="foot01"></footer>
    </div>

</div>
<%-- NOMBRE DEL JS --%>
<script src="script3.js"></script>
</body>

</html>