// * * * populate currency table  * * * 
$(document).ready(function(){	
	
	// get user language
	var userLang = document.documentElement.lang;
	
	// currency codes
	var currencyCode=currencyCode=["THB","USD","AUD","HKD","CAD","NZD","SGD","EUR","HUF","CHF","GBP","UAH","JPY","CZK","DKK","ISK","NOK","SEK","HRK","RON","BGN","TRY","ILS","CLP","MXN","PHP","ZAR","BRL","MYR","RUB","IDR","INR","KRW","CNY","XDR"]
	
	// populate currency name array depending on user language
	var currencyName=[];
	if(userLang == "pl_PL"){		
		currencyName=["bat (Tajlandia)","dolar amerykański","dolar australijski","dolar Hongkongu","dolar kanadyjski","dolar nowozelandzki","dolar singapurski","euro","forint (Węgry)","frank szwajcarski","funt szterling","hrywna (Ukraina)","jen (Japonia)","korona czeska","korona duńska","korona islandzka","korona norweska","korona szwedzka","kuna (Chorwacja)","lej rumuński","lew (Bułgaria)","lira turecka","nowy izraelski szekel","peso chilijskie","peso meksykańskie","piso filipińskie","rand (RPA)","real (Brazylia)","ringgit (Malezja)","rubel rosyjski","rupia indonezyjska","rupia indyjska","won południowokoreański","yuan renminbi (Chiny)","SDR (MFW)"];
	} else {
		currencyName=["Thailand Bat","US Dollar","Australian Dollar","Hongkongu Dollar","Canadian Dollar","New Zealand Dollar","Singapore Dollar","Euro","Hungarian Forint","Swiss Franc","British Pound","Ukraine Hryvnia","Japanese Yen","Czech Koruna","Danish Krone","Icelandic Krona","Norwegian Krone","Swedish Krona","Croatian Kuna","Romanian Leu","Bulgarian Lev","Turkish Lira","Israeli Shekel","Chilean Peso","Mexican Peso","Philippine Peso","South Africa Rand","Brazilian Real","Malaysian Ringgit","Russian Ruble","Indonesia, Rupiah","Indian Rupee","South Korean Won","Chinese Yuan Renminbi","SDR (MFW)"];
	}

	// populate select 
	for (var i = 0; i < currencyCode.length; i++) {
        $('#first-select-list').append('<option value="' + currencyCode[i] + '">' +currencyCode[i]+' - '+ currencyName[i] + '</option>');
        $('#second-select-list').append('<option value="' + currencyCode[i] + '">' +currencyCode[i]+' - '+ currencyName[i] + '</option>');
    }
});