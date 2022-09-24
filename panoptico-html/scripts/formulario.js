const URL_API = "http://localhost:8080/visitas_guiadas"

const UPDATE_FLAG = {
  update: false,
  idVisitas: null,
}

function get_data_form(evt) {
  evt.preventDefault()
  const form = evt.target
  const visitas_guiadas = {
    cedula: form.cedula.value,
    nombre: form.nombre.value,
    telefono: form.telefono.value,
    email: form.email.value,
  }
  console.table({ visitas_guiadas })
  if (UPDATE_FLAG.update) {
    // añade el idVisitas al objeto visitas_guiadas
    visitas_guiadas.idVisitas = UPDATE_FLAG.idVisitas
    update(visitas_guiadas)
  } else {
    create(visitas_guiadas)
  }

  clear(form)
}

function clear(form) {
  form.cedula.value = ""
  form.nombre.value = ""
  form.telefono.value = ""
  form.email.value = ""
}

async function create(visitas_guiadas) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(visitas_guiadas),
  })
  const text = await resp.text()
  alert(text)
}

function set_value_form(visitas_guiadas) {
  document
    .getElementByidVisitas("cedula")
    .setAttribute("value", visitas_guiadas.nombre)
  document
    .getElementByidVisitas("nombre")
    .setAttribute("value", visitas_guiadas.apellidVisitaso)
  document
    .getElementByidVisitas("telefono")
    .setAttribute("value", visitas_guiadas.raza)
  document
    .getElementByidVisitas("email")
    .setAttribute("value", visitas_guiadas.foto)
}
