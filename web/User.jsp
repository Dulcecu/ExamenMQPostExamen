<%--
  Created by IntelliJ IDEA.
  User: Turpitude
  Date: 18/11/2016
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EETAC GO!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="script3.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            var cookie = document.cookie;
            $("#btn1").click(function (){
                $("#res").text("");
            $.get("/Etakemons",{cookie:cookie},function(responseJson) {

                    var $ul = $("<ul>").appendTo($("#res"));
                    $.each(responseJson, function(index, item) {
                        $("<li>").text(item).appendTo($ul)});



            });
            });
            $("#btn2").click(function (){
                $("#res").text("");
                var name= $("#name").val();
                var description= $("#description").val();
                    $.post("/Etakemons",{name:name,description:description,cookie:cookie},function(responseJson) {
                        $("#res").text(responseJson);
                    });

        });
            $("#btn3").click(function (){

                $("#res").text("");
                $.get("/EtakemonsDAO",{cookie:cookie},function(responseJson) {
                    var $ul = $("<ul>").appendTo($("#res"));
                    $.each(responseJson, function(index, item) {
                        $("<li>").text(item).appendTo($ul)});



                });
            });
            $("#btn4").click(function (){
                $("#res").text("");
                var name= $("#name").val();
                var description= $("#description").val();
                $.post("/EtakemonsDAO",{name:name,description:description,cookie:cookie},function(responseJson) {
                    $("#res").text(responseJson);
                });

            });
     });
</script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>Etakemon</h1>
        <div class="form-group">
            <label>Nombre</label>
            <input class="form-control" id="name" type="text">
        </div>

        <div class="form-group">
            <label>Descripcion</label>
            <input class="form-control"id="description" type="text">
        </div>

        <button id="btn1" class="btn btn-primary center-block">Ver Etakemons</button>
        <button id="btn2" class="btn btn-primary center-block">Insertar Etakemon</button>
        <button id="btn3" class="btn btn-primary center-block">Ver Etakemons DAO</button>
        <button id="btn4" class="btn btn-primary center-block">Insertar Etakemon DAO</button>
        <p id="res"></p>
        <footer id="foot01"></footer>
    </div>

</div>
</body>
</html>