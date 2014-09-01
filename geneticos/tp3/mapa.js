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

function iniciarRecorrido(x,y) {
	contexto.beginPath();
	contexto.lineWidth = "2";
	contexto.strokeStyle="red";
	contexto.font="20px Georgia";
	contexto.moveTo(x,y);
	contexto.strokeText("0",x,y);
}

function addPuntoRecorrido(x,y,i) {
	contexto.lineTo(x,y);
	contexto.strokeText(i,x,y);
}

function dibujarRecorrido() {
	contexto.stroke();
}