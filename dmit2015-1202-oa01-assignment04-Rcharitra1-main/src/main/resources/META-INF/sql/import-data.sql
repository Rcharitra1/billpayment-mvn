INSERT INTO BILL(username, payeename, duedate, amountdue, amountbalance, created, lastmodified, version) VALUES ('larry@3stooges.com', 'Some Payee', '2021-12-12',300, 200, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT INTO BILL(username, payeename, duedate, amountdue, amountbalance, created, lastmodified, version) VALUES ('curly@3stooges.com', 'Some Payee3', '2021-12-12',200, 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);








-- CREATE TABLE CallerUser (
--                             username VARCHAR(32) NOT NULL,
--                             password VARCHAR(255) NOT NULL,
--                             PRIMARY KEY (username)
-- );
-- CREATE TABLE CallerGroup(
--                             username VARCHAR(32),
--                             groupname VARCHAR(32),
--                             PRIMARY KEY (username, groupname),
--                             FOREIGN KEY (username) REFERENCES CallerUser(username)
-- );