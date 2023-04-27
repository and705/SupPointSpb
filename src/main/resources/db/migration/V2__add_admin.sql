
INSERT INTO  users (id, archive, comment, email, name, password, phone_number, role, tg_id, tg_name, bucket_id)
VALUES (1, false, 'admin', 'mail@mail.ru', 'admin', 'pass', '0000000000', 'ADMIN', '0', '0', null);

ALTER TABLE user_seq AUTO_INCREMENT = 2;