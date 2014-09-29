var POBLACION = 50;
var GENES = 23;

var crossover;
var mutacion;
var ciclos;
var cicloActual;
var elitismo; //boolean

var cromosoma = new Array(POBLACION);

// var[x] [x]>>cromosoma
var fObjetivoActual = new Array(POBLACION);
var fFitnessActual = new Array(POBLACION);
var ruletaActual = new Array(POBLACION);
var ruleta;

// mejorCromosoma: [0]>>generacion [1]>>fObjetivo [2]>>fFitness [3]>>dec [4]>>bin
var mejorCromosoma = new Array(5);
//igual que mejorCromosoma, excepto [4] >> promedio fObjetive¿o en la generacion [5]>>bin
var mejorCromosomaActual = new Array(6);


function btnPlay(){
	//interfaz
	//document.getElementById("current-generation").style.display = "block";
	document.getElementById("play").disabled = true;
	document.getElementById("stop").disabled = false;
	document.getElementById("next").disabled = false;
	document.querySelector("#nextBest").disabled = false;
	document.getElementById("finish").disabled = false;
	document.getElementById("crossover").disabled = true;
	document.getElementById("mutacion").disabled = true;
	document.getElementById("ciclos").disabled = true;
	document.getElementById("canvas").style.display = "block";

	
	initVars();
	generarPoblacionInicial();
	analizarGeneracionActual();
	llenarTablaGeneracioActual();
	actualizarInfoMejorCromosomaActual();
	ActualizarInfoMejorCromosoma();
	cicloActual++;
	dibujarRecorridoDesdeArreglo(mejorCromosoma[4]);
}

function btnNext(){
	if(cicloActual < ciclos){
		limpiarTablaGeneracionActual();
		crearNuevaGeneracion();
		analizarGeneracionActual();
		llenarTablaGeneracioActual();
		actualizarInfoMejorCromosomaActual();
		ActualizarInfoMejorCromosoma();
		cicloActual++;

		if(cicloActual == ciclos){
			document.getElementById("next").disabled = true;
			document.getElementById("finish").disabled = true;
			document.querySelector("#nextBest").disabled = true;
		}
		dibujarRecorridoDesdeArreglo(mejorCromosoma[4]);
	}
	else{
		dibujarRecorridoDesdeArreglo(mejorCromosoma[4]);
		document.getElementById("next").disabled = true;
		document.getElementById("finish").disabled = true;	
		document.querySelector("#nextBest").disabled = true;
	}
}

function btnNextBest() {
	limpiarTablaGeneracionActual();

	objetivoASuperar = mejorCromosoma[1];
	flagNext = true;
	while(cicloActual < ciclos && flagNext) {
		crearNuevaGeneracion();
		analizarGeneracionActual();

		cicloActual++;

		if(mejorCromosoma[1] < objetivoASuperar) {
			flagNext = false;
		}
	}

	llenarTablaGeneracioActual();
	actualizarInfoMejorCromosomaActual();
	ActualizarInfoMejorCromosoma();
	if(cicloActual == ciclos){
		document.getElementById("next").disabled = true;
		document.getElementById("finish").disabled = true;	
		document.querySelector("#nextBest").disabled = true;
	}

	dibujarRecorridoDesdeArreglo(mejorCromosoma[4]);
}

function btnFinish(){
	for(;cicloActual<ciclos;cicloActual++){
		crearNuevaGeneracion();
		analizarGeneracionActual();
	}
	
	dibujarRecorridoDesdeArreglo(mejorCromosoma[4]);
	limpiarTablaGeneracionActual();
	llenarTablaGeneracioActual();
	actualizarInfoMejorCromosomaActual();
	ActualizarInfoMejorCromosoma();
	document.getElementById("next").disabled = true;
	document.getElementById("finish").disabled = true;	
	document.querySelector("#nextBest").disabled = true;
}

function btnStop(){
	//interfaz
	document.getElementById("play").disabled = false;
	document.getElementById("stop").disabled = true;
	document.getElementById("next").disabled = true;
	document.getElementById("finish").disabled = true;	
	document.getElementById("crossover").disabled = false;
	document.getElementById("mutacion").disabled = false;
	document.getElementById("ciclos").disabled = false;
	document.getElementById("text-current-generation").innerHTML = "Generaci&oacute;n: -";
	document.getElementById("text-current-average").innerHTML = "Promedio F. Objetivo: -";
	document.getElementById("text-current-max").innerHTML = "Valor: -";
	document.getElementById("text-best-generation").innerHTML = "Generaci&oacute;n: -";
	document.getElementById("text-best-objetive").innerHTML = "Promedio F. Objetivo: -";
	document.getElementById("text-best-decimal").innerHTML = "Valor: -";
	document.getElementById("text-best-cromosoma").innerHTML = "Cromosoma: -";
	document.getElementById("canvas").style.display = "none";
	document.querySelector("#nextBest").disabled = true;


	limpiarTablaGeneracionActual();
}

var verControles = true;
function toggleView() {
	verControles = !verControles;

	if(verControles) {
		document.querySelector("#parameters").style.display = "block";
		document.querySelector("#info").style.display = "block";
		document.querySelector("#best-info").style.display = "block";
		document.querySelector("#current-generation").style.display = "block";
		document.querySelector("#buttons").style.position = "relative";
	}
	else {
		document.querySelector("#parameters").style.display = "none";
		document.querySelector("#info").style.display = "none";
		document.querySelector("#best-info").style.display = "none";
		document.querySelector("#current-generation").style.display = "none";
		document.querySelector("#buttons").style.position = "fixed";	
	}
}

function initVars(){
	//inicializa arreglo de cromosomas
	for(i=0;i<POBLACION;i++){
		cromosoma[i] = new Array(GENES);
	}

	//setea parametros
	crossover = document.getElementById("crossover").value;
	mutacion = document.getElementById("mutacion").value;
	ciclos = document.getElementById("ciclos").value;
	elitismo = document.getElementById("elitismo").checked;

	//generacion 0
	cicloActual = 0;

	for(i=0;i<4;i++){
		mejorCromosoma[i] = 9999999;
	}
	mejorCromosoma[4] = new Array(GENES);
}


//ANDA. genera arreglos con numeros del 0 al 22 sin repetir
function generarPoblacionInicial(){
	arrayAux = new Array(GENES);
	for(i=0;i<POBLACION;i++) {

		//aux con los numeros del 0 al 22
		for(j=0;j<GENES;j++) {
			arrayAux[j] = j;
		}

		//rellenar cromosomas con el aux en orden aleatorio
		for(j=0;j<GENES;j++) {
			cromosoma[i][j] = parseInt((arrayAux.splice(Math.floor(Math.random() * arrayAux.length), 1)).join(""));
		}
	}
}


//Anda. creo.
function analizarGeneracionActual(){
	//fitness[i] = (fObjetivoPrimeraSuma - fObjetivo[i]) / (fObjetivoSegundaSuma)
	fObjetivoPrimeraSuma = 0;
	fObjetivoSegundaSuma = 0;
	auxObjetivo = new Array(POBLACION);
	minFObjetivo = 9999999;

	for(i=0;i<POBLACION;i++){
		fObjetivoActual[i] = 0;
		fFitnessActual[i] = 0;
	}

	//guarda la funcion objetivo de todos los cromosomas
	for(indexPoblacion = 0; indexPoblacion < POBLACION; indexPoblacion++){
		fObjetivoActual[indexPoblacion] = calcularFObjetivo(cromosoma[indexPoblacion].slice(0));
	}

	//funcion objetivo mas baja
	for(i = 0; i < POBLACION; i++){
		if(fObjetivoActual[i] < minFObjetivo){
			minFObjetivo = fObjetivoActual[i];
		}
	}

	//suma las funciones objetivo
	for(i = 0; i < POBLACION; i++){
		fObjetivoPrimeraSuma += fObjetivoActual[i];
	}

	for(i = 0; i < POBLACION; i++) {
		auxObjetivo[i] = fObjetivoPrimeraSuma - fObjetivoActual[i];
		fObjetivoSegundaSuma += auxObjetivo[i];
	}

	//calcula el fitness de todos los cromosomas 
	for(i = 0; i < POBLACION; i++){
		fFitnessActual[i] = auxObjetivo[i] / fObjetivoSegundaSuma;
	}

	//mejor cromosoma de la generacion
	for(i=0;i<5;i++){
		mejorCromosomaActual[i] = 0;
	}
	mejorCromosomaActual[1] = 999999;

	for(index = 0; index < POBLACION; index++){
		if(fObjetivoActual[index] < mejorCromosomaActual[1]){
			mejorCromosomaActual[0] = cicloActual;
			mejorCromosomaActual[1] = fObjetivoActual[index];
			mejorCromosomaActual[2] = fFitnessActual[index];
			//mejorCromosomaActual[3] = binToDec(cromosoma[index]);
			mejorCromosomaActual[5] = cromosoma[index]; 
		}
	}
	//promedio
	mejorCromosomaActual[4] = fObjetivoPrimeraSuma / POBLACION;

	//guarda mejor cromosoma de todas las generaciones
	if(mejorCromosomaActual[1] < mejorCromosoma[1]){
		mejorCromosoma[0] = mejorCromosomaActual[0];
		mejorCromosoma[1] = mejorCromosomaActual[1];
		mejorCromosoma[2] = mejorCromosomaActual[2];
	 	///mejorCromosoma[3] = mejorCromosomaActual[3];
		mejorCromosoma[4] = mejorCromosomaActual[5];
	}
}

function llenarTablaGeneracioActual(){
	tabla = document.getElementById("tabla-generacion-actual");
	td = new Array(3);
	for(i=0;i<POBLACION;i++){
		tr = document.createElement("tr");
		
		for(j=0;j<3;j++){
			td[j] = document.createElement("td");
			switch(j){
				case 0:	td[j].innerText = cromosoma[i].join(' ');
						break;
				case 1:	td[j].innerText = fObjetivoActual[i];
						break;
				case 2:	td[j].innerText = fFitnessActual[i];
						break;
			}

			tr.appendChild(td[j]);
		}		

		tabla.appendChild(tr);
	}
}

function actualizarInfoMejorCromosomaActual(){
	document.getElementById("text-current-generation").innerHTML = "Generaci&oacute;n: " + (mejorCromosomaActual[0] + 1);
	document.getElementById("text-current-average").innerHTML = "Promedio F. Objetivo: " + mejorCromosomaActual[4];
	document.getElementById("text-current-max").innerHTML = "Valor: " + mejorCromosomaActual[1];
}

function ActualizarInfoMejorCromosoma(){
	document.getElementById("text-best-generation").innerHTML = "Generaci&oacute;n: " + (mejorCromosoma[0] + 1);
	document.getElementById("text-best-objetive").innerHTML = "F. Objetivo: " + mejorCromosoma[1];
	document.getElementById("text-best-decimal").innerHTML = "Valor: "; //mejorCromosoma[3];
	document.getElementById("text-best-cromosoma").innerHTML = mejorCromosoma[4].join(" ");
}

function limpiarTablaGeneracionActual(){
	tabla = document.getElementById("tabla-generacion-actual");
	for(i=1;i<POBLACION+1;i++){
		tabla.deleteRow(1);
	}
}


//Anda. Calcula km del recorrido pasado (x), 
//agragando la ciudad inicial al final
function calcularFObjetivo(x){
	x[23] = x[0];
	return calcularKilometros(x);
}

//Anda. creo
function crearNuevaGeneracion(){
	armarRuleta();
	cromosomasPadres = new Array(POBLACION);

	for(i = 0; i < POBLACION; i++) {
		cromosomasPadres[i] = new Array(GENES);
	}

	//elegir padres
	for(i = 0; i < POBLACION; i++) {
		indexRuleta = Math.floor((Math.random()*100));
		cromosomasPadres[i] = cromosoma[ruleta[indexRuleta]];
	}

	if(elitismo) {
		nacimientosElitistas(cromosomasPadres);
	}
	else {
		nacimientos(cromosomasPadres);
	}
	
}

function nacimientos(cromosomasPadres) {
	for(indexChrom = 0; indexChrom < POBLACION/2; indexChrom++) {
		//crossover
		if(Math.floor(Math.random()*100) < crossover) {
			cromosomasHijos = doCrossover(cromosomasPadres[indexChrom*2],cromosomasPadres[indexChrom*2+1]);
		}
		else {
			cromosomasHijos = cromosomasPadres[indexChrom*2].concat(cromosomasPadres[indexChrom*2+1]);
		}

		//mutacion primer hijo
		if(Math.floor(Math.random()*100) < mutacion) {
			cromosoma[indexChrom*2] = hacerMutacion(cromosomasHijos.slice(0,GENES));
		}
		else {
			cromosoma[indexChrom*2] = cromosomasHijos.slice(0,GENES);				
		}

		//mutacion segundo hijo
		if(Math.floor(Math.random()*100) < mutacion) {
			cromosoma[indexChrom*2+1] = hacerMutacion(cromosomasHijos.slice(GENES,GENES*2));
		}
		else {
			cromosoma[indexChrom*2+1] = cromosomasHijos.slice(GENES,GENES*2);				
		}
	}
}

function nacimientosElitistas(cromosomasPadres) {
	cromosomasOrdenados = ordenarCromosomas();

	//los cuatro mejores cromosomas pasan intactos a la prox generacion
	for(i = 0; i < 4; i++) {
		cromosoma[i] = cromosomasOrdenados[i];
	}
		
	for(indexChrom=4;indexChrom<POBLACION/2;indexChrom++) {
		//crossover
		if(Math.floor(Math.random()*100) < crossover) {
			cromosomasHijos = doCrossover(cromosomasPadres[indexChrom*2],cromosomasPadres[indexChrom*2+1]);
		}
		else {
			cromosomasHijos = cromosomasPadres[indexChrom*2].concat(cromosomasPadres[indexChrom*2+1]);
		}

		//mutacion primer hijo
		if(Math.floor(Math.random()*100) < mutacion) {
			cromosoma[indexChrom*2] = hacerMutacion(cromosomasHijos.slice(0,GENES));
		}
		else {
			cromosoma[indexChrom*2] = cromosomasHijos.slice(0,GENES);				
		}

		//mutacion segundo hijo
		if(Math.floor(Math.random()*100) < mutacion) {
			cromosoma[indexChrom*2+1] = hacerMutacion(cromosomasHijos.slice(GENES,GENES*2));
		}
		else {
			cromosoma[indexChrom*2+1] = cromosomasHijos.slice(GENES,GENES*2);				
		}
	}
}

function ordenarCromosomas() {
	cromosomaAux = cromosoma;
	cromosomaFObj = new Array(POBLACION);

	for(indexChrom = 0; indexChrom < POBLACION; indexChrom++) {
		cromosomaFObj[indexChrom] = calcularFObjetivo(cromosomaAux[indexChrom].slice(0));
	}

	auxCrom = "";
	aux = 0;
	for(i = 1; i < (POBLACION - 1); i++) {
		for(j = 0; j < POBLACION; j++) {
			if(cromosomaFObj[j] > cromosomaFObj[j+1]) {
				auxCrom = cromosomaAux[j];
				cromosomaAux[j] = cromosomaAux[j+1];
				cromosomaAux[j+1] = auxCrom;

				aux = cromosomaFObj[j];
				cromosomaFObj[j] = cromosomaFObj[j+1];
				cromosomaFObj[j+1] = aux;
			}
		}
	}
	return cromosomaAux;
}


function armarRuleta() {
	ruletaSuma = 0;
	
	for(i=0;i<POBLACION;i++){
		ruletaActual[i] = Math.ceil(fFitnessActual[i] * 100);
		if(ruletaActual[i]===0) ruletaActual[i] = 1;
		ruletaSuma += ruletaActual[i];
	}

	ruletaAux = new Array(ruletaSuma);

	indexRuleta = 0;
	for(i=0;i<POBLACION;i++){
		j = 0;
		while(j < ruletaActual[i]){
			ruletaAux[indexRuleta] = i;
			j++;
			indexRuleta++;
		}
	}

	masacre = 100 - ruletaSuma;

	for(i=0;i<masacre;i++) {
		indice = Math.floor((Math.random()*ruletaSuma)+1);
		ruletaAux[indice] = "no";
	}

	ruleta = new Array(100);
	indiceRuleta = 0;
	for(i=0;i<ruletaSuma;i++) {
		if(ruletaAux[i]!=="no") {
			ruleta[indiceRuleta] = ruletaAux[i];
			indiceRuleta++;
		}
	}

	return 100;
}


//anda
//devuelve un Array[GENES*2] con los dos hijos
function doCrossover(primerPadre, segundoPadre){
	primerHijo = new Array(GENES);
	segundoHijo = new Array(GENES);

//	alert(primerPadre + "\n" + segundoPadre);

	for(i = 0; i < GENES; i++) {
		primerHijo[i]  = -1;
		segundoHijo[i] = -1;
	}

	//donde arranca el crossover ciclico
	iCorte = Math.floor((Math.random()*GENES));
	
	iCambio = iCorte;;

	flag = true;
	while(flag) {
		primerHijo[iCambio]  = primerPadre[iCambio];
		segundoHijo[iCambio] = segundoPadre[iCambio];

		valorSiguiente = segundoPadre[iCambio];

		for(i = 0; i < GENES; i++) {
			if(valorSiguiente == primerPadre[i]) {
				iCambio = i;
				break;
			}
		}

		if(iCambio === iCorte) {
			flag = false;
		}
	}

	for(i = 0; i < GENES; i++) {
		if(primerHijo[i] === -1) {
			primerHijo[i] = segundoPadre[i];
		}

		if(segundoHijo[i] === -1) {
			segundoHijo[i] = primerPadre[i];
		}
	}

	return primerHijo.concat(segundoHijo);
}

//devuelve un Array[GENES] con el hijo mutado
function hacerMutacion(cromosomaHijo){
	randomGEN1 = Math.floor((Math.random() * GENES));
	randomGEN2 = Math.floor((Math.random() * GENES));
	
	if(randomGEN1 !== randomGEN2) {
		auxGen = cromosomaHijo[randomGEN1];
		cromosomaHijo[randomGEN1] = cromosomaHijo[randomGEN2];
		cromosomaHijo[randomGEN2] = auxGen;
	}

	return cromosomaHijo;
}