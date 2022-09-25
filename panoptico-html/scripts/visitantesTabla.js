const URL_API = "http://localhost:8080/visitas_guiadas";
let ID_VISITANTE = -1
const UPDATE_FLAG = {
  idVisitas : null
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
                    <button class="btn btn-warning" onclick='btn_update(${JSON.stringify(v)})' data-bs-toggle="modal" data-bs-target="#exampleModal2">Actualizar</button>
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

// ------------------------------ ACTUALIZAR ESTUDIANTE -------------------------------------------

function btn_update (visitante) {
  set_value_form(visitante)
  UPDATE_FLAG.idVisitas = visitante.idVisitas
}

function set_value_form (visitante) {
  document.getElementById("cedula").setAttribute("value", visitante.cedula)
  document.getElementById("cedula").disabled = true
  document.getElementById("nombre").setAttribute("value", visitante.nombre)
  document.getElementById("telefono").setAttribute("value", visitante.telefono)
  document.getElementById("email").setAttribute("value", visitante.email)
}

async function update_visitante(visitante){
  // Enviar Petición
  const resp = await fetch(URL_API, {
      method: 'PUT',
      headers:{
        'Content-Type' : 'application/json'
      },
      body: JSON.stringify(visitante)
    })
  const text = await resp.text()
  const exitoso = "Estudiante No Inscrito actualizado con éxito!"
  if(text == exitoso){
    alert("Visitante actualizado con éxito en la base de datos")
  }else{
    alert(text)
  }
}

async function modificar_visitante(evt) {
  // Indicar que no recarge página al enviar el formulario
  evt.preventDefault()
  const form = evt.target
  const visitante = {
    idVisitas : UPDATE_FLAG.idVisitas,
    cedula : form.cedula.value,
    nombre : form.nombre.value,
    telefono : form.telefono.value,
    email : form.email.value
  }
  let nombre = visitante.nombre
  let telefono = visitante.telefono
  let email = visitante.email

  if(nombre.length==0 || /^\s+$/.test(nombre)){
    alert("Error!! El campo nombre no puede estar vacio")

  } else if(telefono.length==0 || /^\s+$/.test(telefono) || isNaN(telefono)){
    alert("Error!! El campo telefono no puede estar vacio y debe contener números")

  } else if(email.length==0 || /^\s+$/.test(email)){
    alert("Error!! El campo email no puede estar vacío")
    
  } else{
    update_visitante(visitante)
  }
  main()
}

// ------------------------------ MAIN -------------------------------------------

async function main() {
    const visitantes = await getVisitantesInscritos(URL_API)
    listar_visitantes(visitantes)
}


main()