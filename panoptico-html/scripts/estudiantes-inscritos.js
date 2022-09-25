const URL_API = "http://localhost:8080/estudiantes_inscritos";
const URL_INSCRITOS = "http://localhost:8080/ingreso/estudiantes";

function submit_search (evt) {
    evt.preventDefault()    
    const cedula = evt.target.cedula.value
    if(cedula.length==0 || /^\s+$/.test(cedula)){
      document.getElementById("mensaje-busqueda").innerText = "Error el campo cédula NO puede estar vacío " 
      console.log(cedula)
    }else{
      search(cedula) 
    }
   // console.log(cedula)
   
  
  }

  async function search (cedula) {
    // enviar petición
    const respuesta_existe = await fetch(`${URL_API}/existe/${cedula}`)
    const existe = await respuesta_existe.json()
    //console.log(existe)
    if (existe){
        const respuesta = await fetch(`${URL_API}/${cedula}`)
        const estudiante = await respuesta.json()
        //console.log(estudiante)
        document.getElementById("mensaje-busqueda").innerText = "¡BIENVENIDO(A) " +estudiante.nombre + "\n"
        + "AL MUESO PANÓPTICO DE IBAGUÉ!"
        registrarIngreso(estudiante)
        const btnAceptar =  document.getElementById("aceptar")
        let contenidoAceptar=`
            <button type="button" class="btn btn-success" 
            data-bs-dismiss="modal"
            id="aceptar"     
            name="aceptar"  
            onclick="irInicio()" 
            >Aceptar</button>
        `
        btnAceptar.innerHTML= contenidoAceptar
    }
    else{
    document.getElementById("mensaje-busqueda").innerText = "Usuario consultado CC:" + cedula+
    " NO es estudiante registrado" 
    //alert("Usuario consultado NO es estudiante registrado")
    }
   
  }

  async function registrarIngreso(estudiante){
    const url_registrar_ingreso = URL_INSCRITOS+"/"+estudiante.cedula
     // enviar petición
     const resp = await fetch(url_registrar_ingreso, {
        method: 'POST'
      })
      
      /* const text = await resp.text()
      alert(text) */
    

  }

  function irInicio(){
    window.location.href = "index.html"
  }
 





