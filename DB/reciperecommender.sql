-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema reciperecommenderdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `reciperecommenderdb` ;

-- -----------------------------------------------------
-- Schema reciperecommenderdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `reciperecommenderdb` DEFAULT CHARACTER SET utf8 ;
USE `reciperecommenderdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `enabled` TINYINT(4) NULL DEFAULT NULL,
  `role` VARCHAR(45) NULL DEFAULT NULL,
  `createdat` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedat` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingredient` ;

CREATE TABLE IF NOT EXISTS `ingredient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `recipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe` ;

CREATE TABLE IF NOT EXISTS `recipe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT(255) NOT NULL,
  `ingredient_description` TEXT(255) NOT NULL,
  `createdat` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedat` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `recipe_ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe_ingredient` ;

CREATE TABLE IF NOT EXISTS `recipe_ingredient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ingredient_id` INT NOT NULL,
  `recipe_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_recipe_ingredient_recipe1_idx` (`recipe_id` ASC),
  CONSTRAINT `fk_recipe_ingredient_ingredient`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `ingredient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_ingredient_recipe1`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_ingredient` ;

CREATE TABLE IF NOT EXISTS `user_ingredient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `ingredient_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_ingredient_ingredient1_idx` (`ingredient_id` ASC),
  CONSTRAINT `fk_user_ingredient_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_ingredient_ingredient1`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `ingredient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `reciperecommenderdb`;
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `createdat`, `updatedat`) VALUES (1, 'billybob', 'password', 1, 'user', NULL, NULL);

COMMIT;

