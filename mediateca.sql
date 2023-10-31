CREATE DATABASE mediateca;
USE mediateca;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2023 a las 06:23:53
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mediateca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_material`
--

CREATE TABLE `categoria_material` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria_material`
--

INSERT INTO `categoria_material` (`id`, `nombre`) VALUES
(1, 'Material escrito'),
(2, 'Material audiovisual');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `creador`
--

CREATE TABLE `creador` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipo_creador_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `creador`
--

INSERT INTO `creador` (`id`, `nombre`, `tipo_creador_id`) VALUES
(1, 'Alan Smith', 1),
(2, 'Laura Johnson', 1),
(3, 'Carlos Rodríguez', 1),
(4, 'Maria López', 1),
(5, 'Juan Martínez', 1),
(6, 'Isabel Pérez', 1),
(7, 'The Electric Rhythms', 2),
(8, 'Philharmonia Orchestra', 2),
(9, 'Aria Star', 2),
(10, 'Smooth Jazz Ensemble', 2),
(11, 'John Director', 3),
(12, 'Jane Directora', 3),
(13, 'David Director', 3),
(14, 'Maria Directora', 3),
(16, 'asdddd', 1),
(18, 'test', 1),
(19, 'juan', 1),
(22, 'Nuevo artista', 2),
(23, 'Nuevo director', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editorial`
--

CREATE TABLE `editorial` (
  `id` int(11) NOT NULL,
  `editorial` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `editorial`
--

INSERT INTO `editorial` (`id`, `editorial`) VALUES
(1, 'testaaaaa'),
(2, 'Arco Muralla'),
(3, 'Santillana'),
(4, 'TechPublishers'),
(5, 'EconoBooks'),
(6, 'ArtPress'),
(7, 'Literature House'),
(8, 'Literature House'),
(9, 'Classic Novels Inc.'),
(16, 'test'),
(20, 'asd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `id` int(11) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `tipo_genero_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`id`, `genero`, `tipo_genero_id`) VALUES
(1, 'Rock', 1),
(2, 'Clásica', 1),
(3, 'Pop', 1),
(4, 'Jazz', 1),
(5, 'Acción', 2),
(6, 'Comedia Romántica', 2),
(7, 'Ciencia Ficción', 2),
(8, 'Documental', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `codigo` varchar(10) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `creador_id` int(11) DEFAULT NULL,
  `numero_paginas` int(11) DEFAULT NULL,
  `isbn` char(18) DEFAULT NULL,
  `periodicidad_id` int(11) DEFAULT NULL,
  `anio_publicacion` year(4) DEFAULT NULL,
  `fecha_publicacion` date DEFAULT NULL,
  `genero_id` int(11) DEFAULT NULL,
  `duracion` varchar(10) DEFAULT NULL,
  `numero_canciones` int(11) DEFAULT NULL,
  `unidades` int(11) DEFAULT NULL,
  `tipo_material_id` int(11) DEFAULT NULL,
  `editorial_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`codigo`, `titulo`, `creador_id`, `numero_paginas`, `isbn`, `periodicidad_id`, `anio_publicacion`, `fecha_publicacion`, `genero_id`, `duracion`, `numero_canciones`, `unidades`, `tipo_material_id`, `editorial_id`) VALUES
('CDA00001', 'Álbum de Rock', 7, NULL, NULL, NULL, NULL, NULL, 1, '45:32', 12, 50, 3, NULL),
('CDA00002', 'Musica clasica', 8, NULL, NULL, NULL, NULL, NULL, 2, '60:15', 10, 30, 3, NULL),
('CDA00003', 'Exitos de Pop', 9, NULL, NULL, NULL, NULL, NULL, 3, '55:50', 15, 40, 3, NULL),
('CDA00005', 'Mi nuevo cd', 9, NULL, NULL, NULL, NULL, NULL, 2, '02:30', 12, 23, 3, NULL),
('CDA00006', 'Mi nuevo cd con nuevo artista', 22, NULL, NULL, NULL, NULL, NULL, 2, '45:50', 12, 30, 3, NULL),
('DVD00005', 'El Último Desafío', 11, NULL, NULL, NULL, NULL, NULL, 5, '10:23:11', NULL, NULL, 4, NULL),
('DVD00007', 'Los Viajeros del Tiempo', 13, NULL, NULL, NULL, NULL, NULL, 7, '01:03:00', NULL, NULL, 4, NULL),
('DVD00008', 'El Camino de la Historia', 14, NULL, NULL, NULL, NULL, NULL, 8, '03:23:11', NULL, NULL, 4, NULL),
('LIB00001', 'El Arte de la Programación', 1, 500, '273-2-1897-31783-6', NULL, '2020', NULL, NULL, NULL, NULL, 100, 1, 4),
('LIB00002', 'Introducción a la Economía', 2, 350, '485-4-8375-27356-2', NULL, '2019', NULL, NULL, NULL, NULL, 80, 1, 5),
('LIB00003', 'Historia del Arte', 3, 400, '385-4-8375-89762-1', NULL, '2018', NULL, NULL, NULL, NULL, 75, 1, 3),
('LIB00004', 'Ciencia de Datos con Python', 4, 601, '323-4-8075-89762-9', NULL, '2021', NULL, NULL, NULL, NULL, 120, 1, 4),
('LIB00005', 'La Metamorfosis', 5, 200, '323-4-8075-12345-4', NULL, '1915', NULL, NULL, NULL, NULL, 30, 1, 2),
('LIB00006', 'El Gran Gatsby', 2, 320, '123-4-8075-12345-4', NULL, '1925', NULL, NULL, NULL, NULL, 45, 1, 1),
('REV00257', 'Revista de Cienciaa', NULL, NULL, NULL, 4, NULL, '2023-01-09', NULL, NULL, NULL, 500, 2, 5),
('REV00258', 'Salud y Bienestar', NULL, NULL, NULL, 3, NULL, '2023-04-05', NULL, NULL, NULL, 250, 2, 3),
('REV62351', 'Tecnología Avanzada', NULL, NULL, NULL, 2, NULL, '2023-02-20', NULL, NULL, NULL, 300, 2, 2),
('REV62352', 'Mi primera revistaa', NULL, NULL, NULL, 3, NULL, '2023-10-17', NULL, NULL, NULL, 30, 2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodicidad`
--

CREATE TABLE `periodicidad` (
  `id` int(11) NOT NULL,
  `periodicidad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `periodicidad`
--

INSERT INTO `periodicidad` (`id`, `periodicidad`) VALUES
(1, 'Mensual'),
(2, 'Bimensual'),
(3, 'Trimestral'),
(4, 'Semestral'),
(5, 'Anual'),
(6, 'Semanal'),
(7, 'Quincenal'),
(8, 'Irregular');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_creador`
--

CREATE TABLE `tipo_creador` (
  `id` int(11) NOT NULL,
  `tipo_creador` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_creador`
--

INSERT INTO `tipo_creador` (`id`, `tipo_creador`) VALUES
(1, 'Autor'),
(2, 'Artista'),
(3, 'Director');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_genero`
--

CREATE TABLE `tipo_genero` (
  `id` int(11) NOT NULL,
  `tipo_genero` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_genero`
--

INSERT INTO `tipo_genero` (`id`, `tipo_genero`) VALUES
(1, 'Musical'),
(2, 'Cine');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_material`
--

CREATE TABLE `tipo_material` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `categoria_material_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_material`
--

INSERT INTO `tipo_material` (`id`, `nombre`, `categoria_material_id`) VALUES
(1, 'Libro', 1),
(2, 'Revista', 1),
(3, 'CD', 2),
(4, 'DVD', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria_material`
--
ALTER TABLE `categoria_material`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `creador`
--
ALTER TABLE `creador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipo_creador_fk` (`tipo_creador_id`);

--
-- Indices de la tabla `editorial`
--
ALTER TABLE `editorial`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipo_genero_fk` (`tipo_genero_id`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `creador_fk` (`creador_id`),
  ADD KEY `periodicidad_fk` (`periodicidad_id`),
  ADD KEY `genero_fk` (`genero_id`),
  ADD KEY `tipo_material_fk` (`tipo_material_id`),
  ADD KEY `editorial_id` (`editorial_id`);

--
-- Indices de la tabla `periodicidad`
--
ALTER TABLE `periodicidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_creador`
--
ALTER TABLE `tipo_creador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_genero`
--
ALTER TABLE `tipo_genero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_material`
--
ALTER TABLE `tipo_material`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoria_material_fk` (`categoria_material_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria_material`
--
ALTER TABLE `categoria_material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `creador`
--
ALTER TABLE `creador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `editorial`
--
ALTER TABLE `editorial`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `periodicidad`
--
ALTER TABLE `periodicidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tipo_creador`
--
ALTER TABLE `tipo_creador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_genero`
--
ALTER TABLE `tipo_genero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_material`
--
ALTER TABLE `tipo_material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `creador`
--
ALTER TABLE `creador`
  ADD CONSTRAINT `tipo_creador_fk` FOREIGN KEY (`tipo_creador_id`) REFERENCES `tipo_creador` (`id`);

--
-- Filtros para la tabla `genero`
--
ALTER TABLE `genero`
  ADD CONSTRAINT `tipo_genero_fk` FOREIGN KEY (`tipo_genero_id`) REFERENCES `tipo_genero` (`id`);

--
-- Filtros para la tabla `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `creador_fk` FOREIGN KEY (`creador_id`) REFERENCES `creador` (`id`),
  ADD CONSTRAINT `genero_fk` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`id`),
  ADD CONSTRAINT `material_ibfk_1` FOREIGN KEY (`editorial_id`) REFERENCES `editorial` (`id`),
  ADD CONSTRAINT `periodicidad_fk` FOREIGN KEY (`periodicidad_id`) REFERENCES `periodicidad` (`id`),
  ADD CONSTRAINT `tipo_material_fk` FOREIGN KEY (`tipo_material_id`) REFERENCES `tipo_material` (`id`);

--
-- Filtros para la tabla `tipo_material`
--
ALTER TABLE `tipo_material`
  ADD CONSTRAINT `categoria_material_fk` FOREIGN KEY (`categoria_material_id`) REFERENCES `categoria_material` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
