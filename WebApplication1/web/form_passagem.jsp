<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form name="sentMessage"   action="CompraPassagemServlet">
    <div class="form-group">

        <div class="col-sm-11">
            <label for="de" class="col-sm-1 control-label">De</label>
            <select id="country" class="form-control">
                <option value="GALEAO">Galeão</option>
                <option value="Santos">Santos Dummont</option>
            </select>
        </div>
        <br></div> <!-- /.form-group -->

    <div class="form-group">

        <div class="col-sm-11">
            <label for="para" class="col-sm-1 control-label">Para</label>
            <select name="country" class="form-control">
                <option value="TEXAS AIRPORT">Texas Airport</option>
                <option value="2">Canada Airport</option>
            </select>
        </div>
    </div> <!-- /.form-group -->


    <br><br>
    <div class="form-group">

        <div class="col-sm-4">
            <label for="para" class="col-sm-1 control-label">Ida</label>
            <input type="date" class="form-control" name="dataIda">
        </div>

        <div class="col-sm-4">
            <label for="para" class="col-sm-1 control-label">Volta</label>
            <input type="date" class="form-control" name="dataVolta">
        </div>


        <div class="col-sm-3">    
            <label for="para" class="col-sm-1 control-label">Assentos</label>   
            <select name="assentos" class="form-control">
                <option value="">Máx. 5</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
        </div>
    </div> 

    <!-- botao de buscar -->
    <div id="success"></div>
    <div class="row">
        <div class="form-group col-xs-12 text-center">
            <br>
            <button type="submit" class="btn btn-success btn-lg">Buscar</button>
        </div>
    </div>
</form>