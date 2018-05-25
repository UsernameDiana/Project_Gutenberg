$(function(){
   
   $("#option").on("click", function () {
       $("#searchItem").prop("disabled", false);
       if($(this).val() === "1"){
           $("#searchItem").attr('placeholder', 'Enter one of the books authors');
       }
       else if($(this).val() === "2"){
           $("#searchItem").attr('placeholder', 'Enter the title of the book');
       }
       else if($(this).val() === "3"){
           $("#searchItem").attr('placeholder', 'Enter the city that you want books from');
       }
   });
});
