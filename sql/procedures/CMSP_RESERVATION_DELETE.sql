DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_RESERVATION_DELETE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_RESERVATION_DELETE`(
					IN idHotel tinyint, IN resNumber smallint )
BEGIN
	UPDATE reservation SET tStatus = "*"
	 WHERE nIdHotel = idHotel
	   AND nIdReservation = resNumber;
    END$$

DELIMITER ;