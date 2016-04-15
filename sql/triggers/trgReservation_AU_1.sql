DELIMITER //
DROP TRIGGER `doral`.`tgReservation_AU`//

CREATE TRIGGER `tgReservation_AU` AFTER UPDATE ON `reservation` 
FOR EACH ROW
BEGIN
  DECLARE nights tinyint(3) unsigned;
  DECLARE diffNights tinyint(3);
  DECLARE occDay date;
  DECLARE oldOccDay date;
  DECLARE lastDay date;
  DECLARE minDay date;

  SET nights = 1;
  SET diffNights = NEW.nNights - OLD.nNights;
  SET occDay = NEW.dArrival;
  SET oldOccDay = OLD.dArrival;
## Add records when stayed days grown
  IF diffNights > 0 THEN
     SET lastDay = adddate(OLD.dDeparture, INTERVAL -1 DAY);
     REPEAT
       SET lastDay = adddate(lastDay, INTERVAL 1 DAY);
       INSERT INTO occupation
         VALUES (OLD.tRoomType,lastDay, OLD.nReservation, OLD.tRoomNumber,
                 OLD.nAdults, OLD.nChildren, OLD.tReservationStatus);
       SET diffNights = diffNights - 1;
     UNTIL diffNights = 0
     END REPEAT;
  END IF;
## Delete records when stayed days decrease
  IF diffNights < 0 THEN
     #SET lastDay = adddate(OLD.dDeparture, INTERVAL -1 DAY);
     SET lastDay = OLD.dDeparture;
     REPEAT
       SET lastDay = adddate(lastDay, INTERVAL -1 DAY);
       DELETE FROM occupation
         WHERE nReservation = NEW.nReservation AND dOccupationDay = lastDay;
         SET diffNights = diffNights + 1;
     UNTIL diffNights = 0
     END REPEAT;
  END IF;
## Update records with new information
  WHILE nights <= NEW.nNights DO
    IF nights > 1 THEN
       SET occDay    = adddate(occDay, INTERVAL 1 DAY);
       SET oldOccDay = adddate(oldOccDay, INTERVAL 1 DAY);
    END IF;
    UPDATE occupation
      SET tRoomType          = NEW.tRoomType,
          dOccupationDay     = occDay,
          tRoomNumber        = NEW.tRoomNumber,
          nAdults            = NEW.nAdults,
          nChildren          = NEW.nChildren,
          tReservationStatus = NEW.tReservationStatus
      WHERE nReservation   = NEW.nReservation AND
            dOccupationDay = oldOccDay;
    SET nights = nights + 1;
  END WHILE;
END;
//

DELIMITER ;