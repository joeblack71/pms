SELECT TOP 6 tCodigoTributario,md.tDocumento,nNeto,
       /*j1.tCodigoImpuesto,*/j1.nPorcImpuesto,j1.nPrecioImpuesto,
       /*j2.tCodigoImpuesto,*/j2.nPorcImpuesto,j2.nPrecioImpuesto,
       nVenta
FROM   mdocumento as md
       LEFT JOIN timpuestomdocumento AS j1 ON md.tDocumento = j1.tDocumento AND
                 j1.tCodigoImpuesto = 1
       LEFT JOIN timpuestomdocumento AS j2 ON md.tDocumento = j2.tDocumento
       WHERE tCodigoTributario = '20100912768' AND j2.tCodigoImpuesto = 2
ORDER BY md.tDocumento