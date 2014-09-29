var mapa = new Array(23);

mapa[0]  = [647, 607]; 
mapa[1]  = [381, 131]; 
mapa[2]  = [376, 156]; 
mapa[3]  = [386, 248]; 
mapa[4]  = [418, 294]; 
mapa[5]  = [655, 219]; 
mapa[6]  = [626, 276]; 
mapa[7]  = [555, 455]; 
mapa[8]  = [641, 277]; 
mapa[9]  = [759, 284]; 
mapa[10] = [566, 464]; 
mapa[11] = [434, 442]; 
mapa[12] = [332, 355]; 
mapa[13] = [262, 469]; 
mapa[14] = [353, 549]; 
mapa[15] = [376, 330]; 
mapa[16] = [258, 510]; 
mapa[17] = [426, 679]; 
mapa[18] = [284, 775]; 
mapa[19] = [467, 859]; 
mapa[20] = [400, 961]; 
mapa[21] = [288, 1338];
mapa[22] = [332, 1478];

var contexto;

function dibujarMapa() {
	canvas = document.getElementById("canvas");
	contexto = canvas.getContext("2d");
	img = new Image();
	img.src = "mapa.png"
	contexto.drawImage(img,0,0);
}

function iniciarRecorrido(ciudad) {
	contexto.beginPath();
	contexto.lineWidth = "2";
	contexto.strokeStyle="red";
	contexto.font="20px Georgia";
	contexto.moveTo(mapa[ciudad][0], mapa[ciudad][1]);
	contexto.strokeText("Inicio", mapa[ciudad][0], mapa[ciudad][1]);
}

function addPuntoRecorrido(ciudad,i) {
	contexto.lineTo(mapa[ciudad][0], mapa[ciudad][1]);
	contexto.strokeText(i, mapa[ciudad][0], mapa[ciudad][1]);
}

function dibujarRecorrido() {
	contexto.stroke();
}

function dibujarRecorridoDesdeArreglo(recorrido) {
	dibujarMapa();
	
	iniciarRecorrido(recorrido[0]);

	for(i = 1; i < recorrido.length; i++) {
		addPuntoRecorrido(recorrido[i], i);
	}

	dibujarRecorrido();
}

function dibujarMejorMapa() {
	iniciarRecorrido(21);
	addPuntoRecorrido(20, 1);
	addPuntoRecorrido(19, 2);
	addPuntoRecorrido(17, 3);
	addPuntoRecorrido(0 , 4);
	addPuntoRecorrido(7 , 5);
	addPuntoRecorrido(10, 6);
	addPuntoRecorrido(9 , 7);
	addPuntoRecorrido(8 , 8);
	addPuntoRecorrido(6 , 9);
	addPuntoRecorrido(5 , 10);
	addPuntoRecorrido(1 , 11);
	addPuntoRecorrido(2 , 12);
	addPuntoRecorrido(3 , 13);
	addPuntoRecorrido(4 , 14);
	addPuntoRecorrido(15, 15);
	addPuntoRecorrido(12, 16);
	addPuntoRecorrido(11, 17);
	addPuntoRecorrido(14, 18);
	addPuntoRecorrido(13, 19);
	addPuntoRecorrido(16, 20);
	addPuntoRecorrido(18, 21);
	addPuntoRecorrido(22, 22);
	addPuntoRecorrido(21, 23);
	dibujarRecorrido();

}