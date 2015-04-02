// Archivo JScript

var $filaAeditar = null;
var $tipoDeFila = '';

var fechaRegex = /^(?:(?:31(\/)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/;

var icons = {
    header: "ui-icon-circle-arrow-e",
    headerSelected: "ui-icon-circle-arrow-s"
};

var dialogTiempo,
    tipoTiempo = $("#sltTipoDeTiempo"),
    tiempoAnios = $("#tiTiempoAnios"),
    tiempoMeses = $("#tiTiempoMeses"),
    tiempoDias = $("#tiTiempoDias"),
    tiempoAllFields = $([]).add(tipoTiempo)
                            .add(tiempoAnios)
                            .add(tiempoMeses)
                            .add(tiempoDias);

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
var xmlAbonos, xmlConcurrencias, xmlInstituciones;

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

    $(".combobox").combobox();
    $("#tabs").tabs({
        collapsible: true
    });


    $("#tiCantidadAcciones").attr("disabled", true);

    $('input[name=tipoAcciones]:radio').attr("disabled", true);

    deshabilitarCombobox('celdaGradoJerarquico', 'sltGradoJerarquico');
    deshabilitarCombobox('celdaEscalafonCivil', 'sltEscalafonCivil');

    $('input[name=esDeLinea]:radio').attr("disabled", true);
    $("#tiSueldoMinistroDeCorte").attr("disabled", true);

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

    $(".run").keydown(function (e) {
        restringirRun(e);
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
        dateFormat: "dd/mm/yy",
        firstDay: 1,
        maxDate: 0
    });

    $('.datepicker').on("focusout", function () {
        var elemento = $('#' + this.id);
        var valido = checkRegexpUnitario(elemento, fechaRegex, "no es una fecha válida");
    });

    $('#dtFechaBaja').on("focusout", function () {
        mostrarGrado(this);
    });

    dialogTiempo = $("#dialog-tiempo").dialog({
        autoOpen: false,
        height: 300,
        width: 500,
        modal: true,
        buttons: [
            {
                text: "Agregar",
                name: "btnAgregar",
                click: function () {
                    $("#sltTipoDeTiempo,#tiTiempoAnios,#tiTiempoMeses,#tiTiempoDias").removeClass("ui-state-error");
                    agregarFilaDeTiempos();
                }
            },
            {
                text: "Cerrar",
                name: "btnCerrar",
                click: function () { dialogTiempo.dialog("close"); }
            }
        ],
        open: function () {
            var dialog = dialogTiempo.parent();
            dialog
                .find("button[name='btnAgregar']")
                .button({ icons: { primary: "ui-icon-disk"} });
            dialog
                .find("button[name='btnCerrar']")
                .button({ icons: { primary: "ui-icon-close"} });
        },

        close: function () {
            dialogTiempo
                .find('.validateTips')
                .text('Ingrese datos:');
            formTiempo[0].reset();
            $("#sltTipoDeTiempo,#tiTiempoAnios,#tiTiempoMeses,#tiTiempoDias").removeClass("ui-state-error");
            /* if(vData.estado.toString()=="0"){dialogFunc.dialog( "open" );}*/
        }
    });

    formTiempo = dialogTiempo.find("form").on("submit", function (event) {
        event.preventDefault();
    });
  
    $('#btnNuevoAbono').on("click", function (evento) {

        var $tips = $('#dialog-tiempo .validateTips');
        dialogTiempo
            .dialog({ title: 'Nuevo abono' })
            .dialog("open");

        $('#lblTipoDeTiempo').text('Abono :');

        $tips.text('Ingrese los datos solicitados.');
        $('#sltTipoDeTiempo').focus();
        $tipoDeFila = 'Abono';
        $filaAeditar = null;
    });


    $("#btnNuevoAbono").button({
        text: true,
        icons: {
            primary: "ui-icon-plusthick"
        }
    });
   
    $('#btnNuevaConcurrencia').on("click", function (evento) {

        var $tips = $('#dialog-tiempo .validateTips');
        dialogTiempo
            .dialog({ title: 'Nueva concurrencia' })
            .dialog("open");

        $('#lblTipoDeTiempo').text('Concurrencia :');

        $tips.text('Ingrese los datos solicitados');
        $('#sltTipoDeTiempo').focus();
        $tipoDeFila = 'Concurrencia';
        $filaAeditar = null;
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
                    agregarFilaOtraInstitucion();
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
        $tips.text('Ingrese los datos solicitados.');
        $('#sltOtraInstitucion').focus();
        $tipoDeFila = 'OtraInstitucion';
        $filaAeditar = null;
    });

    $("#btnNuevaInstitucion").button({
        text: true,
        icons: {
            primary: "ui-icon-plusthick"
        }
    });



    $('#tblOtrasInstituciones, #tblAbonos, #tblConcurrencias').on('click', 'tbody tr td .btnRemoverFila', function () {
        var indice = $(".btnRemoverFila").index(this);

        var fila = $(this).parent().parent();
        fila.remove();
    });

    $('#tblOtrasInstituciones').on('click', 'tbody tr td .btnEditarFila', function () {
        var indice = $(".btnEditarFila").index(this);

        $filaAeditar = $($('#tblOtrasInstituciones tbody tr')[indice]);

        modificarFilaOtraInstitucion();
    });

    $('#tblAbonos, #tblConcurrencias').on('click', 'tbody tr td .btnEditarFila', function () {
        var indice = $(".btnEditarFila").index(this);

        $filaAeditar = $(this).parent().parent();

        modificarFilaDeTiempos();
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

        var vOtrasInstituciones = otrasInstitucionesToXml();
        var vAbonos = abonosToXml();
        var vConcurrencias = concurrenciasToXml();

        var entradas = { run: vRun,
            institucion: vInstitucion,
            subInstitucion: vSubInstitucion,
            categoria: vCategoria,
            escalafonCivil: vEscalafonCivil,
            grado: vGrado,
            gradoJerarquico: vGradoJerarquico,
            gradoEconomico: vGradoEconomico,
            esDeLinea: vEsDeLinea,
            fechaDeBaja: vFechaBaja,
            cantidadDeAcciones: vCantidadDeAcciones.replace(".", ""),
            tipoDeAcciones: vTipoDeAcciones,
            porcentajeDeSobresueldo: vSobresueldo,
            porcentajeDeSegundoSobresueldo: vSegundoSobresueldo,
            porcentajeDeAsignacionSOFSOM: vAsignacionSOFSOM,
            poseeAsigMinistroDeCorte: vMinistroDeCorte,
            sueldoIntegroMinistroDeCorte: vSueldoIntegroMinCorte.replace(".", ""),
            planillaSuplementariaLey19699: vPlanillaSuplLey19699,
            planillaSuplementariaDFL1_68: vPlanillaSuplDFL1_68,
            aniosCPDNyConsc: vAniosCPDNyConsc.replace(".", ""),
            mesesCPDNyConsc: vMesesCPDNyConsc.replace(".", ""),
            diasCPDNyConsc: vDiasCPDNyConsc.replace(".", ""),
            aniosDesahucio: vAniosDesahucio.replace(".", ""),
            mesesDesahucio: vMesesDesahucio.replace(".", ""),
            diasDesahucio: vDiasDesahucio.replace(".", ""),
            otrasInstituciones: "",
            abonos: "",
            concurrencias: ""
        };


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
        vOtrasInstituciones + vAbonos + vConcurrencias +
        '</calcular>';

        calcular(param);
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

function checkRegexp(o, regexp, n, p) {
    if (!(regexp.test(o.val())) && o.val() != "") {
        o.addClass("ui-state-error");
        updateTips(p, n);
        return false;
    } else {
        return true;
    }
}

function checkRegexpUnitario(elemento, regexp, mensaje) {
    if (!(regexp.test(elemento.val())) && elemento.val() != "") {
        elemento.tooltip({
            tooltipClass: "ui-state-highlight"
        });
        elemento
            .attr("title", elemento.val() + " " + mensaje)
            .val("")
            .tooltip("open");
        delay(function () {
            elemento.tooltip("close").attr("title", "");
        }, 2500);
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
        $("#tiCantidadAcciones").attr("disabled", false);
        $("#tiCantidadAcciones").val('');
        $('input[name=tipoAcciones]:radio').attr("disabled", false);
        $('input[name=tipoAcciones]:radio').attr("checked", false);
    }
    else if (radioButton.value == 'NO') {
        $("#tiCantidadAcciones").attr("disabled", true);
        $("#tiCantidadAcciones").val('0');
        $('input[name=tipoAcciones]:radio').attr("disabled", true);
        $('input[name=tipoAcciones]:radio').attr("checked", false);
    }
};

function mostrarGrado(combobox) {

    if (combobox.value.toUpperCase().indexOf("EMPLEADO CIVIL") >= 0) {
        habilitarCombobox('celdaGradoJerarquico');
        habilitarCombobox('celdaEscalafonCivil');
        deshabilitarCombobox('celdaGrado', 'sltGrado');
    }
    else {
        habilitarCombobox('celdaGrado');
        deshabilitarCombobox('celdaEscalafonCivil', 'sltEscalafonCivil');
        deshabilitarCombobox('celdaGradoJerarquico', 'sltGradoJerarquico');
    }
};


function habilitarCombobox(idCelda) {
    $('#' + idCelda + ' .ui-combobox .ui-combobox-input').attr("disabled", false);
    $('#' + idCelda + ' .ui-combobox .ui-combobox-button').attr("disabled", false);
}

function deshabilitarCombobox(idCelda, idCombo) {
    $('#' + idCelda + ' .ui-combobox .ui-combobox-input').attr("disabled", true);
    $('#' + idCelda + ' .ui-combobox .ui-combobox-button').attr("disabled", true);
    $('#' + idCombo).combobox('value', '-1');
}


function mostrarEsDeLinea(combobox) {
    if(combobox.value.toUpperCase().indexOf("GENERAL") >= 0){
        $('input[name=esDeLinea]:radio').attr("disabled", false);
        $('input[name=esDeLinea]:radio').attr("checked", false);
    }
    else {
        $('input[name=esDeLinea]:radio').attr("disabled", true);
        $('input[name=esDeLinea]:radio').attr("checked", false);
    }
};

function mostrarSueldoMinistroDeCorte(radioButton) {
    if (radioButton.value == 'SI') {
        $("#tiSueldoMinistroDeCorte").attr("disabled", false);
    }
    else if (radioButton.value == 'NO') {
        $("#tiSueldoMinistroDeCorte").attr("disabled", true);
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

function restringirRun(e) {
    // Allow: backspace, delete, tab, escape, enter and .
    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
    // Allow: Ctrl+A
        (e.keyCode == 65 && e.ctrlKey == true) ||
    // Allow: home, end, left, right, down, up
        (e.keyCode >= 35 && e.keyCode <= 40)) {
        // let it happen, don't do anything
        return;
    }
    // Ensure that it is a number and stop the keypress    keyCode = 75 -> K
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 75 || e.keyCode > 75) && (e.keyCode < 96 || e.keyCode > 105)) {
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

function agregarFilaDeTiempos() {
     var valid = true;
    
     tiempoAllFields.removeClass("ui-state-error");
     
     valid = valid && checkCombo($("#sltTipoDeTiempo"), "Tipo de abono", dialogTiempo);
     valid = valid && checkLength($("#tiTiempoAnios"), "A\u00F1os", 1, 2, dialogTiempo);
     valid = valid && checkLength($("#tiTiempoMeses"), "Meses", 1, 2, dialogTiempo);
     valid = valid && checkLength($("#tiTiempoDias"), "D\u00EDas", 1, 2, dialogTiempo);

     if (valid) {

         var nuevaFila = "<tr>" +
            "<td style=\"text-align:left;\">" + $("#sltTipoDeTiempo option:selected").html() + "</td>" +
            "<td align=\"right\">" + $("#tiTiempoAnios").val() + "</td>" +
            "<td align=\"right\">" + $("#tiTiempoMeses").val() + "</td>" +
            "<td align=\"right\">" + $("#tiTiempoDias").val() + "</td>" +
            "<td>" +
            "<button class=\"btnEditarFila\">Editar</button>" +
            "<button class=\"btnRemoverFila\">Remover</button>" +
            "</td>" +
            "</tr>";

         if ($filaAeditar == null) {
             $('#tbl' + $tipoDeFila + 's tbody').append(nuevaFila);
             $('#tbl' + $tipoDeFila + 's tbody').find('tr:last')
                .find('.btnEditarFila').button({
                    text: false,
                    icons: {
                        primary: "ui-icon-pencil"
                    }
                });
                $('#tbl' + $tipoDeFila + 's tbody').find('tr:last')
                .find('.btnRemoverFila').button({
                    text: false,
                    icons: {
                        primary: "ui-icon-closethick"
                    }
                });
         }
         else {
             $filaAeditar.children('td')[0].innerHTML = $("#sltTipoDeTiempo option:selected").html();
             $filaAeditar.children('td')[1].innerHTML = $("#tiTiempoAnios").val();
             $filaAeditar.children('td')[2].innerHTML = $("#tiTiempoMeses").val();
             $filaAeditar.children('td')[3].innerHTML = $("#tiTiempoDias").val();
         }
         dialogTiempo.dialog("close");
     }
     return valid;
 }




 function modificarFilaDeTiempos() {

     var $tips;

     var tipo = $filaAeditar.children('td')[0].innerHTML;
     var anios = $filaAeditar.children('td')[1].innerHTML;
     var meses = $filaAeditar.children('td')[2].innerHTML;
     var dias = $filaAeditar.children('td')[3].innerHTML;

     if ($tipoDeFila == "Abono") {
         dialogTiempo
            .dialog({ title: 'Editar abono' })
            .dialog("open");
     }
     else if ($tipoDeFila == "Concurrencia") {
         dialogTiempo
            .dialog({ title: 'Editar concurrencia' })
            .dialog("open");
     }

     $('#sltTipoDeTiempo').combobox('textValue', tipo);
     $('#tiTiempoAnios').val(anios);
     $('#tiTiempoMeses').val(meses);
     $('#tiTiempoDias').val(dias);
 }
 
 function agregarFilaOtraInstitucion() {
    var valid = true;
    
    otraInstitucionAllFields.removeClass( "ui-state-error" );
 
    valid = valid && checkCombo( $("#sltOtraInstitucion"), "Institución", dialogOtraInstitucion);
      
    if ( valid ) {
        var nuevaInstitucion = $("#sltOtraInstitucion option:selected").html();

        var nuevaFila = "<tr>" +
            "<td>" + nuevaInstitucion + "</td>" +
            "<td>" +
            "<button class=\"btnEditarFila\">Editar</button>" +
            "<button class=\"btnRemoverFila\">Remover</button>" +
            "</td>" +
            "</tr>";

        if ($filaAeditar == null) {
            $('#tblOtrasInstituciones tbody').append(nuevaFila);
            $('#tblOtrasInstituciones tbody').find('tr:last')
                .find('.btnEditarFila').button({
                    text: false,
                    icons: {
                        primary: "ui-icon-pencil"
                    }
                });
            $('#tblOtrasInstituciones tbody').find('tr:last')
                .find('.btnRemoverFila').button({
                    text: false,
                    icons: {
                        primary: "ui-icon-closethick"
                    }
                });
        }
        else {
            $filaAeditar.children('td')[0].innerHTML = nuevaInstitucion;
        }
        
        dialogOtraInstitucion.dialog( "close" );
    }
    return valid;
}

function modificarFilaOtraInstitucion(){

    var $tips;

    var $tips = $('#dialog-otra-inst .validateTips');
    dialogOtraInstitucion
        .dialog({title:'Editar institución'})
        .dialog("open");
    
    $tips.text('Ingrese los datos solicitados.');

    var $select = $('#dialog-otra-inst').find('#sltOtraInstitucion');
    var institucion = $filaAeditar.children('td')[0].innerHTML;

    $select.combobox('textValue', institucion);
 }
   

function calcular(entradas){
    var param = {
        xml: entradas
    };
    
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
                $('#tiPorcAvos1').val(resultados.porcentajeAVOS2);
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



                //Procesar las tablas

                var servicios = resultados.detalleDeServicios.servicios;
                var totalServicios = resultados.detalleDeServicios.totales;

                var $grillaServicios = $('#tblDetalleServicios tbody');

                for (var indice in servicios) {
                    var servicio = servicios[indice];
                    $grillaServicios.append('<tr"><td style="text-align:left;">' + servicio["detalle"] + '</td>' +
                                                 '<td>' + servicio["anios"] + '</td>' +
                                                 '<td>' + servicio["meses"] + '</td>' +
                                                 '<td>' + servicio["dias"] + '</td>' +
                                                 '<td>' + servicio["enDias"] + '</td>' +
                                                 '<td>' + servicio["proporcion"] + '</td>' +
                                            '</tr>');
                }

                var concurrencias = resultados.detalleDeConcurrencias.concurrencias;
                var totalConcurrencias = resultados.detalleDeConcurrencias.total;

                var $grillaConcurrencias = $('#tblConcurrenciasSalida tbody');

                for (var indice in concurrencias) {
                    var concurrencia = concurrencias[indice];
                    $grillaConcurrencias.append('<tr"><td>' + concurrencia["institucion"] + '</td>' +
                                                 '<td><label class="peso">$</label>'+
                                                 '<input type="text" value="'+ concurrencia["monto"] +'" class="numerico ui-widget-content ui-corner-all"/></td>' +
                                                '</tr>');
                }



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


function convertirTabla(tabla, columnasIgnoradas) {

    var jsonTabla = tabla.tableToJSON({
        ignoreColumns: [columnasIgnoradas]
    });

    return jsonTabla;
}

function abonosToXml() {

    var _abonosXml = '<abonos>';
    
    $('#tblAbonos tbody tr').each(function () {

        var _tipo = $(this).find("td").eq(0).html();
        var _anios = $(this).find("td").eq(1).html();
        var _meses = $(this).find("td").eq(2).html();
        var _dias = $(this).find("td").eq(3).html();

        var _abono = '<abono><tipo>' + _tipo + '</tipo><anios>' + _anios + '</anios><meses>' + _meses + '</meses><dias>' + _dias + '</dias></abono>';
        _abonosXml = _abonosXml + _abono;
    });
    _abonosXml = _abonosXml + '</abonos>';

    return _abonosXml;
}

function concurrenciasToXml() {

    var _concurrenciasXml = '<concurrencias>';

    $('#tblConcurrencias tbody tr').each(function () {

        var _tipo = $(this).find("td").eq(0).html();
        var _anios = $(this).find("td").eq(1).html();
        var _meses = $(this).find("td").eq(2).html();
        var _dias = $(this).find("td").eq(3).html();

        var _concurrencia = '<concurrencia><tipo>' + _tipo + '</tipo><anios>' + _anios + '</anios><meses>' + _meses + '</meses><dias>' + _dias + '</dias></concurrencia>';
        _concurrenciasXml = _concurrenciasXml + _concurrencia;
    });
    _concurrenciasXml = _concurrenciasXml + '</concurrencias>';

    return _concurrenciasXml;
}


function tablaToXml(tabla, nombreRaiz, nombreHijos) {

    var _strXml = '<' + nombreRaiz  + '>';

    $('#tblConcurrencias tbody tr').each(function () {

        var _tipo = $(this).find("td").eq(0).html();
        var _anios = $(this).find("td").eq(1).html();
        var _meses = $(this).find("td").eq(2).html();
        var _dias = $(this).find("td").eq(3).html();

        var _hijo = '<' + nombreHijos + '><tipo>' + _tipo + '</tipo><anios>' + _anios + '</anios><meses>' + _meses + '</meses><dias>' + _dias + '</dias></' + nombreHijos + '>';
        _strXml = _strXml + _hijo;
    });
    _strXml = _strXml + '</' + nombreRaiz + '>';

    return _strXml;
}


function otrasInstitucionesToXml() {

    var _otrasInstitucionesXml = '<otrasInstituciones>';

    $('#tblOtrasInstituciones tbody tr').each(function () {

        var _inst = $(this).find("td").eq(0).html();

        var _institucion = '<institucion>' + _inst + '</institucion>';
        _otrasInstitucionesXml = _otrasInstitucionesXml + _institucion;
    });
    _otrasInstitucionesXml = _otrasInstitucionesXml + '</otrasInstituciones>';

    return _otrasInstitucionesXml;
}