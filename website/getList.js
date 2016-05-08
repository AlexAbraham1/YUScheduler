var LINK = 
$(function () {
    //'use strict';
    $.get(LINK)
        .done(populateSelectBox)
        .fail(function (xhr, status, exception) {
            ajaxFailure(xhr, status, exception, "populateSelect");
        })
        .complete(function () {
            $("#loadingnames").hide();
        });
});