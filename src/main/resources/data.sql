insert into users (user, pwd) values('anzadmin', '$2a$12$Gc.mYi5t7vAcaA4GnTryWubu2O6XJGnmGbvOhe.vy6GaKs9/3fNNG');

insert into Account(account_number,account_name,account_type,balance,balance_date,currency,user_id) values(585309209,'SGSaving726','Savings',84327.51,to_date('08/11/2018','DD/MM/YYYY'),'SGD','AU2344');
insert into Account(account_number,account_name,account_type,balance,balance_date,currency,user_id) values(791066619,'AUSaving933','Savings',88005.93,to_date('08/11/2018','DD/MM/YYYY'),'AUD','AU2367');
insert into Account(account_number,account_name,account_type,balance,balance_date,currency,user_id) values(321143048,'SGCurrent855','Current',38010.62,to_date('08/11/2018','DD/MM/YYYY'),'SGD','AU2344');
insert into Account(account_number,account_name,account_type,balance,balance_date,currency,user_id) values(347786244,'AUSaving726','Current',50664.65,to_date('08/11/2018','DD/MM/YYYY'),'AUD','AU2367');
insert into Account(account_number,account_name,account_type,balance,balance_date,currency,user_id) values(680168213,'AUCurrent569','Current',41327.28,to_date('08/11/2018','DD/MM/YYYY'),'AUD','AU2344');
insert into Account(account_number,account_name,account_type,balance,balance_date,currency,user_id) values(136056165,'AUSaving111','Savings',48928.79,to_date('08/11/2018','DD/MM/YYYY'),'AUD','AU2344');
insert into Account(account_number,account_name,account_type,balance,balance_date,currency,user_id) values(453963528,'SGSaving111','Savings',72117.53,to_date('08/11/2018','DD/MM/YYYY'),'SGD','AU2355');
insert into Account(account_number,account_name,account_type,balance,balance_date,currency,user_id) values(334666982,'AUSaving111','Savings',20588.16,to_date('08/11/2018','DD/MM/YYYY'),'AUD','AU2355');
insert into Account(account_number,account_name,account_type,balance,balance_date,currency,user_id) values(793949180,'AUSaving111','Current',88794.48,to_date('08/11/2018','DD/MM/YYYY'),'AUD','AU2344');
insert into Account(account_number,account_name,account_type,balance,balance_date,currency,user_id) values(768759901,'SGSaving111','Current',5906.55,to_date('08/11/2018','DD/MM/YYYY'),'SGD','AU2399');
insert into Account(account_number,account_name,account_type,balance,balance_date,currency,user_id) values(847257972,'AUSaving111','Current',92561.68,to_date('08/11/2018','DD/MM/YYYY'),'AUD','AU2399');



insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9540.98','SGD',0,'Interest Received','12/01/2012','credit',585309209,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7497.82','SGD',0,'Interest Received','12/01/2012','credit',585309209,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('5564.79','SGD',0,'Interest Received','12/01/2012','credit',585309209,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('8136.18','SGD',0,'Interest Received','12/01/2012','credit',585309209,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9442.46','SGD',0,'Interest Received','12/01/2012','credit',585309209,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7614.45','SGD',0,'Interest Received','12/01/2012','credit',585309209,'Savings Account');

insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9852.98','AUD',0,'Interest Received','12/01/2012','credit',791066619,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7897.82','AUD',0,'Interest Received','12/01/2012','credit',791066619,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('1164.79','AUD',0,'Interest Received','12/01/2012','credit',791066619,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('8000.18','AUD',0,'Interest Received','12/01/2012','credit',791066619,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('6555.46','AUD',0,'Interest Received','12/01/2012','credit',791066619,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('3000.45','AUD',0,'Interest Received','12/01/2012','credit',791066619,'Savings Account');

insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9540.98','SGD',0,'Interest Received','12/01/2012','credit',321143048,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7497.82','SGD',0,'Interest Received','12/01/2012','credit',321143048,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('5564.79','SGD',0,'Interest Received','12/01/2012','credit',321143048,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('8136.18','SGD',0,'Interest Received','12/01/2012','credit',321143048,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9442.46','SGD',0,'Interest Received','12/01/2012','credit',321143048,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7614.45','SGD',0,'Interest Received','12/01/2012','credit',321143048,'Current Account');

insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9540.98','AUD',0,'Interest Received','12/01/2012','credit',347786244,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7497.82','AUD',0,'Interest Received','12/01/2012','credit',347786244,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('5564.79','AUD',0,'Interest Received','12/01/2012','credit',347786244,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('8136.18','AUD',0,'Interest Received','12/01/2012','credit',347786244,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9442.46','AUD',0,'Interest Received','12/01/2012','credit',347786244,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7614.45','AUD',0,'Interest Received','12/01/2012','credit',347786244,'Current Account');

insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9540.98','AUD',0,'Interest Received','12/01/2012','credit',680168213,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7497.82','AUD',0,'Interest Received','12/01/2012','credit',680168213,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('5564.79','AUD',0,'Interest Received','12/01/2012','credit',680168213,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('8136.18','AUD',0,'Interest Received','12/01/2012','credit',680168213,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9442.46','AUD',0,'Interest Received','12/01/2012','credit',680168213,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7614.45','AUD',0,'Interest Received','12/01/2012','credit',680168213,'Current Account');

insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9540.98','AUD',0,'Interest Received','12/01/2012','credit',136056165,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7497.82','AUD',0,'Interest Received','12/01/2012','credit',136056165,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('5564.79','AUD',0,'Interest Received','12/01/2012','credit',136056165,'Savings Account');


insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('8136.18','SGD',0,'Interest Received','12/01/2012','credit',453963528,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9442.46','SGD',0,'Interest Received','12/01/2012','credit',453963528,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7614.45','SGD',0,'Interest Received','12/01/2012','credit',453963528,'Savings Account');


insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9540.98','AUD',0,'Interest Received','12/01/2012','credit',334666982,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7497.82','AUD',0,'Interest Received','12/01/2012','credit',334666982,'Savings Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('5564.79','AUD',0,'Interest Received','12/01/2012','credit',334666982,'Savings Account');


insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9540.98','AUD',0,'Interest Received','12/01/2012','credit',793949180,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7497.82','AUD',0,'Interest Received','12/01/2012','credit',793949180,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('5564.79','AUD',0,'Interest Received','12/01/2012','credit',793949180,'Current Account');


insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9540.98','SGD',0,'Interest Received','12/01/2012','credit',768759901,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7497.82','SGD',0,'Interest Received','12/01/2012','credit',768759901,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('5564.79','SGD',0,'Interest Received','12/01/2012','credit',768759901,'Current Account');

insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('9540.98','AUD',0,'Interest Received','12/01/2012','credit',847257972,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('7497.82','AUD',0,'Interest Received','12/01/2012','credit',847257972,'Current Account');
insert into transaction(credit_amount , currency, debit_amount , description , transaction_date , type , account_account_number,account_name) values ('5564.79','AUD',0,'Interest Received','12/01/2012','credit',847257972,'Current Account');