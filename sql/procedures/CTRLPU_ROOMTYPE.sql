DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPU_ROOMTYPE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_ROOMTYPE`(
					    IN p_id_hotel			varchar(02),
					    IN p_id_roomtype		varchar(02),
						IN p_roomtype_code		varchar(02),
						IN p_description		varchar(20),
						IN p_rack_rate			varchar(14),
						IN p_total_rooms		varchar(03),
						IN p_available_rooms	varchar(03),
						IN p_locked_rooms		varchar(03),
						IN p_status				varchar(01) )
BEGIN
	UPDATE CTRLT_ROOMTYPE
			SET RTYPC_ROOMTYPE_CODE		= p_roomtype_code,
			    RTYPC_DESCRIPTION		= p_description,
				RTYPC_RACK_RATE			= p_rack_rate,
				RTYPC_QUANTITY_ROOMS 	= p_total_rooms,
				RTYPC_AVAILABLE_ROOMS 	= p_available_rooms,
				RTYPC_LOCKED_ROOMS		= p_locked_rooms,
				RTYPC_STATUS 			= p_status
	 WHERE MAINP_ID_HOTEL = p_id_hotel AND RTYPP_ID_ROOMTYPE = p_id_roomtype;
END$$

DELIMITER ;