<!-- BASIC CALCULATOR -->
<!-- CALCULATOR BODY -->
<table id="table-id" class="bg-blue"  align="center" cellpadding="3"  style="border: 40px solid black;   border-radius: 40px;   overflow: hidden;   transition: all .5s linear;">
	<tr>
		<td  colspan="5"class=""> <input id="screen-input" class="form-control form-control-lg shadow text-right calc-input" type="text" placeholder="0"></td>
	<tr>	
	<tr>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="back"><img class="mb-1" src="/font/calculator/left-arrow.png" height="22px" width="22px" ></img></button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="CE">CE</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="C">C</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="+/-"><img class="mb-1" src="/font/calculator/plus-minus.png" height="22px" width="22px"></img></button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="squareroot"><img class="mb-1" src="/font/calculator/square-root.png" height="22px" width="22px"></img></button></td>						
	</tr>					
	<tr>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="7">7</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="8">8</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="9">9</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="/">/</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="%">%</button></td>
	</tr>						
	<tr>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="4">4</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="5">5</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="6">6</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="*">*</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="1/x"><img class="mb-1" src="/font/calculator/1-x-font.png" height="22px" width="32px" ></img></button></td>
	</tr>						
	<tr>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="1">1</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="2">2</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="3">3</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="-">-</button></td>
		<td rowspan="2" ><button type="button" class="calc-btn btn btn-block " value="=" style="padding-top:45% ;padding-bottom:45% ; background-color: #E04B26; height: 100%;">=</button></td>
	</tr>						
	<tr>
		<td colspan="2"><button type="button" class="calc-btn btn btn-warning btn-block " value="0" style="width:100%;">0</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value=".">.</button></td>
		<td><button type="button" class="calc-btn btn btn-warning btn-block " value="+">+</button></td>
	</tr>
</table>
<!-- CALCULATOR BODY -->
<!-- CALCULATOR SCRIPT -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/calculator.js"></script>
<!-- CALCULATOR SCRIPT -->
<!-- BASIC CALCULATOR -->