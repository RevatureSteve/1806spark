--------------------------------------------------------
--  File created - Monday-August-13-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ALBUM
--------------------------------------------------------

  CREATE TABLE "RHYSYAMASAKI"."ALBUM" 
   (	"ALBUMID" NUMBER, 
	"TITLE" VARCHAR2(160 BYTE), 
	"ARTISTID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ARTIST
--------------------------------------------------------

  CREATE TABLE "RHYSYAMASAKI"."ARTIST" 
   (	"ARTISTID" NUMBER, 
	"NAME" VARCHAR2(120 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CUSTOMER
--------------------------------------------------------

  CREATE TABLE "RHYSYAMASAKI"."CUSTOMER" 
   (	"CUSTOMERID" NUMBER, 
	"FIRSTNAME" VARCHAR2(40 BYTE), 
	"LASTNAME" VARCHAR2(20 BYTE), 
	"COMPANY" VARCHAR2(80 BYTE), 
	"ADDRESS" VARCHAR2(70 BYTE), 
	"CITY" VARCHAR2(40 BYTE), 
	"STATE" VARCHAR2(40 BYTE), 
	"COUNTRY" VARCHAR2(40 BYTE), 
	"POSTALCODE" VARCHAR2(10 BYTE), 
	"PHONE" VARCHAR2(24 BYTE), 
	"FAX" VARCHAR2(24 BYTE), 
	"EMAIL" VARCHAR2(60 BYTE), 
	"SUPPORTREPID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EMPLOYEE
--------------------------------------------------------

  CREATE TABLE "RHYSYAMASAKI"."EMPLOYEE" 
   (	"NAME" VARCHAR2(4000 BYTE), 
	"AGE" NUMBER(38,0), 
	"SALARY" NUMBER(18,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table GENRE
--------------------------------------------------------

  CREATE TABLE "RHYSYAMASAKI"."GENRE" 
   (	"GENREID" NUMBER, 
	"NAME" VARCHAR2(120 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table INVOICE
--------------------------------------------------------

  CREATE TABLE "RHYSYAMASAKI"."INVOICE" 
   (	"INVOICEID" NUMBER, 
	"CUSTOMERID" NUMBER, 
	"INVOICEDATE" DATE, 
	"BILLINGADDRESS" VARCHAR2(70 BYTE), 
	"BILLINGCITY" VARCHAR2(40 BYTE), 
	"BILLINGSTATE" VARCHAR2(40 BYTE), 
	"BILLINGCOUNTRY" VARCHAR2(40 BYTE), 
	"BILLINGPOSTALCODE" VARCHAR2(10 BYTE), 
	"TOTAL" NUMBER(10,2)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table INVOICELINE
--------------------------------------------------------

  CREATE TABLE "RHYSYAMASAKI"."INVOICELINE" 
   (	"INVOICELINEID" NUMBER, 
	"INVOICEID" NUMBER, 
	"TRACKID" NUMBER, 
	"UNITPRICE" NUMBER(10,2), 
	"QUANTITY" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MEDIATYPE
--------------------------------------------------------

  CREATE TABLE "RHYSYAMASAKI"."MEDIATYPE" 
   (	"MEDIATYPEID" NUMBER, 
	"NAME" VARCHAR2(120 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PLAYLIST
--------------------------------------------------------

  CREATE TABLE "RHYSYAMASAKI"."PLAYLIST" 
   (	"PLAYLISTID" NUMBER, 
	"NAME" VARCHAR2(120 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PLAYLISTTRACK
--------------------------------------------------------

  CREATE TABLE "RHYSYAMASAKI"."PLAYLISTTRACK" 
   (	"PLAYLISTID" NUMBER, 
	"TRACKID" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TRACK
--------------------------------------------------------

  CREATE TABLE "RHYSYAMASAKI"."TRACK" 
   (	"TRACKID" NUMBER, 
	"NAME" VARCHAR2(200 BYTE), 
	"ALBUMID" NUMBER, 
	"MEDIATYPEID" NUMBER, 
	"GENREID" NUMBER, 
	"COMPOSER" VARCHAR2(220 BYTE), 
	"MILLISECONDS" NUMBER, 
	"BYTES" NUMBER, 
	"UNITPRICE" NUMBER(10,2)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into RHYSYAMASAKI.ALBUM
SET DEFINE OFF;
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (225,'Volume Dois',146);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (226,'Battlestar Galactica: The Story So Far',147);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (227,'Battlestar Galactica, Season 3',147);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (228,'Heroes, Season 1',148);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (229,'Lost, Season 3',149);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (230,'Lost, Season 1',149);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (231,'Lost, Season 2',149);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (232,'Achtung Baby',150);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (233,'All That You Can''t Leave Behind',150);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (234,'B-Sides 1980-1990',150);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (235,'How To Dismantle An Atomic Bomb',150);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (236,'Pop',150);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (237,'Rattle And Hum',150);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (238,'The Best Of 1980-1990',150);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (239,'War',150);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (240,'Zooropa',150);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (241,'UB40 The Best Of - Volume Two [UK]',151);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (242,'Diver Down',152);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (243,'The Best Of Van Halen, Vol. I',152);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (244,'Van Halen',152);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (245,'Van Halen III',152);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (246,'Contraband',153);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (247,'Vinicius De Moraes',72);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (248,'Ao Vivo [IMPORT]',155);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (249,'The Office, Season 1',156);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (250,'The Office, Season 2',156);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (251,'The Office, Season 3',156);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (252,'Un-Led-Ed',157);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (253,'Battlestar Galactica (Classic), Season 1',158);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (254,'Aquaman',159);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (255,'Instant Karma: The Amnesty International Campaign to Save Darfur',150);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (256,'Speak of the Devil',114);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (257,'20th Century Masters - The Millennium Collection: The Best of Scorpions',179);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (258,'House of Pain',180);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (259,'Radio Brasil (O Som da Jovem Vanguarda) - Seleccao de Henrique Amaro',36);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (260,'Cake: B-Sides and Rarities',196);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (261,'LOST, Season 4',149);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (262,'Quiet Songs',197);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (263,'Muso Ko',198);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (264,'Realize',199);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (265,'Every Kind of Light',200);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (266,'Duos II',201);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (267,'Worlds',202);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (268,'The Best of Beethoven',203);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (269,'Temple of the Dog',204);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (270,'Carry On',205);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (271,'Revelations',8);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (272,'Adorate Deum: Gregorian Chant from the Proper of the Mass',206);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (273,'Allegri: Miserere',207);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (274,'Pachelbel: Canon & Gigue',208);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (275,'Vivaldi: The Four Seasons',209);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (276,'Bach: Violin Concertos',210);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (277,'Bach: Goldberg Variations',211);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (278,'Bach: The Cello Suites',212);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (279,'Handel: The Messiah (Highlights)',213);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (280,'The World of Classical Favourites',214);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (281,'Sir Neville Marriner: A Celebration',215);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (282,'Mozart: Wind Concertos',216);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (283,'Haydn: Symphonies 99 - 104',217);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (284,'Beethoven: Symhonies Nos. 5 & 6',218);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (285,'A Soprano Inspired',219);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (286,'Great Opera Choruses',220);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (287,'Wagner: Favourite Overtures',221);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (288,'Fauré: Requiem, Ravel: Pavane & Others',222);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (289,'Tchaikovsky: The Nutcracker',223);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (290,'The Last Night of the Proms',224);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (291,'Puccini: Madama Butterfly - Highlights',225);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (292,'Holst: The Planets, Op. 32 & Vaughan Williams: Fantasies',226);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (293,'Pavarotti''s Opera Made Easy',227);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (294,'Great Performances - Barber''s Adagio and Other Romantic Favorites for Strings',228);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (295,'Carmina Burana',229);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (296,'A Copland Celebration, Vol. I',230);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (297,'Bach: Toccata & Fugue in D Minor',231);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (298,'Prokofiev: Symphony No.1',232);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (299,'Scheherazade',233);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (300,'Bach: The Brandenburg Concertos',234);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (301,'Chopin: Piano Concertos Nos. 1 & 2',235);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (302,'Mascagni: Cavalleria Rusticana',236);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (303,'Sibelius: Finlandia',237);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (304,'Beethoven Piano Sonatas: Moonlight & Pastorale',238);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (305,'Great Recordings of the Century - Mahler: Das Lied von der Erde',240);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (306,'Elgar: Cello Concerto & Vaughan Williams: Fantasias',241);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (307,'Adams, John: The Chairman Dances',242);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (308,'Tchaikovsky: 1812 Festival Overture, Op.49, Capriccio Italien & Beethoven: Wellington''s Victory',243);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (309,'Palestrina: Missa Papae Marcelli & Allegri: Miserere',244);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (310,'Prokofiev: Romeo & Juliet',245);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (311,'Strauss: Waltzes',226);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (312,'Berlioz: Symphonie Fantastique',245);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (313,'Bizet: Carmen Highlights',246);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (314,'English Renaissance',247);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (315,'Handel: Music for the Royal Fireworks (Original Version 1749)',208);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (316,'Grieg: Peer Gynt Suites & Sibelius: Pelléas et Mélisande',248);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (317,'Mozart Gala: Famous Arias',249);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (318,'SCRIABIN: Vers la flamme',250);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (319,'Armada: Music from the Courts of England and Spain',251);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (320,'Mozart: Symphonies Nos. 40 & 41',248);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (321,'Back to Black',252);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (322,'Frank',252);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (323,'Carried to Dust (Bonus Track Version)',253);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (324,'Beethoven: Symphony No. 6 ''Pastoral'' Etc.',254);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (325,'Bartok: Violin & Viola Concertos',255);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (326,'Mendelssohn: A Midsummer Night''s Dream',256);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (327,'Bach: Orchestral Suites Nos. 1 - 4',257);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (328,'Charpentier: Divertissements, Airs & Concerts',258);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (329,'South American Getaway',259);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (330,'Górecki: Symphony No. 3',260);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (331,'Purcell: The Fairy Queen',261);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (332,'The Ultimate Relexation Album',262);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (333,'Purcell: Music for the Queen Mary',263);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (334,'Weill: The Seven Deadly Sins',264);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (335,'J.S. Bach: Chaconne, Suite in E Minor, Partita in E Major & Prelude, Fugue and Allegro',265);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (336,'Prokofiev: Symphony No.5 & Stravinksy: Le Sacre Du Printemps',248);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (337,'Szymanowski: Piano Works, Vol. 1',266);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (338,'Nielsen: The Six Symphonies',267);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (339,'Great Recordings of the Century: Paganini''s 24 Caprices',268);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (340,'Liszt - 12 Études D''Execution Transcendante',269);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (341,'Great Recordings of the Century - Shubert: Schwanengesang, 4 Lieder',270);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (342,'Locatelli: Concertos for Violin, Strings and Continuo, Vol. 3',271);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (343,'Respighi:Pines of Rome',226);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (344,'Schubert: The Late String Quartets & String Quintet (3 CD''s)',272);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (345,'Monteverdi: L''Orfeo',273);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (346,'Mozart: Chamber Music',274);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (347,'Koyaanisqatsi (Soundtrack from the Motion Picture)',275);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (1,'For Those About To Rock We Salute You',1);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (2,'Balls to the Wall',2);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (3,'Restless and Wild',2);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (4,'Let There Be Rock',1);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (5,'Big Ones',3);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (6,'Jagged Little Pill',4);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (7,'Facelift',5);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (8,'Warner 25 Anos',6);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (9,'Plays Metallica By Four Cellos',7);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (10,'Audioslave',8);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (11,'Out Of Exile',8);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (12,'BackBeat Soundtrack',9);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (13,'The Best Of Billy Cobham',10);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (14,'Alcohol Fueled Brewtality Live! [Disc 1]',11);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (15,'Alcohol Fueled Brewtality Live! [Disc 2]',11);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (16,'Black Sabbath',12);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (17,'Black Sabbath Vol. 4 (Remaster)',12);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (18,'Body Count',13);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (19,'Chemical Wedding',14);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (20,'The Best Of Buddy Guy - The Millenium Collection',15);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (21,'Prenda Minha',16);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (22,'Sozinho Remix Ao Vivo',16);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (23,'Minha Historia',17);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (24,'Afrociberdelia',18);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (25,'Da Lama Ao Caos',18);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (26,'Acústico MTV [Live]',19);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (27,'Cidade Negra - Hits',19);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (28,'Na Pista',20);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (29,'Axé Bahia 2001',21);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (30,'BBC Sessions [Disc 1] [Live]',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (31,'Bongo Fury',23);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (32,'Carnaval 2001',21);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (33,'Chill: Brazil (Disc 1)',24);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (34,'Chill: Brazil (Disc 2)',6);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (35,'Garage Inc. (Disc 1)',50);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (36,'Greatest Hits II',51);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (37,'Greatest Kiss',52);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (38,'Heart of the Night',53);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (39,'International Superhits',54);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (40,'Into The Light',55);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (41,'Meus Momentos',56);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (42,'Minha História',57);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (43,'MK III The Final Concerts [Disc 1]',58);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (44,'Physical Graffiti [Disc 1]',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (45,'Sambas De Enredo 2001',21);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (46,'Supernatural',59);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (47,'The Best of Ed Motta',37);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (48,'The Essential Miles Davis [Disc 1]',68);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (49,'The Essential Miles Davis [Disc 2]',68);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (50,'The Final Concerts (Disc 2)',58);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (51,'Up An'' Atom',69);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (52,'Vinícius De Moraes - Sem Limite',70);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (53,'Vozes do MPB',21);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (54,'Chronicle, Vol. 1',76);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (55,'Chronicle, Vol. 2',76);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (56,'Cássia Eller - Coleção Sem Limite [Disc 2]',77);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (57,'Cássia Eller - Sem Limite [Disc 1]',77);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (58,'Come Taste The Band',58);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (59,'Deep Purple In Rock',58);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (60,'Fireball',58);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (61,'Knocking at Your Back Door: The Best Of Deep Purple in the 80''s',58);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (62,'Machine Head',58);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (63,'Purpendicular',58);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (64,'Slaves And Masters',58);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (65,'Stormbringer',58);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (66,'The Battle Rages On',58);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (67,'Vault: Def Leppard''s Greatest Hits',78);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (68,'Outbreak',79);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (69,'Djavan Ao Vivo - Vol. 02',80);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (70,'Djavan Ao Vivo - Vol. 1',80);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (71,'Elis Regina-Minha História',41);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (72,'The Cream Of Clapton',81);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (73,'Unplugged',81);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (74,'Album Of The Year',82);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (75,'Angel Dust',82);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (76,'King For A Day Fool For A Lifetime',82);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (77,'The Real Thing',82);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (78,'Deixa Entrar',83);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (79,'In Your Honor [Disc 1]',84);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (80,'In Your Honor [Disc 2]',84);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (81,'One By One',84);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (82,'The Colour And The Shape',84);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (83,'My Way: The Best Of Frank Sinatra [Disc 1]',85);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (84,'Roda De Funk',86);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (85,'As Canções de Eu Tu Eles',27);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (86,'Quanta Gente Veio Ver (Live)',27);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (87,'Quanta Gente Veio ver--Bônus De Carnaval',27);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (88,'Faceless',87);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (89,'American Idiot',54);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (90,'Appetite for Destruction',88);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (91,'Use Your Illusion I',88);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (92,'Use Your Illusion II',88);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (93,'Blue Moods',89);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (94,'A Matter of Life and Death',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (95,'A Real Dead One',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (96,'A Real Live One',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (97,'Brave New World',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (98,'Dance Of Death',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (99,'Fear Of The Dark',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (100,'Iron Maiden',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (101,'Killers',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (102,'Live After Death',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (103,'Live At Donington 1992 (Disc 1)',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (104,'Live At Donington 1992 (Disc 2)',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (105,'No Prayer For The Dying',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (106,'Piece Of Mind',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (107,'Powerslave',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (108,'Rock In Rio [CD1]',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (109,'Rock In Rio [CD2]',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (110,'Seventh Son of a Seventh Son',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (111,'Somewhere in Time',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (112,'The Number of The Beast',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (113,'The X Factor',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (114,'Virtual XI',90);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (115,'Sex Machine',91);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (116,'Emergency On Planet Earth',92);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (117,'Synkronized',92);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (118,'The Return Of The Space Cowboy',92);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (119,'Get Born',93);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (120,'Are You Experienced?',94);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (121,'Surfing with the Alien (Remastered)',95);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (122,'Jorge Ben Jor 25 Anos',46);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (123,'Jota Quest-1995',96);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (124,'Cafezinho',97);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (125,'Living After Midnight',98);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (126,'Unplugged [Live]',52);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (127,'BBC Sessions [Disc 2] [Live]',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (128,'Coda',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (129,'Houses Of The Holy',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (130,'In Through The Out Door',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (131,'IV',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (132,'Led Zeppelin I',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (133,'Led Zeppelin II',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (134,'Led Zeppelin III',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (135,'Physical Graffiti [Disc 2]',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (136,'Presence',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (137,'The Song Remains The Same (Disc 1)',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (138,'The Song Remains The Same (Disc 2)',22);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (139,'A TempestadeTempestade Ou O Livro Dos Dias',99);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (140,'Mais Do Mesmo',99);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (141,'Greatest Hits',100);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (142,'Lulu Santos - RCA 100 Anos De Música - �?lbum 01',101);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (143,'Lulu Santos - RCA 100 Anos De Música - �?lbum 02',101);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (144,'Misplaced Childhood',102);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (145,'Barulhinho Bom',103);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (146,'Seek And Shall Find: More Of The Best (1963-1981)',104);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (147,'The Best Of Men At Work',105);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (148,'Black Album',50);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (149,'Garage Inc. (Disc 2)',50);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (150,'Kill ''Em All',50);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (151,'Load',50);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (152,'Master Of Puppets',50);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (153,'ReLoad',50);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (154,'Ride The Lightning',50);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (155,'St. Anger',50);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (156,'...And Justice For All',50);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (157,'Miles Ahead',68);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (158,'Milton Nascimento Ao Vivo',42);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (159,'Minas',42);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (160,'Ace Of Spades',106);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (161,'Demorou...',108);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (162,'Motley Crue Greatest Hits',109);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (163,'From The Muddy Banks Of The Wishkah [Live]',110);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (164,'Nevermind',110);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (165,'Compositores',111);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (166,'Olodum',112);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (167,'Acústico MTV',113);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (168,'Arquivo II',113);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (169,'Arquivo Os Paralamas Do Sucesso',113);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (170,'Bark at the Moon (Remastered)',114);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (171,'Blizzard of Ozz',114);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (172,'Diary of a Madman (Remastered)',114);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (173,'No More Tears (Remastered)',114);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (174,'Tribute',114);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (175,'Walking Into Clarksdale',115);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (176,'Original Soundtracks 1',116);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (177,'The Beast Live',117);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (178,'Live On Two Legs [Live]',118);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (179,'Pearl Jam',118);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (180,'Riot Act',118);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (181,'Ten',118);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (182,'Vs.',118);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (183,'Dark Side Of The Moon',120);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (184,'Os Cães Ladram Mas A Caravana Não Pára',121);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (185,'Greatest Hits I',51);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (186,'News Of The World',51);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (187,'Out Of Time',122);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (188,'Green',124);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (189,'New Adventures In Hi-Fi',124);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (190,'The Best Of R.E.M.: The IRS Years',124);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (191,'Cesta Básica',125);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (192,'Raul Seixas',126);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (193,'Blood Sugar Sex Magik',127);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (194,'By The Way',127);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (195,'Californication',127);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (196,'Retrospective I (1974-1980)',128);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (197,'Santana - As Years Go By',59);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (198,'Santana Live',59);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (199,'Maquinarama',130);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (200,'O Samba Poconé',130);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (201,'Judas 0: B-Sides and Rarities',131);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (202,'Rotten Apples: Greatest Hits',131);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (203,'A-Sides',132);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (204,'Morning Dance',53);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (205,'In Step',133);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (206,'Core',134);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (207,'Mezmerize',135);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (208,'[1997] Black Light Syndrome',136);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (209,'Live [Disc 1]',137);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (210,'Live [Disc 2]',137);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (211,'The Singles',138);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (212,'Beyond Good And Evil',139);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (213,'Pure Cult: The Best Of The Cult (For Rockers, Ravers, Lovers & Sinners) [UK]',139);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (214,'The Doors',140);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (215,'The Police Greatest Hits',141);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (216,'Hot Rocks, 1964-1971 (Disc 1)',142);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (217,'No Security',142);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (218,'Voodoo Lounge',142);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (219,'Tangents',143);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (220,'Transmission',143);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (221,'My Generation - The Very Best Of The Who',144);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (222,'Serie Sem Limite (Disc 1)',145);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (223,'Serie Sem Limite (Disc 2)',145);
Insert into RHYSYAMASAKI.ALBUM (ALBUMID,TITLE,ARTISTID) values (224,'Acústico',146);
REM INSERTING into RHYSYAMASAKI.ARTIST
SET DEFINE OFF;
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (249,'Sir Georg Solti, Sumi Jo & Wiener Philharmoniker');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (250,'Christopher O''Riley');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (251,'Fretwork');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (252,'Amy Winehouse');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (253,'Calexico');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (254,'Otto Klemperer & Philharmonia Orchestra');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (255,'Yehudi Menuhin');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (256,'Philharmonia Orchestra & Sir Neville Marriner');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (257,'Academy of St. Martin in the Fields, Sir Neville Marriner & Thurston Dart');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (258,'Les Arts Florissants & William Christie');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (259,'The 12 Cellists of The Berlin Philharmonic');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (260,'Adrian Leaper & Doreen de Feis');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (261,'Roger Norrington, London Classical Players');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (262,'Charles Dutoit & L''Orchestre Symphonique de Montréal');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (263,'Equale Brass Ensemble, John Eliot Gardiner & Munich Monteverdi Orchestra and Choir');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (264,'Kent Nagano and Orchestre de l''Opéra de Lyon');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (265,'Julian Bream');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (266,'Martin Roscoe');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (267,'Göteborgs Symfoniker & Neeme Järvi');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (268,'Itzhak Perlman');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (269,'Michele Campanella');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (270,'Gerald Moore');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (271,'Mela Tenenbaum, Pro Musica Prague & Richard Kapp');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (272,'Emerson String Quartet');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (273,'C. Monteverdi, Nigel Rogers - Chiaroscuro; London Baroque; London Cornett & Sackbu');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (274,'Nash Ensemble');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (275,'Philip Glass Ensemble');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (1,'AC/DC');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (2,'Accept');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (3,'Aerosmith');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (4,'Alanis Morissette');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (5,'Alice In Chains');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (6,'Antônio Carlos Jobim');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (7,'Apocalyptica');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (8,'Audioslave');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (9,'BackBeat');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (10,'Billy Cobham');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (11,'Black Label Society');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (12,'Black Sabbath');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (13,'Body Count');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (14,'Bruce Dickinson');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (15,'Buddy Guy');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (16,'Caetano Veloso');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (17,'Chico Buarque');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (18,'Chico Science & Nação Zumbi');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (19,'Cidade Negra');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (20,'Cláudio Zoli');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (21,'Various Artists');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (22,'Led Zeppelin');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (23,'Frank Zappa & Captain Beefheart');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (24,'Marcos Valle');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (25,'Milton Nascimento & Bebeto');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (26,'Azymuth');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (27,'Gilberto Gil');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (28,'João Gilberto');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (29,'Bebel Gilberto');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (30,'Jorge Vercilo');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (31,'Baby Consuelo');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (32,'Ney Matogrosso');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (33,'Luiz Melodia');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (34,'Nando Reis');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (35,'Pedro Luís & A Parede');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (36,'O Rappa');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (37,'Ed Motta');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (38,'Banda Black Rio');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (39,'Fernanda Porto');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (40,'Os Cariocas');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (41,'Elis Regina');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (42,'Milton Nascimento');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (43,'A Cor Do Som');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (44,'Kid Abelha');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (45,'Sandra De Sá');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (46,'Jorge Ben');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (47,'Hermeto Pascoal');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (48,'Barão Vermelho');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (49,'Edson, DJ Marky & DJ Patife Featuring Fernanda Porto');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (50,'Metallica');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (51,'Queen');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (52,'Kiss');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (53,'Spyro Gyra');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (54,'Green Day');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (55,'David Coverdale');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (56,'Gonzaguinha');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (57,'Os Mutantes');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (58,'Deep Purple');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (59,'Santana');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (60,'Santana Feat. Dave Matthews');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (61,'Santana Feat. Everlast');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (62,'Santana Feat. Rob Thomas');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (63,'Santana Feat. Lauryn Hill & Cee-Lo');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (64,'Santana Feat. The Project G&B');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (65,'Santana Feat. Maná');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (66,'Santana Feat. Eagle-Eye Cherry');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (67,'Santana Feat. Eric Clapton');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (68,'Miles Davis');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (69,'Gene Krupa');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (70,'Toquinho & Vinícius');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (71,'Vinícius De Moraes & Baden Powell');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (72,'Vinícius De Moraes');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (73,'Vinícius E Qurteto Em Cy');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (74,'Vinícius E Odette Lara');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (75,'Vinicius, Toquinho & Quarteto Em Cy');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (76,'Creedence Clearwater Revival');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (77,'Cássia Eller');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (78,'Def Leppard');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (79,'Dennis Chambers');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (80,'Djavan');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (81,'Eric Clapton');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (82,'Faith No More');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (83,'Falamansa');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (84,'Foo Fighters');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (85,'Frank Sinatra');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (86,'Funk Como Le Gusta');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (87,'Godsmack');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (88,'Guns N'' Roses');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (89,'Incognito');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (90,'Iron Maiden');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (91,'James Brown');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (92,'Jamiroquai');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (93,'JET');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (94,'Jimi Hendrix');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (95,'Joe Satriani');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (96,'Jota Quest');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (97,'João Suplicy');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (98,'Judas Priest');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (99,'Legião Urbana');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (100,'Lenny Kravitz');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (101,'Lulu Santos');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (102,'Marillion');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (103,'Marisa Monte');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (104,'Marvin Gaye');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (105,'Men At Work');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (106,'Motörhead');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (107,'Motörhead & Girlschool');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (108,'Mônica Marianno');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (109,'Mötley Crüe');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (110,'Nirvana');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (111,'O Terço');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (112,'Olodum');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (113,'Os Paralamas Do Sucesso');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (114,'Ozzy Osbourne');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (115,'Page & Plant');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (116,'Passengers');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (117,'Paul D''Ianno');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (118,'Pearl Jam');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (119,'Peter Tosh');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (120,'Pink Floyd');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (121,'Planet Hemp');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (122,'R.E.M. Feat. Kate Pearson');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (123,'R.E.M. Feat. KRS-One');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (124,'R.E.M.');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (125,'Raimundos');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (126,'Raul Seixas');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (127,'Red Hot Chili Peppers');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (128,'Rush');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (129,'Simply Red');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (130,'Skank');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (131,'Smashing Pumpkins');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (132,'Soundgarden');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (133,'Stevie Ray Vaughan & Double Trouble');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (134,'Stone Temple Pilots');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (135,'System Of A Down');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (136,'Terry Bozzio, Tony Levin & Steve Stevens');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (137,'The Black Crowes');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (138,'The Clash');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (139,'The Cult');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (140,'The Doors');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (141,'The Police');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (142,'The Rolling Stones');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (143,'The Tea Party');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (144,'The Who');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (145,'Tim Maia');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (146,'Titãs');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (147,'Battlestar Galactica');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (148,'Heroes');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (149,'Lost');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (150,'U2');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (151,'UB40');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (152,'Van Halen');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (153,'Velvet Revolver');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (154,'Whitesnake');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (155,'Zeca Pagodinho');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (156,'The Office');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (157,'Dread Zeppelin');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (158,'Battlestar Galactica (Classic)');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (159,'Aquaman');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (160,'Christina Aguilera featuring BigElf');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (161,'Aerosmith & Sierra Leone''s Refugee Allstars');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (162,'Los Lonely Boys');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (163,'Corinne Bailey Rae');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (164,'Dhani Harrison & Jakob Dylan');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (165,'Jackson Browne');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (166,'Avril Lavigne');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (167,'Big & Rich');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (168,'Youssou N''Dour');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (169,'Black Eyed Peas');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (170,'Jack Johnson');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (171,'Ben Harper');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (172,'Snow Patrol');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (173,'Matisyahu');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (174,'The Postal Service');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (175,'Jaguares');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (176,'The Flaming Lips');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (177,'Jack''s Mannequin & Mick Fleetwood');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (178,'Regina Spektor');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (179,'Scorpions');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (180,'House Of Pain');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (181,'Xis');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (182,'Nega Gizza');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (183,'Gustavo & Andres Veiga & Salazar');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (184,'Rodox');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (185,'Charlie Brown Jr.');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (186,'Pedro Luís E A Parede');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (187,'Los Hermanos');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (188,'Mundo Livre S/A');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (189,'Otto');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (190,'Instituto');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (191,'Nação Zumbi');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (192,'DJ Dolores & Orchestra Santa Massa');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (193,'Seu Jorge');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (194,'Sabotage E Instituto');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (195,'Stereo Maracana');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (196,'Cake');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (197,'Aisha Duo');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (198,'Habib Koité and Bamada');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (199,'Karsh Kale');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (200,'The Posies');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (201,'Luciana Souza/Romero Lubambo');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (202,'Aaron Goldberg');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (203,'Nicolaus Esterhazy Sinfonia');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (204,'Temple of the Dog');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (205,'Chris Cornell');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (206,'Alberto Turco & Nova Schola Gregoriana');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (207,'Richard Marlow & The Choir of Trinity College, Cambridge');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (208,'English Concert & Trevor Pinnock');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (209,'Anne-Sophie Mutter, Herbert Von Karajan & Wiener Philharmoniker');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (210,'Hilary Hahn, Jeffrey Kahane, Los Angeles Chamber Orchestra & Margaret Batjer');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (211,'Wilhelm Kempff');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (212,'Yo-Yo Ma');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (213,'Scholars Baroque Ensemble');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (214,'Academy of St. Martin in the Fields & Sir Neville Marriner');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (215,'Academy of St. Martin in the Fields Chamber Ensemble & Sir Neville Marriner');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (216,'Berliner Philharmoniker, Claudio Abbado & Sabine Meyer');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (217,'Royal Philharmonic Orchestra & Sir Thomas Beecham');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (218,'Orchestre Révolutionnaire et Romantique & John Eliot Gardiner');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (219,'Britten Sinfonia, Ivor Bolton & Lesley Garrett');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (220,'Chicago Symphony Chorus, Chicago Symphony Orchestra & Sir Georg Solti');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (221,'Sir Georg Solti & Wiener Philharmoniker');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (222,'Academy of St. Martin in the Fields, John Birch, Sir Neville Marriner & Sylvia McNair');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (223,'London Symphony Orchestra & Sir Charles Mackerras');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (224,'Barry Wordsworth & BBC Concert Orchestra');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (225,'Herbert Von Karajan, Mirella Freni & Wiener Philharmoniker');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (226,'Eugene Ormandy');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (227,'Luciano Pavarotti');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (228,'Leonard Bernstein & New York Philharmonic');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (229,'Boston Symphony Orchestra & Seiji Ozawa');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (230,'Aaron Copland & London Symphony Orchestra');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (231,'Ton Koopman');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (232,'Sergei Prokofiev & Yuri Temirkanov');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (233,'Chicago Symphony Orchestra & Fritz Reiner');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (234,'Orchestra of The Age of Enlightenment');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (235,'Emanuel Ax, Eugene Ormandy & Philadelphia Orchestra');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (236,'James Levine');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (237,'Berliner Philharmoniker & Hans Rosbaud');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (238,'Maurizio Pollini');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (239,'Academy of St. Martin in the Fields, Sir Neville Marriner & William Bennett');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (240,'Gustav Mahler');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (241,'Felix Schmidt, London Symphony Orchestra & Rafael Frühbeck de Burgos');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (242,'Edo de Waart & San Francisco Symphony');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (243,'Antal Doráti & London Symphony Orchestra');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (244,'Choir Of Westminster Abbey & Simon Preston');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (245,'Michael Tilson Thomas & San Francisco Symphony');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (246,'Chor der Wiener Staatsoper, Herbert Von Karajan & Wiener Philharmoniker');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (247,'The King''s Singers');
Insert into RHYSYAMASAKI.ARTIST (ARTISTID,NAME) values (248,'Berliner Philharmoniker & Herbert Von Karajan');
REM INSERTING into RHYSYAMASAKI.CUSTOMER
SET DEFINE OFF;
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (60,'jorge','jorge',null,null,null,null,null,null,null,null,'j@gmail.com',null);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (1,'Luís','Gonçalves','Embraer - Empresa Brasileira de Aeronáutica S.A.','Av. Brigadeiro Faria Lima, 2170','São José dos Campos','SP','Brazil','12227-000','+55 (12) 3923-5555','+55 (12) 3923-5566','luisg@embraer.com.br',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (2,'Leonie','Köhler',null,'Theodor-Heuss-Straße 34','Stuttgart',null,'Germany','70174','+49 0711 2842222',null,'leonekohler@surfeu.de',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (3,'François','Tremblay',null,'1498 rue Bélanger','Montréal','QC','Canada','H2G 1A7','+1 (514) 721-4711',null,'ftremblay@gmail.com',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (4,'Bjørn','Hansen',null,'Ullevålsveien 14','Oslo',null,'Norway','0171','+47 22 44 22 22',null,'bjorn.hansen@yahoo.no',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (5,'František','Wichterlová','JetBrains s.r.o.','Klanova 9/506','Prague',null,'Czech Republic','14700','+420 2 4172 5555','+420 2 4172 5555','frantisekw@jetbrains.com',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (6,'Helena','Holý',null,'Rilská 3174/6','Prague',null,'Czech Republic','14300','+420 2 4177 0449',null,'hholy@gmail.com',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (7,'Astrid','Gruber',null,'Rotenturmstraße 4, 1010 Innere Stadt','Vienne',null,'Austria','1010','+43 01 5134505',null,'astrid.gruber@apple.at',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (8,'Daan','Peeters',null,'Grétrystraat 63','Brussels',null,'Belgium','1000','+32 02 219 03 03',null,'daan_peeters@apple.be',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (9,'Kara','Nielsen',null,'Sønder Boulevard 51','Copenhagen',null,'Denmark','1720','+453 3331 9991',null,'kara.nielsen@jubii.dk',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (10,'Eduardo','Martins','Woodstock Discos','Rua Dr. Falcão Filho, 155','São Paulo','SP','Brazil','01007-010','+55 (11) 3033-5446','+55 (11) 3033-4564','eduardo@woodstock.com.br',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (11,'Alexandre','Rocha','Banco do Brasil S.A.','Av. Paulista, 2022','São Paulo','SP','Brazil','01310-200','+55 (11) 3055-3278','+55 (11) 3055-8131','alero@uol.com.br',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (12,'Roberto','Almeida','Riotur','Praça Pio X, 119','Rio de Janeiro','RJ','Brazil','20040-020','+55 (21) 2271-7000','+55 (21) 2271-7070','roberto.almeida@riotur.gov.br',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (13,'Fernanda','Ramos',null,'Qe 7 Bloco G','Brasília','DF','Brazil','71020-677','+55 (61) 3363-5547','+55 (61) 3363-7855','fernadaramos4@uol.com.br',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (14,'Mark','Philips','Telus','8210 111 ST NW','Edmonton','AB','Canada','T6G 2C7','+1 (780) 434-4554','+1 (780) 434-5565','mphilips12@shaw.ca',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (15,'Jennifer','Peterson','Rogers Canada','700 W Pender Street','Vancouver','BC','Canada','V6C 1G8','+1 (604) 688-2255','+1 (604) 688-8756','jenniferp@rogers.ca',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (16,'Frank','Harris','Google Inc.','1600 Amphitheatre Parkway','Mountain View','CA','USA','94043-1351','+1 (650) 253-0000','+1 (650) 253-0000','fharris@google.com',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (17,'Jack','Smith','Microsoft Corporation','1 Microsoft Way','Redmond','WA','USA','98052-8300','+1 (425) 882-8080','+1 (425) 882-8081','jacksmith@microsoft.com',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (18,'Michelle','Brooks',null,'627 Broadway','New York','NY','USA','10012-2612','+1 (212) 221-3546','+1 (212) 221-4679','michelleb@aol.com',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (19,'Tim','Goyer','Apple Inc.','1 Infinite Loop','Cupertino','CA','USA','95014','+1 (408) 996-1010','+1 (408) 996-1011','tgoyer@apple.com',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (20,'Dan','Miller',null,'541 Del Medio Avenue','Mountain View','CA','USA','94040-111','+1 (650) 644-3358',null,'dmiller@comcast.com',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (21,'Kathy','Chase',null,'801 W 4th Street','Reno','NV','USA','89503','+1 (775) 223-7665',null,'kachase@hotmail.com',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (22,'Heather','Leacock',null,'120 S Orange Ave','Orlando','FL','USA','32801','+1 (407) 999-7788',null,'hleacock@gmail.com',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (23,'John','Gordon',null,'69 Salem Street','Boston','MA','USA','2113','+1 (617) 522-1333',null,'johngordon22@yahoo.com',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (24,'Frank','Ralston',null,'162 E Superior Street','Chicago','IL','USA','60611','+1 (312) 332-3232',null,'fralston@gmail.com',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (25,'Victor','Stevens',null,'319 N. Frances Street','Madison','WI','USA','53703','+1 (608) 257-0597',null,'vstevens@yahoo.com',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (26,'Richard','Cunningham',null,'2211 W Berry Street','Fort Worth','TX','USA','76110','+1 (817) 924-7272',null,'ricunningham@hotmail.com',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (27,'Patrick','Gray',null,'1033 N Park Ave','Tucson','AZ','USA','85719','+1 (520) 622-4200',null,'patrick.gray@aol.com',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (28,'Julia','Barnett',null,'302 S 700 E','Salt Lake City','UT','USA','84102','+1 (801) 531-7272',null,'jubarnett@gmail.com',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (29,'Robert','Brown',null,'796 Dundas Street West','Toronto','ON','Canada','M6J 1V1','+1 (416) 363-8888',null,'robbrown@shaw.ca',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (30,'Edward','Francis',null,'230 Elgin Street','Ottawa','ON','Canada','K2P 1L7','+1 (613) 234-3322',null,'edfrancis@yachoo.ca',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (31,'Martha','Silk',null,'194A Chain Lake Drive','Halifax','NS','Canada','B3S 1C5','+1 (902) 450-0450',null,'marthasilk@gmail.com',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (32,'Aaron','Mitchell',null,'696 Osborne Street','Winnipeg','MB','Canada','R3L 2B9','+1 (204) 452-6452',null,'aaronmitchell@yahoo.ca',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (33,'Ellie','Sullivan',null,'5112 48 Street','Yellowknife','NT','Canada','X1A 1N6','+1 (867) 920-2233',null,'ellie.sullivan@shaw.ca',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (34,'João','Fernandes',null,'Rua da Assunção 53','Lisbon',null,'Portugal',null,'+351 (213) 466-111',null,'jfernandes@yahoo.pt',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (35,'Madalena','Sampaio',null,'Rua dos Campeões Europeus de Viena, 4350','Porto',null,'Portugal',null,'+351 (225) 022-448',null,'masampaio@sapo.pt',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (36,'Hannah','Schneider',null,'Tauentzienstraße 8','Berlin',null,'Germany','10789','+49 030 26550280',null,'hannah.schneider@yahoo.de',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (37,'Fynn','Zimmermann',null,'Berger Straße 10','Frankfurt',null,'Germany','60316','+49 069 40598889',null,'fzimmermann@yahoo.de',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (38,'Niklas','Schröder',null,'Barbarossastraße 19','Berlin',null,'Germany','10779','+49 030 2141444',null,'nschroder@surfeu.de',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (39,'Camille','Bernard',null,'4, Rue Milton','Paris',null,'France','75009','+33 01 49 70 65 65',null,'camille.bernard@yahoo.fr',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (40,'Dominique','Lefebvre',null,'8, Rue Hanovre','Paris',null,'France','75002','+33 01 47 42 71 71',null,'dominiquelefebvre@gmail.com',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (41,'Marc','Dubois',null,'11, Place Bellecour','Lyon',null,'France','69002','+33 04 78 30 30 30',null,'marc.dubois@hotmail.com',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (42,'Wyatt','Girard',null,'9, Place Louis Barthou','Bordeaux',null,'France','33000','+33 05 56 96 96 96',null,'wyatt.girard@yahoo.fr',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (43,'Isabelle','Mercier',null,'68, Rue Jouvence','Dijon',null,'France','21000','+33 03 80 73 66 99',null,'isabelle_mercier@apple.fr',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (44,'Terhi','Hämäläinen',null,'Porthaninkatu 9','Helsinki',null,'Finland','00530','+358 09 870 2000',null,'terhi.hamalainen@apple.fi',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (45,'Ladislav','Kovács',null,'Erzsébet krt. 58.','Budapest',null,'Hungary','H-1073',null,null,'ladislav_kovacs@apple.hu',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (46,'Hugh','O''Reilly',null,'3 Chatham Street','Dublin','Dublin','Ireland',null,'+353 01 6792424',null,'hughoreilly@apple.ie',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (47,'Lucas','Mancini',null,'Via Degli Scipioni, 43','Rome','RM','Italy','00192','+39 06 39733434',null,'lucas.mancini@yahoo.it',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (48,'Johannes','Van der Berg',null,'Lijnbaansgracht 120bg','Amsterdam','VV','Netherlands','1016','+31 020 6223130',null,'johavanderberg@yahoo.nl',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (49,'Stanisław','Wójcik',null,'Ordynacka 10','Warsaw',null,'Poland','00-358','+48 22 828 37 39',null,'stanisław.wójcik@wp.pl',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (50,'Enrique','Muñoz',null,'C/ San Bernardo 85','Madrid',null,'Spain','28015','+34 914 454 454',null,'enrique_munoz@yahoo.es',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (51,'Joakim','Johansson',null,'Celsiusg. 9','Stockholm',null,'Sweden','11230','+46 08-651 52 52',null,'joakim.johansson@yahoo.se',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (52,'Emma','Jones',null,'202 Hoxton Street','London',null,'United Kingdom','N1 5LH','+44 020 7707 0707',null,'emma_jones@hotmail.com',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (53,'Phil','Hughes',null,'113 Lupus St','London',null,'United Kingdom','SW1V 3EN','+44 020 7976 5722',null,'phil.hughes@gmail.com',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (54,'Steve','Murray',null,'110 Raeburn Pl','Edinburgh ',null,'United Kingdom','EH4 1HH','+44 0131 315 3300',null,'steve.murray@yahoo.uk',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (55,'Mark','Taylor',null,'421 Bourke Street','Sidney','NSW','Australia','2010','+61 (02) 9332 3633',null,'mark.taylor@yahoo.au',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (56,'Diego','Gutiérrez',null,'307 Macacha Güemes','Buenos Aires',null,'Argentina','1106','+54 (0)11 4311 4333',null,'diego.gutierrez@yahoo.ar',4);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (57,'Luis','Rojas',null,'Calle Lira, 198','Santiago',null,'Chile',null,'+56 (0)2 635 4444',null,'luisrojas@yahoo.cl',5);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (58,'Manoj','Pareek',null,'12,Community Centre','Delhi',null,'India','110017','+91 0124 39883988',null,'manoj.pareek@rediff.com',3);
Insert into RHYSYAMASAKI.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) values (59,'Puja','Srivastava',null,'3,Raj Bhavan Road','Bangalore',null,'India','560001','+91 080 22289999',null,'puja_srivastava@yahoo.in',3);
REM INSERTING into RHYSYAMASAKI.EMPLOYEE
SET DEFINE OFF;
REM INSERTING into RHYSYAMASAKI.GENRE
SET DEFINE OFF;
REM INSERTING into RHYSYAMASAKI.INVOICE
SET DEFINE OFF;
REM INSERTING into RHYSYAMASAKI.INVOICELINE
SET DEFINE OFF;
REM INSERTING into RHYSYAMASAKI.MEDIATYPE
SET DEFINE OFF;
Insert into RHYSYAMASAKI.MEDIATYPE (MEDIATYPEID,NAME) values (1,'MPEG audio file');
Insert into RHYSYAMASAKI.MEDIATYPE (MEDIATYPEID,NAME) values (2,'Protected AAC audio file');
Insert into RHYSYAMASAKI.MEDIATYPE (MEDIATYPEID,NAME) values (3,'Protected MPEG-4 video file');
Insert into RHYSYAMASAKI.MEDIATYPE (MEDIATYPEID,NAME) values (4,'Purchased AAC audio file');
Insert into RHYSYAMASAKI.MEDIATYPE (MEDIATYPEID,NAME) values (5,'AAC audio file');
REM INSERTING into RHYSYAMASAKI.PLAYLIST
SET DEFINE OFF;
REM INSERTING into RHYSYAMASAKI.PLAYLISTTRACK
SET DEFINE OFF;
REM INSERTING into RHYSYAMASAKI.TRACK
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PK_INVOICE
--------------------------------------------------------

  CREATE UNIQUE INDEX "RHYSYAMASAKI"."PK_INVOICE" ON "RHYSYAMASAKI"."INVOICE" ("INVOICEID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_GENRE
--------------------------------------------------------

  CREATE UNIQUE INDEX "RHYSYAMASAKI"."PK_GENRE" ON "RHYSYAMASAKI"."GENRE" ("GENREID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_TRACK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RHYSYAMASAKI"."PK_TRACK" ON "RHYSYAMASAKI"."TRACK" ("TRACKID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PLAYLISTTRACK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RHYSYAMASAKI"."PK_PLAYLISTTRACK" ON "RHYSYAMASAKI"."PLAYLISTTRACK" ("PLAYLISTID", "TRACKID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_INVOICELINE
--------------------------------------------------------

  CREATE UNIQUE INDEX "RHYSYAMASAKI"."PK_INVOICELINE" ON "RHYSYAMASAKI"."INVOICELINE" ("INVOICELINEID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PLAYLIST
--------------------------------------------------------

  CREATE UNIQUE INDEX "RHYSYAMASAKI"."PK_PLAYLIST" ON "RHYSYAMASAKI"."PLAYLIST" ("PLAYLISTID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_MEDIATYPE
--------------------------------------------------------

  CREATE UNIQUE INDEX "RHYSYAMASAKI"."PK_MEDIATYPE" ON "RHYSYAMASAKI"."MEDIATYPE" ("MEDIATYPEID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ARTIST
--------------------------------------------------------

  CREATE UNIQUE INDEX "RHYSYAMASAKI"."PK_ARTIST" ON "RHYSYAMASAKI"."ARTIST" ("ARTISTID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_CUSTOMER
--------------------------------------------------------

  CREATE UNIQUE INDEX "RHYSYAMASAKI"."PK_CUSTOMER" ON "RHYSYAMASAKI"."CUSTOMER" ("CUSTOMERID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ALBUM
--------------------------------------------------------

  CREATE UNIQUE INDEX "RHYSYAMASAKI"."PK_ALBUM" ON "RHYSYAMASAKI"."ALBUM" ("ALBUMID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger AFTERINSERT
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "RHYSYAMASAKI"."AFTERINSERT" 
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Good job for inserting!');
END;

--Task B � Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER afterUpdate
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Good job for updating!');
END;

--Task C � Create an after delete trigger on the customer table that fires after a row is deleted from the
--table.

CREATE OR REPLACE TRIGGER afterDelete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Good job for deleting!');
END;



--7.1 INNER
--Task � Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.

SELECT c.firstname, c.lastname, i.invoiceid
FROM customer c
INNER JOIN invoice i ON c.customerid = i.customerid;

--7.2 OUTER
--Task � Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.

SELECT c.firstname, c.lastname, i.invoiceid, i.total
FROM customer c
FULL OUTER JOIN invoice i ON c.customerid = i.invoiceid;

--7.3 RIGHT
--Task � Create a right join that joins album and artist specifying artist name and title.

SELECT a.name, am.title
FROM album am
RIGHT OUTER JOIN artist a ON am.artistid = a.artistid;

--7.4 CROSS
--Task � Create a cross join that joins album and artist and sorts by artist name in ascending order.

SELECT a.name
FROM album am
CROSS JOIN artist a
ORDER BY a.name ASC;

--7.5 SELF
--Task � Perform a self-join on the employee table, joining on the reportsto column.

SELECT a.*, b.firstname AS reporting_to_name
FROM employee a, employee b
WHERE a.reportsto = b.employeeid;


-- Join all tables in chinook

SELECT * 
FROM customer c
INNER JOIN invoice i ON c.customerid = i.customerid
INNER JOIN invoiceline l ON l.invoiceid = i.invoiceid
INNER JOIN employee e ON e.employeeid = c.supportrepid
INNER JOIN track t ON t.trackid = l.trackid
INNER JOIN album a ON a.albumid = t.albumid
INNER JOIN mediatype m ON m.mediatypeid = t.mediatypeid
INNER JOIN artist at ON at.artistid = a.artistid
INNER JOIN genre g ON g.genreid = t.genreid
INNER JOIN playlisttrack pt ON pt.trackid = t.trackid
INNER JOIN playlist p ON pt.playlistid = p.playlistid;



SELECT *
FROM playlisttrack pt


/
ALTER TRIGGER "RHYSYAMASAKI"."AFTERINSERT" ENABLE;
--------------------------------------------------------
--  DDL for Procedure GET_ALL_NAMES
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "RHYSYAMASAKI"."GET_ALL_NAMES" (cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cursorParam FOR
  SELECT firstname, lastname FROM employee;
END;

/
--------------------------------------------------------
--  DDL for Procedure GET_MANAGER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "RHYSYAMASAKI"."GET_MANAGER" (eid INT, emp OUT VARCHAR2)
AS 
BEGIN
    SELECT firstname
    INTO emp
    FROM employee
    WHERE reportsto = eid;
END;

/
--------------------------------------------------------
--  DDL for Procedure GET_NAME_COMPANY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "RHYSYAMASAKI"."GET_NAME_COMPANY" (cid IN NUMBER, emp OUT VARCHAR2)
AS
BEGIN
SELECT firstname INTO emp FROM customer WHERE customerid = cid;
SELECT company INTO emp FROM customer WHERE customerid = cid;
END;

/
--------------------------------------------------------
--  DDL for Procedure INSERT_CUSTOMER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "RHYSYAMASAKI"."INSERT_CUSTOMER" (numId IN INT, fname IN VARCHAR2, lname IN VARCHAR2, mail IN VARCHAR2)
IS
BEGIN
    INSERT INTO customer(customerid, firstname, lastname, email) VALUES (numId, fname, lname, mail);
END;

/
--------------------------------------------------------
--  DDL for Procedure UPDATEINFO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "RHYSYAMASAKI"."UPDATEINFO" (lname VARCHAR2, fname VARCHAR2, address VARCHAR2, city VARCHAR2, s VARCHAR2, 
                                        country VARCHAR2, zip VARCHAR2, phoneNum VARCHAR2, faxNum VARCHAR2, mail VARCHAR2, eid INT)
AS
BEGIN 
    UPDATE employee e SET e.lastname = lname, e.firstname = fname, e.address = address, e.city = city, e.state = s,
    e.country = country, e.postalcode = zip, e.phone = phoneNum, e.fax = faxNum, e.email = mail
    WHERE e.employeeId = eid;
END;

/
--------------------------------------------------------
--  DDL for Function BORN_AFTER_1968
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "RHYSYAMASAKI"."BORN_AFTER_1968" 
RETURN SYS_REFCURSOR
    IS emp_born_after SYS_REFCURSOR;
BEGIN
    OPEN emp_born_after FOR
    SELECT *
    FROM employee
    WHERE birthdate > '01-jan-69';
    RETURN emp_born_after;
END;

/
--------------------------------------------------------
--  DDL for Function GETAVERAGE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "RHYSYAMASAKI"."GETAVERAGE" 
RETURN INT
    IS average INT;
BEGIN
    SELECT AVG(total)
    INTO average
    FROM invoice;
    RETURN average;
END;

SELECT getAverage FROM dual;

--Task B � Create a function that returns the most expensive track*

CREATE OR REPLACE FUNCTION findExpensive
RETURN SYS_REFCURSOR
    IS expense SYS_REFCURSOR;
BEGIN
OPEN expense FOR
SELECT unitprice 
FROM track
WHERE unitprice = ( 
    SELECT MAX(unitprice)
    FROM track
    );
RETURN expense;
END;

SELECT findExpensive FROM dual;

--3.3 User Defined Scalar Functions
--Task A � Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION averagePrice
RETURN NUMBER
    IS price NUMBER;
BEGIN
    SELECT AVG(unitprice)
    INTO price
    FROM invoiceline;
    RETURN price;
END;

/
--------------------------------------------------------
--  DDL for Function GETDATE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "RHYSYAMASAKI"."GETDATE" 
RETURN VARCHAR2 
    IS currDate VARCHAR2(4000);
BEGIN
    SELECT TO_CHAR(sysdate,'MM-DD-YY HH12:MI:SS')
    INTO currDate
    FROM dual;
    RETURN (currDate);
END;

SELECT getDate FROM dual;

--Task B � create a function that returns the length of a mediatype from the mediatype table
CREATE FUNCTION getLength(mediaid INT)
RETURN INT
    IS l INT;
BEGIN
    SELECT LENGTH(name)
    INTO l
    FROM mediatype
    WHERE mediatypeid = mediaid;
    RETURN (l);
END;

/
--------------------------------------------------------
--  Constraints for Table ARTIST
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."ARTIST" MODIFY ("ARTISTID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."ARTIST" ADD CONSTRAINT "PK_ARTIST" PRIMARY KEY ("ARTISTID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table INVOICELINE
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."INVOICELINE" MODIFY ("INVOICELINEID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."INVOICELINE" MODIFY ("INVOICEID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."INVOICELINE" MODIFY ("TRACKID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."INVOICELINE" MODIFY ("UNITPRICE" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."INVOICELINE" MODIFY ("QUANTITY" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."INVOICELINE" ADD CONSTRAINT "PK_INVOICELINE" PRIMARY KEY ("INVOICELINEID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table GENRE
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."GENRE" MODIFY ("GENREID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."GENRE" ADD CONSTRAINT "PK_GENRE" PRIMARY KEY ("GENREID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PLAYLISTTRACK
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."PLAYLISTTRACK" MODIFY ("PLAYLISTID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."PLAYLISTTRACK" MODIFY ("TRACKID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."PLAYLISTTRACK" ADD CONSTRAINT "PK_PLAYLISTTRACK" PRIMARY KEY ("PLAYLISTID", "TRACKID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CUSTOMER
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."CUSTOMER" MODIFY ("CUSTOMERID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."CUSTOMER" MODIFY ("FIRSTNAME" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."CUSTOMER" MODIFY ("LASTNAME" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."CUSTOMER" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."CUSTOMER" ADD CONSTRAINT "PK_CUSTOMER" PRIMARY KEY ("CUSTOMERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table INVOICE
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."INVOICE" MODIFY ("INVOICEID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."INVOICE" MODIFY ("CUSTOMERID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."INVOICE" MODIFY ("INVOICEDATE" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."INVOICE" MODIFY ("TOTAL" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."INVOICE" ADD CONSTRAINT "PK_INVOICE" PRIMARY KEY ("INVOICEID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ALBUM
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."ALBUM" MODIFY ("ALBUMID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."ALBUM" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."ALBUM" MODIFY ("ARTISTID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."ALBUM" ADD CONSTRAINT "PK_ALBUM" PRIMARY KEY ("ALBUMID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PLAYLIST
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."PLAYLIST" MODIFY ("PLAYLISTID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."PLAYLIST" ADD CONSTRAINT "PK_PLAYLIST" PRIMARY KEY ("PLAYLISTID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TRACK
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."TRACK" MODIFY ("TRACKID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."TRACK" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."TRACK" MODIFY ("MEDIATYPEID" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."TRACK" MODIFY ("MILLISECONDS" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."TRACK" MODIFY ("UNITPRICE" NOT NULL ENABLE);
  ALTER TABLE "RHYSYAMASAKI"."TRACK" ADD CONSTRAINT "PK_TRACK" PRIMARY KEY ("TRACKID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ALBUM
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."ALBUM" ADD CONSTRAINT "FK_ALBUMARTISTID" FOREIGN KEY ("ARTISTID")
	  REFERENCES "RHYSYAMASAKI"."ARTIST" ("ARTISTID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table INVOICE
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."INVOICE" ADD CONSTRAINT "FK_INVOICECUSTOMERID" FOREIGN KEY ("CUSTOMERID")
	  REFERENCES "RHYSYAMASAKI"."CUSTOMER" ("CUSTOMERID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table INVOICELINE
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."INVOICELINE" ADD CONSTRAINT "FK_INVOICELINEINVOICEID" FOREIGN KEY ("INVOICEID")
	  REFERENCES "RHYSYAMASAKI"."INVOICE" ("INVOICEID") ENABLE;
  ALTER TABLE "RHYSYAMASAKI"."INVOICELINE" ADD CONSTRAINT "FK_INVOICELINETRACKID" FOREIGN KEY ("TRACKID")
	  REFERENCES "RHYSYAMASAKI"."TRACK" ("TRACKID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PLAYLISTTRACK
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."PLAYLISTTRACK" ADD CONSTRAINT "FK_PLAYLISTTRACKPLAYLISTID" FOREIGN KEY ("PLAYLISTID")
	  REFERENCES "RHYSYAMASAKI"."PLAYLIST" ("PLAYLISTID") ENABLE;
  ALTER TABLE "RHYSYAMASAKI"."PLAYLISTTRACK" ADD CONSTRAINT "FK_PLAYLISTTRACKTRACKID" FOREIGN KEY ("TRACKID")
	  REFERENCES "RHYSYAMASAKI"."TRACK" ("TRACKID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TRACK
--------------------------------------------------------

  ALTER TABLE "RHYSYAMASAKI"."TRACK" ADD CONSTRAINT "FK_TRACKALBUMID" FOREIGN KEY ("ALBUMID")
	  REFERENCES "RHYSYAMASAKI"."ALBUM" ("ALBUMID") ENABLE;
  ALTER TABLE "RHYSYAMASAKI"."TRACK" ADD CONSTRAINT "FK_TRACKGENREID" FOREIGN KEY ("GENREID")
	  REFERENCES "RHYSYAMASAKI"."GENRE" ("GENREID") ENABLE;
