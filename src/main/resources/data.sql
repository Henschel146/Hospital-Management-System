-- Insert Roles
INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('RECEPTIONIST');
INSERT INTO role (name) VALUES ('DOCTOR');

-- Insert User with Role Admin
INSERT INTO user (created_date, date_of_birth, modified_date, phone_number, email, firstname, last_name,username, password) VALUES ('2024-02-10', '1999-02-10', '2024-02-10', '782332823', 'lunguhenschel@gmail.com', 'Henschel', 'Lungu','henschel', '$2a$10$hL0g52SllLyh1S2nvZbvHeIDiAQQqLh91DijsPWV5e7SDx3QBPDRy');

INSERT INTO user_role_mapping (ur_user_id, user_role_id)
VALUES ((SELECT user_id FROM user WHERE username = 'henschel'), (SELECT role_id FROM role WHERE name = 'ADMIN'));




