DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPD_GUEST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_GUEST`(
						IN idHotel int,
						IN idReservation int)
BEGIN
        DELETE FROM CTRLT_GUEST
		 WHERE MAINP_ID_HOTEL = idHotel AND RESVP_ID_RESERVATION = idReservation;
END$$

DELIMITER ;