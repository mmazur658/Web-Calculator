<%@ page pageEncoding="UTF-8"%>

<!-- JQUERY -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<!-- BOOTSTRAP TOOLTIPS -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/popper.min.js"></script>
<!-- BOOTSTRAP CORE JAVASCRIPT -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<!-- SMOOTH SCROLL -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/smooth-scroll/14.2.1/smooth-scroll.min.js" integrity="sha256-MhIEydYjM8X/lfw31uxgXHB5BCo+bQX6BmFJYmzty7w=" crossorigin="anonymous"></script>
<!-- MATERIAL DESIGN BOOTSTRAP CODE JAVASCRIPT -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/mdb.min.js"></script>
<!-- ALERTS -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/show-alert.js"></script>
<!-- INITIALIZE MD BOOTSTRAP ANIMATION -->
<script>	new WOW().init();	</script>
<!-- ACTIVATE SMOOTH SCROLL -->
<script>	
var scroll = new SmoothScroll('a[href*="#"]',{
		offset: 75
});
</script>
<!-- REMOVE FADE-OUT CLASS FROM BODY -->
<script>
$(function() {
    $('body').removeClass('fade-out');
});
</script>