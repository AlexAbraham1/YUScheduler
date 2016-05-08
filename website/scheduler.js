/* global $ */

// Read Synchrously

var isBothYCAndStern = false;
$(document).ready(function() {
    //var fs = require("fs");
    

    $("#getCourses").click(function() {
          
        var data =$("select").val()
            
        $.getJSON("https://scheduler-shainad.c9users.io/" + data + ".json", function(json) {
            var current, getBackMyJSON;
            $("#classes").empty();
            for (dept in json) {
                
                for (course in json[dept]) {
                    current = $().data('key',json[dept][course]);
                    getBackMyJSON = $('#myElement').data('key');
                    
                    $("#classes").append("<div id="+ json[dept][course]["crn"] +">" + course +" " +json[dept][course]["day1"] + "<div>" +  "<br>");// JSON.stringify(json[dept][course]));    
                }
                
        }
                
        
    });
        
      
    });
});