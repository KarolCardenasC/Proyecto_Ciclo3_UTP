const URL_API = "http://localhost:8080/ingreso";
let ID_INGRESO = -1

//--------------------- LISTAR INGRESOS ----------------------------------

async function getIngreso(url) {
  // Enviar petición
  const resp = await fetch(url)
  const ingresos = await resp.json()
  return ingresos
}

function listar_ingresos(ingresos) {
  // Referenciar tabla
  const table = document.getElementById("tbody")
  let tbody = ""
  // Iterar ingresos
  for (let i = 0; i < ingresos.length; i++) {
    const ing = ingresos[i]
    tbody += `<tr> 
                  <th scope="row">${ing.idIngreso}</th>
                  <td>${ing.fecha}</td>
                  <td>${ing.ingreso_estudiante}</td>
                  <td>${ing.ingreso_visita}</td>
                  <td>
                    <button class="btn btn-danger" onclick='btn_delete(${JSON.stringify(ing)})' data-bs-toggle="modal" data-bs-target="#exampleModal">Eliminar</button>
                  </td>
                </tr>`
  }
  table.innerHTML = tbody
}

//--------------------- ELIMINAR INGRESO ----------------------------------

function btn_delete(ingreso) {
  let obtener = document.getElementById("ingreso-eliminar")
  if (ingreso.ingreso_estudiante != null) {
    obtener.innerText = "Estudiante con número de cédula " + ingreso.ingreso_estudiante
  } else {
    obtener.innerText = "Visitante con número de cédula " + ingreso.ingreso_visita
  }

  ID_INGRESO = ingreso.idIngreso
}

async function delete_ingreso() {
  // enviar petición
  const resp = await fetch(`${URL_API}/${ID_INGRESO}`, {
    method: 'DELETE'
  })
  const text = await resp.text()
  alert(text)
  main()
}

// ------------------------------ MAIN -------------------------------------------

async function main() {
  const ingresos = await getIngreso(URL_API)
  listar_ingresos(ingresos)
}


main()