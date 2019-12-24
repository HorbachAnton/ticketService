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
`id` INT NOT NULL AUTO_INCREMENT,
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
  `summary` VARCHAR(600) NOT NULL,
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
    ON DELETE cascade
    ON UPDATE cascade)
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
    REFERENCES `ticketservice`.`event` (`id`)
    on delete cascade
    on update cascade,
  CONSTRAINT `fk_Ticket_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ticketservice`.`user` (`id`)
    on delete cascade
    on update cascade)
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

INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('1', 'Джокер', 'Готэм, начало 1980-х годов. Комик Артур Флек живет с больной матерью, которая с детства учит его «ходить с улыбкой». Пытаясь нести в мир хорошее и дарить людям радость, Артур сталкивается с человеческой жестокостью и постепенно приходит к выводу, что этот мир получит от него не добрую улыбку, а ухмылку злодея Джокера.', '2019-10-12 14:32:44', '1', '245', 'resources/img/joker.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('2', 'Таксист', 'Ветеран вьетнамской войны Трэйвис Бикл ведет свое одинокое такси по ночным улицам бесконечного города, и перед ним разворачивается мрачная панорама человеческих грехов. Как ветхозаветный пророк, он надеется, что однажды небеса пошлют на землю спасительный дождь, который очистит Нью-Йорк от вековой грязи.', '2021-11-20 20:12:40', '2', '344', 'resources/img/taxi_driver.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('3', 'С меня хватит!', 'Неудачи преследуют Уильяма всю жизнь. Особенно этим жарким летом. На работе его отправили в бессрочный отпуск. Решением суда ему запрещено встречаться с дочкой. Обозлившись на весь мир, Уильям решается на месть. Круша все на своем пути, он пробивается сквозь раскаленный город на день рождения к своей дочке. Люди воспринимают его как маньяка, и только опытный детектив Прендергаст знает, в чем причина агрессии Уильяма.', '2018-12-14 17:34:40', '3', '421', 'resources/img/falling_down.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('4', 'Опера:"Седая легенда"', 'Во время охоты в честь свадьбы нобилей Кизгайло и Любки на лесной поляне собираются крепостные девушки Кизгайлы. Среди них – Ирина, в которую без памяти влюблен друг жениха, нобиль Роман. Воспользовавшись случаем, он просит Кизгайлу отдать ему Ирину, чтобы жениться – ведь без нее Роману нет жизни. Кизгайло ошеломлен – как родовитый шляхтич, нобиль, может совершить такое святотатство и повести в храм крепостную? Но уговоры Романа так настойчивы, что Кизгайло дает согласие.', '2020-08-03 15:28:17', '4', '297', 'resources/img/grey_legend.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('5', 'Ледовое шоу Александра Жулина', 'Можно ли представить более сказочное время, чем новогодние праздники? Именно в новый год как никогда хочется верить в волшебство. В это время присутствие сказки чувствуется во всем – в украшенных витринах магазинов, разноцветных елочных игрушках и фонариках, счастливых улыбках людей. Новый год, пожалуй, самое подходящее время, чтобы стать волшебником и сделать из своей жизни сказку.Новогодние праздники – загадочное время, ведь никто не знает, что принесет наступивший год.', '2024-01-22 13:18:43', '2', '532', 'resources/img/ice_show_alexander_zhulin.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('6', 'Трибьют "Король и шут"', 'Приглашаем всех и каждого насладится любимыми песнями, зарядиться энергетикой, прочувствовать драйв и просто круто оторваться. Обещаем, будет жарко как никогда!!! ', '2005-09-15 13:18:43', '1', '282', 'resources/img/king_and_clown.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('7', 'Пабло Пикассо. Параграфы ', 'Пикассо. Самое громкое имя в искусстве XX века. Неистовый гений, создавший десятки тысяч произведений, величайший новатор современности и неисправимый донжуан. Он прожил долгую жизнь и оставил колоссальное наследие, ставшее эталоном авангардного искусства и авторитетнейшим пособием для потомков. Избранные параграфы этого наполненного страстями и сомнениями учения мы объединили в уникальную коллекцию из 61 литографии, полученной из частных коллекций Германии, Бельгии и Франции.', '2008-02-12 17:48:21', '4', '344', 'resources/img/paragraphs_pablo_picasso.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('8', 'Звездные Войны: Скайуокер. Восход', 'Фильм завершает невероятную историю семьи Скайуокеров, длящуюся уже более сорока лет, и обещает дать ответы на все загадки из предыдущих серий. Зрителя ожидают старые и новые герои, уникальные миры, увлекательные путешествия на край Галактики и грандиозный финал фантастической саги.', '1999-03-07 01:54:23', '2', '482', 'resources/img/star_wars_the_rise_of_skywalker.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('9', 'Разговор с комиками', 'Разговор с комиками - это что-то вроде подкаста, в присутствии зрителей. Мы садимся на сцену, берём какие-то темы и новости и обсуждаем их в течении всего вечера, как самостоятельно, так и со зрителями. Точно интересно, возможно смешно!', '2021-09-15 13:18:43', '3', '429', 'resources/img/conversation_with_comedians.png');
INSERT INTO `ticketservice`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`, `iconPath`) VALUES ('10', 'Стендап в Кубе ', 'СТЕНДАП В КУБЕ - это свежая стендап-комедия от комиков со всей Беларуси, как опытных, так и новичков в этом деле. Может выступить любой желающий! У каждого есть 5-7 минут на сцене, чтобы рассмешить Вас. Нету никаких ограничений! Комик борется за ваш смех и аплодисменты, кайфуют все!', '2018-04-11 03:58:11', '2', '134', 'resources/img/standup_in_Cuba.png');

INSERT INTO `ticketservice`.`ticket` (`id`, `Event_id`, `User_id`) VALUES ('1', '1', '1');





