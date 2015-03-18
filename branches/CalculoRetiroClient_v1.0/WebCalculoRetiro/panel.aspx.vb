Imports System
Imports System.IO
Imports System.Text
Imports System.Net
Imports System.Data
Imports System.Web.SessionState
Imports System.Web.Services
Imports System.Collections.Generic
Imports System.Web.UI




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
    Public Shared Function calcular( _
        ByVal run As String, _
        ByVal institucion As String, _
        ByVal subInstitucion As String, _
        ByVal categoria As String, _
        ByVal escalafonCivil As String, _
        ByVal grado As String, _
        ByVal gradoJerarquico As Integer, _
        ByVal gradoEconomico As Integer, _
        ByVal esDeLinea As String, _
        ByVal fechaDeBaja As String, _
        ByVal cantidadDeAcciones As Integer, _
        ByVal tipoDeAcciones As String, _
        ByVal porcentajeDeSobresueldo As String, _
        ByVal porcentajeDeSegundoSobresueldo As String, _
        ByVal porcentajeDeAsignacionSOFSOM As String, _
        ByVal poseeAsigMinistroDeCorte As String, _
        ByVal sueldoIntegroMinistroDeCorte As Integer, _
        ByVal planillaSuplementariaLey19699 As String, _
        ByVal planillaSuplementariaDFL1_68 As String, _
        ByVal aniosCPDNyConsc As Integer, _
        ByVal mesesCPDNyConsc As Integer, _
        ByVal diasCPDNyConsc As Integer, _
        ByVal aniosDesahucio As Integer, _
        ByVal mesesDesahucio As Integer, _
        ByVal diasDesahucio As Integer, _
        ByVal otrasInstituciones As String, _
        ByVal abonos As String, _
        ByVal concurrencias As String) As List(Of String)

        Dim mDatos As New List(Of String)

        Dim str As String
        Dim clsCalculo As New clsCalculoRetiro.calculoRetiro()


        Try
            str = clsCalculo.calcular(run, institucion, subInstitucion, categoria, escalafonCivil, grado, gradoJerarquico, gradoEconomico, esDeLinea, fechaDeBaja, cantidadDeAcciones, tipoDeAcciones, porcentajeDeSobresueldo, porcentajeDeSegundoSobresueldo, porcentajeDeAsignacionSOFSOM, poseeAsigMinistroDeCorte, sueldoIntegroMinistroDeCorte, planillaSuplementariaLey19699, planillaSuplementariaDFL1_68, aniosCPDNyConsc, mesesCPDNyConsc, diasCPDNyConsc, aniosDesahucio, mesesDesahucio, diasDesahucio, otrasInstituciones, abonos, concurrencias)
            mDatos.Add(0)
            mDatos.Add(str)

        Catch ex As Exception
            mDatos.Add(-1)
            mDatos.Add("Code Error: " & ex.Message)

        End Try
        Return mDatos
    End Function

End Class
