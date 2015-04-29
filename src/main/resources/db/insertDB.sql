INSERT IGNORE INTO employees VALUES (1, 'James', 'Carter','jamesch','1234');
INSERT IGNORE INTO employees VALUES (2, 'Helen', 'Leary','helenl','1256');
INSERT IGNORE INTO employees VALUES (3, 'Linda', 'Douglas','lindado','5462');
INSERT IGNORE INTO employees VALUES (4, 'Rafael', 'Ortega','ortegar','3212');
INSERT IGNORE INTO employees VALUES (5, 'Henry', 'Stevens','henryst','1994');
INSERT IGNORE INTO employees VALUES (6, 'Sharon', 'Jenkins','sharons','6566');

INSERT IGNORE INTO countries VALUES (1, 'spain','spain');
INSERT IGNORE INTO countries VALUES (2, 'uzbekistan','uzbekistan');
INSERT IGNORE INTO countries VALUES (3, 'australia','australia');

INSERT IGNORE INTO tours_countries VALUES (6, 1);
INSERT IGNORE INTO tours_countries VALUES (7, 2);
INSERT IGNORE INTO tours_countries VALUES (9, 3);
INSERT IGNORE INTO tours_countries VALUES (10, 2);
INSERT IGNORE INTO tours_countries VALUES (6, 1);

INSERT IGNORE INTO accounts VALUES (1, '100000');
INSERT IGNORE INTO accounts VALUES (2, '100000');
INSERT IGNORE INTO accounts VALUES (3, '100000');
INSERT IGNORE INTO accounts VALUES (4, '100000');
INSERT IGNORE INTO accounts VALUES (5, '100000');
INSERT IGNORE INTO accounts VALUES (6, '100000');

INSERT IGNORE INTO clients VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', '213624589', '7775551023','1985-09-07','georgef','213256',1);
INSERT IGNORE INTO clients VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', '236245896', '7015551749','1981-09-05','bettyb','12365896',2);
INSERT IGNORE INTO clients VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', '659477756', '7755558763','1990-09-06','rodriquezf','125463',3);
INSERT IGNORE INTO clients VALUES (4, 'Harold', 'Davis', '563 Friendly St.', '322256987', '7025553198','1996-09-07','haroldd','21321',4);
INSERT IGNORE INTO clients VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', '231457856', '7075552765','2000-09-07','petert','21325',5);
INSERT IGNORE INTO clients VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', '526432598', '7005552654','1991-09-07','jeanco','21356',6);
INSERT IGNORE INTO clients VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', '265487565', '7212555387','1994-10-05','jeffb','256431',7);
INSERT IGNORE INTO clients VALUES (8, 'Maria', 'Escobito', '345 Maple St.', '886955461', '7075557683','1988-08-07','mariae','58964',8);
INSERT IGNORE INTO clients VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', '446159753', '7005559435','2000-09-07','davids','564952',9);
INSERT IGNORE INTO clients VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', '654456523', '7025555487','2000-01-03','carlose','12512',10);

INSERT IGNORE INTO tours VALUES (5, 'south europe','vacation to the south europe','false', '2000','10', 3, 5);
INSERT IGNORE INTO tours VALUES (6, 'south europe', 'vacation to the south europe','false','2000','10', 4, 1);
INSERT IGNORE INTO tours VALUES (7, 'europe', 'happy vacation','false','1995','10', 1, 4);
INSERT IGNORE INTO tours VALUES (8, 'europe','happy vacation','false', '1995','10', 6, 6);
INSERT IGNORE INTO tours VALUES (9, 'asia', 'shopping vacation','false','1999','10', 5, 2);
INSERT IGNORE INTO tours VALUES (10, 'asia', 'cheep vacation','false','1997','10', 2, 3);
INSERT IGNORE INTO tours VALUES (11, 'europe','cheep vacation','false', '2000','10', 5, 7);
INSERT IGNORE INTO tours VALUES (12, 'australia', 'memorable vacation','false','2000','10', 2, 8);
INSERT IGNORE INTO tours VALUES (13, 'australia', 'memorable vacation','false','2002','10', 1, 9);

INSERT IGNORE INTO tourorder VALUES (1,  '2010',  '20', 1);
INSERT IGNORE INTO tourorder VALUES (2,  '2011',  '20', 2);
INSERT IGNORE INTO tourorder VALUES (3,  '2009',  '20', 3);
INSERT IGNORE INTO tourorder VALUES (4,  '2008',  '20', 4);
INSERT IGNORE INTO tourorder VALUES (5,  '2010',  '20', 5);
INSERT IGNORE INTO tourorder VALUES (6,  '2011',  '20', 6);
INSERT IGNORE INTO tourorder VALUES (7,  '2009',  '20', 7);
INSERT IGNORE INTO tourorder VALUES (8,  '2008',  '20', 8);
INSERT IGNORE INTO tourorder VALUES (9,  '2008',  '20', 9);