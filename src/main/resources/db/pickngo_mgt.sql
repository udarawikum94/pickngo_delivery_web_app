-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.27 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for pickngo_mgt
CREATE DATABASE IF NOT EXISTS `pickngo_mgt` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pickngo_mgt`;

-- Dumping structure for table pickngo_mgt.charges_template
CREATE TABLE IF NOT EXISTS `charges_template` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(5) DEFAULT NULL,
  `From_weight` decimal(38,2) DEFAULT NULL,
  `to_weight` decimal(38,2) DEFAULT NULL,
  `size` varchar(200) DEFAULT NULL,
  `distance` decimal(38,2) DEFAULT NULL,
  `charge_amount` decimal(38,2) DEFAULT NULL,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.charges_template: 0 rows
/*!40000 ALTER TABLE `charges_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `charges_template` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.collection_details
CREATE TABLE IF NOT EXISTS `collection_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `weight` varchar(200) DEFAULT NULL,
  `is_collected` tinyint(1) DEFAULT NULL,
  `item_type` varchar(200) DEFAULT NULL,
  `item_name` varchar(200) DEFAULT NULL,
  `order_image` longblob,
  `size` varchar(200) DEFAULT NULL,
  `calculated_charge_amount` decimal(38,2) DEFAULT NULL,
  `request_no` varchar(255) DEFAULT NULL,
  `tracking_no` varchar(255) DEFAULT NULL,
  `customer_request_id` decimal(38,0) DEFAULT NULL,
  `from_location` varchar(200) DEFAULT NULL,
  `to_location` varchar(200) DEFAULT NULL,
  `reciever id` decimal(38,0) DEFAULT NULL,
  `has_Inter_branch_Transfer` tinyint(1) DEFAULT NULL,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.collection_details: 0 rows
/*!40000 ALTER TABLE `collection_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `collection_details` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `code` varchar(5) DEFAULT NULL,
  `adress` varchar(200) DEFAULT NULL,
  `nicbr_no` varchar(20) DEFAULT NULL,
  `email_adress` varchar(200) DEFAULT NULL,
  `created_user` varchar(255) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `contact_no` varchar(40) DEFAULT NULL,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.customer: 0 rows
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.customer_request
CREATE TABLE IF NOT EXISTS `customer_request` (
  `id` int NOT NULL AUTO_INCREMENT,
  `request_no` varchar(200) DEFAULT NULL,
  `tracking no` varchar(200) DEFAULT NULL,
  `iteam_description` varchar(255) DEFAULT NULL,
  `nearest_op_center` decimal(38,0) DEFAULT NULL,
  `pickup_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estimated_distance` decimal(38,2) DEFAULT NULL,
  `calculated_charge_amount` decimal(38,2) DEFAULT NULL,
  `fetching_op_center` varchar(200) DEFAULT NULL,
  `is_immmediate_delivery` tinyint(1) DEFAULT NULL,
  `customer_id` decimal(38,0) DEFAULT NULL,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.customer_request: 0 rows
/*!40000 ALTER TABLE `customer_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_request` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.districs
CREATE TABLE IF NOT EXISTS `districs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `code` varchar(5) DEFAULT NULL,
  `created_user` varchar(255) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.districs: 0 rows
/*!40000 ALTER TABLE `districs` DISABLE KEYS */;
INSERT INTO `districs` (`id`, `name`, `code`, `created_user`, `created_date`, `modified_user`, `modified_date`, `status`, `version`) VALUES
	(1, 'Anuradhapura', 'D001', 'Udara Wikum', '2022-02-20 10:54:35', NULL, '2022-02-20 10:54:35', 'ACTIVE', 0);
/*!40000 ALTER TABLE `districs` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.driver
CREATE TABLE IF NOT EXISTS `driver` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(5) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `nic` varchar(200) DEFAULT NULL,
  `operation_center_id` decimal(38,0) DEFAULT NULL,
  `contract_no` varchar(40) DEFAULT NULL,
  `email_adrress` varchar(200) DEFAULT NULL,
  `driving_license_no` varchar(200) DEFAULT NULL,
  `license_exp_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `password` varchar(200) DEFAULT NULL,
  `user_name` varchar(200) DEFAULT NULL,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.driver: 0 rows
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.officer
CREATE TABLE IF NOT EXISTS `officer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(5) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `nic` varchar(200) DEFAULT NULL,
  `operational_center_id` decimal(38,0) DEFAULT NULL,
  `contract_no` decimal(38,0) DEFAULT NULL,
  `email_address` varchar(200) DEFAULT NULL,
  `passwoard` varchar(200) DEFAULT NULL,
  `access_group` varchar(50) DEFAULT NULL,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.officer: 0 rows
/*!40000 ALTER TABLE `officer` DISABLE KEYS */;
INSERT INTO `officer` (`id`, `code`, `name`, `address`, `nic`, `operational_center_id`, `contract_no`, `email_address`, `passwoard`, `access_group`, `modified_user`, `modified_date`, `status`, `version`, `created_user`, `created_date`) VALUES
	(1, 'ADMN', 'Udara Wikum', 'Anuradhapura', '943180873V', 1, 763517943, 'udara.wikum@gmail.com', 'asdf@1234', 'Adminitration', NULL, '2022-02-20 10:53:36', 'ACTIVE', 0, 'Udara Liyanage', '2022-02-20 10:53:36'),
	(2, 'CONT', 'David Warner', 'Anuradhapura', '953160687V', 1, 753517943, 'davidw@gmail.com', 'abcd@1234', 'Contact Person', NULL, '2022-02-20 10:53:44', 'ACTIVE', 0, 'Udara Liyanage', '2022-02-20 10:53:44');
/*!40000 ALTER TABLE `officer` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.operational_center
CREATE TABLE IF NOT EXISTS `operational_center` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `adress` varchar(200) DEFAULT NULL,
  `code` varchar(5) DEFAULT NULL,
  `contact_no` varchar(40) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `fax_no` decimal(38,0) DEFAULT NULL,
  `contract_person_id` decimal(38,0) DEFAULT NULL,
  `district_id` decimal(38,0) DEFAULT NULL,
  `stutas` varchar(10) DEFAULT NULL,
  `created_user` varchar(255) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.operational_center: 0 rows
/*!40000 ALTER TABLE `operational_center` DISABLE KEYS */;
INSERT INTO `operational_center` (`id`, `name`, `adress`, `code`, `contact_no`, `description`, `fax_no`, `contract_person_id`, `district_id`, `stutas`, `created_user`, `created_date`, `modified_user`, `modified_date`, `version`) VALUES
	(1, 'Anuradhapura HO', 'D. S. Senanayake Mawatha, Anuradhapura', 'PN01', '0254567895', 'Anuradhapura Head Office', 254567894, 2, 1, 'ACTIVE', 'Udara Wikum', '2022-02-20 10:48:59', NULL, '2022-02-20 10:50:33', 0);
/*!40000 ALTER TABLE `operational_center` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.order_processing
CREATE TABLE IF NOT EXISTS `order_processing` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deliver_type` varchar(200) DEFAULT NULL,
  `deliver_addres` varchar(200) DEFAULT NULL,
  `sequence` decimal(38,0) DEFAULT NULL,
  `order_status` varchar(200) DEFAULT NULL,
  `customor_id` decimal(38,0) DEFAULT NULL,
  `operation_center_id` decimal(38,0) DEFAULT NULL,
  `Driver_vehicle_mapping_id` decimal(38,0) DEFAULT NULL,
  `tracking no` varchar(200) DEFAULT NULL,
  `is_customer_signed_off` varchar(200) DEFAULT NULL,
  `schedule_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `comments` varchar(200) DEFAULT NULL,
  `collection_deatiles_id` decimal(38,0) DEFAULT NULL,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.order_processing: 0 rows
/*!40000 ALTER TABLE `order_processing` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_processing` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.order_tracking
CREATE TABLE IF NOT EXISTS `order_tracking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tracking_no` varchar(200) DEFAULT NULL,
  `tracking_status` varchar(200) DEFAULT NULL,
  `tracking_type` varchar(200) DEFAULT NULL,
  `task_completed_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estimated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.order_tracking: 0 rows
/*!40000 ALTER TABLE `order_tracking` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_tracking` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.rating and review
CREATE TABLE IF NOT EXISTS `rating and review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rating score` decimal(38,0) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.rating and review: 0 rows
/*!40000 ALTER TABLE `rating and review` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating and review` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.reciever
CREATE TABLE IF NOT EXISTS `reciever` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `contract_no_1` varchar(40) DEFAULT NULL,
  `contract_no_2` varchar(40) DEFAULT NULL,
  `collection_deatels_id` decimal(38,0) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.reciever: 0 rows
/*!40000 ALTER TABLE `reciever` DISABLE KEYS */;
/*!40000 ALTER TABLE `reciever` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.tracking_no_generator
CREATE TABLE IF NOT EXISTS `tracking_no_generator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sequence` decimal(38,0) DEFAULT NULL,
  `operation_center_id` decimal(38,0) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.tracking_no_generator: 0 rows
/*!40000 ALTER TABLE `tracking_no_generator` DISABLE KEYS */;
/*!40000 ALTER TABLE `tracking_no_generator` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.transaction
CREATE TABLE IF NOT EXISTS `transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `request_no` varchar(200) DEFAULT NULL,
  `charge_amount` decimal(38,2) DEFAULT NULL,
  `transaction_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reciept_no` varchar(200) DEFAULT NULL,
  `collection_detail_id` decimal(38,0) DEFAULT NULL,
  `charge_template_id` varchar(200) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.transaction: 0 rows
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(200) DEFAULT NULL,
  `user_roles` varchar(200) DEFAULT NULL,
  `code` varchar(5) DEFAULT NULL,
  `ui_name` varchar(200) DEFAULT NULL,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.user_role: 0 rows
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.vehicle
CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `vehicle_make` varchar(200) DEFAULT NULL,
  `vehicle_modle` varchar(200) DEFAULT NULL,
  `code` varchar(5) DEFAULT NULL,
  `vehicle` decimal(38,0) DEFAULT NULL,
  `location_id` varchar(200) DEFAULT NULL,
  `quantity` varchar(200) DEFAULT NULL,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.vehicle: 0 rows
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;

-- Dumping structure for table pickngo_mgt.vehicle_driver_mapping
CREATE TABLE IF NOT EXISTS `vehicle_driver_mapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Vehicle_id` decimal(38,0) DEFAULT NULL,
  `driver id` decimal(38,0) DEFAULT NULL,
  `modified_user` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  `version` decimal(38,0) DEFAULT NULL,
  `created_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table pickngo_mgt.vehicle_driver_mapping: 0 rows
/*!40000 ALTER TABLE `vehicle_driver_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_driver_mapping` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;