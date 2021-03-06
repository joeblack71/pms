DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPD_RESERVATION`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_RESERVATION`(
											IN id_hotel			varchar(02),
											IN id_reservation	varchar(05) )
BEGIN
		-- DECLARE foo int default 0;
		-- DECLARE MYSQL_BUG CONDITION FOR SQLSTATE '21S01'; -- ER_WRONG_VALUE_COUNT 21S01
		DECLARE CONTINUE HANDLER FOR SQLSTATE '21S01' BEGIN END; 

		UPDATE CTRLT_RESERVATION
		-- DELETE FROM CTRLT_RESERVATION
		   SET RESVC_STATUS = '*'
		 WHERE MAINP_ID_HOTEL = id_hotel
		   AND RESVP_ID_RESERVATION = id_reservation;

END$$

DELIMITER ;