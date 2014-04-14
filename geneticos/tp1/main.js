var POBLATION = 10;
var GENES = 30;
var COEF = Math.pow(2,30)-1; 

var crossover;
var mutation;
var cycles;
var currentCycle;

var chromosome = new Array(POBLATION);

// currentAnalysis[x][y]: [x]>>chromosome [y]: [0]>>fObjective [1]>>fFitness [2]>>roulette
var currentAnalysis = new Array()
// bestChromosome: [0]>>generation [1]>>fObjective [2]>>fFitness [3]>>bin [4]>>dec
var bestChromosome = new Array(5);

// data[x][y]: [x]>>generation [y]: [0]>>max fObjective [1]>>min fObjective [2]>>average fObjective
var data;

function main(){
	
}

function btnPlay(){
	//interfaz
	document.getElementById("current-generation").style.display = "block";
	document.getElementById("play").disabled = true;
	document.getElementById("stop").disabled = false;
	document.getElementById("next").disabled = false;
	document.getElementById("finish").disabled = false;
	document.getElementById("crossover").disabled = true;
	document.getElementById("mutation").disabled = true;
	document.getElementById("cycles").disabled = true;
	
	initializeVars();
	generateInitialPoblation();
	analyzeCurrentGeneration();
	populateCurrentGenerationTable();
}

function btnStop(){
	//interfaz
	document.getElementById("current-generation").style.display = "none";
	document.getElementById("play").disabled = false;
	document.getElementById("stop").disabled = true;
	document.getElementById("next").disabled = true;
	document.getElementById("finish").disabled = true;	
	document.getElementById("crossover").disabled = false;
	document.getElementById("mutation").disabled = false;
	document.getElementById("cycles").disabled = false;

	cleanCurrentGenerationTable();
}

function initializeVars(){
	//inicializa arreglo de cromosomas
	for(i=0;i<POBLATION;i++){
		chromosome[i] = new Array(GENES);
	}

	//setea parametros
	crossover = document.getElementById("crossover").value;
	mutation = document.getElementById("mutation").value;
	cycles = document.getElementById("cycles").value;

	//inicializa historico de datos
	data = new Array(cycles);
	for(i=0;i<cycles;i++){
		data[i] = new Array(3);
	}

	for(i=0;i<POBLATION;i++){
		currentAnalysis[i] = new Array(3);
		for(j=0;j<3;j++){
			currentAnalysis[i][j] = 0;
		}
	}

	currentCycle = 0;
	bestChromosome[3] = new Array(GENES);
}

function generateInitialPoblation(){
	for(i=0;i<POBLATION;i++){
		for(j=0;j<GENES;j++){
			chromosome[i].push(Math.floor((Math.random()*2)));
		}
	}
}

function analyzeCurrentGeneration(){
	fObjective = new Array(POBLATION);
	fFitness = new Array(POBLATION);
	fObjectiveSum = 0;

	for(i=0;i<POBLATION;i++){
		fObjective[i] = 0;
		fFitness[i] = 0;
	}
	//guarda la funcion objetivo de todos los cromosomas
	for(i=0;i<POBLATION;i++){
		fObjective[i] = calculatefObjective(binToDec(chromosome[i]));
		currentAnalysis[i][0] = calculatefObjective(binToDec(chromosome[i]));
	}

	//suma las funciones objetivo
	for(i=0;i<POBLATION;i++){
		fObjectiveSum += fObjective[i];
	}

	//calcula el fitness de todos los cromosomas 
	for(i=0;i<POBLATION;i++){
		fFitness[i] = fObjective[i] / fObjectiveSum;
		currentAnalysis[i][1] = fFitness[i];
	}


}

function populateCurrentGenerationTable(){
	table = document.getElementById("current-generation-table");
	td = new Array(4);
	for(i=0;i<POBLATION;i++){
		tr = document.createElement("tr");
		
		for(j=0;j<4;j++){
			td[j] = document.createElement("td");

			if(j===0){
				td[j].innerText = chromosome[i].toString();
			}
			else{
				td[j].innerText = currentAnalysis[i][j];
			}

			tr.appendChild(td[j]);
		}
		

		table.appendChild(tr);
	}
}

function cleanCurrentGenerationTable(){
	table = document.getElementById("current-generation-table");
	for(i=1;i<POBLATION+1;i++){
		table.deleteRow(1);
	}
}

function calculatefObjective(x){
	x = x / COEF;
	x = Math.pow(x,2);
	return x;
}

function binToDec(chrom){
	dec = 0;
	for(i=0;i<GENES;i++){
		dec = dec + chrom[i];
	}
	return dec;
}
