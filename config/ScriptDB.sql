-- -----------------------------------------------------
-- Schema ticketService
-- -----------------------------------------------------
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
  `password` VARCHAR(20) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `surname` VARCHAR(45) NULL DEFAULT NULL,
  `Role_id` INT NOT NULL,
  `iconPath` VARCHAR(100) NULL DEFAULT NULL,
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
  `comment` VARCHAR(400) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id` (`id` ASC) VISIBLE,
  INDEX `fk_Comment_User1_idx` (`User_id` ASC) VISIBLE,
  INDEX `fk_Comment_Event1_idx` (`Event_id` ASC) VISIBLE,
  CONSTRAINT `fk_Comment_Event1`
    FOREIGN KEY (`Event_id`)
    REFERENCES `ticketservice`.`event` (`id`),
  CONSTRAINT `fk_Comment_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ticketservice`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
