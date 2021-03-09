$(document).ready(function(e) {
    $("#goto-home").click(function() {
        window.location.replace("../");
    });
    $("#convert-mti").click(function() {
        var source = $("#inputMeters").val();
        $.get('/converter/convert', { target: 'in', value: source }, function(data) {
            if(data.success === "true")
                $("#inputInches").val(data.result);
            else
                $("#inputMeters").addClass("is-invalid");
        });
    });
    $("#convert-itm").click(function() {
        var source = $("#inputInches").val();
        $.get('/converter/convert', { target: 'm', value: source }, function(data) {
            if(data.success === "true")
                $("#inputMeters").val(data.result);
            else
                $("#inputInches").addClass("is-invalid");
        });
    });
});