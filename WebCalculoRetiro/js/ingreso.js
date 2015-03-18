// Archivo JScript

$(document).ready(function () {
    $("label").inFieldLabels();

    // evento click del boton 
    $('#bttLogin').on("click", function (evento) {
        evento.preventDefault();

        var mtxtUsuario = $('#txtRut').val();
        var mtxtPassword = $('#txtPass').val();

        //busca los datos
        var param = { Nombre: mtxtUsuario, Password: mtxtPassword };
        $.ajax({
            type: "POST",
            url: "ingreso.aspx/BuscaLogin",
            data: JSON.stringify(param),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) {
                var datos = response.d;

                var largo = datos[0];
                if (largo == 0) {
                    $('#form_login').attr('action',"panel.aspx");
                    $('#form_login').submit();
                } else {
                    $("#dialog:ui-dialog").dialog("destroy");

                    $("#dialog-accesoLogin").dialog({
                        height: 240,
                        width: 550,
                        modal: true,
                        buttons: {
                            "Aceptar": function () {
                                $(this).dialog("close");
                            }
                        }
                    });
                    $('#txtRut').focus();
                    return;
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


    }); // fin evento click         
});      // document.ready
