DELIMITER $$

DROP TRIGGER /*!50032 IF EXISTS */ `hotel`.`CTRLT_AI_RESERVATION`$$

CREATE
    /*!50017 DEFINER = 'root'@'localhost' */
    TRIGGER `CTRLT_AI_RESERVATION` AFTER INSERT ON `CTRLT_RESERVATION` 
    FOR EACH ROW BEGIN
		DECLARE occupation_day		date;
		-- DECLARE quantity 			int 	 DEFAULT 0;
		DECLARE v_current_datetime	datetime DEFAULT CURRENT_TIMESTAMP();

		-- WHILE quantity <= NEW.RESVC_QUANTITY DO
			-- SET occupation_day = NEW.RESVC_ARRIVAL;
			-- REPEAT
		SET occupation_day = NEW.RESVC_ARRIVAL;
		WHILE occupation_day < NEW.RESVC_DEPARTURE DO
				INSERT INTO CTRLT_OCCUPATION(
							MAINP_ID_HOTEL,
							OCCPP_ID_ROOMTYPE,
							OCCPP_OCCUPATION_DAY,
							OCCPP_ID_RESERVATION,
							OCCPC_RESERVATION_TYPE,
							OCCPC_QUANTITY_ROOMS,
							OCCPC_ROOM_NUMBER,
							OCCPC_ADULTS,
							OCCPC_CHILDREN,
							OCCPC_STATUS,
							OCCPC_MADE_ON
							) VALUES (
							NEW.MAINP_ID_HOTEL,
							NEW.RTYPF_ID_ROOMTYPE,
							occupation_day,
							NEW.RESVP_ID_RESERVATION,
							NEW.RESVC_RESERVATION_TYPE,
							NEW.RESVC_QUANTITY,
							NEW.ROOMF_ID_ROOM,
							NEW.RESVC_ADULTS,
							NEW.RESVC_CHILDREN,
							NEW.RESVC_STATUS,
							v_current_datetime );
				SET occupation_day = ADDDATE(occupation_day, INTERVAL 1 DAY);
		END WHILE;
			-- UNTIL occupation_day >= NEW.RESVC_DEPARTURE
			-- END REPEAT;
			-- SET quantity = quantity + 1;
		-- END WHILE;
	END;
$$

DELIMITER ;