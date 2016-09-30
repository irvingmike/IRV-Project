CREATE TABLE `Choices` (
  `choice-id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`choice-id`)
);

CREATE TABLE `SAMPLE`.`Votes` (
  `vote-id` INT NOT NULL AUTO_INCREMENT,
  `rank` INT NOT NULL,
  `vote-cast` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`vote-id`)
);

CREATE TABLE `SAMPLE`.`Voters` (
  `voter-id` INT NOT NULL AUTO_INCREMENT,
  `first-name` VARCHAR(45) NULL,
  `last-name` VARCHAR(100) NULL,
  `email` VARCHAR(254) NOT NULL,
  PRIMARY KEY (`voter-id`)
);
