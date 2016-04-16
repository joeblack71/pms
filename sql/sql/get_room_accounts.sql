SELECT nIdBill idBill,
       c.nIdCustomer idCustomer,
	   DATE_FORMAT(dCreationDate,'%d/%m/%Y') creationDate,
	   nBalance balance,
	   gb.tStatus status,
	   CONCAT(c.tLastName1,
	   CONCAT(', ',tFirstNames) ) guestNames,
       tInitials initials
  FROM stt_guest_bill gb
       LEFT JOIN customer c ON gb.nIdCustomer = c.nIdCustomer
 WHERE gb.nIdCustomer = '1'   AND gb.nIdBill like '%'
 ORDER BY idCustomer, idBill;