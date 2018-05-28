$(document).ready(function () {
    var myLat;
    var myLong;
    navigator.geolocation.getCurrentPosition(function (pos) {
        var crd = pos.coords;
        myLat = crd.latitude;
        myLong = crd.longitude;
    }, error, options);
    var options = {
        enableHighAccuracy: true,
        timeout: 5000,
        maximumAge: 0
    };
    function error(err) {
        console.warn(`ERROR(${err.code}): ${err.message}`);
    }

    $("#submit").click(function () {

        if ($("#option").val() === "1") {
            dataUrl = JSON.stringify({
                item: $('#searchItem').val(),
                database: $('#databases').val()
            });
            var url = "api/search/byAuthor";
        } else if ($("#option").val() === "2") {
            dataUrl = JSON.stringify({
                item: $('#searchItem').val(),
                database: $('#databases').val()
            });
            var url = "api/search/byBook";
        } else if ($("#option").val() === "3") {
            dataUrl = JSON.stringify({
                item: $('#searchItem').val(),
                database: $('#databases').val()
            });
            var url = "api/search/byCity";
        } else if ($("#option").val() === "4") {
            var url = "api/search/byGeo";
            var dataUrl = JSON.stringify({
                lat: myLat,
                lng: myLong,
                radius: 3,
                database: $('#databases').val()
            });
        } else if ($("#option").val() === "5") {
            var url = "api/search/byGeo";
            var input = $('#searchItem').val();
            var res = input.split(",");
            var dataUrl = JSON.stringify({
                lat: res[0],
                lng: res[1],
                radius: res[2],
                database: $('#databases').val()
            });
        }


        $.ajax({
            url: url,
            type: "POST",
            contentType: "application/json",
            data: dataUrl,
            success: function (data) {


                document.getElementById('id02').style.display = 'block';
                if ($("#option").val() === "1") {
                    $('#modal2').find('thead:last').html("");
                    $('#modal2').find('tbody:last').html("");
                    var citySet = new Set();
                    var location = {lat: myLat, lng: myLong};
                    var map = new google.maps.Map(document.getElementById('map'), {
                        zoom: 2,
                        center: location
                    });

                    $.each(data, function (key) {

                        var booksInfo = data[key];
                        var row = "";
                        var head = "";
                        var fullhead;
                        var fullrow;
                        var object = [];
                        var i = 0;
                        $.each(booksInfo, function (type, value) {
//                            //console.log(type);
//                            //console.log(value);
                            object[i] = value;
                            if (type.toUpperCase() !== "CITIES") {
                                head = head + "<th>" + type.toUpperCase();
                                +"</th>";
                                row = row + "<td>" + JSON.stringify(value) + "</td>";
                            }
                            i++;

                        });

                        $.each(object[3], function (type, value) {
                            var location = [];
                            var i = 0;

                            $.each(value, function (type, value) {
                                location[i] = value;
                                i++;
                            });

                            if (!citySet.has(location[0])) {
                                citySet.add(location[0]);
                                //console.log(location[0], location[1], location[2]);


                                var myLatLng = {lat: location[2], lng: location[1]};
                                var marker = new google.maps.Marker({
                                    position: myLatLng,
                                    map: map,
                                    title: location[0]
                                });

                            }
                        });
                        fullhead = "<tr>" + head + "</tr>";
                        fullrow = "<tr>" + row + "</tr>";
                        $('#modal2').find('thead:last').html(fullhead);
                        $('#modal2').find('tbody:last').append(fullrow);
                        document.getElementById('map').style.display = 'block';
                    });
                } else if ($("#option").val() === "2") {
                    var boom = true;
                    var location = {lat: myLat, lng: myLong};
                    var map = new google.maps.Map(document.getElementById('map'), {
                        zoom: 2,
                        center: location
                    });
                    document.getElementById('map').style.display = 'block';
                    $('#modal2').find('thead:last').html("");
                    $('#modal2').find('tbody:last').html("");
                    $.each(data, function (key) {

                        var booksInfo = data[key];
                        var city = [];
                        var i = 0;
                        $.each(booksInfo, function (type, value) {
                            //console.log("Value: " + value);
                            city[i] = value;
                            i++;
                        });
                        var myLatLng = {lat: city[2], lng: city[1]};
                        var marker = new google.maps.Marker({
                            position: myLatLng,
                            map: map,
                            title: city[0]
                        });
                    });
                } else if ($("#option").val() === "3" || $("#option").val() === "4" || $("#option").val() === "5") {

                    document.getElementById('map').style.display = 'none';
                    $('#modal2').find('thead:last').html("");
                    $('#modal2').find('tbody:last').html("");
                    $.each(data, function (key) {

                        var booksInfo = data[key];
                        var exists = false;
                        var row = "";
                        var head = "";
                        var fullhead;
                        var fullrow;
                        $.each(booksInfo, function (type, value) {
                            if (type.toUpperCase() !== "CITIES") {
//                                if (($("#option").val() === "4" || $("#option").val() === "5") && type.toUpperCase() !== "AUTHOR") {
                                    head = head + "<th>" + type.toUpperCase();
                                    +"</th>";
                                    row = row + "<td>" + JSON.stringify(value) + "</td>";
//                                }
                            }
                        });
                        fullhead = "<tr>" + head + "</tr>";
                        fullrow = "<tr>" + row + "</tr>";
                        $('#modal2').find('thead:last').html(fullhead);
                        $('#modal2').find('tbody:last').append(fullrow);
                    });
                }
            }

        }
        );
    });
});


