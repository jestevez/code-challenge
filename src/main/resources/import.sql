INSERT INTO accounts (instrument_number, balance) VALUES('ES9800035314907032954976', 9980.00);
INSERT INTO accounts (instrument_number, balance) VALUES('ES8030187592819840053937', 23891.99);
INSERT INTO accounts (instrument_number, balance) VALUES('ES2131348352335125364892', 99979.00);
INSERT INTO accounts (instrument_number, balance) VALUES('ES6120374915613565136989', 9980.00);
INSERT INTO accounts (instrument_number, balance) VALUES('ES9820385778983000760236', 9980.00);

INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000001', 'ES9800035314907032954976', NOW(), 10000.00, 10000.00, 0, 'First deposit', 'CREDIT', 'ENDING', NOW(), 'CLIENT');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000002', 'ES8030187592819840053937', NOW(), 23911.99, 23911.99, 0, 'First deposit', 'CREDIT', 'ENDING', NOW(), 'CLIENT');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000003', 'ES2131348352335125364892', NOW(), 99999.00, 99999.00, 0, 'First deposit', 'CREDIT', 'ENDING', NOW(), 'CLIENT');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000004', 'ES6120374915613565136989', NOW(), 10000.00, 10000.00, 0, 'First deposit', 'CREDIT', 'ENDING', NOW(), 'CLIENT');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000005', 'ES9820385778983000760236', NOW(), 10000.00, 10000.00, 0, 'First deposit', 'CREDIT', 'ENDING', NOW(), 'CLIENT');

INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000006', 'ES9800035314907032954976', NOW(), 10.00, 10.00, 0, 'Maintenance fee', 'DEBIT', 'ENDING', NOW(), 'INTERNAL');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000007', 'ES8030187592819840053937', NOW(), 10.00, 10.00, 0, 'Maintenance fee', 'DEBIT', 'ENDING', NOW(), 'INTERNAL');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000008', 'ES2131348352335125364892', NOW(), 10.00, 10.00, 0, 'Maintenance fee', 'DEBIT', 'ENDING', NOW(), 'INTERNAL');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000009', 'ES6120374915613565136989', NOW(), 10.00, 10.00, 0, 'Maintenance fee', 'DEBIT', 'ENDING', NOW(), 'INTERNAL');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000010', 'ES9820385778983000760236', NOW(), 10.00, 10.00, 0, 'Maintenance fee', 'DEBIT', 'ENDING', NOW(), 'INTERNAL');

INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000011', 'ES9800035314907032954976', NOW(), 10.00, 10.00, 0, 'ATM withdrawal', 'DEBIT', 'ENDING', NOW(), 'ATM');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000012', 'ES8030187592819840053937', NOW(), 10.00, 10.00, 0, 'ATM withdrawal', 'DEBIT', 'ENDING', NOW(), 'ATM');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000013', 'ES2131348352335125364892', NOW(), 10.00, 10.00, 0, 'ATM withdrawal', 'DEBIT', 'ENDING', NOW(), 'ATM');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000014', 'ES6120374915613565136989', NOW(), 10.00, 10.00, 0, 'ATM withdrawal', 'DEBIT', 'ENDING', NOW(), 'ATM');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000015', 'ES9820385778983000760236', NOW(), 10.00, 10.00, 0, 'ATM withdrawal', 'DEBIT', 'ENDING', NOW(), 'ATM');

INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000016', 'ES9800035314907032954976', NOW(), 10.00, 10.00, 0, '', 'CREDIT', 'SETTLED', NOW(), 'CLIENT');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000017', 'ES9800035314907032954976', NOW(), 10.00, 10.00, 0, '', 'CREDIT', 'SETTLED', NOW(), 'INTERNAL');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000018', 'ES9800035314907032954976', NOW(), 10.00, 10.00, 0, '', 'CREDIT', 'PENDING', NOW(), 'CLIENT');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000019', 'ES9800035314907032954976', NOW(), 10.00, 10.00, 0, '', 'CREDIT', 'PENDING', NOW(), 'INTERNAL');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000020', 'ES9800035314907032954976', NOW(), 10.00, 10.00, 0, '', 'CREDIT', 'FUTURE', NOW(), 'CLIENT');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000021', 'ES9800035314907032954976', NOW(), 10.00, 10.00, 0, '', 'CREDIT', 'PENDING', NOW(), 'ATM');
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at, channel) VALUES ('000022', 'ES9800035314907032954976', NOW(), 10.00, 10.00, 0, '', 'CREDIT', 'FUTURE', NOW(), 'INTERNAL');


