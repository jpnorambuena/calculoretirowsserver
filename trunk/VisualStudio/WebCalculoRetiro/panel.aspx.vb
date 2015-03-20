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
    Public Shared Function calcular(ByVal xml As String) As List(Of String)

        Dim mDatos As New List(Of String)

        Dim xmlResultados As String
        Dim clsCalculo As New clsCalculoRetiro.calculoRetiro()


        Try
            xmlResultados = clsCalculo.calcular(xml)
            mDatos.Add(0)
            mDatos.Add(xmlResultados)

        Catch ex As Exception
            mDatos.Add(-1)
            mDatos.Add("Code Error: " & ex.Message)

        End Try
        Return mDatos
    End Function

    Class func
        Public nombresStr As String
        Public apellidosStr As String
        Public gradoStr As String
        Public emailStr As String
        Public unidadStr As String
        Public subunidadStr As String
        Public direccionStr As String
        Public pisoStr As String
    End Class
