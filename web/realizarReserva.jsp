<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="vista/css/añadirPropiedad.css">
        <link rel="shortcut icon" href="vista/imagenes/logo.ico">

        <title>Realizar reserva</title>

    </head>

    <body>
        <div class="Pagina">
            <header>
                <nav>
                    <div class="Menu">
                        <a href="index.jsp"><img class="logo" src="./vista/imagenes/logo.png" alt="vivo turismo"></a>
                        <a class="men" href="configuracion.html">Configuración</a>
                        <a class="men" href="index.jsp">Cerrar sesión</a>
                        <a class="men" href="perfilPropietario.jsp">Perfil</a>
                    </div>
                </nav>
            </header>
            <div class="editar">
                <form action="" class="row">
                    <H1 class="input-field">Estás realizando tu reserva</H1>
                    <h3 class="input-field">(Para continuar completa los siguientes campos)</h3>
                    <div class="input-field">
                        <label for="Estancia">Estancia</label>
                        <input type="text" id="Estancia" required />
                    </div>
                    <div class="input-field">
                        <input
                            type="text"
                            class="datepicker"
                            placeholder="Fecha inicial"
                            required
                        />
                        <input
                            type="text"
                            class="datepicker"
                            placeholder="Fecha final"
                            required
                        />
                    </div>
                    <div class="input-field">
                        <label>Cantidad de personas</label>
                        <input type="text" required />
                    </div>
                    <div class="input-field">
                        <select name="Inmueble solicitado" >
                            <option value="" selected="selected">Inmueble solicitado</option>
                            <option value="Finca Las Brisas">Finca Las Brisas</option>
                            <option value="Condominio La Extrella">Condominio La Extrella</option>
                            <option value="Casa Quinta Helenita">Casa Quinta Helenita</option>
                        </select>
                    </div>                                                                      
                    <button type="submit" class="waves-effect waves-light btn">
                        ENVIAR
                    </button>
                </form>
            </div>
        </div>

    </body>

</html>