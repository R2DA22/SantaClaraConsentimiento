function mostrarModalAlert(mensaje, tipoalerta) {
    settearMensajeAlert([
        {name: 'mensaje', value: mensaje},
        {name: 'tipoalerta', value: tipoalerta}
    ]);
    $('#alertModal').addClass('header-' + tipoalerta);
    PF('dlgAlertModal').show();
}


function setFoco(forma, componente) {
    var component = document.getElementById(forma + ':' + componente);
    if (component !== null) {
        component.focus();
    }
    return false;
}

function cargarIcono() {
    document.getElementById('modalAlert:lblAlert').innerHTML = document.getElementById('modalAlert:lblAlert').innerHTML + '<span><img src="../resources/imagenes/icon-help.png" style="width: 28px;"></span>';
}

function siguiente(idForm, field) { //Foco al siguiente campo activo
    var i;
    var bandera = true;
    field = idForm + ':' + field;
    var component = document.getElementById(field);
    const form = component.form;
    for (i = 0; i < form.elements.length; i++)
        if (field === form.elements[i].id)
            break;
    while (bandera) {
        i = (i + 1);
        var idElement = form.elements[i].attributes.id;

        if (form.elements[i].disabled === false && form.elements[i].readOnly !== true
                && !idElement.value.includes('slc')
                && form.elements[i].type !== 'hidden' && (form.elements[i].localName == 'input' || form.elements[i].localName == 'textarea')) {
            bandera = false;
        }
    }

    form.elements[i].focus();
    return false;
}


