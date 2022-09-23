const URL_API = "http://localhost:8080/estudiantes_inscritos";

function submit_search (evt) {
    evt.preventDefault()    
    const cedula = evt.target.cedula.value
   // console.log(cedula)
    search(cedula) 
  
  }

  async function search (cedula) {
    // enviar petición
    const respuesta_existe = await fetch(`${URL_API}/existe/${cedula}`)
    const existe = await respuesta_existe.json()
    //console.log(existe)
    if (existe){
        const respuesta = await fetch(`${URL_API}/${cedula}`)
    const estudiante = await respuesta.json()
    console.log(estudiante)
    document.getElementById("mensaje-busqueda").innerText = "¡BIENVENIDO(A) " +estudiante.nombre + "\n"
    + "AL MUESO PANÓPTICO DE IBAGUÉ!"
    }
    else{
    document.getElementById("mensaje-busqueda").innerText = "Usuario consultado CC:" + cedula+
    " NO es estudiante registrado" 
    //alert("Usuario consultado NO es estudiante registrado")
    }
   // listarMascotas([mascota])
  }






