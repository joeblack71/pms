DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_GUEST_DELETE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_GUEST_DELETE`(
						IN idHotel tinyint,
						IN idReservation smallint)
BEGIN
        DELETE FROM reservation_guest
		 WHERE nIdHotel = idHotel AND nIdReservation = idReservation;
END$$

DELIMITER ;