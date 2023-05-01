<%-- 
    Document   : menu
    Created on : 30/04/2023, 8:58:12 p. m.
    Author     : Cami:)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title></title> 
        <meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
    </head>  
    <body>
        <form class="formulario">
            <h1>MENU DE OPCIONES</h1>
            <div class="contenedor">
                    <select id="opcion" onchange="opciones()" class="select">
                        <option disabled selected>Selecciona una opción</option>
                        <option value="consultar">Consultar Usuarios</option>
                        <option value="eliminar" >Eliminar Usuario</option>
                   </select>
       
        <section id="consultars" class="centrada" style="display:none;">
            <h1 class="tit">Consultar Usuarios</h1>
            <button class="button" type="submit">
                <a href="usuarios.jsp">Ir</a>
            </button><br></br>
        </section> 
       
        <section id="elim" class="centrada" style="display:none;">
            <h1 class="tit">Eliminar Usuario</h1>
            <form action="Registrar" method="POST">
                        <button class="button" type="submit">
                            <a>Confirmar y eliminar</a>                
                        </button><br></br>
            </form>
        </section>       
          <section id="eliminars" class="centrada" style="display:none;">
            <h1 class="tit">Eliminar Usuario</h1>
            <form action="Registrar" method="POST">
                <input type="hidden" name="accion" value="eliminarUsuario">
                        <div class="input-contenedor">
                            <i class="fas fa-user icon"></i>
                            <input type="text" placeholder="Usuario de la cuenta" name="usser"> 
                        </div>
                        <div class="input-contenedor">
                            <i class="fas fa-key icon"></i>
                            <input type="text" placeholder="Ingresar Contraseña" name="password">
                        </div>
                        <button class="button" type="submit">
                            <a>Confirmar y eliminar</a>                
                        </button><br></br>
            </form>
        </section>       
        <script>
		function opciones() {
			var opcion = document.getElementById("opcion").value;
			if (opcion == "consultar") {
				document.getElementById("consultars").style.display = "block";
                                document.getElementById("eliminars").style.display = "none";
			}else if(opcion == "eliminar"){
                                document.getElementById("consultars").style.display = "none";
                                document.getElementById("eliminars").style.display = "block";
			}else{
                                document.getElementById("consultars").style.display = "none";
                                document.getElementById("eliminars").style.display = "none";
                        }
		}
	    </script>
            </div>
        </form>       
    </body> 
</html>