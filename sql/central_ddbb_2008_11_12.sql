/*
SQLyog Community Edition- MySQL GUI v7.11 
MySQL - 6.0.6-alpha-community : Database - hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `hotel`;

/*Table structure for table `ctrlm_source_type` */

DROP TABLE IF EXISTS `ctrlm_source_type`;

CREATE TABLE `ctrlm_source_type` (
  `srctp_id_source_type` smallint(2) unsigned NOT NULL AUTO_INCREMENT,
  `srctc_description` varchar(15) DEFAULT NULL,
  `srctc_abbreviation` varchar(6) DEFAULT NULL,
  `srctc_made_by` char(3) DEFAULT NULL,
  `srctc_made_on` date DEFAULT NULL,
  `srctc_updated_by` char(3) DEFAULT NULL,
  `srctc_last_updated` date DEFAULT NULL,
  PRIMARY KEY (`srctp_id_source_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlm_source_type` */

insert  into `ctrlm_source_type`(`srctp_id_source_type`,`srctc_description`,`srctc_abbreviation`,`srctc_made_by`,`srctc_made_on`,`srctc_updated_by`,`srctc_last_updated`) values (1,'GOVERMENT','GOVERM','JO','2008-11-12','JO','2008-11-12'),(2,'COMPANY','COMPNY','JO','2008-11-12','JO','2008-11-12'),(3,'ONG','ONG','JO','2008-11-12','JO','2008-11-12'),(4,'TRAVEL AGENCY','AGENCY','JO','2008-11-12','JO','2008-11-12');

/*Table structure for table `ctrlt_app_table` */

DROP TABLE IF EXISTS `ctrlt_app_table`;

CREATE TABLE `ctrlt_app_table` (
  `APPMC_ID_MODULE` smallint(2) unsigned DEFAULT NULL,
  `APPMC_ID_TABLE` smallint(2) unsigned DEFAULT NULL,
  `APPMC_TABLE_DESCRIPTION` char(20) DEFAULT NULL,
  `APPMC_STATUS` char(1) DEFAULT 'A'
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlt_app_table` */

insert  into `ctrlt_app_table`(`APPMC_ID_MODULE`,`APPMC_ID_TABLE`,`APPMC_TABLE_DESCRIPTION`,`APPMC_STATUS`) values (1,1,'Document Types','A'),(1,2,'Query Reservations','A'),(1,5,'Segments','A'),(1,6,'Segment classes','A'),(1,3,'Titles','A'),(1,4,'VipSatus','A');

/*Table structure for table `ctrlt_city` */

DROP TABLE IF EXISTS `ctrlt_city`;

CREATE TABLE `ctrlt_city` (
  `CITYP_ID_CITY` smallint(2) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `CTRYP_ID_COUNTRY` smallint(3) unsigned NOT NULL,
  `CITYC_CITY_NAME` varchar(30) DEFAULT NULL,
  `CITYC_ABBREVIATION` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CITYP_ID_CITY`,`CTRYP_ID_COUNTRY`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlt_city` */

insert  into `ctrlt_city`(`CITYP_ID_CITY`,`CTRYP_ID_COUNTRY`,`CITYC_CITY_NAME`,`CITYC_ABBREVIATION`) values (01,1,'LIMA','LIMA');

/*Table structure for table `ctrlt_country` */

DROP TABLE IF EXISTS `ctrlt_country`;

CREATE TABLE `ctrlt_country` (
  `CTRYP_ID_COUNTRY` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `CTRYC_COUNTRY_NAME` char(20) DEFAULT NULL,
  `CTRYC_ABBREVIATION` char(6) DEFAULT NULL,
  `CTRYC_NATIONALITY` char(20) DEFAULT NULL,
  PRIMARY KEY (`CTRYP_ID_COUNTRY`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='InnoDB free: 4096 k';

/*Data for the table `ctrlt_country` */

insert  into `ctrlt_country`(`CTRYP_ID_COUNTRY`,`CTRYC_COUNTRY_NAME`,`CTRYC_ABBREVIATION`,`CTRYC_NATIONALITY`) values (1,'PERU','PERU','PERUVIAN'),(2,'BRASIL','BRASIL','BRASILIAN'),(3,'SPAIN','SPAIN','SPANISH'),(4,'UNITED STATES (USA)','USA','AMERICAN'),(5,'CHILE','CHILE','CHILEAN');

/*Table structure for table `ctrlt_customer` */

DROP TABLE IF EXISTS `ctrlt_customer`;

CREATE TABLE `ctrlt_customer` (
  `CUSTP_ID_CUSTOMER` int(6) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Customer code. Assign by System',
  `CUSTC_LASTNAME1` varchar(15) NOT NULL,
  `CUSTC_LASTNAME2` varchar(15) DEFAULT NULL,
  `CUSTC_FIRSTNAME` varchar(15) NOT NULL,
  `CUSTC_BIRTHDATE` date DEFAULT NULL,
  `CUSTC_NATIONALITY` smallint(3) unsigned NOT NULL,
  `CUSTC_TITLE` smallint(2) DEFAULT NULL,
  `CUSTF_DOCUMENT_TYPE` smallint(2) unsigned NOT NULL,
  `CUSTC_DOCUMENT_NUMBER` varchar(12) NOT NULL COMMENT 'Document of Identification',
  `CUSTC_STREET_TYPE` smallint(2) NOT NULL,
  `CUSTC_STREET_NAME` varchar(30) NOT NULL,
  `CUSTC_STREET_NUMBER` smallint(4) NOT NULL,
  `CUSTC_INTERIOR_NUMBER` varchar(4) DEFAULT NULL,
  `CUSTC_COMPLEMENTS` varchar(20) DEFAULT NULL,
  `CUSTC_DISTRICT` varchar(15) DEFAULT NULL,
  `CUSTC_CITY` varchar(15) DEFAULT NULL,
  `CTRYF_ID_COUNTRY` smallint(3) unsigned NOT NULL,
  `CUSTC_ZIPCODE` varchar(10) DEFAULT NULL,
  `CUSTC_PHONE1` int(7) unsigned NOT NULL,
  `CUSTC_PHONE2` int(7) unsigned DEFAULT NULL,
  `CUSTC_MOVIL_PHONE` int(9) unsigned DEFAULT NULL,
  `CUSTC_EMAIL` varchar(50) DEFAULT NULL,
  `CUSTC_OCCUPATION` varchar(20) DEFAULT NULL,
  `CUSTC_VIP_STATUS` char(1) DEFAULT '2',
  `CUSTC_SPECIAL_REQUESTS` tinytext,
  `CUSTC_REGISTRATION_HOTEL` smallint(2) unsigned NOT NULL,
  `CUSTC_MADE_BY` char(3) NOT NULL,
  `CUSTC_MADE_ON` date NOT NULL,
  `CUSTC_UPDATED_BY` char(3) DEFAULT NULL,
  `CUSTC_LAST_UPDATE` date DEFAULT NULL,
  `CUSTC_STATUS` char(1) DEFAULT 'P',
  PRIMARY KEY (`CUSTP_ID_CUSTOMER`),
  UNIQUE KEY `idx_documentNumber` (`CUSTC_DOCUMENT_NUMBER`,`CUSTF_DOCUMENT_TYPE`),
  KEY `idx_lastName` (`CUSTC_LASTNAME1`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1 AVG_ROW_LENGTH=159 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=FIXED;

/*Data for the table `ctrlt_customer` */

insert  into `ctrlt_customer`(`CUSTP_ID_CUSTOMER`,`CUSTC_LASTNAME1`,`CUSTC_LASTNAME2`,`CUSTC_FIRSTNAME`,`CUSTC_BIRTHDATE`,`CUSTC_NATIONALITY`,`CUSTC_TITLE`,`CUSTF_DOCUMENT_TYPE`,`CUSTC_DOCUMENT_NUMBER`,`CUSTC_STREET_TYPE`,`CUSTC_STREET_NAME`,`CUSTC_STREET_NUMBER`,`CUSTC_INTERIOR_NUMBER`,`CUSTC_COMPLEMENTS`,`CUSTC_DISTRICT`,`CUSTC_CITY`,`CTRYF_ID_COUNTRY`,`CUSTC_ZIPCODE`,`CUSTC_PHONE1`,`CUSTC_PHONE2`,`CUSTC_MOVIL_PHONE`,`CUSTC_EMAIL`,`CUSTC_OCCUPATION`,`CUSTC_VIP_STATUS`,`CUSTC_SPECIAL_REQUESTS`,`CUSTC_REGISTRATION_HOTEL`,`CUSTC_MADE_BY`,`CUSTC_MADE_ON`,`CUSTC_UPDATED_BY`,`CUSTC_LAST_UPDATE`,`CUSTC_STATUS`) values (1,'PEREZ','','',NULL,1,0,1,'05875942',1,'Lima 33',135,NULL,NULL,'La Molina','LIMA',1,NULL,3655284,3658745,998455628,NULL,'1','2','',1,'999','0000-00-00',NULL,'2008-11-03','A'),(2,'ABDEL HAMID','','HALIMA M.','0000-00-00',1,4,2,'21525328',0,'',0,NULL,NULL,'SURCO','LIMA',1,'L33',2501163,98692569,NULL,'receptivo@invertur.com.pe','SALES','2','SECOND FLOOR',1,'999','0000-00-00',NULL,NULL,'P'),(3,'ZAPATA','','JORGE LUIS','1971-08-12',3,1,2,'12345678',0,'',0,NULL,NULL,'SAN ISIDRO','LIMA',1,'',0,0,NULL,'jzapata@yahoo.es','PROGRAMMER','1','VEGETARIAN',1,'999','0000-00-00',NULL,NULL,''),(4,'OLIVAS','','YAMILLE',NULL,1,0,1,'87654321',0,'',0,NULL,NULL,'','LIMA',1,NULL,2501163,98692569,NULL,'receptivo@invertur.com.pe',NULL,NULL,'TESTING INSERT\r\n                \r\n                ',1,'0','0000-00-00',NULL,NULL,'P'),(5,'SARMIENTO','','NANCY',NULL,1,1,3,'12365478',2,'',0,NULL,NULL,'','LIMA',1,'',2501163,98692569,0,'receptivo@invertur.com.pe','','1','',1,'0','0000-00-00',NULL,'2008-11-08','P'),(6,'LOZANO','','MILAGROS',NULL,1,0,1,'11223344',0,'',0,NULL,NULL,'','KJHKJHJKHJ',1,NULL,0,0,NULL,'KJHKJHJKHJKH',NULL,NULL,'                KJHKJHKJH',1,'0','0000-00-00',NULL,NULL,'P'),(7,'OLIVAS','','ALEJANDRO',NULL,1,0,1,'44332211',0,'',0,NULL,NULL,'','LIMA',1,NULL,2501163,98692569,NULL,'jolivas@viabcp.com.pe',NULL,NULL,'TESTING\r\n                \r\n                ',1,'0','0000-00-00',NULL,NULL,'P'),(8,'OLIVAS','','JOHNNY',NULL,1,0,1,'11221122',0,'',0,NULL,NULL,'','LIMA',1,NULL,2501163,98692569,NULL,'jolivas@viabcp.com.pe',NULL,NULL,'TESTING\r\n                \r\n                \r\n                ',1,'0','0000-00-00',NULL,NULL,'*'),(9,'BAZAN','','DAVID',NULL,1,0,1,'2244668',0,'',0,NULL,NULL,'','LIMA',1,NULL,2501163,98692569,NULL,'receptivo@invertur.com.pe',NULL,NULL,'TESTING INSERT\r\n                \r\n                ',1,'0','0000-00-00',NULL,NULL,'P'),(10,'CASTRO','','ESTEBAN',NULL,1,0,1,'88888888',0,'',0,NULL,NULL,'','LIMA',1,NULL,2501163,98692569,NULL,'receptivo@invertur.com.pe',NULL,NULL,'TESTING INSERT\r\n                \r\n                \r\n                ',1,'0','0000-00-00',NULL,NULL,'P'),(11,'PEREZ','','JOSE','0000-00-00',0,0,1,'99999999',1,'',0,NULL,'','','',1,'',2427799,3659988,998565486,'algo@dominio.com','','','',1,'0','0000-00-00',NULL,'2008-11-09',''),(12,'ALCORTA','','MARIA',NULL,1,0,1,'13141516',0,'',0,NULL,NULL,'','',1,NULL,0,0,NULL,'',NULL,NULL,'                ',1,'0','0000-00-00',NULL,NULL,'P'),(26,'PEREZ TREVIÑO','FERNANDEZ','JUAN ESTEBAN',NULL,2,1,1,'77777777',2,'LA FLORESTA',1031,'506',NULL,'SURCO','LIMA',2,'LIMA 33',2427799,3659988,998565486,'algo@dominio.com','','1','atenciones especiales',1,'JO.','2008-11-04',NULL,'2008-11-10','');

/*Table structure for table `ctrlt_district` */

DROP TABLE IF EXISTS `ctrlt_district`;

CREATE TABLE `ctrlt_district` (
  `CTRYP_ID_COUNTRY` tinyint(3) unsigned NOT NULL,
  `CITYP_ID_CITY` tinyint(2) unsigned NOT NULL,
  `DISTP_ID_DISTRICT` tinyint(2) unsigned NOT NULL,
  `DISTC_DISTRICT_NAME` varchar(30) DEFAULT NULL,
  `DISTC_ZIPCODE` char(5) DEFAULT NULL,
  `DISTC_STATUS` char(1) DEFAULT 'A',
  PRIMARY KEY (`CTRYP_ID_COUNTRY`,`CITYP_ID_CITY`,`DISTP_ID_DISTRICT`),
  UNIQUE KEY `nDistrictId` (`DISTP_ID_DISTRICT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlt_district` */

insert  into `ctrlt_district`(`CTRYP_ID_COUNTRY`,`CITYP_ID_CITY`,`DISTP_ID_DISTRICT`,`DISTC_DISTRICT_NAME`,`DISTC_ZIPCODE`,`DISTC_STATUS`) values (1,1,1,'SAN ISIDRO','L28','1'),(1,1,2,'MIRAFLORES','L32','1'),(1,1,3,'SANTIAGO DE SURCO','L28','1');

/*Table structure for table `ctrlt_guest` */

DROP TABLE IF EXISTS `ctrlt_guest`;

CREATE TABLE `ctrlt_guest` (
  `MAINP_ID_HOTEL` tinyint(1) unsigned NOT NULL,
  `RESVP_ID_RESERVATION` int(5) unsigned NOT NULL,
  `CUSTP_ID_CUSTOMER` int(5) unsigned NOT NULL COMMENT 'valor invariable en el tiempo',
  `GUESC_STATUS` char(1) DEFAULT 'P',
  PRIMARY KEY (`MAINP_ID_HOTEL`,`RESVP_ID_RESERVATION`,`CUSTP_ID_CUSTOMER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC COMMENT='Huespedes registrados en reserva';

/*Data for the table `ctrlt_guest` */

insert  into `ctrlt_guest`(`MAINP_ID_HOTEL`,`RESVP_ID_RESERVATION`,`CUSTP_ID_CUSTOMER`,`GUESC_STATUS`) values (1,2540,3,NULL),(1,2543,3,NULL),(1,2547,12,NULL),(1,5140,3,'P'),(1,5141,3,NULL),(1,5145,3,NULL),(1,5146,4,NULL),(1,5147,1,'P'),(1,5147,2,'P'),(1,5147,3,'P'),(1,5147,4,'P'),(1,5148,3,NULL),(1,5148,4,NULL),(1,5149,2,NULL),(1,5150,2,NULL),(1,5152,3,NULL),(1,5153,3,NULL),(1,5211,1,NULL),(1,5211,2,NULL),(1,5211,4,NULL);

/*Table structure for table `ctrlt_holliday` */

DROP TABLE IF EXISTS `ctrlt_holliday`;

CREATE TABLE `ctrlt_holliday` (
  `HOLYC_ID_COUNTRY` smallint(6) DEFAULT NULL,
  `HOLYC_HOLLYDAY` date DEFAULT NULL,
  `HOLYC_DESCRIPTION` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlt_holliday` */

insert  into `ctrlt_holliday`(`HOLYC_ID_COUNTRY`,`HOLYC_HOLLYDAY`,`HOLYC_DESCRIPTION`) values (NULL,'0000-00-00','New Years day'),(NULL,'0000-00-00','San Valentine\'s day'),(NULL,'0000-00-00','Job\'s day'),(NULL,'0000-00-00','Indian\'s day'),(NULL,'0000-00-00','Independence day'),(NULL,'0000-00-00','Angamos Combat'),(NULL,'0000-00-00','Santa Rosa\'s day'),(NULL,'0000-00-00','Death\'s day'),(NULL,'0000-00-00','Merry Christmats');

/*Table structure for table `ctrlt_hotel_account` */

DROP TABLE IF EXISTS `ctrlt_hotel_account`;

CREATE TABLE `ctrlt_hotel_account` (
  `MAINP_ID_HOTEL` smallint(2) NOT NULL DEFAULT '0',
  `ACCTP_ID_ACCOUNT` smallint(4) DEFAULT NULL,
  `ACCTC_ACCOUNT_NUMBER` char(3) NOT NULL DEFAULT '0',
  `ACCTC_ACCOUNT_TYPE` char(1) DEFAULT NULL,
  `ACCTC_DESCRIPTION` varchar(30) DEFAULT NULL,
  `ACCTC_STATUS` char(1) DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC COMMENT='InnoDB free: 4096 kB';

/*Data for the table `ctrlt_hotel_account` */

insert  into `ctrlt_hotel_account`(`MAINP_ID_HOTEL`,`ACCTP_ID_ACCOUNT`,`ACCTC_ACCOUNT_NUMBER`,`ACCTC_ACCOUNT_TYPE`,`ACCTC_DESCRIPTION`,`ACCTC_STATUS`) values (1,21,'21','P','Efectivo','A'),(1,22,'22','P','Cheque','A'),(1,24,'24','P','Visa','A'),(1,25,'25','P','Master Card','A'),(1,26,'26','P','Dinners','A'),(1,51,'51','P','Cuentas x Cobrar','A'),(1,52,'52','P','Canje','A'),(1,99,'99','0','Multiple','A'),(1,111,'111','C','Alojamiento','A'),(1,121,'121','C','Restaurant','A'),(1,130,'130','C','Lavanderia','A'),(1,151,'151','C','Telefonia Local','A'),(1,152,'152','C','Telefonia L/D Nacional','A'),(1,155,'155','C','Telefonia L/D Internacional','A');

/*Table structure for table `ctrlt_hotel_main` */

DROP TABLE IF EXISTS `ctrlt_hotel_main`;

CREATE TABLE `ctrlt_hotel_main` (
  `MAINP_ID_HOTEL` tinyint(1) unsigned NOT NULL,
  `MAINC_HOTEL_DESCRIPTION` varchar(50) NOT NULL DEFAULT '',
  `MAINC_TOTAL_ROOMS` smallint(3) NOT NULL,
  `MAINC_ADDRESS` varchar(50) NOT NULL DEFAULT '',
  `MAINC_DISTRICT` char(20) NOT NULL DEFAULT '',
  `MAINC_CITY` char(20) NOT NULL DEFAULT '',
  `MAINC_REGION` char(20) NOT NULL DEFAULT '',
  `MAINC_STATE` char(20) NOT NULL DEFAULT '',
  `MAINC_COUNTRY` char(20) NOT NULL DEFAULT '',
  `MAINC_CODE_AREA` char(5) NOT NULL DEFAULT '',
  `MAINC_CODE_CITY` char(5) NOT NULL DEFAULT '',
  `MAINC_PHONE_NUMBER` varchar(10) NOT NULL DEFAULT '',
  `MAINC_ZIP_CODE` varchar(10) NOT NULL DEFAULT '',
  `MAINC_STATUS` char(1) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC COMMENT='Hotel Description';

/*Data for the table `ctrlt_hotel_main` */

insert  into `ctrlt_hotel_main`(`MAINP_ID_HOTEL`,`MAINC_HOTEL_DESCRIPTION`,`MAINC_TOTAL_ROOMS`,`MAINC_ADDRESS`,`MAINC_DISTRICT`,`MAINC_CITY`,`MAINC_REGION`,`MAINC_STATE`,`MAINC_COUNTRY`,`MAINC_CODE_AREA`,`MAINC_CODE_CITY`,`MAINC_PHONE_NUMBER`,`MAINC_ZIP_CODE`,`MAINC_STATUS`) values (1,'UNIDAD HOTELERA 1',50,'LIMA','LIMA','LIMA','LIMA','COSTA','PERU','00-51','51-1-','','0',''),(2,'UNIDAD HOTELERA 2',100,'ICA','ICA','ICA','ICA','COSTA','PERU','00-56','56-2-','','0','');

/*Table structure for table `ctrlt_hotel_room` */

DROP TABLE IF EXISTS `ctrlt_hotel_room`;

CREATE TABLE `ctrlt_hotel_room` (
  `MAINP_ID_HOTEL` tinyint(1) unsigned NOT NULL,
  `ROOMP_ID_ROOM` smallint(6) DEFAULT NULL,
  `ROOMC_ROOM_NUMBER` char(4) NOT NULL DEFAULT '',
  `ROOMC_DESCRIPTION` varchar(50) DEFAULT NULL,
  `RTYPF_ID_ROOMTYPE` char(2) DEFAULT NULL,
  `ROOMC_ROOM_RATE` decimal(10,0) DEFAULT NULL,
  `ROOMC_STATUS` char(1) DEFAULT NULL,
  PRIMARY KEY (`MAINP_ID_HOTEL`,`ROOMC_ROOM_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlt_hotel_room` */

insert  into `ctrlt_hotel_room`(`MAINP_ID_HOTEL`,`ROOMP_ID_ROOM`,`ROOMC_ROOM_NUMBER`,`ROOMC_DESCRIPTION`,`RTYPF_ID_ROOMTYPE`,`ROOMC_ROOM_RATE`,`ROOMC_STATUS`) values (1,NULL,'0101','Double','DB','50','A');

/*Table structure for table `ctrlt_occupation` */

DROP TABLE IF EXISTS `ctrlt_occupation`;

CREATE TABLE `ctrlt_occupation` (
  `MAINP_ID_HOTEL` tinyint(1) DEFAULT NULL,
  `RTYPP_ROOM_TYPE` char(2) DEFAULT NULL,
  `OCCPP_OCCUPATION_DAY` date DEFAULT NULL,
  `RESVP_ID_RESERVATION` smallint(5) unsigned DEFAULT NULL,
  `OCCPC_RESERVATION_TYPE` char(1) DEFAULT 'I',
  `OCCPC_QUANTITY_ROOMS` tinyint(3) DEFAULT '1',
  `OCCPC_ROOM_NUMBER` char(4) DEFAULT NULL,
  `OCCPC_ADULTS` tinyint(3) unsigned DEFAULT '1',
  `OCCPC_CHILDREN` tinyint(1) unsigned DEFAULT '0',
  `OCCPC_STATUS` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AVG_ROW_LENGTH=8192 ROW_FORMAT=DYNAMIC COMMENT='InnoDB free: 22528 kB';

/*Data for the table `ctrlt_occupation` */

insert  into `ctrlt_occupation`(`MAINP_ID_HOTEL`,`RTYPP_ROOM_TYPE`,`OCCPP_OCCUPATION_DAY`,`RESVP_ID_RESERVATION`,`OCCPC_RESERVATION_TYPE`,`OCCPC_QUANTITY_ROOMS`,`OCCPC_ROOM_NUMBER`,`OCCPC_ADULTS`,`OCCPC_CHILDREN`,`OCCPC_STATUS`) values (1,'SJ','2007-01-09',2604,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-08',2604,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-07',2604,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-12',2603,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-11',2603,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-10',2603,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-09',2603,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-08',2603,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-07',2603,'I',1,'0000',1,0,'T'),(1,'SJ','2007-02-26',2602,'I',1,'0000',2,0,'T'),(1,'SJ','2007-02-25',2602,'I',1,'0000',2,0,'T'),(1,'SJ','2007-02-24',2602,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-06',2601,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-21',2600,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-20',2600,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-21',2599,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-20',2599,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-15',2598,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-15',2597,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-12',2596,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-11',2596,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-12',2595,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-11',2595,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-16',2594,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-15',2594,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-14',2594,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-13',2594,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-12',2594,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-11',2594,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-10',2594,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-28',2593,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-27',2593,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-05',2592,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-04',2592,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-03',2592,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-02',2592,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-01',2592,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-05',2591,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-04',2591,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-03',2591,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-02',2591,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-01',2591,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-05',2590,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-04',2590,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-03',2590,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-02',2590,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-01',2590,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-05',2589,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-04',2589,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-03',2589,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-02',2589,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-01',2589,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-05',2588,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-04',2588,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-03',2588,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-02',2588,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-01',2588,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-05',2587,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-04',2587,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-03',2587,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-02',2587,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-01',2587,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-05',2586,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-04',2586,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-03',2586,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-02',2586,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-01',2586,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-05',2585,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-04',2585,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-03',2585,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-02',2585,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-01',2585,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-05',2584,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-04',2584,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-03',2584,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-02',2584,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-01',2584,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-05',2583,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-04',2583,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-03',2583,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-02',2583,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-01',2583,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-05',2582,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-04',2582,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-03',2582,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-02',2582,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-01',2582,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-14',2581,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-13',2581,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',2580,'I',1,'0305',1,0,'W'),(1,'ES','2007-12-17',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-16',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-15',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-14',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-13',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-12',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-11',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-10',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-09',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-08',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-07',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-06',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-05',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-04',2579,'I',1,'0501',1,0,'W'),(1,'ES','2007-12-03',2579,'I',1,'0501',1,0,'W'),(1,'SJ','2007-12-07',2578,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-14',2577,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-13',2577,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-12',2577,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-11',2577,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-10',2577,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-14',2576,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-13',2576,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-12',2576,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-03',2575,'I',1,'0303',1,0,'W'),(1,'SJ','2007-12-05',2574,'I',1,'0206',2,0,'C'),(1,'SJ','2007-12-04',2574,'I',1,'0206',2,0,'C'),(1,'SJ','2007-12-03',2574,'I',1,'0206',2,0,'C'),(1,'SJ','2007-12-02',2573,'I',1,'0410',1,0,'W'),(1,'SJ','2007-12-07',2571,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',2571,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',2571,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',2570,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',2570,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',2570,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',2569,'I',1,'0104',1,0,'C'),(1,'SJ','2007-12-06',2569,'I',1,'0104',1,0,'C'),(1,'SJ','2007-12-05',2569,'I',1,'0104',1,0,'C'),(1,'SJ','2007-12-04',2569,'I',1,'0104',1,0,'C'),(1,'SJ','2007-12-03',2569,'I',1,'0104',1,0,'C'),(1,'SJ','2007-12-04',2568,'I',1,'0210',1,0,'W'),(1,'SJ','2007-12-03',2568,'I',1,'0210',1,0,'W'),(1,'SJ','2007-12-02',2568,'I',1,'0210',1,0,'W'),(1,'SJ','2007-12-06',2567,'I',1,'0302',2,0,'W'),(1,'SJ','2007-12-05',2567,'I',1,'0302',2,0,'W'),(1,'SJ','2007-12-04',2567,'I',1,'0302',2,0,'W'),(1,'SJ','2007-12-03',2567,'I',1,'0302',2,0,'W'),(1,'SJ','2007-12-02',2567,'I',1,'0302',2,0,'W'),(1,'SJ','2007-12-01',2567,'I',1,'0302',2,0,'W'),(1,'SJ','2007-12-06',2566,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',2566,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',2565,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',2565,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-02',2561,'I',1,'0303',2,0,'W'),(1,'SJ','2007-12-01',2561,'I',1,'0303',2,0,'W'),(1,'SJ','2007-11-30',2561,'I',1,'0303',2,0,'W'),(1,'SJ','2007-12-07',2560,'I',1,'0407',1,0,'W'),(1,'SJ','2007-12-06',2560,'I',1,'0407',1,0,'W'),(1,'SJ','2007-12-05',2560,'I',1,'0407',1,0,'W'),(1,'SJ','2007-12-04',2560,'I',1,'0407',1,0,'W'),(1,'SJ','2007-12-03',2560,'I',1,'0407',1,0,'W'),(1,'SJ','2007-12-02',2560,'I',1,'0407',1,0,'W'),(1,'SJ','2007-12-01',2560,'I',1,'0407',1,0,'W'),(1,'SJ','2007-11-30',2560,'I',1,'0407',1,0,'W'),(1,'SJ','2007-12-02',2559,'I',1,'0301',1,0,'W'),(1,'SJ','2007-12-01',2559,'I',1,'0301',1,0,'W'),(1,'SJ','2007-11-30',2559,'I',1,'0301',1,0,'W'),(1,'SJ','2007-12-09',2558,'I',1,'0310',2,0,'W'),(1,'SJ','2007-12-08',2558,'I',1,'0310',2,0,'W'),(1,'SJ','2007-12-07',2558,'I',1,'0310',2,0,'W'),(1,'SJ','2007-12-06',2558,'I',1,'0310',2,0,'W'),(1,'SJ','2007-12-05',2558,'I',1,'0310',2,0,'W'),(1,'SJ','2007-12-04',2558,'I',1,'0310',2,0,'W'),(1,'SJ','2007-12-03',2558,'I',1,'0310',2,0,'W'),(1,'SJ','2007-12-02',2558,'I',1,'0310',2,0,'W'),(1,'SJ','2007-12-01',2558,'I',1,'0310',2,0,'W'),(1,'SJ','2007-11-30',2558,'I',1,'0310',2,0,'W'),(1,'SJ','2007-12-02',2557,'I',1,'0207',2,0,'W'),(1,'SJ','2007-12-01',2557,'I',1,'0207',2,0,'W'),(1,'SJ','2007-11-30',2557,'I',1,'0207',2,0,'W'),(1,'SJ','2007-12-02',2555,'I',1,'0404',1,0,'C'),(1,'SJ','2007-12-01',2555,'I',1,'0404',1,0,'C'),(1,'SJ','2007-01-23',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-22',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-21',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-20',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-19',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-18',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-17',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-16',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-15',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-14',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-13',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-12',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-11',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-10',2554,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-19',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-18',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-17',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-16',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-15',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-14',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-13',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-12',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-11',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-10',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-09',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-08',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-07',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-06',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-05',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-04',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-03',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-02',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-12-01',2553,'I',1,'0409',1,0,'W'),(1,'SJ','2007-11-30',2553,'I',1,'0409',1,0,'W'),(1,'ES','2007-12-03',2547,'I',1,'',1,0,'M'),(1,'SJ','2007-12-07',2546,'I',1,'0103',2,0,'C'),(1,'SJ','2007-12-06',2546,'I',1,'0103',2,0,'C'),(1,'SJ','2007-12-05',2546,'I',1,'0103',2,0,'C'),(1,'SJ','2007-12-04',2546,'I',1,'0103',2,0,'C'),(1,'SJ','2007-12-03',2546,'I',1,'0103',2,0,'C'),(1,'SJ','2007-12-19',2543,'I',1,'0000',2,0,'M'),(1,'SJ','2007-12-04',2539,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-10',2538,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-11',2537,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-10',2537,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-04',2536,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-03',2536,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-02',2536,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-27',2535,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-26',2535,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-02',2534,'I',1,'0209',1,0,'W'),(1,'SJ','2007-12-01',2534,'I',1,'0209',1,0,'W'),(1,'SJ','2007-11-30',2534,'I',1,'0209',1,0,'W'),(1,'SJ','2007-11-29',2534,'I',1,'0209',1,0,'W'),(1,'SJ','2007-11-28',2534,'I',1,'0209',1,0,'W'),(1,'SJ','2007-12-18',2533,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-17',2533,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-16',2533,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-09',2532,'I',1,'0204',1,0,'C'),(1,'SJ','2007-12-08',2532,'I',1,'0204',1,0,'C'),(1,'SJ','2007-12-07',2532,'I',1,'0204',1,0,'C'),(1,'SJ','2007-12-06',2532,'I',1,'0204',1,0,'C'),(1,'SJ','2007-12-05',2532,'I',1,'0204',1,0,'C'),(1,'SJ','2007-12-04',2532,'I',1,'0204',1,0,'C'),(1,'SJ','2007-12-03',2532,'I',1,'0204',1,0,'C'),(1,'SJ','2007-12-02',2532,'I',1,'0204',1,0,'C'),(1,'SJ','2007-12-06',2530,'I',1,'0308',1,0,'C'),(1,'SJ','2007-12-05',2530,'I',1,'0308',1,0,'C'),(1,'SJ','2007-12-04',2530,'I',1,'0308',1,0,'C'),(1,'SJ','2007-12-03',2530,'I',1,'0308',1,0,'C'),(1,'SJ','2007-12-02',2530,'I',1,'0308',1,0,'C'),(1,'SJ','2007-12-06',2529,'I',1,'0402',1,0,'C'),(1,'SJ','2007-12-05',2529,'I',1,'0402',1,0,'C'),(1,'SJ','2007-12-04',2529,'I',1,'0402',1,0,'C'),(1,'SJ','2007-12-03',2529,'I',1,'0402',1,0,'C'),(1,'SJ','2007-12-02',2529,'I',1,'0402',1,0,'C'),(1,'SJ','2007-12-06',2528,'I',1,'0209',1,0,'C'),(1,'SJ','2007-12-05',2528,'I',1,'0209',1,0,'C'),(1,'SJ','2007-12-04',2528,'I',1,'0209',1,0,'C'),(1,'SJ','2007-12-03',2528,'I',1,'0209',1,0,'C'),(1,'SJ','2007-12-02',2528,'I',1,'0209',1,0,'C'),(1,'SJ','2007-12-05',2527,'I',1,'0307',2,0,'C'),(1,'SJ','2007-12-04',2527,'I',1,'0307',2,0,'C'),(1,'SJ','2007-12-03',2527,'I',1,'0307',2,0,'C'),(1,'SJ','2007-12-06',2525,'I',1,'0203',1,0,'C'),(1,'SJ','2007-12-05',2525,'I',1,'0203',1,0,'C'),(1,'SJ','2007-12-04',2525,'I',1,'0203',1,0,'C'),(1,'SJ','2007-12-03',2525,'I',1,'0203',1,0,'C'),(1,'SJ','2007-12-02',2522,'I',1,'0203',1,0,'C'),(1,'SJ','2007-12-11',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-10',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-09',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-08',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-07',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-06',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-05',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-04',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-03',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-02',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-01',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-11-30',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-11-29',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-08',2518,'I',1,'0311',1,0,'C'),(1,'SJ','2007-12-07',2518,'I',1,'0311',1,0,'C'),(1,'SJ','2007-12-06',2518,'I',1,'0311',1,0,'C'),(1,'SJ','2007-12-05',2518,'I',1,'0311',1,0,'C'),(1,'SJ','2007-12-10',2517,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-09',2517,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-08',2517,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',2517,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',2517,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',2517,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',2517,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-03',2517,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-02',2517,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-09',2516,'I',1,'0309',2,0,'C'),(1,'SJ','2007-12-08',2516,'I',1,'0309',2,0,'C'),(1,'SJ','2007-12-07',2516,'I',1,'0309',2,0,'C'),(1,'SJ','2007-12-06',2516,'I',1,'0309',2,0,'C'),(1,'SJ','2007-12-05',2516,'I',1,'0309',2,0,'C'),(1,'SJ','2007-12-04',2516,'I',1,'0309',2,0,'C'),(1,'SJ','2007-12-03',2516,'I',1,'0309',2,0,'C'),(1,'SJ','2007-12-02',2516,'I',1,'0309',2,0,'C'),(1,'SJ','2007-12-01',2516,'I',1,'0309',2,0,'C'),(1,'SJ','2007-12-02',2515,'I',1,'0405',1,0,'C'),(1,'SJ','2007-12-01',2515,'I',1,'0405',1,0,'C'),(1,'SJ','2007-11-30',2515,'I',1,'0405',1,0,'C'),(1,'SJ','2007-11-29',2515,'I',1,'0405',1,0,'C'),(1,'SJ','2007-12-06',2512,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-08',2511,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',2511,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',2511,'I',1,'0000',1,0,'T'),(1,'ES','2007-12-02',2510,'I',1,'0601',1,0,'C'),(1,'ES','2007-12-02',2509,'I',1,'0601',1,0,'C'),(1,'ES','2007-11-25',2504,'I',1,'0601',1,0,'W'),(1,'SJ','2007-12-03',2496,'I',1,'0311',1,0,'C'),(1,'SJ','2007-12-18',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-17',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-16',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-15',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-14',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-13',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-12',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-11',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-10',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-09',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-08',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-07',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-06',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-05',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-04',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-03',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-02',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-01',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-11-30',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-11-29',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-11-28',2494,'I',1,'0201',1,0,'C'),(1,'SJ','2007-12-02',2492,'I',1,'0307',2,0,'C'),(1,'SJ','2007-12-01',2492,'I',1,'0307',2,0,'C'),(1,'SJ','2007-11-30',2492,'I',1,'0307',2,0,'C'),(1,'SJ','2007-12-06',2488,'I',1,'0208',1,0,'C'),(1,'SJ','2007-12-05',2488,'I',1,'0208',1,0,'C'),(1,'SJ','2007-12-04',2488,'I',1,'0208',1,0,'C'),(1,'SJ','2007-12-03',2488,'I',1,'0208',1,0,'C'),(1,'SJ','2007-12-06',2487,'I',1,'0102',1,0,'C'),(1,'SJ','2007-12-05',2487,'I',1,'0102',1,0,'C'),(1,'SJ','2007-12-04',2487,'I',1,'0102',1,0,'C'),(1,'SJ','2007-12-03',2487,'I',1,'0102',1,0,'C'),(1,'SJ','2007-12-06',2486,'I',1,'0207',1,0,'C'),(1,'SJ','2007-12-05',2486,'I',1,'0207',1,0,'C'),(1,'SJ','2007-12-04',2486,'I',1,'0207',1,0,'C'),(1,'SJ','2007-12-03',2486,'I',1,'0207',1,0,'C'),(1,'SJ','2007-11-26',2485,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',2485,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-13',2479,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-12',2479,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-30',2476,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-29',2476,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-28',2476,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-27',2476,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-26',2476,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-30',2475,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-29',2475,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-28',2475,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-27',2475,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-26',2475,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-06',2470,'I',1,'0211',1,0,'C'),(1,'SJ','2007-12-05',2470,'I',1,'0211',1,0,'C'),(1,'SJ','2007-12-04',2470,'I',1,'0211',1,0,'C'),(1,'SJ','2007-12-03',2470,'I',1,'0211',1,0,'C'),(1,'SJ','2007-12-02',2470,'I',1,'0211',1,0,'C'),(1,'SJ','2007-12-01',2470,'I',1,'0211',1,0,'C'),(1,'SJ','2007-11-28',2465,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-27',2465,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-26',2465,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',2465,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-24',2465,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',2465,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-02',2464,'I',1,'0102',1,0,'C'),(1,'SJ','2007-12-12',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-11',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-10',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-09',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-08',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-07',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-06',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-05',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-04',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-03',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-02',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-01',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-11-30',2462,'I',1,'0406',2,0,'C'),(1,'SJ','2007-12-01',2461,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-30',2461,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-29',2461,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-28',2461,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-27',2461,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-02',2459,'I',1,'0206',1,0,'C'),(1,'SJ','2007-12-01',2459,'I',1,'0206',1,0,'C'),(1,'SJ','2007-11-30',2459,'I',1,'0206',1,0,'C'),(1,'SJ','2007-11-29',2459,'I',1,'0206',1,0,'C'),(1,'SJ','2007-11-21',2457,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-20',2456,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-27',2455,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-27',2454,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-22',2446,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-21',2446,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-20',2446,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-27',2443,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-26',2443,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-25',2443,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-24',2443,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-23',2443,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-22',2443,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-21',2443,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-20',2443,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-19',2443,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-18',2443,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-17',2443,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-05',2439,'I',1,'0605',1,0,'C'),(1,'SJ','2007-12-04',2439,'I',1,'0605',1,0,'C'),(1,'SJ','2007-12-03',2439,'I',1,'0605',1,0,'C'),(1,'SJ','2007-12-05',2438,'I',1,'0603',1,0,'C'),(1,'SJ','2007-12-04',2438,'I',1,'0603',1,0,'C'),(1,'SJ','2007-12-03',2438,'I',1,'0603',1,0,'C'),(1,'SJ','2007-12-05',2432,'I',1,'0403',1,0,'C'),(1,'SJ','2007-12-04',2432,'I',1,'0403',1,0,'C'),(1,'SJ','2007-12-03',2432,'I',1,'0403',1,0,'C'),(1,'SJ','2007-12-02',2432,'I',1,'0403',1,0,'C'),(1,'SJ','2007-12-02',2431,'I',1,'0304',1,0,'C'),(1,'SJ','2007-12-01',2431,'I',1,'0304',1,0,'C'),(1,'SJ','2007-11-30',2431,'I',1,'0304',1,0,'C'),(1,'SJ','2007-11-29',2431,'I',1,'0304',1,0,'C'),(1,'SJ','2007-11-28',2431,'I',1,'0304',1,0,'C'),(1,'SJ','2007-11-27',2431,'I',1,'0304',1,0,'C'),(1,'SJ','2007-11-26',2431,'I',1,'0304',1,0,'C'),(1,'SJ','2007-11-25',2431,'I',1,'0304',1,0,'C'),(1,'SJ','2007-11-24',2431,'I',1,'0304',1,0,'C'),(1,'SJ','2007-11-23',2431,'I',1,'0304',1,0,'C'),(1,'SJ','2007-11-22',2431,'I',1,'0304',1,0,'C'),(1,'SJ','2007-12-07',2422,'I',1,'0401',1,0,'C'),(1,'SJ','2007-12-06',2422,'I',1,'0401',1,0,'C'),(1,'SJ','2007-12-05',2422,'I',1,'0401',1,0,'C'),(1,'SJ','2007-12-04',2422,'I',1,'0401',1,0,'C'),(1,'SJ','2007-12-03',2422,'I',1,'0401',1,0,'C'),(1,'SJ','2007-12-02',2422,'I',1,'0401',1,0,'C'),(1,'SJ','2007-12-01',2422,'I',1,'0401',1,0,'C'),(1,'SJ','2007-12-06',2421,'I',1,'0306',3,0,'C'),(1,'SJ','2007-12-05',2421,'I',1,'0306',3,0,'C'),(1,'SJ','2007-12-04',2421,'I',1,'0306',3,0,'C'),(1,'SJ','2007-12-03',2421,'I',1,'0306',3,0,'C'),(1,'SJ','2007-11-25',2419,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',2414,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-26',2407,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',2407,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-24',2407,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-23',2406,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-22',2406,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-21',2406,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-20',2406,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-23',2405,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-22',2405,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-21',2405,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-20',2405,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-16',2404,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-10',2403,'I',1,'0408',1,0,'C'),(1,'SJ','2007-12-09',2403,'I',1,'0408',1,0,'C'),(1,'SJ','2007-12-08',2403,'I',1,'0408',1,0,'C'),(1,'SJ','2007-12-07',2403,'I',1,'0408',1,0,'C'),(1,'SJ','2007-12-06',2403,'I',1,'0408',1,0,'C'),(1,'SJ','2007-12-05',2403,'I',1,'0408',1,0,'C'),(1,'SJ','2007-12-04',2403,'I',1,'0408',1,0,'C'),(1,'SJ','2007-12-03',2403,'I',1,'0408',1,0,'C'),(1,'SJ','2007-12-02',2403,'I',1,'0408',1,0,'C'),(1,'SJ','2007-12-16',2400,'I',1,'0000',3,0,'T'),(1,'SJ','2007-12-15',2400,'I',1,'0000',3,0,'T'),(1,'SJ','2007-12-14',2400,'I',1,'0000',3,0,'T'),(1,'SJ','2007-12-13',2400,'I',1,'0000',3,0,'T'),(1,'SJ','2007-12-12',2400,'I',1,'0000',3,0,'T'),(1,'SJ','2007-11-15',2399,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',2398,'I',1,'0210',1,0,'C'),(1,'SJ','2007-01-09',2392,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-08',2392,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-07',2392,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-06',2392,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-05',2392,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-04',2392,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-03',2392,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-15',2388,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',2387,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',2386,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',2385,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',2384,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',2383,'I',1,'0301',1,0,'C'),(1,'SJ','2007-12-04',2382,'I',1,'0303',1,0,'C'),(1,'SJ','2007-12-04',2381,'I',1,'0304',1,0,'C'),(1,'SJ','2007-11-15',2380,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',2374,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',2373,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',2372,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-14',2371,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-19',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-18',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-17',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-16',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-15',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-14',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-13',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-12',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-11',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-10',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-09',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-08',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-03',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-02',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-01',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-30',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-29',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-28',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-27',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-26',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-24',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-22',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-21',2370,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',2365,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',2365,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',2364,'I',1,'0105',1,0,'C'),(1,'SJ','2007-12-05',2364,'I',1,'0105',1,0,'C'),(1,'SJ','2007-12-04',2364,'I',1,'0105',1,0,'C'),(1,'SJ','2007-12-03',2364,'I',1,'0105',1,0,'C'),(1,'SJ','2007-11-25',2357,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-24',2357,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',2357,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-22',2357,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-29',2356,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-28',2356,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-27',2356,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-26',2356,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',2356,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-24',2356,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',2356,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-22',2356,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-21',2356,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-20',2356,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-19',2356,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-20',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-19',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-18',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-17',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-16',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-15',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-14',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-13',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-12',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-11',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-10',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-09',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-08',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-03',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-02',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-01',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-30',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-29',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-28',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-21',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-13',2338,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-02',2333,'I',1,'0104',1,0,'C'),(1,'SJ','2007-12-01',2333,'I',1,'0104',1,0,'C'),(1,'SJ','2007-11-30',2333,'I',1,'0104',1,0,'C'),(1,'SJ','2007-11-29',2333,'I',1,'0104',1,0,'C'),(1,'SJ','2007-11-28',2333,'I',1,'0104',1,0,'C'),(1,'SJ','2007-11-27',2333,'I',1,'0104',1,0,'C'),(1,'SJ','2007-11-26',2333,'I',1,'0104',1,0,'C'),(1,'SJ','2007-12-02',2332,'I',1,'0305',1,0,'C'),(1,'SJ','2007-12-01',2332,'I',1,'0305',1,0,'C'),(1,'SJ','2007-11-30',2332,'I',1,'0305',1,0,'C'),(1,'SJ','2007-11-29',2332,'I',1,'0305',1,0,'C'),(1,'SJ','2007-11-28',2332,'I',1,'0305',1,0,'C'),(1,'SJ','2007-11-27',2332,'I',1,'0305',1,0,'C'),(1,'SJ','2007-11-26',2332,'I',1,'0305',1,0,'C'),(1,'SJ','2007-12-09',2321,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-17',2315,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',2315,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',2315,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',2315,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-13',2315,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-12',2315,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-11',2309,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-10',2309,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',2309,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-11',2308,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-10',2308,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',2308,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-05',2307,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-02',38,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-01',38,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-01',2522,'I',1,'0203',1,0,'C'),(1,'SJ','2007-12-14',2521,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-13',2521,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-08',2520,'I',1,'0410',1,0,'C'),(1,'SJ','2007-12-07',2520,'I',1,'0410',1,0,'C'),(1,'SJ','2007-12-06',2520,'I',1,'0410',1,0,'C'),(1,'SJ','2007-12-05',2520,'I',1,'0410',1,0,'C'),(1,'SJ','2007-12-04',2520,'I',1,'0410',1,0,'C'),(1,'SJ','2007-12-03',2520,'I',1,'0410',1,0,'C'),(1,'SJ','2007-12-15',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-14',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-13',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-12-12',2519,'I',1,'0202',1,0,'C'),(1,'SJ','2007-11-08',2259,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-07',2259,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-06',2259,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-05',2259,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-04',2250,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-03',2250,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-02',2250,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-01',2250,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-21',2247,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-20',2247,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-18',2247,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-17',2247,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-16',2247,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-02',2244,'I',1,'0208',1,0,'C'),(1,'SJ','2007-12-01',2244,'I',1,'0208',1,0,'C'),(1,'SJ','2007-11-30',2244,'I',1,'0208',1,0,'C'),(1,'SJ','2007-11-26',2238,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',2238,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-03',2234,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-30',2223,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-29',2223,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-13',2220,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-07',2219,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-06',2219,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-11',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-10',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-07',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-06',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-05',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-04',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-03',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-02',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-01',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-31',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-30',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-29',2217,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-22',2211,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-21',2211,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-20',2211,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-19',2211,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-01',2210,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-30',2210,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-29',2210,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-28',2210,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-27',2210,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-26',2210,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',2187,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',2187,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',2187,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',2187,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-13',2187,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-12',2187,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-25',2182,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-21',2181,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-20',2181,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-09',2180,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',2180,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-07',2180,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',2179,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',2179,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-07',2179,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-30',2175,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-29',2175,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-02',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-01',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-31',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-30',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-29',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-28',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-27',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-26',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-25',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-24',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-23',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-22',2151,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-25',2143,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-24',2143,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-23',2143,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-27',2138,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-26',2138,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',2136,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',2136,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',2136,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',2136,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-13',2136,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-12',2136,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',2135,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',2135,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',2135,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',2135,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-13',2135,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-12',2135,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',2134,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',2134,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',2134,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',2134,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-13',2134,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-12',2134,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-11',2134,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-10',2134,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',2133,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',2133,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',2133,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',2133,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-13',2133,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-12',2133,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-11',2133,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-10',2133,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-27',2121,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-26',2121,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-25',2121,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-24',2121,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-23',2121,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-22',2121,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-25',2120,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-24',2120,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-23',2120,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-22',2120,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-21',2120,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-30',2114,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-10',2103,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',2103,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',2103,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-07',2103,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-06',2103,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-05',2103,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-10',2102,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',2102,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',2102,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-07',2102,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-06',2102,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-05',2102,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',2082,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',2082,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-07',2082,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-06',2082,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-05',2082,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',2081,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',2081,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-07',2081,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-06',2081,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-05',2081,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-25',2079,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-24',2079,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-23',2079,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-22',2079,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-28',1981,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',1972,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-24',1972,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-23',1972,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-22',1972,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-21',1972,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-20',1972,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-19',1972,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-18',1972,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-17',1972,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-03',1956,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-24',1943,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-24',1929,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-24',1880,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-24',1879,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-29',1835,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-16',1820,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-15',1820,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-27',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-26',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-25',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-24',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-23',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-22',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-21',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-20',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-19',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-18',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-17',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-16',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-15',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-14',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-13',1781,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-15',1777,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-19',1772,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-18',1772,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-17',1772,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-16',1772,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-15',1772,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-14',1772,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-13',1772,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-12',1772,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-11',1772,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-10',1772,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-18',1724,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-06',1719,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-05',1719,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-04',1719,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-03',1719,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-02',1719,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-30',1694,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-29',1694,'I',1,'0000',2,0,'T'),(1,'ES','2007-12-27',1686,'I',1,'0602',1,0,'T'),(1,'ES','2007-12-26',1686,'I',1,'0602',1,0,'T'),(1,'SJ','2007-12-28',1663,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-27',1663,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-26',1663,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-25',1663,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-31',1660,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-30',1660,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-29',1660,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-28',1660,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-27',1660,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-31',1659,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-30',1659,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-29',1659,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-28',1659,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-27',1659,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-21',1652,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-20',1652,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-18',1647,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-17',1647,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-20',1629,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-19',1629,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-18',1629,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-17',1629,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-16',1629,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-15',1629,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-14',1629,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-13',1629,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-30',1608,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-29',1608,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-28',1608,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-27',1608,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-26',1608,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-25',1608,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-24',1608,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-11',1585,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-10',1585,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-09',1585,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-21',1576,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',1557,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',1557,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',1557,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',1557,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-03',1557,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',1544,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',1544,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',1544,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',1544,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-03',1544,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-02',1544,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',1539,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',1539,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',1539,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-03',1539,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-02',1539,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',1538,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-06',1538,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-05',1538,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-04',1538,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-03',1538,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-02',1538,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-07',1533,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',1533,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',1533,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',1533,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-03',1533,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-02',1533,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-17',1510,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-16',1510,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-15',1510,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-07',1502,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',1502,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',1502,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',1502,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-27',1486,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-26',1486,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',1486,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-01',1472,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-30',1472,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-26',1470,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',1457,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',1456,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-20',1452,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-23',1433,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-18',1428,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-17',1428,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-29',1426,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-28',1426,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-27',1426,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-26',1426,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',1426,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-24',1426,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',1426,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-22',1426,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-21',1426,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-20',1426,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-29',1425,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-28',1425,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-27',1425,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-26',1425,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',1425,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-24',1425,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',1425,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-22',1425,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-21',1425,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-20',1425,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-22',1420,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-21',1420,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-20',1420,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-19',1420,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-18',1420,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-17',1420,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-15',1416,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-20',1415,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',1410,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-16',1408,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-09',1364,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-08',1364,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-07',1364,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-11',1363,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-11',1362,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-11',1361,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-11',1360,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-06',1353,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-26',1352,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',1352,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-24',1352,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',1352,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-22',1352,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-21',1352,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-20',1352,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-19',1352,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-18',1352,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-04',1344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-04',1343,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',1341,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-17',1340,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-16',1340,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-04',1321,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-19',1320,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-18',1320,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-16',1179,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',1320,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',1320,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',1320,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',1320,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-19',1319,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-18',1319,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',1319,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',1319,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',1319,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',1319,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-19',1318,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-18',1318,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',1318,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',1318,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',1318,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-15',1179,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',1318,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-19',1317,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-18',1317,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',1317,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',1317,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',1317,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',1317,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-04',1311,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-03',1311,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-15',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-02',1311,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-19',1303,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-18',1303,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',1303,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',1303,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',1303,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',1303,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-30',1285,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-27',1247,'I',1,'0000',2,0,'T'),(1,'SJ','2007-10-26',1247,'I',1,'0000',2,0,'T'),(1,'SJ','2007-10-30',1235,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-29',1235,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-28',1235,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-27',1235,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-26',1235,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-25',1235,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-24',1235,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-23',1235,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-30',1234,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-29',1234,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-28',1234,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-27',1234,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-26',1234,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-25',1234,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-24',1234,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-23',1234,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-30',1233,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-29',1233,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-28',1233,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-27',1233,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-26',1233,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-25',1233,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-24',1233,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-23',1233,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-30',1232,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-29',1232,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-28',1232,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-27',1232,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-26',1232,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-25',1232,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-24',1232,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-23',1232,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-30',1231,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-29',1231,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-28',1231,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-27',1231,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-26',1231,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-25',1231,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-24',1231,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-23',1231,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',1227,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',1227,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-28',1226,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-18',1184,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-18',1180,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-17',1180,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-16',1180,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-15',1180,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-18',1179,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-17',1179,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-13',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-12',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-11',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-10',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-09',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-08',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-07',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-06',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-05',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-04',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-10-07',1069,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-06',1069,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-05',1069,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-04',1069,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-03',1069,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-18',1066,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-17',1066,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-16',1066,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-15',1066,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-14',1066,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-13',1066,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-12',1066,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-11',1066,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-10',1066,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-09',1066,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-08',1066,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-18',1065,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-17',1065,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-16',1065,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-15',1065,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-14',1065,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-13',1065,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-12',1065,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-11',1065,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-10',1065,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-09',1065,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-08',1065,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-07',1061,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-06',1061,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-12',1052,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-11',1052,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-10',1052,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-09',1052,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-08',1052,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-12',1050,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-09',1043,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-01',1032,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-14',1030,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-13',1030,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-12',1030,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-11',1030,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-10',1030,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-09',1030,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-08',1030,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-07',1030,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-22',1024,'I',1,'0000',2,0,'T'),(1,'SJ','2007-10-21',1024,'I',1,'0000',2,0,'T'),(1,'SJ','2007-10-20',1024,'I',1,'0000',2,0,'T'),(1,'SJ','2007-10-13',1018,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-12',1018,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-26',995,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-25',981,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-24',981,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-23',981,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-01',969,'I',1,'0408',1,0,'T'),(1,'SJ','2007-09-27',968,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-18',938,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-17',938,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-16',938,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-14',928,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-16',916,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-20',915,'I',1,'0000',2,0,'T'),(1,'SJ','2007-09-19',915,'I',1,'0000',2,0,'T'),(1,'SJ','2007-09-18',915,'I',1,'0000',2,0,'T'),(1,'SJ','2007-09-17',915,'I',1,'0000',2,0,'T'),(1,'SJ','2007-09-16',915,'I',1,'0000',2,0,'T'),(1,'SJ','2007-09-11',913,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-21',900,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-20',900,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-19',900,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-18',900,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-25',665,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-26',665,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-27',665,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-17',900,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-16',900,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-15',900,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-14',900,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-12',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-11',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-10',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-09',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-08',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-07',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-06',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-05',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-04',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-03',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-02',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-01',899,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-06',873,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-03',847,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-11',827,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-03',823,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-02',823,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-31',815,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-30',815,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-31',807,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-29',802,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-28',802,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-27',802,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-26',802,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-25',802,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-24',802,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-23',802,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-22',802,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-21',802,'I',1,'0000',2,0,'T'),(1,'SJ','2007-01-20',802,'I',1,'0000',2,0,'T'),(1,'SJ','2007-09-09',799,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-16',797,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-15',797,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-11',790,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-10',790,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-09',790,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-08',790,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-04',789,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-03',789,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-04',788,'I',1,'0000',2,0,'T'),(1,'SJ','2007-09-01',786,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-31',786,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-30',786,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-29',786,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-28',786,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-27',786,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-13',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-12',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-11',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-10',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-07',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-06',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-05',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-04',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-03',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-02',784,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-27',769,'I',1,'0403',1,0,'T'),(1,'SJ','2007-09-12',765,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-09',740,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-08',740,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-07',740,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-23',723,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-22',723,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-10',712,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-20',686,'I',1,'0000',3,0,'T'),(1,'SJ','2007-12-19',686,'I',1,'0000',3,0,'T'),(1,'SJ','2007-12-18',686,'I',1,'0000',3,0,'T'),(1,'SJ','2007-12-17',686,'I',1,'0000',3,0,'T'),(1,'SJ','2007-12-16',686,'I',1,'0000',3,0,'T'),(1,'SJ','2007-12-15',686,'I',1,'0000',3,0,'T'),(1,'SJ','2007-08-28',665,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-24',665,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-31',664,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-30',664,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-29',664,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-28',664,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-27',664,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-26',664,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-25',664,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-24',664,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-07',660,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-06',660,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-20',653,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-19',653,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-18',653,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-17',653,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-16',653,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-12',605,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-13',604,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-10',597,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-15',592,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-15',591,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-15',590,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-10',589,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-10',588,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-02',585,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-01',585,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-02',584,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-01',584,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-12',549,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-11',549,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-10',549,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-08',543,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-10',509,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-14',507,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-07',501,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-06',501,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-05',501,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-04',500,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-09',499,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-08',499,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-07',499,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-06',499,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-29',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-28',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-27',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-26',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-25',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-24',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-23',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-22',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-21',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-20',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-19',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-18',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-17',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-16',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-12-15',498,'I',1,'0000',2,0,'T'),(1,'SJ','2007-08-14',496,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-13',496,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-12',496,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-11',496,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-15',495,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-14',495,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-13',495,'I',1,'0000',1,0,'T'),(1,'SJ','2007-09-12',495,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-08',467,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-30',443,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-27',427,'I',1,'0000',3,0,'T'),(1,'SJ','2007-08-22',407,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-21',407,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-20',407,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-26',402,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-31',400,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-30',400,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-31',399,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-23',378,'I',1,'0000',2,0,'T'),(1,'SJ','2007-08-22',378,'I',1,'0000',2,0,'T'),(1,'SJ','2007-08-21',378,'I',1,'0000',2,0,'T'),(1,'SJ','2007-08-20',378,'I',1,'0000',2,0,'T'),(1,'SJ','2007-08-19',378,'I',1,'0000',2,0,'T'),(1,'SJ','2007-08-18',378,'I',1,'0000',2,0,'T'),(1,'SJ','2007-08-17',378,'I',1,'0000',2,0,'T'),(1,'SJ','2007-08-16',378,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-19',355,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-20',345,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-20',340,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-20',339,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-19',339,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-18',338,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-26',336,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-25',336,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-24',336,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-23',336,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-26',335,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-25',335,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-23',335,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-24',335,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-19',330,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-18',330,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-19',329,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-18',329,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-19',328,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-18',328,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-19',327,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-18',327,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-19',326,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-18',326,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-19',324,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-15',33,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-18',324,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-19',323,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-18',323,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-19',322,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-18',322,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-02',321,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-01',321,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-31',321,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-30',321,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-21',316,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-20',316,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-19',316,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-18',316,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-20',309,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-19',309,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-18',309,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-17',309,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-20',308,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-19',308,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-18',308,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-17',308,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-16',283,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-15',283,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-14',283,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-13',283,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-12',283,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-17',281,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-16',281,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-15',281,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-14',281,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-17',273,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-16',273,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-10',261,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-09',261,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-27',259,'I',1,'0000',10,0,'T'),(1,'SJ','2007-07-26',259,'I',1,'0000',10,0,'T'),(1,'SJ','2007-07-25',259,'I',1,'0000',10,0,'T'),(1,'SJ','2007-07-24',259,'I',1,'0000',10,0,'T'),(1,'SJ','2007-07-23',259,'I',1,'0000',10,0,'T'),(1,'SJ','2007-07-22',259,'I',1,'0000',10,0,'T'),(1,'SJ','2007-07-21',259,'I',1,'0000',10,0,'T'),(1,'SJ','2007-07-06',241,'I',1,'0404',1,0,'W'),(1,'SJ','2007-07-21',240,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-17',239,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-16',239,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-15',239,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-05',229,'I',1,'0211',1,0,'W'),(1,'SJ','2007-07-10',213,'I',1,'0000',3,0,'T'),(1,'SJ','2007-07-09',213,'I',1,'0000',3,0,'T'),(1,'SJ','2007-07-14',208,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-06',193,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-04',190,'I',1,'0203',1,0,'W'),(1,'SJ','2007-07-03',190,'I',1,'0203',1,0,'W'),(1,'SJ','2007-07-02',190,'I',1,'0203',1,0,'W'),(1,'SJ','2007-07-06',187,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-02',186,'I',1,'0603',1,0,'W'),(1,'SJ','2007-07-01',186,'I',1,'0603',1,0,'W'),(1,'SJ','2007-07-04',179,'I',1,'0406',1,0,'C'),(1,'SJ','2007-07-02',168,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-01',168,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-02',163,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-01',163,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-30',163,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-16',138,'I',1,'0000',3,0,'T'),(1,'SJ','2007-07-07',131,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-06',131,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-30',114,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-29',114,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-23',110,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-23',109,'I',1,'0000',2,0,'T'),(1,'SJ','2007-06-25',108,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-30',97,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-29',97,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-28',97,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-27',96,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-26',96,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-25',96,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-24',96,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-28',94,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-27',94,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-26',94,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-30',90,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-29',90,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-28',90,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-27',89,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-26',89,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-25',89,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-24',89,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-23',88,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-22',88,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-21',88,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-29',86,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-30',80,'I',1,'0000',2,0,'T'),(1,'SJ','2007-06-30',74,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-26',73,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-25',56,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-25',53,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-24',53,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-25',52,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-24',52,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-21',51,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-17',48,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-16',48,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-15',48,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-03',38,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-27',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-26',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-25',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-24',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-23',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-22',2344,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',2306,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',2306,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-03',2306,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-02',2306,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-01',2306,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-30',2306,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-10',2305,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-09',2305,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-08',2305,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-07',2305,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-06',2305,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-05',2305,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-04',2305,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-03',2305,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-02',2305,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-01',2305,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-30',2305,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-20',2304,'I',1,'0205',1,0,'C'),(1,'SJ','2007-11-19',2304,'I',1,'0205',1,0,'C'),(1,'SJ','2007-11-08',2300,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-06',2297,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-17',2291,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-16',2291,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-15',2291,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-14',2291,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-13',2291,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-12',2291,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-12',2282,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',2280,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',2280,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-07',2280,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-06',2280,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-05',2280,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',2278,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',2277,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-08',2276,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-04',2269,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-10',2259,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-09',2259,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-19',2247,'I',1,'0000',2,0,'T'),(1,'SJ','2007-11-03',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-11-02',1172,'I',1,'0409',1,0,'T'),(1,'SJ','2007-10-10',1131,'I',1,'0605',1,0,'T'),(1,'SJ','2007-11-04',1125,'I',1,'0000',1,0,'T'),(1,'SJ','2007-11-03',1125,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-15',1114,'I',1,'0000',1,0,'T'),(1,'SJ','2007-10-11',1110,'I',1,'0000',1,0,'T'),(1,'SJ','2007-08-24',378,'I',1,'0000',2,0,'T'),(1,'SJ','2007-08-25',378,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-30',399,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-10',2604,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-11',2604,'I',1,'0000',1,0,'T'),(1,'SJ','2007-01-12',2604,'I',1,'0000',1,0,'T'),(1,'SJ','2007-07-04',2855,'I',1,'0406',1,0,'C'),(1,'SJ','2007-07-05',2855,'I',1,'0406',1,0,'C'),(1,'SJ','2007-06-29',5127,'I',1,'0000',2,0,'T'),(1,'SJ','2007-06-29',5128,'I',1,'0000',2,0,'T'),(1,'SJ','2007-05-24',5131,'I',1,'0000',1,0,'T'),(1,'SJ','2007-05-25',5131,'I',1,'0000',1,0,'T'),(1,'SJ','2007-05-26',5131,'I',1,'0000',1,0,'T'),(1,'SJ','2007-05-27',5131,'I',1,'0000',1,0,'T'),(1,'SJ','2007-05-28',5131,'I',1,'0000',1,0,'T'),(1,'SJ','2007-05-29',5131,'I',1,'0000',1,0,'T'),(1,'SJ','2007-05-30',5131,'I',1,'0000',1,0,'T'),(1,'SJ','2007-06-27',5136,'I',1,'0000',2,0,'T'),(1,'SJ','2007-06-28',5136,'I',1,'0000',2,0,'T'),(1,'SJ','2007-06-29',5136,'I',1,'0000',2,0,'T'),(1,'SJ','2007-07-15',10,'I',1,'0000',2,0,'C'),(1,'SJ','2007-12-11',5137,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-12',5137,'I',1,'0000',1,0,'T'),(1,'SJ','2007-12-03',5138,'I',1,'0304',3,0,'C'),(1,'SJ','2007-12-03',5139,'I',1,'',2,0,'C'),(1,'SJ','2007-12-03',5142,'I',1,'',1,0,'C'),(1,'SJ','2007-12-03',5143,'I',1,'5143',1,0,'C'),(1,'SJ','2007-10-18',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-17',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-16',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-15',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-12-03',5143,'I',1,'5143',1,0,'C'),(1,'SJ','2007-12-03',5143,'I',1,'5143',1,0,'C'),(1,'SJ','2007-10-15',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-16',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-17',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-18',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-15',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-16',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-17',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-18',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-15',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-16',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-17',5144,'I',1,'5144',1,0,'T'),(1,'SJ','2007-10-18',5144,'I',1,'5144',1,0,'T'),(1,'ES','2007-12-04',2548,'I',1,'',3,0,'T'),(1,'ES','2007-12-03',2548,'I',1,'',3,0,'T'),(1,'ES','2008-02-15',5163,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5168,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5184,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5176,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5183,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5181,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5184,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5181,'I',1,'0201',1,0,'T'),(1,'ES','2008-02-15',5181,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5183,'I',1,'0201',1,0,'T'),(1,'ES','2008-02-15',5183,'I',1,'0201',1,0,'T'),(1,'DB','2008-02-15',5184,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5193,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5192,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5190,'I',1,'0201',1,0,'*'),(1,'0','2008-02-15',5191,'I',1,'0201',1,0,'*'),(1,'DB','2008-02-15',5192,'I',1,'0201',1,0,'T'),(1,'DB','2008-02-15',5193,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5166,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5163,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5165,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5175,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5191,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5190,'I',1,'0201',1,0,'T'),(1,'0','2008-02-15',5190,'I',1,'0201',1,0,'*'),(1,'0','2008-02-15',5191,'I',1,'0201',1,0,'*'),(1,'0','2008-02-15',5163,'I',1,'0201',1,0,'T');

/*Table structure for table `ctrlt_period` */

DROP TABLE IF EXISTS `ctrlt_period`;

CREATE TABLE `ctrlt_period` (
  `MAINP_ID_HOTEL` tinyint(2) unsigned NOT NULL,
  `PERIP_ID_PERIOD` tinyint(3) unsigned zerofill NOT NULL,
  `PERIC_START_DATE` date NOT NULL,
  `PERIC_END_DATE` date NOT NULL,
  `PERIC_DESCRIPTION` varchar(50) NOT NULL DEFAULT '',
  `PERIC_PERIOD_CLASS` char(1) DEFAULT NULL COMMENT 'Y=Yearly;S=Temporada; W=Fin de semana; H=Holiday',
  `PERIC_MADE_BY` varchar(30) DEFAULT NULL,
  `PERIC_MADE_ON` date DEFAULT NULL,
  `PERIC_UPDATED_BY` varchar(30) DEFAULT NULL,
  `PERIC_LAST_UPDATE` date DEFAULT NULL,
  `PERIC_STATUS` char(1) DEFAULT 'A',
  PRIMARY KEY (`MAINP_ID_HOTEL`,`PERIP_ID_PERIOD`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ctrlt_period` */

insert  into `ctrlt_period`(`MAINP_ID_HOTEL`,`PERIP_ID_PERIOD`,`PERIC_START_DATE`,`PERIC_END_DATE`,`PERIC_DESCRIPTION`,`PERIC_PERIOD_CLASS`,`PERIC_MADE_BY`,`PERIC_MADE_ON`,`PERIC_UPDATED_BY`,`PERIC_LAST_UPDATE`,`PERIC_STATUS`) values (1,001,'2008-01-01','2008-12-31','ALL 2008','Y','J.O','2008-07-01','J.O','2008-07-01','A');

/*Table structure for table `ctrlt_rate` */

DROP TABLE IF EXISTS `ctrlt_rate`;

CREATE TABLE `ctrlt_rate` (
  `RTYPF_ID_ROOM_TYPE` smallint(2) unsigned NOT NULL,
  `MAINP_ID_HOTEL` smallint(2) unsigned NOT NULL,
  `PERIF_ID_PERIOD` smallint(3) unsigned zerofill NOT NULL,
  `RATEP_ID_SPECIAL_RATE` smallint(2) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `RATEC_VALUE` decimal(10,2) DEFAULT NULL,
  `RATEC_MADE_BY` char(3) DEFAULT NULL,
  `RATEC_MADE_ON` date DEFAULT NULL,
  `RATEC_UPDATED_BY` char(3) DEFAULT NULL,
  `RATEC_LAST_UPDATE` date DEFAULT NULL,
  `RATEC_STATUS` char(1) DEFAULT 'A',
  PRIMARY KEY (`RATEP_ID_SPECIAL_RATE`,`MAINP_ID_HOTEL`,`RTYPF_ID_ROOM_TYPE`,`PERIF_ID_PERIOD`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlt_rate` */

insert  into `ctrlt_rate`(`RTYPF_ID_ROOM_TYPE`,`MAINP_ID_HOTEL`,`PERIF_ID_PERIOD`,`RATEP_ID_SPECIAL_RATE`,`RATEC_VALUE`,`RATEC_MADE_BY`,`RATEC_MADE_ON`,`RATEC_UPDATED_BY`,`RATEC_LAST_UPDATE`,`RATEC_STATUS`) values (1,1,001,01,'50.00','J.O','2008-07-01','J.O','2008-07-01','A'),(2,1,001,01,'40.00','J.O','2008-07-01','J.O','2008-07-01','A'),(2,1,002,01,'45.00','J.O','2008-07-01','J.O','2008-07-01','A'),(1,1,001,02,'40.00','J.O','2008-07-01','J.O','2008-07-01','A'),(2,1,001,02,'35.00','J.O','2008-07-01','J.O','2008-07-01','A'),(1,1,001,04,'50.00','JO.','2008-10-06','JO.','2008-10-06','A'),(1,1,001,05,'50.00','JO.','2008-10-06','JO.','2008-10-06','A'),(1,1,001,06,'50.00','JO.','2008-10-06',NULL,'2008-10-06','A');

/*Table structure for table `ctrlt_res_type` */

DROP TABLE IF EXISTS `ctrlt_res_type`;

CREATE TABLE `ctrlt_res_type` (
  `SEGMP_ID_SEGMENT` smallint(2) unsigned NOT NULL AUTO_INCREMENT,
  `RESTC_DESCRIPTION` varbinary(50) DEFAULT NULL,
  `COMPF_ID_COMPANY` smallint(6) unsigned DEFAULT '0',
  PRIMARY KEY (`SEGMP_ID_SEGMENT`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlt_res_type` */

insert  into `ctrlt_res_type`(`SEGMP_ID_SEGMENT`,`RESTC_DESCRIPTION`,`COMPF_ID_COMPANY`) values (1,'INDIVIDUAL',0),(2,'TOURISM',0),(3,'CORPORATIVE',0);

/*Table structure for table `ctrlt_reservation` */

DROP TABLE IF EXISTS `ctrlt_reservation`;

CREATE TABLE `ctrlt_reservation` (
  `RESVP_ID_RESERVATION` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `MAINP_ID_HOTEL` smallint(1) unsigned NOT NULL,
  `RESVC_RESERVATION_TYPE` varchar(1) NOT NULL DEFAULT 'I',
  `RESVC_ARRIVAL` date NOT NULL,
  `RESVC_DEPARTURE` date NOT NULL,
  `RESVC_NIGHTS` tinyint(3) unsigned NOT NULL,
  `RESVC_ADULTS` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `RESVC_CHILDREN` tinyint(3) unsigned DEFAULT '0',
  `RESVF_ID_ROOMTYPE` smallint(2) NOT NULL,
  `RESVC_QUANTITY` smallint(6) unsigned NOT NULL DEFAULT '1',
  `RESVF_ID_ROOM` varchar(4) DEFAULT NULL,
  `RESVC_VIP_CODE` char(1) DEFAULT '3',
  `SRCEF_ID_SOURCE` int(6) unsigned NOT NULL,
  `RESVC_ROOM_RATE` decimal(10,2) NOT NULL,
  `RESVC_TOTAL_ROOM` decimal(10,2) NOT NULL,
  `RESVC_PAYMENT_DUE` date DEFAULT NULL,
  `RESVF_PAYMENT_TYPE` tinyint(3) unsigned DEFAULT NULL,
  `RESVC_VOUCHER` varchar(10) DEFAULT NULL,
  `RESVC_HOTEL_INSTRUCTIONS` varchar(120) DEFAULT NULL,
  `RESVC_GUEST_INSTRUCTIONS` varchar(120) DEFAULT NULL,
  `RESVC_MADE_BY` varchar(3) DEFAULT NULL,
  `RESVC_MADE_ON` datetime DEFAULT NULL,
  `RESVC_UPDATED_BY` varchar(3) DEFAULT NULL,
  `RESVC_LAST_UPDATE` datetime DEFAULT NULL,
  `RESVC_STATUS` char(1) NOT NULL DEFAULT 'T',
  PRIMARY KEY (`RESVP_ID_RESERVATION`,`MAINP_ID_HOTEL`)
) ENGINE=InnoDB AUTO_INCREMENT=5146 DEFAULT CHARSET=latin1 AVG_ROW_LENGTH=214 ROW_FORMAT=DYNAMIC COMMENT='InnoDB free: 22528 kB';

/*Data for the table `ctrlt_reservation` */

insert  into `ctrlt_reservation`(`RESVP_ID_RESERVATION`,`MAINP_ID_HOTEL`,`RESVC_RESERVATION_TYPE`,`RESVC_ARRIVAL`,`RESVC_DEPARTURE`,`RESVC_NIGHTS`,`RESVC_ADULTS`,`RESVC_CHILDREN`,`RESVF_ID_ROOMTYPE`,`RESVC_QUANTITY`,`RESVF_ID_ROOM`,`RESVC_VIP_CODE`,`SRCEF_ID_SOURCE`,`RESVC_ROOM_RATE`,`RESVC_TOTAL_ROOM`,`RESVC_PAYMENT_DUE`,`RESVF_PAYMENT_TYPE`,`RESVC_VOUCHER`,`RESVC_HOTEL_INSTRUCTIONS`,`RESVC_GUEST_INSTRUCTIONS`,`RESVC_MADE_BY`,`RESVC_MADE_ON`,`RESVC_UPDATED_BY`,`RESVC_LAST_UPDATE`,`RESVC_STATUS`) values (0033,1,'I','2007-07-15','2007-07-16',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0038,1,'I','2007-07-01','2007-07-04',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0048,1,'I','2007-07-15','2007-07-18',3,2,0,0,1,'0000','',0,'42.00','126.00','0000-00-00',0,NULL,'PAX PAGA EXTRAS         ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0051,1,'I','2007-07-21','2007-07-22',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0052,1,'I','2007-07-24','2007-07-26',2,2,0,0,1,'0000','',0,'42.00','84.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0053,1,'I','2007-07-24','2007-07-26',2,2,0,0,1,'0000','',0,'42.00','84.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0056,1,'I','2007-07-25','2007-07-26',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0073,1,'I','2007-06-26','2007-06-27',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0074,1,'I','2007-06-30','2007-07-01',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0080,1,'I','2007-06-30','2007-07-01',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0086,1,'I','2007-06-29','2007-06-30',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0088,1,'I','2007-06-21','2007-06-24',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'CIA$SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0089,1,'I','2007-06-24','2007-06-28',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'CIA$SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0090,1,'I','2007-06-28','2007-07-01',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'CIA$SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0094,1,'I','2007-06-26','2007-06-29',3,1,0,0,1,'0000','',0,'46.00','138.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0096,1,'I','2007-06-24','2007-06-28',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'CIA PAGA SOLO ROOM      ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0097,1,'I','2007-06-28','2007-07-01',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'CIA PAGA SOLO ROOM      ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0108,1,'I','2007-06-25','2007-06-26',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0109,1,'I','2007-06-23','2007-06-24',1,2,0,0,1,'0000','',0,'54.00','54.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0110,1,'I','2007-06-23','2007-06-24',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0114,1,'I','2007-06-29','2007-07-01',2,1,0,0,1,'0000','',0,'46.00','92.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0131,1,'I','2007-07-06','2007-07-08',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0138,1,'I','2007-07-16','2007-07-17',1,3,0,0,1,'0000','',0,'0.00','0.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0163,1,'I','2007-06-30','2007-07-03',3,1,0,0,1,'0000','',0,'36.00','108.00','0000-00-00',0,NULL,'CIA$SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0168,1,'I','2007-07-01','2007-07-03',2,1,0,0,1,'0000','',0,'36.00','72.00','0000-00-00',0,NULL,'CIA$SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0179,1,'I','2007-07-04','2007-07-05',1,1,0,0,1,'0406','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(0186,1,'I','2007-07-01','2007-07-03',2,1,0,0,1,'0603','',0,'36.00','72.00','0000-00-00',0,NULL,'CIA$SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(0187,1,'I','2007-07-06','2007-07-07',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0190,1,'I','2007-07-02','2007-07-05',3,1,0,0,1,'0203','',0,'36.00','108.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(0193,1,'I','2007-07-06','2007-07-07',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0208,1,'I','2007-07-14','2007-07-15',1,2,0,0,1,'0000','',0,'50.00','50.00','0000-00-00',0,NULL,'PAX.PAGA/EXO.IG.V.      ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0213,1,'I','2007-07-09','2007-07-11',2,3,0,0,1,'0000','',0,'54.00','108.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0229,1,'I','2007-07-05','2007-07-06',1,1,0,0,1,'0211','3',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(0239,1,'I','2007-07-15','2007-07-18',3,2,0,0,1,'0000','',0,'42.00','126.00','0000-00-00',0,NULL,'CIA $ ROOM PAX $ EXTRAS ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0240,1,'I','2007-07-21','2007-07-22',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'CIA $ ROOM PAX $ EXTRAS ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0241,1,'I','2007-07-06','2007-07-07',1,1,0,0,1,'0404','1',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(0259,1,'I','2007-07-21','2007-07-28',7,10,0,0,1,'0000','',0,'38.00','266.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0261,1,'I','2007-07-09','2007-07-11',2,2,0,0,1,'0000','',0,'42.00','84.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0273,1,'I','2007-07-16','2007-07-18',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0281,1,'I','2007-07-14','2007-07-18',4,2,0,0,1,'0000','',0,'42.00','168.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0283,1,'I','2007-07-12','2007-07-17',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0308,1,'I','2007-07-17','2007-07-21',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0309,1,'I','2007-07-17','2007-07-21',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0316,1,'I','2007-07-18','2007-07-22',4,1,0,0,1,'0000','',0,'42.00','168.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0321,1,'I','2007-07-30','2007-08-03',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0322,1,'I','2007-07-18','2007-07-20',2,1,0,0,1,'0000','',0,'36.00','72.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0323,1,'I','2007-07-18','2007-07-20',2,1,0,0,1,'0000','',0,'36.00','72.00','0000-00-00',0,NULL,'CIA ROOM                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0324,1,'I','2007-07-18','2007-07-20',2,1,0,0,1,'0000','',0,'36.00','72.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0326,1,'I','2007-07-18','2007-07-20',2,1,0,0,1,'0000','',0,'36.00','72.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0327,1,'I','2007-07-18','2007-07-20',2,1,0,0,1,'0000','',0,'36.00','72.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0328,1,'I','2007-07-18','2007-07-20',2,1,0,0,1,'0000','',0,'36.00','72.00','0000-00-00',0,NULL,'CIA. PAGA ROOM          ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0329,1,'I','2007-07-18','2007-07-20',2,1,0,0,1,'0000','',0,'36.00','72.00','0000-00-00',0,NULL,'CIAPAGA ROOM            ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0330,1,'I','2007-07-18','2007-07-20',2,1,0,0,1,'0000','',0,'36.00','72.00','0000-00-00',0,NULL,'CIA PAGA ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0335,1,'I','2007-07-23','2007-07-27',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0336,1,'I','2007-07-23','2007-07-27',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0338,1,'I','2007-07-18','2007-07-19',1,1,0,0,1,'0000','',0,'36.00','36.00','0000-00-00',0,NULL,'CIA PAGA ROOM PAX PAGA E',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0339,1,'I','2007-07-19','2007-07-21',2,2,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'CIA $ ROOM PAX $ EXTRAS ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0340,1,'I','2007-07-20','2007-07-21',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX PAGA C/JOHNNY BERDAL',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0345,1,'I','2007-07-20','2007-07-21',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0355,1,'I','2007-07-19','2007-07-20',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0378,1,'I','2007-08-16','2007-08-26',10,2,0,0,1,'0000','',0,'42.00','420.00','0000-00-00',0,NULL,'PAX PAGA CAMAS GEMELAS  ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0399,1,'I','2007-07-30','2007-08-01',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0400,1,'I','2007-07-30','2007-08-01',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0402,1,'I','2007-07-26','2007-07-27',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX. PAGA3              ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0407,1,'I','2007-08-20','2007-08-23',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0427,1,'I','2007-07-27','2007-07-28',1,3,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0441,1,'I','2007-08-26','2007-08-26',0,1,0,0,1,'0000','',0,'19.00','0.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0443,1,'I','2007-07-30','2007-07-31',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0467,1,'I','2007-08-08','2007-08-09',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0495,1,'I','2007-09-12','2007-09-16',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0496,1,'I','2007-08-11','2007-08-15',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0498,1,'I','2007-12-15','2007-12-30',15,2,0,0,1,'0000','',0,'42.00','630.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0499,1,'I','2007-08-06','2007-08-10',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0500,1,'I','2007-08-04','2007-08-05',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0501,1,'I','2007-08-05','2007-08-08',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0507,1,'I','2007-08-14','2007-08-15',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0509,1,'I','2007-08-10','2007-08-11',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'CIA PAGA ROOM+LAVANDERIA',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0543,1,'I','2007-08-08','2007-08-09',1,1,0,0,1,'0000','2',0,'38.00','38.00','0000-00-00',0,NULL,'CIA PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0549,1,'I','2007-08-10','2007-08-13',3,1,0,0,1,'0000','1',0,'38.00','114.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0584,1,'I','2007-09-01','2007-09-03',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0585,1,'I','2007-09-01','2007-09-03',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0588,1,'I','2007-09-10','2007-09-11',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0589,1,'I','2007-09-10','2007-09-11',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0590,1,'I','2007-09-15','2007-09-16',1,1,0,0,1,'0000','1',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0591,1,'I','2007-09-15','2007-09-16',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0592,1,'I','2007-09-15','2007-09-16',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0597,1,'I','2007-08-10','2007-08-11',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0604,1,'I','2007-08-13','2007-08-14',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0605,1,'I','2007-08-12','2007-08-13',1,1,0,0,1,'0000','1',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0653,1,'I','2007-09-16','2007-09-21',5,1,0,0,1,'0000','',0,'38.00','190.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0657,1,'I','2007-09-06','2007-09-06',0,1,0,0,1,'0000','3',0,'19.00','0.00','0000-00-00',0,NULL,'CIA PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0660,1,'I','2007-09-06','2007-09-08',2,1,0,0,1,'0000','3',0,'46.00','92.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0664,1,'I','2007-08-24','2007-09-01',8,1,0,0,1,'0000','',0,'46.00','368.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0665,1,'I','2007-08-24','2007-08-29',5,1,0,0,1,'0000','',0,'46.00','230.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0686,1,'I','2007-12-15','2007-12-21',6,3,0,0,1,'0000','3',0,'42.00','252.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0712,1,'I','2007-09-10','2007-09-11',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0723,1,'I','2007-08-22','2007-08-24',2,1,0,0,1,'0000','3',0,'38.00','76.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0740,1,'I','2007-10-07','2007-10-10',3,1,0,0,1,'0000','1',0,'38.00','114.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0765,1,'I','2007-09-12','2007-09-13',1,1,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0769,1,'I','2007-08-27','2007-08-28',1,1,0,0,1,'0403','',0,'36.00','36.00','0000-00-00',0,NULL,'CIA$ROOM Y ALIMENTACION ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0784,1,'I','2007-11-02','2007-11-16',14,1,0,0,1,'0000','',0,'38.00','532.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0786,1,'I','2007-08-27','2007-09-02',6,1,0,0,1,'0000','',0,'46.00','276.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0788,1,'I','2007-09-04','2007-09-05',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0789,1,'I','2007-09-03','2007-09-05',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0790,1,'I','2007-09-08','2007-09-12',4,1,0,0,1,'0000','1',0,'31.00','124.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0797,1,'I','2007-09-15','2007-09-17',2,1,0,0,1,'0000','3',0,'38.00','76.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0799,1,'I','2007-09-09','2007-09-10',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0802,1,'I','2007-01-20','2007-01-30',10,2,0,0,1,'0000','',0,'46.00','460.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0807,1,'I','2007-08-31','2007-09-01',1,1,0,0,1,'0000','',0,'54.00','54.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0815,1,'I','2007-08-30','2007-09-01',2,1,0,0,1,'0000','3',0,'36.00','72.00','0000-00-00',0,NULL,'CIA ROOM PENS.COMPL.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0823,1,'I','2007-09-02','2007-09-04',2,1,0,0,1,'0000','1',0,'38.00','76.00','0000-00-00',0,NULL,'CIA PAGA TODO BV C/O    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0827,1,'I','2007-09-11','2007-09-12',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0847,1,'I','2007-09-03','2007-09-04',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'CIA$ROOM Y ALIMENTACION ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0873,1,'I','2007-09-06','2007-09-07',1,1,0,0,1,'0000','',0,'27.00','27.00','0000-00-00',0,NULL,'CIA PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0899,1,'I','2007-10-01','2007-10-13',12,1,0,0,1,'0000','',0,'38.00','456.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0900,1,'I','2007-09-14','2007-09-22',8,1,0,0,1,'0000','',0,'38.00','304.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0913,1,'I','2007-09-11','2007-09-12',1,1,0,0,1,'0000','',0,'27.00','27.00','0000-00-00',0,NULL,'CIA. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0915,1,'I','2007-09-16','2007-09-21',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0916,1,'I','2007-09-16','2007-09-17',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'CIA PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0928,1,'I','2007-09-14','2007-09-15',1,1,0,0,1,'0000','1',0,'38.00','38.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0938,1,'I','2007-09-16','2007-09-19',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0968,1,'I','2007-09-27','2007-09-28',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0969,1,'I','2007-01-01','2007-01-02',1,1,0,0,1,'0408','3',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0981,1,'I','2007-09-23','2007-09-26',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(0995,1,'I','2007-09-26','2007-09-27',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1018,1,'I','2007-10-12','2007-10-14',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1024,1,'I','2007-10-20','2007-10-23',3,2,0,0,1,'0000','',0,'46.00','138.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1030,1,'I','2007-10-07','2007-10-15',8,1,0,0,1,'0000','',0,'38.00','304.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1032,1,'I','2007-10-01','2007-10-02',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1043,1,'I','2007-10-09','2007-10-10',1,1,0,0,1,'0000','1',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1050,1,'I','2007-10-12','2007-10-13',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1052,1,'I','2007-10-08','2007-10-13',5,1,0,0,1,'0000','',0,'38.00','190.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1061,1,'I','2007-10-06','2007-10-08',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1065,1,'I','2007-10-08','2007-10-19',11,1,0,0,1,'0000','',0,'38.00','418.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1066,1,'I','2007-10-08','2007-10-19',11,1,0,0,1,'0000','',0,'38.00','418.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1069,1,'I','2007-10-03','2007-10-08',5,1,0,0,1,'0000','',0,'38.00','190.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1110,1,'I','2007-10-11','2007-10-12',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1114,1,'I','2007-10-15','2007-10-16',1,1,0,0,1,'0000','1',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1125,1,'I','2007-11-03','2007-11-05',2,1,0,0,1,'0000','',0,'42.00','84.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1131,1,'I','2007-10-10','2007-10-11',1,1,0,0,1,'0605','',0,'27.00','27.00','0000-00-00',0,NULL,'PAX PAGA  VER CUADERNO  ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1172,1,'I','2007-11-02','2007-11-16',14,1,0,0,1,'0409','',0,'38.00','532.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1179,1,'I','2007-10-15','2007-10-19',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1180,1,'I','2007-10-15','2007-10-19',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1184,1,'I','2007-10-18','2007-10-19',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1226,1,'I','2007-10-28','2007-10-29',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1227,1,'I','2007-11-08','2007-11-10',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1231,1,'I','2007-10-23','2007-10-31',8,1,0,0,1,'0000','',0,'38.00','304.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1232,1,'I','2007-10-23','2007-10-31',8,1,0,0,1,'0000','',0,'38.00','304.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1233,1,'I','2007-10-23','2007-10-31',8,1,0,0,1,'0000','',0,'38.00','304.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1234,1,'I','2007-10-23','2007-10-31',8,1,0,0,1,'0000','',0,'38.00','304.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1235,1,'I','2007-10-23','2007-10-31',8,1,0,0,1,'0000','',0,'38.00','304.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1247,1,'I','2007-10-26','2007-10-28',2,2,0,0,1,'0000','',0,'42.00','84.00','0000-00-00',0,NULL,'PAX $ C/ESPOSA E HIJO   ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1285,1,'I','2007-10-30','2007-10-31',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1303,1,'I','2007-11-14','2007-11-20',6,1,0,0,1,'0000','',0,'26.00','156.00','0000-00-00',0,NULL,'CIA$ROOM/EXO I.G.V.     ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1311,1,'I','2007-11-02','2007-11-05',3,2,0,0,1,'0000','',0,'46.00','138.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1317,1,'I','2007-11-14','2007-11-20',6,1,0,0,1,'0000','',0,'26.00','156.00','0000-00-00',0,NULL,'ROOM Y ALOJ EXO I.G.V.  ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1318,1,'I','2007-11-14','2007-11-20',6,1,0,0,1,'0000','',0,'26.00','156.00','0000-00-00',0,NULL,'ROOM Y ALOJ EXO I.G.V.  ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1319,1,'I','2007-11-14','2007-11-20',6,1,0,0,1,'0000','',0,'26.00','156.00','0000-00-00',0,NULL,'ROOM Y ALOJ EXO I.G.V.  ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1320,1,'I','2007-11-14','2007-11-20',6,1,0,0,1,'0000','',0,'26.00','156.00','0000-00-00',0,NULL,'ROOM Y ALOJ EXO I.G.V.  ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1321,1,'I','2007-11-04','2007-11-05',1,1,0,0,1,'0000','1',0,'38.00','38.00','0000-00-00',0,NULL,'CIA PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1340,1,'I','2007-11-16','2007-11-18',2,2,0,0,1,'0000','',0,'42.00','84.00','0000-00-00',0,NULL,'PAX.PAGA/EXO I.G.V.     ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1341,1,'I','2007-11-23','2007-11-24',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX.PAGA/EXO I.G.V.     ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1343,1,'I','2007-11-04','2007-11-05',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'CIA$ROOM Y ALIMENTAC    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1344,1,'I','2007-11-04','2007-11-05',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'CIA$ROOM Y ALIMENTACION ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1352,1,'I','2007-11-18','2007-11-27',9,1,0,0,1,'0000','',0,'38.00','342.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1353,1,'I','2007-11-06','2007-11-07',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1360,1,'I','2007-11-11','2007-11-12',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA/EXO. I.G.V.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1361,1,'I','2007-11-11','2007-11-12',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA/EXO. I.G.V.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1362,1,'I','2007-11-11','2007-11-12',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA/exo. I.G.V.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1363,1,'I','2007-11-11','2007-11-12',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA/EXO I.G.V.     ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1364,1,'I','2007-11-07','2007-11-10',3,2,0,0,1,'0000','',0,'42.00','126.00','0000-00-00',0,NULL,'PAX.PAGA/EXO. I.G.V.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1408,1,'I','2007-11-16','2007-11-17',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1410,1,'I','2007-11-23','2007-11-24',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'IGV                     ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1415,1,'I','2007-11-20','2007-11-21',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1416,1,'I','2007-11-15','2007-11-16',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1420,1,'I','2007-11-17','2007-11-23',6,2,0,0,1,'0000','',0,'38.00','228.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1425,1,'I','2007-11-20','2007-11-30',10,1,0,0,1,'0000','',0,'38.00','380.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1426,1,'I','2007-11-20','2007-11-30',10,1,0,0,1,'0000','',0,'38.00','380.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1428,1,'I','2007-11-17','2007-11-19',2,2,0,0,1,'0000','3',0,'50.00','100.00','0000-00-00',0,NULL,'ALOJ. ALIM. EXO. IGV    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1433,1,'I','2007-11-23','2007-11-24',1,1,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1452,1,'I','2007-11-20','2007-11-21',1,2,0,0,1,'0000','',0,'50.00','50.00','0000-00-00',0,NULL,'CIA. PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1456,1,'I','2007-11-23','2007-11-24',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1457,1,'I','2007-11-23','2007-11-24',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1470,1,'I','2007-11-26','2007-11-27',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1472,1,'I','2007-11-30','2007-12-02',2,1,0,0,1,'0000','3',0,'38.00','76.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1486,1,'I','2007-11-25','2007-11-28',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1502,1,'I','2007-12-04','2007-12-08',4,1,0,0,1,'0000','3',0,'38.00','152.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1510,1,'I','2007-12-15','2007-12-18',3,2,0,0,1,'0000','',0,'42.00','126.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1533,1,'I','2007-12-02','2007-12-08',6,1,0,0,1,'0000','3',0,'38.00','228.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1538,1,'I','2007-12-02','2007-12-08',6,2,0,0,1,'0000','',0,'42.00','252.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1539,1,'I','2007-12-02','2007-12-07',5,1,0,0,1,'0000','1',0,'38.00','190.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1544,1,'I','2007-12-02','2007-12-08',6,1,0,0,1,'0000','',0,'38.00','228.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1557,1,'I','2007-12-03','2007-12-08',5,1,0,0,1,'0000','',0,'38.00','190.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1576,1,'I','2007-12-21','2007-12-22',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1585,1,'I','2007-12-09','2007-12-12',3,1,0,0,1,'0000','3',0,'38.00','114.00','0000-00-00',0,NULL,'CIA4CON B.V.            ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1608,1,'I','2007-01-24','2007-01-31',7,2,0,0,1,'0000','',0,'65.00','455.00',NULL,21,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1629,1,'I','2007-12-13','2007-12-21',8,1,0,0,1,'0000','',0,'38.00','304.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1647,1,'I','2007-12-17','2007-12-19',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1652,1,'I','2007-12-20','2007-12-22',2,2,0,0,1,'0000','',0,'42.00','84.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1659,1,'I','2007-01-27','2007-02-01',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1660,1,'I','2007-01-27','2007-02-01',5,1,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1663,1,'I','2007-12-25','2007-12-29',4,1,0,0,1,'0000','',0,'46.00','184.00','0000-00-00',0,NULL,'ROOM Y ALIMT. EXO. IGV  ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1686,1,'I','2007-12-26','2007-12-28',2,1,0,0,1,'0602','3',0,'38.00','76.00','0000-00-00',0,NULL,'ROOM Y ALIMT. EXO IGV   ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1694,1,'I','2007-12-29','2007-12-31',2,2,0,0,1,'0000','',0,'65.00','130.00','0000-00-00',0,NULL,'ROOM Y ALIMT. EXO IGV   ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1719,1,'I','2007-01-02','2007-01-07',5,1,0,0,1,'0000','',0,'38.00','190.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1724,1,'I','2007-01-18','2007-01-19',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1772,1,'I','2007-01-10','2007-01-20',10,1,0,0,1,'0000','',0,'38.00','380.00','0000-00-00',0,NULL,'CIA$SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1777,1,'I','2007-01-15','2007-01-16',1,1,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1781,1,'I','2007-01-13','2007-01-28',15,1,0,0,1,'0000','',0,'35.00','525.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1820,1,'I','2007-01-15','2007-01-17',2,1,0,0,1,'0000','',0,'38.00','76.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1835,1,'I','2007-01-29','2007-01-30',1,2,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1879,1,'I','2007-01-24','2007-01-25',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1880,1,'I','2007-01-24','2007-01-25',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1929,1,'I','2007-01-24','2007-01-25',1,1,0,0,1,'0000','',0,'46.00','46.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1943,1,'I','2007-01-24','2007-01-25',1,1,0,0,1,'0000','',0,'46.00','46.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1956,1,'I','2007-11-03','2007-11-04',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1972,1,'I','2007-11-17','2007-11-26',9,2,0,0,1,'0000','',0,'37.00','333.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(1981,1,'I','2007-01-28','2007-01-29',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2079,1,'I','2007-10-22','2007-10-26',4,1,0,0,1,'0000','3',0,'38.00','152.00','0000-00-00',0,NULL,'CIA SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2081,1,'I','2007-11-05','2007-11-10',5,1,0,0,1,'0000','',0,'50.00','250.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2082,1,'I','2007-11-05','2007-11-10',5,1,0,0,1,'0000','',0,'45.00','225.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2102,1,'I','2007-11-05','2007-11-11',6,1,0,0,1,'0000','3',0,'45.00','270.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2103,1,'I','2007-11-05','2007-11-11',6,1,0,0,1,'0000','3',0,'45.00','270.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2114,1,'I','2007-11-30','2007-12-01',1,1,0,0,1,'0000','',0,'45.00','45.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2120,1,'I','2007-10-21','2007-10-26',5,1,0,0,1,'0000','',0,'30.00','150.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2121,1,'I','2007-10-22','2007-10-28',6,1,0,0,1,'0000','',0,'45.00','270.00','0000-00-00',0,NULL,'CIA PAGA AL C/O         ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2133,1,'I','2007-11-10','2007-11-18',8,1,0,0,1,'0000','3',0,'38.00','304.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2134,1,'I','2007-11-10','2007-11-18',8,1,0,0,1,'0000','',0,'38.00','304.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2135,1,'I','2007-11-12','2007-11-18',6,1,0,0,1,'0000','3',0,'38.00','228.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2136,1,'I','2007-11-12','2007-11-18',6,1,0,0,1,'0000','',0,'38.00','228.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2138,1,'I','2007-10-26','2007-10-28',2,1,0,0,1,'0000','',0,'45.00','90.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2143,1,'I','2007-10-23','2007-10-26',3,1,0,0,1,'0000','',0,'45.00','135.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2151,1,'I','2007-10-22','2007-11-03',12,1,0,0,1,'0000','',0,'38.00','456.00','0000-00-00',0,NULL,'CIA$TODO                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2175,1,'I','2007-10-29','2007-10-31',2,1,0,0,1,'0000','',0,'45.00','90.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2179,1,'I','2007-11-07','2007-11-10',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'PAXC PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2180,1,'I','2007-11-07','2007-11-10',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2181,1,'I','2007-12-20','2007-12-22',2,2,0,0,1,'0000','',0,'65.00','130.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2182,1,'I','2007-10-25','2007-10-26',1,1,0,0,1,'0000','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2187,1,'I','2007-11-12','2007-11-18',6,1,0,0,1,'0000','3',0,'38.00','228.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2210,1,'I','2007-11-26','2007-12-02',6,1,0,0,1,'0000','',0,'46.00','276.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2211,1,'I','2007-11-19','2007-11-23',4,1,0,0,1,'0000','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2217,1,'I','2007-10-29','2007-11-12',14,1,0,0,1,'0000','',0,'49.00','686.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2219,1,'I','2007-12-06','2007-12-08',2,2,0,0,1,'0000','',0,'55.00','110.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2220,1,'I','2007-12-13','2007-12-14',1,2,0,0,1,'0000','',0,'55.00','55.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2223,1,'I','2007-10-29','2007-10-31',2,1,0,0,1,'0000','',0,'49.00','98.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2234,1,'I','2007-11-03','2007-11-04',1,1,0,0,1,'0000','3',0,'42.00','42.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2238,1,'I','2007-11-25','2007-11-27',2,1,0,0,1,'0000','3',0,'38.00','76.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2244,1,'I','2007-11-30','2007-12-03',3,1,0,0,1,'0208','',0,'49.00','147.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2247,1,'I','2007-12-16','2007-12-22',6,2,0,0,1,'0000','',0,'50.00','300.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2250,1,'I','2007-11-01','2007-11-05',4,2,0,0,1,'0000','',0,'55.00','220.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2259,1,'I','2007-11-05','2007-11-11',6,1,0,0,1,'0000','',0,'38.00','228.00','0000-00-00',0,NULL,'CIA SOLO ROOM AL C/O    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2269,1,'I','2007-11-04','2007-11-05',1,1,0,0,1,'0000','',0,'45.00','45.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2276,1,'I','2007-11-08','2007-11-09',1,1,0,0,1,'0000','',0,'45.00','45.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2277,1,'I','2007-11-08','2007-11-09',1,1,0,0,1,'0000','',0,'45.00','45.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2278,1,'I','2007-11-08','2007-11-09',1,1,0,0,1,'0000','',0,'45.00','45.00','0000-00-00',0,NULL,'PAX APGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2280,1,'I','2007-11-05','2007-11-10',5,1,0,0,1,'0000','',0,'38.00','190.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2282,1,'I','2007-11-12','2007-11-13',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2291,1,'I','2007-11-12','2007-11-18',6,1,0,0,1,'0000','',0,'38.00','228.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2297,1,'I','2007-11-06','2007-11-07',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX APGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2300,1,'I','2007-11-08','2007-11-09',1,1,0,0,1,'0000','1',0,'45.00','45.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2304,1,'I','2007-11-19','2007-11-21',2,1,0,0,1,'0205','3',0,'38.00','76.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2305,1,'I','2007-11-30','2007-12-11',11,1,0,0,1,'0000','3',0,'38.00','418.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2306,1,'I','2007-11-30','2007-12-06',6,1,0,0,1,'0000','3',0,'38.00','228.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2307,1,'I','2007-11-05','2007-11-06',1,1,0,0,1,'0000','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2308,1,'I','2007-11-09','2007-11-12',3,1,0,0,1,'0000','',0,'49.00','147.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2309,1,'I','2007-11-09','2007-11-12',3,1,0,0,1,'0000','',0,'49.00','147.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2315,1,'I','2007-11-12','2007-11-18',6,1,0,0,1,'0000','',0,'38.00','228.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2321,1,'I','2007-12-09','2007-12-10',1,2,0,0,1,'0000','3',0,'42.00','42.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2332,1,'I','2007-11-26','2007-12-03',7,1,0,0,1,'0305','',0,'38.00','266.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2333,1,'I','2007-11-26','2007-12-03',7,1,0,0,1,'0104','',0,'38.00','266.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2338,1,'I','2007-12-13','2007-12-14',1,2,0,0,1,'0000','',0,'55.00','55.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2344,1,'I','2007-11-21','2007-12-21',30,1,0,0,1,'0000','',0,'38.00','1140.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2356,1,'I','2007-11-19','2007-11-30',11,1,0,0,1,'0000','',0,'38.00','418.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2357,1,'I','2007-11-22','2007-11-26',4,1,0,0,1,'0000','',0,'45.00','180.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2364,1,'I','2007-12-03','2007-12-07',4,1,0,0,1,'0105','3',0,'45.00','180.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2365,1,'I','2007-11-16','2007-11-18',2,1,0,0,1,'0000','3',0,'38.00','76.00','0000-00-00',0,NULL,'CIA PAGA TODO           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2370,1,'I','2007-11-21','2007-12-20',29,1,0,0,1,'0000','',0,'38.00','1102.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2371,1,'I','2007-11-14','2007-11-15',1,1,0,0,1,'0000','1',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2372,1,'I','2007-11-14','2007-11-15',1,2,0,0,1,'0000','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2373,1,'I','2007-11-14','2007-11-15',1,1,0,0,1,'0000','1',0,'49.00','49.00','0000-00-00',0,NULL,'ROOM .ALIM. EXO. IGV.   ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2374,1,'I','2007-11-14','2007-11-15',1,1,0,0,1,'0000','1',0,'49.00','49.00','0000-00-00',0,NULL,'ROOM ALIM. EXO. IGV.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2380,1,'I','2007-11-15','2007-11-16',1,1,0,0,1,'0000','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2381,1,'I','2007-12-04','2007-12-05',1,1,0,0,1,'0304','1',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2382,1,'I','2007-12-04','2007-12-05',1,1,0,0,1,'0303','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2383,1,'I','2007-12-04','2007-12-05',1,1,0,0,1,'0301','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2384,1,'I','2007-12-07','2007-12-08',1,1,0,0,1,'0000','1',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2385,1,'I','2007-12-07','2007-12-08',1,1,0,0,1,'0000','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX APGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2386,1,'I','2007-12-07','2007-12-08',1,1,0,0,1,'0000','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2387,1,'I','2007-11-15','2007-11-16',1,1,0,0,1,'0000','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2388,1,'I','2007-11-15','2007-11-16',1,1,0,0,1,'0000','',0,'55.00','55.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2392,1,'I','2007-01-03','2007-01-10',7,2,0,0,1,'0000','',0,'50.00','350.00','0000-00-00',0,NULL,'PAX .PAGA               ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2398,1,'I','2007-12-05','2007-12-06',1,1,0,0,1,'0210','3',0,'0.00','0.00','0000-00-00',0,NULL,'PAX PAHA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2399,1,'I','2007-11-15','2007-11-16',1,1,0,0,1,'0000','1',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2400,1,'I','2007-12-12','2007-12-17',5,3,0,0,1,'0000','3',0,'65.00','325.00','0000-00-00',0,NULL,'ROOM ALIM. EXO. IGV.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2403,1,'I','2007-12-02','2007-12-11',9,1,0,0,1,'0408','3',0,'38.00','342.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2404,1,'I','2007-12-16','2007-12-17',1,2,0,0,1,'0000','3',0,'50.00','50.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2405,1,'I','2007-12-20','2007-12-24',4,2,0,0,1,'0000','3',0,'50.00','200.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2406,1,'I','2007-12-20','2007-12-24',4,2,0,0,1,'0000','3',0,'50.00','200.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2407,1,'I','2007-11-24','2007-11-27',3,1,0,0,1,'0000','',0,'37.00','111.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2414,1,'I','2007-11-25','2007-11-26',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2419,1,'I','2007-11-25','2007-11-26',1,1,0,0,1,'0000','',0,'42.00','42.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2421,1,'I','2007-12-03','2007-12-07',4,3,0,0,1,'0306','',0,'65.00','260.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2422,1,'I','2007-12-01','2007-12-08',7,1,0,0,1,'0401','',0,'50.00','350.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2431,1,'I','2007-11-22','2007-12-03',11,1,0,0,1,'0304','',0,'49.00','539.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2432,1,'I','2007-12-02','2007-12-06',4,1,0,0,1,'0403','',0,'45.00','180.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2438,1,'I','2007-12-03','2007-12-06',3,1,0,0,1,'0603','1',0,'38.00','114.00','0000-00-00',0,NULL,'ROOM ALIM. EXO. IGV.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2439,1,'I','2007-12-03','2007-12-06',3,1,0,0,1,'0605','1',0,'38.00','114.00','0000-00-00',0,NULL,'ROOM ALIM. EXO. IGV.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2443,1,'I','2007-12-17','2007-12-28',11,2,0,0,1,'0000','',0,'49.00','539.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2446,1,'I','2007-11-20','2007-11-23',3,2,0,0,1,'0000','1',0,'42.00','126.00','0000-00-00',0,NULL,'ROOM ALIM. EXO. IGV.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2454,1,'I','2007-11-27','2007-11-28',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'PAX APGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2455,1,'I','2007-11-27','2007-11-28',1,1,0,0,1,'0000','1',0,'38.00','38.00','0000-00-00',0,NULL,'PAX APGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2456,1,'I','2007-11-20','2007-11-21',1,1,0,0,1,'0000','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2457,1,'I','2007-11-21','2007-11-22',1,1,0,0,1,'0000','3',0,'38.00','38.00','0000-00-00',0,NULL,'CIA$TODO(-BEBIDAS ALCOHO',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2459,1,'I','2007-11-29','2007-12-03',4,1,0,0,1,'0206','',0,'45.00','180.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2461,1,'I','2007-11-27','2007-12-02',5,1,0,0,1,'0000','',0,'45.00','225.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2462,1,'I','2007-11-30','2007-12-13',13,2,0,0,1,'0406','',0,'50.00','650.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2464,1,'I','2007-12-02','2007-12-03',1,1,0,0,1,'0102','1',0,'27.00','27.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2465,1,'I','2007-11-23','2007-11-29',6,1,0,0,1,'0000','',0,'38.00','228.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2470,1,'I','2007-12-01','2007-12-07',6,1,0,0,1,'0211','3',0,'38.00','228.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2475,1,'I','2007-11-26','2007-12-01',5,2,0,0,1,'0000','3',0,'50.00','250.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2476,1,'I','2007-11-26','2007-12-01',5,2,0,0,1,'0000','3',0,'50.00','250.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2479,1,'I','2007-12-12','2007-12-14',2,1,0,0,1,'0000','3',0,'49.00','98.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2485,1,'I','2007-11-25','2007-11-27',2,1,0,0,1,'0000','3',0,'38.00','76.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2486,1,'I','2007-12-03','2007-12-07',4,1,0,0,1,'0207','3',0,'38.00','152.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2487,1,'I','2007-12-03','2007-12-07',4,1,0,0,1,'0102','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2488,1,'I','2007-12-03','2007-12-07',4,1,0,0,1,'0208','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2492,1,'I','2007-11-30','2007-12-03',3,2,0,0,1,'0307','',0,'50.00','150.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2494,1,'I','2007-11-28','2007-12-19',21,1,0,0,1,'0201','3',0,'45.00','945.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2496,1,'I','2007-12-03','2007-12-04',1,1,0,0,1,'0311','3',0,'45.00','45.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2504,1,'I','2007-11-25','2007-11-26',1,1,0,0,1,'0601','',0,'0.00','0.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2509,1,'I','2007-12-02','2007-12-03',1,1,0,0,1,'0601','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2510,1,'I','2007-12-02','2007-12-03',1,1,0,0,1,'0601','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2511,1,'I','2007-12-06','2007-12-09',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2512,1,'I','2007-12-06','2007-12-07',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2515,1,'I','2007-11-29','2007-12-03',4,1,0,0,1,'0405','3',0,'38.00','152.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2516,1,'I','2007-12-01','2007-12-10',9,2,0,0,1,'0309','',0,'28.00','252.00','0000-00-00',0,NULL,'CIA$SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2517,1,'I','2007-12-02','2007-12-11',9,1,0,0,1,'0000','3',0,'45.00','405.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2518,1,'I','2007-12-05','2007-12-09',4,1,0,0,1,'0311','',0,'38.00','152.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2519,1,'I','2007-11-29','2007-12-16',17,1,0,0,1,'0202','',0,'42.00','714.00','0000-00-00',0,NULL,'CAI SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2520,1,'I','2007-12-03','2007-12-09',6,1,0,0,1,'0410','1',0,'38.00','228.00','0000-00-00',0,NULL,'ROOM ALIM. EXO. IGV.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2521,1,'I','2007-12-13','2007-12-15',2,1,0,0,1,'0000','',0,'42.00','84.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2522,1,'I','2007-12-01','2007-12-03',2,1,0,0,1,'0203','3',0,'45.00','90.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2525,1,'I','2007-12-03','2007-12-07',4,1,0,0,1,'0203','1',0,'45.00','180.00','0000-00-00',0,NULL,'CIA$SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2527,1,'I','2007-12-03','2007-12-06',3,2,0,0,1,'0307','3',0,'42.00','126.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2528,1,'I','2007-12-02','2007-12-07',5,1,0,0,1,'0209','',0,'38.00','190.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2529,1,'I','2007-12-02','2007-12-07',5,1,0,0,1,'0402','',0,'38.00','190.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2530,1,'I','2007-12-02','2007-12-07',5,1,0,0,1,'0308','',0,'38.00','190.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2532,1,'I','2007-12-02','2007-12-10',8,1,0,0,1,'0204','1',0,'45.00','360.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2533,1,'I','2007-12-16','2007-12-19',3,1,0,0,1,'0000','1',0,'45.00','135.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2534,1,'I','2007-11-28','2007-12-03',5,1,0,0,1,'0209','1',0,'38.00','190.00','0000-00-00',0,NULL,'CIA$SOLO ROOM           ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2535,1,'I','2007-12-26','2007-12-28',2,2,0,0,1,'0000','',0,'55.00','110.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2536,1,'I','2007-01-02','2007-01-05',3,2,0,0,1,'0000','',0,'55.00','165.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','2007-01-02 00:00:00','','0000-00-00 00:00:00','T'),(2537,1,'I','2007-12-10','2007-12-12',2,1,0,0,1,'0000','',0,'45.00','90.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','2007-12-10 00:00:00','','0000-00-00 00:00:00','T'),(2538,1,'I','2007-12-10','2007-12-11',1,1,0,0,1,'0000','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','2007-12-10 00:00:00','','0000-00-00 00:00:00','T'),(2539,1,'I','2007-12-04','2007-12-05',1,1,0,0,1,'0000','',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','2007-12-04 00:00:00','','0000-00-00 00:00:00','T'),(2540,1,'I','2007-12-20','2007-12-21',1,1,0,0,1,'0000','3',9999,'0.00','0.00',NULL,1,NULL,'','','','2007-12-20 00:00:00',NULL,'2007-12-15 00:00:00',''),(2543,1,'I','2007-12-19','2007-12-20',1,2,0,0,1,'0000','',0,'55.00','55.00','0000-00-00',1,NULL,NULL,NULL,'','2007-12-19 00:00:00','','0000-00-00 00:00:00','M'),(2546,1,'I','2007-12-03','2007-12-08',5,2,0,0,1,'0103','',0,'49.00','245.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','2007-12-03 00:00:00','','0000-00-00 00:00:00','C'),(2547,1,'I','2007-12-03','2007-12-04',1,1,0,0,1,'','',1,'54.00','54.00','0000-00-00',1,NULL,NULL,NULL,'','2007-12-03 00:00:00','','0000-00-00 00:00:00','M'),(2553,1,'I','2007-11-30','2007-12-20',20,1,0,0,1,'0409','',0,'38.00','760.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2554,1,'I','2007-01-10','2007-01-24',14,1,0,0,1,'0000','3',0,'38.00','532.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2555,1,'I','2007-12-01','2007-12-03',2,1,0,0,1,'0404','',0,'38.00','76.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2557,1,'I','2007-11-30','2007-12-03',3,2,0,0,1,'0207','3',0,'55.00','165.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2558,1,'I','2007-11-30','2007-12-10',10,2,0,0,1,'0310','3',0,'42.00','420.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2559,1,'I','2007-11-30','2007-12-03',3,1,0,0,1,'0301','',0,'42.00','126.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2560,1,'I','2007-11-30','2007-12-08',8,1,0,0,1,'0407','',0,'38.00','304.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2561,1,'I','2007-11-30','2007-12-03',3,2,0,0,1,'0303','',0,'55.00','165.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2565,1,'I','2007-12-05','2007-12-07',2,1,0,0,1,'0000','',0,'45.00','90.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2566,1,'I','2007-12-05','2007-12-07',2,1,0,0,1,'0000','1',0,'35.00','70.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2567,1,'I','2007-12-01','2007-12-07',6,2,0,0,1,'0302','',0,'42.00','252.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2568,1,'I','2007-12-02','2007-12-05',3,1,0,0,1,'0210','3',0,'38.00','114.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2569,1,'I','2007-12-03','2007-12-08',5,1,0,0,1,'0104','1',0,'45.00','225.00','0000-00-00',0,NULL,'ROOM ALIM. EXO. IGV.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2570,1,'I','2007-12-05','2007-12-08',3,1,0,0,1,'0000','',0,'38.00','114.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2571,1,'I','2007-12-05','2007-12-08',3,1,0,0,1,'0000','3',0,'38.00','114.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2573,1,'I','2007-12-02','2007-12-03',1,1,0,0,1,'0410','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2574,1,'I','2007-12-03','2007-12-06',3,2,0,0,1,'0206','',0,'50.00','150.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(2575,1,'I','2007-12-03','2007-12-04',1,1,0,0,1,'0303','3',0,'49.00','49.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2576,1,'I','2007-12-12','2007-12-15',3,1,0,0,1,'0000','1',0,'27.00','81.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2577,1,'I','2007-12-10','2007-12-15',5,1,0,0,1,'0000','',0,'45.00','225.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2578,1,'I','2007-12-07','2007-12-08',1,1,0,0,1,'0000','',0,'38.00','38.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2579,1,'I','2007-12-03','2007-12-18',15,1,0,0,1,'0501','1',0,'38.00','570.00','0000-00-00',0,NULL,'ROOM ALIM. EXO. IGV.    ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2580,1,'I','2007-12-04','2007-12-05',1,1,0,0,1,'0305','1',0,'42.00','42.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','W'),(2581,1,'I','2007-12-13','2007-12-15',2,1,0,0,1,'0000','1',0,'45.00','90.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2582,1,'I','2007-01-01','2007-01-06',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2583,1,'I','2007-01-01','2007-01-06',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2584,1,'I','2007-01-01','2007-01-06',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2585,1,'I','2007-01-01','2007-01-06',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2586,1,'I','2007-01-01','2007-01-06',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2587,1,'I','2007-01-01','2007-01-06',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2588,1,'I','2007-01-01','2007-01-06',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2589,1,'I','2007-01-01','2007-01-06',5,1,0,0,1,'0000','',0,'38.00','190.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2590,1,'I','2007-01-01','2007-01-06',5,1,0,0,1,'0000','',0,'38.00','190.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2591,1,'I','2007-01-01','2007-01-06',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2592,1,'I','2007-01-01','2007-01-06',5,2,0,0,1,'0000','',0,'42.00','210.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2593,1,'I','2007-12-27','2007-12-29',2,2,0,0,1,'0000','',0,'42.00','84.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2594,1,'I','2007-12-10','2007-12-17',7,1,0,0,1,'0000','',0,'45.00','315.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2595,1,'I','2007-12-11','2007-12-13',2,1,0,0,1,'0000','',0,'45.00','90.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2596,1,'I','2007-12-11','2007-12-13',2,1,0,0,1,'0000','',0,'45.00','90.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2597,1,'I','2007-12-15','2007-12-16',1,1,0,0,1,'0000','',0,'45.00','45.00','0000-00-00',0,NULL,'PAX PGA                 ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2598,1,'I','2007-12-15','2007-12-16',1,1,0,0,1,'0000','',0,'45.00','45.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2599,1,'I','2007-12-20','2007-12-22',2,1,0,0,1,'0000','',0,'45.00','90.00','0000-00-00',0,NULL,'PAX PGA                 ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2600,1,'I','2007-12-20','2007-12-22',2,1,0,0,1,'0000','',0,'45.00','90.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2601,1,'I','2007-12-06','2007-12-07',1,1,0,0,1,'0000','',0,'45.00','45.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2602,1,'I','2007-02-24','2007-02-27',3,2,0,0,1,'0000','',0,'37.00','111.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2603,1,'I','2007-01-07','2007-01-13',6,1,0,0,1,'0000','',0,'45.00','270.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2604,1,'I','2007-01-07','2007-01-13',6,1,0,0,1,'0000','',0,'45.00','270.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(2855,1,'I','2007-07-04','2007-07-06',2,1,0,0,1,'0406','3',0,'38.00','76.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','C'),(5127,1,'I','2007-06-29','2007-06-30',1,2,0,0,1,'0000','3',0,'42.00','42.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(5128,1,'I','2007-06-29','2007-06-30',1,2,0,0,1,'0000','3',0,'42.00','42.00','0000-00-00',0,NULL,'                        ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(5131,1,'I','2007-05-24','2007-05-31',7,1,0,0,1,'0000','',0,'46.00','322.00','0000-00-00',0,NULL,'PAX.PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(5136,1,'I','2007-06-27','2007-06-30',3,2,0,0,1,'0000','3',0,'42.00','126.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(5137,1,'I','2007-12-11','2007-12-13',2,1,0,0,1,'0000',NULL,0,'45.00','0.00','0000-00-00',0,NULL,'PAX PAGA                ',NULL,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','T'),(5138,1,'I','2007-12-03','2007-12-04',1,3,0,0,1,'0304',NULL,0,'65.00','0.00',NULL,21,NULL,'PAX PAGA                ',NULL,NULL,'2007-05-04 12:39:22',NULL,'2007-05-04 12:39:22','C'),(5139,1,'I','2007-12-03','2007-12-04',1,2,0,0,1,'',NULL,0,'65.00','0.00',NULL,21,NULL,'PAX PAGA                ',NULL,NULL,'2007-05-11 19:28:52',NULL,'2007-05-11 19:28:52','C'),(5140,1,'I','2008-02-15','2008-02-16',1,2,0,0,1,'',NULL,0,'65.00','65.00','0000-00-00',21,NULL,'','',NULL,'2007-05-11 20:16:59','JO.','2008-01-22 00:00:00','T'),(5141,1,'I','2008-02-01','2008-02-03',1,1,0,0,1,'0201',NULL,9999,'65.00','0.00','2008-01-15',1,NULL,'VIP','',NULL,'2007-05-24 23:36:08','JO.','2007-12-23 00:00:00','T'),(5142,1,'I','2007-12-03','2007-12-04',1,1,0,0,1,'',NULL,0,'65.00','0.00',NULL,21,NULL,'Pax, con problemas para movilizarse, asignarle habitacion cercana al comedor. Poner CANASTA DE FRUTAS.              ',NULL,'','2007-05-25 00:13:06','','2007-05-25 00:13:06','C'),(5143,1,'I','2007-12-03','2007-12-04',1,1,0,0,3,'0201',NULL,9999,'65.00','0.00','0000-00-00',21,NULL,'Pax, con problemas para movilizarse, asignarle habitacion cercana al comedor. Poner CANASTA DE FRUTAS.              ','',NULL,'2007-05-25 00:20:56','JO.','2008-01-21 00:00:00','T'),(5144,1,'I','2007-10-15','2007-10-19',4,1,0,0,4,'5144',NULL,0,'38.00','0.00',NULL,21,NULL,'testing II',NULL,NULL,'2007-06-05 11:11:26',NULL,'2007-06-05 11:11:26','T'),(5145,1,'I','2008-02-15','2008-02-16',1,1,0,0,1,'0201','3',9999,'150.50','150.50','2008-02-10',1,NULL,'Hotel instructions ...','Successfull update verify','JO.','2008-10-09 00:00:00','JO.','2008-10-09 00:00:00','*');

/*Table structure for table `ctrlt_reservation_status` */

DROP TABLE IF EXISTS `ctrlt_reservation_status`;

CREATE TABLE `ctrlt_reservation_status` (
  `RESSC_STATUS` char(1) DEFAULT NULL,
  `RESSC_DESCRIPTION` char(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC COMMENT='Reservation Status';

/*Data for the table `ctrlt_reservation_status` */

insert  into `ctrlt_reservation_status`(`RESSC_STATUS`,`RESSC_DESCRIPTION`) values ('T','TENTATIVE'),('C','CONFIRMED'),('X','CANCELLED'),('B','BLOCKED'),('M','MAINTENANCE');

/*Table structure for table `ctrlt_room` */

DROP TABLE IF EXISTS `ctrlt_room`;

CREATE TABLE `ctrlt_room` (
  `ROOMP_ID_ROOM` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `MAINP_ID_HOTEL` smallint(2) unsigned NOT NULL,
  `RTYPF_ID_ROOM_TYPE` smallint(3) NOT NULL,
  `ROOMC_ROOM_NUMBER` char(4) NOT NULL,
  `ROOMC_LOCATION` varchar(50) NOT NULL,
  `ROOMC_DESCRIPTION` varchar(50) NOT NULL,
  `ROOMC_ROOM_RATE` decimal(6,2) NOT NULL,
  `ROOMC_MAX_BEDS` smallint(3) NOT NULL,
  `ROOMC_CONNECTION` char(4) DEFAULT NULL,
  `RESVC_ID_RESERVATION` int(4) DEFAULT NULL,
  `ROOMC_HK_STATUS` char(1) DEFAULT NULL,
  `ROOMC_STATUS` char(1) NOT NULL DEFAULT 'V',
  `ROOMC_MADE_BY` char(3) NOT NULL,
  `ROOMC_MADE_ON` date NOT NULL,
  `ROOMC_UPDATED_BY` char(3) DEFAULT NULL,
  `ROOMC_LAST_UPDATE` date DEFAULT NULL,
  PRIMARY KEY (`ROOMP_ID_ROOM`,`MAINP_ID_HOTEL`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;

/*Data for the table `ctrlt_room` */

insert  into `ctrlt_room`(`ROOMP_ID_ROOM`,`MAINP_ID_HOTEL`,`RTYPF_ID_ROOM_TYPE`,`ROOMC_ROOM_NUMBER`,`ROOMC_LOCATION`,`ROOMC_DESCRIPTION`,`ROOMC_ROOM_RATE`,`ROOMC_MAX_BEDS`,`ROOMC_CONNECTION`,`RESVC_ID_RESERVATION`,`ROOMC_HK_STATUS`,`ROOMC_STATUS`,`ROOMC_MADE_BY`,`ROOMC_MADE_ON`,`ROOMC_UPDATED_BY`,`ROOMC_LAST_UPDATE`) values (1,1,2,'0101','PISO 1','VISTA INTERNA','60.00',2,'',5211,'V','I','','0000-00-00',NULL,NULL),(2,1,2,'0102','PISO 1','VISTA CALLE','50.00',2,'',5210,'V','I','','0000-00-00',NULL,NULL),(3,1,2,'0103','PISO 1','VISTA INTERNA','50.00',2,'',5209,'V','I','','0000-00-00',NULL,NULL),(4,1,2,'0104','PISO 1','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(5,1,2,'0105','PISO 1','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(6,1,2,'0106','PISO 1','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(7,1,2,'0107','PISO 1','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(8,1,2,'0108','PISO 1','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(9,1,1,'0109','PISO 1','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(10,1,1,'0110','PISO 1','VISTA CALLE','40.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(11,1,2,'0201','PISO 2','VISTA INTERNA','40.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(12,1,2,'0202','PISO 2','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(13,1,2,'0203','PISO 2','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(14,1,2,'0204','PISO 2','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(15,1,2,'0205','PISO 2','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(16,1,2,'0206','PISO 2','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(17,1,2,'0207','PISO 2','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(18,1,2,'0208','PISO 2','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(19,1,1,'0209','PISO 2','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(20,1,1,'0210','PISO 2','VISTA CALLE','40.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(21,1,2,'0301','PISO 3','VISTA INTERNA','40.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(22,1,2,'0302','PISO 3','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(23,1,2,'0303','PISO 3','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(24,1,2,'0304','PISO 3','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(25,1,2,'0305','PISO 3','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(26,1,2,'0306','PISO 3','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(27,1,2,'0307','PISO 3','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(28,1,2,'0308','PISO 3','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(29,1,1,'0309','PISO 3','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(30,1,1,'0310','PISO 3','VISTA CALLE','40.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(31,1,2,'0401','PISO 4','VISTA INTERNA','40.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(32,1,2,'0402','PISO 4','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(33,1,2,'0403','PISO 4','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(34,1,2,'0404','PISO 4','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(35,1,2,'0405','PISO 4','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(36,1,2,'0406','PISO 4','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(37,1,2,'0407','PISO 4','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(38,1,2,'0408','PISO 4','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(39,1,1,'0409','PISO 4','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(40,1,1,'0410','PISO 4','VISTA CALLE','40.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(41,1,2,'0501','PISO 5','VISTA INTERNA','40.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(42,1,2,'0502','PISO 5','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(43,1,2,'0503','PISO 5','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(44,1,2,'0504','PISO 5','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(45,1,2,'0505','PISO 5','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(46,1,2,'0506','PISO 5','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(47,1,2,'0507','PISO 5','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(48,1,2,'0508','PISO 5','VISTA CALLE','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(49,1,1,'0509','PISO 5','VISTA INTERNA','50.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(50,1,1,'0510','PISO 5','VISTA CALLE','40.00',2,'',0,'V','V','','0000-00-00',NULL,NULL),(52,1,3,'9999','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',2555,'','A','JO.','2008-10-18','JO.','2008-10-18'),(53,1,3,'9999','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',2555,'','A','JO.','2008-10-18','JO.','2008-10-18'),(54,1,3,'9999','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',2555,'','A','JO.','2008-10-18','JO.','2008-10-18'),(55,1,3,'9999','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',0,'','A','JO.','2008-10-18','JO.','2008-10-18'),(56,1,3,'ZZZZ','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',0,'','A','JO.','2008-10-18',NULL,'2008-10-18'),(57,1,3,'9999','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',0,'','A','JO.','2008-10-18','JO.','2008-10-18'),(58,1,3,'9999','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',0,'','A','JO.','2008-10-18','JO.','2008-10-18'),(59,1,3,'ZZZZ','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',0,'','A','JO.','2008-10-18',NULL,'2008-10-18'),(60,1,3,'9999','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',0,'','A','JO.','2008-10-18','JO.','2008-10-18'),(61,1,3,'9999','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',0,'','*','JO.','2008-10-18','JO.','2008-10-18'),(62,1,3,'ZZZZ','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',0,'','A','JO.','2008-10-18',NULL,'2008-10-18'),(63,1,3,'ZZZZ','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',0,'','*','JO.','2008-10-18',NULL,'2008-10-18'),(64,1,3,'ZZZZ','Piso 9','Hbtn. doble c/Vista Interna','50.00',2,'',0,'','*','JO.','2008-10-18',NULL,'2008-10-18');

/*Table structure for table `ctrlt_roomtype` */

DROP TABLE IF EXISTS `ctrlt_roomtype`;

CREATE TABLE `ctrlt_roomtype` (
  `MAINP_ID_HOTEL` smallint(2) unsigned NOT NULL,
  `RTYPP_ID_ROOM_TYPE` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `RTYPC_ROOM_TYPE` char(2) NOT NULL,
  `RTYPC_DESCRIPTION` varchar(20) NOT NULL,
  `RTYPC_RACK_RATE` decimal(6,2) NOT NULL,
  `RTYPC_QUANTITY_ROOMS` smallint(3) unsigned NOT NULL,
  `RTYPC_AVAILABLE_ROOMS` smallint(3) unsigned NOT NULL,
  `RTYPC_LOCKED_ROOMS` smallint(3) unsigned DEFAULT NULL,
  `RTYPC_STATUS` char(1) NOT NULL DEFAULT 'A',
  `RTYPC_MADE_BY` char(3) NOT NULL,
  `RTYPC_MADE_ON` date NOT NULL,
  `RTYPC_UPDATED_BY` char(3) NOT NULL,
  `RTYPC_LAST_UPDATE` date NOT NULL,
  PRIMARY KEY (`RTYPP_ID_ROOM_TYPE`,`MAINP_ID_HOTEL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ctrlt_roomtype` */

/*Table structure for table `ctrlt_roomtype_status` */

DROP TABLE IF EXISTS `ctrlt_roomtype_status`;

CREATE TABLE `ctrlt_roomtype_status` (
  `MAINP_ID_HOTEL` tinyint(1) unsigned NOT NULL,
  `RTYPP_ROOM_TYPE` char(2) NOT NULL DEFAULT '',
  `RTSTC_STATUS_DAY` date DEFAULT NULL,
  `RTSTC_TOTAL_ROOMS` smallint(3) DEFAULT NULL,
  `RTSTC_AVAILABLE_ROOMS` smallint(6) DEFAULT NULL,
  `RTSTC_TENTATIVE_ROOMS` smallint(6) DEFAULT NULL,
  `RTSTC_COMFIRMED_ROOMS` smallint(6) DEFAULT NULL,
  `RTSTC_LOCKED_ROOMS` smallint(6) DEFAULT NULL,
  `RTSTC_MAINTENANCE_ROOMS` smallint(6) DEFAULT NULL,
  `RTSTC_RESERVATION_TYPE` char(1) DEFAULT NULL COMMENT 'Individual or Group'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ctrlt_roomtype_status` */

insert  into `ctrlt_roomtype_status`(`MAINP_ID_HOTEL`,`RTYPP_ROOM_TYPE`,`RTSTC_STATUS_DAY`,`RTSTC_TOTAL_ROOMS`,`RTSTC_AVAILABLE_ROOMS`,`RTSTC_TENTATIVE_ROOMS`,`RTSTC_COMFIRMED_ROOMS`,`RTSTC_LOCKED_ROOMS`,`RTSTC_MAINTENANCE_ROOMS`,`RTSTC_RESERVATION_TYPE`) values (1,'SJ','2007-12-01',1,0,0,0,0,0,'I');

/*Table structure for table `ctrlt_season` */

DROP TABLE IF EXISTS `ctrlt_season`;

CREATE TABLE `ctrlt_season` (
  `MAINP_ID_HOTEL` smallint(2) DEFAULT NULL,
  `SEASC_MONTH` tinyint(2) DEFAULT NULL,
  `SEASC_SEASON` char(1) DEFAULT NULL,
  `SEASC_STATUS` char(1) DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlt_season` */

/*Table structure for table `ctrlt_segment` */

DROP TABLE IF EXISTS `ctrlt_segment`;

CREATE TABLE `ctrlt_segment` (
  `SEGMP_ID_SEGMENT` smallint(2) unsigned NOT NULL AUTO_INCREMENT,
  `MAINP_ID_HOTEL` smallint(2) unsigned NOT NULL,
  `SRCEF_ID_SOURCE` smallint(6) unsigned DEFAULT NULL,
  `SEGMC_DESCRIPTION` varchar(50) DEFAULT NULL,
  `SEGMC_MADE_BY` varchar(3) DEFAULT NULL,
  `SEGMC_MADE_ON` date DEFAULT NULL,
  `SEGMC_UPDATED_BY` varchar(3) DEFAULT NULL,
  `SEGMC_LAST_UPDATE` datetime DEFAULT NULL,
  `SEGMC_STATUS` char(1) DEFAULT 'A',
  PRIMARY KEY (`SEGMP_ID_SEGMENT`,`MAINP_ID_HOTEL`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlt_segment` */

insert  into `ctrlt_segment`(`SEGMP_ID_SEGMENT`,`MAINP_ID_HOTEL`,`SRCEF_ID_SOURCE`,`SEGMC_DESCRIPTION`,`SEGMC_MADE_BY`,`SEGMC_MADE_ON`,`SEGMC_UPDATED_BY`,`SEGMC_LAST_UPDATE`,`SEGMC_STATUS`) values (1,1,1,'BANK & FINANCIAL',NULL,NULL,NULL,NULL,'*'),(2,1,2,'TRAVEL AGENT',NULL,NULL,NULL,NULL,'A'),(3,1,3,'LABORATORY',NULL,NULL,NULL,NULL,'A'),(4,1,4,'INFORMATION & TECHNOLOGY',NULL,NULL,NULL,NULL,'A');

/*Table structure for table `ctrlt_source` */

DROP TABLE IF EXISTS `ctrlt_source`;

CREATE TABLE `ctrlt_source` (
  `SRCEP_ID_SOURCE` int(6) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Customer code. Assign by System',
  `SRCEC_SOURCE_NAME` varchar(50) NOT NULL DEFAULT '',
  `SRCEC_COMMERCIAL_NAME` varchar(30) DEFAULT NULL,
  `SRCEC_DOCUMENT_NUMBER` varchar(11) NOT NULL COMMENT 'Document of Identification',
  `SRCEC_STREET_TYPE` smallint(6) NOT NULL,
  `SRCEC_STREET_NAME` varchar(20) NOT NULL,
  `SRCEC_STREET_NUMBER` varchar(4) NOT NULL,
  `SRCEC_INTERIOR` varchar(4) DEFAULT NULL,
  `SRCEC_COMPLEMENT` varchar(20) DEFAULT NULL,
  `SRCEC_ID_DISTRICT` smallint(3) unsigned DEFAULT NULL,
  `SRCEC_ID_CITY` smallint(3) unsigned NOT NULL,
  `CTRYF_ID_COUNTRY` smallint(3) unsigned NOT NULL,
  `SRCEC_ZIP_CODE` varchar(10) DEFAULT NULL,
  `SRCEC_PHONE1` varchar(10) NOT NULL,
  `SRCEC_PHONE2` varchar(10) DEFAULT NULL,
  `SRCEC_WEB_PAGE` varchar(50) DEFAULT NULL,
  `SRCEC_ID_SEGMENT` smallint(4) unsigned NOT NULL COMMENT 'I=Industry, S=Service, F=Financial',
  `SRCEC_ID_TYPE` smallint(2) DEFAULT NULL COMMENT 'C=Company, G=Goverment, O=ONG, etc.',
  `SRECC_CATEGORY` char(1) DEFAULT NULL,
  `RATEF_ID_RATE` smallint(4) unsigned NOT NULL,
  `SRCEC_CREDIT_TYPE` varchar(2) DEFAULT NULL COMMENT 'Credit type (C1 = 10 dias)',
  `SRCEC_REGISTRATION_HOTEL` smallint(2) NOT NULL,
  `SRCEC_MADE_BY` char(3) NOT NULL,
  `SRCEC_MADE_ON` date NOT NULL,
  `SRCEC_UPDATED_BY` char(3) NOT NULL,
  `SRCEC_LAST_UPDATE` date NOT NULL,
  `SRCEC_STATUS` char(1) NOT NULL,
  PRIMARY KEY (`SRCEP_ID_SOURCE`),
  UNIQUE KEY `CTRL_IDX_SOURCE_DOCUMENT` (`SRCEC_DOCUMENT_NUMBER`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `ctrlt_source` */

insert  into `ctrlt_source`(`SRCEP_ID_SOURCE`,`SRCEC_SOURCE_NAME`,`SRCEC_COMMERCIAL_NAME`,`SRCEC_DOCUMENT_NUMBER`,`SRCEC_STREET_TYPE`,`SRCEC_STREET_NAME`,`SRCEC_STREET_NUMBER`,`SRCEC_INTERIOR`,`SRCEC_COMPLEMENT`,`SRCEC_ID_DISTRICT`,`SRCEC_ID_CITY`,`CTRYF_ID_COUNTRY`,`SRCEC_ZIP_CODE`,`SRCEC_PHONE1`,`SRCEC_PHONE2`,`SRCEC_WEB_PAGE`,`SRCEC_ID_SEGMENT`,`SRCEC_ID_TYPE`,`SRECC_CATEGORY`,`RATEF_ID_RATE`,`SRCEC_CREDIT_TYPE`,`SRCEC_REGISTRATION_HOTEL`,`SRCEC_MADE_BY`,`SRCEC_MADE_ON`,`SRCEC_UPDATED_BY`,`SRCEC_LAST_UPDATE`,`SRCEC_STATUS`) values (9,'ASIS TP S.A.','ASIS','20136424867',1,'MIGUEL DASSO','258',NULL,'204',1,0,1,'LIMA 28','2427799','3659988','www.asistp.com.pe',1,1,NULL,1,'1',1,'JO','2008-11-11','JO','2008-11-11','A'),(10,'TURISMO EL DORAL S.A.','APART HOTEL EL DORAL','20100970962',1,'MIGUEL DASSO','258','204','Block C',1,0,1,'LIMA 28','2427799','3659988','www.aparthoteleldoral.com.pe',1,1,'A',1,'1',1,'JO','2008-11-12','JO','2008-11-12','A');

/*Table structure for table `ctrlt_special_rate` */

DROP TABLE IF EXISTS `ctrlt_special_rate`;

CREATE TABLE `ctrlt_special_rate` (
  `SPRTP_ID_SPECIAL_RATE` smallint(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `MAINP_ID_HOTEL` smallint(2) unsigned NOT NULL,
  `SPRTC_DESCRIPTION` varchar(20) DEFAULT NULL,
  `SPRTC_STATUS` char(1) DEFAULT 'A',
  PRIMARY KEY (`SPRTP_ID_SPECIAL_RATE`,`MAINP_ID_HOTEL`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlt_special_rate` */

insert  into `ctrlt_special_rate`(`SPRTP_ID_SPECIAL_RATE`,`MAINP_ID_HOTEL`,`SPRTC_DESCRIPTION`,`SPRTC_STATUS`) values (0001,1,'FULL RATE','A'),(0002,1,'CONFIDENCIAL 1','A'),(0003,1,'CONFIDENCIAL 2','A'),(0004,1,'CONFIDENCIAL 3','A');

/*Table structure for table `ctrlt_stt_bill_charge` */

DROP TABLE IF EXISTS `ctrlt_stt_bill_charge`;

CREATE TABLE `ctrlt_stt_bill_charge` (
  `MAINP_ID_HOTEL` int(6) unsigned NOT NULL COMMENT 'HOTEL ID',
  `CUSTF_ID_CUSTOMER` int(6) unsigned NOT NULL COMMENT 'GUEST ID',
  `CUSTF_ID_ROOM` char(4) DEFAULT NULL COMMENT 'ROOM NUMBER',
  `CHGEP_BILL_NUMBER` int(6) unsigned NOT NULL COMMENT 'FOLIO ID',
  `CHGEP_SECUENCE` int(6) unsigned zerofill NOT NULL COMMENT 'SECUENCE NUMBER',
  `CHGEP_CHARGE_DATE` date NOT NULL COMMENT 'CHARGE DATE',
  `ACCTF_ID_ACCOUNT` int(6) unsigned NOT NULL COMMENT 'ACCOUNT ID',
  `CHGEP_AMOUNT_CHARGE` decimal(6,2) unsigned NOT NULL COMMENT 'AMOUNT CHARGE',
  `CHGEP_CHECK_TYPE` char(1) DEFAULT NULL COMMENT 'COMAND, VALE, OTHER',
  `CHGEP_CHECK_NUMBER` int(6) DEFAULT NULL COMMENT 'CHECK NUMBER',
  `CHGEP_MADE_ON` date DEFAULT NULL COMMENT 'MADE ON',
  `CHGEP_MADE_BY` char(3) DEFAULT NULL COMMENT 'MADE BY',
  `CHGEP_LAST_UPDATE` date DEFAULT NULL,
  `CHGEP_UPDATED_BY` char(3) DEFAULT NULL,
  `CHGEP_STATUS` char(1) DEFAULT 'A' COMMENT 'CHARGED, CORRECTED, ADJUSTED, ETC.',
  PRIMARY KEY (`MAINP_ID_HOTEL`,`CUSTF_ID_CUSTOMER`,`CHGEP_BILL_NUMBER`,`CHGEP_SECUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ctrlt_stt_bill_charge` */

insert  into `ctrlt_stt_bill_charge`(`MAINP_ID_HOTEL`,`CUSTF_ID_CUSTOMER`,`CUSTF_ID_ROOM`,`CHGEP_BILL_NUMBER`,`CHGEP_SECUENCE`,`CHGEP_CHARGE_DATE`,`ACCTF_ID_ACCOUNT`,`CHGEP_AMOUNT_CHARGE`,`CHGEP_CHECK_TYPE`,`CHGEP_CHECK_NUMBER`,`CHGEP_MADE_ON`,`CHGEP_MADE_BY`,`CHGEP_LAST_UPDATE`,`CHGEP_UPDATED_BY`,`CHGEP_STATUS`) values (1,1,'101',1,000001,'2008-02-15',111,'50.00','-',0,'2008-02-21','JO.',NULL,NULL,'A'),(1,1,'101',1,000002,'2008-02-15',121,'15.00','1',5124,'2008-02-20','JO.',NULL,NULL,'A'),(1,1,'101',1,000003,'2008-12-02',130,'20.00','2',3548,'2008-02-21','JO.',NULL,NULL,'A'),(1,1,'102',1,000004,'2008-02-17',111,'50.00','1',1234,'2008-02-23','0',NULL,NULL,'A'),(1,1,'102',1,000005,'2008-02-23',121,'34.00','1',435,'2008-02-23',NULL,NULL,NULL,'A'),(1,1,'102',1,000006,'2008-02-23',121,'34.00','1',435,'2008-02-23',NULL,NULL,NULL,'A'),(1,1,'103',2,000001,'0000-00-00',152,'5.00','-',0,'2008-02-20','JO.',NULL,NULL,'A'),(1,1,'103',2,000002,'0000-00-00',152,'12.00','-',0,'2008-02-20','JO.',NULL,NULL,'A'),(1,1,'103',2,000003,'0000-00-00',151,'0.50','-',0,'2008-02-20','JO.',NULL,NULL,'A');

/*Table structure for table `ctrlt_stt_guest_bill` */

DROP TABLE IF EXISTS `ctrlt_stt_guest_bill`;

CREATE TABLE `ctrlt_stt_guest_bill` (
  `MAINP_ID_HOTEL` tinyint(2) unsigned NOT NULL,
  `CUSTP_ID_CUSTOMER` int(6) NOT NULL DEFAULT '0',
  `BILLP_ID_BILL` int(6) unsigned zerofill NOT NULL,
  `BILLC_BILL_NUMBER` bigint(20) DEFAULT NULL,
  `BILLC_MADE_ON` date NOT NULL COMMENT 'Fecha de apertura de cuenta',
  `BILLC_BALANCE` decimal(10,2) DEFAULT NULL,
  `BILLC_INITIALS` char(3) DEFAULT NULL,
  `BILLC_STATUS` varchar(1) DEFAULT 'A',
  PRIMARY KEY (`MAINP_ID_HOTEL`,`CUSTP_ID_CUSTOMER`,`BILLP_ID_BILL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ctrlt_stt_guest_bill` */

insert  into `ctrlt_stt_guest_bill`(`MAINP_ID_HOTEL`,`CUSTP_ID_CUSTOMER`,`BILLP_ID_BILL`,`BILLC_BILL_NUMBER`,`BILLC_MADE_ON`,`BILLC_BALANCE`,`BILLC_INITIALS`,`BILLC_STATUS`) values (1,1,000001,NULL,'2008-02-15','203.00','JO.','A'),(1,1,000002,NULL,'2008-02-15','17.50','JO.','A');

/*Table structure for table `ctrlt_table_item` */

DROP TABLE IF EXISTS `ctrlt_table_item`;

CREATE TABLE `ctrlt_table_item` (
  `ITMTP_ID_ITEM` smallint(2) unsigned NOT NULL AUTO_INCREMENT,
  `ITMTP_ID_TABLE` smallint(2) unsigned NOT NULL,
  `ITMTP_ITEM_DESCRIPTION` char(20) DEFAULT NULL,
  `ITMTP__STATUS` char(1) DEFAULT 'A',
  PRIMARY KEY (`ITMTP_ID_ITEM`,`ITMTP_ID_TABLE`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ctrlt_table_item` */

insert  into `ctrlt_table_item`(`ITMTP_ID_ITEM`,`ITMTP_ID_TABLE`,`ITMTP_ITEM_DESCRIPTION`,`ITMTP__STATUS`) values (1,1,'DNI','A'),(1,2,'Mr.','A'),(1,3,'TENTATIVE','A'),(1,4,'AV.','A'),(2,1,'PASSPORT','A'),(2,2,'Mrs.','A'),(2,3,'CONFIRMED','A'),(2,4,'ST.','A'),(3,1,'CARNET','A'),(3,2,'Miss','A'),(4,2,'Ms.','A');

/* Trigger structure for table `ctrlt_reservation` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `TGRESERVATION_AI` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `TGRESERVATION_AI` AFTER INSERT ON `ctrlt_reservation` FOR EACH ROW BEGIN
		DECLARE occDay date;
		DECLARE quantity int;
		-- SET occDay = NEW.dArrival;
		-- SET quantity = 1;
		WHILE quantity <= NEW.RESVC_QUANTITY DO
		  SET occDay = NEW.RESVC_ARRIVAL;
		  REPEAT
			INSERT INTO CTRLT_OCCUPATION VALUES
			  (NEW.MAINP_ID_HOTEL,       NEW.RESVF_ID_ROOMTYPE,      occDay,
			   NEW.RESVP_ID_RESERVATION, NEW.RESVC_RESERVATION_TYPE, NEW.RESVC_QUANTITY,
			   NEW.RESVF_ID_ROOM,        NEW.RESVC_ADULTS,           NEW.RESVC_CHILDREN, NEW.RESVC_STATUS);
			SET occDay = adddate(occDay, INTERVAL 1 DAY);
		  UNTIL occDay >= NEW.RESVC_DEPARTURE
		  END REPEAT;
		  SET quantity = quantity + 1;
		END WHILE;
	END */$$


DELIMITER ;

/* Trigger structure for table `ctrlt_reservation` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `TGRESERVATION_AU` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `TGRESERVATION_AU` AFTER UPDATE ON `ctrlt_reservation` FOR EACH ROW BEGIN
		DECLARE occDay date;
		DECLARE quantity int;
		DELETE FROM CTRLT_OCCUPATION
         WHERE MAINP_ID_HOTEL = NEW.MAINP_ID_HOTEL
		   AND RESVP_ID_RESERVATION = NEW.RESVP_ID_RESERVATION;
		## Arrival MUST BE less than Departure !!
		SET quantity = 1;
		WHILE quantity <= NEW.RESVC_QUANTITY DO
		    SET occDay = NEW.RESVC_ARRIVAL;
		    REPEAT
			    INSERT INTO CTRLT_OCCUPATION
			         VALUES( NEW.MAINP_ID_HOTEL,
							 NEW.RESVF_ID_ROOMTYPE,
							 occDay,
							 NEW.RESVP_ID_RESERVATION,
							 NEW.RESVF_ID_ROOM,
							 NEW.RESVC_ADULTS,
							 NEW.RESVC_CHILDREN,
							 NEW.RESVC_STATUS );
				SET occDay = adddate(occDay, INTERVAL 1 DAY);
		    UNTIL occDay >= NEW.RESVC_DEPARTURE
		    END REPEAT;
		    SET quantity = quantity + 1;
		END WHILE;
	END */$$


DELIMITER ;

/* Procedure structure for procedure `CTRLPD_CITY` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPD_CITY` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_CITY`(
								 IN p_id_country int,
								 IN p_id_city int )
BEGIN
	DELETE FROM CTRLT_CITY
	 WHERE CTRYP_ID_COUNTRY = p_id_country
       AND CITYP_ID_CITY = p_id_city;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPD_COUNTRY` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPD_COUNTRY` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_COUNTRY`(
								 IN p_id_country int )
BEGIN
	DELETE FROM CTRLT_COUNTRY
	 WHERE CTRYP_ID_COUNTRY = p_id_country;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPD_CUSTOMER` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPD_CUSTOMER` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_CUSTOMER`(IN p_idCustomer varchar(06),
								 IN p_hotelRegistration varchar(03) )
BEGIN
	UPDATE CTRLT_CUSTOMER
	   SET CUSTC_STATUS = "*"
	 WHERE CUSTP_ID_CUSTOMER = p_idCustomer
	   AND CUSTC_REGISTRATION_HOTEL = p_hotelRegistration;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPD_GUEST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPD_GUEST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_GUEST`(
						IN idHotel int,
						IN idReservation int)
BEGIN
        DELETE FROM CTRLT_GUEST
		 WHERE MAINP_ID_HOTEL = idHotel AND RESVP_ID_RESERVATION = idReservation;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPD_RATE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPD_RATE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_RATE`(
								 IN p_id_hotel varchar(02),
								 IN p_id_rate  varchar(04) )
BEGIN
	DELETE FROM CTRLT_RATE
	 WHERE MAINP_ID_HOTEL  = p_id_hotel
	   AND RATEP_ID_SPECIAL_RATE = p_id_rate;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPD_RESERVATION` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPD_RESERVATION` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_RESERVATION`(
											IN id_hotel smallint,
											IN res_number int )
BEGIN
		-- DECLARE foo int default 0;
		-- DECLARE MYSQL_BUG CONDITION FOR SQLSTATE '21S01'; -- ER_WRONG_VALUE_COUNT 21S01
		DECLARE CONTINUE HANDLER FOR SQLSTATE '21S01' BEGIN END; 
		UPDATE CTRLT_RESERVATION
		-- DELETE FROM CTRLT_RESERVATION
		   SET RESVC_STATUS = '*'
		 WHERE MAINP_ID_HOTEL = id_hotel
		   AND RESVP_ID_RESERVATION = res_number;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPD_ROOM` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPD_ROOM` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_ROOM`(
								 IN p_id_hotel varchar(02),
								 IN p_id_room varchar(04) )
BEGIN
	UPDATE CTRLT_ROOM
	   SET ROOMC_STATUS = "*"
	 WHERE MAINP_ID_HOTEL  = p_id_hotel
	   AND ROOMP_ID_ROOM = p_id_room;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPD_ROOMTYPE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPD_ROOMTYPE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_ROOMTYPE`(
								 IN p_idHotel  varchar(02),
								 IN p_idRoomType varchar(02) )
BEGIN
	UPDATE CTRLT_ROOMTYPE
	   SET RTYPC_STATUS = "*"
	 WHERE MAINP_ID_HOTEL  = p_idHotel
	   AND RTYPP_ID_ROOM_TYPE = p_idRoomType;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPD_SEGMENT` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPD_SEGMENT` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_SEGMENT`(
								 IN p_id_hotel		varchar(02),
								 IN p_id_segment	varchar(02) )
BEGIN
	UPDATE CTRLT_SEGMENT
	   SET SEGMC_STATUS = "*"
	 WHERE MAINP_ID_HOTEL  = p_id_hotel
	   AND SEGMP_ID_SEGMENT = p_id_segment;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPD_SOURCE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPD_SOURCE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_SOURCE`(
					IN p_id_source varchar(06) )
BEGIN
	UPDATE CTRLT_SOURCE
	   SET SRCEC_STATUS = "*"
	 WHERE SRCEP_ID_SOURCE = p_id_source;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_CHARGE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_CHARGE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_CHARGE`(
					    IN p_idHotel		int,
						IN p_idCustomer		int,
						IN p_idBill			int,
						IN p_ChargeDate		varchar(10),
						IN p_idAccount		int,
						IN p_totalCharge	decimal,
						IN p_CheckType		int,
						IN p_CheckNumber	int,
						IN p_MadeBy			int,
						IN p_status			char(1) )
BEGIN
	declare v_secuence int default 0;
	SELECT max(nSecuence) + 1 INTO v_secuence
	  FROM stt_bill_charge
	 WHERE nIdHotel = p_idHotel
       AND nIdCustomer = p_idCustomer
       AND nIdBill = p_idBill;
    INSERT INTO stt_bill_charge(
			nIdHotel, nIdCustomer, nIdBill,	nSecuence,
			dChargeDate, nIdAccount, nTotalCharge, tCheckType,
			nCheckNumber, dMadeOn, tMadeBy, tStatus)
		VALUES(
			p_idHotel, p_idCustomer, p_idBill, v_secuence,
			STR_TO_DATE(p_chargeDate, '%d/%m/%Y'),
			p_idAccount, p_totalCharge, p_checkType,
			p_checkNumber, CURRENT_TIMESTAMP(), p_madeBy, p_status);
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_CITY` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_CITY` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_CITY`(
					   OUT p_id_city		int,
					    IN p_id_country		varchar(20),
						IN p_city_name		varchar(06),
						IN p_abbreviation	varchar(20) )
BEGIN
	INSERT INTO CTRLT_CITY(
			CTRYP_ID_COUNTRY,
			CITYC_CITY_NAME,
			CITYC_ABBREVIATION )
	VALUES( p_id_country,
			p_city_name,
			p_abbreviation );
	SET p_id_city = LAST_INSERT_ID();
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_COUNTRY` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_COUNTRY` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_COUNTRY`(
					   OUT p_id_country		int,
					    IN p_country_name	varchar(20),
						IN p_abbreviation	varchar(06),
						IN p_nationality	varchar(20) )
BEGIN
	DECLARE v_current_date date DEFAULT CURRENT_TIMESTAMP();
	INSERT INTO CTRLT_COUNTRY(
			CTRYC_COUNTRY_NAME,
			CTRYC_ABBREVIATION,
			CTRYC_NATIONALITY )
	VALUES( p_country_name,
			p_abbreviation,
			p_nationality );
	SET p_id_country = LAST_INSERT_ID();
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_GUEST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_GUEST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_GUEST`(
					    IN p_id_hotel			varchar(02),
						IN p_id_reservation		varchar(06),
						IN p_id_customer		varchar(06),
						IN p_status    			varchar(01) )
BEGIN
    INSERT INTO CTRLT_GUEST(
			MAINP_ID_HOTEL,
			RESVP_ID_RESERVATION,
			CUSTP_ID_CUSTOMER,
			GUESC_STATUS )
	VALUES(	p_id_hotel,
			p_id_reservation,
			p_id_customer,
			p_status );
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_RATE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_RATE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_RATE`(
					   OUT p_id_rate			int,
					    IN p_id_hotel			varchar(02),
						IN p_id_room_type		int,
						IN p_id_period			int,
						IN p_value				varchar(10),
						IN p_made_by			varchar(03),
						IN p_status				varchar(01) )
BEGIN
	DECLARE v_current_day date DEFAULT CURRENT_TIMESTAMP();
	INSERT INTO CTRLT_RATE(
			MAINP_ID_HOTEL,
			-- RATEP_ID_SPECIAL_RATE,
			RTYPF_ID_ROOM_TYPE,
			PERIF_ID_PERIOD,
			RATEC_VALUE,
			RATEC_MADE_BY,
			RATEC_MADE_ON,
			RATEC_UPDATED_BY,
			RATEC_LAST_UPDATE,
			RATEC_STATUS )
	VALUES( p_id_hotel,
			-- p_id_special_rate,
			p_id_room_type,
			p_id_period,
			p_value,
			p_made_by,
			v_current_day,
			p_made_by,
			v_current_day,
			p_status );
	SET p_id_rate = LAST_INSERT_ID();
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_ROOMTYPE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_ROOMTYPE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_ROOMTYPE`(
					   OUT p_id_room_type		int,
					    IN p_id_hotel			varchar(02),
						IN p_room_type			varchar(02),
						IN p_description		varchar(20),
						IN p_rack_rate			varchar(10),
						IN p_total_rooms		varchar(03),
						IN p_available_rooms	varchar(03),
						IN p_locked_rooms		varchar(03),
						IN p_made_by			varchar(03) )
BEGIN
	DECLARE v_current_date date default current_date();
    INSERT INTO CTRLT_ROOMTYPE(
			MAINP_ID_HOTEL,
			RTYPP_ID_ROOM_TYPE,
			RTYPC_ROOM_TYPE,
			RTYPC_DESCRIPTION,
			RTYPC_RACK_RATE,
			RTYPC_QUANTITY_ROOMS,
			RTYPC_AVAILABLE_ROOMS,
			RTYPC_LOCKED_ROOMS,
			-- RTYPC_STATUS,
			RTYPC_MADE_BY,
			RTYPC_MADE_ON,
			RTYPC_UPDATED_BY,
			RTYPC_LAST_UPDATE )
	VALUES(	p_id_hotel,
			null,
			p_room_type,
			p_description,
			p_rack_rate,
			p_total_rooms,
			p_available_rooms,
			p_locked_rooms,
			p_made_by,
			v_current_date,
			p_made_by,
			v_current_date );
	SET p_id_room_type = LAST_INSERT_ID();
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_SEGMENT` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_SEGMENT` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_SEGMENT`(
					   OUT p_id_segment		int,
					    IN p_id_hotel		varchar(02),
						IN p_id_source		varchar(06),
						IN p_description	varchar(50),
						IN p_made_by		varchar(03),
						IN p_status			varchar(01) )
BEGIN
	DECLARE v_current_date date DEFAULT current_date();
	INSERT INTO CTRLT_SEGMENT(
			MAINP_ID_HOTEL,
			SRCEF_ID_SOURCE,
			SEGMC_DESCRIPTION,
			SEGMC_MADE_BY,
			SEGMC_MADE_ON,
			SEGMC_UPDATED_BY,
			SEGMC_LAST_UPDATE,
			SEGMC_STATUS )
	VALUES( p_id_hotel,
			p_id_source,
			p_description,
			p_made_by,
			v_current_date,
			p_made_by,
			v_current_date,
			p_status );
	SET p_id_segment = LAST_INSERT_ID();
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_CUSTOMER` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_CUSTOMER` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_CUSTOMER`(
                       OUT p_last_insert_id     int, 
                       OUT p_error_type   		varchar(06), 
						IN p_lastname1			varchar(15),
						IN p_lastname2			varchar(15),
						IN p_firstnames			varchar(20),
						IN p_birthdate			varchar(10),
						IN p_nationality		varchar(02),
						IN p_title				varchar(03),
						IN p_document_type		varchar(02),
						IN p_document_number	varchar(12),
						IN p_street_type		varchar(02),
						IN p_street_name		varchar(30),
						IN p_street_number		varchar(04),
						IN p_interior_number	varchar(04),
						IN p_complements		varchar(20),
						IN p_district			varchar(15),
						IN p_city				varchar(15),
						IN p_id_country			varchar(02),
						IN p_zip_code			varchar(10),
						IN p_phone1				varchar(07),
						IN p_phone2				varchar(07),
						IN p_movil_phone		varchar(10),
						IN p_email				varchar(50),
						IN p_occupation			varchar(20),
						IN p_vip_status			varchar(01),
						IN p_requests			tinytext,
						IN p_hotel_registration	varchar(02),
						IN p_made_by			varchar(05) )
BEGIN
	declare v_current_date date default current_date();
	declare v_birthdate date;
	/* Continua luego de intentar registrar un documento de identidad duplicado */
	DECLARE ER_DUP_ENTRY CONDITION FOR SQLSTATE '23000'; -- ER_DUP_ENTRY 23000
	DECLARE CONTINUE HANDLER FOR ER_DUP_ENTRY SET p_error_type = '23000'; 
	-- TODO: test if
	if !strcmp(p_birthdate,'1971-08-12') then
	   set v_birthdate = 1969-12-31;
	else
	   set v_birthdate = STR_TO_DATE(p_birthDate,'%d/%m/%Y');
	end if;
    insert into CTRLT_CUSTOMER
		   (CUSTC_LASTNAME1,
			CUSTC_LASTNAME2,
			CUSTC_FIRSTNAME,
			CUSTC_BIRTHDATE,
			CUSTC_NATIONALITY,
			CUSTC_TITLE,
			CUSTF_DOCUMENT_TYPE,
			CUSTC_DOCUMENT_NUMBER,
			CUSTC_STREET_TYPE,
			CUSTC_STREET_NAME,
			CUSTC_STREET_NUMBER,
			CUSTC_INTERIOR_NUMBER,
			CUSTC_COMPLEMENTS,
			CUSTC_DISTRICT,
			CUSTC_CITY,
			CTRYF_ID_COUNTRY,
			CUSTC_ZIPCODE,
			CUSTC_PHONE1,
			CUSTC_PHONE2,
			CUSTC_MOVIL_PHONE,
			CUSTC_EMAIL,
			CUSTC_OCCUPATION,
			CUSTC_VIP_STATUS,
			CUSTC_SPECIAL_REQUESTS,
			CUSTC_REGISTRATION_HOTEL,
			CUSTC_MADE_BY,
			CUSTC_MADE_ON,
			CUSTC_UPDATED_BY,
			CUSTC_LAST_UPDATE,
			CUSTC_STATUS)
	values (p_lastname1,
			p_lastname2,
			p_firstnames,
			v_birthdate,
			p_nationality,
			p_title,
			p_document_type,
			p_document_number,
			p_street_type,
			p_street_name,
			p_street_number,
			p_interior_number,
			p_complements,
			p_district,
			p_city,
			p_id_country,
			p_zip_code,
			p_phone1,
			p_phone2,
			p_movil_phone,
			p_email,
			p_occupation,
			p_vip_status,
			p_requests,
			p_hotel_registration,
			p_made_by,
			v_current_date,
			p_made_by,
			v_current_date,
			'A');
     set p_last_insert_id = LAST_INSERT_ID();
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_RESERVATION` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_RESERVATION` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_RESERVATION`(
						OUT id_reservation int,
						IN id_hotel tinyint,
						IN reservation_type varchar(01),
						IN arrival varchar(10),
						IN departure varchar(10),
						IN nights tinyint,
						IN adults tinyint,
						IN children tinyint,
						IN room_type varchar(02),
						IN quantity_rooms tinyint,
						IN room_number varchar(04),
						
						IN vip_code tinyint,
						IN id_source smallint,
						IN room_rate decimal(10,2),
						IN total_room decimal(10,2),
						IN payment_due varchar(10),
						IN payment_type tinyint,
						IN voucher integer,
						IN hotel_instructions varchar(120),
						IN guest_instructions varchar(120),
						IN made_by varchar(03),
						IN update_by varchar(03),
						IN reservation_status varchar(01) )
BEGIN
		-- DECLARE v_id_reservation smallint;
		DECLARE v_current_date date DEFAULT CURRENT_TIMESTAMP();
        INSERT INTO CTRLT_RESERVATION(
			MAINP_ID_HOTEL,
			-- RESVP_ID_RESERVATION, -- Autoincremented
			RESVC_RESERVATION_TYPE,
			RESVC_ARRIVAL,
			RESVC_DEPARTURE,
			RESVC_NIGHTS,
			RESVC_ADULTS,
			RESVC_CHILDREN,
			RESVF_ID_ROOMTYPE,
			RESVC_QUANTITY,
			RESVF_ID_ROOM,
			SRCEF_ID_SOURCE,
			RESVC_ROOM_RATE,
			RESVC_TOTAL_ROOM,
			RESVC_PAYMENT_DUE,
			RESVF_PAYMENT_TYPE,
			RESVC_STATUS,
			RESVC_HOTEL_INSTRUCTIONS,
			RESVC_GUEST_INSTRUCTIONS,
			RESVC_MADE_BY,
			RESVC_MADE_ON,
			RESVC_UPDATED_BY,
			RESVC_LAST_UPDATE )
		VALUES(
			id_hotel,
			-- '', -- Autoincremented
			reservation_type,
			STR_TO_DATE(arrival, '%d/%m/%Y'),
			STR_TO_DATE(departure, '%d/%m/%Y'),
			nights,
			adults,
			children,
			room_type,
			quantity_rooms,
			room_number,
			id_source,
			room_rate,
			total_room,
			STR_TO_DATE(payment_due, '%d/%m/%Y'),
			payment_type,
			reservation_status,
			hotel_instructions,
			guest_instructions,
			made_by,
			v_current_date,
			made_by,
			v_current_date );
		-- SET reservationId = v_id_reservation;
		SET id_reservation = LAST_INSERT_ID();
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_ROOM` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_ROOM` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_ROOM`(
					   OUT p_id_room			int,
					    IN p_id_hotel			varchar(02),
						IN p_room_type			varchar(02),
						IN p_room_number		varchar(04),
						IN p_room_location		varchar(50),
						IN p_description		varchar(50),
						IN p_room_rate			varchar(10),
						IN p_max_beds			varchar(02),
						IN p_connection			varchar(04),
						IN p_id_reservation		varchar(06),
						IN p_hk_status			varchar(01),
						IN p_status				varchar(01),
						IN p_made_by			varchar(03) )
BEGIN
	DECLARE v_current_date date DEFAULT CURRENT_DATE();
	INSERT INTO CTRLT_ROOM(
			MAINP_ID_HOTEL,
			RTYPF_ID_ROOM_TYPE,
			ROOMC_ROOM_NUMBER,
			ROOMC_LOCATION,
			ROOMC_DESCRIPTION,
			ROOMC_ROOM_RATE,
			ROOMC_MAX_BEDS,
			ROOMC_CONNECTION,
			RESVC_ID_RESERVATION,
			ROOMC_HK_STATUS,
			ROOMC_STATUS,
			ROOMC_MADE_BY,
			ROOMC_MADE_ON,
			ROOMC_UPDATED_BY,
			ROOMC_LAST_UPDATE )
	VALUES( p_id_hotel,
			p_room_type,
			p_room_number,
			p_room_location,
			p_description,
			p_room_rate,
			p_max_beds,
			p_connection,
			p_id_reservation,
			p_hk_status,
			p_status,
			p_made_by,
			v_current_date,
			p_made_by,
			v_current_date);
	set p_id_room = LAST_INSERT_ID();
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_SOURCE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_SOURCE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_SOURCE`(
			out p_id_source 	  	 int,
			out p_error_type 	  	 varchar(06),
			 in	p_source_name 	  	 varchar(50),
			 in	p_commercial_name 	 varchar(50),
			 in	p_document_number 	 varchar(11),
			 in	p_street_type 	  	 varchar(02),
			 in	p_street_name	  	 varchar(30),
			 in	p_street_number   	 varchar(30),
			 in	p_interior		  	 varchar(04),
			 in	p_complement	  	 varchar(20),
			 in	p_id_district 	  	 varchar(02),
			 in	p_id_city 		  	 varchar(20),
			 in p_id_country 	  	 varchar(03),
			 in	p_zip_code 		  	 varchar(10),
			 in	p_phone1 		  	 varchar(10),
			 in	p_phone2 		  	 varchar(10),
			 in	p_web_page 		  	 varchar(50),
			 in	p_id_segment 	  	 varchar(02),
			 in	p_id_type 		  	 varchar(02),
			 in	p_category 		  	 varchar(01),
			 in	p_id_rate		  	 varchar(04),
			 in	p_credit_type 	  	 varchar(02),
			 in	p_registration_hotel varchar(03),
			 in	p_made_by 			 varchar(04),
			 in p_status 			 varchar(01) )
BEGIN
		DECLARE v_current_date date DEFAULT current_date();
		/* Continua luego de intentar registrar un numero de documento duplicado */
		DECLARE ER_DUP_ENTRY CONDITION FOR SQLSTATE '23000'; -- ER_DUP_ENTRY 23000
		DECLARE CONTINUE HANDLER FOR ER_DUP_ENTRY SET p_error_type = '23000'; 
		INSERT INTO CTRLT_SOURCE
			  (	SRCEP_ID_SOURCE,
				SRCEC_SOURCE_NAME,
				SRCEC_COMMERCIAL_NAME,
				SRCEC_DOCUMENT_NUMBER,
				SRCEC_STREET_TYPE,
				SRCEC_STREET_NAME,
				SRCEC_STREET_NUMBER,
				SRCEC_INTERIOR,
				SRCEC_COMPLEMENT,
				SRCEC_ID_DISTRICT,
				SRCEC_ID_CITY,
				CTRYF_ID_COUNTRY,
				SRCEC_ZIP_CODE,
				SRCEC_PHONE1,
				SRCEC_PHONE2,
				SRCEC_WEB_PAGE,
				SRCEC_ID_SEGMENT,
				SRCEC_ID_TYPE,
				SRECC_CATEGORY,
				RATEF_ID_RATE,
				SRCEC_CREDIT_TYPE,
				SRCEC_REGISTRATION_HOTEL,
				SRCEC_MADE_BY,
				SRCEC_MADE_ON,
				SRCEC_UPDATED_BY,
				SRCEC_LAST_UPDATE,
				SRCEC_STATUS )
		VALUES( p_id_source,
				p_source_name,
				p_commercial_name,
				p_document_number,
				p_street_type,
				p_street_name,
				p_street_number,
				p_interior,
				p_complement,
				p_id_district,
				p_id_city,
				p_id_country,
				p_zip_code,
				p_phone1,
				p_phone2,
				p_web_page,
				p_id_segment,
				p_id_type,
				p_category,
				p_id_rate,
				p_credit_type,
				p_registration_hotel,
				p_made_by,
				v_current_date,
				p_made_by,
				v_current_date,
				p_status );
		SET p_id_source = LAST_INSERT_ID();
    END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPI_STT_BILL_CHARGE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPI_STT_BILL_CHARGE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_STT_BILL_CHARGE`(
					    IN p_idHotel		int,
						IN p_idCustomer		int,
						IN p_idBill			int,
						IN p_ChargeDate		varchar(10),
						IN p_idAccount		int,
						IN p_totalCharge	decimal,
						IN p_CheckType		int,
						IN p_CheckNumber	int,
						IN p_MadeBy			int,
						IN p_status			char(1) )
BEGIN
	declare v_secuence int default 0;
	SELECT max(nSecuence) + 1 INTO v_secuence
	  FROM stt_bill_charge
	 WHERE nIdHotel = p_idHotel
       AND nIdCustomer = p_idCustomer
       AND nIdBill = p_idBill;
    INSERT INTO stt_bill_charge(
			nIdHotel, nIdCustomer, nIdBill,	nSecuence,
			dChargeDate, nIdAccount, nTotalCharge, tCheckType,
			nCheckNumber, dMadeOn, tMadeBy, tStatus)
		VALUES(
			p_idHotel, p_idCustomer, p_idBill, v_secuence,
			STR_TO_DATE(p_chargeDate, '%d/%m/%Y'),
			p_idAccount, p_totalCharge, p_checkType,
			p_checkNumber, CURRENT_TIMESTAMP(), p_madeBy, p_status);
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_AVAILABILITY_ROOMS` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_AVAILABILITY_ROOMS` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_AVAILABILITY_ROOMS`( IN p_idhotel char(1),
											    IN p_roomType char(2),
												IN p_startDate date,
												IN p_endDate date,
												IN p_status char(1) )
BEGIN
	declare a int;
	SELECT tRoomType, dOccupationDay, COUNT(dOccupationDay)
	  FROM occupation
	 WHERE nIdHotel = p_idhotel
	   AND tRoomType like if(p_roomType is null or p_roomType = '', '%', p_roomType)
	   AND dOccupationDay >= p_startDate
	   AND dOccupationDay <= p_endDate
       AND tStatus like if(p_status is null or p_status = '', '%', p_status)
	 GROUP BY tRoomType, dOccupationDay;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_AVAILABLE_STAY` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_AVAILABLE_STAY` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_AVAILABLE_STAY`(
		IN h INT,
		IN rt char(02),
		IN ad date,
		IN dd date )
BEGIN
	DECLARE a int;
	SELECT tRoomType, dOccupationDay, COUNT(dOccupationDay)
	  FROM occupation
	 WHERE nIdHotel = h
	   AND tRoomType = rt
	   AND dOccupationDay >= ad
	   AND dOccupationDay < dd
	GROUP BY dOccupationDay;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_CITY` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_CITY` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_CITY`(
								IN p_id_country int,
								IN p_id_city int )
BEGIN
	SELECT	CTRYP_ID_COUNTRY	ID_COUNTRY,
			CITYP_ID_CITY		ID_CITY,
			CITYC_CITY_NAME		CITY_NAME,
			CITYC_ABBREVIATION	ABBREVIATION
	  FROM CTRLT_CITY
	 WHERE p_id_country = CTRYP_ID_COUNTRY
       AND p_id_city = CITYP_ID_CITY;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_CITY_LIST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_CITY_LIST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_CITY_LIST`(
					IN p_id_country varchar(02) )
BEGIN
	SELECT	CTRYP_ID_COUNTRY 	ID_COUNTRY,
			CITYP_ID_CITY	 	ID_CITY,
			CITYC_CITY_NAME	 	CITY_NAME,
			CITYC_ABBREVIATION	ABBREVIATION
	  FROM CTRLT_CITY
     WHERE p_id_country = '' OR CTRYP_ID_COUNTRY = p_id_country;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_COUNTRY` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_COUNTRY` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_COUNTRY`(
								IN p_id_country int )
BEGIN
	SELECT	CTRYP_ID_COUNTRY	ID_COUNTRY,
			CTRYC_COUNTRY_NAME	COUNTRY_NAME,
			CTRYC_ABBREVIATION	ABBREVIATION,
			CTRYC_NATIONALITY	NATIONALITY
	  FROM CTRLT_COUNTRY
	 WHERE p_id_country = CTRYP_ID_COUNTRY;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_COUNTRY_LIST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_COUNTRY_LIST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_COUNTRY_LIST`(
					IN p_pattern varchar(02) )
BEGIN
	SELECT	CTRYP_ID_COUNTRY	ID_COUNTRY,
			CTRYC_COUNTRY_NAME	COUNTRY_NAME,
			CTRYC_ABBREVIATION	ABBREVIATION,
			CTRYC_NATIONALITY	NATIONALITY
	  FROM CTRLT_COUNTRY;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_CUSTOMER` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_CUSTOMER` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_CUSTOMER`(
			IN p_id_hotel			varchar(02),
			IN p_id_customer		varchar(06),
			IN p_document_number 	varchar(12),
			IN p_status				varchar(01) )
BEGIN
	DECLARE EMPTY varchar(01) DEFAULT '';
	-- REFACTOR
	-- tempo sentences
	IF p_id_customer IS NULL THEN
		SET p_id_customer = EMPTY;
	END IF;
	IF p_document_number IS NULL THEN
		SET p_document_number = EMPTY;
	END IF;
	IF p_status IS NULL THEN
		SET p_status = EMPTY;
	END IF;
	-- end tempo sentences
	SELECT	CUSTP_ID_CUSTOMER		id_customer,
			CUSTC_LASTNAME1			lastname1,
			CUSTC_LASTNAME2			lastname2,
			CUSTC_FIRSTNAME			firstname,
			DATE_FORMAT(CUSTC_BIRTHDATE,'%d/%m/%Y')
									birthdate,
			CUSTC_NATIONALITY 		nationality,
			CUSTC_TITLE 			title, -- Mr., Miss, etc.
			CUSTF_DOCUMENT_TYPE 	document_type,
			CUSTC_DOCUMENT_NUMBER 	document_number,
			CUSTC_STREET_TYPE 		street_type,
			CUSTC_STREET_NAME 		street_name,
			CUSTC_STREET_NUMBER		street_number,
			CUSTC_INTERIOR_NUMBER	interior_number,
			CUSTC_COMPLEMENTS 		complements,
			CUSTC_DISTRICT 			district,
			CUSTC_CITY 				city,
			CTRYF_ID_COUNTRY 		id_country,
			CUSTC_ZIPCODE 			zip_code,
			CUSTC_PHONE1 			phone1,
			CUSTC_PHONE2 			phone2,
			CUSTC_MOVIL_PHONE		movil_phone,
			CUSTC_EMAIL 			email,
			CUSTC_OCCUPATION 		occupation,
			CUSTC_VIP_STATUS 		vip,
			CUSTC_SPECIAL_REQUESTS 	requests,
			CUSTC_REGISTRATION_HOTEL hotel_registration,
			CUSTC_MADE_BY 			made_by,
			DATE_FORMAT(CUSTC_MADE_ON,'%d/%m/%Y')
									made_on,
			CUSTC_UPDATED_BY 		updated_by,
			DATE_FORMAT(CUSTC_LAST_UPDATE,'%d/%m/%Y')
									last_update,
			CUSTC_STATUS 			status
	  FROM CTRLT_CUSTOMER c
			LEFT JOIN ctrlt_country ct
					  ON c.CUSTC_NATIONALITY = ct.CTRYP_ID_COUNTRY
	 WHERE ( ( p_id_customer = CUSTP_ID_CUSTOMER AND p_document_number = EMPTY )
			 OR ( p_document_number = CUSTC_DOCUMENT_NUMBER AND p_id_customer = EMPTY ) )
	   AND ( p_status = EMPTY OR p_status = CUSTC_STATUS );
    END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_CUSTOMER_LIST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_CUSTOMER_LIST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_CUSTOMER_LIST`(
					IN p_idHotel INT, IN param VARCHAR(25) )
BEGIN
	declare v_param varchar(26);
	declare DOCUMENT_TYPE_TABLE smallint DEFAULT 1;
	declare TITLE_TABLE smallint DEFAULT 2;
	
	SET v_param = concat(param,'%');
	SELECT	CUSTP_ID_CUSTOMER		id_customer,
			CUSTC_LASTNAME1			lastname1,
			CUSTC_LASTNAME2			lastname2,
			CUSTC_FIRSTNAME			firstname,
			DATE_FORMAT(CUSTC_BIRTHDATE,'%d/%m/%Y')
									birthdate,
			ct.CTRYC_NATIONALITY 	nationality,
			t.ITMTP_ITEM_DESCRIPTION
									title, -- Mr., Miss, etc.
			dt.ITMTP_ITEM_DESCRIPTION
									document_type,
			CUSTC_DOCUMENT_NUMBER 	document_number,
			CUSTC_STREET_TYPE 		street_type,
			CUSTC_STREET_NAME 		street_name,
			CUSTC_STREET_NUMBER		street_number,
			CUSTC_INTERIOR_NUMBER	interior_number,
			CUSTC_COMPLEMENTS 		complements,
			CUSTC_DISTRICT 			district,
			CUSTC_CITY 				city,
			ct.CTRYC_COUNTRY_NAME	country_name,
			CUSTC_ZIPCODE 			zip_code,
			CUSTC_PHONE1 			phone1,
			CUSTC_PHONE2 			phone2,
			CUSTC_MOVIL_PHONE		movil_phone,
			CUSTC_EMAIL 			email,
			CUSTC_OCCUPATION 		occupation,
			CUSTC_VIP_STATUS 		vip,
			CUSTC_SPECIAL_REQUESTS 	requests,
			CUSTC_REGISTRATION_HOTEL hotel_registration,
			CUSTC_MADE_BY 			made_by,
			DATE_FORMAT(CUSTC_MADE_ON,'%d/%m/%Y')
									made_on,
			CUSTC_UPDATED_BY 		updated_by,
			DATE_FORMAT(CUSTC_LAST_UPDATE,'%d/%m/%Y')
									last_update,
			CUSTC_STATUS 			status
	  FROM CTRLT_CUSTOMER c
			LEFT JOIN ctrlt_country ct
					  ON c.CUSTC_NATIONALITY = ct.CTRYP_ID_COUNTRY
			LEFT JOIN ctrlt_table_item t
					  ON c.CUSTF_DOCUMENT_TYPE = t.ITMTP_ID_ITEM
						 AND t.ITMTP_ID_TABLE = TITLE_TABLE
			LEFT JOIN ctrlt_table_item dt
					  ON c.CUSTF_DOCUMENT_TYPE = dt.ITMTP_ID_ITEM
						 AND dt.ITMTP_ID_TABLE = DOCUMENT_TYPE_TABLE
	 WHERE c.CUSTC_REGISTRATION_HOTEL = p_idHotel
	   AND c.CUSTC_LASTNAME1 LIKE v_param
     ORDER BY c.CUSTC_LASTNAME1;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_GUEST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_GUEST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_GUEST`(
							IN p_id_hotel varchar(02),
							IN p_id_reservation varchar(06),
							IN p_status  varchar(01) )
BEGIN
		SELECT 	MAINP_ID_HOTEL			ID_HOTEL,
				RESVP_ID_RESERVATION	ID_RESERVATION,
				g.CUSTP_ID_CUSTOMER		ID_CUSTOMER,
				c.CUSTC_DOCUMENT_NUMBER	DOCUMENT_NUMBER,
				CONCAT(c.CUSTC_LASTNAME1, ', ', c.CUSTC_FIRSTNAME)
										CUSTOMER_NAMES,
				GUESC_STATUS			STATUS
		  FROM CTRLT_GUEST g
				LEFT JOIN CTRLT_CUSTOMER c ON g.CUSTP_ID_CUSTOMER = c.CUSTP_ID_CUSTOMER
		 WHERE p_id_hotel = MAINP_ID_HOTEL
		   AND p_id_reservation = RESVP_ID_RESERVATION;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_GUEST_LIST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_GUEST_LIST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_GUEST_LIST`(
							IN p_idHotel varchar(02),
							IN p_status  varchar(01) )
BEGIN
		SELECT 	MAINP_ID_HOTEL			ID_HOTEL,
				RESVP_ID_RESERVATION	ID_RESERVATION,
				g.CUSTP_ID_CUSTOMER		ID_CUSTOMER,
				c.CUSTC_DOCUMENT_NUMBER	DOCUMENT_NUMBER,
				CONCAT(c.CUSTC_LASTNAME1, ', ', c.CUSTC_FIRSTNAME)
										CUSTOMER_NAMES,
				GUESC_STATUS			STATUS
		  FROM CTRLT_GUEST g
				LEFT JOIN CTRLT_CUSTOMER c ON g.CUSTP_ID_CUSTOMER = c.CUSTP_ID_CUSTOMER
		 WHERE p_idHotel = MAINP_ID_HOTEL
		   AND ( p_status = '' OR p_status = g.GUESC_STATUS );
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_RATE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_RATE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_RATE`(
								IN p_id_hotel	varchar(02),
								IN p_id_rate	varchar(04),
								IN p_status		varchar(01) )
BEGIN
	SELECT	MAINP_ID_HOTEL			ID_HOTEL,
			RTYPF_ID_ROOM_TYPE		ID_ROOM_TYPE,
			PERIF_ID_PERIOD			ID_PERIOD,
			RATEP_ID_SPECIAL_RATE	ID_SPECIAL_RATE,
			RATEC_VALUE				VALUE,
			RATEC_MADE_BY			MADE_BY,
			RATEC_MADE_ON			MADE_ON,
			RATEC_UPDATED_BY 		UPDATED_BY,
			RATEC_LAST_UPDATE 		LAST_UPDATE,
			RATEC_STATUS 			STATUS
	  FROM CTRLT_RATE
	 WHERE p_id_hotel = MAINP_ID_HOTEL
	   AND p_id_rate  = RATEP_ID_SPECIAL_RATE
	   AND ( p_status = '' OR p_status = RATEC_STATUS );
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_RATE_LIST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_RATE_LIST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_RATE_LIST`(
					IN p_id_hotel varchar(02) )
BEGIN
	SELECT	MAINP_ID_HOTEL			ID_HOTEL,
			RATEP_ID_SPECIAL_RATE	ID_SPECIAL_RATE,
			RTYPF_ID_ROOM_TYPE		ID_ROOM_TYPE,
			PERIF_ID_PERIOD			ID_PERIOD,
			RATEC_VALUE				VALUE,
			RATEC_MADE_BY			MADE_BY,
			RATEC_MADE_ON			MADE_ON,
			RATEC_UPDATED_BY 		UPDATED_BY,
			RATEC_LAST_UPDATE 		LAST_UPDATE,
			RATEC_STATUS 			STATUS
	  FROM CTRLT_RATE
	 WHERE p_id_hotel = MAINP_ID_HOTEL
	   AND RATEC_STATUS = 'A';
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_RESERVATION` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_RESERVATION` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_RESERVATION`(
			IN p_id_hotel varchar(01),
			IN p_id_reservation varchar(06) )
BEGIN
	SELECT  MAINP_ID_HOTEL			ID_HOTEL,
			RESVP_ID_RESERVATION	ID_RESERVATION,
			RESVC_RESERVATION_TYPE	RESERVATION_TYPE,
			DATE_FORMAT(RESVC_ARRIVAL,'%d/%m/%Y')
									ARRIVAL,
			DATE_FORMAT(RESVC_DEPARTURE,'%d/%m/%Y')
									DEPARTURE,
			RESVC_NIGHTS 			NIGHTS,
			RESVC_ADULTS 			ADULTS,
			RESVC_CHILDREN 			CHILDREN,
			RESVF_ID_ROOMTYPE 		ID_ROOMTYPE,
			RESVC_QUANTITY 			QUANTITY,
			RESVF_ID_ROOM		 	ID_ROOM,
			RESVC_VIP_CODE 			VIP_CODE,
			SRCEF_ID_SOURCE			ID_SOURCE,
			RESVC_ROOM_RATE 		ROOM_RATE,
			RESVC_TOTAL_ROOM 		TOTAL_ROOM, -- Total a pagar x alojamiento
			case when DATE_FORMAT(RESVC_PAYMENT_DUE,'%d/%m/%Y') = 0 then '' else RESVC_PAYMENT_DUE end
									PAYMENT_DUE,
			RESVF_PAYMENT_TYPE		PAYMENT_TYPE,
			RESVC_VOUCHER			VOUCHER,
			RESVC_HOTEL_INSTRUCTIONS	HOTEL_INSTRUCTIONS,
			RESVC_GUEST_INSTRUCTIONS	GUEST_INSTRUCTIONS,
			RESVC_MADE_BY				MADE_BY,
			DATE_FORMAT(RESVC_MADE_ON,'%d/%m/%Y')
									MADE_ON,
			RESVC_UPDATED_BY 		UPDATED_BY,
			DATE_FORMAT(RESVC_LAST_UPDATE,'%d/%m/%Y')
									LAST_UPDATE,
			RESVC_STATUS			STATUS
	  FROM CTRLT_RESERVATION
	 WHERE MAINP_ID_HOTEL = p_id_hotel
	   AND RESVP_ID_RESERVATION = p_id_reservation;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_RESERVATION_FILTER` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_RESERVATION_FILTER` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_RESERVATION_FILTER`(
				    IN p_idHotel tinyint,
				    IN p_condition varchar(50) )
BEGIN
	DECLARE v_condition varchar(50);
	SET v_condition = CONCAT("nIdReservation ", p_condition);
	SELECT COUNT(*)
	  FROM reservation
	 WHERE MAINP_ID_HOTEL = p_idHotel AND v_condition;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_RESERVATION_GUEST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_RESERVATION_GUEST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_RESERVATION_GUEST`(
							IN p_idHotel		varchar(02),
							IN p_idReservation 	varchar(06),
							IN p_status			varchar(01) )
BEGIN
	SELECT 	nIdHotel			idHotel,
			nIdReservation		idReservation,
			rg.nIdCustomer		idCustomer,
			c.tDocumentNumber	documentNumber,
			CONCAT(c.tLastName1, ', ', c.tFirstNames)
								customerNames,
			rg.tStatus			status
	  FROM reservation_guest rg
			LEFT JOIN customer c ON rg.nIdCustomer = c.nIdCustomer
	 WHERE p_idHotel = rg.nIdHotel
	   AND p_idReservation = rg.nIdReservation;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_RESERVATION_LIST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_RESERVATION_LIST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_RESERVATION_LIST`(
					IN idHotel INT, IN param VARCHAR(255) )
BEGIN
	SELECT 	r.nIdHotel          idHotel,
			r.nIdReservation    idReservation,
			tReservationType    reservationTYpe,
			DATE_FORMAT(dArrival,'%d/%m/%Y')
								arrival,
			DATE_FORMAT(dDeparture,'%d/%m/%Y')
								departure,
			nNights             nights,
			nAdults             adults,
			nChildren           children,
			rt.tDescription     roomType,
			nQuantity           quantity,
			nIdRoom             roomNumber,
			tVipCode            vipCode,
			nIdSource           idSource,
			nRoomRate           roomRate,
			nTotalRoom          totalRoom,
			DATE_FORMAT(dPaymentDue,'%d/%m/%Y')
								paymentDue,
			nPaymentType        paymentType,
			tVoucher            voucher,
			tHotelInstructions  hotelInstructions,
			tGuestInstructions  guestInstructions,
			r.tMadeBy             madeBy,
			DATE_FORMAT(r.dMadeOn,'%d/%m/%Y')
								madeOn,
			tUpdatedBy          updateBy,
			DATE_FORMAT(dLastUpdate,'%d/%m/%Y')
								lastUpdate,
			r.tStatus             status
       FROM reservation r
            LEFT JOIN roomtype rt
                   ON r.nIdRoomType = rt.nIdRoomType
			LEFT JOIN reservation_guest  g
				   ON r.nIdHotel = g.nIdHotel
				  AND r.nIdReservation = g.nIdReservation
			LEFT JOIN customer  c
				   ON g.nIdHotel = c.nHotelRegistration
				  AND g.nIdCustomer = c.nIdCustomer
	 WHERE r.nIdHotel = idHotel AND c.tLastName1 LIKE concat(param,'%')
	 ORDER BY r.nIdReservation;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_ROOM` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_ROOM` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_ROOM`(
								IN p_id_hotel	varchar(02),
								IN p_id_room	varchar(04) )
BEGIN
	SELECT	ROOMP_ID_ROOM		ID_ROOM,
			MAINP_ID_HOTEL		ID_HOTEL,
			RTYPF_ID_ROOM_TYPE	ID_ROOM_TYPE,
			ROOMC_ROOM_NUMBER	ROOM_NUMBER,
			ROOMC_DESCRIPTION	DESCRIPTION,
			ROOMC_LOCATION		LOCATION,
			ROOMC_ROOM_RATE		ROOM_RATE,
			ROOMC_MAX_BEDS		MAX_BEDS,
			ROOMC_CONNECTION	ROOM_CONNECTION,
			RESVC_ID_RESERVATION ID_RESERVATION,
			ROOMC_HK_STATUS 	HK_STATUS,
			ROOMC_STATUS 		STATUS,
			ROOMC_MADE_BY		MADE_BY,
			ROOMC_MADE_ON		MADE_ON,
			ROOMC_UPDATED_BY	UPDATED_BY,
			ROOMC_LAST_UPDATE	LAST_UPDATE
	  FROM CTRLT_ROOM
	 WHERE p_id_hotel = MAINP_ID_HOTEL
	   AND p_id_room  = ROOMP_ID_ROOM;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_ROOMTYPE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_ROOMTYPE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_ROOMTYPE`(
								IN p_idHotel	varchar(02),
								IN p_idRoomType	varchar(02),
								IN p_status		varchar(01) )
BEGIN
	SELECT MAINP_ID_HOTEL		 ID_HOTEL,
	       RTYPP_ID_ROOM_TYPE	 ID_ROOM_TYPE,
	       RTYPC_ROOM_TYPE		 ROOM_TYPE,
		   RTYPC_DESCRIPTION	 DESCRIPTION,
		   RTYPC_RACK_RATE		 RACK_RATE,
		   RTYPC_QUANTITY_ROOMS	 QUANTITY_ROOMS,
		   RTYPC_AVAILABLE_ROOMS AVAILABLE_ROOMS,
		   RTYPC_LOCKED_ROOMS	 LOCKED_ROOMS,
		   RTYPC_STATUS 		 STATUS,
		   RTYPC_MADE_BY		 MADE_BY,
		   RTYPC_MADE_ON		 MADE_ON,
		   RTYPC_UPDATED_BY		 UPDATED_BY,
		   RTYPC_LAST_UPDATE	 LAST_UPDATE
	  FROM CTRLT_ROOMTYPE
	 WHERE p_idHotel  = MAINP_ID_HOTEL
	   AND p_idRoomType = RTYPP_ID_ROOM_TYPE
	   AND ( p_status = '' OR p_status = RTYPC_STATUS );
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_ROOMTYPE_LIST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_ROOMTYPE_LIST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_ROOMTYPE_LIST`(
					IN p_id_Hotel varchar(02),
					IN p_status   varchar(01) )
BEGIN
	SELECT MAINP_ID_HOTEL		 ID_HOTEL,
	       RTYPP_ID_ROOM_TYPE	 ID_ROOM_TYPE,
	       RTYPC_ROOM_TYPE		 ROOM_TYPE,
		   RTYPC_DESCRIPTION	 DESCRIPTION,
		   RTYPC_RACK_RATE		 RACK_RATE,
		   RTYPC_QUANTITY_ROOMS	 QUANTITY_ROOMS,
		   RTYPC_AVAILABLE_ROOMS AVAILABLE_ROOMS,
		   RTYPC_LOCKED_ROOMS	 LOCKED_ROOMS,
		   RTYPC_STATUS 		 STATUS,
		   RTYPC_MADE_BY		 MADE_BY,
		   RTYPC_MADE_ON		 MADE_ON,
		   RTYPC_UPDATED_BY		 UPDATED_BY,
		   RTYPC_LAST_UPDATE	 LAST_UPDATE
	  FROM CTRLT_ROOMTYPE rt
	 WHERE p_id_hotel = MAINP_ID_HOTEL
	   AND ( p_status = '' OR RTYPC_STATUS = p_status );
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_SEGMENT` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_SEGMENT` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_SEGMENT`(
								IN p_id_hotel	varchar(02),
								IN p_id_segment	varchar(02) )
BEGIN
	SELECT	SEGMP_ID_SEGMENT	ID_SEGMENT,
			MAINP_ID_HOTEL		ID_HOTEL,
			SRCEF_ID_SOURCE		ID_SOURCE,
			SEGMC_DESCRIPTION	DESCRIPTION,
			SEGMC_MADE_BY		MADE_BY,
			SEGMC_MADE_ON		MADE_ON,
			SEGMC_UPDATED_BY	UPDATED_BY,
			SEGMC_LAST_UPDATE	LAST_UPDATE,
			SEGMC_STATUS 		STATUS
	  FROM CTRLT_SEGMENT
	 WHERE p_id_hotel = MAINP_ID_HOTEL
	   AND p_id_segment  = SEGMP_ID_SEGMENT;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_ROOM_LIST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_ROOM_LIST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_ROOM_LIST`(
		IN p_id_hotel		varchar(02),
		IN p_id_room_type	varchar(03),
		IN p_status			varchar(02) )
BEGIN
	SELECT	MAINP_ID_HOTEL			MAINP_ID_HOTEL,
			ROOMP_ID_ROOM			ROOMP_ID_ROOM,
			RTYPF_ID_ROOM_TYPE		RTYPF_ID_ROOM_TYPE,
			ROOMC_ROOM_NUMBER		ROOM_NUMBER,
			ROOMC_LOCATION			LOCATION,
			ROOMC_DESCRIPTION		DESCRIPTION,
			ROOMC_ROOM_RATE			ROOM_RATE,
			ROOMC_MAX_BEDS			MAX_BEDS,
			ROOMC_CONNECTION		ROOM_CONNECTION,
			RESVC_ID_RESERVATION 	RESVC_ID_RESERVATION,
			ROOMC_HK_STATUS			HK_STATUS,
			ROOMC_STATUS			STATUS,
			ROOMC_MADE_BY			MADE_BY,
			ROOMC_MADE_ON			MADE_ON,
			ROOMC_UPDATED_BY		UPDATED_BY,
			ROOMC_LAST_UPDATE		LAST_UPDATE
	  FROM CTRLT_ROOM
	 WHERE p_id_hotel = MAINP_ID_HOTEL
	   AND ( p_id_room_type = ''
			 OR p_id_room_type = RTYPF_ID_ROOM_TYPE )
	   AND ( p_status = ''
			 OR p_status = ROOMC_STATUS );
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_SEGMENT_LIST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_SEGMENT_LIST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_SEGMENT_LIST`(
					IN p_id_hotel	varchar(02),
					IN p_status		varchar(01) )
BEGIN
	SELECT	MAINP_ID_HOTEL		ID_HOTEL,
			SEGMP_ID_SEGMENT	ID_SEGMENT,
			SRCEF_ID_SOURCE		ID_SOURCE,
			SEGMC_DESCRIPTION	DESCRIPTION,
			SEGMC_MADE_BY		MADE_BY,
			SEGMC_MADE_ON		MADE_ON,
			SEGMC_UPDATED_BY	UPDATED_BY,
			SEGMC_LAST_UPDATE	LAST_UPDATE,
			SEGMC_STATUS 		STATUS
	  FROM CTRLT_SEGMENT
	 WHERE p_id_hotel = MAINP_ID_HOTEL
	   AND ( p_status = '' OR p_status = SEGMC_STATUS );
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_SOURCE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_SOURCE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_SOURCE`(
								IN p_id_source	varchar(06),
								IN p_id_hotel	varchar(02),
								IN p_status		varchar(01) )
BEGIN
	SELECT	SRCEP_ID_SOURCE			ID_SOURCE,
	      	SRCEC_SOURCE_NAME		SOURCE_NAME,
			SRCEC_COMMERCIAL_NAME	COMMERCIAL_NAME,
			SRCEC_DOCUMENT_NUMBER	DOCUMENT_NUMBER,
			SRCEC_STREET_TYPE		STREET_TYPE,
			SRCEC_STREET_NAME		STREET_NAME,
			SRCEC_STREET_NUMBER		STREET_NUMBER,
			SRCEC_INTERIOR			INTERIOR,
			SRCEC_COMPLEMENT		COMPLEMENT,
			SRCEC_ID_DISTRICT		ID_DISTRICT,
			SRCEC_ID_CITY			ID_CITY,
			CTRYF_ID_COUNTRY		ID_COUNTRY,
			SRCEC_ZIP_CODE 			ZIP_CODE,
			SRCEC_PHONE1 			PHONE1,
			SRCEC_PHONE2 			PHONE2,
			SRCEC_WEB_PAGE			WEB_PAGE,
			SRCEC_ID_SEGMENT 		ID_SEGMENT,
			SRCEC_ID_TYPE 			ID_TYPE,
			SRECC_CATEGORY			CATEGORY,
			RATEF_ID_RATE 			ID_RATE,
			SRCEC_CREDIT_TYPE 		CREDIT_TYPE,
			SRCEC_REGISTRATION_HOTEL	REGISTRATION_HOTEL,
			SRCEC_MADE_BY 			MADE_BY,
			SRCEC_MADE_ON 			MADE_ON,
			SRCEC_UPDATED_BY 		UPDATED_BY,
			SRCEC_LAST_UPDATE 		LAST_UPDATE,
			SRCEC_STATUS 			STATUS
	  FROM CTRLT_SOURCE
	 WHERE p_id_source = SRCEP_ID_SOURCE
	   AND ( p_id_hotel = '' OR p_id_hotel = SRCEC_REGISTRATION_HOTEL )
	   AND ( p_status = '' OR p_status = SRCEC_STATUS );
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_SOURCE_LIST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_SOURCE_LIST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_SOURCE_LIST`(
								IN p_id_hotel			varchar(02),
								IN p_source_name		varchar(40),
								IN p_commercial_name	varchar(40),
								IN p_status				varchar(01) )
BEGIN
	DECLARE v_source_name varchar(41) DEFAULT concat(p_source_name,'%');
	DECLARE v_commercial_name varchar(41) DEFAULT concat(p_commercial_name,'%');
	SELECT	SRCEP_ID_SOURCE				ID_SOURCE,
			SRCEC_SOURCE_NAME			SOURCE_NAME,
			SRCEC_COMMERCIAL_NAME		COMMERCIAL_NAME,
			SRCEC_DOCUMENT_NUMBER		DOCUMENT_NUMBER,
			SRCEC_STREET_TYPE			STREET_TYPE,
			SRCEC_STREET_NAME			STREET_NAME,
			SRCEC_STREET_NUMBER			STREET_NUMBER,
			SRCEC_INTERIOR				INTERIOR,
			SRCEC_COMPLEMENT			COMPLEMENT,
			SRCEC_ID_DISTRICT			ID_DISTRICT,
			SRCEC_ID_CITY				ID_CITY,
			CTRYF_ID_COUNTRY			ID_COUNTRY,
			SRCEC_ZIP_CODE 				ZIP_CODE,
			SRCEC_PHONE1				PHONE1,
			SRCEC_PHONE2				PHONE2,
			SRCEC_WEB_PAGE				WEB_PAGE,
			SRCEC_ID_SEGMENT 			ID_SEGMENT,
			SRCEC_ID_TYPE 				ID_TYPE,
			SRECC_CATEGORY				CATEGORY,
			RATEF_ID_RATE 				ID_RATE,
			SRCEC_CREDIT_TYPE 			CREDIT_TYPE,
			SRCEC_REGISTRATION_HOTEL	REGISTRATION_HOTEL,
			SRCEC_MADE_BY 				MADE_BY,
			SRCEC_MADE_ON 				MADE_ON,
			SRCEC_UPDATED_BY 			UPDATED_BY,
			SRCEC_LAST_UPDATE 			LAST_UPDATE,
			SRCEC_STATUS 				STATUS
	  FROM CTRLT_SOURCE
	 WHERE ( p_id_hotel    = '' OR p_id_hotel = SRCEC_REGISTRATION_HOTEL )
	   AND ( p_source_name = '' OR SRCEC_SOURCE_NAME like v_source_name )
	   AND ( p_commercial_name = '' OR SRCEC_COMMERCIAL_NAME like v_commercial_name )
	   AND ( p_status	   = '' OR p_status = SRCEC_STATUS );
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_TABLE_ITEM` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_TABLE_ITEM` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_TABLE_ITEM`(
					IN p_id_module VARCHAR(02),
					IN p_id_table  VARCHAR(02),
					IN p_status	   VARCHAR(01) )
BEGIN
	SELECT 	ITMTP_ID_TABLE			ID_TABLE,
			ITMTP_ID_ITEM			ID_ITEM,
			ITMTP_ITEM_DESCRIPTION	ITEM_DESCRIPTION,
			ITMTP__STATUS			STATUS
	  FROM CTRLT_TABLE_ITEM
	 WHERE ITMTP_ID_TABLE = p_id_table
	   AND ( ITMTP__STATUS = p_status OR p_status = '' );
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_TABLE_ITEM_LIST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_TABLE_ITEM_LIST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_TABLE_ITEM_LIST`(
					IN p_id_module VARCHAR(02),
					IN p_id_table  VARCHAR(02),
					IN p_status	   VARCHAR(01) )
BEGIN
	SELECT 	-- ITMTP_ID_TABLE			ID_TABLE,
			ITMTP_ID_ITEM			ID_ITEM,
			ITMTP_ITEM_DESCRIPTION	ITEM_DESCRIPTION,
			ITMTP__STATUS			STATUS
	  FROM CTRLT_TABLE_ITEM
	 WHERE ITMTP_ID_TABLE = p_id_table
	   AND ( p_status = ''  OR ITMTP__STATUS = p_status );
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPS_VAL_ROOMTYPE_ST` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPS_VAL_ROOMTYPE_ST` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_VAL_ROOMTYPE_ST`(
	IN h INT, IN t char(02),IN d date )
BEGIN
	DECLARE a int;
	SELECT nAvailableRooms INTO a
	  FROM roomtype_status
	 WHERE nIdHotel = h
	   AND tRoomType = t
	   AND dStatusDate = d
		   LIMIT 1;
	IF a IS NULL THEN
		INSERT INTO roomtype_status VALUES(h,t,d,1,0,0,0,0,0,"I");
	END IF;
	SET @x = a;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPU_CITY` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPU_CITY` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_CITY`(
					    IN p_id_country		int,
						IN p_id_city		int,
						IN p_city_name		varchar(30),
						IN p_abbreviation	varchar(10) )
BEGIN
	UPDATE CTRLT_CITY
			SET CITYC_CITY_NAME = p_city_name,
				CITYC_ABBREVIATION = p_abbreviation
	 WHERE CTRYP_ID_COUNTRY = p_id_country
       AND CITYP_ID_CITY = p_id_city;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPU_COUNTRY` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPU_COUNTRY` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_COUNTRY`(
					    IN p_id_country		int,
						IN p_country_name	varchar(20),
						IN p_abbreviation	varchar(06),
						IN p_nationality	varchar(20) )
BEGIN
	UPDATE CTRLT_COUNTRY
			SET CTRYC_COUNTRY_NAME = p_country_name,
				CTRYC_ABBREVIATION = p_abbreviation,
				CTRYC_NATIONALITY  = p_nationality
	 WHERE CTRYP_ID_COUNTRY = p_id_country;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPU_RATE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPU_RATE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_RATE`(
					    IN p_id_hotel			varchar(02),
						IN p_id_room_type		int,
						IN p_id_period			int,
					    IN p_id_rate			int,
						IN p_value				varchar(10),
						IN p_update_by			varchar(03),
						IN p_status				varchar(01) )
BEGIN
	DECLARE v_current_day date DEFAULT CURRENT_TIMESTAMP();
	UPDATE CTRLT_RATE
	    SET RTYPF_ID_ROOM_TYPE = p_id_room_type,
			PERIF_ID_PERIOD = p_id_period,
			RATEC_VALUE = p_value,
			RATEC_UPDATED_BY = p_update_by,
			RATEC_LAST_UPDATE = v_current_day,
			RATEC_STATUS = p_status
	 WHERE p_id_hotel = MAINP_ID_HOTEL
       AND p_id_rate = RATEP_ID_SPECIAL_RATE;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPU_ROOM` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPU_ROOM` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_ROOM`(
					    IN p_id_hotel			varchar(02),
						IN p_id_room			varchar(03),
						IN p_id_room_type		varchar(03),
						IN p_room_number		varchar(04),
						IN p_room_location		varchar(50),
						IN p_description		varchar(50),
						IN p_room_rate			varchar(10),
						IN p_max_beds			varchar(02),
						IN p_connection			varchar(04),
						IN p_id_reservation		varchar(06),
						IN p_hk_status			varchar(01),
						IN p_status				varchar(01),
						IN p_updated_by			varchar(03) )
BEGIN
	DECLARE v_current_date date DEFAULT current_date();
	UPDATE CTRLT_ROOM
			SET RTYPF_ID_ROOM_TYPE	 = p_id_room_type,
				ROOMC_ROOM_NUMBER	 = p_room_number,
				ROOMC_LOCATION		 = p_room_location,
				ROOMC_DESCRIPTION	 = p_description,
				ROOMC_ROOM_RATE		 = p_room_rate,
				ROOMC_MAX_BEDS		 = p_max_beds,
				ROOMC_CONNECTION 	 = p_connection,
				RESVC_ID_RESERVATION = p_id_reservation,
				ROOMC_HK_STATUS		 = p_hk_status,
				ROOMC_STATUS 		 = p_status,
				ROOMC_UPDATED_BY	 = p_updated_by,
				ROOMC_LAST_UPDATE	 = v_current_date
	 WHERE MAINP_ID_HOTEL = p_id_hotel AND ROOMP_ID_ROOM = p_id_room;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPU_CUSTOMER` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPU_CUSTOMER` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_CUSTOMER`(
					   OUT p_error_type			varchar(06),
					    IN p_id_customer		varchar(06),
						IN p_lastname1			varchar(15),
						IN p_lastname2			varchar(15),
						IN p_firstnames			varchar(20),
						IN p_birthdate			varchar(10),
						IN p_nationality		varchar(02),
						IN p_title				varchar(03),
						IN p_document_type		varchar(02),
						IN p_document_number	varchar(12),
						IN p_street_type		varchar(02),
						IN p_street_name		varchar(30),
						IN p_street_number		varchar(04),
						IN p_interior_number	varchar(04),
						IN p_complements		varchar(20),
						IN p_district			varchar(15),
						IN p_city				varchar(15),
						IN p_id_country			varchar(02),
						IN p_zip_code			varchar(10),
						IN p_phone1				varchar(10),
						IN p_phone2				varchar(10),
						IN p_movil_phone		varchar(10),
						IN p_email				varchar(50),
						IN p_occupation			varchar(20),
						IN p_vip_status			varchar(01),
						IN p_requests			tinytext,
						IN p_hotel_registration	varchar(02),
						IN p_update_by			varchar(05),
						IN p_status				varchar(01) )
BEGIN
	declare v_current_date date default current_date();
	declare v_birthdate date;
	/* Continua luego de intentar registrar un documento de identidad duplicado */
	DECLARE foo int default 0;
	DECLARE ER_DUP_ENTRY CONDITION FOR SQLSTATE '23000'; -- ER_DUP_ENTRY 23000
	DECLARE CONTINUE HANDLER FOR ER_DUP_ENTRY SET p_error_type = '23000'; 
	-- TODO: test if
	if !strcmp(p_birthdate,'1971-08-12') then
	   set v_birthdate = 1969-12-31;
	else
	   set v_birthdate = STR_TO_DATE(p_birthDate,'%d/%m/%Y');
	end if;
    UPDATE CTRLT_CUSTOMER SET
			CUSTC_LASTNAME1			= p_lastname1,
			CUSTC_LASTNAME2			= p_lastname2,
			CUSTC_FIRSTNAME			= p_firstNames,
			CUSTC_BIRTHDATE			= v_birthdate,
			CUSTC_NATIONALITY		= p_nationality,
			CUSTC_TITLE				= p_title,
			CUSTF_DOCUMENT_TYPE		= p_document_type,
			CUSTC_DOCUMENT_NUMBER	= p_document_number,
			CUSTC_STREET_TYPE		= p_street_type,
			CUSTC_STREET_NAME		= p_street_name,
			CUSTC_STREET_NUMBER		= p_street_number,
			CUSTC_INTERIOR_NUMBER	= p_interior_number,
			CUSTC_COMPLEMENTS		= p_complements,
			CUSTC_DISTRICT			= p_district,
			CUSTC_CITY				= p_city,
			CTRYF_ID_COUNTRY		= p_id_country,
			CUSTC_ZIPCODE			= p_zip_code,
			CUSTC_PHONE1			= p_phone1,
			CUSTC_PHONE2			= p_phone2,
			CUSTC_MOVIL_PHONE		= p_movil_phone,
			CUSTC_EMAIL				= p_email,
			CUSTC_OCCUPATION		= p_occupation,
			CUSTC_VIP_STATUS		= p_vip_status,
			CUSTC_SPECIAL_REQUESTS	= p_requests,
			CUSTC_REGISTRATION_HOTEL = p_hotel_registration,
			CUSTC_UPDATED_BY		= p_update_by,
			CUSTC_LAST_UPDATE		= v_current_date,
			CUSTC_STATUS			= p_status
	WHERE 	CUSTP_ID_CUSTOMER		= p_id_customer;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPU_RESERVATION` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPU_RESERVATION` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_RESERVATION`(
						IN p_id_hotel smallint,
						IN p_id_reservation int,
						IN p_arrival varchar(10),
						IN p_departure varchar(10),
						IN p_nights varchar(03),
						IN p_adults varchar(02),
						IN p_children varchar(02),
						IN p_room_type varchar(02),
						IN p_quantity_rooms varchar(02),
						IN p_room_number varchar(04),
						IN p_id_source varchar(06),
						IN p_room_rate decimal(10,2),
						IN p_total_room decimal(10,2),
						IN p_payment_due varchar(10),
						IN p_payment_type varchar(02),
						IN p_res_status varchar(01),
						IN p_hotel_instructions varchar(120),
						IN p_guest_instructions varchar(120),
						IN p_update_by varchar(03) )
BEGIN
		DECLARE foo int default 0;
		DECLARE v_current_date date DEFAULT CURRENT_TIMESTAMP();
		/* El handler controla el flujo luego de un bug de mysql */
		DECLARE GUEST_INSTRUCTIONS_BUG CONDITION FOR SQLSTATE '21S01'; -- ER_WRONG_VALUE_COUNT 21S01
		DECLARE CONTINUE HANDLER FOR GUEST_INSTRUCTIONS_BUG SET foo = 1; 
		/* End conditions manage */
        UPDATE CTRLT_RESERVATION
		   SET	RESVC_ARRIVAL      = STR_TO_DATE(p_arrival,'%d/%m/%Y'),
				RESVC_DEPARTURE    = STR_TO_DATE(p_departure,'%d/%m/%Y'),
				RESVC_NIGHTS       = p_nights,
				RESVC_ADULTS       = p_adults,
				RESVC_CHILDREN     = p_children,
				RESVF_ID_ROOMTYPE  = p_room_type,
				RESVC_QUANTITY     = p_quantity_rooms,
				RESVF_ID_ROOM      = p_room_number,
				SRCEF_ID_SOURCE    = p_id_source,
				RESVC_ROOM_RATE    = p_room_rate,
				RESVC_TOTAL_ROOM   = p_total_room,
				RESVC_PAYMENT_DUE  = STR_TO_DATE(p_payment_due,'%d/%m/%Y'),
				RESVF_PAYMENT_TYPE = p_payment_type,
				RESVC_STATUS       = p_res_status,
				RESVC_HOTEL_INSTRUCTIONS = p_hotel_instructions,
				RESVC_GUEST_INSTRUCTIONS = p_guest_instructions, -- Genera bug mysql
				RESVC_UPDATED_BY   = p_update_by,
				RESVC_LAST_UPDATE  = v_current_date
		 WHERE MAINP_ID_HOTEL = p_id_hotel
		   AND RESVP_ID_RESERVATION = p_id_reservation;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPU_ROOMTYPE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPU_ROOMTYPE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_ROOMTYPE`(
					    IN p_idHotel			varchar(02),
					    IN p_idRoomType			varchar(02),
						IN p_roomType			varchar(02),
						IN p_description		varchar(20),
						IN p_rackRate			varchar(14),
						IN p_totalRooms			varchar(03),
						IN p_availableRooms		varchar(03),
						IN p_blockedRooms		varchar(03),
						IN p_status				varchar(01) )
BEGIN
	UPDATE CTRLT_ROOMTYPE
			SET RTYPC_ROOM_TYPE		= p_roomType,
			    RTYPC_DESCRIPTION	= p_description,
				RTYPC_RACK_RATE		= p_rackRate,
				RTYPC_QUANTITY_ROOMS = p_totalRooms,
				RTYPC_AVAILABLE_ROOMS = p_availableRooms,
				RTYPC_LOCKED_ROOMS	= p_blockedRooms,
				RTYPC_STATUS 		= p_status
	 WHERE MAINP_ID_HOTEL = p_idHotel AND RTYPP_ID_ROOM_TYPE = p_idRoomType;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPU_SEGMENT` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPU_SEGMENT` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_SEGMENT`(
					    IN p_id_hotel		int,
					    IN p_id_segment		varchar(02),
						IN p_id_source		varchar(06),
						IN p_description	varchar(50),
						IN p_updated_by		varchar(03),
						IN p_status			varchar(01) )
BEGIN
	DECLARE v_current_date date DEFAULT CURRENT_DATE();
	UPDATE CTRLT_SEGMENT
			SET SRCEF_ID_SOURCE	  = p_id_source,
				SEGMC_DESCRIPTION = p_description,
				SEGMC_UPDATED_BY  = p_updated_by,
				SEGMC_LAST_UPDATE = v_current_date,
				SEGMC_STATUS 	  = p_status
	 WHERE MAINP_ID_HOTEL = p_id_hotel AND SEGMP_ID_SEGMENT = p_id_segment;
END */$$
DELIMITER ;

/* Procedure structure for procedure `CTRLPU_SOURCE` */

/*!50003 DROP PROCEDURE IF EXISTS  `CTRLPU_SOURCE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_SOURCE`(
			out p_error_type 	  	 varchar(06),
			 in p_id_source			 varchar(06),
			 in	p_source_name 	  	 varchar(50),
			 in	p_commercial_name 	 varchar(50),
			 in	p_document_number 	 varchar(11),
			 in	p_street_type 	  	 varchar(02),
			 in	p_street_name	  	 varchar(30),
			 in	p_street_number   	 varchar(30),
			 in	p_interior		  	 varchar(04),
			 in	p_complement	  	 varchar(20),
			 in	p_id_district 	  	 varchar(02),
			 in	p_id_city 		  	 varchar(20),
			 in p_id_country 	  	 varchar(03),
			 in	p_zip_code 		  	 varchar(10),
			 in	p_phone1 		  	 varchar(10),
			 in	p_phone2 		  	 varchar(10),
			 in	p_web_page 		  	 varchar(50),
			 in	p_id_segment 	  	 varchar(02),
			 in	p_id_type 		  	 varchar(02),
			 in	p_category 		  	 varchar(01),
			 in	p_id_rate		  	 varchar(04),
			 in	p_credit_type 	  	 varchar(02),
			 in	p_registration_hotel varchar(03),
			 in	p_updated_by		 varchar(04),
			 in p_status 			 varchar(01) )
BEGIN
		DECLARE v_current_date date DEFAULT current_date();
		/* Continua luego de intentar registrar un numero de documento duplicado */
		DECLARE ER_DUP_ENTRY CONDITION FOR SQLSTATE '23000'; -- ER_DUP_ENTRY 23000
		DECLARE CONTINUE HANDLER FOR ER_DUP_ENTRY SET p_error_type = '23000'; 
		UPDATE CTRLT_SOURCE
		    SET SRCEC_SOURCE_NAME		 = p_source_name,
				SRCEC_COMMERCIAL_NAME    = p_commercial_name,
				SRCEC_DOCUMENT_NUMBER 	 = p_document_number,
				SRCEC_STREET_TYPE 		 = p_street_type,
				SRCEC_STREET_NAME 		 = p_street_name,
				SRCEC_STREET_NUMBER 	 = p_street_number,
				SRCEC_INTERIOR 			 = p_interior,
				SRCEC_COMPLEMENT		 = p_complement,
				SRCEC_ID_CITY 			 = p_id_city,
				CTRYF_ID_COUNTRY 		 = p_id_country,
				SRCEC_ID_DISTRICT 		 = p_id_district,
				SRCEC_ZIP_CODE 			 = p_zip_code,
				SRCEC_PHONE1 			 = p_phone1,
				SRCEC_PHONE2 			 = p_phone2,
				SRCEC_WEB_PAGE 			 = p_web_page,
				SRCEC_ID_SEGMENT 		 = p_id_segment,
				SRCEC_ID_TYPE 			 = p_id_type,
				SRECC_CATEGORY 			 = p_category,
				RATEF_ID_RATE 			 = p_id_rate,
				SRCEC_CREDIT_TYPE        = p_credit_type,
				SRCEC_REGISTRATION_HOTEL = p_registration_hotel,
				SRCEC_UPDATED_BY 		 = p_updated_by,
				SRCEC_LAST_UPDATE 		 = v_current_date,
				SRCEC_STATUS 			 = p_status
		WHERE SRCEP_ID_SOURCE = p_id_source;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `SP_DO_ITERATE` */

/*!50003 DROP PROCEDURE IF EXISTS  `SP_DO_ITERATE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_DO_ITERATE`(p1 INT)
BEGIN
	label1: LOOP
	SET p1 = p1 + 1;
	IF p1 < 10 THEN
		ITERATE label1; END IF;
	LEAVE label1;
	END LOOP label1;
	SET @x = p1;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
