<%@ Page Language="VB" AutoEventWireup="false" CodeFile="panel.aspx.vb" Inherits="panel" Debug="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>c&aacute;lculoRetiro - Sistema de c&aacute;lculo de pensiones de retiro del personal de las FF.AA.</title>
    <link href="css/panel2.css" rel="stylesheet" type="text/css" />
    <link href="ui/1.11.1/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery_1.10.2.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.11.js"></script> 
    <script src="js/jquery.blockUI.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/panel.js"></script> 
    <script type="text/javascript" src="js/rut.js"></script> 
    <script type="text/javascript" src="js/listas.js"></script> 
    <script type="text/javascript" src="js/jquery.ui.combobox.js"></script>
    <script type="text/javascript" src="js/jquery.tabletojson.js"></script>
    
    <script type="text/javascript">
        $(function () {


        });  //fin function
    </script>
   
  
   
  
</head>
<body>


    <div id="container">
            
            <div id='header'>
                <form id="frmHeader" runat="server">
                    <div id="logo" style="float:left">
                        <img src="img/logoSSFFAA.jpg" alt="" style="width: 120px; top: 0px; border: 0" />
                    </div>
                    <div>
                        <div id='infoUser'>
                            <div class="UserLogueado">
                                &nbsp;
                                <asp:TextBox ID="txtUserName" runat="server" BorderStyle="None" ReadOnly="true"></asp:TextBox></div>
                            <br />
                            <br />
                        </div>
                        <div id='infoLogo' style="">
                            <h1 id="h1"><span><span style="color: #888">c&aacute;lculo</span>Retiro</span></h1>
	                        <span class='title'>C&aacute;lculo Retiro - Sistema de c&aacute;lculo de pensiones de retiro del personal de las Fuerzas Armadas</span>
                        </div>                    
                    </div>
                    
                </form>
                <div>
                    <div>
                        <button id="bttSalir">Salir</button>
                    </div>
                </div>
            </div>
        
            <div id="principal" class="ui-widget-content">
                
                <div id="tabs">
                    <ul>
                        <li><a href="#tabs-info-general">Información general</a></li>
                        <li><a href="#tabs-otras-instituciones">Otras instituciones</a></li>
                        <li><a href="#tabs-abonos">Abonos</a></li>
                        <li><a href="#tabs-concurrencias">Concurrencias</a></li>
                        <li><a href="#tabs-resultados">Resultados</a></li>
                    </ul>
                    <div id="tabs-info-general">
                        <p>Ingrese la información solicitada.</p>
                        <form id="frmPrincipal" >
                           
                            <div class="newFila">
                                <label for="Run">Run</label>
                                <input type="text" name="tiRun" id="tiRun" value="" class="run ui-widget-content ui-corner-all"/>
                            </div>
                            <div class="newFila">
                                <label for="Institucion">Institución</label>
                                <select name="sltInstitucion" id="sltInstitucion" class="combobox ui-widget-content ui-corner-all" onchange="setCategorias(this,sltCategoria,sltGrado)">
                                    <option value="-1" selected="selected">[SELECCIONE]</option>
                                    <script type="text/javascript">
                                        setInstituciones();
                                    </script>
                                </select>
                                <label for="Subinstitucion">Subinstitución</label>
                                <select name="sltSubinstitucion" id="sltSubinstitucion"  class="combobox ui-widget-content ui-corner-all">
                                    <option value="-1" selected="selected">[SELECCIONE]</option>
                                    <script type="text/javascript">
                                        setInstituciones();
                                    </script>
                                </select>
                            </div>
                            <div class="newFila">
                                <label for="Categoria">Categoría</label>
                                <select name="sltCategoria" id="sltCategoria"  class="combobox ui-widget-content ui-corner-all" onchange="setGrado(this,sltGrado)">
                                    <option value="-1" selected="selected">[SELECCIONE]</option>
                                </select>
                                <label for="Grado">Grado</label>
                                <select name="sltGrado" id="sltGrado"  class="combobox ui-widget-content ui-corner-all">
                                    <option value="-1" selected="selected">[SELECCIONE]</option>
                                </select>
                                <label for="EsDeLinea">Es de línea</label>
                                <input type="radio" name="esDeLinea" value="SI"/>
                                <label for="EsDeLineaSI" class="opcionRadio">Si</label>
                                <input type="radio" name="esDeLinea" value="NO" checked/>
                                <label for="EsDeLineaNO" class="opcionRadio">No</label>
                            </div>
                            <div class="newFila">
                                <label for="GradoEconomico">Grado económico</label>
                                <select id="sltGradoEconomico"  class="combobox ui-widget-content ui-corner-all">
                                    <option value="-1" selected="selected">[SELECCIONE]</option>
                                    <script type="text/javascript">
                                        cargarLista("Grados economicos");
                                    </script>
                                </select>
                                <label for="GradoJerarquico">Grado jerárquico</label>
                                <select id="sltGradoJerarquico"  class="combobox ui-widget-content ui-corner-all">
                                    <option value="-1" selected="selected">[SELECCIONE]</option>
                                    <script type="text/javascript">
                                        cargarLista("Grados jerarquicos");
                                    </script>
                                </select>
                            </div>










                                <div class="fila">
                                    
                                    <div class="celda">
                                        
                                    </div>
                                </div>
                                <div class="fila">
                                    <div id="celdaCategoria" class="celda">
                                        
                                    </div>
                                    <div class="celda">
                                        <div id="celdaGrado" >
                                            
                                        </div> 
                                        <div id="celdaGradoJerarquico" >
                                            
                                        </div>
                            
                                    </div>
                                    <div id="celdaEsDeLinea" class="celda">
                                        
                                    </div>
                                </div>
                                <div class="fila">
                                    <div class="celda">
                                        
                                    </div>
                                    <div id="celdaEscalafonCivil" class="celda">
                                        <label for="EscalafonCivil" class="etiqueta">Escalafón civil</label>
                                        <select id="sltEscalafonCivil"  class="combobox ui-widget-content ui-corner-all">
                                            <option value="-1" selected="selected">[SELECCIONE]</option>
                                            <script type="text/javascript">
                                                cargarListaValor("Escalafon civil");
                                            </script>
                                        </select>
                                    </div>
                                </div>

                                <div class="fila">
                                    <div class="celda">
                                        <label for="FechaBaja" class="etiqueta">Fecha de baja</label>
                                        <input type="text" id="dtFechaBaja" class="datepicker ui-widget-content ui-corner-all"/>
                                    </div>
                                </div>

                                <div class="fila">
                                    <div id="celdaPoseeAcciones" class="celda">
                                        <label for="PoseeAcciones" class="etiqueta">Posee acciones</label>
                                        <input type="radio" id="radioPoseeAccionesSi" name="poseeAcciones" value="SI"/>
                                        <label for="PoseeAccionesSI" class="etiquetaOpcionRadio">Si</label>
                                        <input type="radio" id="radioPoseeAccionesNo" name="poseeAcciones" value="NO"/>
                                        <label for="PoseeAccionesNO" class="etiquetaOpcionRadio">No</label>

                                    </div>
                                    <div id="celdaCantidadDeAcciones" class="celda">
                                        <label for="CantidadAcciones" class="etiqueta">Cantidad</label>
                                        <input type="text" name="cantidadAcciones" id="tiCantidadAcciones" value="" class="numerico ui-widget-content ui-corner-all"/>
                                    </div>
                                    <div id="celdaTipoDeAcciones" class="celda">
                                        <label for="TipoAcciones" class="etiqueta">Tipo</label>
                                        <input type="radio" name="tipoAcciones" value="Con AEGE"/>
                                        <label for="TipoAccionesConAege" class="etiquetaOpcionRadio">Con AEGE</label>
                                        <input type="radio" name="tipoAcciones" value="Sin AEGE"/>
                                        <label for="TipoAccionesSinAege" class="etiquetaOpcionRadio">Sin AEGE</label>
                                    </div>
                                </div>

                                <div class="fila">
                                    <div class="celda">
                                        <label for="Sobresueldo" class="etiqueta">Sobresueldo</label>
                                        <select id="sltSobresueldo"  class="combobox ui-widget-content ui-corner-all">
                                            <option value="-1" selected="selected">[SELECCIONE]</option>
                                            <script type="text/javascript">
                                                cargarListaValor("Sobresueldos");
                                            </script>
                                        </select>

                                    </div>
                                    <div class="celda">
                                        <label for="SegundoSobresueldo" class="etiqueta">Segundo sobresueldo</label>
                                        <select id="sltSegundoSobresueldo"  class="combobox ui-widget-content ui-corner-all">
                                            <option value="-1" selected="selected">[SELECCIONE]</option>
                                            <script type="text/javascript">
                                                cargarListaValor("Segundo sobresueldo");
                                            </script>
                                        </select>
                                    </div>
                                </div>

                                <div class="fila">
                                    <div class="celda">
                                        <label for="AsignacionSOFSOM" class="etiqueta">Asig. SOF/SOM</label>
                                        <select id="sltAsignacionSOFSOM"  class="combobox ui-widget-content ui-corner-all">
                                            <option value="-1" selected="selected">[SELECCIONE]</option>
                                            <script type="text/javascript">
                                                cargarListaValor("Asignacion SOFSOM");
                                            </script>
                                        </select>
                                    </div>
                                </div>

                                <div class="fila">
                                    <div id="celdaMinistroDeCorte" class="celda">
                                        <label for="EsMinistroDeCorte" class="etiqueta">Posee asig. Min. Corte</label>
                                        <input type="radio" id="radioEsMinistroDeCorteSi" name="esMinistroDeCorte" value="SI"/>
                                        <label for="EsMinistroDeCorteSI">Si</label>
                                        <input type="radio" id="radioEsMinistroDeCorteNo" name="esMinistroDeCorte" value="NO"/>
                                        <label for="EsMinistroDeCorteNO">No</label>

                                    </div>
                                    <div id="celdaSueldoMinistroDeCorte" class="celda">
                                        <label for="CantidadAcciones" class="etiqueta">Sueldo íntegro</label>
                                        <input type="text" name="sueldoMinistroDeCorte" id="tiSueldoMinistroDeCorte" value="" class="numerico ui-widget-content ui-corner-all"/>
                                    </div>
                                </div>

                                <div class="fila">
                                    <div class="celda">
                                        <label for="PlanillaSupl19699" class="etiqueta">Pla. Supl. Ley 19.699</label>
                                        <select id="sltPlanSuplLey19699"  class="combobox ui-widget-content ui-corner-all">
                                            <option value="-1" selected="selected">[SELECCIONE]</option>
                                            <script type="text/javascript">
                                                cargarLista("Planilla Supl 19699");
                                            </script>
                                        </select>

                                    </div>
                                    <div class="celda">
                                        <label for="PlanillaSuplDFL1" class="etiqueta">Pla. Supl. DFL 1/68</label>
                                        <select id="sltPlanSuplDFL1"  class="combobox ui-widget-content ui-corner-all">
                                            <option value="-1" selected="selected">[SELECCIONE]</option>
                                            <script type="text/javascript">
                                                cargarLista("Planilla Supl DFL1");
                                            </script>
                                        </select>
                                    </div>
                                </div>


                                <div class="fila">
                                    <div class="celda">
                                        <label for="AniosCapredena" class="etiqueta">Años CAPREDENA</label>
                                        <input type="text" name="aniosCapredena" id="tiAniosCapredena" value="" class="numerico ui-widget-content ui-corner-all"/>
                                    </div>
                                    <div class="celda">
                                        <label for="MesesCapredena" class="etiqueta">Meses CAPREDENA</label>
                                        <input type="text" name="mesesCapredena" id="tiMesesCapredena" value="" class="numerico ui-widget-content ui-corner-all"/>
                                    </div>
                                    <div class="celda">
                                        <label for="DiasCapredena" class="etiqueta">Días CAPREDENA</label>
                                        <input type="text" name="diasCapredena" id="tiDiasCapredena" value="" class="numerico ui-widget-content ui-corner-all"/>
                                    </div>
                                </div>

                                <div class="fila">
                                    <div class="celda">
                                        <label for="AniosCapredena" class="etiqueta">Años desahucio</label>
                                        <input type="text" name="aniosDesahucio" id="tiAniosDesahucio" value="" class="numerico ui-widget-content ui-corner-all"/>
                                    </div>
                                    <div class="celda">
                                        <label for="MesesCapredena" class="etiqueta">Meses desahucio</label>
                                        <input type="text" name="mesesDesahucio" id="tiMesesDesahucio" value="" class="numerico ui-widget-content ui-corner-all"/>
                                    </div>
                                    <div class="celda">
                                        <label for="DiasCapredena" class="etiqueta">Días desahucio</label>
                                        <input type="text" name="diasDesahucio" id="tiDiasDesahucio" value="" class="numerico ui-widget-content ui-corner-all"/>
                                    </div>
                                </div>
                        </form>
                    </div>
                    <div id="tabs-otras-instituciones">
                        <p>Ingrese otras instituciones en las que prestó servicios.</p>
                        <div class="contenedor-tabla-simple ui-widget">
                            <table id="tblOtrasInstituciones" class="ui-widget ui-widget-content">
                                <thead>
                                    <tr class="ui-widget-header ">
                                        <th class="columInstitucion">Institución</th>
                                        <th class="columBotones"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <button id="btnNuevaInstitucion">Agregar</button>
                        </div>

                        <button id="btnSgteInstituciones">Siguiente</button>

                    </div>  
                    <div id="tabs-abonos">
                        <p>Ingrese los abonos de tiempo correspondientes.</p>
                        <div class="contenedor-tabla-tiempos ui-widget">
                            <table id="tblAbonos" class="ui-widget ui-widget-content">
                                <thead>
                                    <tr class="ui-widget-header ">
                                        <th class="columDescripcionTiempo">Tipo</th>
                                        <th class="columNumericaTiempo">Años</th>
                                        <th class="columNumericaTiempo">Meses</th>
                                        <th class="columNumericaTiempo">Días</th>
                                        <th class="columBotones"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <button id="btnNuevoAbono">Agregar</button>
                        </div>

                        <button id="btnSgteAbonos">Siguiente</button>
                    </div>  
                    <div id="tabs-concurrencias">
                        <p>Ingrese las concurrencias correspondientes.</p>
                        <div class="contenedor-tabla-tiempos ui-widget">
                            <table id="tblConcurrencias" class="ui-widget ui-widget-content">
                                <thead>
                                    <tr class="ui-widget-header ">
                                        <th class="columDescripcionTiempo">Tipo</th>
                                        <th class="columNumericaTiempo">Años</th>
                                        <th class="columNumericaTiempo">Meses</th>
                                        <th class="columNumericaTiempo">Días</th>
                                        <th class="columBotones"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <button id="btnNuevaConcurrencia">Agregar</button>
                        </div>

                        <button id="btnSgteConcurrencias">Siguiente</button>

                    </div> 
                    <div id="tabs-resultados">
                        <p>Los resultados son los siguientes.</p>

                        <div class="contenedor-tabla">
                            <div class="fila">
                                <div class="contenedor-tabla-servicios ui-widget">
                                    <table id="tblDetalleServicios">
                                        <thead>
                                            <tr class="borde-solido">
                                                <th style="width:40%;">DETALLE DE SERVICIOS</th>
                                                <th style="width:10%;">AÑOS</th>
                                                <th style="width:10%;">MESES</th>
                                                <th style="width:10%;">DÍAS</th>
                                                <th style="width:15%;">EN DÍAS</th>
                                                <th style="width:15%;">PORCENTAJE</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="contenedor-tabla espacio-vertical">
                            <div class="fila">
                                <div class="contenedor-tabla-18263 ui-widget">
                                    <table id="tblLey18263">
                                        <thead class="borde-solido">
                                            <tr>
                                                <th colspan="4">Ley N° 18.263</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td style="width:27%">GRADO</td>
                                                <td style="width:19%">
                                                    <input type="text" name="grados" id="tiGrados" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td style="width:27%">
                                                    <label class="peso">$</label>
                                                    <input type="text" name="sueldo1981" id="tiSueldo1981" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td style="width:27%"></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <input type="text" name="trienios" id="tiTrienios" value="" class="numericoCorto ui-widget-content ui-corner-all"/>
                                                    TRIENIOS
                                                </td>
                                                <td>
                                                    <input type="text" name="porcTrienios" id="tiPorcTrienios" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="trienios18263" id="tiTrienios18263" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>SOBRESUELDO</td>
                                                <td>
                                                    <input type="text" name="porcSobresueldo" id="tiPorcSobresueldo" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="sobresueldo18263" id="tiSobresueldo18263" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>MDO. Y ADM.</td>
                                                <td>
                                                    <input type="text" name="porcMandoAdm" id="tiPorcMandoAdm" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="mandoAdm18263" id="tiMandoAdm18263" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>ALTO MDO.</td>
                                                <td>
                                                    <input type="text" name="porcAltoMando" id="tiPorcAltoMando" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="altoMando18263" id="tiAltoMando18263" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>LEY 19.699</td>
                                                 <td>
                                                    <input type="text" name="aplicaPlaSup19699" id="tiAplicaPlaSup19699" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="plaSup18263" id="tiPlaSup18263" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>ASIG.SOM</td>
                                                <td>
                                                    <input type="text" name="porcAsigSom" id="tiPorcAsigSom" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="asigSom18263" id="tiAsigSom18263" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>M. DE CORTE</td>
                                                <td>
                                                    <input type="text" name="porcMinCorte" id="tiPorcMinCorte" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="minCorte18263" id="tiMinCorte18263" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>AEGE</td>
                                                <td>
                                                    <input type="text" name="tituloProf" id="tiTituloProf" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="aege18263" id="tiAege18263" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td><b>TOTAL</b></td>
                                                <td></td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="total18263" id="tiTotal18263" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td><b>TOTAL IMPONIBLE</b></td>
                                                <td></td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="totalImponible18263" id="tiTotalImponible18263" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>AVOS</td>
                                                <td>
                                                    <input type="text" name="cantidadAvos" id="tiCantidadAvos" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="montoAvos18263" id="tiMontoAvos18263" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td>
                                                    <input type="text" name="porcAvos" id="tiPorcAvos" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>HASTA</td>
                                                <td>8,80%</td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="montoHasta88" id="tiMontoHasta88" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>D.S.(H) 376/987</td>
                                                <td>
                                                    <input type="text" name="porcReajDS376" id="tiPorcReajDS376" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="montoReajDS376" id="tiMontoReajDS376" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>D.S.(H) 321/988</td>
                                                <td>
                                                    <input type="text" name="porcReajDS321" id="tiPorcReajDS321" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="montoReajDS321" id="tiMontoReajDS321" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <input type="text" name="documentoUltimoReaj" id="tiDocumentoUltimoReaj" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <input type="text" name="porcUltimoReaj" id="tiPorcUltimoReaj" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="montoUltimoReaj" id="tiMontoUltimoReaj" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>                            
                                </div>
                                
                                <div class="contenedor-tabla-18694 ui-widget">
                                    <table id="tblLey18694">
                                        <thead>
                                            <tr class="borde-solido">
                                                <th colspan="3">Ley N° 18.694</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td style="width:38%">
                                                    <label class="peso">$</label>
                                                    <input type="text" name="sueldoActividad" id="tiSueldoActividad" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td style="width:24%"></td>
                                                <td style="width:38%"></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="trienios18694" id="tiTrienios18694" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="sobresueldo18694" id="tiSSobresueldo18694" value="" class="numerico ui-widget-content ui-corner-all"/> 
                                                </td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="mandoAdm18694" id="tiMandoAdm18694" value="" class="numerico ui-widget-content ui-corner-all"/> 
                                                </td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="altoMando18694" id="tiAltoMando18694" value="" class="numerico ui-widget-content ui-corner-all"/>  
                                                </td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="plaSup18694" id="tiPlaSup18694" value="" class="numerico ui-widget-content ui-corner-all"/> 
                                                </td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="asigSom18694" id="tiAsigSom18694" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="minCorte18694" id="tiMinCorte18694" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="aege18694" id="tiAege18694" value="" class="numerico ui-widget-content ui-corner-all"/> 
                                                </td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="total18694" id="tiTotal18694" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td colspan="2"><b>TOTAL PARA DESAHUCIO</b></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="totalImponibleParcial18694" id="tiTotalImponibleParcial18694" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td colspan="2"><b>TOTAL IMPONIBLE</b></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="totalDesahucioAvos18694" id="tiTotalDesahucioAvos" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td>
                                                    <input type="text" name="porcAvos1" id="tiPorcAvos1" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>AVOS</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="totalImponible18694" id="tiTotalImponible18694" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td colspan="2"><b>TOTAL IMPONIBLE</b></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="aegeNoImponible" id="tiAegeNoImponible" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td colspan="2">No AEGE - 20 años</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="plaSupDfl1" id="tiPlaSupDfl1" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td>
                                                    <input type="text" name="aplicaPlaSupDfl1" id="tiAplicaPlaSupDfl1" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>P.S. DFL G/68</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="bonifCompensatoria" id="tiBonifCompensatoria" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td></td>
                                                <td>BONIF. COMP.</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="bonifRiesgoEsp" id="tiBonifRiesgoEsp" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td>
                                                    <input type="text" name="porcBonifRiesgoEsp" id="tiPorcBonifRiesgoEsp" value="" class="text ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td>
                                                    <input type="text" name="tipoBonifRiesgoEsp" id="tiTipoBonifRiesgoEsp" value="" class="text ui-widget-content ui-corner-all"/>    
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="minCorteNoImp" id="tiMinCorteNoImp" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td>
                                                    <input type="text" name="porcMinCorteNoImp" id="tiPorcMinCorteNoImp" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>M. DE CORTE</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="asigSomNoImp" id="tiAsigSomNoImp" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td>
                                                    <input type="text" name="porcAsigSomNoImp" id="tiPorcAsigSomNoImp" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>ASIG. DE SUB.</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="segundoSobresueldo" id="tiSegundoSobresueldo" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td>
                                                    <input type="text" name="porcSegundoSobresueldo" id="tiPorcSegundoSobresueldo" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>2° SOBRES.</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="totalRemuneracion" id="tiTotalRemuneracion" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td colspan="2">TOTAL REMUNERACIÓN 100%</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="totalRemuneracionAvos" id="tiTotalRemuneracionAvos" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td>
                                                    <input type="text" name="porcAvos2" id="tiPorcAvos2" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>AVOS</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="pensioAotorgar" id="tiPensioAotorgar" value="" class="numerico ui-widget-content ui-corner-all"/>    
                                                </td>
                                                <td colspan="2"><b>PENSIÓN A OTORGAR</b></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td colspan="2">
                                                    <input type="text" name="tope" id="tiTope" value="" class="text ui-widget-content ui-corner-all"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div class="contenedor-tabla espacio-vertical">
                            <div class="fila">
                                <div class="contenedor-tabla-distribucion">
                                    <table id="tblDistribucion">
                                        <thead class="borde-solido">
                                            <tr>
                                                <th colspan="2">DISTRIBUCIÓN</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td style="width:50%;">CAPREDENA</td>
                                                <td style="width:50%;">
                                                    <label class="peso">$</label>
                                                    <input type="text" name="distribucionCapredena" id="tiDistribucionCapredena" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>FISCO</td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="distribucionFisco" id="tiDistribucionFisco" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                            </tr>
                                            <tr class="borde-solido">
                                                <td>TOTAL</td>
                                                <td>
                                                    <label class="peso">$</label>
                                                    <input type="text" name="distribucionTotal" id="tiDistribucionTotal" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                
                                <div class="contenedor-tabla-concurrencias">
                                    <table id="tblConcurrenciasSalida">
                                        <thead class="borde-solido">
                                            <tr>
                                                <th colspan="2">CONCURRENCIAS</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        


                        <div class="contenedor-tabla-desahucio espacio-vertical">
                            <div class="fila">
                                <div class="contenedor-tabla-desahucio">
                                    <table id="tblDesahucio">
                                        <thead>
                                            <tr>
                                                <th colspan="6">DESAHUCIO</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>IMPONIBLE</td>
                                                <td>
                                                    <input type="text" name="mensualidadDesahucio" id="tiMensualidadDesahucio" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>MESES</td>
                                                <td>
                                                    <input type="text" name="mensualidadesDesahucio" id="tiMensualidadesDesahucio" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>PAGO</td>
                                                <td>
                                                    <input type="text" name="subTotalDesahucio" id="tiSubTotalDesahucio" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                           </div>
                        </div>
                        
                        
                        <div class="contenedor-tabla-acciones espacio-vertical">
                            <div class="fila">
                                <div class="contenedor-tabla-acciones">
                                    <table id="tblAcciones">
                                        <thead>
                                            <tr>
                                                <th colspan="6">DESAHUCIO</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Con/Sin AEGE</td>
                                                <td>
                                                    <input type="text" name="mensualidadAcciones" id="tiMensualidadAcciones" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>MESES</td>
                                                <td>
                                                    <input type="text" name="mensualidadesAcciones" id="tiMensualidadesAcciones" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>PAGO</td>
                                                <td>
                                                    <input type="text" name="subTotalAcciones" id="tiSubTotalAcciones" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                           </div>
                        </div>

                        <div class="contenedor-tabla-acciones espacio-vertical">
                            <div class="fila">
                                <div class="contenedor-tabla-acciones">
                                    <table id="Table1">
                                        <thead>
                                            <tr>
                                                <th>DESAHUCIO A PAGAR</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <input type="text" name="desahucioApagar" id="tiDesahucioApagar" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                           </div>
                        </div>


                        <div class="contenedor-tabla-acciones espacio-vertical">
                            <div class="fila">
                                <div class="contenedor-tabla-acciones">
                                    <table id="Table2">
                                        <tbody>
                                            <tr>
                                                <td>ART.210 LE FALTAN</td>
                                                <td>
                                                    <input type="text" name="meseseSigteTrienio" id="tiMeseseSigteTrienio" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>MESES</td>
                                                <td>
                                                    <input type="text" name="diasSigteTrienio" id="tiDiasSigteTrienio" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>DÍAS PARA DISFRUTAR DEL </td>
                                                <td>
                                                    <input type="text" name="sigteTrienio" id="tiSigteTrienio" value="" class="numerico ui-widget-content ui-corner-all"/>
                                                </td>
                                                <td>TRIENIO</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                           </div>
                        </div>

                        <br />
                        <button id="btnCalcularPension">Calcular</button>   
                    </div>  
                     
                </div>
                
            </div>


            <div id='footer'>
                <img src="img/barra_logo.PNG" alt="" style="width: 120px;" />
                <br />
                <a rel="&copy; 2015 - Desarrollado por el Dpto. de Tecnolog&iacute;as de la Informaci&oacute;n y Comunicaciones - Secci&oacute;n Desarrollo y Mantenci&oacute;n de Sistemas"
                    href="#">&copy; 2015 - Desarrollado por el Dpto. de Tecnolog&iacute;as de la Informaci&oacute;n
                    y Comunicaciones - Secci&oacute;n Desarrollo y Mantenci&oacute;n de Sistemas</a>
            </div>

             <div id="about">
                <iframe id="frameAbout" src="http://172.20.4.7/about/about.aspx"></iframe>
                <button id="btt_Cerrar_about">
                    Salir</button>
            </div>


            <div id="dialog-message" title="uuppps Problemas">
                <p>
                    <span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;">
                    </span>Estimado usuario: .
                </p>
                <p>
                    No se pudo obtener los datos solicitados. Comuniquese con el <b>Area de Mantenci&oacute;n
                        y Desarrollo de Sistemas</b>.
                </p>
            </div>

            <div id="dialog-otra-inst" title="Agregar nueva institución" class="ui-dialog-content ui-widget-content">
                <p class="validateTips">Ingrese los datos solicitados.</p>
                <form>
                    <fieldset>
                            <label for="name" class="etiqueta">Institución</label>
                            <select name="institucion" id="sltOtraInstitucion"  class="combobox ui-widget-content ui-corner-all">
                                <option value="-1" selected="selected">[SELECCIONE]</option>
                                <script type="text/javascript">
                                    cargarListaValorCorrelativo("Instituciones");
                                </script>
                            </select>
                        <!-- Allow form submission with keyboard without duplicating the dialog button -->
                       <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
                </fieldset>
              </form>
            </div>


            <div id="dialog-abono" title="Agregar nuevo abono" class="ui-dialog-content ui-widget-content">
                <p class="validateTips">Ingrese los datos solicitados.</p>
                <form>
                    <fieldset>
                            <label for="name" class="etiqueta">Tipo de abono</label>
                            <select name="tipoAbono" id="sltTipoAbono"  class="combobox ui-widget-content ui-corner-all">
                                <option value="-1" selected="selected">[SELECCIONE]</option>
                                <script type="text/javascript">
                                    cargarListaValorCorrelativo("Abonos");
                                </script>
                            </select>

                            <label for="aniosAbono" class="etiqueta">Años</label>
                            <input type="text" name="aniosAbono" id="tiAniosAbono" value="" class="numerico ui-widget-content ui-corner-all"/>
                        
                            <label for="mesesAbono" class="etiqueta">Meses</label>
                            <input type="text" name="mesesAbono" id="tiMesesAbono" value="" class="numerico ui-widget-content ui-corner-all"/>
                        
                            <label for="diasAbono" class="etiqueta">Días</label>
                            <input type="text" name="diasAbono" id="tiDiasAbono" value="" class="numerico ui-widget-content ui-corner-all"/>
                     
                        <!-- Allow form submission with keyboard without duplicating the dialog button -->
                       <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
                </fieldset>
              </form>
            </div>

            <div id="dialog-concurrencia" title="Agregar nueva concurrencia" class="ui-dialog-content ui-widget-content">
                <p class="validateTips">Ingrese los datos solicitados.</p>
                <form>
                    <fieldset>
                            <label for="name" class="etiqueta">Concurrencia</label>
                            <select name="tipoAbono" id="sltTipoConcurrencia"  class="combobox ui-widget-content ui-corner-all">
                                <option value="-1" selected="selected">[SELECCIONE]</option>
                                <script type="text/javascript">
                                    cargarListaValorCorrelativo("Concurrencias");
                                </script>
                            </select>

                            <label for="aniosConcurrencia" class="etiqueta">Años</label>
                            <input type="text" name="aniosConcurrencia" id="tiAniosConcurrencia" value="" class="numerico ui-widget-content ui-corner-all"/>
                        
                            <label for="mesesConcurrencia" class="etiqueta">Meses</label>
                            <input type="text" name="mesesConcurrencia" id="tiMesesConcurrencia" value="" class="numerico ui-widget-content ui-corner-all"/>
                        
                            <label for="diasConcurrencia" class="etiqueta">Días</label>
                            <input type="text" name="diasConcurrencia" id="tiDiasConcurrencia" value="" class="numerico ui-widget-content ui-corner-all"/>
                     
                        <!-- Allow form submission with keyboard without duplicating the dialog button -->
                       <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
                </fieldset>
              </form>
            </div>
        </div>

</body>
</html>
