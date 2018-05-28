$(function () {

    $("#option").on("click", function () {
        $("#searchItem").prop("disabled", false);
        if ($(this).val() === "1") {
            $("#searchItem").attr('placeholder', 'Enter one of the books authors');
        } else if ($(this).val() === "2") {
            $("#searchItem").attr('placeholder', 'Enter the title of the book');
        } else if ($(this).val() === "3") {
            $("#searchItem").attr('placeholder', 'Enter the city that you want books from');
        } else if ($(this).val() === "4") {
            $("#searchItem").prop("disabled", true);
            $("#searchItem").attr('placeholder', 'Press \'Search\' To Find Books Close to you');
        } else if ($(this).val() === "5") {

            $("#searchItem").attr('placeholder', 'LATITUDE,LONGITUDE,RADIUS (1 = 1KM)');
        }
    });
});
