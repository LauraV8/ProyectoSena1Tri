-- MySQL Script generated by MySQL Workbench
-- Sun Jul 19 12:28:42 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tipousuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tipousuarios` (
  `idTipoUsuarios` INT NOT NULL AUTO_INCREMENT COMMENT 'En este campo contiene el id que es  la llave pincipal de la entidad nivel',
  `tipoUsuario` VARCHAR(250) NOT NULL COMMENT 'En este campo almacena el nombre del nivel',
  PRIMARY KEY (`idTipoUsuarios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuarios` (
  `idUsuarios` INT NOT NULL AUTO_INCREMENT COMMENT 'Este campo tiene la llave principal de la tabla usuario ',
  `nombre` VARCHAR(250) NOT NULL COMMENT 'En este campo se almacena el nombre del usuario',
  `apellido` VARCHAR(250) NOT NULL COMMENT 'En este campo se almacena el apellido del usuario',
  `nombreUsuario` VARCHAR(250) NOT NULL,
  `email` VARCHAR(250) NOT NULL COMMENT 'En este campo se almacena el email del usuario',
  `fechaDeNacimiento` VARCHAR(250) NOT NULL COMMENT 'En este campo se almacena la fecha de nacimiento  del usuario',
  `telefono` VARCHAR(250) NOT NULL COMMENT 'En este campo se almacena el telefono del usuario',
  `direccion` VARCHAR(250) NOT NULL,
  `contraseña` VARCHAR(250) NOT NULL COMMENT 'En este campo se almacena la contraseña del usuario',
  `tipousuarios_idTipoUsuarios` INT NOT NULL COMMENT 'En este campo contiene la relacion con la entidad  nivel',
  PRIMARY KEY (`idUsuarios`),
  INDEX `fk_ususario_Nivel1_idx` (`tipousuarios_idTipoUsuarios` ASC),
  UNIQUE INDEX `nombreUsuario_UNIQUE` (`nombreUsuario` ASC),
  CONSTRAINT `fk_ususario_Nivel1`
    FOREIGN KEY (`tipousuarios_idTipoUsuarios`)
    REFERENCES `mydb`.`tipousuarios` (`idTipoUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comentarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`comentarios` (
  `idComentarios` INT NOT NULL AUTO_INCREMENT COMMENT 'En este campo se contiene la llave principal de  la entidad  comentario',
  `calificacion` INT NULL COMMENT 'En este campo se almacena la calificacion de  la entidad  comentario',
  `descripcion` VARCHAR(250) NULL COMMENT 'En este campo se almacena la descripcion de la entidad  comentario',
  `usuarios_idUsuarios` INT NOT NULL,
  PRIMARY KEY (`idComentarios`),
  INDEX `fk_Comentario_Usuarios1_idx` (`usuarios_idUsuarios` ASC),
  CONSTRAINT `fk_Comentario_Usuarios1`
    FOREIGN KEY (`usuarios_idUsuarios`)
    REFERENCES `mydb`.`usuarios` (`idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipoinmuebles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tipoinmuebles` (
  `idTipoInmuebles` INT NOT NULL AUTO_INCREMENT COMMENT 'En este campo se  almacena la llave principal de la entidad tipo de inmueble ',
  `tipoInmueble` VARCHAR(250) NOT NULL COMMENT 'En este campo contiene informacion si es condominio de la entidad tipo de inmueble ',
  PRIMARY KEY (`idTipoInmuebles`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ciudades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ciudades` (
  `idCiudades` INT NOT NULL AUTO_INCREMENT,
  `nombreCiudad` VARCHAR(250) NOT NULL,
  `nombreDepartamento` VARCHAR(250) NOT NULL,
  `direccion` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idCiudades`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`inmuebles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`inmuebles` (
  `idInmuebles` INT NOT NULL AUTO_INCREMENT COMMENT 'En este campo contiene la llave principal de la entidad inmueble',
  `nombre` VARCHAR(250) NOT NULL,
  `precioAlquiler` INT NOT NULL COMMENT 'En este campo se almacena el precio del alquiler de la entidad inmuebles',
  `descripcion` VARCHAR(250) NOT NULL COMMENT 'En este campo se almacena la descripcion de la entidad inmuebles',
  `tipoinmuebles_idTipoInmuebles` INT NOT NULL COMMENT 'En este campo se contiene la llave foranea de la relacion con la entidad  tipo de inmueble',
  `usuarios_idUsuarios` INT NOT NULL,
  `ciudades_idCiudades` INT NOT NULL,
  PRIMARY KEY (`idInmuebles`),
  INDEX `fk_inmuebles_TipoInmueble1_idx` (`tipoinmuebles_idTipoInmuebles` ASC),
  INDEX `fk_Inmuebles_Usuarios1_idx` (`usuarios_idUsuarios` ASC),
  INDEX `fk_inmuebles_ciudades1_idx` (`ciudades_idCiudades` ASC),
  CONSTRAINT `fk_inmuebles_TipoInmueble1`
    FOREIGN KEY (`tipoinmuebles_idTipoInmuebles`)
    REFERENCES `mydb`.`tipoinmuebles` (`idTipoInmuebles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inmuebles_Usuarios1`
    FOREIGN KEY (`usuarios_idUsuarios`)
    REFERENCES `mydb`.`usuarios` (`idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inmuebles_ciudades1`
    FOREIGN KEY (`ciudades_idCiudades`)
    REFERENCES `mydb`.`ciudades` (`idCiudades`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`estadoreservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`estadoreservas` (
  `idEstadoReservas` INT NOT NULL AUTO_INCREMENT,
  `nombreEstado` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idEstadoReservas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reservas` (
  `idReservas` INT NOT NULL AUTO_INCREMENT COMMENT 'En este campo contiene la llave primaria de la entidad reserva',
  `estancia` VARCHAR(250) NOT NULL COMMENT 'En este campo se almacena la estancia  de la entidad reserva',
  `cantidadDePersonas` INT NOT NULL COMMENT 'En este campo se almacena la cantidad de personas de la entidad reserva',
  `ingreso` VARCHAR(250) NOT NULL,
  `salida` VARCHAR(250) NOT NULL,
  `inmuebles_idInmuebles` INT NOT NULL COMMENT 'En este campo contiene la llave foranea de la relacion de la entidad inmuebles',
  `Usuarios_idUsuarios` INT NOT NULL,
  `estadoreservas_idEstadoReservas` INT NOT NULL,
  PRIMARY KEY (`idReservas`),
  INDEX `fk_Resevas_inmuebles1_idx` (`inmuebles_idInmuebles` ASC),
  INDEX `fk_Reservas_Usuarios1_idx` (`Usuarios_idUsuarios` ASC),
  INDEX `fk_reservas_estadoreservas1_idx` (`estadoreservas_idEstadoReservas` ASC),
  CONSTRAINT `fk_Resevas_inmuebles1`
    FOREIGN KEY (`inmuebles_idInmuebles`)
    REFERENCES `mydb`.`inmuebles` (`idInmuebles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservas_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuarios`)
    REFERENCES `mydb`.`usuarios` (`idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservas_estadoreservas1`
    FOREIGN KEY (`estadoreservas_idEstadoReservas`)
    REFERENCES `mydb`.`estadoreservas` (`idEstadoReservas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`fotos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`fotos` (
  `idFotos` INT NOT NULL AUTO_INCREMENT COMMENT 'En este campo se contiene la llave principal de  la entidad  fotos',
  `urlFoto` VARCHAR(250) NULL COMMENT 'En este campo almacena la foto 4  de  la entidad  fotos',
  `inmuebles_idInmuebles` INT NOT NULL COMMENT 'En este campo contiene la llave foranea de la entidad inmuebles\n\n\n',
  PRIMARY KEY (`idFotos`),
  INDEX `fk_Fotos_Inmuebles1_idx` (`inmuebles_idInmuebles` ASC),
  CONSTRAINT `fk_Fotos_Inmuebles1`
    FOREIGN KEY (`inmuebles_idInmuebles`)
    REFERENCES `mydb`.`inmuebles` (`idInmuebles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipoDocumentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tipoDocumentos` (
  `idTipoDocumentos` INT NOT NULL AUTO_INCREMENT COMMENT 'En este campo contiene el id que es  la llave pincipal de la entidad nivel',
  `tipoDocumento` VARCHAR(250) NOT NULL COMMENT 'En este campo almacena el nombre del nivel',
  PRIMARY KEY (`idTipoDocumentos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`documentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`documentos` (
  `idDocumentos` INT NOT NULL AUTO_INCREMENT,
  `numeroDocumento` VARCHAR(250) NOT NULL,
  `usuarios_idUsuarios` INT NOT NULL,
  `tipoDocumentos_idTipoDocumentos` INT NOT NULL,
  PRIMARY KEY (`idDocumentos`),
  INDEX `fk_tipodocumentos_usuarios1_idx` (`usuarios_idUsuarios` ASC),
  UNIQUE INDEX `numeroDocumento_UNIQUE` (`numeroDocumento` ASC),
  INDEX `fk_documentos_tipoDocumentos1_idx` (`tipoDocumentos_idTipoDocumentos` ASC),
  CONSTRAINT `fk_tipodocumentos_usuarios1`
    FOREIGN KEY (`usuarios_idUsuarios`)
    REFERENCES `mydb`.`usuarios` (`idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_documentos_tipoDocumentos1`
    FOREIGN KEY (`tipoDocumentos_idTipoDocumentos`)
    REFERENCES `mydb`.`tipoDocumentos` (`idTipoDocumentos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
