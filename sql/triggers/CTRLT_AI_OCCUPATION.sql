DELIMITER $$

DROP TRIGGER /*!50032 IF EXISTS */ HOTEL.CTRLT_AI_OCCUPATION$$

CREATE /*DEFINER = jolivas*/ TRIGGER HOTEL.CTRLT_AI_OCCUPATION
	AFTER INSERT ON HOTEL.CTRLT_OCCUPATION FOR EACH ROW

	BEGIN
		DECLARE TENTATIVE			char(01) 	DEFAULT 'T';
		DECLARE CONFIRMED			char(01) 	DEFAULT 'C';
		DECLARE LOCKED				char(01) 	DEFAULT 'L';
		DECLARE MAINTENANCE			char(01) 	DEFAULT 'M';

		DECLARE v_id_hotel			smallint	DEFAULT NEW.MAINP_ID_HOTEL;
		DECLARE v_id_roomtype		smallint	DEFAULT NEW.OCCPP_ID_ROOMTYPE;
		DECLARE v_occupation_date	date		DEFAULT NEW.OCCPP_OCCUPATION_DAY;
		DECLARE v_status			char(01)	DEFAULT NEW.OCCPC_STATUS;
		DECLARE v_quantity_rooms	int			DEFAULT NEW.OCCPC_QUANTITY_ROOMS;
		DECLARE v_total_children	int			DEFAULT NEW.OCCPC_CHILDREN;
		DECLARE v_total_adults		int			DEFAULT NEW.OCCPC_ADULTS;
		DECLARE v_reservation_type	int			DEFAULT NEW.OCCPC_RESERVATION_TYPE;

		DECLARE v_available_rooms	smallint	DEFAULT 0;
		DECLARE v_tentative_rooms	smallint	DEFAULT 0;
		DECLARE v_confirmed_rooms	smallint	DEFAULT 0;
		DECLARE v_locked_rooms		smallint	DEFAULT 0;
		DECLARE v_maintenance_rooms	smallint	DEFAULT 0;
		DECLARE v_current_datetime  datetime	DEFAULT CURRENT_TIMESTAMP();


		IF v_status = TENTATIVE		  THEN SET v_tentative_rooms 	= v_quantity_rooms;
		ELSEIF v_status = CONFIRMED	  THEN SET v_confirmed_rooms 	= v_quantity_rooms;
		ELSEIF v_status = LOCKED 	  THEN SET v_locked_rooms 		= v_quantity_rooms;
		ELSEIF v_status = MAINTENANCE THEN SET v_maintenance_rooms	= v_quantity_rooms;
		END IF;

		UPDATE CTRLT_ROOMTYPE_STATUS
		   SET  RTSTC_TENTATIVE_ROOMS	= RTSTC_TENTATIVE_ROOMS   + v_tentative_rooms,
				RTSTC_COMFIRMED_ROOMS	= RTSTC_COMFIRMED_ROOMS   + v_confirmed_rooms,
				RTSTC_LOCKED_ROOMS		= RTSTC_LOCKED_ROOMS	  + v_locked_rooms,
				RTSTC_MAINTENANCE_ROOMS = RTSTC_MAINTENANCE_ROOMS + v_maintenance_rooms,
				RTSTC_AVAILABLE_ROOMS	= RTSTC_AVAILABLE_ROOMS   - v_quantity_rooms,
				RTSTC_TOTAL_CHILDREN	= RTSTC_TOTAL_CHILDREN	  + v_total_children,
				RTSTC_TOTAL_ADULTS		= RTSTC_TOTAL_ADULTS	  + v_total_adults,
				RTSTC_RESERVATION_TYPE	= v_reservation_type,
				RTSTC_LAST_UPDATE		= v_current_datetime
		 WHERE MAINP_ID_HOTEL 	 = v_id_hotel
		   AND RTSTP_ID_ROOMTYPE = v_id_roomtype
		   AND RTSTP_STATUS_DAY	 = v_occupation_date;

    END$$

DELIMITER ;