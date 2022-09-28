const URL_API = "http://localhost:8080/login_admin"

function submit_search(evt) {
  evt.preventDefault()

  let modal_titulo = document.getElementById("exampleModalLabel")
  let modal_body = document.getElementById("mensaje-busqueda")

  const form = evt.target
  const login_admin = {
    email: form.email.value,
    pass: form.pass.value,
  }
  console.table({ login_admin })
  if (email.value == "" || /^\s+$/.test(email.value)) {
    modal_titulo.innerText = "Error"
    modal_body.innerText = "¡El campo email no puede estar vacio!"
  } else if (pass.value == "" || /^\s+$/.test(pass.value)) {
    modal_titulo.innerText = "Error"
    modal_body.innerText = "¡El campo password no puede estar vacio!"
  } else {
    register(login_admin, modal_titulo, modal_body)
  }
  clear(form)
}

function clear(form) {
  form.email.value = ""
  form.pass.value = ""
}

function btn_register(login_email) {
  document.getElementById("email").innerText = login_email.email
}

function btn_register(login_pass) {
  document.getElementById("pass").innerText = login_pass.pass
}

async function register() {
  // enviar petición
  const resp = await fetch(`${URL_API}/`, {
    method: "GET",
  })
  const text = await resp.text()
  irTablas(text)
}

function irTablas() {
  window.location.href = "ingresoTabla.html"
}

function submit_login(evt) {
  evt.preventDefault()
  const email = evt.target.mail.value
  const pass = evt.target.pass.value
  if(email.length==0 || /^\s+$/.test(email) || pass.length==0 || /^\s+$/.test(pass) ){
    document.getElementById("mensaje-busqueda").innerText = "Error el campo email o cédula NO puede estar vacío " 
    //console.log(cedula)
  }else{
    //alert(pass)
  search(email, pass)
  }
  

}

async function search (email, pass) {
  // enviar petición
  const respuesta_existe = await fetch(`${URL_API}/login?username=${email}&clave=${pass}`)
  const existe = await respuesta_existe.json()
  
  //alert(existe)
  if (existe){
    //alert("login exitoso")
    document.getElementById("mensaje-busqueda").innerText = "Bienvenido" 
    window.location.href = "ingresoTabla.html"
  }else{
    document.getElementById("mensaje-busqueda").innerText = "Usuario o clave equivocados" 
    //clear(form)
  }

}

