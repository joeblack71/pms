DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_ROOMTYPE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_ROOMTYPE`(
					   OUT p_id_roomtype		int,
					    IN p_id_hotel			varchar(02),
						IN p_roomtype_code		varchar(02),
						IN p_description		varchar(20),
						IN p_rack_rate			varchar(10),
						IN p_total_rooms		varchar(03),
						IN p_available_rooms	varchar(03),
						IN p_locked_rooms		varchar(03),
						IN p_made_by			varchar(03) )
BEGIN
	DECLARE v_current_date date default current_date();

    INSERT INTO CTRLT_ROOMTYPE(
			MAINP_ID_HOTEL,
			RTYPP_ID_ROOMTYPE,
			RTYPC_ROOMTYPE_CODE,
			RTYPC_DESCRIPTION,
			RTYPC_RACK_RATE,
			RTYPC_QUANTITY_ROOMS,
			RTYPC_AVAILABLE_ROOMS,
			RTYPC_LOCKED_ROOMS,
			-- RTYPC_STATUS,
			RTYPC_MADE_BY,
			RTYPC_MADE_ON,
			RTYPC_UPDATED_BY,
			RTYPC_LAST_UPDATE )
	VALUES(	p_id_hotel,
			null,
			p_roomtype_code,
			p_description,
			p_rack_rate,
			p_total_rooms,
			p_available_rooms,
			p_locked_rooms,
			p_made_by,
			v_current_date,
			p_made_by,
			v_current_date );
	SET p_id_roomtype = LAST_INSERT_ID();
END$$

DELIMITER ;