DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_GUEST_INSERT`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_GUEST_INSERT`(
					    IN p_idHotel			varchar(02),
						IN p_idReservation		varchar(06),
						IN p_idCustomer			varchar(06) )
BEGIN
    INSERT INTO reservation_guest(
			nIdHotel, nIdReservation, nIdCustomer )
	VALUES(	p_idHotel, p_idReservation, p_idCustomer );
END$$

DELIMITER ;