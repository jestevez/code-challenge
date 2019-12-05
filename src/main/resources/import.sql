INSERT INTO accounts (instrument_number, balance) VALUES('ES9800035314907032954976', 10000.00);
INSERT INTO accounts (instrument_number, balance) VALUES('ES8030187592819840053937', 23911.99);
INSERT INTO accounts (instrument_number, balance) VALUES('ES2131348352335125364892', 99999.00);
INSERT INTO accounts (instrument_number, balance) VALUES('ES6120374915613565136989', 10000.00);
INSERT INTO accounts (instrument_number, balance) VALUES('ES9820385778983000760236', 10000.00);


INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at) VALUES ('000001', 'ES9800035314907032954976', NOW(), 10000.00, 10000.00, 0, 'First deposit', 'CREDIT', 'ENDING', NOW());
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at) VALUES ('000002', 'ES8030187592819840053937', NOW(), 23911.99, 23911.99, 0, 'First deposit', 'CREDIT', 'ENDING', NOW());
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at) VALUES ('000003', 'ES2131348352335125364892', NOW(), 99999.00, 99999.00, 0, 'First deposit', 'CREDIT', 'ENDING', NOW());
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at) VALUES ('000004', 'ES6120374915613565136989', NOW(), 10000.00, 10000.00, 0, 'First deposit', 'CREDIT', 'ENDING', NOW());
INSERT INTO transactions (reference, account_iban, tx_date, amount, base_amount, fee, description, movement_type, transaction_status, create_at) VALUES ('000005', 'ES9820385778983000760236', NOW(), 10000.00, 10000.00, 0, 'First deposit', 'CREDIT', 'ENDING', NOW());
