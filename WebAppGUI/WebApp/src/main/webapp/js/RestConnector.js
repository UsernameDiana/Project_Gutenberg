$(document).ready(function () {
    $("#submit").click(function () {
        if ($("#option").val() === "1") {
            var url = "api/search/byAuthor";
        } else if ($("#option").val() === "2") {
            var url = "api/search/byBook";
        } else if ($("#option").val() === "3") {
            var url = "api/search/byCity";
        }
        $.ajax({
            url: url,
            type: "POST",
            contentType: "application/json",
            data: $('#searchItem').val(),
            success: function (data) {

                $('#modal2').find('thead:last').html("");
                $('#modal2').find('tbody:last').html("");

                document.getElementById('id02').style.display = 'block';
                $.each(data, function (key) {

                    var booksInfo = data[key];
                    var exists = false;
                    var row = "";
                    var head = "";
                    var fullhead;
                    var fullrow;
                    $.each(booksInfo, function (type, value) {

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