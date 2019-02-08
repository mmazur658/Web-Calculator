<%@ page pageEncoding="UTF-8"%>
<!-- META -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">  
<meta name="_csrf" content="${_csrf.token}"/>
<!-- AWESOME FONT -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
<!-- BOOTSTRAP CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<!-- MATERIAL DESIGN BOOTSTRAP -->
<link href="<%=request.getContextPath()%>/css/mdb.min.css" rel="stylesheet">
<!-- CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/scrollbar.css" rel="stylesheet">
<!-- JQUERY -->
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<!-- TOASTR -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.3/js/toastr.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.3/css/toastr.css" rel="stylesheet"/>
<!-- DATEPICKER -->
<link href="<%=request.getContextPath()%>/css/datepicker.min.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/datepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/js/i18n/datepicker.en.js"></script>
<script src="<%=request.getContextPath()%>/js/i18n/datepicker.pl.js"></script>
<!-- PRETTY CHECKBOX -->
<link href="<%=request.getContextPath()%>/css/switch-btn.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css" rel="stylesheet">
<!-- * * * * FAVICON * * * *  -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon/favicon.ico">	
<link rel="icon" sizes="16x16 32x32 64x64" href="<%=request.getContextPath()%>/img/favicon/favicon.ico">	
<link rel="icon" type="image/png" sizes="196x196" href="<%=request.getContextPath()%>/img/favicon/favicon-192.png">
<link rel="icon" type="image/png" sizes="160x160" href="<%=request.getContextPath()%>/img/favicon/favicon-160.png">
<link rel="icon" type="image/png" sizes="96x96" href="<%=request.getContextPath()%>/img/favicon/favicon-96.png">
<link rel="icon" type="image/png" sizes="64x64" href="<%=request.getContextPath()%>/img/favicon/favicon-64.png">	
<link rel="icon" type="image/png" sizes="32x32" href="<%=request.getContextPath()%>/img/favicon/favicon-32.png">
<link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath()%>/img/favicon/favicon-16.png">
<link rel="apple-touch-icon" href="<%=request.getContextPath()%>/img/favicon/favicon-57.png">
<link rel="apple-touch-icon" sizes="114x114" href="<%=request.getContextPath()%>/img/favicon/favicon-114.png">
<link rel="apple-touch-icon" sizes="72x72" href="<%=request.getContextPath()%>/img/favicon/favicon-72.png">
<link rel="apple-touch-icon" sizes="144x144" href="<%=request.getContextPath()%>/img/favicon/favicon-144.png">	
<link rel="apple-touch-icon" sizes="60x60" href="<%=request.getContextPath()%>/img/favicon/favicon-60.png">
<link rel="apple-touch-icon" sizes="120x120" href="<%=request.getContextPath()%>/img/favicon/favicon-120.png">	
<link rel="apple-touch-icon" sizes="76x76" href="<%=request.getContextPath()%>/img/favicon/favicon-76.png">	
<link rel="apple-touch-icon" sizes="152x152" href="<%=request.getContextPath()%>/img/favicon/favicon-152.png">
<link rel="apple-touch-icon" sizes="180x180" href="<%=request.getContextPath()%>/img/favicon/favicon-180.png">	
<meta name="msapplication-TileColor" content="#FFFFFF">	
<meta name="msapplication-TileImage" content="<%=request.getContextPath()%>/img/favicon/favicon-144.png">
<meta name="msapplication-config" content="<%=request.getContextPath()%>/img/favicon/browserconfig.xml">
<!-- * * * * FAVICON * * * *  -->
<!-- COOKIE ALERT -->
<script src="http://cookiealert.sruu.pl/CookieAlert-latest.min.js"></script>
<script>
CookieAlert.init({
	style: 'dark',
	position: 'top',
	opacity: '1',
	displayTime: 0,
	cookiePolicy: 'http://cookiealert.sruu.pl/o-ciasteczkach',
	text: 'Ten serwis wykorzystuje pliki cookies. Korzystanie z witryny oznacza zgodę na ich zapis lub odczyt wg ustawień przeglądarki.'
});
</script>