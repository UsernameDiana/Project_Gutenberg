
<%-- 
    Document   : response
    Created on : May 14, 2018, 11:21:37 AM
    Author     : diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--import the class with the info-->
<!DOCTYPE html>
<html>


    <head>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="js/RestConnector.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="form-inline">

            <div class="form-group mx-sm-3 mb-2">
                <input type="hidden" id="command" value="getBooksByCityName">
                <label for="city" class="sr-only">Input</label>
                <input type="text" class="form-control" id="city" placeholder="City,Author,Book">
            </div>


            <button id="submit" class="btn btn-primary mb-2" data-toggle="modal" data-target=".bd-example-modal-lg">Search</button>
        </div>
        
        <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">List</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <table id="modal2" class="table">
                            <thead></thead>
                            <tbody></tbody>
                        </table>
                    </div>
                </div>
            </div>
    
    </form
</body>
</html>

