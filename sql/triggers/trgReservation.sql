## After INSERT operation
DELIMITER //
DROP TRIGGER `doral`.`tgReservation_AI`//
CREATE TRIGGER tgReservation_AI AFTER INSERT ON reservation
FOR EACH ROW
BEGIN
  DECLARE nights tinyint(3) unsigned;
  DECLARE occDay date;

  SET nights = 1;
  SET occDay = NEW.dArrival;
  WHILE nights <= NEW.nNights DO
    IF nights > 1 THEN
       SET occDay = adddate(occDay, INTERVAL 1 DAY);
    END IF;
    INSERT INTO occupation
      SET tRoomType          = NEW.tRoomType,    dOccupationDay = occDay,
          nReservation       = NEW.nReservation, tRoomNumber    = NEW.tRoomNumber,
          nAdults            = NEW.nAdults,      nChildren      = NEW.nChildren,
          tReservationStatus = NEW.tReservationStatus;
    SET nights = nights + 1;
  END WHILE;
END//
DELIMITER ;

## After UPDATE operation
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

  IF diffNights < 0 THEN
     SET lastDay = OLD.dDeparture;
     REPEAT
       SET lastDay = adddate(lastDay, INTERVAL -1 DAY);
       DELETE FROM occupation
         WHERE nReservation = NEW.nReservation AND dOccupationDay = lastDay;
         SET diffNights = diffNights + 1;
     UNTIL diffNights = 0
     END REPEAT;
  END IF;

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
END//
DELIMITER ;

## Before DELETE operation
DELIMITER //
DROP TRIGGER `doral`.`tgReservation_BD`//
CREATE TRIGGER tgReservation_BD BEFORE DELETE ON reservation
FOR EACH ROW
  DELETE FROM occupation
         WHERE nReservation = OLD.nReservation;
//
DELIMITER ;
