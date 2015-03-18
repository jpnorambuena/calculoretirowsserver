Imports System
Imports System.IO
Imports System.Text
Imports System.Net
Imports System.Data
Imports System.Web.SessionState
Imports System.Web.Services
Imports System.Collections.Generic




Partial Class ingreso
    Inherits System.Web.UI.Page

    Private Sub Page_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'Put user code to initialize the page here
        ' Ajax.Utility.RegisterTypeForAjax(GetType(ingreso))
        Response.Cache.SetExpires(DateTime.UtcNow.AddMinutes(-1))
        Response.Cache.SetCacheability(HttpCacheability.NoCache)
        Response.Cache.SetNoStore()
        Response.AddHeader("Refresh", Convert.ToString(Session.Timeout * 60) + 5)
    End Sub


    <WebMethod()> _
    Public Shared Function BuscaLogin(ByVal Nombre As String, ByVal Password As String) As List(Of String)
        Dim ldatos As New List(Of String)
        Dim ds As New Data.DataSet
        Dim codigo As Integer = -1
        Dim aprobador As String = "no se encontro!!!!"
        Dim email As String = ""
        Dim id As Integer = -1


        Dim classSistemas As New clsSistemas.clsSistemas
        'Envia datos al Log de Sistemas
        Dim context As HttpContext = HttpContext.Current
        classSistemas.Context = context

        Dim fila As String = ""
        Dim i As Integer

        Try
            ds = classSistemas.UserLogin(Nombre.ToString.Trim, Password.ToString.Trim)

            If ds.Tables(0).Rows.Count > 0 Then
                codigo = ds.Tables(0).Rows(i)("codigo")
                aprobador = ds.Tables(0).Rows(i)("aprobador")
                email = ds.Tables(0).Rows(i)("func_email")
                id = ds.Tables(0).Rows(i)("func_id")
            End If

            ldatos.Add(codigo)
            ldatos.Add(aprobador)
            ldatos.Add(email)
            ldatos.Add(id)


        Catch ex As Exception
            ldatos.Add(-1)
            ldatos.Add(ex.Message)
        End Try





        If codigo = 0 Then
            HttpContext.Current.Session("usuario") = aprobador
            HttpContext.Current.Session("func_email") = email
            HttpContext.Current.Session("func_id") = id

            classSistemas.Sistemas_InsertLog(8, "Acceso correcto")
        Else
            classSistemas.Sistemas_InsertLog(8, "Acceso incorrecto")
        End If

        Return ldatos
    End Function




End Class
