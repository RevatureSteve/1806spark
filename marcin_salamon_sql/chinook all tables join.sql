SELECT * FROM customer c
FULL OUTER JOIN employee e
    ON e.employeeid = c.supportrepid
FULL OUTER JOIN invoice i
    ON i.customerid = c.customerid
FULL OUTER JOIN invoiceline il
    ON il.invoiceid = i.invoiceid
FULL OUTER JOIN track t
    ON t.trackid = il.trackid
FULL OUTER JOIN genre g
    ON g.genreid = t.genreid
FULL OUTER JOIN mediatype m
    ON m.mediatypeid = t.mediatypeid
FULL OUTER JOIN playlisttrack pt
    ON pt.trackid = t.trackid
FULL OUTER JOIN playlist p
    ON pt.playlistid = p.playlistid
FULL OUTER JOIN album a
    ON a.albumid = t.albumid
FULL OUTER JOIN artist ar
    ON a.artistid = ar.artistid;