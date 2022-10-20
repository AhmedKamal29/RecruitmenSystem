-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2020 at 02:04 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recruitment_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE `application` (
  `ID` int(11) NOT NULL,
  `jobSeekerID` int(11) NOT NULL,
  `jobID` int(11) NOT NULL,
  `Date` varchar(10) NOT NULL,
  `status` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`ID`, `jobSeekerID`, `jobID`, `Date`, `status`) VALUES
(3, 18, 2, '1/1/2020', 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `ID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `location` text NOT NULL,
  `email` varchar(25) NOT NULL,
  `U_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`ID`, `name`, `location`, `email`, `U_ID`) VALUES
(1, 'Udemy', 'Smart village', 'Udemy@gmail.com', 35),
(2, 'Udemy', 'Smart village', 'Udemy@gmail.com', 36),
(3, 'Udemy', 'Smart village', 'Udemy@gmail.com', 37),
(4, 'Udemy', 'Smart village', 'Udemy@gmail.com', 38),
(5, 'Udemy', 'Smart village', 'Udemy@gmail.com', 39),
(6, 'Udemy', 'Smart village', 'Udemy@gmail.com', 41);

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE `job` (
  `ID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` text NOT NULL,
  `qualification` text NOT NULL,
  `publishDate` text NOT NULL,
  `C_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `job`
--

INSERT INTO `job` (`ID`, `name`, `description`, `qualification`, `publishDate`, `C_ID`) VALUES
(1, 'Software Engineer', 'Coding', 'gradate', '1/1/2020', 4),
(2, 'Software Engineer', 'Coding', 'gradate', '1/1/2020', 5),
(3, 'Software Engineer', 'Coding', 'gradate', '1/1/2020', 6);

-- --------------------------------------------------------

--
-- Table structure for table `jobseeker`
--

CREATE TABLE `jobseeker` (
  `jobSeekerID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `email` text NOT NULL,
  `education` text NOT NULL,
  `U_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jobseeker`
--

INSERT INTO `jobseeker` (`jobSeekerID`, `name`, `age`, `email`, `education`, `U_ID`) VALUES
(9, 'Adnan4', 20, 'karim@gmail.com', 'BUE', 26),
(10, 'Adnan4', 20, 'karim@gmail.com', 'BUE', 27),
(11, 'Adnan4', 20, 'karim@gmail.com', 'BUE', 28),
(12, 'Adnan4', 20, 'karim@gmail.com', 'BUE', 29),
(13, 'Adnan4', 20, 'karim@gmail.com', 'BUE', 30),
(14, 'Adnan4', 20, 'karim@gmail.com', 'BUE', 31),
(15, 'Adnan4', 20, 'karim@gmail.com', 'BUE', 32),
(16, 'Adnan4', 20, 'karim@gmail.com', 'BUE', 33),
(17, 'Adnan4', 20, 'karim@gmail.com', 'BUE', 34),
(18, 'Adnan4', 20, 'karim@gmail.com', 'BUE', 40);

-- --------------------------------------------------------

--
-- Table structure for table `jobseekerexp`
--

CREATE TABLE `jobseekerexp` (
  `numOfYears` int(11) NOT NULL,
  `CompanyName` varchar(20) NOT NULL,
  `title` varchar(20) NOT NULL,
  `skills` int(11) NOT NULL,
  `JS_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `observersubject`
--

CREATE TABLE `observersubject` (
  `ID` int(11) NOT NULL,
  `subjectID` int(11) NOT NULL,
  `observerID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `systemadministrator`
--

CREATE TABLE `systemadministrator` (
  `A_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `useraccount`
--

CREATE TABLE `useraccount` (
  `ID` int(11) NOT NULL,
  `Role` int(11) NOT NULL,
  `password` varchar(8) NOT NULL,
  `username` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `useraccount`
--

INSERT INTO `useraccount` (`ID`, `Role`, `password`, `username`) VALUES
(26, 2, 'Kodsy4', 'Abdelrahaman4'),
(27, 2, 'Kodsy4', 'Abdelrahaman4'),
(28, 2, 'Kodsy4', 'Abdelrahaman4'),
(29, 2, 'Kodsy4', 'Abdelrahaman4'),
(30, 2, 'Kodsy4', 'Abdelrahaman4'),
(31, 2, 'Kodsy4', 'Abdelrahaman4'),
(32, 2, '1234', 'Abdelrahaman4'),
(33, 2, '1234', 'Abdelrahaman4'),
(34, 2, '1234', 'Abdelrahaman4'),
(35, 1, '123456', 'Udemy1'),
(36, 1, '123456', 'Udemy1'),
(37, 1, '123456', 'Udemy1'),
(38, 1, '123456', 'Udemy1'),
(39, 1, '123456', 'Udemy1'),
(40, 2, '1234', 'Abdelrahaman4'),
(41, 1, '123456', 'Udemy1'),
(42, 1, '1234', 'karim');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `JS_ID` (`jobSeekerID`),
  ADD KEY `J_ID` (`jobID`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `U_ID` (`U_ID`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `C_ID` (`C_ID`);

--
-- Indexes for table `jobseeker`
--
ALTER TABLE `jobseeker`
  ADD PRIMARY KEY (`jobSeekerID`),
  ADD KEY `U_ID` (`U_ID`);

--
-- Indexes for table `jobseekerexp`
--
ALTER TABLE `jobseekerexp`
  ADD KEY `JS_ID` (`JS_ID`);

--
-- Indexes for table `observersubject`
--
ALTER TABLE `observersubject`
  ADD PRIMARY KEY (`ID`,`subjectID`);

--
-- Indexes for table `systemadministrator`
--
ALTER TABLE `systemadministrator`
  ADD PRIMARY KEY (`A_ID`);

--
-- Indexes for table `useraccount`
--
ALTER TABLE `useraccount`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `application`
--
ALTER TABLE `application`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `job`
--
ALTER TABLE `job`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `jobseeker`
--
ALTER TABLE `jobseeker`
  MODIFY `jobSeekerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `observersubject`
--
ALTER TABLE `observersubject`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `systemadministrator`
--
ALTER TABLE `systemadministrator`
  MODIFY `A_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `useraccount`
--
ALTER TABLE `useraccount`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `application_ibfk_1` FOREIGN KEY (`jobSeekerID`) REFERENCES `jobseeker` (`jobSeekerID`),
  ADD CONSTRAINT `application_ibfk_2` FOREIGN KEY (`jobID`) REFERENCES `job` (`ID`);

--
-- Constraints for table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `company_ibfk_1` FOREIGN KEY (`U_ID`) REFERENCES `useraccount` (`ID`);

--
-- Constraints for table `job`
--
ALTER TABLE `job`
  ADD CONSTRAINT `job_ibfk_1` FOREIGN KEY (`C_ID`) REFERENCES `company` (`ID`);

--
-- Constraints for table `jobseeker`
--
ALTER TABLE `jobseeker`
  ADD CONSTRAINT `jobseeker_ibfk_1` FOREIGN KEY (`U_ID`) REFERENCES `useraccount` (`ID`);

--
-- Constraints for table `jobseekerexp`
--
ALTER TABLE `jobseekerexp`
  ADD CONSTRAINT `jobseekerexp_ibfk_1` FOREIGN KEY (`JS_ID`) REFERENCES `jobseeker` (`jobSeekerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
