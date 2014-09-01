var ciudades = new Array(23);
var distancias = new Array(23);
ciudades[0]  = "Buenos Aires";
ciudades[1]  = "San Salvador de Jujuy";
ciudades[2]  = "Salta";
ciudades[3]  = "San Miguel de Tucumán";
ciudades[4]  = "Santiago del Estero";
ciudades[5]  = "Formosa";
ciudades[6]  = "Resistencia";
ciudades[7]  = "Santa Fe";
ciudades[8]  = "Corrientes";
ciudades[9]  = "Posadas";
ciudades[10] = "Paraná";
ciudades[11] = "Córdoba";
ciudades[12] = "La Rioja";
ciudades[13] = "San Juan";
ciudades[14] = "San Luis";
ciudades[15] = "Catamarca";
ciudades[16] = "Mendoza";
ciudades[17] = "Santa Rosa";
ciudades[18] = "Neuquén";
ciudades[19] = "Viedma";
ciudades[20] = "Rawson";
ciudades[21] = "Rio Gallegos";
ciudades[22] = "Ushuaia";

//                0     1     2     3     4     5     6     7     8     9     10    11    12    13    14    15    16    17    18    19    20    21    22 
distancias[0]  = [0   , 1543, 1510, 1203, 1043, 1191, 1023, 478 , 940 , 1040, 480 , 715 , 1150, 1110, 790 , 1155, 1050, 620 , 1158, 960 , 1455, 2635, 3228];
distancias[1]  = [1543, 0   , 99  , 340 , 500 , 960 , 860 , 1107, 883 , 1198, 1138, 930 , 770 , 1220, 1320, 572 , 1345, 1530, 2200, 2124, 2385, 3565, 4158];
distancias[2]  = [1510, 99  , 0   , 307 , 467 , 948 , 780 , 1074, 803 , 1118, 1105, 897 , 695 , 1145, 1245, 539 , 1227, 1497, 2082, 2091, 2352, 3532, 4125];
distancias[3]  = [1203, 340 , 307 , 0   , 160 , 936 , 768 , 767 , 791 , 1106, 798 , 590 , 338 , 838 , 938 , 232 , 1005, 1190, 1860, 1784, 2045, 3225, 3818];
distancias[4]  = [1043, 500 , 467 , 160 , 0   , 776 , 610 , 607 , 633 , 948 , 638 , 430 , 360 , 810 , 850 , 212 , 977 , 1030, 1567, 1624, 1885, 3065, 3658];
distancias[5]  = [1191, 960 , 948 , 936 , 776 , 0   , 168 , 713 , 191 , 506 , 744 , 1043, 1136, 1543, 1463, 988 , 1710, 1523, 2060, 2117, 2378, 3558, 4151];
distancias[6]  = [1023, 860 , 780 , 765 , 610 , 168 , 0   , 545 , 23  , 338 , 576 , 875 , 970 , 1420, 1295, 822 , 1587, 1475, 2012, 2069, 2210, 3390, 3983];
distancias[7]  = [478 , 1107, 1074, 767 , 607 , 713 , 545 , 0   , 568 , 883 , 31  , 330 , 765 , 830 , 625 , 770 , 885 , 810 , 1347, 1404, 1665, 2845, 3438];
distancias[8]  = [940 , 883 , 803 , 791 , 633 , 191 , 23  , 568 , 0   , 315 , 590 , 898 , 993 , 1398, 1318, 845 , 1565, 1378, 1989, 2046, 2187, 3367, 3960];
distancias[9]  = [1040, 1198, 1118, 1106, 948 , 506 , 338 , 883 , 315 , 0   , 820 , 1213, 1308, 1758, 1633, 1160, 1925, 1660, 2198, 2000, 2495, 3675, 4268];
distancias[10] = [480 , 1138, 1105, 798 , 638 , 744 , 576 , 31  , 590 , 820 , 0   , 361 , 796 , 861 , 656 , 801 , 916 , 841 , 1378, 1435, 1696, 2876, 3469];
distancias[11] = [715 , 930 , 897 , 590 , 430 , 1043, 875 , 330 , 898 , 1213, 361 , 0   , 435 , 500 , 420 , 440 , 670 , 600 , 1137, 1194, 1455, 3635, 3228];
distancias[12] = [1150, 770 , 695 , 388 , 360 , 1136, 970 , 765 , 993 , 1308, 796 , 435 , 0   , 450 , 550 , 156 , 617 , 1035, 1472, 1629, 1890, 3070, 3663];
distancias[13] = [1110, 1220, 1145, 838 , 810 , 1543, 1420, 830 , 1398, 1758, 861 , 500 , 450 , 0   , 320 , 606 , 167 , 825 , 1022, 1419, 1680, 2860, 3453];
distancias[14] = [790 , 1320, 1245, 938 , 850 , 1463, 1295, 625 , 1318, 1633, 656 , 420 , 550 , 320 , 0   , 705 , 260 , 505 , 883 , 1099, 1360, 2540, 3133];
distancias[15] = [1145, 572 , 539 , 232 , 212 , 988 , 822 , 770 , 845 , 1160, 801 , 440 , 156 , 606 , 705 , 0   , 773 , 1040, 1588, 1634, 1895, 3075, 3668];
distancias[16] = [1050, 1345, 1227, 1005, 977 , 1710, 1587, 885 , 1565, 1925, 916 , 670 , 617 , 167 , 260 , 773 , 0   , 765 , 855 , 1359, 1620, 2800, 3393];
distancias[17] = [620 , 1530, 1497, 1190, 1030, 1523, 1475, 810 , 1378, 1660, 841 , 600 , 1035, 825 , 505 , 1040, 765 , 0   , 537 , 594 , 855 , 2035, 2628];
distancias[18] = [1158, 2200, 2082, 1860, 1567, 2060, 2012, 1347, 1989, 2198, 1378, 1137, 1472, 1022, 883 , 1588, 855 , 537 , 0   , 660 , 750 , 1930, 2523];
distancias[19] = [960 , 2124, 2091, 1784, 1624, 2117, 2069, 1404, 2046, 2000, 1435, 1194, 1629, 1419, 1099, 1634, 1359, 594 , 660 , 0   , 495 , 1675, 2268];
distancias[20] = [1455, 2385, 2352, 2045, 1885, 2378, 2210, 1665, 2187, 2495, 1696, 1455, 1890, 1680, 1360, 1895, 1620, 855 , 750 , 495 , 0   , 1180, 1773];
distancias[21] = [2635, 3565, 3532, 3225, 3065, 3558, 3390, 2845, 3367, 3675, 2876, 2635, 3070, 2860, 2540, 3075, 2800, 2035, 1930, 1675, 1180, 0   , 593];
distancias[22] = [3228, 4158, 4125, 3818, 3658, 4151, 3983, 3438, 3960, 4268, 3469, 3228, 3660, 3453, 3133, 3668, 3393, 2628, 2523, 2268, 1773, 593 , 0];


function listadoCiudadesHeuristica(ciudadInicioIndex, ciudadesARecorrer, dibujar) {
	dibujar = typeof dibujar !== 'undefined' ? dibujar : true;
	ciudadesRecorridas = new Array();
	indexCiudad = parseInt(ciudadInicioIndex);

	ciudadesRecorridas.push(indexCiudad);

	//mapa
	if(dibujar) {
		dibujarMapa();
		iniciarRecorrido(mapa[indexCiudad][0], mapa[indexCiudad][1]);
	}

	for(cont in ciudadesARecorrer) {
	
		distanciaMinima = 99999;
		ciudadMasCercana = null;

		for(index in ciudadesARecorrer) {

			if(!estaEn(ciudadesARecorrer[index], ciudadesRecorridas)) {
				if(indexCiudad !== ciudadesARecorrer[index]) {
					if(distancias[indexCiudad][ciudadesARecorrer[index]] < distanciaMinima) {
						distanciaMinima = distancias[indexCiudad][ciudadesARecorrer[index]];
						ciudadMasCercana = ciudadesARecorrer[index];
					}
				}
			}
		}

		ciudadesRecorridas.push(ciudadMasCercana);

		indexCiudad = ciudadMasCercana;
		
		//mapa
		if(dibujar) {
			addPuntoRecorrido(mapa[ciudadMasCercana][0], mapa[ciudadMasCercana][1], parseInt(cont)+1);
		}
	}

	//mapa
	if(dibujar) {
		dibujarRecorrido();
	}

	ciudadesRecorridas.push(ciudadInicioIndex);

	return ciudadesRecorridas; 
}

function estaEn(ciudad, arrayCiudades) {
	if(arrayCiudades.indexOf(ciudad) === -1) {
		return false;
	}
	else {
		return true;
	}
}

function calcularKilometros(recorrido) {
	km = 0;
	ciudadActual = recorrido[0];
	for(i=0; i<recorrido.length;i++) {
		km += distancias[ciudadActual][recorrido[i]];
		ciudadActual = recorrido[i];
	}

	return km;
}

function mejorCiudadInicio(ciudadesARecorrer) {
	menorKM = 99999999;
	mejorx = null;

	for(x in ciudadesARecorrer) {
		aRecorrer = ciudadesARecorrer.slice(0);
		aRecorrer.splice(aRecorrer.indexOf(ciudadesARecorrer[x]),1);
		recorrido = listadoCiudadesHeuristica(ciudadesARecorrer[x], aRecorrer, false);

		dist = calcularKilometros(recorrido);
		if(dist < menorKM) {
			menorKM = dist;
			mejorx = ciudadesARecorrer[x];
		}
	}

	return mejorx;
}
		

