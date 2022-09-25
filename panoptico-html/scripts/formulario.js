const URL_API = "http://localhost:8080/visitas_guiadas/register"

function get_data_form(evt) {
  // Indicar que no recarge página al enviar el formulario
  evt.preventDefault()
  const form = evt.target
  const visitas_guiadas = {
    cedula: form.cedula.value,
    nombre: form.nombre.value,
    telefono: form.telefono.value,
    email: form.email.value,
  }
  console.table({ visitas_guiadas })
  if (cedula.value == "" || /^\s+$/.test(cedula)) {
    alert("Error!! El campo nombre no puede estar vacio")
  } else if (nombre.value == "" || /^\s+$/.test(nombre)) {
    alert(
      "Error!! El campo telefono no puede estar vacio y debe contener números"
    )
  } else if (telefono.value == "" || /^\s+$/.test(telefono)) {
    alert(
      "Error!! El campo telefono no puede estar vacio y debe contener números"
    )
  } else if (email.value == "" || /^\s+$/.test(email)) {
    alert("Error!! El campo email no puede estar vacío")
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

function alert(visitas_guiadas) {
  document.getElementById("mensaje-busqueda").innerText =
    visitas_guiadas.nombre + " " + visitas_guiadas.cedula
}

function irInicio() {
  window.location.href = "index.html"
}
