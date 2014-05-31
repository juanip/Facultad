var elementos = [[150,20],[325,40],[600,50],[805,36],[430,25],[1200,64],[770,54],[60,18],[930,46],[353,28]];
var mochilaMax = 4200;
var elementosHeuristica = new Array(10);

for(i=0;i<10;i++){
	elementosHeuristica[i] = elementos[i][0] / elementos[i][1];
}
alert(elementosHeuristica);

Math.sort()