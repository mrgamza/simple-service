ALTER TABLE `user` ADD COLUMN `role` VARCHAR(20) NOT NULL;
ALTER TABLE `user` ADD COLUMN `created_at` TIMESTAMP NOT NULL
    DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE `user` ADD COLUMN `updated_at` TIMESTAMP NOT NULL
    DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP;