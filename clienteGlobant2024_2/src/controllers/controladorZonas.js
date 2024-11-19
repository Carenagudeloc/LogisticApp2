async function cargarZonas() {
    const url = "http://localhost:8080/logisticApp/v1/zonaBodega/zonas";

    try {
        const respuesta = await fetch(url); 
        if (!respuesta.ok) {
            throw new Error("Error al obtener las zonas");
        }

        const zonas = await respuesta.json(); 

        const select = document.getElementById("zonaSelect");
        select.innerHTML = ""; 
        zonas.forEach(zona => {
            const option = document.createElement("option");
            option.value = zona.id; 
            option.textContent = zona.nombreZona; 
            select.appendChild(option);
        });
    } catch (error) {
        console.error("Error al cargar las zonas:", error.message);
    }
}

document.addEventListener("DOMContentLoaded", cargarZonas);