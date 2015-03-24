Imports System
Imports System.IO
Imports System.Text
Imports System.Net
Imports System.Data
Imports System.Web.SessionState
Imports System.Web.Services
Imports System.Collections.Generic
Imports System.Web.UI
Imports System.Xml




Partial Class panel
    Inherits System.Web.UI.Page
    Public sesion As String = String.Empty



    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Response.Cache.SetExpires(DateTime.UtcNow.AddMinutes(-1))
        Response.Cache.SetCacheability(HttpCacheability.NoCache)
        Response.Cache.SetNoStore()
        Response.AddHeader("Refresh", Convert.ToString(Session.Timeout * 60) + 5)


        If Not IsPostBack Then
            If Session("usuario") Is Nothing Then
                Response.Redirect("ingreso.aspx")
            Else
                Me.txtUserName.Text = "Usuario: " & Session("usuario")
            End If
        Else
            Me.txtUserName.Text = "Usuario: " & Session("usuario")
        End If
    End Sub
    <WebMethod(EnableSession:=True)> _
    Public Shared Function LogOut() As Boolean
        Dim flag As Boolean
        flag = False
        'Acceso a la Clave para Log de sistemas
        Dim classSistemas As New clsSistemas.clsSistemas
        Dim context As HttpContext = HttpContext.Current
        classSistemas.Context = context

        Try

            If HttpContext.Current.Session("usuario") Is Nothing Then
                HttpContext.Current.Response.Redirect("ingreso.aspx")
            Else
                HttpContext.Current.Session.Abandon()
            End If
            flag = True

            classSistemas.Sistemas_InsertLog(7, "Logout correcto")

        Catch ex As Exception


            flag = False
            classSistemas.Sistemas_InsertLog(7, "Logout incorrecto")
        End Try

        Return flag
    End Function

    Public Sub CerrarSesion()
        Session("usuario") = Nothing

    End Sub

    Private Shared Function EnableSession() As Boolean
        Throw New NotImplementedException
    End Function


    <WebMethod(EnableSession:=True)> _
    Private Shared Function Crea_DataLogXML(ByVal IdAccion As Integer, ByVal Descripcion As String) As String
        'Envia datos al Log de Sistemas
        Dim classSistemas As New clsSistemas.clsSistemas

        Dim context As HttpContext = HttpContext.Current
        classSistemas.Context = context
        Return classSistemas.CreaXml(IdAccion, Descripcion)

    End Function


    <WebMethod(EnableSession:=True)> _
    Public Shared Function calcular(ByVal xml As String) As List(Of String)

        Dim mDatos As New List(Of String)
        Dim xmlResultados As String
        Dim clsCalculo As New clsCalculoRetiro.calculoRetiro()
        Dim jsonResultados As String

        Dim sb As New StringBuilder()
        Dim xmlDoc As XmlDocument
        Dim xmlNode As XmlNode
        Dim xmlNodeList As XmlNodeList

        jsonResultados = ""
        Try
            xmlResultados = clsCalculo.calcular(xml)

            If xmlResultados IsNot Nothing Then
                xmlDoc = New XmlDocument()
                xmlDoc.LoadXml(xmlResultados)


                sb.Append("{""grados"":""" & xmlDoc.SelectSingleNode("/resultados/grados").InnerText & """,")
                sb.Append("""sueldo1981"":""" & xmlDoc.SelectSingleNode("/resultados/sueldo1981").InnerText & """,")
                sb.Append("""sueldoEnActividad"":""" & xmlDoc.SelectSingleNode("/resultados/sueldoEnActividad").InnerText & """,")
                sb.Append("""cantidadTrienios"":""" & xmlDoc.SelectSingleNode("/resultados/cantidadTrienios").InnerText & """,")
                sb.Append("""porcentajeTrienios"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeTrienios").InnerText & """,")
                sb.Append("""asignacionTrieniosLey18263"":""" & xmlDoc.SelectSingleNode("/resultados/asignacionTrieniosLey18263").InnerText & """,")
                sb.Append("""asignacionTrieniosLey18694"":""" & xmlDoc.SelectSingleNode("/resultados/asignacionTrieniosLey18694").InnerText & """,")
                sb.Append("""porcentajeSobresueldo"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeSobresueldo").InnerText & """,")
                sb.Append("""sobresueldoLey18263"":""" & xmlDoc.SelectSingleNode("/resultados/sobresueldoLey18263").InnerText & """,")
                sb.Append("""sobresueldoLey18694"":""" & xmlDoc.SelectSingleNode("/resultados/sobresueldoLey18694").InnerText & """,")
                sb.Append("""porcentajeBonifMandoAdministracion"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeBonifMandoAdministracion").InnerText & """,")
                sb.Append("""bonifMandoAdministracionLey18263"":""" & xmlDoc.SelectSingleNode("/resultados/bonifMandoAdministracionLey18263").InnerText & """,")
                sb.Append("""bonifMandoAdministracionLey18694"":""" & xmlDoc.SelectSingleNode("/resultados/bonifMandoAdministracionLey18694").InnerText & """,")
                sb.Append("""porcentajeBonifAltoMando"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeBonifAltoMando").InnerText & """,")
                sb.Append("""bonifAltoMandoLey18263"":""" & xmlDoc.SelectSingleNode("/resultados/bonifAltoMandoLey18263").InnerText & """,")
                sb.Append("""bonifAltoMandoLey18694"":""" & xmlDoc.SelectSingleNode("/resultados/bonifAltoMandoLey18694").InnerText & """,")
                sb.Append("""aplicaPlanillaSuplementaria"":""" & xmlDoc.SelectSingleNode("/resultados/aplicaPlanillaSuplementaria").InnerText & """,")
                sb.Append("""planillaSuplementariaLey19699Actual"":""" & xmlDoc.SelectSingleNode("/resultados/planillaSuplementariaLey19699Actual").InnerText & """,")
                sb.Append("""planillaSuplementariaLey19699anio1981"":""" & xmlDoc.SelectSingleNode("/resultados/planillaSuplementariaLey19699anio1981").InnerText & """,")
                sb.Append("""porcentajeAsignacionSOM"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeAsignacionSOM").InnerText & """,")
                sb.Append("""asignacionSOMLey18263"":""" & xmlDoc.SelectSingleNode("/resultados/asignacionSOMLey18263").InnerText & """,")
                sb.Append("""asignacionSOMLey18694"":""" & xmlDoc.SelectSingleNode("/resultados/asignacionSOMLey18694").InnerText & """,")
                sb.Append("""porcentajeAsigMinistroDeCorte"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeAsigMinistroDeCorte").InnerText & """,")
                sb.Append("""asigMinistroDeCorteLey18263"":""" & xmlDoc.SelectSingleNode("/resultados/asigMinistroDeCorteLey18263").InnerText & """,")
                sb.Append("""asigMinistroDeCorteLey18694"":""" & xmlDoc.SelectSingleNode("/resultados/asigMinistroDeCorteLey18694").InnerText & """,")
                sb.Append("""poseeTituloProf"":""" & xmlDoc.SelectSingleNode("/resultados/poseeTituloProf").InnerText & """,")
                sb.Append("""aegeLey18263"":""" & xmlDoc.SelectSingleNode("/resultados/aegeLey18263").InnerText & """,")
                sb.Append("""aegeLey18694"":""" & xmlDoc.SelectSingleNode("/resultados/aegeLey18694").InnerText & """,")
                sb.Append("""totalLey18263"":""" & xmlDoc.SelectSingleNode("/resultados/totalLey18263").InnerText & """,")
                sb.Append("""totalParaDesahucio"":""" & xmlDoc.SelectSingleNode("/resultados/totalParaDesahucio").InnerText & """,")
                sb.Append("""cantidadAVOS"":""" & xmlDoc.SelectSingleNode("/resultados/cantidadAVOS").InnerText & """,")
                sb.Append("""montoAVOS"":""" & xmlDoc.SelectSingleNode("/resultados/montoAVOS").InnerText & """,")
                sb.Append("""porcentajeAVOS"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeAVOS").InnerText & """,")
                sb.Append("""reajusteHasta8_8"":""" & xmlDoc.SelectSingleNode("/resultados/reajusteHasta8_8").InnerText & """,")
                sb.Append("""porcentajeReajusteDS376_1987"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeReajusteDS376_1987").InnerText & """,")
                sb.Append("""montoReajusteDS376_1987"":""" & xmlDoc.SelectSingleNode("/resultados/montoReajusteDS376_1987").InnerText & """,")
                sb.Append("""porcentajeReajusteDS321_1988"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeReajusteDS321_1988").InnerText & """,")
                sb.Append("""montoReajusteDS321_1988"":""" & xmlDoc.SelectSingleNode("/resultados/montoReajusteDS321_1988").InnerText & """,")
                sb.Append("""totalImponibleParcial"":""" & xmlDoc.SelectSingleNode("/resultados/totalImponibleParcial").InnerText & """,")
                sb.Append("""totalDesahucioSegunA"":""" & xmlDoc.SelectSingleNode("/resultados/totalDesahucioSegunAvos").InnerText & """,")
                sb.Append("""totalImponible"":""" & xmlDoc.SelectSingleNode("/resultados/totalImponible").InnerText & """,")
                sb.Append("""aegeNoImponible"":""" & xmlDoc.SelectSingleNode("/resultados/aegeNoImponible").InnerText & """,")
                sb.Append("""recibePlanillaSuplementariaDfl_1_68"":""" & xmlDoc.SelectSingleNode("/resultados/recibePlanillaSuplementariaDfl_1_68").InnerText & """,")
                sb.Append("""planillaSuplementariaDfl_1_68"":""" & xmlDoc.SelectSingleNode("/resultados/planillaSuplementariaDfl_1_68").InnerText & """,")
                sb.Append("""bonificacionCompensatoria"":""" & xmlDoc.SelectSingleNode("/resultados/bonificacionCompensatoria").InnerText & """,")
                sb.Append("""tipoDeBonifRiesgoEspecial"":""" & xmlDoc.SelectSingleNode("/resultados/tipoDeBonifRiesgoEspecial").InnerText & """,")
                sb.Append("""porcentajeBonifRiesgoEspecial"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeBonifRiesgoEspecial").InnerText & """,")
                sb.Append("""bonifRiesgoEspecial"":""" & xmlDoc.SelectSingleNode("/resultados/bonifRiesgoEspecial").InnerText & """,")
                sb.Append("""porcentajeAsigMinDeCorteNoImp"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeAsigMinDeCorteNoImp").InnerText & """,")
                sb.Append("""asigMinistroDeCorteNoImp"":""" & xmlDoc.SelectSingleNode("/resultados/asigMinistroDeCorteNoImp").InnerText & """,")
                sb.Append("""asignacionSOMnoImp"":""" & xmlDoc.SelectSingleNode("/resultados/asignacionSOMnoImp").InnerText & """,")
                sb.Append("""porcentajeAsigSOMnoImp"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeAsigSOMnoImp").InnerText & """,")
                sb.Append("""porcentajeSegundoSobresueldo"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeSegundoSobresueldo").InnerText & """,")
                sb.Append("""segundoSobresueldo"":""" & xmlDoc.SelectSingleNode("/resultados/segundoSobresueldo").InnerText & """,")
                sb.Append("""totalRemuneracion"":""" & xmlDoc.SelectSingleNode("/resultados/totalRemuneracion").InnerText & """,")
                sb.Append("""totalRemuneracionSegunAVOS"":""" & xmlDoc.SelectSingleNode("/resultados/totalRemuneracionSegunAVOS").InnerText & """,")
                sb.Append("""tipoDocUltimoReajuste"":""" & xmlDoc.SelectSingleNode("/resultados/tipoDocUltimoReajuste").InnerText & """,")
                sb.Append("""numeroDocUltimoReajuste"":""" & xmlDoc.SelectSingleNode("/resultados/numeroDocUltimoReajuste").InnerText & """,")
                sb.Append("""porcentajeUltimoReajuste"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeUltimoReajuste").InnerText & """,")
                sb.Append("""montoUltimoReajuste"":""" & xmlDoc.SelectSingleNode("/resultados/montoUltimoReajuste").InnerText & """,")
                sb.Append("""pensionAotorgar"":""" & xmlDoc.SelectSingleNode("/resultados/pensionAotorgar").InnerText & """,")
                sb.Append("""porcentajeAVOS2"":""" & xmlDoc.SelectSingleNode("/resultados/porcentajeAVOS2").InnerText & """,")
                sb.Append("""conTopeSinTope"":""" & xmlDoc.SelectSingleNode("/resultados/conTopeSinTope").InnerText & """,")
                sb.Append("""distribucionCapredena"":""" & xmlDoc.SelectSingleNode("/resultados/distribucionCapredena").InnerText & """,")
                sb.Append("""distribucionFisco"":""" & xmlDoc.SelectSingleNode("/resultados/distribucionFisco").InnerText & """,")
                sb.Append("""distribucionTotal"":""" & xmlDoc.SelectSingleNode("/resultados/distribucionTotal").InnerText & """,")
                sb.Append("""mensualidadesDesahucio"":""" & xmlDoc.SelectSingleNode("/resultados/mensualidadesDesahucio").InnerText & """,")
                sb.Append("""montoMensualidadDesahucio"":""" & xmlDoc.SelectSingleNode("/resultados/montoMensualidadDesahucio").InnerText & """,")
                sb.Append("""subtotalDesahucio"":""" & xmlDoc.SelectSingleNode("/resultados/subtotalDesahucio").InnerText & """,")
                sb.Append("""cantidadAcciones"":""" & xmlDoc.SelectSingleNode("/resultados/cantidadAcciones").InnerText & """,")
                sb.Append("""montoUnitarioAcciones"":""" & xmlDoc.SelectSingleNode("/resultados/montoUnitarioAcciones").InnerText & """,")
                sb.Append("""subtotalAcciones"":""" & xmlDoc.SelectSingleNode("/resultados/subtotalAcciones").InnerText & """,")
                sb.Append("""desahucioApagar"":""" & xmlDoc.SelectSingleNode("/resultados/desahucioApagar").InnerText & """,")
                sb.Append("""mesesSgteTrienio"":""" & xmlDoc.SelectSingleNode("/resultados/mesesSgteTrienio").InnerText & """,")
                sb.Append("""diasSgteTrienio"":""" & xmlDoc.SelectSingleNode("/resultados/diasSgteTrienio").InnerText & """,")
                sb.Append("""siguienteTrienio"":""" & xmlDoc.SelectSingleNode("/resultados/siguienteTrienio").InnerText & """}")




                'sb.Append("""XXXXXXXXXX"":""" & xmlDoc.SelectSingleNode("/resultados/XXXXXXXXXX").InnerText & """,")
                jsonResultados = sb.ToString

            End If

            






            mDatos.Add(0)
            mDatos.Add(jsonResultados)

        Catch ex As Exception
            mDatos.Add(-1)
            mDatos.Add("Code Error: " & ex.Message)

        End Try
        Return mDatos
    End Function


End Class

