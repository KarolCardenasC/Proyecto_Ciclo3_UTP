const URL_API = "http://localhost:8080/visitas_guiadas"
const URL_VISITAS = "http://localhost:8080/ingreso/visitantes"

function submit_post(evt) {
  evt.preventDefault()
  const cedula = evt.target.cedula.value
  const nombre = evt.target.cedula.value
  const telefono = evt.target.cedula.value
  const email = evt.target.cedula.value
  // console.log(cedula)
  POST(cedula, nombre, telefono, email)
}

async function POST(cedula, nombre, telefono, email) {
  // enviar petición
  const respuesta_visitante = await fetch(
    `${URL_API}/register/${(cedula, nombre, telefono, email)}`
  )
}
