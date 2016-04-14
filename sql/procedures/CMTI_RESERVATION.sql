DELIMITER $$

DROP TRIGGER /*!50032 IF EXISTS */ `hotel`.`tgReservation_AI`$$

CREATE
    /*!50017 DEFINER = 'root'@'localhost' */
    TRIGGER `hotel`.`tgReservation_AI` AFTER INSERT ON `hotel`.`reservation` 
    FOR EACH ROW BEGIN
    DECLARE occDay date;
    DECLARE quantity int;
    /*SET occDay = NEW.dArrival;*/
    SET quantity = 1;
    WHILE quantity <= NEW.RESVC_QUANTITY DO
      SET occDay = NEW.RESVC_ARRIVAL;
      REPEAT
        INSERT INTO occupation VALUES
	      (NEW.RESVP_ID_HOTEL,       NEW.RESVF_ID_ROOMTYPE,      occDay,
	       NEW.RESVP_ID_RESERVATION, NEW.RESVC_RESERVATION_TYPE, NEW.RESVC_QUANTITY,
	       NEW.RESVF_ID_ROOM,        NEW.RESVC_ADULTS,           NEW.RESVC_CHILDREN, NEW.RESVC_STATUS);
        SET occDay = adddate(occDay, INTERVAL 1 DAY);
      UNTIL occDay >= NEW.RESVC_DEPARTURE
      END REPEAT;
      SET quantity = quantity + 1;
    END WHILE;
END;
$$

DELIMITER ;