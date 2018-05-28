
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
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAQ4lzFiOKDBzNMqDy03WUoc6zG5yGjtJk">
        </script>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="js/RestConnector.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/placeholderValue.js" type="text/javascript"></script>
        <style>
            #map {
                width: 100%;
                height: 400px;
                background-color: grey;
            }
        </style>
        <title>JSP Page</title>

    </head>
    <body>
        <div id="wrap">
            <div id="main">
                <div class="container w3-green" style="width: 45%">
                    <h2>Search</h2>
                </div>
                <div class="container" style="width: 46.4%">
                    <select class="w3-select" id="databases">
                        <option value="" disabled selected>Database:</option>
                        <option value="1b">MYSQL</option>
                        <option value="2b">POSTGRES</option>
                        <option value="3b">MONGO</option>
                    </select>
                    <select class="w3-select" id="option">
                        <option value="" disabled selected>Search By:</option>
                        <option value="1">Author</option>
                        <option value="2">Title</option>
                        <option value="3">City</option>
                        <option value="4">My Location</option>
                        <option value="5">Geolocation</option>
                    </select>
                    <button id="submit" class="w3-btn w3-black" style="float: right; height: 39px" >Search</button>
                    <input style="width: 90.6%" id="searchItem" class="w3-input" type="text" placeholder="Select one of the options above! (Click On Search By)" disabled>
                    <!-- The Modal -->
                    <div id="id02" class="w3-modal">
                        <div class="w3-modal-content">
                            <div class="w3-container">
                                <span onclick="document.getElementById('id02').style.display = 'none'" 
                                      class="w3-closebtn">&times;</span>
                                <div id="map" type="hidden"></div>
                                <table id="modal2" class="table">
                                    <thead></thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!--        <div class="form-inline">
        
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
        -->
    </body>
</html>

