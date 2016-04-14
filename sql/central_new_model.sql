SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
CREATE SCHEMA IF NOT EXISTS `hotel` DEFAULT CHARACTER SET latin1 ;
USE `hotel`;

-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_app_table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_app_table` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_app_table` (
  `APPMC_ID_MODULE` SMALLINT(2) UNSIGNED NULL DEFAULT NULL ,
  `APPMC_ID_TABLE` SMALLINT(2) UNSIGNED NULL DEFAULT NULL ,
  `APPMC_TABLE_DESCRIPTION` CHAR(20) NULL DEFAULT NULL ,
  `APPMC_STATUS` CHAR(1) NULL DEFAULT 'A' )
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_city` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_city` (
  `CITYP_ID_CITY` SMALLINT(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT ,
  `CTRYP_ID_COUNTRY` SMALLINT(3) UNSIGNED NOT NULL ,
  `CITYC_CITY_NAME` VARCHAR(30) NULL DEFAULT NULL ,
  `CITYC_ABBREVIATION` VARCHAR(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`CITYP_ID_CITY`, `CTRYP_ID_COUNTRY`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1
CHECKSUM = 1
DELAY_KEY_WRITE = 1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_country` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_country` (
  `CTRYP_ID_COUNTRY` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `CTRYC_COUNTRY_NAME` CHAR(20) NULL DEFAULT NULL ,
  `CTRYC_ABBREVIATION` CHAR(6) NULL DEFAULT NULL ,
  `CTRYC_NATIONALITY` CHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`CTRYP_ID_COUNTRY`) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1
CHECKSUM = 1
COMMENT = 'InnoDB free: 4096 k'
DELAY_KEY_WRITE = 1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_customer` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_customer` (
  `CUSTP_ID_CUSTOMER` INT(6) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Customer code. Assign by System' ,
  `CUSTC_LASTNAME1` VARCHAR(15) NOT NULL ,
  `CUSTC_LASTNAME2` VARCHAR(15) NULL DEFAULT NULL ,
  `CUSTC_FIRSTNAME` VARCHAR(15) NOT NULL ,
  `CUSTC_BIRTHDATE` DATE NULL DEFAULT NULL ,
  `CUSTC_NATIONALITY` SMALLINT(3) UNSIGNED NOT NULL ,
  `CUSTC_TITLE` SMALLINT(2) NULL DEFAULT NULL ,
  `CUSTF_DOCUMENT_TYPE` SMALLINT(2) UNSIGNED NOT NULL ,
  `CUSTC_DOCUMENT_NUMBER` VARCHAR(12) NOT NULL COMMENT 'Document of Identification' ,
  `CUSTC_STREET_TYPE` SMALLINT(2) NOT NULL ,
  `CUSTC_STREET_NAME` VARCHAR(30) NOT NULL ,
  `CUSTC_STREET_NUMBER` SMALLINT(4) NOT NULL ,
  `CUSTC_INTERIOR_NUMBER` VARCHAR(4) NULL DEFAULT NULL ,
  `CUSTC_COMPLEMENTS` VARCHAR(20) NULL DEFAULT NULL ,
  `CUSTC_DISTRICT` VARCHAR(15) NULL DEFAULT NULL ,
  `CUSTC_CITY` VARCHAR(15) NULL DEFAULT NULL ,
  `CTRYF_ID_COUNTRY` SMALLINT(3) UNSIGNED NOT NULL ,
  `CUSTC_ZIPCODE` VARCHAR(10) NULL DEFAULT NULL ,
  `CUSTC_PHONE1` INT(7) UNSIGNED NOT NULL ,
  `CUSTC_PHONE2` INT(7) UNSIGNED NULL DEFAULT NULL ,
  `CUSTC_MOVIL_PHONE` INT(9) UNSIGNED NULL DEFAULT NULL ,
  `CUSTC_EMAIL` VARCHAR(50) NULL DEFAULT NULL ,
  `CUSTC_OCCUPATION` VARCHAR(20) NULL DEFAULT NULL ,
  `CUSTC_VIP_STATUS` CHAR(1) NULL DEFAULT '2' ,
  `CUSTC_SPECIAL_REQUESTS` TINYTEXT NULL DEFAULT NULL ,
  `CUSTC_REGISTRATION_HOTEL` SMALLINT(2) UNSIGNED NOT NULL ,
  `CUSTC_MADE_BY` CHAR(3) NOT NULL ,
  `CUSTC_MADE_ON` DATE NOT NULL ,
  `CUSTC_UPDATED_BY` CHAR(3) NULL DEFAULT NULL ,
  `CUSTC_LAST_UPDATE` DATE NULL DEFAULT NULL ,
  `CUSTC_STATUS` CHAR(1) NULL DEFAULT 'P' ,
  PRIMARY KEY (`CUSTP_ID_CUSTOMER`) )
ENGINE = InnoDB
AUTO_INCREMENT = 27
AVG_ROW_LENGTH = 159
DEFAULT CHARACTER SET = latin1
CHECKSUM = 1
DELAY_KEY_WRITE = 1
ROW_FORMAT = FIXED;

CREATE UNIQUE INDEX `idx_documentNumber` ON `hotel`.`ctrlt_customer` (`CUSTC_DOCUMENT_NUMBER` ASC, `CUSTF_DOCUMENT_TYPE` ASC) ;

CREATE INDEX `idx_lastName` ON `hotel`.`ctrlt_customer` (`CUSTC_LASTNAME1` ASC) ;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_district`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_district` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_district` (
  `CTRYP_ID_COUNTRY` TINYINT(3) UNSIGNED NOT NULL ,
  `CITYP_ID_CITY` TINYINT(2) UNSIGNED NOT NULL ,
  `DISTP_ID_DISTRICT` TINYINT(2) UNSIGNED NOT NULL ,
  `DISTC_DISTRICT_NAME` VARCHAR(30) NULL DEFAULT NULL ,
  `DISTC_ZIPCODE` CHAR(5) NULL DEFAULT NULL ,
  `DISTC_STATUS` CHAR(1) NULL DEFAULT 'A' ,
  PRIMARY KEY (`CTRYP_ID_COUNTRY`, `CITYP_ID_CITY`, `DISTP_ID_DISTRICT`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
ROW_FORMAT = DYNAMIC;

CREATE UNIQUE INDEX `nDistrictId` ON `hotel`.`ctrlt_district` (`DISTP_ID_DISTRICT` ASC) ;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_guest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_guest` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_guest` (
  `MAINP_ID_HOTEL` TINYINT(1) UNSIGNED NOT NULL ,
  `RESVP_ID_RESERVATION` INT(5) UNSIGNED NOT NULL ,
  `CUSTP_ID_CUSTOMER` INT(5) UNSIGNED NOT NULL COMMENT 'valor invariable en el tiempo' ,
  `GUESC_STATUS` CHAR(1) NULL DEFAULT 'P' ,
  PRIMARY KEY (`MAINP_ID_HOTEL`, `RESVP_ID_RESERVATION`, `CUSTP_ID_CUSTOMER`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'Huespedes registrados en reserva'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_holliday`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_holliday` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_holliday` (
  `HOLYC_ID_COUNTRY` SMALLINT(6) NULL DEFAULT NULL ,
  `HOLYC_HOLLYDAY` DATE NULL DEFAULT NULL ,
  `HOLYC_DESCRIPTION` VARCHAR(30) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_hotel_account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_hotel_account` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_hotel_account` (
  `MAINP_ID_HOTEL` SMALLINT(2) NOT NULL DEFAULT '0' ,
  `ACCTP_ID_ACCOUNT` SMALLINT(4) NULL DEFAULT NULL ,
  `ACCTC_ACCOUNT_NUMBER` CHAR(3) NOT NULL DEFAULT '0' ,
  `ACCTC_ACCOUNT_TYPE` CHAR(1) NULL DEFAULT NULL ,
  `ACCTC_DESCRIPTION` VARCHAR(30) NULL DEFAULT NULL ,
  `ACCTC_STATUS` CHAR(1) NULL DEFAULT 'A' )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'InnoDB free: 4096 kB'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_hotel_main`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_hotel_main` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_hotel_main` (
  `MAINP_ID_HOTEL` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `MAINC_HOTEL_DESCRIPTION` VARCHAR(50) NOT NULL DEFAULT '' ,
  `MAINC_TOTAL_ROOMS` SMALLINT(3) NOT NULL ,
  `MAINC_ADDRESS` VARCHAR(50) NOT NULL DEFAULT '' ,
  `MAINC_DISTRICT` CHAR(20) NOT NULL DEFAULT '' ,
  `MAINC_CITY` CHAR(20) NOT NULL DEFAULT '' ,
  `MAINC_REGION` CHAR(20) NOT NULL DEFAULT '' ,
  `MAINC_STATE` CHAR(20) NOT NULL DEFAULT '' ,
  `MAINC_COUNTRY` CHAR(20) NOT NULL DEFAULT '' ,
  `MAINC_CODE_AREA` CHAR(5) NOT NULL DEFAULT '' ,
  `MAINC_CODE_CITY` CHAR(5) NOT NULL DEFAULT '' ,
  `MAINC_PHONE_NUMBER` VARCHAR(10) NOT NULL DEFAULT '' ,
  `MAINC_ZIP_CODE` VARCHAR(10) NOT NULL DEFAULT '' ,
  `MAINC_STATUS` CHAR(1) NOT NULL DEFAULT '' ,
  PRIMARY KEY (`MAINP_ID_HOTEL`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'Hotel Description'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_hotel_room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_hotel_room` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_hotel_room` (
  `MAINP_ID_HOTEL` TINYINT(1) UNSIGNED NOT NULL ,
  `ROOMP_ID_ROOM` SMALLINT(6) NULL DEFAULT NULL ,
  `ROOMC_ROOM_NUMBER` CHAR(4) NOT NULL DEFAULT '' ,
  `ROOMC_DESCRIPTION` VARCHAR(50) NULL DEFAULT NULL ,
  `RTYPF_ID_ROOMTYPE` CHAR(2) NULL DEFAULT NULL ,
  `ROOMC_ROOM_RATE` DECIMAL(10,0) NULL DEFAULT NULL ,
  `ROOMC_STATUS` CHAR(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`MAINP_ID_HOTEL`, `ROOMC_ROOM_NUMBER`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_occupation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_occupation` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_occupation` (
  `MAINP_ID_HOTEL` TINYINT(1) NULL DEFAULT NULL ,
  `RTYPP_ROOM_TYPE` CHAR(2) NULL DEFAULT NULL ,
  `OCCPP_OCCUPATION_DAY` DATE NULL DEFAULT NULL ,
  `RESVP_ID_RESERVATION` SMALLINT(5) UNSIGNED NULL DEFAULT NULL ,
  `OCCPC_RESERVATION_TYPE` CHAR(1) NULL DEFAULT 'I' ,
  `OCCPC_QUANTITY_ROOMS` TINYINT(3) NULL DEFAULT '1' ,
  `OCCPC_ROOM_NUMBER` CHAR(4) NULL DEFAULT NULL ,
  `OCCPC_ADULTS` TINYINT(3) UNSIGNED NULL DEFAULT '1' ,
  `OCCPC_CHILDREN` TINYINT(1) UNSIGNED NULL DEFAULT '0' ,
  `OCCPC_STATUS` CHAR(1) NULL DEFAULT NULL )
ENGINE = InnoDB
AVG_ROW_LENGTH = 8192
DEFAULT CHARACTER SET = latin1
COMMENT = 'InnoDB free: 22528 kB'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_period`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_period` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_period` (
  `MAINP_ID_HOTEL` TINYINT(2) UNSIGNED NOT NULL ,
  `PERIP_ID_PERIOD` TINYINT(3) UNSIGNED ZEROFILL NOT NULL ,
  `PERIC_START_DATE` DATE NOT NULL ,
  `PERIC_END_DATE` DATE NOT NULL ,
  `PERIC_DESCRIPTION` VARCHAR(50) NOT NULL DEFAULT '' ,
  `PERIC_PERIOD_CLASS` CHAR(1) NULL DEFAULT NULL COMMENT 'Y=Yearly;S=Temporada; W=Fin de semana; H=Holiday' ,
  `PERIC_MADE_BY` VARCHAR(30) NULL DEFAULT NULL ,
  `PERIC_MADE_ON` DATE NULL DEFAULT NULL ,
  `PERIC_UPDATED_BY` VARCHAR(30) NULL DEFAULT NULL ,
  `PERIC_LAST_UPDATE` DATE NULL DEFAULT NULL ,
  `PERIC_STATUS` CHAR(1) NULL DEFAULT 'A' ,
  PRIMARY KEY (`MAINP_ID_HOTEL`, `PERIP_ID_PERIOD`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_rate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_rate` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_rate` (
  `RTYPF_ID_ROOM_TYPE` SMALLINT(2) UNSIGNED NOT NULL ,
  `MAINP_ID_HOTEL` SMALLINT(2) UNSIGNED NOT NULL ,
  `PERIF_ID_PERIOD` SMALLINT(3) UNSIGNED ZEROFILL NOT NULL ,
  `RATEP_ID_SPECIAL_RATE` SMALLINT(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT ,
  `RATEC_VALUE` DECIMAL(10,2) NULL DEFAULT NULL ,
  `RATEC_MADE_BY` CHAR(3) NULL DEFAULT NULL ,
  `RATEC_MADE_ON` DATE NULL DEFAULT NULL ,
  `RATEC_UPDATED_BY` CHAR(3) NULL DEFAULT NULL ,
  `RATEC_LAST_UPDATE` DATE NULL DEFAULT NULL ,
  `RATEC_STATUS` CHAR(1) NULL DEFAULT 'A' ,
  PRIMARY KEY (`RATEP_ID_SPECIAL_RATE`, `MAINP_ID_HOTEL`, `RTYPF_ID_ROOM_TYPE`, `PERIF_ID_PERIOD`) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_res_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_res_type` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_res_type` (
  `SEGMP_ID_SEGMENT` SMALLINT(2) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `RESTC_DESCRIPTION` VARBINARY(50) NULL DEFAULT NULL ,
  `COMPF_ID_COMPANY` SMALLINT(6) UNSIGNED NULL DEFAULT '0' ,
  PRIMARY KEY (`SEGMP_ID_SEGMENT`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_room` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_room` (
  `ROOMP_ID_ROOM` INT(4) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `MAINP_ID_HOTEL` SMALLINT(2) UNSIGNED NOT NULL ,
  `RTYPF_ID_ROOM_TYPE` SMALLINT(3) NOT NULL ,
  `ROOMC_ROOM_NUMBER` CHAR(4) NOT NULL ,
  `ROOMC_LOCATION` VARCHAR(50) NOT NULL ,
  `ROOMC_DESCRIPTION` VARCHAR(50) NOT NULL ,
  `ROOMC_ROOM_RATE` DECIMAL(6,2) NOT NULL ,
  `ROOMC_MAX_BEDS` SMALLINT(3) NOT NULL ,
  `ROOMC_CONNECTION` CHAR(4) NULL DEFAULT NULL ,
  `RESVC_ID_RESERVATION` INT(4) NULL DEFAULT NULL ,
  `ROOMC_HK_STATUS` CHAR(1) NULL DEFAULT NULL ,
  `ROOMC_STATUS` CHAR(1) NOT NULL DEFAULT 'V' ,
  `ROOMC_MADE_BY` CHAR(3) NOT NULL ,
  `ROOMC_MADE_ON` DATE NOT NULL ,
  `ROOMC_UPDATED_BY` CHAR(3) NULL DEFAULT NULL ,
  `ROOMC_LAST_UPDATE` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`ROOMP_ID_ROOM`, `MAINP_ID_HOTEL`) )
ENGINE = InnoDB
AUTO_INCREMENT = 65
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_roomtype`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_roomtype` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_roomtype` (
  `MAINP_ID_HOTEL` SMALLINT(2) UNSIGNED NOT NULL ,
  `RTYPP_ID_ROOM_TYPE` INT(3) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `RTYPC_ROOM_TYPE` CHAR(2) NOT NULL ,
  `RTYPC_DESCRIPTION` VARCHAR(20) NOT NULL ,
  `RTYPC_RACK_RATE` DECIMAL(6,2) NOT NULL ,
  `RTYPC_QUANTITY_ROOMS` SMALLINT(3) UNSIGNED NOT NULL ,
  `RTYPC_AVAILABLE_ROOMS` SMALLINT(3) UNSIGNED NOT NULL ,
  `RTYPC_LOCKED_ROOMS` SMALLINT(3) UNSIGNED NULL DEFAULT NULL ,
  `RTYPC_STATUS` CHAR(1) NOT NULL DEFAULT 'A' ,
  `RTYPC_MADE_BY` CHAR(3) NOT NULL ,
  `RTYPC_MADE_ON` DATE NOT NULL ,
  `RTYPC_UPDATED_BY` CHAR(3) NOT NULL ,
  `RTYPC_LAST_UPDATE` DATE NOT NULL ,
  PRIMARY KEY (`RTYPP_ID_ROOM_TYPE`, `MAINP_ID_HOTEL`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_source`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_source` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_source` (
  `SRCEP_ID_SOURCE` INT(6) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Customer code. Assign by System' ,
  `SRCEC_SOURCE_NAME` VARCHAR(50) NOT NULL DEFAULT '' ,
  `SRCEC_COMMERCIAL_NAME` VARCHAR(30) NULL DEFAULT NULL ,
  `SRCEC_DOCUMENT_NUMBER` VARCHAR(11) NOT NULL COMMENT 'Document of Identification' ,
  `SRCEC_STREET_TYPE` SMALLINT(6) NOT NULL ,
  `SRCEC_STREET_NAME` VARCHAR(20) NOT NULL ,
  `SRCEC_STREET_NUMBER` VARCHAR(4) NOT NULL ,
  `SRCEC_INTERIOR` VARCHAR(4) NULL DEFAULT NULL ,
  `SRCEC_COMPLEMENT` VARCHAR(20) NULL DEFAULT NULL ,
  `SRCEC_ID_DISTRICT` SMALLINT(3) UNSIGNED NULL DEFAULT NULL ,
  `SRCEC_CITY` VARCHAR(15) NOT NULL ,
  `CTRYF_ID_COUNTRY` SMALLINT(3) UNSIGNED NOT NULL ,
  `SRCEC_ZIP_CODE` VARCHAR(10) NULL DEFAULT NULL ,
  `SRCEC_PHONE1` VARCHAR(10) NOT NULL ,
  `SRCEC_PHONE2` VARCHAR(10) NULL DEFAULT NULL ,
  `SRCEC_WEB_PAGE` VARCHAR(50) NULL DEFAULT NULL ,
  `SRCEC_ID_SEGMENT` SMALLINT(4) UNSIGNED NOT NULL COMMENT 'I=Industry, S=Service, F=Financial' ,
  `SRCEC_ID_TYPE` SMALLINT(2) NULL DEFAULT NULL COMMENT 'C=Company, G=Goverment, O=ONG, etc.' ,
  `SRECC_CATEGORY` CHAR(1) NULL DEFAULT NULL ,
  `RATEF_ID_RATE` SMALLINT(4) UNSIGNED NOT NULL ,
  `SRCEC_CREDIT_TYPE` VARCHAR(2) NULL DEFAULT NULL COMMENT 'Credit type (C1 = 10 dias)' ,
  `SRCEC_REGISTRATION_HOTEL` SMALLINT(2) NOT NULL ,
  `SRCEC_MADE_BY` CHAR(3) NOT NULL ,
  `SRCEC_MADE_ON` DATE NOT NULL ,
  `SRCEC_UPDATED_BY` CHAR(3) NOT NULL ,
  `SRCEC_LAST_UPDATE` DATE NOT NULL ,
  `SRCEC_STATUS` CHAR(1) NOT NULL ,
  PRIMARY KEY (`SRCEP_ID_SOURCE`) )
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;

CREATE UNIQUE INDEX `CTRL_IDX_SOURCE_DOCUMENT` ON `hotel`.`ctrlt_source` (`SRCEC_DOCUMENT_NUMBER` ASC) ;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_reservation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_reservation` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_reservation` (
  `RESVP_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `RESVF_ID_HOTEL` SMALLINT UNSIGNED NOT NULL ,
  `RESVC_RESERVATION_TYPE` SMALLINT NOT NULL DEFAULT 1 ,
  `RESVC_ARRIVAL` DATE NOT NULL ,
  `RESVC_DEPARTURE` DATE NOT NULL ,
  `RESVC_NIGHTS` SMALLINT UNSIGNED NOT NULL ,
  `RESVC_ADULTS` SMALLINT UNSIGNED NOT NULL DEFAULT 1 ,
  `RESVC_CHILDREN` SMALLINT UNSIGNED NULL DEFAULT 0 ,
  `RESVF_ID_ROOMTYPE` SMALLINT UNSIGNED NOT NULL ,
  `RESVC_QUANTITY` SMALLINT UNSIGNED NOT NULL DEFAULT 1 ,
  `RESVF_ID_ROOM` INT UNSIGNED NULL DEFAULT NULL ,
  `RESVF_ID_SOURCE` INT UNSIGNED NOT NULL ,
  `RESVC_ROOM_RATE` DECIMAL(10,2) NOT NULL ,
  `RESVC_TOTAL_ROOM` DECIMAL(10,2) NOT NULL ,
  `RESVC_PAYMENT_DUE` DATE NULL DEFAULT NULL ,
  `RESVF_PAYMENT_TYPE` SMALLINT UNSIGNED NOT NULL ,
  `RESVC_VOUCHER` VARCHAR(10) NULL ,
  `RESVC_VIP_CODE` SMALLINT UNSIGNED NULL DEFAULT 3 ,
  `RESVC_HOTEL_INSTRUCTIONS` VARCHAR(120) NULL DEFAULT NULL ,
  `RESVC_GUEST_INSTRUCTIONS` VARCHAR(120) NULL DEFAULT NULL ,
  `RESVC_STATUS` SMALLINT UNSIGNED NOT NULL DEFAULT 1 ,
  `RESVC_MADE_BY` VARCHAR(3) NULL DEFAULT NULL ,
  `RESVC_MADE_ON` DATETIME NULL DEFAULT NULL ,
  `RESVC_UPDATED_BY` VARCHAR(3) NULL DEFAULT NULL ,
  `RESVC_LAST_UPDATE` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`RESVP_ID`) ,
  CONSTRAINT `IDX_ID_ROOM`
    FOREIGN KEY (`RESVF_ID_ROOM` )
    REFERENCES `hotel`.`ctrlt_room` (`ROOMP_ID_ROOM` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `IDX_ID_ROOMTYPE`
    FOREIGN KEY (`RESVF_ID_ROOMTYPE` )
    REFERENCES `hotel`.`ctrlt_roomtype` (`RTYPC_ROOM_TYPE` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `IDX_ID_SOURCE`
    FOREIGN KEY (`RESVF_ID_SOURCE` )
    REFERENCES `hotel`.`ctrlt_source` (`SRCEP_ID_SOURCE` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `IDX_ID_HOTEL`
    FOREIGN KEY (`RESVF_ID_HOTEL` )
    REFERENCES `hotel`.`ctrlt_hotel_main` (`MAINP_ID_HOTEL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5146
AVG_ROW_LENGTH = 214
DEFAULT CHARACTER SET = latin1
COMMENT = 'InnoDB free: 22528 kB'
ROW_FORMAT = DYNAMIC;

CREATE INDEX `IDX_ID_ROOM` ON `hotel`.`ctrlt_reservation` (`RESVF_ID_ROOM` ASC) ;

CREATE INDEX `IDX_ID_ROOMTYPE` ON `hotel`.`ctrlt_reservation` (`RESVF_ID_ROOMTYPE` ASC) ;

CREATE INDEX `IDX_ID_SOURCE` ON `hotel`.`ctrlt_reservation` (`RESVF_ID_SOURCE` ASC) ;

CREATE INDEX `IDX_ID_HOTEL` ON `hotel`.`ctrlt_reservation` (`RESVF_ID_HOTEL` ASC) ;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_reservation_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_reservation_status` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_reservation_status` (
  `RESSC_STATUS` CHAR(1) NULL DEFAULT NULL ,
  `RESSC_DESCRIPTION` CHAR(15) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'Reservation Status'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_roomtype_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_roomtype_status` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_roomtype_status` (
  `MAINP_ID_HOTEL` TINYINT(1) UNSIGNED NOT NULL ,
  `RTYPP_ROOM_TYPE` CHAR(2) NOT NULL DEFAULT '' ,
  `RTSTC_STATUS_DAY` DATE NULL DEFAULT NULL ,
  `RTSTC_TOTAL_ROOMS` SMALLINT(3) NULL DEFAULT NULL ,
  `RTSTC_AVAILABLE_ROOMS` SMALLINT(6) NULL DEFAULT NULL ,
  `RTSTC_TENTATIVE_ROOMS` SMALLINT(6) NULL DEFAULT NULL ,
  `RTSTC_COMFIRMED_ROOMS` SMALLINT(6) NULL DEFAULT NULL ,
  `RTSTC_LOCKED_ROOMS` SMALLINT(6) NULL DEFAULT NULL ,
  `RTSTC_MAINTENANCE_ROOMS` SMALLINT(6) NULL DEFAULT NULL ,
  `RTSTC_RESERVATION_TYPE` CHAR(1) NULL DEFAULT NULL COMMENT 'Individual or Group' )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_season`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_season` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_season` (
  `MAINP_ID_HOTEL` SMALLINT(2) NULL DEFAULT NULL ,
  `SEASC_MONTH` TINYINT(2) NULL DEFAULT NULL ,
  `SEASC_SEASON` CHAR(1) NULL DEFAULT NULL ,
  `SEASC_STATUS` CHAR(1) NULL DEFAULT 'A' )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_segment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_segment` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_segment` (
  `SEGMP_ID_SEGMENT` SMALLINT(2) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `MAINP_ID_HOTEL` SMALLINT(2) UNSIGNED NOT NULL ,
  `SRCEF_ID_SOURCE` SMALLINT(6) UNSIGNED NULL DEFAULT NULL ,
  `SEGMC_DESCRIPTION` VARCHAR(50) NULL DEFAULT NULL ,
  `SEGMC_MADE_BY` VARCHAR(3) NULL DEFAULT NULL ,
  `SEGMC_MADE_ON` DATE NULL DEFAULT NULL ,
  `SEGMC_UPDATED_BY` VARCHAR(3) NULL DEFAULT NULL ,
  `SEGMC_LAST_UPDATE` DATETIME NULL DEFAULT NULL ,
  `SEGMC_STATUS` CHAR(1) NULL DEFAULT 'A' ,
  PRIMARY KEY (`SEGMP_ID_SEGMENT`, `MAINP_ID_HOTEL`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1
CHECKSUM = 1
DELAY_KEY_WRITE = 1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_source_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_source_type` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_source_type` (
  `SRCTP_ID_SOURCE_TYPE` SMALLINT(2) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `SRCTC_DESCRIPTION` VARCHAR(15) NULL DEFAULT NULL ,
  `SRCTC_ABBREVIATION` VARCHAR(6) NULL DEFAULT NULL ,
  `SRCTC_STATUS` CHAR(1) NULL DEFAULT NULL ,
  `SRCTC_MADE_BY` CHAR(3) NULL DEFAULT NULL ,
  `SRCTC_MADE_ON` DATE NULL DEFAULT NULL ,
  `SRCTC_UPDATED_BY` CHAR(3) NULL DEFAULT NULL ,
  `SRCTC_LAST_UPDATE` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`SRCTP_ID_SOURCE_TYPE`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1
CHECKSUM = 1
DELAY_KEY_WRITE = 1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_special_rate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_special_rate` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_special_rate` (
  `SPRTP_ID_SPECIAL_RATE` SMALLINT(4) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `MAINP_ID_HOTEL` SMALLINT(2) UNSIGNED NOT NULL ,
  `SPRTC_DESCRIPTION` VARCHAR(20) NULL DEFAULT NULL ,
  `SPRTC_STATUS` CHAR(1) NULL DEFAULT 'A' ,
  PRIMARY KEY (`SPRTP_ID_SPECIAL_RATE`, `MAINP_ID_HOTEL`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_stt_bill_charge`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_stt_bill_charge` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_stt_bill_charge` (
  `MAINP_ID_HOTEL` INT(6) UNSIGNED NOT NULL COMMENT 'HOTEL ID' ,
  `CUSTF_ID_CUSTOMER` INT(6) UNSIGNED NOT NULL COMMENT 'GUEST ID' ,
  `CUSTF_ID_ROOM` CHAR(4) NULL DEFAULT NULL COMMENT 'ROOM NUMBER' ,
  `CHGEP_BILL_NUMBER` INT(6) UNSIGNED NOT NULL COMMENT 'FOLIO ID' ,
  `CHGEP_SECUENCE` INT(6) UNSIGNED ZEROFILL NOT NULL COMMENT 'SECUENCE NUMBER' ,
  `CHGEP_CHARGE_DATE` DATE NOT NULL COMMENT 'CHARGE DATE' ,
  `ACCTF_ID_ACCOUNT` INT(6) UNSIGNED NOT NULL COMMENT 'ACCOUNT ID' ,
  `CHGEP_AMOUNT_CHARGE` DECIMAL(6,2) UNSIGNED NOT NULL COMMENT 'AMOUNT CHARGE' ,
  `CHGEP_CHECK_TYPE` CHAR(1) NULL DEFAULT NULL COMMENT 'COMAND, VALE, OTHER' ,
  `CHGEP_CHECK_NUMBER` INT(6) NULL DEFAULT NULL COMMENT 'CHECK NUMBER' ,
  `CHGEP_MADE_ON` DATE NULL DEFAULT NULL COMMENT 'MADE ON' ,
  `CHGEP_MADE_BY` CHAR(3) NULL DEFAULT NULL COMMENT 'MADE BY' ,
  `CHGEP_LAST_UPDATE` DATE NULL DEFAULT NULL ,
  `CHGEP_UPDATED_BY` CHAR(3) NULL DEFAULT NULL ,
  `CHGEP_STATUS` CHAR(1) NULL DEFAULT 'A' COMMENT 'CHARGED, CORRECTED, ADJUSTED, ETC.' ,
  PRIMARY KEY (`MAINP_ID_HOTEL`, `CUSTF_ID_CUSTOMER`, `CHGEP_BILL_NUMBER`, `CHGEP_SECUENCE`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_stt_guest_bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_stt_guest_bill` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_stt_guest_bill` (
  `MAINP_ID_HOTEL` TINYINT(2) UNSIGNED NOT NULL ,
  `CUSTP_ID_CUSTOMER` INT(6) NOT NULL DEFAULT '0' ,
  `BILLP_ID_BILL` INT(6) UNSIGNED ZEROFILL NOT NULL ,
  `BILLC_BILL_NUMBER` BIGINT(20) NULL DEFAULT NULL ,
  `BILLC_MADE_ON` DATE NOT NULL COMMENT 'Fecha de apertura de cuenta' ,
  `BILLC_BALANCE` DECIMAL(10,2) NULL DEFAULT NULL ,
  `BILLC_INITIALS` CHAR(3) NULL DEFAULT NULL ,
  `BILLC_STATUS` VARCHAR(1) NULL DEFAULT 'A' ,
  PRIMARY KEY (`MAINP_ID_HOTEL`, `CUSTP_ID_CUSTOMER`, `BILLP_ID_BILL`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hotel`.`ctrlt_table_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`ctrlt_table_item` ;

CREATE  TABLE IF NOT EXISTS `hotel`.`ctrlt_table_item` (
  `ITMTP_ID_ITEM` SMALLINT(2) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `ITMTP_ID_TABLE` SMALLINT(2) UNSIGNED NOT NULL ,
  `ITMTP_ITEM_DESCRIPTION` CHAR(20) NULL DEFAULT NULL ,
  `ITMTP__STATUS` CHAR(1) NULL DEFAULT 'A' ,
  PRIMARY KEY (`ITMTP_ID_ITEM`, `ITMTP_ID_TABLE`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1
ROW_FORMAT = DYNAMIC;

USE `hotel`;

DELIMITER //

DELIMITER ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;