package com.example.logisticAPP.helpers.mensajes;

public enum MensajesError {

    VOLUMEN_INVALIDO("El volumen ingresado es invalido"),
    PESO_INVALIDO("El peso ingresado es invalido"),
    DESCRIPCION_INVALIDA("Revisa la descripción ingresada"),
    NOMBREZONA_INVALIDO("El nombre ingresado tiene mas de 50 carecteres"),
    VOLUMENOCUPADO_INVALIDO("El volumen ocupado ingresado no es valido"),
    PESOOCUPADO_INVALIDO("El peso ocupado ingresado no es valido")

    ;

    private String mensaje;

    MensajesError() {
    }

    MensajesError(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
