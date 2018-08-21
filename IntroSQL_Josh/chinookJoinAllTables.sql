SELECT *
FROM ++album al, ++artist ar, ++customer cu, ++employee em, ++genre ge, ++invoice in, invoiceline inl++, ++mediatype me, ++playlist pl, 
       ++ playlisttrack pltr, ++track tr
WHERE em.
/
select *
from employee em, customer cu, invoice inv, invoiceline inl, track tr, playlisttrack pltr, playlist pl, mediatype me, genre ge, album al, artist ar
where em.employeeid = cu.supportrepid AND
cu.customerid = inv.customerid AND
inv.invoiceid = inl.invoiceid AND
tr.trackid = inl.trackid AND
tr.trackid = pltr.trackid AND
pl.playlistid =  pltr.playlistid AND
me.mediatypeid = tr.mediatypeid AND
ge.genreid = tr.genreid AND
al.albumid = tr.albumid AND
ar.artistid = al.artistid
;

