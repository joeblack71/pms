DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_GUEST_LIST`$$

CREATE DEFINER=`root`@`localhost`

PROCEDURE `CMSP_GUEST_LIST`(
							IN p_idHotel varchar(02),
							IN p_status  varchar(01) )
BEGIN

	SELECT 	nIdHotel			idHotel,
			nIdReservation		idReservation,
			nIdCustomer			idCustomer,
			c.nDocumentNumber	documentNumber,
			CONCAT(c.lastname1, ',', c.firstnames)
								customerNames,
			tStatus				status
	  FROM reservation_guest rg
			LEFT JOIN customer c ON rg.nIdCustomer = c.idCustomer
	 WHERE p_idHotel = nIdHotel
	   AND ( p_status = '' OR p_status = tStatus );

END$$

DELIMITER ;