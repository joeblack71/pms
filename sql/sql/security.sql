/*
SQLyog Community Edition- MySQL GUI v6.14
MySQL - 5.0.26-community-nt : Database - security
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `security`;

USE `security`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `app_module` */

DROP TABLE IF EXISTS `app_module`;

CREATE TABLE `app_module` (
  `nHotelid` smallint(2) unsigned NOT NULL,
  `nModuleId` smallint(2) unsigned NOT NULL,
  `tModuleName` char(20) default NULL,
  `tModuleDescription` char(50) default NULL,
  `bModuleStatus` tinyint(1) default '1',
  PRIMARY KEY  (`nHotelid`,`nModuleId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `app_module` */

insert  into `app_module`(`nHotelid`,`nModuleId`,`tModuleName`,`tModuleDescription`,`bModuleStatus`) values (1,1,'Reservations','Central of Reservations',1),(1,2,'Guest Accounting','Control of Guest Account',1);

/*Table structure for table `menu_option` */

DROP TABLE IF EXISTS `menu_option`;

CREATE TABLE `menu_option` (
  `nModuleId` smallint(2) unsigned NOT NULL,
  `nMenuId` tinyint(3) unsigned NOT NULL,
  `nOptionId` tinyint(3) unsigned NOT NULL auto_increment,
  `tDescription` char(50) default NULL,
  `nResourceType` tinyint(1) default NULL COMMENT '1=Servlet; 2=JSP; 3=HTML',
  `tResourceName` char(50) default NULL,
  `nOutputType` tinyint(1) default NULL COMMENT '1=Screen; 2=Report',
  `bPopupWindow` tinyint(1) default NULL,
  `tResourceInfo` char(50) default NULL,
  `tImageOption` char(15) default NULL,
  PRIMARY KEY  (`nModuleId`,`nMenuId`,`nOptionId`),
  UNIQUE KEY `nOptionId` (`nOptionId`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC COMMENT='InnoDB free: 4096 kB';

/*Data for the table `menu_option` */

insert  into `menu_option`(`nModuleId`,`nMenuId`,`nOptionId`,`tDescription`,`nResourceType`,`tResourceName`,`nOutputType`,`bPopupWindow`,`tResourceInfo`,`tImageOption`) values (1,1,1,'Reservations',2,'ReservationList.do',2,0,'Make Reservation',''),(1,1,2,'Customer Register',2,'CustomerList.do',2,0,'Customer Register',''),(1,1,4,'Source Register',2,'SourceList.do',2,0,'Source Register',''),(1,1,3,'Availability Rooms',2,'AvailabilityShow.do',2,1,'Availability Hotel',''),(1,1,6,'Reports',2,'GuestbookingReport.do',2,0,'Reservation Reports',''),(1,1,5,'Rates Management',2,'SpecialRateList.do',2,0,'Rates Maintenance',''),(1,1,7,'Room Management',2,'RoomList.do',2,0,'Room Maintenance','');

/*Table structure for table `module_menu` */

DROP TABLE IF EXISTS `module_menu`;

CREATE TABLE `module_menu` (
  `nModuleId` smallint(2) unsigned NOT NULL,
  `nMenuId` smallint(2) unsigned NOT NULL auto_increment,
  `tDescription` char(30) default NULL,
  `nStatus` tinyint(1) default '1',
  PRIMARY KEY  (`nModuleId`,`nMenuId`),
  UNIQUE KEY `nMenuId` (`nMenuId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `module_menu` */

insert  into `module_menu`(`nModuleId`,`nMenuId`,`tDescription`,`nStatus`) values (1,1,'Reservations',1);

/*Table structure for table `module_user` */

DROP TABLE IF EXISTS `module_user`;

CREATE TABLE `module_user` (
  `nIdHotel` smallint(2) NOT NULL,
  `nIdUser` tinyint(3) unsigned NOT NULL auto_increment,
  `nIdModule` smallint(2) default NULL,
  `tLogin` char(6) default NULL,
  `tPassword` char(6) default NULL,
  `tFirstName` char(15) default NULL,
  `tLastName` char(20) default NULL,
  `nUserType` char(10) default NULL,
  `tDepartment` char(15) default NULL,
  `nStatus` tinyint(1) default NULL,
  PRIMARY KEY  (`nIdHotel`,`nIdUser`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `module_user` */

insert  into `module_user`(`nIdHotel`,`nIdUser`,`nIdModule`,`tLogin`,`tPassword`,`tFirstName`,`tLastName`,`nUserType`,`tDepartment`,`nStatus`) values (1,1,1,'super','','Developer','','developer','TI',1),(1,2,1,'guest','','Testing','','single','Training & Test',1),(2,1,1,'super','','Developer','','developer','TI',1);

/*Table structure for table `user_option` */

DROP TABLE IF EXISTS `user_option`;

CREATE TABLE `user_option` (
  `nUserId` tinyint(3) unsigned NOT NULL,
  `nMenuId` tinyint(3) unsigned NOT NULL,
  `nOptionId` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY  (`nUserId`,`nMenuId`,`nOptionId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `user_option` */

insert  into `user_option`(`nUserId`,`nMenuId`,`nOptionId`) values (1,1,1),(1,1,2),(1,1,3),(1,1,4),(1,1,5),(1,1,6),(1,1,7);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
