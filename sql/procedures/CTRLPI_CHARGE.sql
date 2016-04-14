DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_CHARGE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_CHARGE`(
					    IN p_idHotel		int,
						IN p_idCustomer		int,
						IN p_idBill			int,
						IN p_ChargeDate		varchar(10),
						IN p_idAccount		int,
						IN p_totalCharge	decimal,
						IN p_CheckType		int,
						IN p_CheckNumber	int,
						IN p_MadeBy			int,
						IN p_status			char(1) )
BEGIN
	declare v_secuence int default 0;
	SELECT max(nSecuence) + 1 INTO v_secuence
	  FROM stt_bill_charge
	 WHERE nIdHotel = p_idHotel
       AND nIdCustomer = p_idCustomer
       AND nIdBill = p_idBill;
    INSERT INTO stt_bill_charge(
			nIdHotel, nIdCustomer, nIdBill,	nSecuence,
			dChargeDate, nIdAccount, nTotalCharge, tCheckType,
			nCheckNumber, dMadeOn, tMadeBy, tStatus)
		VALUES(
			p_idHotel, p_idCustomer, p_idBill, v_secuence,
			STR_TO_DATE(p_chargeDate, '%d/%m/%Y'),
			p_idAccount, p_totalCharge, p_checkType,
			p_checkNumber, CURRENT_TIMESTAMP(), p_madeBy, p_status);
END$$

DELIMITER ;