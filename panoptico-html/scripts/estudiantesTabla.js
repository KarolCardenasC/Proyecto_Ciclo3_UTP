const URL_API = "http://localhost:8080/estudiantes_inscritos";
let ID_ESTUDIANTE = -1

// ------------------------------ REFRESCAR VENTANA ----------------------

function refrescarPagina(){
  location.reload();
}

// ------------------------------ LISTAR ESTUDIANTES -------------------------------------------

async function getEstudiantesInscritos(url) {
    // Enviar petición
    const resp = await fetch(url)
    const estudiantes = await resp.json()
    return estudiantes
}

function listar_estudiantes(estudiantes) {
    // Referenciar tabla
    const table = document.getElementById("tbody")
    let tbody = ""
    // Iterar estudiantes
    for (let i = 0; i < estudiantes.length; i++) {
        const e = estudiantes[i]
        tbody += `<tr> 
                  <th scope="row">${e.idEstudiante}</th>
                  <td>${e.cedula}</td>
                  <td>${e.nombre}</td>
                  <td>${e.telefono}</td>
                  <td>${e.email}</td>
                  <td>
                    <button class="btn btn-warning" onclick='update(${JSON.stringify(e)})'>Actualizar</button>
                    <button class="btn btn-danger" onclick='btn_delete(${JSON.stringify(e)})' data-bs-toggle="modal" data-bs-target="#exampleModal">Eliminar</button>
                  </td>
                </tr>`
    }
    table.innerHTML = tbody
}

// ------------------------------ ELIMINAR ESTUDIANTE -------------------------------------------

function btn_delete (estudiante) {
  document.getElementById("estudiante-eliminar").innerText = estudiante.nombre + " con número de cédula " + estudiante.cedula
  ID_ESTUDIANTE = estudiante.idEstudiante
}

async function delete_estudiante () {
  // enviar petición
  const resp = await fetch(`${URL_API}/id/${ID_ESTUDIANTE}`, {
    method: 'DELETE'
  })
  const text = await resp.text()
  const exitoso = "Estudiante Inscrito eliminado con éxito!"
  if(text == exitoso){
    alert("Estudiante eliminado con éxito")
  }else{
    const msg = "Error al eliminar Estudiante!!! La cedula coincide con algunos registros en la tabla Ingresos"
    alert(msg)
  }
  main()
}

// ------------------------------ CREAR ESTUDIANTE -------------------------------------------
async function registrar_estudiante(evt) {
  // Indicar que no recarge página al enviar el formulario
  evt.preventDefault()
  const form = evt.target
  const estudiante = {
    cedula : form.cedula.value,
    nombre : form.nombre.value,
    telefono : form.telefono.value,
    email : form.email.value
  }

  let cedula = estudiante.cedula
  let nombre = estudiante.nombre
  let telefono = estudiante.telefono
  let email = estudiante.email


  if(cedula.length==0 || /^\s+$/.test(cedula) || isNaN(cedula)){
    alert("Error!! El campo cédula no puede estar vacío y debe contener números")

  } else if(nombre.length==0 || /^\s+$/.test(nombre)){
    alert("Error!! El campo nombre no puede estar vacio")

  } else if(telefono.length==0 || /^\s+$/.test(telefono) || isNaN(telefono)){
    alert("Error!! El campo telefono no puede estar vacio y debe contener números")

  } else if(email.length==0 || /^\s+$/.test(email)){
    alert("Error!! El campo email no puede estar vacío")
    
  } else{
    create_estudiante(estudiante)
  }
    
  clear(form)
}

function clear(form){
  form.cedula.value = ""
  form.nombre.value = ""
  form.telefono.value = ""
  form.email.value = ""
}

async function create_estudiante(estudiante){
  // Enviar Petición
  const resp = await fetch(URL_API, {
      method: 'POST',
      headers:{
        'Content-Type' : 'application/json'
      },
      body: JSON.stringify(estudiante)
    })
  const text = await resp.text()
  const exitoso = "Estudiante registrado con éxito"
  if(text == exitoso){
    alert(exitoso)
  }else{
    const msg = "Error al registrar Estudiante!!! La cedula digitada ya se encuentra en la base de datos"
    alert(msg)
  }
  
}

// ------------------------------ MAIN -------------------------------------------

async function main() {
    const estudiantes = await getEstudiantesInscritos(URL_API)
    listar_estudiantes(estudiantes)
}


main()
