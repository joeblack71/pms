DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_RESERVATION_GUEST_LIST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_RESERVATION_GUEST_LIST`(
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
END$$

DELIMITER ;