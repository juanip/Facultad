var POBLATION = 10;
var GENES = 30;
var COEF = Math.pow(2,30)-1;
//precalculated powers of 2
var POWS = new Array(GENES);

var crossover;
var mutation;
var cycles;
var currentCycle;

var chromosome = new Array(POBLATION);

// currentX[x] [x]>>chromosome
var currentObjective = new Array(POBLATION);
var currentFitness = new Array(POBLATION);
var currentRoulette = new Array(POBLATION);

// bestChromosome: [0]>>generation [1]>>fObjective [2]>>fFitness [3]>>bin [4]>>dec
var bestChromosome = new Array(5);

// data[x][y]: [x]>>generation [y]: [0]>>max fObjective [1]>>min fObjective [2]>>average fObjective
var data;

function btnFinish(){
	alert(Math.floor(Math.random()));
}

function main(){
	//initialize POWS
	for(i=0;i<GENES;i++){
		POWS[i] = Math.pow(2,i);
	}
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

function btnNext(){
		generateNewGeneration();
		currentCycle++;
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

	currentCycle = 0;
	bestChromosome[3] = new Array(GENES);
}

function generateInitialPoblation(){
	for(i=0;i<POBLATION;i++){
		for(j=0;j<GENES;j++){
			chromosome[i][j] = Math.floor((Math.random()*2)) ? '1' : '0';
		}
	}
}

function analyzeCurrentGeneration(){
	fObjectiveSum = 0;

	for(i=0;i<POBLATION;i++){
		currentObjective[i] = 0;
		currentFitness[i] = 0;
	}
	//guarda la funcion objetivo de todos los cromosomas
	decimal = 0;
	for(index=0;index<POBLATION;index++){
		decimal = binToDec(chromosome[index]);
		currentObjective[index] = calculatefObjective(decimal);
	}

	//suma las funciones objetivo
	for(i=0;i<POBLATION;i++){
		fObjectiveSum += currentObjective[i];
	}

	//calcula el fitness de todos los cromosomas 
	for(i=0;i<POBLATION;i++){
		currentFitness[i] = currentObjective[i] / fObjectiveSum;
	}

	for(i=0;i<POBLATION;i++){
		currentRoulette[i] = Math.round(currentFitness[i] * 100);
	}


}

function populateCurrentGenerationTable(){
	table = document.getElementById("current-generation-table");
	td = new Array(4);
	for(i=0;i<POBLATION;i++){
		tr = document.createElement("tr");
		
		for(j=0;j<4;j++){
			td[j] = document.createElement("td");
			switch(j){
				case 0:	td[j].innerText = chromosome[i].toString();
						break;
				case 1:	td[j].innerText = currentObjective[i];
						break;
				case 2:	td[j].innerText = currentFitness[i];
						break;
				case 3:	td[j].innerText = currentRoulette[i];
						break;
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
	indexPow = 0;
	for(indexChrom = GENES-1;indexChrom>=0;indexChrom--){
		dec = dec + (parseInt(chrom[indexChrom]) * POWS[indexPow]);
		indexPow++;
	}
	return dec;
}

function generateNewGeneration(){
	rouletteSum = 0;
	for(i=0;i<POBLATION;i++){
		rouletteSum = rouletteSum + currentRoulette[i];
	}

	roulette = new Array(rouletteSum);

	indexRoulette = 0;
	for(i=0;i<POBLATION;i++){
		j = 0;
		while(j < currentRoulette[i]){
			roulette[indexRoulette] = i;
			j++;
			indexRoulette++;
		}
	}

	parentChromosome = new Array(POBLATION);
	for(i=0;i<POBLATION;i++){
		parentChromosome[i] = new Array(GENES);
	}

	for(i=0;i<POBLATION;i++){
		Math.floor((Math.random()*2));
	}
}