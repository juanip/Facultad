var POBLACION = 50;
var GENES = 23;

var cromosomas = new Array(POBLACION);

function main() {
	generarPoblacionInicial();
}

function generarPoblacionInicial(){
	arrayAux = new Array(GENES);
	for(i=0;i<POBLACION;i++){
		cromosomas[i] = new Array(GENES);
		for(j=0;j<GENES;j++){
			arrayAux[j] = j;
		}

		for(j=0;j<GENES;j++) {
			cromosomas[i][j] = parseInt((arrayAux.splice(Math.floor(Math.random() * arrayAux.length), 1)).join(""));
		}
	}

	console.table(cromosomas);
}