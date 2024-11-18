import { registrarMercancia, obtenerMercancia } from "../services/mercanciaservicio.js";

let botonMercancia=document.getElementById("botonProducto")

let cajaVolumenOcupa = document.getElementById("volumenProducto");
let cajaPesoOcupa = document.getElementById("pesoProducto");
let cajaNombreProducto = document.getElementById("nombreMercancia");
let cajaDescripcionProducto = document.getElementById("descripcionProducto");
let cajaFechaEntrada = document.getElementById("fechaEntrada");
let cajaFechaSalida = document.getElementById("fechaSalida");
let cajaIdZona = document.getElementById("idZona")

botonMercancia.addEventListener("click", function(evento){

    evento.preventDefault()

    let datosProducto={
        volumenOcupa: cajaVolumenOcupa.value,
        pesoOcupa: cajaPesoOcupa.value,
        nombreProducto: cajaNombreProducto.value,
        descripcionProducto: cajaDescripcionProducto.value,
        fechaEntrada: cajaFechaEntrada.value,
        fechaSalida: cajaFechaSalida.value,
        storeZone : {
            idZona : cajaIdZona.value
        }   
    }

    //console.log(datosProducto)
    //lamo al servicio para llevarle datos al back
    registrarMercancia(datosProducto)

    Swal.fire({
        title: "Good job!",
        text: "You clicked the button!",
        icon: "success"
      });


    //
})

obtenerMercancia()



   