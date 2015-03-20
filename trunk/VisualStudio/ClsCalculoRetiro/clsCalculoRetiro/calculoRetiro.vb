Public Class calculoRetiro
    Dim ws As New WsCalculoRetiro.CalculoRetiroWSClient

    Public Function calcular(ByVal xml As String) As String
        Try
            Return ws.calcularPorXml(xml)
        Catch ex As Exception
            Return Nothing
        End Try
    End Function


End Class
