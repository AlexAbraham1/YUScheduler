Template.syms.rendered = function () {
  $(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal-trigger').leanModal();
  });

  Session.set('currentSearch')
};

Template.syms.helpers({
  'symsClasses': function () {
    return symsMenClasses.find({}).fetch();
  },

  'search': function() {
    return Session.get('currentSearch');
  },

  'currentMoreInfo': function () {
    return Session.get('currentMoreInfo');
  }
});

Template.syms.events({
  'keydown input.search' : function (event) {
    if (event.which == 13) { // 13 is the enter key event
      var searchTerm = $('input.search').val();
      var search = symsMenClasses.find({title:{$regex:".*" + searchTerm + "*"}}).fetch();
      Session.set('currentSearch', search);
    }
  },

  'click a#more-info': function () {
    Session.set('currentMoreInfo', this);
    $('#modal1').openModal();
  },


  'click h5.title': function (e) {
    e.preventDefault();

    var time = this.time1start.split(":");
    var startTime = time[0];

    var day1 = this.day1.split("")[0];
    var day2 = this.day1.split("")[1];

    if (day1 == "M") {
      if (startTime == "09") {
        $('#09-mon').html(this.title);
      }
      else if (startTime == "10") {
        $('#10-mon').html(this.title);
      }
      else if (startTime == "11") {
        $('#11-mon').html(this.title);
      }
      else if (startTime == "01") {
        $('#01-mon').html(this.title);
      }
      else if (startTime == "03") {
        $('#03-mon').html(this.title);
      }
      else if (startTime == "04") {
        $('#04-mon').html(this.title);
      }
      else if (startTime == "06") {
        $('#06-mon').html(this.title);
      }
      else if (startTime == "07") {
        $('#07-mon').html(this.title);
      }
    }

    if (day1 == "T") {
      if (startTime == "09") {
        $('#09-tues').html(this.title);
      }
      else if (startTime == "10") {
        $('#10-tues').html(this.title);
      }
      else if (startTime == "11") {
        $('#11-tues').html(this.title);
      }
      else if (startTime == "01") {
        $('#01-tues').html(this.title);
      }
      else if (startTime == "03") {
        $('#03-tues').html(this.title);
      }
      else if (startTime == "04") {
        $('#04-tues').html(this.title);
      }
      else if (startTime == "06") {
        $('#06-tues').html(this.title);
      }
      else if (startTime == "07") {
        $('#07-tues').html(this.title);
      }
    }

    if (day1 == "W") {
      if (startTime == "09") {
        $('#09-wed').html(this.title);
      }
      else if (startTime == "10") {
        $('#10-wed').html(this.title);
      }
      else if (startTime == "11") {
        $('#11-wed').html(this.title);
      }
      else if (startTime == "01") {
        $('#01-wed').html(this.title);
      }
      else if (startTime == "03") {
        $('#03-wed').html(this.title);
      }
      else if (startTime == "04") {
        $('#04-wed').html(this.title);
      }
      else if (startTime == "06") {
        $('#06-wed').html(this.title);
      }
      else if (startTime == "07") {
        $('#07-wed').html(this.title);
      }
    }

    if (day1 == "R") {
      if (startTime == "09") {
        $('#09-thurs').html(this.title);
      }
      else if (startTime == "10") {
        $('#10-thurs').html(this.title);
      }
      else if (startTime == "11") {
        $('#11-thurs').html(this.title);
      }
      else if (startTime == "01") {
        $('#01-thurs').html(this.title);
      }
      else if (startTime == "03") {
        $('#03-thurs').html(this.title);
      }
      else if (startTime == "04") {
        $('#04-thurs').html(this.title);
      }
      else if (startTime == "06") {
        $('#06-thurs').html(this.title);
      }
      else if (startTime == "07") {
        $('#07-thurs').html(this.title);
      }
    }

    if (day1 == "F") {
      $('#09-fri').html(this.title);
    }

    if (day2 == "M") {
      if (startTime == "09") {
        $('#09-mon').html(this.title);
      }
      else if (startTime == "10") {
        $('#10-mon').html(this.title);
      }
      else if (startTime == "11") {
        $('#11-mon').html(this.title);
      }
      else if (startTime == "01") {
        $('#01-mon').html(this.title);
      }
      else if (startTime == "03") {
        $('#03-mon').html(this.title);
      }
      else if (startTime == "04") {
        $('#04-mon').html(this.title);
      }
      else if (startTime == "06") {
        $('#06-mon').html(this.title);
      }
      else if (startTime == "07") {
        $('#07-mon').html(this.title);
      }
    }

    if (day2 == "T") {
      if (startTime == "09") {
        $('#09-tues').html(this.title);
      }
      else if (startTime == "10") {
        $('#10-tues').html(this.title);
      }
      else if (startTime == "11") {
        $('#11-tues').html(this.title);
      }
      else if (startTime == "01") {
        $('#01-tues').html(this.title);
      }
      else if (startTime == "03") {
        $('#03-tues').html(this.title);
      }
      else if (startTime == "04") {
        $('#04-tues').html(this.title);
      }
      else if (startTime == "06") {
        $('#06-tues').html(this.title);
      }
      else if (startTime == "07") {
        $('#07-tues').html(this.title);
      }
    }

    if (day2 == "W") {
      if (startTime == "09") {
        $('#09-wed').html(this.title);
      }
      else if (startTime == "10") {
        $('#10-wed').html(this.title);
      }
      else if (startTime == "11") {
        $('#11-wed').html(this.title);
      }
      else if (startTime == "01") {
        $('#01-wed').html(this.title);
      }
      else if (startTime == "03") {
        $('#03-wed').html(this.title);
      }
      else if (startTime == "04") {
        $('#04-wed').html(this.title);
      }
      else if (startTime == "06") {
        $('#06-wed').html(this.title);
      }
      else if (startTime == "07") {
        $('#07-wed').html(this.title);
      }
    }

    if (day2 == "R") {
      if (startTime == "09") {
        $('#09-thurs').html(this.title);
      }
      else if (startTime == "10") {
        $('#10-thurs').html(this.title);
      }
      else if (startTime == "11") {
        $('#11-thurs').html(this.title);
      }
      else if (startTime == "01") {
        $('#01-thurs').html(this.title);
      }
      else if (startTime == "03") {
        $('#03-thurs').html(this.title);
      }
      else if (startTime == "04") {
        $('#04-thurs').html(this.title);
      }
      else if (startTime == "06") {
        $('#06-thurs').html(this.title);
      }
      else if (startTime == "07") {
        $('#07-thurs').html(this.title);
      }
    }

    if (day2 == "F") {
      $('#09-fri').html(this.title);
    }
  }
});
