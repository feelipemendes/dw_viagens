<%-- 
    Document   : signin
    Created on : 28/11/2016, 22:31:05
    Author     : Luiz
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Dw Viagens - Página Principal</title>

        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Theme CSS -->
        <link href="css/freelancer.min.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Dw Viagens - Index</title>

        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Theme CSS -->
        <link href="css/freelancer.min.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link rel="icon" type="img/ico" href="img/ico/favicon.ico">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <!--  jQuery -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

        
        
        <!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
        <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

        <!-- Bootstrap Date-Picker Plugin -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    </head>
    <body id="page-top" class="index">
         <!-- Navigation -->
        <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="#page-top">Dw Viagens </a><img class="img-responsive" id="img-ico" src="img/airplane-ico2.png" alt="airplane-icone">
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="hidden">
                            <a href="#page-top"></a>
                        </li>
                        <li class="page-scroll">
                            <a href="passagem">Comprar Passagem</a>
                        </li>
                        <li class="page-scroll">
                            <a href="#about">About</a>
                        </li>
                        <li class="page-scroll">
                            <a href="#contact">Contact</a>
                        </li>
                        <li class="dropdown">
                            <a data-toggle="dropdown" href="#"><%= request.getSession().getAttribute("nome")%><span class="caret"></span></a>
                            <ul id="menu-login" class="dropdown-menu">
                                <li><a href="#">home</a></li>
                                <li><a href="#">minhas compras</a></li>
                                <li><a href="#">configurações</a></li>
                                <li><a href="LogoutServlet">Logout</a></li>
                            </ul>
                        </li>    
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    <section id="passagem">
        <div class="container">
        <form action="">
                         <div class="centered">
                            <div class="col-sm-7">
                                <h3>Tabela de preços</h3>
                                <table class="table table-hover">
                                    <thead>
                                        <th>Executivo</th>
                                        <th>Selecionar</th>
                                        <th>Primeira classe</th>
                                        <th>Selecionar</th>
                                    </thead>
                                    <tbody>
                                        <jsp:useBean id="precos" class="java.util.List" scope="request"/>
                                        <c:forEach var="precos" items="${precos}">
                                            <tr>
                                                <td>${precos.executiva}</td>
                                                <td>  <input type="radio" name="precoExecutiva" value="${precos.id}" /> </td>   
                                                <td>${precos.primeiraClasse}</td>
                                                <td>  <input type="radio" name="precoPrimeira" value="${precos.id}" /> </td>                                        
                                            </tr>
                                        </c:forEach>
                                            <div class="row">
                                
                                    </div>
                                 </tbody>
                                 
                                </table>
                                        <div class="form-group col-xs-12 text-center">
                                    <br>
                                    <button type="submit" class="btn btn-success btn-lg">Selecionar</button>
                                </div>
                            </div>
                    </form>
                                        </div>
            </section>
    </body>
</html>
