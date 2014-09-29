var ciudadesARecorrer;

function crearCheckbox() {
	alternar = true;
	for(indexCiudades=0; indexCiudades<23; indexCiudades++){
		if(alternar){
			div = document.getElementById("checkboxCiudades1");
		}
		else {
			div = document.getElementById("checkboxCiudades2");
		}

		alternar = !alternar;

		chkbox = document.createElement("input");
		chkbox.type = "checkbox";
		chkbox.name = "ciudad";
		chkbox.value = indexCiudades;

		label = document.createElement("label");
		label.onclick = function() {actualizarSelect()};
		label.innerText = ciudades[indexCiudades];

		label.insertBefore(chkbox,label.firstChild);
		div.appendChild(label);
	}
}

function seleccionarCheckbox(opcion) {
	count = 2;
	div = document.getElementById("checkboxCiudades1");
	while(count > 0) {
		checkboxes = div.children;
		for(indexCheckbox = 0; indexCheckbox < checkboxes.length; indexCheckbox++){
			//label > checkbox
			checkboxes[indexCheckbox].children[0].checked = opcion;
		}

		div = document.getElementById("checkboxCiudades2");
		count--;
	}
	dibujarMapa();
}

function actualizarSelect() {
	select = document.getElementById("ciudadPartida");
	while(select.firstChild) {
		select.removeChild(select.firstChild);
	}
	
	ciudadesARecorrer = [];

	count = 2;
	div = document.getElementById("checkboxCiudades1");
	while(count > 0) {
		labels = div.children;
		for(indexLabel = 0; indexLabel < labels.length; indexLabel++){
			checkbox = labels[indexLabel].children[0];
			if(checkbox.checked){
				option = document.createElement("option");
				option.innerText = ciudades[parseInt(checkbox.value)];
				option.value = parseInt(checkbox.value);
				select.appendChild(option);

				ciudadesARecorrer.push(parseInt(checkbox.value));
			}
		}

		div = document.getElementById("checkboxCiudades2");
		count--;
	}
	actualizarMensaje();

}

function actualizarMensaje() {
	select = document.getElementById("ciudadPartida");
	selectedOption = select.options[select.selectedIndex];
	
	try{
		ciudadPartidaIndex = parseInt(selectedOption.value);
		ciudadInicio = document.getElementById("ciudadInicio");
		ciudadFin = document.getElementById("ciudadFin");
		ciudadInicio.innerHTML = ciudadFin.innerHTML = ciudades[ciudadPartidaIndex];

	}
	catch(e) {
		ciudadInicio.innerHTML = "undefined";
	}

	div = document.getElementById("mensajes");
	if(ciudadInicio.innerHTML == "undefined") {
		div.style.display = "none";
	}
	else {
		listaCiudades = document.getElementById("listaCiudades");
		while(listaCiudades.firstChild) {
			listaCiudades.removeChild(listaCiudades.firstChild);
		}

		aRecorrer = ciudadesARecorrer.slice(0);
		aRecorrer.splice(aRecorrer.indexOf(ciudadPartidaIndex),1);

		recorrido = listadoCiudadesHeuristica(ciudadPartidaIndex, aRecorrer);
		for(indexRecorrido = 1; indexRecorrido < recorrido.length - 1; indexRecorrido++) {
			li = document.createElement("li");
			li.innerHTML = indexRecorrido + ". " + ciudades[recorrido[indexRecorrido]];
			listaCiudades.appendChild(li);
		}

		kmTotal = document.getElementById("kmTotal");
		kmTotal.innerHTML = calcularKilometros(recorrido.slice(0));

		salida = new Array(2);
		salida[0] = ciudades[ciudadPartidaIndex];
		salida[1] = calcularKilometros(recorrido.slice(0));
		console.log(salida);

		//Buscar mejor
		mejorCiudadInicioIndex = mejorCiudadInicio(ciudadesARecorrer.slice(0));

		ciudadOptima = document.getElementById("ciudadOptima");
		ciudadOptima.innerHTML = ciudades[mejorCiudadInicioIndex];


		recorrido = ciudadesARecorrer.slice(0);
		recorrido.splice(recorrido.indexOf(mejorCiudadInicioIndex),1);
		recorridoOptimo = listadoCiudadesHeuristica(mejorCiudadInicioIndex, recorrido, false);
		console.log(mejorCiudadInicioIndex);
		console.log(ciudadesARecorrer);
		console.log(recorridoOptimo);
		kmOptimo = document.getElementById("kmOptimo");
		kmOptimo.innerHTML = calcularKilometros(recorridoOptimo);

		div.style.display = "block";
	}
}
