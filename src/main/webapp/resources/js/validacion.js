const nameForm = 'frmFormulario';
const formGrupoIncorrecto = 'formulario__grupo-incorrecto';
const formGrupoCorrecto = 'formulario__grupo-correcto';
const formulario = document.getElementById(nameForm);
var inputs = document.querySelectorAll('#' + nameForm + ' .form-control');
document.addEventListener('DOMContentLoaded', () => {
    document.querySelectorAll('.form-control').forEach(node => node.addEventListener('keypress', e => {
        if (e.keyCode === 13) {
            e.preventDefault();
        }
    }));
});
var submit = false;
const expresiones = {
    nombre: /^[a-zA-ZÀ-ÿ\s]{1,150}$/, // Letras y espacios, pueden llevar acentos.
    documento: /^([A-Z]{2})?\d{6,15}([-\s]\d{1})?$/,
    digito: /^\d+$/,
    telefono: /^3([0-9]){9}$/,
    email: /^[a-z0-9!#$%&'*+\/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+\/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/,
    date: /^\d\d-\d\d-\d\d\d\d/
};
const campos = {
    "nombre-acudiente": false,
    "nombre-paciente": false,
    "nombre-profesional": false,
    "documento-acudiente": false,
    "documento-paciente": false,
    "ocupacion-paciente": false,
    "ocupacion-profesional": false,
    "eps-paciente": false,
    "sintomas-paciente": false,
    "telefono-paciente": false,
    "edad-paciente": false,
    "admision": false,
    "viajes-paciente": false,
    "registro": false,
    "email-paciente": false,
    "usuario-de": false,
    "use-condom-reason": false,
    "why-no-use-condom": false,
    "another-transmission": false,
    "positive-result-reaction": false,
    "another-mood": false,
    "test-reason": false,
    "city-patient": false,
    "address-patient": false,
    "born-date-patient": false
};
const validarFormulario = (e) => {
    var miString = e.target.value;
    miString = miString.replace(/^\s*/g, '');
    if (e.target.name !== nameForm + ":email-paciente" && !e.target.name.includes('documento')
        && !e.target.name.includes('test-reason')
        && !e.target.name.includes('born-date-patient')
        && !e.target.name.includes('positive-result-reaction')
        && !e.target.name.includes('why-no-use-condom')
        && !e.target.name.includes('use-condom-reason')
        && !e.target.name.includes('address-patient')) {
        miString = normalize(miString);
        e.target.value = miString.toLowerCase().replace(/\w\S*/g, (w) => (w.replace(/^\w/, (c) => c.toUpperCase())));
    }
    switch (e.target.name) {
        case nameForm + ":nombre-acudiente":
            validarCampo(expresiones.nombre, e.target, "nombre-acudiente");
            break;
        case nameForm + ":nombre-paciente":
            validarCampo(expresiones.nombre, e.target, "nombre-paciente");
            break;
        case nameForm + ":nombre-profesional":
            validarCampo(expresiones.nombre, e.target, "nombre-profesional");
            break;
        case nameForm + ":documento-acudiente":
            validarCampo(expresiones.documento, e.target, "documento-acudiente");
            break;
        case nameForm + ":documento-paciente":
            validarCampo(expresiones.documento, e.target, "documento-paciente");
            break;
        case nameForm + ":documento-profesional":
            validarCampo(expresiones.documento, e.target, "documento-profesional");
            break;
        case nameForm + ":ocupacion-paciente":
            validarCampo(expresiones.nombre, e.target, "ocupacion-paciente");
            break;
        case nameForm + ":telefono-paciente":
            validarCampo(expresiones.telefono, e.target, "telefono-paciente");
            break;
        case nameForm + ":edad-paciente":
            validarCampo(expresiones.digito, e.target, "edad-paciente");
            break;
        case nameForm + ":eps-paciente":
            validarCampo(expresiones.nombre, e.target, "eps-paciente");
            break;
        case nameForm + ":usuario-de":
            validarCampo(expresiones.nombre, e.target, "usuario-de");
            break;
        case nameForm + ":sintomas-paciente":
            validarCampo(expresiones.nombre, e.target, "sintomas-paciente");
            break;
        case nameForm + ":use-condom-reason":
            validarCampo(expresiones.nombre, e.target, "use-condom-reason");
            break;
        case nameForm + ":why-no-use-condom":
            validarCampo(expresiones.nombre, e.target, "why-no-use-condom");
            break;
        case nameForm + ":another-transmission":
            validarCampo(expresiones.nombre, e.target, "another-transmission");
            break;
        case nameForm + ":admision":
            validarCampo(expresiones.digito, e.target, "admision");
            break;
        case nameForm + ":registro":
            validarCampo(expresiones.digito, e.target, "registro");
            break;
        case nameForm + ":viajes-paciente":
            validarCampo(expresiones.nombre, e.target, "viajes-paciente");
            break;
        case nameForm + ":email-paciente":
            validarCampo(expresiones.email, e.target, "email-paciente");
            break;
        case nameForm + ":positive-result-reaction":
            validarCampo(expresiones.nombre, e.target, "positive-result-reaction");
            break;
        case nameForm + ":another-mood":
            validarCampo(expresiones.nombre, e.target, "another-mood");
            break;
        case nameForm + ":test-reason":
            validarCampo(expresiones.nombre, e.target, "test-reason");
            break;
        case nameForm + ":city-patient":
            validarCampo(expresiones.nombre, e.target, "city-patient");
            break;
    }
};
const validarFormularioGuardar = (input) => {
    submit = true;
    switch (input.name) {
        case nameForm + ":nombre-acudiente":
            validarCampo(expresiones.nombre, input, "nombre-acudiente");
            break;
        case nameForm + ":nombre-paciente":
            validarCampo(expresiones.nombre, input, "nombre-paciente");
            break;
        case nameForm + ":nombre-profesional":
            validarCampo(expresiones.nombre, input, "nombre-profesional");
            break;
        case nameForm + ":documento-acudiente":
            validarCampo(expresiones.documento, input, "documento-acudiente");
            break;
        case nameForm + ":documento-paciente":
            validarCampo(expresiones.documento, input, "documento-paciente");
            break;
        case nameForm + ":documento-profesional":
            validarCampo(expresiones.documento, input, "documento-profesional");
            break;
        case nameForm + ":ocupacion-paciente":
            validarCampo(expresiones.nombre, input, "ocupacion-paciente");
            break;
        case nameForm + ":telefono-paciente":
            validarCampo(expresiones.telefono, input, "telefono-paciente");
            break;
        case nameForm + ":eps-paciente":
            validarCampo(expresiones.nombre, input, "eps-paciente");
            break;
        case nameForm + ":usuario-de":
            validarCampo(expresiones.nombre, input, "usuario-de");
            break;
        case nameForm + ":edad-paciente":
            validarCampo(expresiones.digito, input, "edad-paciente");
            break;
        case nameForm + ":sintomas-paciente":
            validarCampo(expresiones.nombre, input, "sintomas-paciente");
            break;
        case nameForm + ":admision":
            validarCampo(expresiones.digito, input, "admision");
            break;
        case nameForm + ":registro":
            validarCampo(expresiones.digito, input, "registro");
            break;
        case nameForm + ":viajes-paciente":
            validarCampo(expresiones.nombre, input, "viajes-paciente");
            break;
        case nameForm + ":email-paciente":
            validarCampo(expresiones.email, input, "email-paciente");
            break;
        case nameForm + ":use-condom-reason":
            validarCampo(expresiones.nombre, input, "use-condom-reason");
            break;
        case nameForm + ":why-no-use-condom":
            validarCampo(expresiones.nombre, input, "why-no-use-condom");
            break;
        case nameForm + ":another-transmission":
            validarCampo(expresiones.nombre, input, "another-transmission");
            break;
        case nameForm + ":positive-result-reaction":
            validarCampo(expresiones.nombre, input, "positive-result-reaction");
            break;
        case nameForm + ":another-mood":
            validarCampo(expresiones.nombre, input, "another-mood");
            break;
        case nameForm + ":test-reason":
            validarCampo(expresiones.nombre, input, "test-reason");
            break;
        case nameForm + ":city-patient":
            validarCampo(expresiones.nombre, input, "city-patient");
            break;
    }
    submit = false;
};
const validarCampo = (expresion, input, campo) => {
    if (expresion.test(input.value)) {
        document.getElementById(`${nameForm}:grupo-${campo}`).classList.remove(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-${campo}`).classList.add(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
        campos[campo] = true;
    } else {
        document.getElementById(`${nameForm}:grupo-${campo}`).classList.add(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-${campo}`).classList.remove(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
        campos[campo] = false;
        if (submit) {
            input.focus();
        }
    }
};
inputs.forEach((input) => {
    input.addEventListener('keyup', validarFormulario);
    input.addEventListener('blur', validarFormulario);
    input.addEventListener('keypress', e => {
        if (e.keyCode === 13) {
            e.preventDefault();
        }
    })
});

function validarGuardar() {
    const firma = document.getElementById(nameForm + ':firma_value');
    if (firma.value !== '') {
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.remove('formulario__input-error-activo');
    } else {
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.add('formulario__input-error-activo');
    }
    const acudiente = document.getElementById(nameForm + ':nombre-acudiente');
    if (campos["admision"]
        && (campos["documento-acudiente"] || !acudiente) && campos["documento-paciente"]
        && (campos["nombre-acudiente"] || !acudiente)
        && campos["nombre-paciente"] && firma.value !== '') {
        saveConsent();
    } else {
        inputs.forEach((input) => {
            validarFormularioGuardar(input);
        });
    }
}

function validarGuardarFormCovid() {
    const firma = document.getElementById(nameForm + ':firma_value');
    if (firma.value !== '') {
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.remove('formulario__input-error-activo');
    } else {
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.add('formulario__input-error-activo');
    }
    const acudiente = document.getElementById(nameForm + ':nombre-acudiente');
    const sintomas = document.getElementById(nameForm + ':sintomas').value === 'true';
    const viajes = document.getElementById(nameForm + ':viajes').value === 'true';
    if (campos["ocupacion-paciente"]
        && campos["telefono-paciente"]
        && campos["edad-paciente"]
        && campos["eps-paciente"]
        && campos["email-paciente"]
        && (campos["documento-acudiente"] || !acudiente) && campos["documento-paciente"]
        && (campos["nombre-acudiente"] || !acudiente)
        && (campos["sintomas-paciente"] || !sintomas)
        && (campos["viajes-paciente"] || !viajes)
        && campos["nombre-paciente"] && firma.value !== '') {
        saveConsent();
    } else {
        inputs.forEach((input) => {
            validarFormularioGuardar(input);
        });
    }
}

function validarGuardarFormAbandon() {
    if (campos["documento-acudiente"]
        && campos["documento-paciente"]
        && campos["nombre-paciente"]
        && campos["nombre-acudiente"]) {
        saveConsent();
    } else {
        inputs.forEach((input) => {
            validarFormularioGuardar(input);
        });
    }
}


function validarGuardarFormUrgencias() {
    const firma = document.getElementById(nameForm + ':firma_value');
    if (firma.value !== '') {
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.remove('formulario__input-error-activo');
    } else {
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.add('formulario__input-error-activo');
    }
    const acudiente = document.getElementById(nameForm + ':nombre-acudiente');
    if (campos["usuario-de"]
        && (campos["documento-acudiente"] || !acudiente) && campos["documento-paciente"]
        && (campos["nombre-acudiente"] || !acudiente)
        && campos["nombre-paciente"] && firma.value !== '') {
        saveConsent();
    } else {
        inputs.forEach((input) => {
            validarFormularioGuardar(input);
        });
    }
}

function validarGuardarFormOdontologiaCovid() {
    const firma = document.getElementById(nameForm + ':firma_value');
    if (firma.value !== '') {
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.remove('formulario__input-error-activo');
    } else {
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.add('formulario__input-error-activo');
    }
    const acudiente = document.getElementById(nameForm + ':nombre-acudiente');
    if (campos["edad-paciente"]
        && (campos["documento-acudiente"] || !acudiente) && campos["documento-paciente"]
        && (campos["nombre-acudiente"] || !acudiente)
        && campos["nombre-paciente"] && firma.value !== ''
    ) {
        saveConsent();
    } else {
        inputs.forEach((input) => {
            validarFormularioGuardar(input);
        });
    }
}

function validarGuardarFormOdontologia() {
    const firma = document.getElementById(nameForm + ':firma_value');
//    const firmaProfesional = document.getElementById(nameForm + ':firma-profesional_value');
    if (firma.value !== '') {
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.remove('formulario__input-error-activo');
    } else {
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.add('formulario__input-error-activo');
    }
    const acudiente = document.getElementById(nameForm + ':nombre-acudiente');
    if ((campos["documento-acudiente"] || !acudiente) && campos["documento-paciente"]
        && (campos["nombre-acudiente"] || !acudiente)
        && campos["nombre-paciente"] && firma.value !== ''
    ) {
        saveConsent();
    } else {
        inputs.forEach((input) => {
            validarFormularioGuardar(input);
        });
    }
}

function validarGuardarFormRegistroProfesional() {
    const firma = document.getElementById(nameForm + ':firma_value');
//    const firmaProfesional = document.getElementById(nameForm + ':firma-profesional_value');
    if (firma.value !== '') {
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.remove('formulario__input-error-activo');
    } else {
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.add('formulario__input-error-activo');
    }
    if (campos["registro"]
        && campos["nombre-profesional"]
        && campos["documento-profesional"]
        && firma.value !== ''
    ) {
        saveProfessional();
    } else {
        inputs.forEach((input) => {
            validarFormularioGuardar(input);
        });
    }
}

function validarGuardarVIH() {
    const firma = document.getElementById(nameForm + ':firma_value');
    const bornDate = document.getElementById(nameForm + ':born-date-patient_input');
    validarCampo(expresiones.date, bornDate, "born-date-patient");
    if (firma.value !== '') {
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.remove('formulario__input-error-activo');
    } else {
        document.getElementById(`${nameForm}:grupo-firma`).classList.add(formGrupoIncorrecto);
        document.getElementById(`${nameForm}:grupo-firma`).classList.remove(formGrupoCorrecto);
        document.querySelector(`#${nameForm}\\:grupo-firma .formulario__input-error`).classList.add('formulario__input-error-activo');
    }
    const transmission = document.getElementById(nameForm + ':transmission').value === 'true';
    const mood = document.getElementById(nameForm + ':mood').value === 'true';
    const condom = document.getElementById(nameForm + ':condom').value === 'true';
    if (campos["documento-paciente"]
        && campos["nombre-paciente"]  && firma.value !== ''
        && ((campos["use-condom-reason"] || !condom) || (campos["why-no-use-condom"] || condom))
        && (campos["another-transmission"] || !transmission)
        && campos["positive-result-reaction"] && (campos["another-mood"] || !mood) && campos["test-reason"]
        && campos["city-patient"] && campos["born-date-patient"]
        && campos["edad-paciente"] && campos["telefono-paciente"] && campos["ocupacion-paciente"]
    ) {
        saveConsent();
    } else {
        inputs.forEach((input) => {
            validarFormularioGuardar(input);
        });
    }
}

function actualizarInputs() {
    inputs = document.querySelectorAll('#' + nameForm + ' .form-control');
    inputs.forEach((input) => {
        input.addEventListener('keyup', validarFormulario);
        input.addEventListener('blur', validarFormulario);
        input.addEventListener('keypress', e => {
            if (e.keyCode === 13) {
                e.preventDefault();
            }
        });
    });
}


function showIconCheck(id, show, clase) {
    if (show) {
        document.getElementById(id).firstElementChild.classList.remove(clase);
    } else {
        document.getElementById(id).firstElementChild.classList.add(clase);

    }
}

var normalize = (function () {
    var from = "ÃÀÁÄÂÈÉËÊÌÍÏÎÒÓÖÔÙÚÜÛãàáäâèéëêìíïîòóöôùúüûÑñÇç",
        to = "AAAAAEEEEIIIIOOOOUUUUaaaaaeeeeiiiioooouuuunncc",
        mapping = {};

    for (var i = 0, j = from.length; i < j; i++)
        mapping[from.charAt(i)] = to.charAt(i);

    return function (str) {
        var ret = [];
        for (var i = 0, j = str.length; i < j; i++) {
            var c = str.charAt(i);
            if (mapping.hasOwnProperty(str.charAt(i)))
                ret.push(mapping[c]);
            else
                ret.push(c);
        }
        return ret.join('');
    };

})();
