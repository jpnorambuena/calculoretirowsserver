<%@ Page Language="VB" AutoEventWireup="false" CodeFile="ingreso.aspx.vb" Inherits="ingreso" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>c&aacute;lculoRetiro - Sistema de c&aacute;lculo de pensiones de retiro del personal de las FF.AA.</title>
    <link type='text/css' href='css/ingreso.css' rel='stylesheet' media='screen' />
    <link href="ui/1.11.1/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery_1.10.2.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.11.js"></script>
    <script type="text/javascript" src="js/ingreso.js"></script>
    <script src="js/jquery.infieldlabel.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            //agrega icono al boton
            $("#bttLogin").button({
                text: true,
                icons: {
                    primary: "ui-icon-unlocked",
                    secundary: "ui-icon-triangle-1-s"
                }
            })
        });  //fin function
    </script>
</head>
<body>
    <div id="dialog-accesoLogin" title="Acceso al Sistema">
        <p>
            <span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 65px 0;"></span>
            Estimado usuario,
        </p>
        <p>
            para ingresar a c&aacute;lculoRetiro debe introducir su <b>RUT</b>  (sin puntos y guion ej. 11222333-4) y la misma <b>contraseña</b> que utiliza actualmente en el sistema DOCUMENTAL
        </p>
    </div>
    <div id='container'>
        <div id="imagen">
            <img src="img/logoSSFFAA.jpg" alt="" />
        </div>
        <div id='logo' >
            &nbsp;<h1><span><span style="color: #888">c&aacute;lculo</span>Retiro <span style="font-size: 14px;color: #888">v1.0</span></span></h1>
		        <span class='title'>C&aacute;lculo Retiro - Sistema de c&aacute;lculo de pensiones de retiro del personal de las Fuerzas Armadas</span>
        </div>
        <form id="form_login" runat="server">
        <div id='content'>
            <h3>
                Bienvenidos</h3>
            <p>
                C&aacute;lculo &nbsp;Retiro es una aplicaci&oacute;n web que te permitir&aacute; obtener de forma f&aacute;cil y amigable los c&aacute;lculos asociados 
                    a una pensi&oacute;n de retiro del personal de las Fuerzas Armadas.&nbsp;
            </p>
            <div id="marco">
                <div class="row_login">
                    <div>
                        <table width="357" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="50">
                                    Usuario:
                                </td>
                                <td width="208">
                                    <p>
                                        <label for="txtRut">
                                            &nbsp;RUT &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ejemplo. 11222333-4</label>
                                    </p>
                                    <input type="text" id="txtRut" class="text_login" name="txtRut" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Contrase&ntilde;a:
                                </td>
                                <td>
                                    <p>
                                        <label for="txtPass">
                                            &nbsp;Contrase&ntilde;a &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;</label>
                                    </p>
                                    <input type="password" id="txtPass" class="text_login" name="txtPass" />
                                </td>
                            </tr>
                        </table>
                        <br />
                        <button id="bttLogin" type="submit">
                            Ingresar</button>
                    </div>
                </div>
            </div>
        </div>
        </form>
        <div id='footer'>
            <img src="img/barra_logo.png" alt="" style="width: 163px; height: 8px;" />
            <br />
            &copy; 2015 - Desarrollado por el Dpto. de Tecnolog&iacute;as de la Informaci&oacute;n y Comunicaciones - Secci&oacute;n Desarrollo y Mantenci&oacute;n de Sistemas.
        </div>
    </div>
</body>
</html>
