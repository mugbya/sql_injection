

CREATE TABLE `user` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

INSERT INTO `user` (`username`, `password`) VALUES ('mugbya', 'mugbya');

