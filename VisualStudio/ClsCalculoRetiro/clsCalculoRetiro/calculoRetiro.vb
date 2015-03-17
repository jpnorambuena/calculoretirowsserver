Public Class calculoRetiro
    Dim ws As New WsCalculoRetiro.CalculoRetiroWSClient

    Public Function calcular(ByVal run As String,
                                ByVal institucion As String,
                                ByVal subInstitucion As String,
                                ByVal categoria As String,
                                ByVal escalafonCivil As String,
                                ByVal grado As String,
                                ByVal gradoJerarquico As Integer,
                                ByVal gradoEconomico As Integer,
                                ByVal esDeLinea As String,
                                ByVal fechaDeBaja As String,
                                ByVal cantidadDeAcciones As Integer,
                                ByVal tipoDeAcciones As String,
                                ByVal porcentajeDeSobresueldo As String,
                                ByVal porcentajeDeSegundoSobresueldo As String,
                                ByVal porcentajeDeAsignacionSOFSOM As String,
                                ByVal poseeAsigMinistroDeCorte As String,
                                ByVal sueldoIntegroMinistroDeCorte As Integer,
                                ByVal planillaSuplementariaLey19699 As String,
                                ByVal planillaSuplementariaDFL1_68 As String,
                                ByVal aniosCPDNyConsc As Integer,
                                ByVal mesesCPDNyConsc As Integer,
                                ByVal diasCPDNyConsc As Integer,
                                ByVal aniosDesahucio As Integer,
                                ByVal mesesDesahucio As Integer,
                                ByVal diasDesahucio As Integer,
                                ByVal otrasInstituciones As String,
                                ByVal abonos As String,
                                ByVal concurrencias As String) As String
        Try
            Return ws.calcular(run, institucion, subInstitucion, categoria, escalafonCivil, grado, gradoJerarquico, gradoEconomico, esDeLinea, fechaDeBaja, cantidadDeAcciones,
                        tipoDeAcciones, porcentajeDeSobresueldo, porcentajeDeSegundoSobresueldo, porcentajeDeAsignacionSOFSOM, poseeAsigMinistroDeCorte, sueldoIntegroMinistroDeCorte,
                        planillaSuplementariaLey19699, planillaSuplementariaDFL1_68, aniosCPDNyConsc, mesesCPDNyConsc, diasCPDNyConsc, aniosDesahucio, mesesDesahucio, diasDesahucio,
                        otrasInstituciones, abonos, concurrencias,
                        0, 0, 0, "", 0, 0, "", 0, 0, "", 0, 0, "", 0, 0, "", 0, 0, "", 0, 0, "", 0, 0, "", 0, 0, 0, 0, "", 0, "", 0, "", 0, "", 0, "", "", "", 0, 0, 0, 0, 0, "", 0,
                        0, "", "", 0, "", 0, "", 0, "", 0, 0, 0, "", 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0.0, "", 0)
        Catch ex As Exception
            Return Nothing
        End Try
    End Function


End Class
