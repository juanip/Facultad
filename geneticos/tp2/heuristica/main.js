var inicio = new Date();
var elementos = [[150,20],[325,40],[600,50],[805,36],[430,25],[1200,64],[770,54],[60,18],[930,46],[353,28]];
var mochilaMax = 4200;
var elementosHeuristica = new Array(10);
var elementosHeuristicaPosiciones = new Array(10);

for(i=0;i<10;i++){
	elementosHeuristica[i] = elementos[i][0] / elementos[i][1];
	elementosHeuristicaPosiciones[i] = i;
}

aux = 0;
for(i=1;i<10;i++) {
	for(j=0;j<9;j++) {
		if(elementosHeuristica[i]>elementosHeuristica[j]) {
			aux = elementosHeuristica[j];
			elementosHeuristica[j] = elementosHeuristica[i];
			elementosHeuristica[i] = aux;

			aux = elementosHeuristicaPosiciones[j];
			elementosHeuristicaPosiciones[j] = elementosHeuristicaPosiciones[i];
			elementosHeuristicaPosiciones[i] = aux;
		}
	}
}

i = 0;
volumen = 0;
valor = 0;
mochila = new Array();
while((volumen+elementos[elementosHeuristicaPosiciones[i]][0]) <= mochilaMax){
	mochila[i] = elementosHeuristicaPosiciones[i];
	volumen += elementos[elementosHeuristicaPosiciones[i]][0];
	valor += elementos[elementosHeuristicaPosiciones[i]][1];
	i++;
}
console.log("Tiempo:");
console.log(((new Date())-inicio)/1000);
console.log("Mochila");
console.log(mochila);
console.log("Valor");
console.log(valor);
console.log("Volumen");
console.log(volumen);