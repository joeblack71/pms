DELIMITER $$

DROP TRIGGER `hotel`.`tgReservation_AI`$$

create trigger `hotel`.`tgReservation_AI` AFTER INSERT on `hotel`.`reservation` 
for each row BEGIN
    DECLARE occDay date;
    DECLARE quantity int;
    /*SET occDay = NEW.dArrival;*/
    SET quantity = 1;
    WHILE quantity <= NEW.nQuantity DO
      SET occDay = NEW.dArrival;
      REPEAT
        INSERT INTO occupation VALUES
	      (NEW.nHotelId,     NEW.tRoomType, occDay,
	       NEW.nReservation, NEW.tReservationType,         NEW.nQuantity,
	       NEW.tRoomNumber,  NEW.nAdults,   NEW.nChildren, NEW.tStatus);
        SET occDay = adddate(occDay, INTERVAL 1 DAY);
      UNTIL occDay >= NEW.dDeparture
      END REPEAT;
      SET quantity = quantity + 1;
    END WHILE;
END;
$$

DELIMITER ;