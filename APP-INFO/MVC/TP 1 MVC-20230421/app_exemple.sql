CREATE DATABASE IF NOT EXISTS `app_exemple` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `app_exemple`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL
);


ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;