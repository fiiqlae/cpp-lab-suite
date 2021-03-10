$(document).ready(function(e) {
    $("#goto-home").click(function() {
        window.location.replace("../");
    });
    $("#convert-mti").click(function() {
        var source = $("#inputMeters").val();
        $.get('/converter/convert', { targetSystem: 'in', requestValue: source }, function(data) {
            if(data.success)
                $("#inputInches").val(data.result);
            else
                $("#inputMeters").addClass("is-invalid");
        });
    });
    $("#convert-itm").click(function() {
        var source = $("#inputInches").val();
        $.get('/converter/convert', { targetSystem: 'm', requestValue: source }, function(data) {
            if(data.success)
                $("#inputMeters").val(data.result);
            else
                $("#inputInches").addClass("is-invalid");
        });
    });
});