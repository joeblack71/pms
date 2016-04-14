DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_TABLE_ITEM_LIST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_TABLE_ITEM_LIST`(
					IN p_idModule VARCHAR(02),
					IN p_idTable  VARCHAR(02) )

BEGIN
	SELECT 	nIdTable			idTable,
			nIdItem				idItem,
			tItemDescription	description,
			nVipStatus			status
	  FROM table_item ti
	 WHERE nIdTable = p_idTable;
END$$

DELIMITER ;