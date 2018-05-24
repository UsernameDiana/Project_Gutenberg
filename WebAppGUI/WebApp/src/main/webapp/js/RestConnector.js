$(document).ready(function () {
    $("#submit").click(function () {
        $.ajax({
            url: "api/search/later",
            type: "POST",
            contentType: "application/json",
            data: $('#city').val(),
            success: function (data) {
                
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
                        console.log(type.toUpperCase() + "-------------" + JSON.stringify(value));
                        head = head + "<th>" + type.toUpperCase();
                        +"</th>";
                        row = row + "<td>" + JSON.stringify(value) + "</td>";

                    });
                    fullhead = "<tr>" + head + "</tr>";
                    fullrow = "<tr>" + row + "</tr>";
                    $('#modal2').find('thead:last').html(fullhead);
                    $('#modal2').find('tbody:last').append(fullrow);
                });
            }
        });

    });
});