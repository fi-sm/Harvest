//Dropdown Menu
$( document ).ready(function() {
	$('#menu > ul > li > a').click(function() {
		$('#menu li').removeClass('active');
		$(this).closest('li').addClass('active'); 
		var checkElement = $(this).next();
		if((checkElement.is('ul')) && (checkElement.is(':visible'))) {
			$(this).closest('li').removeClass('active');
			checkElement.slideUp('normal');
		}
		if((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
			$('#menu ul ul:visible').slideUp('normal');
			checkElement.slideDown('normal');
		}
		if($(this).closest('li').find('ul').children().length == 0) {
			return true;
		} else {
			return false; 
		}   
	});
});


// Mobile Nav
$('#mob-nav').click(function(){
	if($('aside.open').length > 0){
		$( "aside" ).animate({left: "-250px" }, 500 ).removeClass('open');
	} else {
		$( "aside" ).animate({left: "0px" }, 500 ).addClass('open');
	}
});
//Sidebar
$(function() {
	var s = 0;
	$('.menu-toggle').click(function() {
		if (s == 0) {
			s = 1;
			$( "#sidebar" ).animate({left: "-210px"}, 100 );
			$('.dashboard-wrapper').animate({'margin-left': "0px"}, 100);
		} else {
			s = 0;
			$('#sidebar').animate({left: "0px"}, 100);
			$('.dashboard-wrapper').animate({'margin-left': "210px"}, 100);
		}
	});
});

$(function(){
	
   $("input[name=atmmon]").click(function(){
      $("div.content").not("."+this.value).hide();
      $("."+this.value).show();
   });

});
 

// Right Sidebar
$(function() {
	var r = 0;
	$('#right-bar').click(function() {
		if (r == 0) {
			r = 1;
			$( ".right-sidebar" ).css({"right": "0","display": "block","background":"#ffffff", "z-index":"100","border-left":"2px solid #e2e8f0"}, 100 );
		} else {
			r = 0;
			$('.right-sidebar').css({right: "-220px",display: "none" }, 100);
		}
		this.reset();
	});
});