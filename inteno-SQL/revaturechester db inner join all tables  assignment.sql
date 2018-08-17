select * from album, artist, customer, employee, genre, invoice, invoiceline, mediatype, playlist, playlisttrack, track;

select * from customer
inner join employee on employee.employeeid = customer.customerid
inner join invoice on invoice.customerid = customer.customerid
inner join invoiceline on invoice.customerid = invoiceline.invoicelineid
inner join track on track.trackid = invoiceline.invoicelineid
inner join genre on genre.genreid = track.trackid
inner join mediatype on mediatype.mediatypeid =track.trackid
inner join album on album.albumid = track.trackid
inner join artist on artist.artistid = track.trackid
inner join playlisttrack on playlisttrack.playlistid = track.trackid
inner join playlist on playlist.playlistid = playlisttrack.playlistid;