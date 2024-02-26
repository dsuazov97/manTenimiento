-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2022 a las 17:14:25
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `man|tenimiento`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pdcelular`
--

CREATE TABLE `pdcelular` (
  `codigo` varchar(10) NOT NULL,
  `marca` varchar(25) NOT NULL,
  `modelo` varchar(25) NOT NULL,
  `cantDias` int(2) NOT NULL,
  `precioBase` int(5) NOT NULL,
  `cPantalla` tinyint(1) DEFAULT NULL,
  `cBateria` tinyint(1) DEFAULT NULL,
  `cPlaca` tinyint(1) DEFAULT NULL,
  `cCamara` tinyint(1) DEFAULT NULL,
  `cImei` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pdcelular`
--

INSERT INTO `pdcelular` (`codigo`, `marca`, `modelo`, `cantDias`, `precioBase`, `cPantalla`, `cBateria`, `cPlaca`, `cCamara`, `cImei`) VALUES
('123fgh', 'Huawei', 'P40-Pro', 3, 2000, 0, 1, 0, 0, 1),
('986HDG', 'Alcatel', 'Mini', 2, 1500, 1, 0, 1, 0, 0),
('987poi', 'Apple', 'Iphone 11', 1, 3000, 0, 0, 0, 0, 1),
('ABTYF5', 'Huawei', 'P50 Pro', 5, 4000, 1, 1, 1, 1, 1),
('ILMG42', 'Samsung', 'A50', 3, 2000, 1, 1, 1, 1, 1),
('ÑLGU23', 'Lenovo', 'Ideapad510', 2, 2500, 0, 1, 1, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pdcomputador`
--

CREATE TABLE `pdcomputador` (
  `codigo` varchar(10) NOT NULL,
  `marca` varchar(25) NOT NULL,
  `modelo` varchar(25) NOT NULL,
  `cantDias` int(2) NOT NULL,
  `precioBase` int(5) NOT NULL,
  `limpieza` tinyint(1) DEFAULT NULL,
  `formateo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pdcomputador`
--

INSERT INTO `pdcomputador` (`codigo`, `marca`, `modelo`, `cantDias`, `precioBase`, `limpieza`, `formateo`) VALUES
('123ASDAS', 'Lenovo', 'Ideapad500S', 2, 2500, 1, 1),
('abcde', 'Samsung', 'SM230', 2, 2000, 1, 1),
('bcdefg', 'HP', 'HP-PAVILIONG4', 10, 2000, 1, 1),
('DAFBAS2', 'ASUS', 'S420', 2, 1500, 1, 1),
('GFHA45', 'ASUS', 'S500', 1, 1500, 1, 1),
('HDP100', 'Lenovo', 'Ideapad200', 12, 2500, 1, 0),
('PLGR67', 'Aliensware', 'GX512', 2, 5000, 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pdcelular`
--
ALTER TABLE `pdcelular`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `pdcomputador`
--
ALTER TABLE `pdcomputador`
  ADD PRIMARY KEY (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
