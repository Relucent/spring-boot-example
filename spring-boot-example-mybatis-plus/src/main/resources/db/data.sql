DELETE FROM hello;
INSERT INTO hello (id, name, value, deleted, created_at, updated_at) VALUES (1, 'java',   'sun',       0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hello (id, name, value, deleted, created_at, updated_at) VALUES (2, 'C#',     'microsoft', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hello (id, name, value, deleted, created_at, updated_at) VALUES (3, 'golang', 'google',    0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);