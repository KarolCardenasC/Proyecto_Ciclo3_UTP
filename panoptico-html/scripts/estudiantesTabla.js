const URL_API = "http://localhost:8080/estudiantes_inscritos";
let ID_ESTUDIANTE = -1

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

// ------------------------------ MAIN -------------------------------------------

async function main() {
    const estudiantes = await getEstudiantesInscritos(URL_API)
    listar_estudiantes(estudiantes)
}


main()
