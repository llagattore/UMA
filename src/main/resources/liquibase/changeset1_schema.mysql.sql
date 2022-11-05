--liquibase formatted sql

--changeset llagator:1
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
-- Schema uma_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `uma_db` DEFAULT CHARACTER SET utf8mb3 ;
USE `uma_db` ;

-- -----------------------------------------------------
-- Table `uma_db`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uma_db`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `code` CHAR(3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `uma_db`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uma_db`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `country_id_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cities_country_id`
    FOREIGN KEY (`country_id`)
    REFERENCES `uma_db`.`country` (`id`)
    ON DELETE SET NULL)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `uma_db`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uma_db`.`company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `uma_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uma_db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `date_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` BIT(1) NULL DEFAULT b'1',
  `company_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `company_id_idx` (`company_id` ASC) VISIBLE,
  CONSTRAINT `fk_Users_company_id`
    FOREIGN KEY (`company_id`)
    REFERENCES `uma_db`.`company` (`id`)
    ON DELETE SET NULL)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `uma_db`.`user_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uma_db`.`user_details` (
  `user_id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `date_of_birth` DATE NULL DEFAULT NULL,
  `sex` CHAR(1) NULL DEFAULT 'u',
  `city_of_birth` INT NULL DEFAULT NULL,
  `country_of_birth` INT NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `city_of_birth_idx` (`city_of_birth` ASC) VISIBLE,
  INDEX `country_of_birth_idx` (`country_of_birth` ASC) VISIBLE,
  CONSTRAINT `fk_Users_details_city_of_birth`
    FOREIGN KEY (`city_of_birth`)
    REFERENCES `uma_db`.`city` (`id`)
    ON DELETE SET NULL,
  CONSTRAINT `fk_Users_details_country_of_birth`
    FOREIGN KEY (`country_of_birth`)
    REFERENCES `uma_db`.`country` (`id`)
    ON DELETE SET NULL,
  CONSTRAINT `fk_Users_deteils_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `uma_db`.`user` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;