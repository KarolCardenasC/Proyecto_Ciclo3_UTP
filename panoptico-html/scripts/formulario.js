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
  const respuesta_existe = await fetch(
    `${URL_API}/register/${(cedula, nombre, telefono, email)}`
  )
  const existe = await respuesta_existe.json()
  //console.log(existe)
  if (existe) {
    const respuesta = await fetch(`${URL_API}/${cedula}`)
    const visitante = await respuesta.json()
    console.log(visitante)
    document.getElementById("mensaje-busqueda").innerText =
      "¡BIENVENIDO(A) " +
      visitante.nombre +
      "\n" +
      "AL MUESO PANÓPTICO DE IBAGUÉ!"
    registrarIngreso(visitante)
  } else {
    document.getElementById("mensaje-busqueda").innerText =
      "Usuario: " + cedula + nombre + " NO ha sido registrado"
  }
}

async function registrarIngreso(visitante) {
  const url_registrar_ingreso = URL_VISITAS + "/" + visitante.cedula
  // enviar petición
  const resp = await fetch(url_registrar_ingreso, {
    method: "POST",
  })
}
