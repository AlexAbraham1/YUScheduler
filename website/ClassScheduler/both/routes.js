// Router.configure({
//   // the default layout
//   layoutTemplate: 'index'
// });

Router.route('/', function () {
  Session.set('route', 'home');
  this.render('main');
  //Set session to return true for nav bar change in 'navigation.html/js'

});

Router.route('/stern', function () {
  Session.set('route', 'details');
  this.render('SternClasses');
});

Router.route('/syms', function () {
  Session.set('route', 'details');
  this.render('syms');
});

Router.route('/yc', function () {
  Session.set('route', 'details');
  this.render('yc');
});
