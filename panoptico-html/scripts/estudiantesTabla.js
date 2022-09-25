const URL_API = "http://localhost:8080/estudiantes_inscritos";
let ID_ESTUDIANTE = -1
const UPDATE_FLAG = {
  idEstudiante : null
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
                    <button class="btn btn-warning" onclick='btn_update(${JSON.stringify(e)})' data-bs-toggle="modal" data-bs-target="#exampleModal2">Actualizar</button>
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

// ------------------------------ ACTUALIZAR ESTUDIANTE -------------------------------------------

function btn_update (estudiante) {
  set_value_form(estudiante)
  UPDATE_FLAG.idEstudiante = estudiante.idEstudiante
}

function set_value_form (estudiante) {
  document.getElementById("cedula").setAttribute("value", estudiante.cedula)
  document.getElementById("cedula").disabled = true
  document.getElementById("nombre").setAttribute("value", estudiante.nombre)
  document.getElementById("telefono").setAttribute("value", estudiante.telefono)
  document.getElementById("email").setAttribute("value", estudiante.email)
}

async function update_estudiante(estudiante){
  // Enviar Petición
  const resp = await fetch(URL_API, {
      method: 'PUT',
      headers:{
        'Content-Type' : 'application/json'
      },
      body: JSON.stringify(estudiante)
    })
  const text = await resp.text()
  const exitoso = "Estudiante Inscrito actualizado con éxito!"
  if(text == exitoso){
    alert("Estudiante actualizado con éxito en la base de datos")
  }else{
    alert(text)
  }
}

async function modificar_estudiante(evt) {
  // Indicar que no recarge página al enviar el formulario
  evt.preventDefault()
  const form = evt.target
  const estudiante = {
    idEstudiante : UPDATE_FLAG.idEstudiante,
    cedula : form.cedula.value,
    nombre : form.nombre.value,
    telefono : form.telefono.value,
    email : form.email.value
  }
  let nombre = estudiante.nombre
  let telefono = estudiante.telefono
  let email = estudiante.email

  if(nombre.length==0 || /^\s+$/.test(nombre)){
    alert("Error!! El campo nombre no puede estar vacio")

  } else if(telefono.length==0 || /^\s+$/.test(telefono) || isNaN(telefono)){
    alert("Error!! El campo telefono no puede estar vacio y debe contener números")

  } else if(email.length==0 || /^\s+$/.test(email)){
    alert("Error!! El campo email no puede estar vacío")
    
  } else{
    update_estudiante(estudiante)
  }
  main()
}

// ------------------------------ MAIN -------------------------------------------

async function main() {
    const estudiantes = await getEstudiantesInscritos(URL_API)
    listar_estudiantes(estudiantes)
}


main()
