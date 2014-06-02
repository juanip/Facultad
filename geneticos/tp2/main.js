var elementos;
var mochilaMax;

function iniciar() {
	elementos = [[150,20],[325,40],[600,50],[805,36],[430,25],[1200,64],[770,54],[60,18],[930,46],[353,28]];
	mochilaMax = 4200;
}

function exhaustiva() {
	document.getElementById('mensaje').style.display = 'block';
	setTimeout(function(){doExhaustiva()},0);	
}

function doExhaustiva() {
	var inicio = new Date();
	
	var mochilaItems = new Array();
	var mochilaVolumen = new Array();
	var mochilaValor = new Array();
	var valores = new Array(10);
	
	aux = 0;
	for(i=0;i<10;i++){
		valores[0] = i;
		for(j=0;j<10;j++){
			if(j==i) continue;
			valores[1] = j;
			for(k=0;k<10;k++){
				if(k==j|k==i) continue;
				valores[2] = k;
				for(l=0;l<10;l++){
					if(l==k|l==j|l==i) continue;
					valores[3] = l;
					for(m=0;m<10;m++){
						if(m==k|m==j|m==i|m==l) continue;
						valores[4] = m;
						for(n=0;n<10;n++){
							if(n==k|n==j|n==i|n==l|n==m) continue;
							valores[5] = n;
							for(o=0;o<10;o++){
								if(o==k|o==j|o==i|o==l|o==m|o==n) continue;
								valores[6] = o;
								for(p=0;p<10;p++){
									if(p==k|p==j|p==i|p==l|p==m|p==n|p==o) continue;
									valores[7] = p;
									for(q=0;q<10;q++){
										if(q==k|q==j|q==i|q==l|q==m|q==n|q==o|q==p) continue;
										valores[8] = q;
										for(r=0;r<10;r++){
											if(r==k|r==j|r==i|r==l|r==m|r==n|r==o|r==p|r==q) continue;
											valores[9] = r;
											mochilaVolumen[aux] = 0;
											cont = 0;
											mochilaValor[aux] = 0;
											mochilaItems[aux] = "";
											while((mochilaVolumen[aux]+elementos[valores[cont]][0]) <= mochilaMax){
												mochilaValor[aux] += elementos[valores[cont]][1];
												mochilaVolumen[aux] += elementos[valores[cont]][0];
												mochilaItems[aux] += (valores[cont]+' ');
												cont++;
											}
											aux++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	aux = 0;
	auxIndice = 0;
	for(i=0;i<mochilaValor.length;i++){
		if(aux < mochilaValor[i]){
			aux = mochilaValor[i];
			auxIndice = i;
		}
	}
	document.getElementById('mensaje').style.display = 'none';
	document.getElementById('pexhaustiva').style.display = 'block';

	console.log("Tiempo:");
	console.log(((new Date())-inicio)/1000);
	console.log("Mochila");
	console.log(mochilaItems[auxIndice]);
	console.log("Valor");
	console.log(mochilaValor[auxIndice]);
	console.log("Volumen");
	console.log(mochilaVolumen[auxIndice]);

	document.getElementById('exhaustiva-elementos').innerHTML = mochilaItems[auxIndice]; 
	document.getElementById('exhaustiva-valor').innerHTML = mochilaValor[auxIndice];
	document.getElementById('exhaustiva-volumen').innerHTML = mochilaVolumen[auxIndice];
}

function heuristica() {
	var inicio = new Date();
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

	document.getElementById('pheuristica').style.display = 'block';

	document.getElementById('heuristica-elementos').innerHTML = mochila.join(" "); 
	document.getElementById('heuristica-valor').innerHTML = valor;
	document.getElementById('heuristica-volumen').innerHTML = volumen;
}