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
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `enabled` TINYINT NULL DEFAULT NULL,
  `role` VARCHAR(45) NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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
  `name` VARCHAR(500) NOT NULL,
  `description` TEXT NOT NULL,
  `ingredient_description` TEXT NOT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `recipe_image` VARCHAR(500) NULL,
  `user_id` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_recipe_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_recipe_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `recipe_ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe_ingredient` ;

CREATE TABLE IF NOT EXISTS `recipe_ingredient` (
  `ingredient_id` INT NOT NULL,
  `recipe_id` INT NOT NULL,
  INDEX `fk_recipe_ingredient_recipe1_idx` (`recipe_id` ASC),
  PRIMARY KEY (`ingredient_id`, `recipe_id`),
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
  `user_id` INT NOT NULL,
  `ingredient_id` INT NOT NULL,
  INDEX `fk_user_ingredient_ingredient1_idx` (`ingredient_id` ASC),
  PRIMARY KEY (`user_id`, `ingredient_id`),
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


-- -----------------------------------------------------
-- Table `user_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_comment` ;

CREATE TABLE IF NOT EXISTS `user_comment` (
  `recipe_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `comment` TEXT NULL,
  PRIMARY KEY (`recipe_id`, `user_id`),
  INDEX `fk_recipe_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_recipe_has_user_recipe1_idx` (`recipe_id` ASC),
  CONSTRAINT `fk_recipe_has_user_recipe1`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `recipe_impression`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe_impression` ;

CREATE TABLE IF NOT EXISTS `recipe_impression` (
  `recipe_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`recipe_id`, `user_id`),
  INDEX `fk_recipe_has_user_user2_idx` (`user_id` ASC),
  INDEX `fk_recipe_has_user_recipe2_idx` (`recipe_id` ASC),
  CONSTRAINT `fk_recipe_has_user_recipe2`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_has_user_user2`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
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
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `created_at`, `updated_at`) VALUES (1, 'admin', 'admin', 1, 'admin', NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `created_at`, `updated_at`) VALUES (2, 'armando', 'armando', 1, 'user', NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `created_at`, `updated_at`) VALUES (3, 'daniel', 'daniel', 1, 'user', NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `created_at`, `updated_at`) VALUES (4, 'jesse', 'jesse', 1, 'user', NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `created_at`, `updated_at`) VALUES (5, 'blake', 'blake', 1, 'user', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `ingredient`
-- -----------------------------------------------------
START TRANSACTION;
USE `reciperecommenderdb`;
INSERT INTO `ingredient` (`id`, `name`) VALUES (1, 'test ingredient');
INSERT INTO `ingredient` (`id`, `name`) VALUES (2, 'test ingredient 2');

COMMIT;


-- -----------------------------------------------------
-- Data for table `recipe`
-- -----------------------------------------------------
START TRANSACTION;
USE `reciperecommenderdb`;
INSERT INTO `recipe` (`id`, `name`, `description`, `ingredient_description`, `created_at`, `updated_at`, `recipe_image`, `user_id`) VALUES (1, 'test recipe name', 'description 1', 'ingredient description 1', NULL, NULL, NULL, DEFAULT);
INSERT INTO `recipe` (`id`, `name`, `description`, `ingredient_description`, `created_at`, `updated_at`, `recipe_image`, `user_id`) VALUES (2, 'test recipe name 2', 'description 2', 'ingredient description 2', NULL, NULL, NULL, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `recipe_ingredient`
-- -----------------------------------------------------
START TRANSACTION;
USE `reciperecommenderdb`;
INSERT INTO `recipe_ingredient` (`ingredient_id`, `recipe_id`) VALUES (1, 1);
INSERT INTO `recipe_ingredient` (`ingredient_id`, `recipe_id`) VALUES (2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_ingredient`
-- -----------------------------------------------------
START TRANSACTION;
USE `reciperecommenderdb`;
INSERT INTO `user_ingredient` (`user_id`, `ingredient_id`) VALUES (2, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `reciperecommenderdb`;
INSERT INTO `user_comment` (`recipe_id`, `user_id`, `comment`) VALUES (1, 1, 'This stuff sucks!');

COMMIT;


-- -----------------------------------------------------
-- Data for table `recipe_impression`
-- -----------------------------------------------------
START TRANSACTION;
USE `reciperecommenderdb`;
INSERT INTO `recipe_impression` (`recipe_id`, `user_id`) VALUES (1, 1);
INSERT INTO `recipe_impression` (`recipe_id`, `user_id`) VALUES (1, 2);

COMMIT;

