$(document).ready(function(e) {
    $("#goto-home").click(function() {
        window.location.replace("../");
    });
    $("#convert-mti").click(function() {
        var source = $("#inputMeters").val();
        $.get('/converter/convert', { target: 'in', value: source }, function(data) {
            $("#inputInches").val(data);
        });
    });
    $("#convert-itm").click(function() {
        var source = $("#inputInches").val();
        $.get('/converter/convert', { target: 'm', value: source }, function(data) {
            $("#inputMeters").val(data);
        });
    });
});