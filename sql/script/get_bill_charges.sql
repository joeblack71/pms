select bc.nIdBill, bc.nSecuence, bc.nIdAccount,
	   bc.nTotalCharge, bc.tCheckType, bc.nCheckNumber,
       bc.dMadeOn, bc.tMadeBy, bc.tstatus
from stt_guest_bill gb
     left join stt_bill_charge bc on gb.nIdBill = bc.nIdBill
where gb.nIdHotel = 1
  and gb.nIdCustomer = 1
  and gb.nIdBill = 2
  and gb.tStatus = 'A'