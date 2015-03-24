// Archivo JScript

var numFilaAeliminar = -1; 

var icons = {
    header: "ui-icon-circle-arrow-e",
    headerSelected: "ui-icon-circle-arrow-s"
};

var dialogAbono,
    tipoAbono = $("#sltTipoAbono"),
    aniosAbono = $("#tiAniosAbono"),
    mesesAbono = $("#tiMesesAbono"),
    diasAbono = $("#tiDiasAbono"),
    abonoAllFields = $([]).add(tipoAbono)
                            .add(aniosAbono)
                            .add(mesesAbono)
                            .add(diasAbono);
var dialogConcurrencia,
    tipoConcurrencia = $("#sltTipoConcurrencia"),
    aniosConcurrencia = $("#tiAniosConcurrencia"),
    mesesConcurrencia = $("#tiMesesConcurrencia"),
    diasConcurrencia = $("#tiDiasConcurrencia"),
    concurrenciaAllFields = $([]).add(tipoConcurrencia)
                            .add(aniosConcurrencia)
                            .add(mesesConcurrencia)
                            .add(diasConcurrencia);

var dialogOtraInstitucion,
    otraInstitucion = $("#sltOtraInstitucion"),
    otraInstitucionAllFields = $([]).add(otraInstitucion);

var jsonAbonos, jsonConcurrencias, jsonInstituciones;

$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);

// inicio del document ready
$(document).ready(function () {



    //agrega icono al boton
    $("#bttSalir").button({
        text: true,
        icons: {
            primary: "ui-icon-extlink",
            secundary: "ui-icon-triangle-1-s"
        }
    });

    $("#btt_Cerrar_about").button({
        text: true,
        icons: {
            primary: "ui-icon-close"
        }
    });

    $("#footer a").on("click", function () {
        $.blockUI({ onOverlayClick: $.unblockUI, message: $('#about') });
    });


    $('#bttSalir').on("click", function (evento) {
        CerrarMiSession();
    });


    //cerrar about
    $('#btt_Cerrar_about').on("click", function (evento) {
        $.unblockUI();
        return false;
    });

    /*----------------------------------------------------------------*/
    /*----------------------------NUEVO-------------------------------*/
    /*----------------------------------------------------------------*/

    $(".combobox").combobox();
    $("#tabs").tabs({
        collapsible: true
    });


    $("#celdaCantidadDeAcciones").hide();
    $("#celdaTipoDeAcciones").hide();
    $("#celdaGradoJerarquico").hide();
    $("#celdaEscalafonCivil").hide();
    $("#celdaGrado").hide();
    $("#celdaEsDeLinea").hide();
    $("#celdaSueldoMinistroDeCorte").hide();

    $('input[name=poseeAcciones]:radio').on("change", function () {
        actualizarAcciones(this);
    });


    $('#celdaCategoria > .ui-combobox > .ui-combobox-input').on("focusout", function () {
        mostrarGrado(this);
    });

    $('#celdaGrado > .ui-combobox > .ui-combobox-input').on("focusout", function () {
        mostrarEsDeLinea(this);
    });

    $('input[name=esMinistroDeCorte]:radio').on("change", function () {
        mostrarSueldoMinistroDeCorte(this);
    });


    $(".numerico").keydown(function (e) {
        restringirNumerico(e);
    });

    $(".numerico").on("keyup", function (e) {
        var elemento = $('input[name=' + this.name + ']:input');

        var valor = e.target.value;
        darFormatoDeMiles(elemento, valor);
    });


    $('#tiRun').Rut({
        on_error: function () {
            limpiarRun($('#tiRun'));
        },
        format_on: 'keyup'
    });

    $(".datepicker").datepicker({
        changeMonth: true,
        changeYear: true,
        showOn: "button",
        buttonImage: "img/calendar.png",
        buttonImageOnly: true,
        buttonText: "Seleccione una fecha",
        closeText: "Listo",
        prevText: "Anterior",
        nextText: "Siguiente",
        currentText: "Hoy",
        monthNames: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
        monthNamesShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"],
        dayNames: ["Domingo", "Lunes", "Martes", "Mi\u00E9rcoles", "Jueves", "Viernes", "S\u00E1bado"],
        dayNamesShort: ["Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"],
        dayNamesMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
        weekHeader: "Se",
        dateFormat: "dd/mm/yy"
    });


    dialogAbono = $("#dialog-abono").dialog({
        autoOpen: false,
        height: 300,
        width: 500,
        modal: true,
        buttons: [
            {
                text: "Agregar",
                name: "btnAgregar",
                click: function () {
                    $("#sltTipoAbono,#tiAniosAbono,#tiMesesAbono,#tiDiasAbono").removeClass("ui-state-error");
                    agregarFila("Abono");
                }
            },
            {
                text: "Cerrar",
                name: "btnCerrar",
                click: function () { dialogAbono.dialog("close"); }
            }
        ],
        open: function () {
            var dialog = dialogAbono.parent();
            dialog
                .find("button[name='btnAgregar']")
                .button({ icons: { primary: "ui-icon-disk"} });
            dialog
                .find("button[name='btnCerrar']")
                .button({ icons: { primary: "ui-icon-close"} });
        },

        close: function () {
            dialogAbono
                .find('.validateTips')
                .text('Ingrese datos:');
            formAbono[0].reset();
            $("#sltTipoAbono,#tiAniosAbono,#tiMesesAbono,#tiDiasAbono").removeClass("ui-state-error");
            /* if(vData.estado.toString()=="0"){dialogFunc.dialog( "open" );}*/
        }
    });

    formAbono = dialogAbono.find("form").on("submit", function (event) {
        event.preventDefault();
    });

    $('#btnNuevoAbono').on("click", function (evento) {

        var $tips = $('#dialog-abono .validateTips');
        dialogAbono
            .dialog({ title: 'Nuevo abono' })
            .dialog("open");
        $tips.text('Todos los datos son obligatorios.');
        $('#sltTipoAbono').focus();
        numFilaAeliminar = -1;
    });


    $("#btnNuevoAbono").button({
        text: true,
        icons: {
            primary: "ui-icon-plusthick"
        }
    });

    dialogConcurrencia = $("#dialog-concurrencia").dialog({
        autoOpen: false,
        height: 300,
        width: 500,
        modal: true,
        buttons: [
            {
                text: "Agregar",
                name: "btnAgregar",
                click: function () {
                    $("#sltTipoConcurrencia,#tiAniosConcurrencia,#tiMesesConcurrencia,#tiDiasConcurrencia").removeClass("ui-state-error");
                    agregarFila("Concurrencia");
                }
            },
            {
                text: "Cerrar",
                name: "btnCerrar",
                click: function () { dialogConcurrencia.dialog("close"); }
            }
        ],
        open: function () {
            var dialog = dialogConcurrencia.parent();
            dialog
                .find("button[name='btnAgregar']")
                .button({ icons: { primary: "ui-icon-disk"} });
            dialog
                .find("button[name='btnCerrar']")
                .button({ icons: { primary: "ui-icon-close"} });
        },

        close: function () {
            dialogConcurrencia
                .find('.validateTips')
                .text('Ingrese datos:');
            formConcurrencia[0].reset();
            $("#sltTipoConcurrencia,#tiAniosConcurrencia,#tiMesesConcurrencia,#tiDiasConcurrencia").removeClass("ui-state-error");
            /* if(vData.estado.toString()=="0"){dialogFunc.dialog( "open" );}*/
        }
    });

    formConcurrencia = dialogConcurrencia.find("form").on("submit", function (event) {
        event.preventDefault();
    });

    $('#btnNuevaConcurrencia').on("click", function (evento) {

        var $tips = $('#dialog-concurrencia .validateTips');
        dialogConcurrencia
            .dialog({ title: 'Nueva concurrencia' })
            .dialog("open");
        $tips.text('Todos los datos son obligatorios.');
        $('#sltTipoConcurrencia').focus();
        numFilaAeliminar = -1;
    });


    $("#btnNuevaConcurrencia").button({
        text: true,
        icons: {
            primary: "ui-icon-plusthick"
        }
    });


    dialogOtraInstitucion = $("#dialog-otra-inst").dialog({
        autoOpen: false,
        height: 300,
        width: 500,
        modal: true,
        buttons: [
            {
                text: "Agregar",
                name: "btnAgregar",
                click: function () {
                    $("#sltOtraInstitucion").removeClass("ui-state-error");
                    agregarFilaSimple("Institucion");
                }
            },
            {
                text: "Cerrar",
                name: "btnCerrar",
                click: function () { dialogOtraInstitucion.dialog("close"); }
            }
        ],
        open: function () {
            var dialog = dialogOtraInstitucion.parent();
            dialog
                .find("button[name='btnAgregar']")
                .button({ icons: { primary: "ui-icon-disk"} });
            dialog
                .find("button[name='btnCerrar']")
                .button({ icons: { primary: "ui-icon-close"} });
        },

        close: function () {
            dialogOtraInstitucion
                .find('.validateTips')
                .text('Ingrese datos:');
            formOtraInst[0].reset();
            $("#sltTipoAbono,#tiAniosAbono,#tiMesesAbono,#tiDiasAbono").removeClass("ui-state-error");
            /* if(vData.estado.toString()=="0"){dialogFunc.dialog( "open" );}*/
        }
    });

    formOtraInst = dialogOtraInstitucion.find("form").on("submit", function (event) {
        event.preventDefault();
    });

    $('#btnNuevaInstitucion').on("click", function (evento) {

        var $tips = $('#dialog-otra-inst .validateTips');
        dialogOtraInstitucion
            .dialog({ title: 'Nueva institución' })
            .dialog("open");
        $tips.text('Todos los datos son obligatorios.');
        $('#sltOtraInstitucion').focus();
        numFilaAeliminar = -1;
    });


    $("#btnNuevaInstitucion").button({
        text: true,
        icons: {
            primary: "ui-icon-plusthick"
        }
    });


    $('#btnSgteAbonos').on("click", function (evento) {

        alert("hola");
    });


    $('#btnCalcularPension').on("click", function (evento) {

        var vRun = $('#tiRun').val();
        var vInstitucion = $('#sltInstitucion option:selected').text();
        var vSubInstitucion = $('#sltSubinstitucion option:selected').text();
        var vCategoria = $('#sltCategoria option:selected').text();
        var vGrado = $('#sltGrado option:selected').text();
        var vGradoJerarquico = $('#sltGradoJerarquico').val();
        var vEsDeLinea = $('input[name=esDeLinea]:radio').val();
        var vGradoEconomico = $('#sltGradoEconomico').val();
        var vEscalafonCivil = $('#sltEscalafonCivil').val();
        var vFechaBaja = $('#dtFechaBaja').val();
        var vCantidadDeAcciones = $('#tiCantidadAcciones').val();
        var vTipoDeAcciones = $('input[name=tipoAcciones]:radio').val();
        var vSobresueldo = $('#sltSobresueldo').val();
        var vSegundoSobresueldo = $('#sltSegundoSobresueldo').val();
        var vAsignacionSOFSOM = $('#sltAsignacionSOFSOM').val();
        var vMinistroDeCorte = $('input[name=esMinistroDeCorte]:radio').val();
        var vSueldoIntegroMinCorte = $('#tiSueldoMinistroDeCorte').val();
        var vPlanillaSuplLey19699 = $('#sltPlanSuplLey19699').val();
        var vPlanillaSuplDFL1_68 = $('#sltPlanSuplDFL1').val();
        var vAniosCPDNyConsc = $('#tiAniosCapredena').val();
        var vMesesCPDNyConsc = $('#tiMesesCapredena').val();
        var vDiasCPDNyConsc = $('#tiDiasCapredena').val();
        var vAniosDesahucio = $('#tiAniosDesahucio').val();
        var vMesesDesahucio = $('#tiMesesDesahucio').val();
        var vDiasDesahucio = $('#tiDiasDesahucio').val();



        var vOtrasInstituciones = '<otrasInstituciones>' +
		                            '   <institucion>Asmar</institucion>' +
		                            '   <institucion>Carabineros</institucion>' +
		                            '   <institucion>DGAC</institucion>' +
		                            '</otrasInstituciones>';

        var vAbonos = '<abonos>' +
		                '   <abono>' +
		                '       <tipo>Abono por hijos</tipo>' +
		                '       <anios>10</anios>' +
		                '       <meses>2</meses>' +
		                '       <dias>3</dias>' +
		                '   </abono>' +
		                '   <abono>' +
		                '       <tipo>Abono por viudez</tipo>' +
		                '       <anios>4</anios>' +
		                '       <meses>6</meses>' +
		                '       <dias>15</dias>' +
		                '   </abono>' +
		                '   <abono>' +
		                '       <tipo>Abono por lesiones</tipo>' +
		                '       <anios>4</anios>' +
		                '       <meses>1</meses>' +
		                '       <dias>25</dias>' +
		                '   </abono>' +
		                '</abonos>';

        var vConcurrencias = '<concurrencias>' +
		                        '   <concurrencia>' +
		                        '       <tipo>Canaempu</tipo>' +
		                        '       <anios>10</anios>' +
		                        '       <meses>2</meses>' +
		                        '       <dias>3</dias>' +
		                        '   </concurrencia>' +
		                        '   <concurrencia>' +
		                        '       <tipo>Dipreca</tipo>' +
		                        '       <anios>2</anios>' +
		                        '       <meses>3</meses>' +
		                        '       <dias>4</dias>' +
		                        '   </concurrencia>' +
		                        '   <concurrencia>' +
		                        '       <tipo>Empart</tipo>' +
		                        '       <anios>5</anios>' +
		                        '       <meses>6</meses>' +
		                        '       <dias>4</dias>' +
		                        '   </concurrencia>' +
		                        '</concurrencias>';


        var entradas = { "run": vRun,
            "institucion": vInstitucion,
            "subInstitucion": vSubInstitucion,
            "categoria": vCategoria,
            "escalafonCivil": vEscalafonCivil,
            "grado": vGrado,
            "gradoJerarquico": vGradoJerarquico,
            "gradoEconomico": vGradoEconomico,
            "esDeLinea": vEsDeLinea,
            "fechaDeBaja": vFechaBaja,
            "cantidadDeAcciones": vCantidadDeAcciones.replace(".", ""),
            "tipoDeAcciones": vTipoDeAcciones,
            "porcentajeDeSobresueldo": vSobresueldo,
            "porcentajeDeSegundoSobresueldo": vSegundoSobresueldo,
            "porcentajeDeAsignacionSOFSOM": vAsignacionSOFSOM,
            "poseeAsigMinistroDeCorte": vMinistroDeCorte,
            "sueldoIntegroMinistroDeCorte": vSueldoIntegroMinCorte.replace(".", ""),
            "planillaSuplementariaLey19699": vPlanillaSuplLey19699,
            "planillaSuplementariaDFL1_68": vPlanillaSuplDFL1_68,
            "aniosCPDNyConsc": vAniosCPDNyConsc.replace(".", ""),
            "mesesCPDNyConsc": vMesesCPDNyConsc.replace(".", ""),
            "diasCPDNyConsc": vDiasCPDNyConsc.replace(".", ""),
            "aniosDesahucio": vAniosDesahucio.replace(".", ""),
            "mesesDesahucio": vMesesDesahucio.replace(".", ""),
            "diasDesahucio": vDiasDesahucio.replace(".", ""),
            "otrasInstituciones": vOtrasInstituciones,
            "abonos": vAbonos,
            "concurrencias": vConcurrencias
        };


        /*
        var param = '<calcular>' +
        '<run>' + vRun + '</run>' +
        '<institucion>' + vInstitucion + '</institucion>' +
        '<subInstitucion>' + vSubInstitucion + '</subInstitucion>' +
        '<categoria>' + vCategoria + '</categoria>' +
        '<escalafonCivil>' + vEscalafonCivil + '</escalafonCivil>' +
        '<grado>' + vGrado + '</grado>' +
        '<gradoJerarquico>' + vGradoJerarquico + '</gradoJerarquico>' +
        '<gradoEconomico>' + vGradoEconomico + '</gradoEconomico>' +
        '<esDeLinea>' + vEsDeLinea + '</esDeLinea>' +
        '<fechaDeBaja>' + vFechaBaja + '</fechaDeBaja>' +
        '<cantidadDeAcciones>' + vCantidadDeAcciones + '</cantidadDeAcciones>' +
        '<tipoDeAcciones>' + vTipoDeAcciones + '</tipoDeAcciones>' +
        '<porcentajeDeSobresueldo>' + vSobresueldo + '</porcentajeDeSobresueldo>' +
        '<porcentajeDeSegundoSobresueldo>' + vSegundoSobresueldo + '</porcentajeDeSegundoSobresueldo>' +
        '<porcentajeDeAsignacionSOFSOM>' + vAsignacionSOFSOM + '</porcentajeDeAsignacionSOFSOM>' +
        '<poseeAsigMinistroDeCorte>' + vMinistroDeCorte + '</poseeAsigMinistroDeCorte>' +
        '<sueldoIntegroMinistroDeCorte>' + vSueldoIntegroMinCorte + '</sueldoIntegroMinistroDeCorte>' +
        '<planillaSuplementariaLey19699>' + vPlanillaSuplLey19699 + '</planillaSuplementariaLey19699>' +
        '<planillaSuplementariaDFL1_68>' + vPlanillaSuplDFL1_68 + '</planillaSuplementariaDFL1_68>' +
        '<aniosCPDNyConsc>' + vAniosCPDNyConsc + '</aniosCPDNyConsc>' +
        '<mesesCPDNyConsc>' + vMesesCPDNyConsc + '</mesesCPDNyConsc>' +
        '<diasCPDNyConsc>' + vDiasCPDNyConsc + '</diasCPDNyConsc>' +
        '<aniosDesahucio>' + vAniosDesahucio + '</aniosDesahucio>' +
        '<mesesDesahucio>' + vMesesDesahucio + '</mesesDesahucio>' +
        '<diasDesahucio>' + vDiasDesahucio + '</diasDesahucio>' +
        '<otrasInstituciones>' + vOtrasInstituciones + '</otrasInstituciones>' +
        '<abonos>' + vAbonos + '</abonos>' +
        '<concurrencias>' + vConcurrencias + '</concurrencias>' +
        '</calcular>';
        */


        //calcular(param);

        var jsonTabla = convertirTabla()


        //tableToJson();
    });

});
//fin document.ready





function CerrarMiSession() {
    $.ajax({
        type: "POST",
        url: "panel.aspx/LogOut",
        //        data: {},
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            var valid = response.d;
            //alert(valid);
            if (valid == true) {
                $('#frmHeader').attr('action', 'ingreso.aspx?');
                $('#frmHeader').attr('target', '_self');
                $('#frmHeader').submit();
            }
        },
        error: function (jqXHR, exception) {
            if (jqXHR.status === 0) {
                alert('Sin conexion.\n Verifique la red.');
            } else if (jqXHR.status == 404) {
                alert('Pagina requerida no encontrada. [404].');
            } else if (jqXHR.status == 500) {
                alert('Error de Servidor Interno [500].');
                console.log(jqXHR.responseText);
            } else if (exception === 'parsererror') {
                alert('Fall\u00F3 parseo JSON requerido.');
                console.log(jqXHR);
            } else if (exception === 'timeout') {
                alert('Error de Tiempo de espera.');
            } else if (exception === 'abort') {
                alert('Requerimiento Ajax abortado.');
            } else {
                alert('Error desconocido.\n' + jqXHR.responseText);
            }
        }

    });  
}

/*----------------------------------------------------------------*/
/*----------------------------NUEVO-------------------------------*/
/*----------------------------------------------------------------*/

function checkRegexp(o, regexp, n, p) {
    if (!(regexp.test(o.val())) && o.val() != "") {
        o.addClass("ui-state-error");
        updateTips(p, n);
        return false;
    } else {
        return true;
    }
}

function checkLength(o, n, min, max, p) {
    if (o.val().length > max || o.val().length < min) {
        o.addClass("ui-state-error");
        updateTips(p, n + " es obligatorio (debe tener entre " +
        min + " y " + max + " caracteres).");
        return false;
    } else {
        return true;
    }
}

function checkCombo(o, n, p) {
    if (o.val() < 0) {
        o.addClass("ui-state-error");
        updateTips(p, n + " es obligatorio (debe seleccionar una opci\u00F3n).");
        return false;
    } else {
        return true;
    }
}

function checkValue(o, n, sel, p) {
    if (o.val() == sel.toString() || o.find('option:selected').length == 0) {
        o.addClass("ui-state-error");
        updateTips(p, n + " es obligatorio.");
        return false;
    } else {
        return true;
    }
}

function updateTips(p, t) {
    var $tips = p.find('.validateTips')
    $tips
        .text(t)
        .addClass("ui-state-highlight");
    setTimeout(function () {
        $tips.removeClass("ui-state-highlight", 1500);
    }, 500);
}

function actualizarAcciones(radioButton) {
    if (radioButton.value == 'SI') {
        $("#celdaCantidadDeAcciones").show();
        $("#celdaTipoDeAcciones").show();
    }
    else if (radioButton.value == 'NO') {
        $("#celdaCantidadDeAcciones").hide();
        $("#celdaTipoDeAcciones").hide();
        $("#tiCantidadAcciones").val('0');
    }
};

function mostrarGrado(combobox) {

    if (combobox.value.toUpperCase().indexOf("EMPLEADO CIVIL") >= 0) {
        $("#celdaGradoJerarquico").show();
        $("#celdaEscalafonCivil").show();
        $("#celdaGrado").hide();
    }
    else {
        $("#celdaGrado").show();
        $("#celdaEscalafonCivil").hide();
        $("#celdaGradoJerarquico").hide();
    }
};

function mostrarEsDeLinea(combobox) {
    if(combobox.value.toUpperCase().indexOf("GENERAL") >= 0){
        $("#celdaEsDeLinea").show();
    }
    else {
        $("#celdaEsDeLinea").hide();
    }
};

function mostrarSueldoMinistroDeCorte(radioButton) {
    if (radioButton.value == 'SI') {
        $("#celdaSueldoMinistroDeCorte").show();
    }
    else if (radioButton.value == 'NO') {
        $("#celdaSueldoMinistroDeCorte").hide();
        $("#tiSueldoMinistroDeCorte").val('0');
    }
};

function restringirNumerico(e) {
    // Allow: backspace, delete, tab, escape, enter and .
    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
        // Allow: Ctrl+A
        (e.keyCode == 65 && e.ctrlKey == true) || 
        // Allow: home, end, left, right, down, up
        (e.keyCode >= 35 && e.keyCode <= 40)) {
        // let it happen, don't do anything
        return;
    }
    // Ensure that it is a number and stop the keypress
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
        e.preventDefault();
    }
};

function darFormatoDeMiles(elemento, numero){
    
    var sNumero = new String(numero);
    var sNumeroFormateado = '';
    sNumero = quitarFormatoNumerico(sNumero);
   
    while( sNumero.length > 3 )
    {
        sNumeroFormateado = "." + sNumero.substr(sNumero.length - 3) + sNumeroFormateado;
        sNumero = sNumero.substring(0, sNumero.length - 3);
    }
    sNumeroFormateado = sNumero + sNumeroFormateado;
    
    elemento.val(sNumeroFormateado);
};

 function quitarFormatoNumerico(numero){

    var strNumero = new String(numero);
    while( strNumero.indexOf(".") != -1 )
    {
        strNumero = strNumero.replace(".","");
    }
          
    return strNumero;
};


var delay = (function(){
  var timer = 0;
  return function(callback, ms){
    clearTimeout (timer);
    timer = setTimeout(callback, ms);
  };
})();

function limpiarRun(run) {
    
    run.tooltip({
                tooltipClass: "ui-state-highlight"
            });
    run
    .val("")
    .attr("title", "Run inv\u00E1lido")
    .tooltip("open");
    delay(function(){
      run.tooltip("close").attr("title", "");
    }, 2500);
};

function agregarFila(tipoDeFila) {
    var valid = true;
    var dialogo;


    if(tipoDeFila == "Abono"){
        abonoAllFields.removeClass( "ui-state-error" );
        dialogo = dialogAbono;
    }
    else if(tipoDeFila == "Concurrencia"){
        concurrenciaAllFields.removeClass( "ui-state-error" );
        dialogo = dialogConcurrencia;
    }

 
    valid = valid && checkCombo( $("#sltTipo"+tipoDeFila), "Tipo de abono", dialogo);
    valid = valid && checkLength( $("#tiAnios"+tipoDeFila), "A\u00F1os", 1, 2, dialogo);
    valid = valid && checkLength( $("#tiMeses"+tipoDeFila), "Meses", 1, 2, dialogo);
    valid = valid && checkLength( $("#tiDias"+tipoDeFila), "D\u00EDas", 1, 2, dialogo);
      
    if ( valid ) {
        
        if(numFilaAeliminar >= 0){
            removerFila(numFilaAeliminar);
        }
        
        $( "#tbl"+tipoDeFila+"s tbody" ).append( "<tr>" +
            "<td>" + $("#sltTipo"+tipoDeFila+" option:selected").html() + "</td>" +
            "<td align=\"right\">" + $("#tiAnios"+tipoDeFila).val() + "</td>" +
            "<td align=\"right\">" + $("#tiMeses"+tipoDeFila).val() + "</td>" +
            "<td align=\"right\">" + $("#tiDias"+tipoDeFila).val() + "</td>" +
            "<td>"+
            "<button class=\"btnEditarFila\">Editar</button>"+
            "<button class=\"btnRemoverFila\">Remover</button>"+
            "</td>" +
            "</tr>" );
        dialogo.dialog( "close" );
        actualizarBotones(tipoDeFila);
    }
    return valid;
}

function actualizarBotones(tipoDeFila){

    $(".btnEditarFila").button({
        text: false,
        icons: {
            primary: "ui-icon-pencil"
        }
    });
    
    $('.btnEditarFila').on("click", function () {
        var indice = $(".btnEditarFila").index(this);
        
        var tipo = $($('#tbl'+tipoDeFila+'s tbody tr')[indice]).children('td')[0].innerHTML;
        var anios = $($('#tbl'+tipoDeFila+'s tbody tr')[indice]).children('td')[1].innerHTML;
        var meses = $($('#tbl'+tipoDeFila+'s tbody tr')[indice]).children('td')[2].innerHTML;
        var dias = $($('#tbl'+tipoDeFila+'s tbody tr')[indice]).children('td')[3].innerHTML;
        numFilaAeliminar = indice;
        modificarFila(tipoDeFila, tipo, anios, meses, dias);
    });  

    $(".btnRemoverFila").button({
        text: false,
        icons: {
            primary: "ui-icon-closethick"
        }
    });
    
    $('.btnRemoverFila').on("click", function () {
        var indice = $(".btnRemoverFila").index(this);
        removerFila(indice, tipoDeFila);
    });
}
 
function removerFila(indice, tipoDeFila){
   
    $($('#tbl'+tipoDeFila+'s tbody tr')[indice]).remove();
}

 function modificarFila(tipoDeFila, tipo, anios, meses, dias){

    var $tips;

    if(tipoDeFila == "Abono"){
        var $tips = $('#dialog-abono .validateTips');
        dialogAbono
            .dialog({title:'Nuevo abono'})
            .dialog("open");
    }
    else if(tipoDeFila == "Concurrencia"){
        var $tips = $('#dialog-concurrencia .validateTips');
        dialogAbono
            .dialog({title:'Nueva concurrencia'})
            .dialog("open");
    }

    $tips.text('Todos los datos son obligatorios.');

    $('#sltTipo'+tipoDeFila).combobox('value', tipo);
    $('#tiAnios'+tipoDeFila).val(anios);
    $('#tiMeses'+tipoDeFila).val(meses);
    $('#tiDias'+tipoDeFila).val(dias);
    $('#sltTipo'+tipoDeFila).focus();
 }
    

function agregarFilaSimple() {
    var valid = true;
    
    otraInstitucionAllFields.removeClass( "ui-state-error" );
 
    valid = valid && checkCombo( $("#sltOtraInstitucion"), "Institución", dialogOtraInstitucion);
      
    if ( valid ) {
        
        if(numFilaAeliminar >= 0){
            removerFila(numFilaAeliminar);
        }
        
        $( "#tblOtrasInstituciones tbody" ).append( "<tr>" +
            "<td>" + $("#sltOtraInstitucion option:selected").html() + "</td>" +
            "<td>"+
            "<button class=\"btnEditarFila\">Editar</button>"+
            "<button class=\"btnRemoverFila\">Remover</button>"+
            "</td>" +
            "</tr>" );
        dialogOtraInstitucion.dialog( "close" );
        actualizarBotonesFilaSimple();
    }
    return valid;
}

function actualizarBotonesFilaSimple(){

    $(".btnEditarFila").button({
        text: false,
        icons: {
            primary: "ui-icon-pencil"
        }
    });
    
    $('.btnEditarFila').on("click", function () {
        var indice = $(".btnEditarFila").index(this);
        
        var institucion = $($('#tblOtrasInstituciones tbody tr')[indice]).children('td')[0].innerHTML;
        numFilaAeliminar = indice;
        modificarFilaSimple(institucion);
    });  

    $(".btnRemoverFila").button({
        text: false,
        icons: {
            primary: "ui-icon-closethick"
        }
    });
    
    $('.btnRemoverFila').on("click", function () {
        var indice = $(".btnRemoverFila").index(this);
        removerFilaSimple(indice);
    });
}
 
function removerFilaSimple(indice){
   
    $($('#tblOtrasInstituciones tbody tr')[indice]).remove();
}

 function modificarFilaSimple(institucion){

    var $tips;

    var $tips = $('#dialog-otra-inst .validateTips');
    dialogOtraInstitucion
        .dialog({title:'Nueva institución'})
        .dialog("open");
    
    $tips.text('Todos los datos son obligatorios.');

    $('#sltOtraInstitucion').combobox('value', tipo);
    $('#sltOtraInstitucion').focus();
 }
   

function calcular(entradas){
    /*
    var param2 = {
        xml: '<calcular>'+
	    '<run>16.023.917-4</run>'+
		'<institucion>FUERZA AÉREA</institucion>'+
		'<subInstitucion>FUERZA AÉREA</subInstitucion>'+
		'<categoria>OFICIAL (FA)</categoria>'+
		'<escalafonCivil></escalafonCivil>'+
		'<grado>CORONEL DE AVIACIÓN</grado>'+
		'<gradoJerarquico>4</gradoJerarquico>'+
		'<gradoEconomico>1</gradoEconomico>'+
		'<esDeLinea>NO</esDeLinea>'+
		'<fechaDeBaja>2015-01-31</fechaDeBaja>'+
		'<cantidadDeAcciones>10</cantidadDeAcciones>'+
		'<tipoDeAcciones>Con AEGE</tipoDeAcciones>'+
		'<porcentajeDeSobresueldo>21%</porcentajeDeSobresueldo>'+
		'<porcentajeDeSegundoSobresueldo>20%</porcentajeDeSegundoSobresueldo>'+
		'<porcentajeDeAsignacionSOFSOM>25%</porcentajeDeAsignacionSOFSOM>'+
		'<poseeAsigMinistroDeCorte>SI</poseeAsigMinistroDeCorte>'+
		'<sueldoIntegroMinistroDeCorte>100000</sueldoIntegroMinistroDeCorte>'+
		'<planillaSuplementariaLey19699>3</planillaSuplementariaLey19699>'+
		'<planillaSuplementariaDFL1_68>3</planillaSuplementariaDFL1_68>'+
		'<aniosCPDNyConsc>26</aniosCPDNyConsc>'+
		'<mesesCPDNyConsc>24</mesesCPDNyConsc>'+
		'<diasCPDNyConsc>33</diasCPDNyConsc>'+
		'<aniosDesahucio>19</aniosDesahucio>'+
		'<mesesDesahucio>15</mesesDesahucio>'+
		'<diasDesahucio>32</diasDesahucio>'+
		'<otrasInstituciones>'+
		'<institucion>Asmar</institucion>'+
		'<institucion>Carabineros</institucion>'+
		'<institucion>DGAC</institucion>'+
		'</otrasInstituciones>'+
		'<abonos>'+
		'<abono>'+
		'<tipo>Abono por hijos</tipo>'+
		'<anios>10</anios>'+
		'<meses>2</meses>'+
		'<dias>3</dias>'+
		'</abono>'+
		'<abono>'+
		'<tipo>Abono por viudez</tipo>'+
		'<anios>4</anios>'+
		'<meses>6</meses>'+
		'<dias>15</dias>'+
		'</abono>'+
		'<abono>'+
		'<tipo>Abono por lesiones</tipo>'+
		'<anios>4</anios>'+
		'<meses>1</meses>'+
		'<dias>25</dias>'+
		'</abono>'+
		'</abonos>'+
		'<concurrencias>'+
		'<concurrencia>'+
		'<tipo>Canaempu</tipo>'+
		'<anios>10</anios>'+
		'<meses>2</meses>'+
		'<dias>3</dias>'+
		'</concurrencia>'+
		'<concurrencia>'+
		'<tipo>Dipreca</tipo>'+
		'<anios>2</anios>'+
		'<meses>3</meses>'+
		'<dias>4</dias>'+
		'</concurrencia>'+
		'<concurrencia>'+
		'<tipo>Empart</tipo>'+
		'<anios>5</anios>'+
		'<meses>6</meses>'+
		'<dias>4</dias>'+
		'</concurrencia>'+
		'</concurrencias>'+
		'</calcular>'
            };
*/
    var param = {
        xml: entradas
    };

    alert("ENTRADAS :\n" + entradas);

    //console.info('panel.js calcular --> param: '+JSON.stringify(param));
    $.ajax({
        type: "POST",
        url: "panel.aspx/calcular",
        data: JSON.stringify(param),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            var dataSet = response.d;
            var codigo = dataSet[0];

            if (codigo == 0 && dataSet[1].toString() != '') {

                var resultados = JSON.parse(dataSet[1].toString());


                $('#tiGrados').val(resultados.grados);
                $('#tiSueldo1981').val(resultados.sueldo1981);
                $('#tiSueldoActividad').val(resultados.sueldoEnActividad);
                $('#tiTrienios').val(resultados.cantidadTrienios);
                $('#tiPorcTrienios').val(resultados.porcentajeTrienios);
                $('#tiTrienios18263').val(resultados.asignacionTrieniosLey18263);
                $('#tiTrienios18694').val(resultados.asignacionTrieniosLey18694);
                $('#tiPorcSobresueldo').val(resultados.porcentajeSobresueldo);
                $('#tiSobresueldo18263').val(resultados.sobresueldoLey18263);
                $('#tiSSobresueldo18694').val(resultados.sobresueldoLey18694);
                $('#tiPorcMandoAdm').val(resultados.porcentajeBonifMandoAdministracion);
                $('#tiMandoAdm18263').val(resultados.bonifMandoAdministracionLey18263);
                $('#tiMandoAdm18694').val(resultados.bonifMandoAdministracionLey18694);
                $('#tiPorcAltoMando').val(resultados.porcentajeBonifAltoMando);
                $('#tiAltoMando18263').val(resultados.bonifAltoMandoLey18263);
                $('#tiAltoMando18694').val(resultados.bonifAltoMandoLey18694);
                $('#tiAplicaPlaSup19699').val(resultados.aplicaPlanillaSuplementaria);
                $('#tiPlaSup18694').val(resultados.planillaSuplementariaLey19699Actual);
                $('#tiPlaSup18263').val(resultados.planillaSuplementariaLey19699anio1981);
                $('#tiPorcAsigSom').val(resultados.porcentajeAsignacionSOM);
                $('#tiAsigSom18263').val(resultados.asignacionSOMLey18263);
                $('#tiAsigSom18694').val(resultados.asignacionSOMLey18694);
                $('#tiPorcMinCorte').val(resultados.porcentajeAsigMinistroDeCorte);
                $('#tiMinCorte18263').val(resultados.asigMinistroDeCorteLey18263);
                $('#tiMinCorte18694').val(resultados.asigMinistroDeCorteLey18694);
                $('#tiTituloProf').val(resultados.poseeTituloProf);
                $('#tiAege18263').val(resultados.aegeLey18263);
                $('#tiAege18694').val(resultados.aegeLey18694);
                $('#tiTotal18263').val(resultados.totalLey18263);
                $('#tiTotalImponible18263').val(resultados.totalLey18263);
                $('#tiTotal18694').val(resultados.totalParaDesahucio);
                $('#tiCantidadAvos').val(resultados.cantidadAVOS);
                $('#tiMontoAvos18263').val(resultados.montoAVOS);
                $('#tiPorcAvos').val(resultados.porcentajeAVOS);
                $('#tiMontoHasta88').val(resultados.reajusteHasta8_8);
                $('#tiPorcReajDS376').val(resultados.porcentajeReajusteDS376_1987);
                $('#tiMontoReajDS376').val(resultados.montoReajusteDS376_1987);
                $('#tiPorcReajDS321').val(resultados.porcentajeReajusteDS321_1988);
                $('#tiMontoReajDS321').val(resultados.montoReajusteDS321_1988);
                $('#totalImponibleParcial18694').val(resultados.totalImponibleParcial);
                $('#tiTotalDesahucioAvos18694').val(resultados.totalDesahucioSegunAvos);
                $('#tiTotalImponible18694').val(resultados.totalImponible);
                $('#tiAegeNoImponible').val(resultados.aegeNoImponible);
                $('#tiAplicaPlaSupDfl1').val(resultados.recibePlanillaSuplementariaDfl_1_68);
                $('#tiPlaSupDfl1').val(resultados.planillaSuplementariaDfl_1_68);
                $('#tiBonifCompensatoria').val(resultados.bonificacionCompensatoria);
                $('#tiTipoBonifRiesgoEsp').val(resultados.tipoDeBonifRiesgoEspecial);
                $('#tiPorcBonifRiesgoEsp').val(resultados.porcentajeBonifRiesgoEspecial);
                $('#tiBonifRiesgoEsp').val(resultados.bonifRiesgoEspecial);
                $('#tiPorcMinCorteNoImp').val(resultados.porcentajeAsigMinDeCorteNoImp);
                $('#tiMinCorteNoImp').val(resultados.asigMinistroDeCorteNoImp);
                $('#tiAsigSomNoImp').val(resultados.asignacionSOMnoImp);
                $('#tiPorcAsigSomNoImp').val(resultados.porcentajeAsigSOMnoImp);
                $('#tiPorcSegundoSobresueldo').val(resultados.porcentajeSegundoSobresueldo);
                $('#tiSegundoSobresueldo').val(resultados.segundoSobresueldo);
                $('#tiTotalRemuneracion').val(resultados.totalRemuneracion);
                $('#tiTotalRemuneracionAvos').val(resultados.totalRemuneracionSegunAVOS);
                $('#tiDocumentoUltimoReaj').val(resultados.tipoDocUltimoReajuste + ' ' + resultados.numeroDocUltimoReajuste);
                $('#tiPorcUltimoReaj').val(resultados.porcentajeUltimoReajuste);
                $('#tiMontoUltimoReaj').val(resultados.montoUltimoReajuste);
                $('#tiPensioAotorgar').val(resultados.pensionAotorgar);
                $('#tiPorcAvos2').val(resultados.porcentajeAVOS2);
                $('#tiTope').val(resultados.conTopeSinTope);
                $('#tiDistribucionCapredena').val(resultados.distribucionCapredena);
                $('#tiDistribucionFisco').val(resultados.distribucionFisco);
                $('#tiDistribucionTotal').val(resultados.distribucionTotal);
                $('#tiMensualidadesDesahucio').val(resultados.mensualidadesDesahucio);
                $('#tiMensualidadDesahucio').val(resultados.montoMensualidadDesahucio);
                $('#tiSubTotalDesahucio').val(resultados.subtotalDesahucio);
                $('#tiMensualidadesAcciones').val(resultados.cantidadAcciones);
                $('#tiMensualidadAcciones').val(resultados.montoUnitarioAcciones);
                $('#tiSubTotalAcciones').val(resultados.subtotalAcciones);
                $('#tiDesahucioApagar').val(resultados.desahucioApagar);
                $('#tiMeseseSigteTrienio').val(resultados.mesesSgteTrienio);
                $('#tiDiasSigteTrienio').val(resultados.diasSgteTrienio);
                $('#tiSigteTrienio').val(resultados.siguienteTrienio);









            }
            else {
                alert("resultados invalidos");
            }

        },
        error: function (jqXHR, exception) {
            if (jqXHR.status === 0) {
                alert('Sin conexion.\n Verifique la red.');
            } else if (jqXHR.status == 404) {
                alert('Pagina requerida no encontrada. [404].');
            } else if (jqXHR.status == 500) {
                alert('Error de Servidor Interno [500].');
                console.info(jqXHR.responseText);
            } else if (exception === 'parsererror') {
                alert('Falló parseo JSON requerido.');
                console.log(jqXHR);
            } else if (exception === 'timeout') {
                alert('Error de Tiempo de espera.');
            } else if (exception === 'abort') {
                alert('Requerimiento Ajax abortado.');
            } else {
                alert('Error desconocido.\n' + jqXHR.responseText);
            }
        }

    });
}


function convertirTabla() {

/*
    var table = $('#tblDetalleServicios').tableToJSON({
        ignoreColumns: [3]
    });

  */


    var table = $('#tblAbonos').tableToJSON({
        ignoreColumns: [4]
    });
   
    console.log(table);
    alert(JSON.stringify(table));
    var test = '<table>' + $('#tblAbonos').html() + '</table>';
    alert(JSON.stringify(test));

    return "";
}