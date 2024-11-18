-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2024 a las 21:40:56
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `logisticbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `codigo_postal` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `departamento_cliente` varchar(255) NOT NULL,
  `direccion_cliente` varchar(255) NOT NULL,
  `municipio_cliente` varchar(255) NOT NULL,
  `nombre_cliente` varchar(255) NOT NULL,
  `rol` varchar(255) NOT NULL,
  `telefono` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mercancias`
--

CREATE TABLE `mercancias` (
  `iup` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_entrada` date NOT NULL,
  `fecha_salida` date DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `peso_ocupa` double NOT NULL,
  `volumen_ocupado` double NOT NULL,
  `fk_client` int(11) DEFAULT NULL,
  `fk_zona_bodega` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mercancias`
--

INSERT INTO `mercancias` (`iup`, `descripcion`, `fecha_entrada`, `fecha_salida`, `nombre`, `peso_ocupa`, `volumen_ocupado`, `fk_client`, `fk_zona_bodega`) VALUES
(1, 'Televisor 46 pulgadas', '2024-11-19', '2024-12-03', 'Televisor LG', 100, 200, NULL, NULL),
(2, 'Televisor 46 pulgadas', '2024-11-19', '2024-12-03', 'Televisor LG', 100, 200, NULL, NULL),
(5, 'x<x<x', '2024-10-29', '2024-10-30', 'Tv LG Noviembre 5', 200, 200, NULL, 1),
(6, 'TNevera UltraAhorradora', '2024-10-31', '2024-11-20', 'Nevera Haceb', 300, 100, NULL, NULL),
(7, 'lavadora 7L', '2024-10-31', '2024-11-20', 'Lavadora LG', 300, 100, NULL, 1),
(8, 'Televisor 55 pulgadas', '2024-11-14', '2024-11-27', 'Televisor Samsung', 50, 100, NULL, 1),
(10, 'Lavadora marca gatp', '2024-11-11', '2024-11-09', 'Lavadora China', 50, 100, NULL, 3),
(11, 'APPLE', '2024-11-07', '2024-11-21', 'Computador', 200, 100, NULL, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zonas_bodega`
--

CREATE TABLE `zonas_bodega` (
  `id_zona` int(11) NOT NULL,
  `nombre_zona` varchar(255) NOT NULL,
  `peso_maximo` double NOT NULL,
  `volumen_maximo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `zonas_bodega`
--

INSERT INTO `zonas_bodega` (`id_zona`, `nombre_zona`, `peso_maximo`, `volumen_maximo`) VALUES
(1, 'Zona Amarilla', 7000, 0),
(2, 'Zona C', 5000, 0),
(3, 'Zona D', 6000, 0),
(4, 'Zona k', 9000, 0),
(5, 'Zona B', 5000, 0),
(6, 'Zona k', 9000, 7000),
(7, 'Zona Q', 5000, 4000),
(8, 'Zona A', 4000, 5000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `mercancias`
--
ALTER TABLE `mercancias`
  ADD PRIMARY KEY (`iup`),
  ADD KEY `FK52e8csb7ibhiw7316mebfyktb` (`fk_client`),
  ADD KEY `FKgebrul8xn1vraubyw6g03ryno` (`fk_zona_bodega`);

--
-- Indices de la tabla `zonas_bodega`
--
ALTER TABLE `zonas_bodega`
  ADD PRIMARY KEY (`id_zona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mercancias`
--
ALTER TABLE `mercancias`
  MODIFY `iup` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `zonas_bodega`
--
ALTER TABLE `zonas_bodega`
  MODIFY `id_zona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mercancias`
--
ALTER TABLE `mercancias`
  ADD CONSTRAINT `FK52e8csb7ibhiw7316mebfyktb` FOREIGN KEY (`fk_client`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `FKgebrul8xn1vraubyw6g03ryno` FOREIGN KEY (`fk_zona_bodega`) REFERENCES `zonas_bodega` (`id_zona`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
