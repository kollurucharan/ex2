
<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">

<title>master card</title>
<h1 style="text-align: center;">master card</h1>

<div id="d">
	<center>

		<label for="m">mode</label> <input type="text" id="m">
	</center>
</div>
<style>
#d2, #d3, #d4, #d5, #d7, #d8, #d9, #d11, #d12, #13 {
	display: flex;
	justify-content: center;
	align-items: flex-end;
	height: 5vh;
}
</style>

</head>
<body>

	<center>
	
		<div id="d1">
    <div id="d2">
        <label for="l1">product id</label>
        <input type="text" id="t1">
    </div>
    <div id="d3">
        <label for="l2">product name</label>
        <input type="text" id="t2">
        <span id="productNameError" class="error"></span>
    </div>
    <div id="d4">
        <label for="l3">price</label>
        <input type="text" id="t3">
        <span id="priceError" class="error"></span>
    </div>
    <div id="d5">
        <label for="l4">quantity</label>
        <input type="text" id="t4">
        <span id="quantityError" class="error"></span>
    </div>
    <div id="d11">
        <label for="l5">Manufacturer</label>
        <input type="text" id="t11">
        <span id="manufacturerError" class="error"></span>
    </div>
    <div id="d12">
        <label for="l6">Category</label>
        <input type="text" id="t12">
        <span id="categoryError" class="error"></span>
    </div>
    <div id="d13">
        <label for="l7">Date</label>
        <input type="text" id="t13">
        <span id="dateError" class="error"></span>
    </div>
</div>

			<br> <br> <br> <br>
			<div id="d7">
				<input type="button" value="first" id="b1" onclick="first()">
				<input type="button" value="prev" id="b2" onclick="prev()">
				<input type="button" value="next" id="b3" onclick="next()">
				<input type="button" value="last" id="b4" onclick="last()">
			</div>
			<div id="d8">
				<input type="button" value="del" id="b5" onclick="del()"> <input
					type="button" value="edit" id="b6" onclick="edit()"> <input
					type="button" value="add" id="b7" onclick="add()"> <input
					type="button" value="save" id="b8" onclick="save()">
			</div>
			<div id="d9">

				<input type="button" value="exit" id="b10" onclick="exit()">

			</div>
			<
			<label for="product_name">id:</label>
			
			 <input type="text"
				id="id1" name="product_name"> 
				<label for="product_name">name:</label> 
				<input type="text"
				id="name2" name="product_name"> 
				<label
				for="product_name">quantity:</label>
				 <input type="text"
				id="quantity3" name="product_name"> 
				<label
				for="product_name">date:</label> 
				<input type="text"
				id="date4" name="product_name">
				 <input type="button"
				value="search" id="b5" onclick="search()">
	</center>



	<script>
		var current = 1;
		var length;
		var t1 = document.getElementById('t1');
		var t2 = document.getElementById('t2');
		var t3 = document.getElementById('t3');
		var t4 = document.getElementById('t4');
		var t5 = document.getElementById('t11');
		var t6 = document.getElementById('t12');

		var t7 = document.getElementById('t13');
		var m = document.getElementById('m');

		function start() {
			m.value = "read";
			var x = new XMLHttpRequest();
			var a = "start";
			var baseUrl = "http://localhost:8080/MyServlet/Exservlet";
			var urlWithParameters = baseUrl + "?img=" + a;

			x.open("GET", urlWithParameters, true);
			x.onreadystatechange = function() {
				if (x.readyState == 4 && x.status == 200) {
					var jsonData = x.responseText;

					var data = JSON.parse(jsonData);
					console.log(jsonData);

					localStorage.setItem('start', JSON.stringify(data));

				}
			};

			x.send();
		}
		start();

		var storedData = localStorage.getItem('start');
		var parsedData = JSON.parse(storedData);
		var arrayLength = parsedData.length;
		console.log("Array Length: " + arrayLength);

		function first() {
			m.value = "read1";
			var x = new XMLHttpRequest();
			var a = "first";
			current = 0;
			var baseUrl = "http://localhost:8080/MyServlet/Exservlet";
			var urlWithParameters = baseUrl + "?img=" + a;

			x.open("GET", urlWithParameters, true);
			x.onreadystatechange = function() {
				if (x.readyState == 4 && x.status == 200) {
					var jsonData = x.responseText;

					var data = JSON.parse(jsonData);

					t1.value = data.a;
					t2.value = data.b;
					t3.value = data.c;
					t4.value = data.d;
					t5.value = data.e;
					t6.value = data.f;
					t7.value = data.h;

				}
			};

			x.send();
		}
		first();

		function last() {
			m.value = "read4";
			var x = new XMLHttpRequest();
			var a = "last";
			current = arrayLength - 1;
			var baseUrl = "http://localhost:8080/MyServlet/Exservlet";
			var urlWithParameters = baseUrl + "?img=" + a;

			x.open("GET", urlWithParameters, true);
			x.onreadystatechange = function() {
				if (x.readyState == 4 && x.status == 200) {
					var jsonData = x.responseText;

					var data = JSON.parse(jsonData);

					t1.value = data.a;
					t2.value = data.b;
					t3.value = data.c;
					t4.value = data.d;
					t5.value = data.e;
					t6.value = data.f;
					t7.value = data.h;

				}
			};

			x.send();
		}

		function next() {
			m.value = "read3";
			var i = current + 1;
			var a = parsedData[i].a;
			var b = parsedData[i].b;
			var c = parsedData[i].c;
			var d = parsedData[i].d;
			var e = parsedData[i].e;
			var f = parsedData[i].f;
			var g = parsedData[i].g;

			t1.value = a;
			t2.value = b;
			t3.value = c;
			t4.value = d;
			t5.value = e;
			t6.value = f;
			t7.value = g;
			current = i;

		}
		function prev() {
			m.value = "read2";
			var i = current - 1;
			var a = parsedData[i].a;
			var b = parsedData[i].b;
			var c = parsedData[i].c;
			var d = parsedData[i].d;
			var e = parsedData[i].e;
			var f = parsedData[i].f;
			var g = parsedData[i].g;

			t1.value = a;
			t2.value = b;
			t3.value = c;
			t4.value = d;
			t5.value = e;
			t6.value = f;
			t7.value = g;
			current = i;

		}

		function del() {
			m.value = "delete1";

		}
		function add() {
			m.value = "add";
			t1.value = "";
			t2.value = "";
			t3.value = "";
			t4.value = "";
			t5.value = "";
			t6.value = "";
			t7.value = "";

		}
		function edit() {
			m.value = "edit";

		}
		function save() {
			var mode = document.getElementById('m').value;
			var a1 = document.getElementById('t1').value;
			var a2 = document.getElementById('t2').value;
			var a3 = document.getElementById('t3').value;
			var a4 = document.getElementById('t4').value;
			var a5 = document.getElementById('t11').value;
			var a6 = document.getElementById('t12').value;
			var a7 = document.getElementById('t13').value;
			console.log(mode);
			
		    var productName = document.getElementById('t2');
		    var productNameError = document.getElementById('productNameError');
		    if (productName.value.trim() === '') {
		        productNameError.textContent = 'Product Name is required';
		        return; 
		    } else {
		        productNameError.textContent = ''; 
		    }

		    
		    var price = document.getElementById('t3');
		    var priceError = document.getElementById('priceError');
		    if (isNaN(price.value)) {
		        priceError.textContent = 'Price must be a number';
		        return; 
		    } else {
		        priceError.textContent = ''; 
		    }

		  
		    var quantity = document.getElementById('t4');
		    var quantityError = document.getElementById('quantityError');
		    if (isNaN(quantity.value)) {
		        quantityError.textContent = 'Quantity must be a number';
		        return;
		    } else {
		        quantityError.textContent = ''; 
		    }

		    var manufacturer = document.getElementById('t11');
		    var manufacturerError = document.getElementById('manufacturerError');
		    if (manufacturer.value.trim() === '') {
		        manufacturerError.textContent = 'Manufacturer is required';
		        return; 
		    } else {
		        manufacturerError.textContent = ''; 
		    }

		    
		    var category = document.getElementById('t12');
		    var categoryError = document.getElementById('categoryError');
		    if (category.value.trim() === '') {
		        categoryError.textContent = 'Category is required';
		        return; 
		    } else {
		        categoryError.textContent = ''; 
		    }

		 
		    var date = document.getElementById('t13');
		    var dateError = document.getElementById('dateError');
		    if (date.value.trim() === '') {
		        dateError.textContent = 'Date is required';
		        return; 
		    } else {
		        dateError.textContent = '';
		    }


			if (mode === ("delete1")) {
				var a = "delete";
				var x = new XMLHttpRequest();
				var baseUrl = "http://localhost:8080/MyServlet/Exservlet";
				var urlWithParameters = baseUrl + "?img=" + a + "&id=" + a1;

				x.open("GET", urlWithParameters, true);
				x.onreadystatechange = function() {
					if (x.readyState == 4 && x.status == 200) {

						function showAlert() {
							alert("This is an alert box!")
						}
						;
						showAlert();
						t1.value = "";
						t2.value = "";
						t3.value = "";
						t4.value = "";
						t5.value = "";
						t6.value = "";
						t7.value = "";

					}
				};

				x.send();

			}

			else if (mode === ("add")) {

				var a = "add";
				var x = new XMLHttpRequest();
				var baseUrl = "http://localhost:8080/MyServlet/Exservlet";
				var urlWithParameters = baseUrl + "?img=" + a + "&a1=" + a1
						+ "&a2=" + a2 + "&a3=" + a3 + "&a4=" + a4 + "&a5=" + a5
						+ "&a6=" + a6 + "&a7=" + a7;
				x.open("GET", urlWithParameters, true);
				x.onreadystatechange = function() {
					if (x.readyState == 4 && x.status == 200) {

						function showAlert() {
							alert("successfully added!")
						}
						;
						showAlert();

					}
				};

				x.send();

			}

			else if (mode === ("edit")) {
				var a = "edit";
				var x = new XMLHttpRequest();
				var baseUrl = " http://localhost:8080/MyServlet/Exservlet";
				var urlWithParameters = baseUrl + "?img=" + a + "&a1=" + a1
						+ "&a2=" + a2 + "&a3=" + a3 + "&a4=" + a4 + "&a5=" + a5
						+ "&a6=" + a6 + "&a7=" + a7;
				x.open("GET", urlWithParameters, true);
				x.onreadystatechange = function() {
					if (x.readyState == 4 && x.status == 200) {

						function showAlert() {
							alert("successfully edited!")
						}
						;
						showAlert();

					}
				};

				x.send();
			}

			start();

		}
		
		
		function search(){
			
		}
		 
		
	</script>
</body>
</html>