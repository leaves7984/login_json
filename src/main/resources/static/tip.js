$(document).ready(function() {
    $("#category").change(function () {
        var text = $("#category option:selected").val();
        $("#showtext").text(text);
        console.log("value: " + text);
    });
});
