
var instituciones = Object();
instituciones['Instituciones'] = 'ARMADA|EJÉRCITO|FUERZA AÉREA';

var categorias = Object();
categorias['ARMADA'] = 'OFICIAL (A)|GENTE DE MAR (A)|EMPLEADO CIVIL (A)';
categorias['EJÉRCITO'] = 'OFICIAL (E)|CUADRO PERMANENTE (E)|EMPLEADO CIVIL (E)';
categorias['FUERZA AÉREA'] = 'OFICIAL (FA)|CUADRO PERMANENTE (FA)|EMPLEADO CIVIL (FA)';

var grados = Object();
grados['OFICIAL (A)'] = 'ALMIRANTE|VICEALMIRANTE|CONTRALMIRANTE|CAPITÁN DE NAVIO|CAPITÁN DE FRAGATA|CAPITÁN DE CORBETA|TENIENTE 1°|TENIENTE 2°|SUBTENIENTE|GUARDIAMARINA';
grados['GENTE DE MAR (A)'] = 'SUBOFICIAL MAYOR|SUBOFICIAL|SARGENTO 1°|SARGENTO 2°|CABO 1°|CABO 2°|MARINERO 1° Y SOLDADO 1°';
grados['OFICIAL (E)'] = 'GENERAL DE EJÉRCITO|GENERAL DE DIVISIÓN|GENERAL DE BRIGADA|CORONEL|TENIENTE CORONEL|MAYOR|CAPITÁN|TENIENTE|SUBTENIENTE|ALFÉREZ';
grados['CUADRO PERMANENTE (E)'] = 'SUBOFICIAL MAYOR|SUBOFICIAL|SARGENTO 1°|SARGENTO 2°|CABO 1°|CABO 2°|CABO';
grados['OFICIAL (FA)'] = 'GENERAL DEL AIRE|GENERAL DE AVIACIÓN|GENERAL DE BRIGADA AÉREA|CORONEL DE AVIACIÓN|COMANDANTE DE GRUPO|COMANDANTE DE ESCUADRILLA|CAPITÁN DE BANDADA|TENIENTE|SUB-TENIENTE|ALFÉREZ';
grados['CUADRO PERMANENTE (FA)'] = 'SUBOFICIAL MAYOR|SUBOFICIAL|SARGENTO 1°|SARGENTO 2°|CABO 1°|CABO 2°|CABO';

var listaSimple = Object();
listaSimple['Grados jerarquicos'] = '1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20';
listaSimple['Grados economicos'] = '1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20';
listaSimple['Planilla Supl 19699'] = '1|2|3|4|5|6|7|8|9|10|11|12|13|14';
listaSimple['Planilla Supl DFL1'] = '1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20';
listaSimple['Instituciones'] = 'Armada|Asmar|Carabineros|Central Nacional de Inteligencia|Chile Deportes|D.G.TT.MM. Y MM.|DGAC|Digeder|Dipreca|Dirección General de Movilización Nacional|Ejército|Enaer|Estado Mayor ConyuntoFACH|Famae|Gendarmeria|Hospital Fach|Investigaciones|Subsecrataría de Defensa|Subsecretaría para las Fuerzas Armadas';
listaSimple['Abonos'] = 'Abono por hijos|Abono por Viudez|Abono por Lesiones|Abono Rama Aire|Abono por Radiación|Abono Zona Antartica o Aislamiento|Administradora de Fondos de Pensiones|Caja de OO.MM.|Caja de EE.MM.|Caja Nac. de la Marina Merc.|Caja de Prev. de la Hipica Nac.|Canaempu|Capremer|Carabineros de Chile|Dipreca|Empart|Ferrocarriles del Estado|Gendarmeria de Chile|Investigaciones de Chile|Servicio de Seguro Social|Triomar|Otros';
listaSimple['Concurrencias'] = 'Caja de OO.MM.|Caja de EE.MM.|Caja Nac. de la Marina Merc.|Caja de Prev. de la Hipica Nac.|Canaempu|Capremer|Carabineros de Chile|Dipreca|Empart|Ferrocarriles del Estado|Gendarmeria de Chile|Investigaciones de Chile|Servicio de Seguro Social|Triomar|Otros';


var listaValorLabel = Object();
listaValorLabel['Escalafon civil'] = 'Adm.&ADMINISTRATIVO|Aux.&AUXILIAR|Direc.&DIRECTIVO|Prof.&PROFESIONAL|Tec.&TÉCNICO';
listaValorLabel['Sobresueldos'] = '0&0%|17&17%|18&18%|19&19%|20&20%|21&21%|22&22%|23&23%|24&24%|25&25%|26&26%|27&27%|28&28%|29&29%|30&30%|35&35%|65&65%';
listaValorLabel['Segundo sobresueldo'] = '0&0%|17&17%|18&18%|19&19%|20&20%|21&21%|22&22%|23&23%|24&24%|25&25%|26&26%|27&27%|28&28%|29&29%|30&30%|35&35%|65&65%';
listaValorLabel['Asignacion SOFSOM'] = '35%&SUBOFICIAL MAYOR|30%&SUBOFICIAL +30 AÑOS|25%&SUBOFICIAL -30 AÑOS';


function cargarLista(nombreLista) {
    var array = listaSimple[nombreLista].split('|');

    for (var i = 0; i < array.length; i++)
        document.write('<option value="' + array[i] + '">' + array[i] + '</option>');
}

function cargarListaValorCorrelativo(nombreLista) {
    var array = listaSimple[nombreLista].split('|');

    for (var i = 0; i < array.length; i++)
        document.write('<option value="' + i+1 + '">' + array[i] + '</option>');
}

function cargarListaValor(nombreLista) {
    var items = listaValorLabel[nombreLista].split('|');

    for (var i = 0; i < items.length; i++) {
        var item = items[i].split('&');
        document.write('<option value="' + item[0] + '">' + item[1] + '</option>');
    }
}

function setInstituciones() {
    var institucionesArray = instituciones["Instituciones"].split('|');

    for (var i = 0; i < institucionesArray.length; i++)
        document.write('<option value="' + i + '">' + institucionesArray[i] + '</option>');
}

function setCategorias(oSelectInstitucion, oSelectCategoria, oSelectGrado) {
    var categoriaArr;
    oSelectCategoria.length = 0;
    oSelectGrado.length = 0;
    var institucion = oSelectInstitucion.options[oSelectInstitucion.selectedIndex].text;
    if (categorias[institucion]) {                
        oSelectCategoria.options[0] = new Option('[SELECCIONE]', '-1');
        categoriaArr = categorias[institucion].split('|');
        for (var i = 0; i < categoriaArr.length; i++)
            oSelectCategoria.options[i + 1] = new Option(categoriaArr[i], i + 1);


        $('select[name=' + oSelectCategoria.name + ']').combobox('value', '-1');
        oSelectGrado.options[0] = new Option('[SELECCIONE]', '-1');
        $('select[name=' + oSelectGrado.name + ']').combobox('value', '-1');
    }
    else oSelectCategoria.disabled = true;
}

function setGrado(oSelectCategoria, oSelectGrado)
{
	var gradoArr;
	oSelectGrado.length = 0;
	var categoria = oSelectCategoria.options[oSelectCategoria.selectedIndex].text;
	if (grados[categoria])
	{
		oSelectGrado.options[0] = new Option('[SELECCIONE]', '-1');
		gradoArr = grados[categoria].split('|');
		for (var i = 0; i < gradoArr.length; i++)
		    oSelectGrado.options[i + 1] = new Option(gradoArr[i], i + 1);

		$('select[name=' + oSelectGrado.name + ']').combobox('value', '-1');
	}
	else oSelectGrado.disabled = true;
}
