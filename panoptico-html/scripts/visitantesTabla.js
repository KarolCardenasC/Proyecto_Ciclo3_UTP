const URL_API = "http://localhost:8080/visitas_guiadas";
let ID_VISITANTE = -1

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

// ------------------------------ MAIN -------------------------------------------

async function main() {
    const visitantes = await getVisitantesInscritos(URL_API)
    listar_visitantes(visitantes)
}


main()