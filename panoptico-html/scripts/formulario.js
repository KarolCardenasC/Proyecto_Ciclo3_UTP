const URL_API = "http://localhost:8080/visitas_guiadas/register"

function get_data_form(evt) {
  // Indicar que no recarge página al enviar el formulario
  evt.preventDefault()

  let modal_titulo = document.getElementById("exampleModalLabel")
  let modal_body = document.getElementById("mensaje-busqueda")

  const form = evt.target
  const visitas_guiadas = {
    cedula: form.cedula.value,
    nombre: form.nombre.value,
    telefono: form.telefono.value,
    email: form.email.value,
  }
  console.table({ visitas_guiadas })
  if (cedula.value == "" || /^\s+$/.test(cedula.value)) {
    modal_titulo.innerText = "Error"
    modal_body.innerText =
      "Error!! El campo cedula no puede estar vacio y debe contener números"
  } else if (nombre.value == "" || /^\s+$/.test(nombre.value)) {
    modal_titulo.innerText = "Error"
    modal_body.innerText = "Error!! El campo nombre no puede estar vacio"
  } else if (telefono.value == "" || /^\s+$/.test(telefono.value)) {
    modal_titulo.innerText = "Error"
    modal_body.innerText =
      "Error!! El campo telefono no puede estar vacio y debe contener números"
  } else if (email.value == "" || /^\s+$/.test(email.value)) {
    modal_titulo.innerText = "Error"
    modal_body.innerText = "Error!! El campo email no puede estar vacío"
  } else {
    create(visitas_guiadas, modal_titulo, modal_body)
  }

  clear(form)
}

function clear(form) {
  form.cedula.value = ""
  form.nombre.value = ""
  form.telefono.value = ""
  form.email.value = ""
}

async function create(visitas_guiadas, modal_titulo, modal_body) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(visitas_guiadas),
  })

  const text = await resp.text()
  const exitoso =
    "Visitante registrado con éxito" +
    "\n" +
    "Estudiante No inscrito ingresado a la tabla registro con éxito"
  const regis_exitoso =
    "Converting `org.hibernate.exception.ConstraintViolationException` to JPA `PersistenceException` : could not execute statement" +
    "\n" +
    "Estudiante No inscrito ingresado a la tabla registro con éxito"

  if (text == exitoso) {
    modal_titulo.innerText = "Bienvenido" + " " + visitas_guiadas.nombre
    modal_body.innerText = `Su registro fué exitoso y se ingresó a la base de datos correctamente ¡¡¡Disfrute su visita!!!`
  } else if (text == regis_exitoso) {
    modal_titulo.innerText = "Bienvenido" + " " + visitas_guiadas.nombre
    modal_body.innerText = `La cedula digitada ya se encuentra registrada, por lo que sólo se hizo válido el ingreso ¡¡¡Disfrute su visita!!!`
  } else {
    modal_titulo.innerText = "Error"
    modal_body.innerText = `Problema al conectarse con la base de datos, por favor intentelo más tarde !!!`
  }
}

function irInicio() {
  window.location.href = "index.html"
}
