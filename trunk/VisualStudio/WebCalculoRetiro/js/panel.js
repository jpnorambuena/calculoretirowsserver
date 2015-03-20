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
    $( "#tabs" ).tabs({
      collapsible: true
    });


    $("#celdaCantidadDeAcciones").hide();
    $("#celdaTipoDeAcciones").hide();
    $("#celdaGradoJerarquico").hide();
    $("#celdaEscalafonCivil").hide();
    $("#celdaGrado").hide();
    $("#celdaEsDeLinea").hide();
    $("#celdaSueldoMinistroDeCorte").hide();

    $('input[name=poseeAcciones]:radio').on("change", function() {
        actualizarAcciones(this);       
    });
    
    
    $('#celdaCategoria > .ui-combobox > .ui-combobox-input').on("focusout", function() {
        mostrarGrado(this);       
    });
    
    $('#celdaGrado > .ui-combobox > .ui-combobox-input').on("focusout", function() {
        mostrarEsDeLinea(this);       
    });
 
    $('input[name=esMinistroDeCorte]:radio').on("change", function() {
        mostrarSueldoMinistroDeCorte(this);       
    });


    $(".numerico").keydown(function (e) {
        restringirNumerico(e);
    });

    $(".numerico").on("keyup", function (e) {
        var elemento =  $('input[name='+this.name+']:input');
        
        var valor = e.target.value;
        darFormatoDeMiles(elemento, valor);
    });

    
    $('#tiRun').Rut({
        on_error: function(){ 
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
		monthNames: ["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"],
		monthNamesShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"],
		dayNames: ["Domingo", "Lunes", "Martes", "Mi\u00E9rcoles", "Jueves", "Viernes", "S\u00E1bado"],
		dayNamesShort: ["Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"],
		dayNamesMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
		weekHeader: "Se",
		dateFormat: "dd/mm/yy"
    });

    
    dialogAbono = $( "#dialog-abono" ).dialog({
        autoOpen: false,
        height: 300,
        width: 500,
        modal: true,
        buttons: [
            {
                text: "Agregar",
                name: "btnAgregar",
                click: function()
                    {
                        $("#sltTipoAbono,#tiAniosAbono,#tiMesesAbono,#tiDiasAbono").removeClass( "ui-state-error" );
                        agregarFila("Abono");
                    }
            },
            {
                text: "Cerrar",
                name: "btnCerrar",
                click: function(){dialogAbono.dialog( "close" );}
            }
        ],
        open: function(){
            var dialog = dialogAbono.parent();
            dialog
                .find("button[name='btnAgregar']")
                .button({ icons: { primary: "ui-icon-disk" } });
            dialog
                .find("button[name='btnCerrar']")
                .button({ icons: { primary: "ui-icon-close" } });
        },

        close: function() {
            dialogAbono
                .find('.validateTips')
                .text('Ingrese datos:');
            formAbono[0].reset();
            $("#sltTipoAbono,#tiAniosAbono,#tiMesesAbono,#tiDiasAbono").removeClass( "ui-state-error" );
           /* if(vData.estado.toString()=="0"){dialogFunc.dialog( "open" );}*/
        }
    });

    formAbono = dialogAbono.find( "form" ).on( "submit", function( event ) {
        event.preventDefault();
    });
    
    $('#btnNuevoAbono').on("click", function (evento) {
        
        var $tips = $('#dialog-abono .validateTips');
        dialogAbono
            .dialog({title:'Nuevo abono'})
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

    dialogConcurrencia = $( "#dialog-concurrencia" ).dialog({
        autoOpen: false,
        height: 300,
        width: 500,
        modal: true,
        buttons: [
            {
                text: "Agregar",
                name: "btnAgregar",
                click: function()
                    {
                        $("#sltTipoConcurrencia,#tiAniosConcurrencia,#tiMesesConcurrencia,#tiDiasConcurrencia").removeClass( "ui-state-error" );
                        agregarFila("Concurrencia");
                    }
            },
            {
                text: "Cerrar",
                name: "btnCerrar",
                click: function(){dialogConcurrencia.dialog( "close" );}
            }
        ],
        open: function(){
            var dialog = dialogConcurrencia.parent();
            dialog
                .find("button[name='btnAgregar']")
                .button({ icons: { primary: "ui-icon-disk" } });
            dialog
                .find("button[name='btnCerrar']")
                .button({ icons: { primary: "ui-icon-close" } });
        },

        close: function() {
            dialogConcurrencia
                .find('.validateTips')
                .text('Ingrese datos:');
            formConcurrencia[0].reset();
            $("#sltTipoConcurrencia,#tiAniosConcurrencia,#tiMesesConcurrencia,#tiDiasConcurrencia").removeClass( "ui-state-error" );
           /* if(vData.estado.toString()=="0"){dialogFunc.dialog( "open" );}*/
        }
    });
     
    formConcurrencia = dialogConcurrencia.find( "form" ).on( "submit", function( event ) {
        event.preventDefault();
    });
    
    $('#btnNuevaConcurrencia').on("click", function (evento) {
        
        var $tips = $('#dialog-concurrencia .validateTips');
        dialogConcurrencia
            .dialog({title:'Nueva concurrencia'})
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


    dialogOtraInstitucion = $( "#dialog-otra-inst" ).dialog({
        autoOpen: false,
        height: 300,
        width: 500,
        modal: true,
        buttons: [
            {
                text: "Agregar",
                name: "btnAgregar",
                click: function()
                    {
                        $("#sltOtraInstitucion").removeClass( "ui-state-error" );
                        agregarFilaSimple("Institucion");
                    }
            },
            {
                text: "Cerrar",
                name: "btnCerrar",
                click: function(){dialogOtraInstitucion.dialog( "close" );}
            }
        ],
        open: function(){
            var dialog = dialogOtraInstitucion.parent();
            dialog
                .find("button[name='btnAgregar']")
                .button({ icons: { primary: "ui-icon-disk" } });
            dialog
                .find("button[name='btnCerrar']")
                .button({ icons: { primary: "ui-icon-close" } });
        },

        close: function() {
            dialogOtraInstitucion
                .find('.validateTips')
                .text('Ingrese datos:');
            formOtraInst[0].reset();
            $("#sltTipoAbono,#tiAniosAbono,#tiMesesAbono,#tiDiasAbono").removeClass( "ui-state-error" );
           /* if(vData.estado.toString()=="0"){dialogFunc.dialog( "open" );}*/
        }
    });

    formOtraInst = dialogOtraInstitucion.find( "form" ).on( "submit", function( event ) {
        event.preventDefault();
    });
    
    $('#btnNuevaInstitucion').on("click", function (evento) {
        
        var $tips = $('#dialog-otra-inst .validateTips');
        dialogOtraInstitucion
            .dialog({title:'Nueva institución'})
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

    
    $('#btnCalcularPension').on("click", function (evento) {

        var vRun = $('#tiRun').val();
        var vInstitucion = $('#sltInstitucion').val();
        var vSubInstitucion = $('#sltSubinstitucion').val;
        var vCategoria = $('#sltCategoria').val();
        var vGrado = $('#sltGrado').val();
        var vGradoJerarquico = $('#sltGradoJerarquico').val(); /*$( "#sltGradoJerarquico option:selected" ).text();*/
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


        
        /*
<otrasInstituciones>&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt; &lt;grilla&gt; &lt;columna id=\"_Institucion\" titulo=\"Institución\" orden=\"1\" tipoDato=\"ALF\"&gt; &lt;valor orden=\"0\" tipoDato=\"null\"&gt;Asmar&lt;/valor&gt; &lt;valor orden=\"1\" tipoDato=\"null\"&gt;Carabineros&lt;/valor&gt;  &lt;valor orden=\"2\" tipoDato=\"null\"&gt;DGAC&lt;/valor&gt; &lt;/columna&gt; &lt;/grilla&gt;</otrasInstituciones>
            <abonos>&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt; &lt;grilla&gt; &lt;columna id=\"_Abono\" titulo=\"Abono\" orden=\"1\" tipoDato=\"ALF\"&gt; &lt;valor orden=\"0\" tipoDato=\"null\"&gt;Abono por hijos&lt;/valor&gt; &lt;valor orden=\"1\" tipoDato=\"null\"&gt;Abono por viudez&lt;/valor&gt; &lt;valor orden=\"2\" tipoDato=\"null\"&gt;Abono por lesiones&lt;/valor&gt; &lt;/columna&gt; &lt;columna id=\"_Anios\" titulo=\"Años\" orden=\"2\" tipoDato=\"NUM\"&gt; &lt;valor orden=\"0\" tipoDato=\"null\"&gt;10&lt;/valor&gt; &lt;valor orden=\"1\" tipoDato=\"null\"&gt;4&lt;/valor&gt; &lt;valor orden=\"2\" tipoDato=\"null\"&gt;4&lt;/valor&gt; &lt;/columna&gt; &lt;columna id=\"_Meses\" titulo=\"Meses\" orden=\"3\" tipoDato=\"NUM\"&gt; &lt;valor orden=\"0\" tipoDato=\"null\"&gt;2&lt;/valor&gt; &lt;valor orden=\"1\" tipoDato=\"null\"&gt;6&lt;/valor&gt; &lt;valor orden=\"2\" tipoDato=\"null\"&gt;1&lt;/valor&gt; &lt;/columna&gt; &lt;columna id=\"_Días\" titulo=\"Días\" orden=\"4\" tipoDato=\"NUM\"&gt; &lt;valor orden=\"0\" tipoDato=\"null\"&gt;3&lt;/valor&gt; &lt;valor orden=\"1\" tipoDato=\"null\"&gt;15&lt;/valor&gt; &lt;valor orden=\"2\" tipoDato=\"null\"&gt;25&lt;/valor&gt; &lt;/columna&gt; &lt;/grilla&gt; </abonos>
            <concurrencias>&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt; &lt;grilla&gt; &lt;columna id=\"_Concurrencia\" titulo=\"Concurrencia\" orden=\"1\" tipoDato=\"ALF\"&gt; &lt;valor orden=\"0\" tipoDato=\"null\"&gt;Canaempu&lt;/valor&gt; &lt;valor orden=\"1\" tipoDato=\"null\"&gt;Dipreca&lt;/valor&gt; &lt;valor orden=\"2\" tipoDato=\"null\"&gt;Empart&lt;/valor&gt; &lt;/columna&gt; &lt;columna id=\"_Anios\" titulo=\"Años\" orden=\"2\" tipoDato=\"NUM\"&gt; &lt;valor orden=\"0\" tipoDato=\"null\"&gt;10&lt;/valor&gt; &lt;valor orden=\"1\" tipoDato=\"null\"&gt;2&lt;/valor&gt; &lt;valor orden=\"2\" tipoDato=\"null\"&gt;5&lt;/valor&gt; &lt;/columna&gt; &lt;columna id=\"_Meses\" titulo=\"Meses\" orden=\"3\" tipoDato=\"NUM\"&gt; &lt;valor orden=\"0\" tipoDato=\"null\"&gt;2&lt;/valor&gt; &lt;valor orden=\"1\" tipoDato=\"null\"&gt;3&lt;/valor&gt; &lt;valor orden=\"2\" tipoDato=\"null\"&gt;6&lt;/valor&gt; &lt;/columna&gt; &lt;columna id=\"_Días\" titulo=\"Días\" orden=\"4\" tipoDato=\"NUM\"&gt; &lt;valor orden=\"0\" tipoDato=\"null\"&gt;3&lt;/valor&gt; &lt;valor orden=\"1\" tipoDato=\"null\"&gt;4&lt;/valor&gt; &lt;valor orden=\"2\" tipoDato=\"null\"&gt;4&lt;/valor&gt; &lt;/columna&gt; "+ &lt;/grilla&gt;</concurrencias>

        */
        var vOtrasInstituciones = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> "+
									"<grilla> "+
									"	<columna id=\"_Institucion\" titulo=\"Institución\" orden=\"1\" tipoDato=\"ALF\"> "+
									"		<valor orden=\"0\" tipoDato=\"null\">Asmar</valor> "+
									"		<valor orden=\"1\" tipoDato=\"null\">Carabineros</valor> "+ 
									"		<valor orden=\"2\" tipoDato=\"null\">DGAC</valor> "+
									"	</columna> "+
									"</grilla>";
		
		var vAbonos = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> "+
									"<grilla>  "+
									"	<columna id=\"_Abono\" titulo=\"Abono\" orden=\"1\" tipoDato=\"ALF\">  "+
									"		<valor orden=\"0\" tipoDato=\"null\">Abono por hijos</valor>  "+
									"		<valor orden=\"1\" tipoDato=\"null\">Abono por viudez</valor>  "+
									"		<valor orden=\"2\" tipoDato=\"null\">Abono por lesiones</valor>  "+
									"	</columna>  "+
									"	<columna id=\"_Anios\" titulo=\"Años\" orden=\"2\" tipoDato=\"NUM\"> "+ 
									"		<valor orden=\"0\" tipoDato=\"null\">10</valor>  "+
									"		<valor orden=\"1\" tipoDato=\"null\">4</valor>  "+
									"		<valor orden=\"2\" tipoDato=\"null\">4</valor>  "+
									"	</columna>  "+
									"	<columna id=\"_Meses\" titulo=\"Meses\" orden=\"3\" tipoDato=\"NUM\">  "+
									"		<valor orden=\"0\" tipoDato=\"null\">2</valor>  "+
									"		<valor orden=\"1\" tipoDato=\"null\">6</valor>  "+
									"		<valor orden=\"2\" tipoDato=\"null\">1</valor>  "+
									"	</columna>  "+
									"	<columna id=\"_Días\" titulo=\"Días\" orden=\"4\" tipoDato=\"NUM\">  "+
									"		<valor orden=\"0\" tipoDato=\"null\">3</valor>  "+
									"		<valor orden=\"1\" tipoDato=\"null\">15</valor>  "+
									"		<valor orden=\"2\" tipoDato=\"null\">25</valor>  "+
									"	</columna> "+
									"</grilla>"; 
				
		var vConcurrencias = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>  "+
								"<grilla>  "+
								"	<columna id=\"_Concurrencia\" titulo=\"Concurrencia\" orden=\"1\" tipoDato=\"ALF\">  "+
								"		<valor orden=\"0\" tipoDato=\"null\">Canaempu</valor>  "+
								"		<valor orden=\"1\" tipoDato=\"null\">Dipreca</valor>  "+
								"		<valor orden=\"2\" tipoDato=\"null\">Empart</valor>  "+
								"	</columna>  "+
								"	<columna id=\"_Anios\" titulo=\"Años\" orden=\"2\" tipoDato=\"NUM\">  "+
								"		<valor orden=\"0\" tipoDato=\"null\">10</valor>  "+
								"		<valor orden=\"1\" tipoDato=\"null\">2</valor>  "+
								"		<valor orden=\"2\" tipoDato=\"null\">5</valor>  "+
								"	</columna>  "+
								"	<columna id=\"_Meses\" titulo=\"Meses\" orden=\"3\" tipoDato=\"NUM\">  "+
								"		<valor orden=\"0\" tipoDato=\"null\">2</valor>  "+
								"		<valor orden=\"1\" tipoDato=\"null\">3</valor>  "+
								"		<valor orden=\"2\" tipoDato=\"null\">6</valor>  "+
								"	</columna>  "+
								"	<columna id=\"_Días\" titulo=\"Días\" orden=\"4\" tipoDato=\"NUM\">  "+
								"		<valor orden=\"0\" tipoDato=\"null\">3</valor>  "+
								"		<valor orden=\"1\" tipoDato=\"null\">4</valor>  "+
								"		<valor orden=\"2\" tipoDato=\"null\">4</valor>  "+
								"	</columna> "+
								"</grilla> ";


        

        var param = '<?xml version="1.0" encoding="utf-8" ?>' +
                    '<soap:envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"' +
                    'xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">' +
                    '<soap:body>' +
                    '<calcular xmlns="http://wsdl.ssffaa.cl/CalculoRetiro">' +
                    '"<run>"' + vRun + '"</run>"' +
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
                    '</calcular>' +
                    '</soap:body>' +
                    '</soap:envelope>';
    
        var param2 = '<?xml version="1.0" encoding="utf-8"?>' +
                        '<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" ' +
                        'xmlns:xsd="http://www.w3.org/2001/XMLSchema" ' +
                        'xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">' +
                        '<soap:Body>' +
                        '<calcular xmlns="http://wsdl.ssffaa.cl/CalculoRetiro">' +
                        '<run>16.023.917-4</run>' +
                        '<institucion>FUERZA AÉREA</institucion>' +
                        '<subInstitucion>FUERZA AÉREA</subInstitucion>' +
                        '<categoria>OFICIAL (FA)</categoria>' +
                        '<escalafonCivil>prof.</escalafonCivil>' +
                        '<grado>CORONEL DE AVIACIÓN</grado>' +
                        '<gradoJerarquico>4</gradoJerarquico>' +
                        '<gradoEconomico>1</gradoEconomico>' +
                        '<esDeLinea>NO</esDeLinea>' +
                        '<fechaDeBaja>2015-01-31</fechaDeBaja>' +
                        '<cantidadDeAcciones>10</cantidadDeAcciones>' +
                        '<tipoDeAcciones>Con AEGE</tipoDeAcciones>' +
                        '<porcentajeDeSobresueldo>21%</porcentajeDeSobresueldo>' +
                        '<porcentajeDeSegundoSobresueldo>20%</porcentajeDeSegundoSobresueldo>' +
                        '<porcentajeDeAsignacionSOFSOM>25%</porcentajeDeAsignacionSOFSOM>' +
                        '<poseeAsigMinistroDeCorte>SI</poseeAsigMinistroDeCorte>' +
                        '<sueldoIntegroMinistroDeCorte>100000</sueldoIntegroMinistroDeCorte>' +
                        '<planillaSuplementariaLey19699>3</planillaSuplementariaLey19699>' +
                        '<planillaSuplementariaDFL1_68>3</planillaSuplementariaDFL1_68>' +
                        '<aniosCPDNyConsc>26</aniosCPDNyConsc>' +
                        '<mesesCPDNyConsc>24</mesesCPDNyConsc>' +
                        '<diasCPDNyConsc>33</diasCPDNyConsc>' +
                        '<aniosDesahucio>19</aniosDesahucio>' +
                        '<mesesDesahucio>15</mesesDesahucio>' +
                        '<diasDesahucio>32</diasDesahucio>' +
                        '<otrasInstituciones>' + vOtrasInstituciones + '</otrasInstituciones>' +
                        '<abonos>' + vAbonos + '</abonos>' +
                        '<concurrencias>' + vConcurrencias + '</concurrencias>' +
                        '</calcular>' +
                        '</soap:body>' +
                        '</soap:envelope>';

        var param3 = '<![CDATA[<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://wsdl.ssffaa.cl/CalculoRetiro">' +
   '<soapenv:Header/>' +
   '<soapenv:Body>' +
      '<cal:calcular>' +
        ' <run>16.023.917-4</run>' +
	    '<institucion>FUERZA AÉREA</institucion>' +
	    '<subInstitucion>FUERZA AÉREA</subInstitucion>' +
	    '<categoria>OFICIAL (FA)</categoria>' +
	    '<escalafonCivil></escalafonCivil>' +
	    '<grado>CORONEL DE AVIACIÓN</grado>' +
	    '<gradoJerarquico>4</gradoJerarquico>' +
	    '<gradoEconomico>1</gradoEconomico>' +
	    '<esDeLinea>NO</esDeLinea>' +
	    '<fechaDeBaja>2015-01-31</fechaDeBaja>' +
	    '<cantidadDeAcciones>10</cantidadDeAcciones>' +
	    '<tipoDeAcciones>Con AEGE</tipoDeAcciones>' +
	    '<porcentajeDeSobresueldo>21%</porcentajeDeSobresueldo>' +
	    '<porcentajeDeSegundoSobresueldo>20%</porcentajeDeSegundoSobresueldo>' +
	    '<porcentajeDeAsignacionSOFSOM>25%</porcentajeDeAsignacionSOFSOM>' +
	    '<poseeAsigMinistroDeCorte>SI</poseeAsigMinistroDeCorte>' +
	    '<sueldoIntegroMinistroDeCorte>100000</sueldoIntegroMinistroDeCorte>' +
	    '<planillaSuplementariaLey19699>3</planillaSuplementariaLey19699>' +
	    '<planillaSuplementariaDFL1_68>3</planillaSuplementariaDFL1_68>' +
	    '<aniosCPDNyConsc>26</aniosCPDNyConsc>' +
	    '<mesesCPDNyConsc>24</mesesCPDNyConsc>' +
	    '<diasCPDNyConsc>33</diasCPDNyConsc>' +
	    '<aniosDesahucio>19</aniosDesahucio>' +
	   ' <mesesDesahucio>15</mesesDesahucio>' +
	  '  <diasDesahucio>32</diasDesahucio>' +
     '    <otrasInstituciones><![CDATA[<?xml version="1.0" encoding="UTF-8"?>' +
	'		<grilla>' +
	'			<columna id="_Institucion" titulo="Institución" orden="1" tipoDato="ALF">' +
	'				<valor orden="0" tipoDato="null">Asmar</valor>' +
	'				<valor orden="1" tipoDato="null">Carabineros</valor>' +
	'				<valor orden="2" tipoDato="null">DGAC</valor>' +
	'			</columna>' +
	'		</grilla>' +
	'		]]>' +
	'	</otrasInstituciones>' +
	'	<abonos><![CDATA[<?xml version="1.0" encoding="UTF-8"?>' +
	'		<grilla>' +
	'			<columna id="_Abono" titulo="Abono" orden="1" tipoDato="ALF">' +
	'				<valor orden="0" tipoDato="null">Abono por hijos</valor>' +
	'				<valor orden="1" tipoDato="null">Abono por viudez</valor>' +
	'				<valor orden="2" tipoDato="null">Abono por lesiones</valor>' +
	'			</columna>' +
	'			<columna id="_Anios" titulo="Años" orden="2" tipoDato="NUM">' +
	'				<valor orden="0" tipoDato="null">10</valor>' +
	'				<valor orden="1" tipoDato="null">4</valor>' +
	'				<valor orden="2" tipoDato="null">4</valor>' +
	'			</columna>' +
	'			<columna id="_Meses" titulo="Meses" orden="3" tipoDato="NUM">' +
	'				<valor orden="0" tipoDato="null">2</valor>' +
	'				<valor orden="1" tipoDato="null">6</valor>' +
	'				<valor orden="2" tipoDato="null">1</valor>' +
	'			</columna>' +
	'			<columna id="_Días" titulo="Días" orden="4" tipoDato="NUM">' +
	'				<valor orden="0" tipoDato="null">3</valor>' +
	'				<valor orden="1" tipoDato="null">15</valor>' +
	'				<valor orden="2" tipoDato="null">25</valor>' +
	'			</columna>' +
	'		</grilla>' +
	'		]]>' +
	'	</abonos>' +
	'	<concurrencias><![CDATA[<?xml version="1.0" encoding="UTF-8"?>' +
	'		<grilla>' +
	'			<columna id="_Concurrencia" titulo="Concurrencia" orden="1" tipoDato="ALF">' +
	'				<valor orden="0" tipoDato="null">Canaempu</valor>' +
	'				<valor orden="1" tipoDato="null">Dipreca</valor>' +
	'				<valor orden="2" tipoDato="null">Empart</valor>' +
	'			</columna>' +
	'			<columna id="_Anios" titulo="Años" orden="2" tipoDato="NUM">' +
	'				<valor orden="0" tipoDato="null">10</valor>' +
	'				<valor orden="1" tipoDato="null">2</valor>' +
	'				<valor orden="2" tipoDato="null">5</valor>' +
	'			</columna> ' +
	'			<columna id="_Meses" titulo="Meses" orden="3" tipoDato="NUM">' +
	'				<valor orden="0" tipoDato="null">2</valor>' +
	'				<valor orden="1" tipoDato="null">3</valor>' +
	'				<valor orden="2" tipoDato="null">6</valor>' +
	'			</columna>' +
	'			<columna id="_Días" titulo="Días" orden="4" tipoDato="NUM">' +
	'				<valor orden="0" tipoDato="null">3</valor>' +
	'				<valor orden="1" tipoDato="null">4</valor>' +
	'				<valor orden="2" tipoDato="null">4</valor>' +
	'			</columna>' +
	'		</grilla>' +
	'		]]>' +
	'	</concurrencias>' +
  '    </cal:calcular>' +
 '  </soapenv:Body>' +
'</soapenv:Envelope>]]>' ;







        //calcular(param3);
        calcularX();
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
    
 
   
 
   /*
function calcular(param) {
    //var param = { _Tipo: TipoBusqueda, _xmlParam: xParam };


    var dataSet = "";
    $.ajax({
        type: "POST",
        url: "panel.aspx/rDocuDigital_Filtro",
        data: JSON.stringify(param),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            dataSet = response.d;
            var mCol = dataSet[0];    //.split("|");
            var mDat = dataSet[1];


            if (mCol != "-1") {
                CreaTabla(mCol.length, 1, principal, mDat, mCol);

            } else {
                $("#dialog-message").dialog({
                    modal: true,
                    buttons: {
                        Ok: function () {
                            $(this).dialog("close");
                        }
                    }
                });

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
*/

function calcular(mensaje)
{
    //Creamos la variable que contiene la url del webservice
    var webServiceURL = 'http://unibox.ssffaa.cl/CalculoRetiroWSServer/services/CalculoRetiroWSSOAP?wsdl';
    //Este es el mensaje SOAP, dentro de las etiquetas <CI>'+ $('#ci').val() +'</CI> hacemos uso de una función JQuery para obtener valor que está en el campo de texto
    var soapMessage = mensaje;
 
    //Llamamos a la función AJAX de JQuery
    $.ajax({
        url: webServiceURL,
        type: "POST",
        cache: false,
        data: soapMessage,
        SOAPAction: "calcular",
        contentType: "text/xml",
        success: OnSuccess,
        error: OnError

    });
    return false;
}
//Función que se ejecuta si realizó completa la petición
function OnSuccess(data, status)
{
        //Aquí mostramos el valor que aparece en la etiqueta "PrimerNombre" del cuerpo de respuesta
        alert($(data).find("PrimerNombre").text());
}
function OnError(request, status, error)  //Función que se ejecuta si ocurre algún error
{
    alert(status);
}
$(function() {
    //Evita problemas de cross-domain con JQuery
    jQuery.support.cors = true;
});


function calcularX(){
    var param = {
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



    //console.info('panel.js cargaGuiaMinisterial --> param: '+JSON.stringify(param));
    var dataSet = "";
    $.ajax({
        type: "POST",
        url: "panel.aspx/calcular",
        data: JSON.stringify(param),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            dataSet = response.d;
            alert("SUCCES");
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