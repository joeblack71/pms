DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_RESERVATION_DELETE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_RESERVATION_DELETE`(
					IN idHotel tinyint, IN resNumber smallint )
BEGIN
	UPDATE reservation SET RESVC_STATUS = "*"
	 WHERE RESVP_ID_HOTEL = idHotel
	   AND RESVP_ID_RESERVATION = resNumber;
    END$$

DELIMITER ;