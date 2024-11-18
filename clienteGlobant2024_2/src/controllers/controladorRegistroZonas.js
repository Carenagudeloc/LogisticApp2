import { registrarZona } from "../services/zonaservicio.js";

let botonMercancia=document.getElementById("botonZona")

let cajaNombreZona = document.getElementById("nombreZona");
let cajaVolumenMaximoZona = document.getElementById("volumenMaximoZona");
let cajaPesoMaximoZona = document.getElementById("pesoMaximoZona");


botonMercancia.addEventListener("click", function(evento){

evento.preventDefault()

let datosZona={
    nombreZona: cajaNombreZona.value,
    volumenMaximo: cajaVolumenMaximoZona.value,
    pesoMaximo: cajaPesoMaximoZona.value,
}

    console.log(datosZona)

    registrarZona(datosZona)

    Swal.fire({
        title: "Good job!",
        text: "You clicked the button!",
        icon: "success"
      });

})