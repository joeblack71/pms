DELIMITER $$

DROP TRIGGER `hotel`.`tgReservation_AU`$$

create trigger `hotel`.`tgReservation_AU` AFTER UPDATE on `hotel`.`reservation` 
for each row BEGIN
##  DECLARE nights tinyint(3) unsigned;
  DECLARE occDay date;
  DECLARE quantity int;

/* If any of arrival, departure or quantity vary,
 then delete all records in 'occupation' table
*/
  IF NEW.tRoomType  = OLD.tRoomType  AND
     NEW.dArrival   = OLD.dArrival   AND
     NEW.dDeparture = OLD.dDeparture AND
     NEW.nQuantity  = OLD.nQuantity THEN
     UPDATE occupation
        SET tRoomNumber        = NEW.tRoomNumber,
            nAdults            = NEW.nAdults,
            nChildren          = NEW.nChildren,
            tStatus            = NEW.tStatus
      WHERE nHotelId = NEW.nHotelId AND nReservation = NEW.nReservation;
  ELSE
     DELETE FROM occupation
            WHERE nHotelId     = NEW.nHotelId AND
                  nReservation = NEW.nReservation;
## Arrival MUST BE less than Departure !!
     SET quantity = 1;
     WHILE quantity <= NEW.nQuantity DO
       SET occDay = NEW.dArrival;
       REPEAT
         INSERT INTO occupation
           VALUES (NEW.nHotelId, NEW.tRoomType, occDay, NEW.nReservation, NEW.tRoomNumber,
                   NEW.nAdults,  NEW.nChildren, NEW.tStatus);
         SET occDay = adddate(occDay, INTERVAL 1 DAY);
       UNTIL occDay >= NEW.dDeparture
       END REPEAT;
       SET quantity = quantity + 1;
     END WHILE;
  END IF;
END;
$$

DELIMITER ;