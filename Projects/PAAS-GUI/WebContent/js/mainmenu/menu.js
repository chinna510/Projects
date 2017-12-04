$("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("active");
});
$("#menu-toggle").click(function(e) {
	e.preventDefault();
	$("#wrapper").toggleClass("toggled");
});

/*
              version 1
$(document).ready(function () {
    $('.sidebar-nav li a').click(function(e) {

        $('.sidebar-nav li').removeClass('active');

        var $parent = $(this).parent();
        if (!$parent.hasClass('active')) {
            $parent.addClass('active');
        }
        e.preventDefault();
    });
});*/

$('.sidebar-nav a').click(function() {
	   $('.sidebar-nav a').css('background', '#ffffff');
	     $(this).css('background-color', '#FF6600');
	})