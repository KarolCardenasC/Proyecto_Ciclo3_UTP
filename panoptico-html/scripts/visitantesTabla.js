const URL_API = "http://localhost:8080/visitas_guiadas";
let ID_VISITANTE = -1

// ------------------------------ REFRESCAR VENTANA ----------------------

function refrescarPagina(){
  location.reload();
}

// ------------------------------ LISTAR VISITANTES -------------------------------------------

async function getVisitantesInscritos(url) {
    // Enviar petición
    const resp = await fetch(url)
    const visitantes = await resp.json()
    return visitantes
}

function listar_visitantes(visitantes) {
    // Referenciar tabla
    const table = document.getElementById("tbody")
    let tbody = ""
    // Iterar visitantes
    for (let i = 0; i < visitantes.length; i++) {
        const v = visitantes[i]
        tbody += `<tr> 
                  <th scope="row">${v.idVisitas}</th>
                  <td>${v.cedula}</td>
                  <td>${v.nombre}</td>
                  <td>${v.telefono}</td>
                  <td>${v.email}</td>
                  <td>
                    <button class="btn btn-warning" onclick='update(${JSON.stringify(v)})'>Actualizar</button>
                    <button class="btn btn-danger" onclick='btn_delete(${JSON.stringify(v)})' data-bs-toggle="modal" data-bs-target="#exampleModal">Eliminar</button>
                  </td>
                </tr>`
    }
    table.innerHTML = tbody
}

// ------------------------------ ELIMINAR VISITAANTE -------------------------------------------

function btn_delete (visitante) {
  document.getElementById("visitante-eliminar").innerText = visitante.nombre + " con número de cédula " + visitante.cedula
  ID_VISITANTE = visitante.idVisitas
}

async function delete_visitante () {
  // enviar petición
  const resp = await fetch(`${URL_API}/id/${ID_VISITANTE}`, {
    method: 'DELETE'
  })
  const text = await resp.text()
  const exitoso = "Estudiante No Inscrito eliminado con éxito!"
  if(text == exitoso){
    alert("Visitante eliminado con éxito")
  }else{
    const msg = "Error al eliminar Visitante!!! La cedula coincide con algunos registros en la tabla Ingresos"
    alert(msg)
  }
  main()
}

// ------------------------------ CREAR VISITANTE -------------------------------------------

async function registrar_visitante(evt) {
  // Indicar que no recarge página al enviar el formulario
  evt.preventDefault()
  const form = evt.target
  const visitante = {
    cedula : form.cedula.value,
    nombre : form.nombre.value,
    telefono : form.telefono.value,
    email : form.email.value
  }
  
  
  let cedula = visitante.cedula
  let nombre = visitante.nombre
  let telefono = visitante.telefono
  let email = visitante.email


  if(cedula.length==0 || /^\s+$/.test(cedula) || isNaN(cedula)){
    alert("Error!! El campo cédula no puede estar vacío y debe contener números")

  } else if(nombre.length==0 || /^\s+$/.test(nombre)){
    alert("Error!! El campo nombre no puede estar vacio")

  } else if(telefono.length==0 || /^\s+$/.test(telefono) || isNaN(telefono)){
    alert("Error!! El campo telefono no puede estar vacio y debe contener números")

  } else if(email.length==0 || /^\s+$/.test(email)){
    alert("Error!! El campo email no puede estar vacío")
    
  } else{
    create_visitante(visitante)
  }
    
  clear(form)
}

function clear(form){
  form.cedula.value = ""
  form.nombre.value = ""
  form.telefono.value = ""
  form.email.value = ""
}

async function create_visitante(visitante){
  // Enviar Petición
  const resp = await fetch(URL_API, {
      method: 'POST',
      headers:{
        'Content-Type' : 'application/json'
      },
      body: JSON.stringify(visitante)
    })
  const text = await resp.text()
  const exitoso = "Visitante registrado con éxito"
  if(text == exitoso){
    alert(exitoso)
  }else{
    const msg = "Error al registrar Visitante!!! La cedula digitada ya se encuentra en la base de datos"
    alert(msg)
  }
  
}

// ------------------------------ MAIN -------------------------------------------

async function main() {
    const visitantes = await getVisitantesInscritos(URL_API)
    listar_visitantes(visitantes)
}


main()