select month(fFecha) as mes,count(month(fFecha))/*, tCodigoReserva, tNumeroHabitacion, tCodigoCliente*/
from   mdocumento
where  tHotel = 2 and        /* 2:Nazca */
       fFecha >= '2005-11-01' and fFecha <= '2006-10-31'
group by month(fFecha)
order by mes;
