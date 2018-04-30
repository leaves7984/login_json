init();
function init(){
    $("#showtext").hide();
}
$("#category").change(function () {
    var text = $("#category option:selected").val();
    $.get( "/api/stByTitle?title=" + text, function( data ) {
        console.log(data);
        $("#showtext").empty();

        if(data.sleepTips.length != null){
            $("#showtext").show();
            data.sleepTips.forEach(function(item, index) {
                var option = "<option value = '" + item.id+ "'>" + item.title +  "</option>";
                $("#showtext").append(option);
            });
        }

    });
});