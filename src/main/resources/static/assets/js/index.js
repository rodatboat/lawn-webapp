$('document').ready(function() {
    $('#registerButton').on('click', function(e) {
        console.log("Register button pressed!")
        e.preventDefault();
        //
        // var b_href = $(this).attr('href');
        // // console.log($(this))
        //
        // $.get(b_href, (country, status) => {
        //     $('#idEdit').val(country.id);
        //     $('#descriptionEdit').val(country.description);
        //     $('#capitalEdit').val(country.capital);
        //     $('#codeEdit').val(country.code);
        //     $('#continentEdit').val(country.continent);
        //     $('#nationalityEdit').val(country.nationality);
        // });

        $('#registerModal').modal();
    });

    // $('table #deleteButton').on('click',function(event) {
    //     event.preventDefault();
    //
    //     var href = $(this).attr('href');
    //     $(this).attr('href', "");
    //
    //     $('#confirmDeleteButton').attr('href', href);
    //     $('#deleteModal').modal();
    // });
});