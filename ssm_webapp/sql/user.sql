INSERT INTO `user`(`userName`, `password`, `age`, `reg_time`) VALUES ('张三', '123', 22, '2019-06-04 00:38:32');
INSERT INTO `user`(`userName`, `password`, `age`, `reg_time`) VALUES ('李四', '123', 23, '2019-06-01 00:39:06');
INSERT INTO `user`(`userName`, `password`, `age`, `reg_time`) VALUES ('王五', '123', 25, '2019-05-28 00:39:36');

CREATE TABLE `user` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `age` int(10) NOT NULL,
  `reg_time` timestamp NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
