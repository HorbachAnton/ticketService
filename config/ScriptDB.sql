-- -----------------------------------------------------
-- Schema ticketService
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ticketservice`;
CREATE SCHEMA IF NOT EXISTS `ticketservice` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ticketservice` ;

-- -----------------------------------------------------
-- Table `ticketservice`.`Location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketservice`.`Location` (
`id` INT NOT NULL,
`title` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `id` (`id` ASC, `title` ASC) VISIBLE,
UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `ticketService`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketservice`.`Role` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `id` (`id` ASC, `name` ASC) VISIBLE,
UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ticketService`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketservice`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(70) NOT NULL,
  `enabled` TINYINT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `surname` VARCHAR(45) NULL DEFAULT NULL,
  `Role_id` INT NOT NULL,
  `iconPath` VARCHAR(220) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id` (`id` ASC, `email` ASC) VISIBLE,
  INDEX `fk_User_Role_idx` (`Role_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `fk_User_Role`
    FOREIGN KEY (`Role_id`)
    REFERENCES `ticketservice`.`role` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ticketService`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketservice`.`Event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `summary` VARCHAR(400) NOT NULL,
  `date` DATETIME NOT NULL,
  `Location_id` INT NOT NULL,
  `price` INT NULL DEFAULT NULL,
  `iconPath` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id` (`id` ASC) VISIBLE,
  INDEX `fk_event_Location1_idx` (`Location_id` ASC) VISIBLE,
  CONSTRAINT `fk_event_Location1`
    FOREIGN KEY (`Location_id`)
    REFERENCES `ticketservice`.`Location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ticketService`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketservice`.`Ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Event_id` INT NOT NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id` (`id` ASC) VISIBLE,
  INDEX `fk_Ticket_Event1_idx` (`Event_id` ASC) VISIBLE,
  INDEX `fk_Ticket_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_Ticket_Event1`
    FOREIGN KEY (`Event_id`)
    REFERENCES `ticketservice`.`event` (`id`),
  CONSTRAINT `fk_Ticket_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ticketservice`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ticketService`.`Comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketservice`.`Comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `User_id` INT NOT NULL,
  `Event_id` INT NOT NULL,
  `text` VARCHAR(400) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id` (`id` ASC) VISIBLE,
  INDEX `fk_Comment_User1_idx` (`User_id` ASC) VISIBLE,
  INDEX `fk_Comment_Event1_idx` (`Event_id` ASC) VISIBLE,
  CONSTRAINT `fk_Comment_Event1`
    FOREIGN KEY (`Event_id`)
    REFERENCES `ticketservice`.`event` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_Comment_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ticketservice`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `ticketservice`.`role` (`id`, `name`) VALUES ('1', 'CONSUMER');
INSERT INTO `ticketservice`.`role` (`id`, `name`) VALUES ('2', 'ADMINISTRATOR');

INSERT INTO `ticketservice`.`user` (`id`, `email`, `password`, `enabled`, `name`, `surname`, `Role_id`, `iconPath`) VALUES ('1', 'dmitri@yandex.by', '$2a$12$YRvw/MMuK.tXvOBPbTm7NOHV5BLXFFq7vUQ5/VDqPlR6lJpUvXjSK', '1', 'Dmitri', 'Fedorovich', '1', null);
INSERT INTO `ticketservice`.`user` (`id`, `email`, `password`, `enabled`, `name`, `surname`, `Role_id`, `iconPath`) VALUES ('2', 'vadim@mail.ru', '$2a$12$YRvw/MMuK.tXvOBPbTm7NOHV5BLXFFq7vUQ5/VDqPlR6lJpUvXjSK', '1', 'Vadim', 'Dmitrievich', '2', null);

INSERT INTO `ticketservice`.`location` (`id`, `title`) VALUES ('1', 'Магнит');
INSERT INTO `ticketservice`.`location` (`id`, `title`) VALUES ('2', 'ТЦ ПЛАЗА');
INSERT INTO `ticketservice`.`location` (`id`, `title`) VALUES ('3', 'Большая опера');
INSERT INTO `ticketservice`.`location` (`id`, `title`) VALUES ('4', 'Кинотеатр');

INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('1', 'Хеллоуин', 'Тест', '2019-10-12 14:32:44', '1', '245', 'resources/img/halloween.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('2', 'Фестиваль', 'Тест', '2021-11-20 20:12:40', '2', '344', 'resources/img/festival.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('3', 'Опера', 'Тест', '2018-12-14 17:34:40', '3', '421', 'resources/img/opera.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('4', 'Фильм', 'Тест', '2020-08-03 15:28:17', '4', '297', 'resources/img/film.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('5', 'Фильм2', 'Тест', '2024-01-22 13:18:43', '2', '532', 'resources/img/rec.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('6', 'Фильм3', 'Тест', '2005-09-15 13:18:43', '1', '282', 'resources/img/fig.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('7', 'Фильм4', 'Тест', '2008-02-12 17:48:21', '4', '344', 'resources/img/kek.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('8', 'Фильм5', 'Тест', '1999-03-07 01:54:23', '2', '482', 'resources/img/pig.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('9', 'Фильм6', 'Тест', '2021-09-15 13:18:43', '3', '429', 'resources/img/kig.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('10', 'Фильм7', 'Тест', '2018-04-11 03:58:11', '2', '134', 'resources/img/mig.png');

INSERT INTO `ticketservice`.`ticket` (`id`, `Event_id`, `User_id`) VALUES ('1', '1', '1');

INSERT INTO `ticketservice`.`comment` (`id`, `User_id`, `Event_id`, `text`) VALUES ('1', '1', '1', 'Тест');




