alter table user drop column role;
alter table user drop column enabled;
ALTER TABLE user CHANGE COLUMN user_id id INT NOT NULL;
alter table user add column created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;