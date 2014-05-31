var inicio = new Date();
var elementos = [[150,20],[325,40],[600,50],[805,36],[430,25],[1200,64],[770,54],[60,18],[930,46],[353,28]];
var mochilaMax = 4200;

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

console.log("Tiempo:");
console.log(((new Date())-inicio)/1000);
console.log("Mochila");
console.log(mochilaItems[auxIndice]);
console.log("Valor");
console.log(mochilaValor[auxIndice]);
console.log("Volumen");
console.log(mochilaVolumen[auxIndice]);