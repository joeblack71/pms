select month(fLlegada) as mes,count(month(fLlegada))
from   mreserva, testadoreserva
where  tHotel = 2 and        
       fLlegada >= '2005-11-01' and fLlegada <= '2006-10-31' and
       tCodigoReserva != ' ' and tEstadoReserva = tCodigo and
       tEstadoReserva != '05'
group by month(fLlegada)
with rollup;
/*order by mes;*/

/*
select fLlegada, tCodigoReserva, tCodigo, tDetalladoReserva
from   mreserva, testadoreserva 
where  tHotel = 2 and
       fLlegada >= '2005-11-01' and fLlegada <= '2006-10-31' and
       tCodigoReserva != ' ' and tEstadoReserva = tCodigo and
       tEstadoReserva != '05'
order by fLlegada;
*/

/*
select count(*) from mdocumento
where  tHotel = 2 and
       year(fFecha) = 2005 and month(fFecha) = 11;
*/
