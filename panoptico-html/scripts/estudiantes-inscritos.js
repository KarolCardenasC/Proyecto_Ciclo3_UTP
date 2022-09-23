const URL_API = "http://localhost:8080/estudiantes_inscritos";

function submit_search (evt) {
    evt.preventDefault()
    //alert("evento ok")
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
    }
    else
    alert("Usuario consultado NO es estudiante registrado")
    
   // listarMascotas([mascota])
  }






