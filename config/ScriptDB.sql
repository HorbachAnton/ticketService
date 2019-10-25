-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ticketService
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ticketService
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ticketService` DEFAULT CHARACTER SET utf8 ;
USE `ticketService` ;

-- -----------------------------------------------------
-- Table `ticketService`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketService`.`Role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ticketService`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketService`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `Role_id` INT NOT NULL,
  `iconPath` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_User_Role_idx` (`Role_id` ASC),
  CONSTRAINT `fk_User_Role`
    FOREIGN KEY (`Role_id`)
    REFERENCES `ticketService`.`Role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ticketService`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketService`.`Event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titleEvent` VARCHAR(45) NOT NULL,
  `summary` VARCHAR(400) NOT NULL,
  `date` DATETIME NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `price` INT NULL,
  `iconPath` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ticketService`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketService`.`Ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Event_id` INT NOT NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Ticket_Event1_idx` (`Event_id` ASC),
  INDEX `fk_Ticket_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_Ticket_Event1`
    FOREIGN KEY (`Event_id`)
    REFERENCES `ticketService`.`Event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ticket_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ticketService`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ticketService`.`Comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketService`.`Comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `User_id` INT NOT NULL,
  `Event_id` INT NOT NULL,
  `comment` VARCHAR(400) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Comment_User1_idx` (`User_id` ASC),
  INDEX `fk_Comment_Event1_idx` (`Event_id` ASC),
  CONSTRAINT `fk_Comment_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ticketService`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_Event1`
    FOREIGN KEY (`Event_id`)
    REFERENCES `ticketService`.`Event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
