<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="vista/css/Index.css">
        <link rel="shortcut icon" href="vista/imagenes/logo.ico">

        <title>Añadir documento</title>

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
                    <h1>Añadir documento</h1>
                    <div class="input-field">
                        <label for="document">Numero del documento</label>
                        <input type="text" name="" id="document" />
                    </div>
                    <div class="input-field">
                        <select
                            name="Tipo documento"
                            id="tipo_de_documento"
                            onchange="tipoDocumento(this)"
                            >
                            <option value="" selected="selected">Seleccione tipo documento</option>
                            <option value="RNT">RNT</option>
                            <option value="NIT">NIT</option>
                            <option value="ciudadania">cedula de ciudadania</option>
                            <option value="extranjeria">cedula de extranjeria</option>
                            <option value="comercio">camara de comercio</option>
                        </select>
                    </div>
                    <div class="input-field">
                        <h3 class="input-field">
                            <b
                                >Para documentos de Cámara de Comercio, RUT o RNT debe subir el
                                documento.
                            </b>
                        </h3>
                        <input
                            type="file"
                        />
                    </div>
                    <button type="submit" class="waves-effect waves-light btn">
                        ENVIAR
                    </button>
                </form>
            </div>
        </div>

    </body>

</html>