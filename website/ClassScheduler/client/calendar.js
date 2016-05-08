Template.calendar.events({
  'click td': function (e) {
    var date = "#" + e.target.id;
    $(date).html("");
  }
});



