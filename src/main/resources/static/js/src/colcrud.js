/*
 * IT WOULD BE REALLY NICE TO USE ASYNC\AWAIT HERE. YEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEAH
 * SOME REALLY GOOD CODE HERE. YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAS.
 * */

$(document).ready(function(e) {
    $("#goto-home").click(function() {
        window.location.replace("../");
    });
    $("#add").click(function() {
        var addedFname = $("#fname").val();
        var addedLname = $("#lname").val();
        add(addedFname, addedLname).then(resp => refreshTable());
    });
    $("#update").click(function() {
        var addedFname = $("#fname").val();
        var addedLname = $("#lname").val();
        var index = $("#update").attr("current-elem");
        console.log(addedFname, addedLname, index);
        upd(index, addedFname, addedLname).then(resp => refreshTable());
        $("#add").show(300);
        $("#update").hide(300);
        $("#update").attr("current-elem", null);
    });
});

function add(addedFname, addedLname) {
    return $.ajax({
        url: '/colcrud/create', 
        data: { firstName: addedFname, lastName: addedLname}, 
        type: 'PUT'
    });
}

function upd(index, addedFname, addedLname) {
    return $.ajax({
        url: '/colcrud/edit', 
        data: { listIndex: index, firstName: addedFname, lastName: addedLname}, 
        type: 'PATCH',
        success: setTimeout(() => refreshTable(), 100)
    });
}

function refreshTable(data) {
    var listIndex = 0;
    console.log("ref");
    $.get('/colcrud/all', function(data) {
        $('#table tbody').empty();
        data.map(elem => {
            addTableRow(listIndex, elem.firstName, elem.lastName);
            listIndex++;
        });
    });
}
function addTableRow(index, fname, lname) {
    const DOMEditButton = (index) => "<button id=\"edit-"+index+"\" class=\"w-100 btn btn-lg btn-primary mt-1 mb-1\">Edit<button>";
    const DOMDeleteButton= (index) => "<button id=\"delete-"+index+"\" class=\"w-100 btn-danger btn-lg btn-primary mt-1 mb-1\" current-elem=\""+index+"\">Delete<button>";

    $('#table').append('<tr><td>'+fname+'</td><td>'+lname+'</td><td>'+DOMEditButton(index)+'</td><td>'+DOMDeleteButton(index)+'</td></tr>');
    $('#edit-'+index).click(function() {
        $("#fname").val(fname);
        $("#lname").val(lname);
        $("#add").hide(300);
        $("#update").show(300);
        $("#update").attr("current-elem", index);
    });
    $("#delete-"+index).click(function() {
        var addedFname = $("#fname").val();
        var addedLname = $("#lname").val();
        $.ajax({
            url: '/colcrud/delete', 
            data: { listIndex: index, firstName: addedFname, lastName: addedLname}, 
            type: 'DELETE',
            success: setTimeout(() => refreshTable(), 100)
        });
    });
}
