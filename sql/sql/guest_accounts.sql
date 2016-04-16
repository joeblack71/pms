select 
	   nIdBill idBill,
	   c.nIdCustomer idCustomer,
	   DATE_FORMAT(dCreationDate,'%d/%m/%Y') creationDate,
	   nBalance balance,
	   CONCAT(c.tLastName1, CONCAT(', ',tFirstNames) ) guestNames,
       tInitials initials
  from guest_bill b
	   left join customer c on b.nIdCustomer = c.nIdCustomer
 where b.nIdCustomer = "1"