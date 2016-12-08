<%-- 
    Document   : error
    Created on : 04/12/2016, 14:20:46
    Author     : Luiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p class="alert-danger text-center"> YOU NEED TO SIGN TO ENTER </p>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" isErrorPage="true">
        <title>ERROR 404 - Page Not Found!</title>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

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

    </head>
<script> 
var timeout = 4; //set time here 5sec
function timer(){ 
   if( --timeout > 0 ){ 
      document.forma.clock.value = timeout; 
      window.setTimeout( "timer()", 1000 ); 
   } 
   else{ 
     document.forma.clock.value = ""; 
     ///disable submit-button etc 
   } 
   if(document.forma.clock.value==""){
     top.document.location.replace('index.jsp'); //redirect page url to sign in
   }
}     
</script> 
<body> 
   <form  name="forma"> 
      <% String clock = null; %>
      <br>
      <br>
      <img src="img/you_shall_not_pass1.jpg" alt="gandalf" align="center" class="img-responsive center-block">
      <h1 class="text-center"><input type="text" size='1' name="clock" value="<%=clock%>" style="border:1px solid white">seconds</h1>
     <script> 
        timer(); //calljs timer()
     </script> 
   </form> 
</body>
</html> 
</html>
