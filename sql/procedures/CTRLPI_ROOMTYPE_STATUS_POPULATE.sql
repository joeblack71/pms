DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_ROOMTYPE_STATUS_POPULATE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_ROOMTYPE_STATUS_POPULATE`(
					   OUT p_result				varchar(06),
					    IN p_id_hotel			varchar(02),
						IN p_id_roomtype		varchar(02),
						IN p_start_status_date	varchar(10),
						IN p_end_status_date	varchar(10) )

BEGIN
	DECLARE v_current_timestamp datetime DEFAULT current_timestamp();
	DECLARE v_total_rooms			 int DEFAULT 0;
	DECLARE v_available_rooms		 int DEFAULT 0;
	DECLARE v_start_status_date	    date DEFAULT STR_TO_DATE(p_start_status_date, '%d/%m/%Y');
	DECLARE v_end_status_date	    date DEFAULT STR_TO_DATE(p_end_status_date, '%d/%m/%Y');
	DECLARE v_current_status_date   date DEFAULT v_start_status_date;
	DECLARE ZERO					 int DEFAULT 0;

	SELECT T.RTYPC_AVAILABLE_ROOMS into v_total_rooms
      FROM CTRLT_ROOMTYPE T
     WHERE T.MAINP_ID_HOTEL = p_id_hotel
	   AND T.RTYPP_ID_ROOMTYPE = p_id_roomtype;

    WHILE v_current_status_date <= v_end_status_date DO
		INSERT INTO CTRLT_ROOMTYPE_STATUS(
					MAINP_ID_HOTEL,
					RTSTP_ID_ROOMTYPE,
					RTSTP_STATUS_DAY,
					RTSTC_TOTAL_ROOMS,
					RTSTC_AVAILABLE_ROOMS, -- from room_type
					RTSTC_TENTATIVE_ROOMS,
					RTSTC_COMFIRMED_ROOMS,
					RTSTC_LOCKED_ROOMS,
					RTSTC_MAINTENANCE_ROOMS,
					RTSTC_TOTAL_CHILDREN,
					RTSTC_TOTAL_ADULTS,
					RTSTC_RESERVATION_TYPE,
					RTSTC_LAST_UPDATE
					) VALUES (
					p_id_hotel,
					p_id_roomtype,
					v_current_status_date,
					v_total_rooms,
					v_total_rooms, -- Available rooms
					ZERO,
					ZERO,
					ZERO,
					ZERO,
					ZERO,
					ZERO,
					'',
					v_current_timestamp );
        SET v_current_status_date = adddate(v_current_status_date, INTERVAL 1 DAY);
    END WHILE;

	SET p_result = 0; -- 'OK'
END$$

DELIMITER ;