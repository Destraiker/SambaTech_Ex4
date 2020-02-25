-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 25-Fev-2020 às 03:22
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `samba_tech_4`
--
CREATE DATABASE IF NOT EXISTS `samba_tech_4` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `samba_tech_4`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `midias`
--

CREATE TABLE `midias` (
  `Id` int(7) UNSIGNED NOT NULL,
  `Nome` varchar(512) NOT NULL,
  `URL` varchar(512) DEFAULT NULL,
  `Duracao` int(7) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `midias`
--

INSERT INTO `midias` (`Id`, `Nome`, `URL`, `Duracao`) VALUES
(1, 'Brener Eduardo Rodrigues', 'http://localhost:8080/SambaTech_Ex4/', 565655),
(2, 'Dirceu Rodrigues de Almeida', 'https://www.youtube.com/', 121545),
(3, 'Joana D\'arc da Silva Rodrigues', 'https://aluno.unibh.br/SOL/aluno/index.php/index/seguranca/dev/instituicao/1', 654715),
(4, 'Gabrielly Lopes da Silva Rodrigues', 'https://www.wattpad.com/', 41),
(5, 'Lourdes Alvenas Lopes', 'https://www.devmedia.com.br/', 64);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `midias`
--
ALTER TABLE `midias`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `midias`
--
ALTER TABLE `midias`
  MODIFY `Id` int(7) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
