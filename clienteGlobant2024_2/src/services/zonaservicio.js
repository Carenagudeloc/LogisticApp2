export async function registrarZona(datosZona) {
    const URL = "http://localhost:8080/logisticApp/v1/zonaBodega"

    let peticion = {
        method: "POST",
        headers: {
            "Content-Type":"application/json"
        },
        body:JSON.stringify(datosZona)
    }

    let respuestaServidor = await fetch(URL, peticion)

    let respuestFinal = await respuestaServidor.json()

    console.log(respuestFinal)
}

